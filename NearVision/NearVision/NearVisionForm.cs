using System;
using System.Collections.Generic;
using System.Drawing;
using System.Net;
using System.Windows.Forms;
using Newtonsoft.Json;
using SimpleWebServer;
using System.Drawing.Imaging;
using System.Linq;

namespace NearVision
{
    public partial class NearVisionForm : Form
    {
        private ConfigMgr _config;
        private System.Timers.Timer _hideTimer;
        private TextHandler _textHandler;
        private Image _currentImage;
        private Dictionary<string, Image> _imageMap;
        private LogForm _logForm;

        private static readonly log4net.ILog _log = log4net.LogManager.GetLogger(System.Reflection.MethodBase.GetCurrentMethod().DeclaringType);


        public NearVisionForm()
        {

            InitializeComponent();

            log4net.Config.XmlConfigurator.Configure();
            _logForm = new LogForm();
            _logForm.Show();
            _logForm.Hide();



            _log.Info("Contructor started");
            try
            {
                _log.Info("Initializing Configuration...");
                _config = ConfigMgr.Init();
            }
            catch (NearVisionException e)
            {
                throw;
            }

            catch (Exception e)
            {
                new NearVisionException("Cannot initialize config", e);
            }

            try
            {
                InitWebServer();
            }
            catch (Exception e)
            {
                throw new NearVisionException("Cannot start http server", e);
            }

            _textHandler = new TextHandler(_config);
            _textHandler.UpdateTextBlockEvent += OnUpdateTextBlock;
            _imageMap = new Dictionary<string, Image>();

            InitGUI();
            InitMouseEvents();
            InitStartText();

            //_logForm.LogBoxInitedEvent += onLogBoxInitedEVent;
        }

        private void onLogBoxInitedEVent()
        {

        }

        private void InitGUI()
        {
            BringToFront();
            TopMost = true;

            _imageBox.SizeMode = PictureBoxSizeMode.StretchImage;
            ControlPanel.Visible = _browserBox.Visible = _imageBox.Visible =  false;
            _textHeader.Visible = _textBox.Visible = true;
            _textHeader.BringToFront();
            _hideTimer = new System.Timers.Timer();
        }

        private void InitMouseEvents()
        {
            this.MouseClick += this.OnMouseClick;
            this._imageBox.MouseClick += this.OnMouseClick;
            this._textBox.MouseClick += this.OnMouseClick;
            this._textHeader.MouseClick += this.OnMouseClick;
        }

        private void InitWebServer()
        {
            var httpPreffix = _config.General.IsSSL ? "https://" : "http://";
            _log.Info($"Initializing HTTP server with the following parameters :\r\n\t\tIP address : \t{_config.General.ServerIP}\r\n\t\tPort : \t{_config.General.Port}\r\n\t\tProtocol :\t{httpPreffix}");
            var ws = new WebServer(SendResponse, $"{httpPreffix}{_config.General.ServerIP}:{_config.General.Port}/");
            ws.Run();
        }

        private void InitStartText ()
        {
            var td = _textHandler.getCurrentTextData();
            if (td == null)
                return;

            UpdateTextBlock(td);
        }

        private void OnUpdateTextBlock(TextData textData)
        {
            if (textData == null)
                return;

            UpdateTextBlock(textData);
        }

        private void UpdateTextBlock(TextData td )
        {
            _textBox.Font = new Font(td.FontFamily, (float)td.FontSize, GraphicsUnit.Pixel);
            _textBox.Text = td.Text;
            _textHeader.Text = td.UnitText;
            _log.Info($"Setting new text : \r\n\t\t{td.Text}");
            _log.Info($"Setting header text : {td.UnitText}");

        }

        private void OnHideTimer(object sender, EventArgs e)
        {
            Invoke(new Action(() =>
            {
                ControlPanel.Visible = false;
            }));
            _hideTimer.Stop();
        }

        public string SendResponse(HttpListenerRequest request)
        {
            var allKeys = string.Join("\r\n\t\t\t\t\t\t",
            request.QueryString
                   .AllKeys
                   .Select(key => key + " : " + request.QueryString[key])
                   .ToArray());

            _log.Info("\r\n\r\n----------------------------------------------------------------------");
            _log.Info($"Received HTTP request from {request.RemoteEndPoint.Address}; Request : \r\n\t\t\t\t\t\t{allKeys}");
            var cmdName = request.QueryString.Get("cmd");
            if (cmdName == null)
            {
                _log.Error($"Field \"command\" not has been specified");
                _log.Info("----------------------------------------------------------------------\r\n");
                return string.Format($"<HTML><BODY>cmd {cmdName} is not present</BODY></HTML>");
            }


            var selectedCmd = GetSelectedCmd(cmdName);
            if (selectedCmd == null)
            {
                _log.Error($"Command {cmdName} is not valid in the current context");
                _log.Info("----------------------------------------------------------------------\r\n");
                return string.Format("<HTML><BODY>test is null</BODY></HTML>", DateTime.Now);
            }

            var res = GenerateResponse(selectedCmd);
            _log.Info($"Response string : {res}");
            Invoke((MethodInvoker)delegate {
                PerformDisplayAction(selectedCmd, res);
            });
            _log.Info("----------------------------------------------------------------------\r\n");
            return res;
        }

        private Command GetSelectedCmd(string cmdCommand)
        {
           return _config.GetCommandByName(cmdCommand);
        }

        public String GenerateResponse(Command cmd)
        {
            var msec = (long)(DateTimeOffset.Now.ToUniversalTime() - new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc)).TotalMilliseconds ;
            System.Collections.IDictionary dict = new Dictionary<string, string>
            {
                ["test"] = cmd.ID.ToString(),
                ["cmd"] = cmd.Cmd,
                ["ptime"] = msec.ToString(),
                ["lang"] = _config.CurrentLangId
            };

            switch (cmd.ID)
            {
                case 500:
                case 501:
                    break;
                case 502:
                    var td = _textHandler.getCurrentTextData();
                    dict["textOne"] = td.Text;
                    dict["ac1"] = td.UnitText;
                    break;
                case 503:
                    var tdNext = _textHandler.next();
                    dict["textOne"] = tdNext.Text;
                    dict["ac1"] = tdNext.UnitText;
                    break;
                case 504:
                    var tdPrev = _textHandler.previous();
                    dict["textOne"] = tdPrev.Text;
                    dict["ac1"] = tdPrev.UnitText;
                    break;
            }
            return JsonConvert.SerializeObject(dict, Formatting.Indented);
        }

  
        public void PerformDisplayAction(Command cmd, String response)
        {
            switch (cmd.ID)
            {
                case 501:
                    var html = HtmlHelper.generateHtmlPage(response);
                    _browserBox.DocumentText = html;
                    _browserBox.Visible = true;
                    _imageBox.Visible = _textHeader.Visible = _textBox.Visible = false;
                    ShowImage("nv_fixation_target.png");
                    break;

                case 502:
                case 503:
                case 504:
                    _textBox.Width = _textBox.Parent.Width;
                    UpdateTextBlock(_textHandler.getCurrentTextData());
                    _browserBox.Visible = _imageBox.Visible = false;
                    _textHeader.Visible = _textBox.Visible = true;
                    break;

                case 505: 
                case 506:
                case 507:
                case 508:
                case 509:
                case 510: 
                case 511: 
                case 512: 
                case 513: 
                case 514:
                case 515:
                case 516:
                case 517:
                case 518:
                case 519:
                case 520:
                case 521:
                    if (cmd.Media.Length != 0)
                        ShowImage(cmd.Media);
                    break;

            }
        }

       
        private void OnMouseClick(object sender, EventArgs e)
        {
            if (this.WindowState == FormWindowState.Normal)
            {
                ControlPanel.BringToFront();
                ControlPanel.Visible = true;
                return;
            }

            if (_hideTimer.Enabled)
            {
                _hideTimer.Stop();
            }
            ControlPanel.BringToFront();
            ControlPanel.Visible = true;

            _hideTimer.Elapsed += OnHideTimer;
            _hideTimer.Interval = 5000;
            _hideTimer.Enabled = true;
        }

        private void ZoomButton_Click(object sender, EventArgs e)
        {
            _log.Info("Zoom Button clicked");
            if ( this.WindowState == FormWindowState.Maximized )
            {
                this.WindowState = FormWindowState.Normal;
                ZoomButton.Image = Properties.Resources.windowed;
                this.Location = new Point(10, 10);
                this.Size = new Size(Screen.PrimaryScreen.WorkingArea.Size.Width - 20, Screen.PrimaryScreen.WorkingArea.Size.Height - 20);
                this.FormBorderStyle = FormBorderStyle.FixedSingle;
                this.MaximizeBox = this.MinimizeBox = TopMost = false;

                ControlPanel.BringToFront();
                ControlPanel.Visible = true;
                _hideTimer.Stop();

            }
            else
            {
                ControlPanel.Visible = false;
                this.FormBorderStyle = FormBorderStyle.None;
                this.WindowState = FormWindowState.Maximized;
                ZoomButton.Image = Properties.Resources.full_screen_icon_11769;
                TopMost = true;
            }
        }

        private void SettingButton_Click(object sender, EventArgs e)
        {
            _log.Info("Settings Button clicked");
            var settingsDlg = new SettingDlg (_config)
            {
                StartPosition = FormStartPosition.CenterScreen,
                TopMost = true
            };
            settingsDlg.BrightnessChangedEvent += OnUpdateBrightness;
            DialogResult res = settingsDlg.ShowDialog();

            if ( res == DialogResult.Cancel)
            {
                _imageBox.Image = AdjustBrightness((Bitmap)_currentImage, _config.Brightness);
            }
        }

        private void OnUpdateBrightness(int value)
        {
            _imageBox.Image = AdjustBrightness((Bitmap)_currentImage, value);
        }

        public static Bitmap AdjustBrightness(Bitmap Image, int Value)
        {
            if (Image == null)
                return null;

            //Bitmap TempBitmap = Image;
            Bitmap adjustedBmp = new Bitmap(Image.Width, Image.Height);
            var graphics = Graphics.FromImage(adjustedBmp);
            float FinalValue = (float)Value / 255.0f;
            float[][] colorMatrix =
                {
                    new float[] {1, 0, 0, 0, 0},
                    new float[] {0, 1, 0, 0, 0},
                    new float[] {0, 0, 1, 0, 0},
                    new float[] {0, 0, 0, 1, 0},
                    new float[] {FinalValue, FinalValue, FinalValue, 1, 1}
                };

            ImageAttributes Attributes = new ImageAttributes();
            Attributes.SetColorMatrix(new ColorMatrix(colorMatrix), ColorMatrixFlag.Default, ColorAdjustType.Bitmap);
            graphics.DrawImage(Image, new Rectangle(0, 0, Image.Width, Image.Height), 0, 0, Image.Width, Image.Height, GraphicsUnit.Pixel, Attributes);
            return adjustedBmp;
        }


        private void ShowImage(String name)
        {
            _log.Info($"Displaying image : \"{name}\"");

            if (_imageMap.ContainsKey(name))
                _currentImage = _imageMap[name];

            else
            {
                _currentImage = Image.FromFile("./Resources/nv_images/" + name);
                _imageMap[name] = _currentImage;
            }

            if (_currentImage == null)
            {
                _log.Error($"Cannot load image : \"{name}\"");
                return;
            }

            _imageBox.Image = AdjustBrightness((Bitmap)_currentImage, _config.Brightness);
            _textBox.Visible = _textHeader.Visible = _browserBox.Visible = false;
            _imageBox.Visible = true;
        }

        private void NearVisionForm_FormClosing(object sender, FormClosingEventArgs e)
        {
            e.Cancel = true;
        }

        private void LogButton_Click(object sender, EventArgs e)
        {
            _logForm.Show();
            _logForm.BringToFront();
        }
    }
}
