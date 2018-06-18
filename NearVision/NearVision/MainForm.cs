using System;
using System.Collections.Generic;
using System.Drawing;
using System.Timers;
using System.Net;
using System.Windows.Forms;
using Newtonsoft.Json;
using SimpleWebServer;

namespace NearVision
{
    public partial class MainForm : Form
    {
        private ConfigMgr _config;
        private System.Timers.Timer _hideTimer;
        private SettingDlg _settingsDlg;
        private TextHandler _textHandler;

        public MainForm()
        {
            InitializeComponent();

            _config = ConfigMgr.Init();
            _textHandler = new TextHandler(_config);
            _textHandler.updateTextBlockEvent += onUpdateTextBlock;

            InitGUI();
            InitMouseEvents();
            InitWebServer();
            InitStartText();

        }

     
        private void InitGUI()
        {
            BringToFront();
            TopMost = true;

            _imageBox.SizeMode = PictureBoxSizeMode.StretchImage;
            ControlPanel.Visible = _browserBox.Visible = _imageBox.Visible =  false;
            _textHeader.Visible = _textBox.Visible = true;
            _hideTimer = new System.Timers.Timer();
        }

        private void InitMouseEvents()
        {
            this.MouseClick += new System.Windows.Forms.MouseEventHandler(this.on_MouseClick);
            this._imageBox.MouseClick += new MouseEventHandler(this.on_MouseClick);
            this._textBox.MouseClick += new MouseEventHandler(this.on_MouseClick);
            this._textHeader.MouseClick += new MouseEventHandler(this.on_MouseClick);
        }

        private void InitWebServer()
        {
            string httpPreffix = _config.General.IsSSL ? "https://" : "http://";
            WebServer ws = new WebServer(SendResponse, $"{httpPreffix}{_config.General.ServerIP}:{_config.General.Port}/");
            ws.Run();
        }

        private void InitStartText ()
        {
            TextData td = _textHandler.getCurrentTextData();
            if (td == null)
                return;

            UpdateTextBlock(td);
        }

        private void onUpdateTextBlock(TextData textData)
        {
            if (textData == null)
                return;

            UpdateTextBlock(textData);
        }

        private void UpdateTextBlock(TextData td )
        {
            _textBox.Font = new Font(_textBox.Font.FontFamily, (float)td.FontSize, GraphicsUnit.Pixel);
            _textBox.Text = td.Text;
            _textHeader.Text = td.UnitText;
        }

        private void on_MouseClick(object sender, EventArgs e)
        {
            if ( this.WindowState == FormWindowState.Normal )
            {
                return;
            }

            if (_hideTimer.Enabled )
            {
                _hideTimer.Stop();
            }
            ControlPanel.BringToFront();
            ControlPanel.Visible = true;

            _hideTimer.Elapsed += new ElapsedEventHandler(on_HideTimer);
            _hideTimer.Interval = 5000;
            _hideTimer.Enabled = true;
        }

        private void on_HideTimer(object sender, EventArgs e)
        {
            ControlPanel.Visible = false;
            _hideTimer.Stop();
        }

        public string SendResponse(HttpListenerRequest request)
        {
            var allRequet = request.ToString();
            String cmd = request.QueryString.Get("cmd");
            if (cmd != null)
            {
                Constants.L40Cmd selectedTest = getSelectedTest(cmd);
                if (selectedTest == null)
                    return string.Format("<HTML><BODY>test is null</BODY></HTML>", DateTime.Now);
                String res = GenerateResponse(selectedTest);
                Invoke((MethodInvoker)delegate {
                    setWebPageByResponse(selectedTest.mTestId, res);
                });

                return res;
            }
            return string.Format("<HTML><BODY>cmd is not parsed</BODY></HTML>", DateTime.Now);
        }

        private static Constants.L40Cmd getSelectedTest(String cmdCommand)
        {
            Constants.L40Cmd selectedTest = null;
            foreach (Constants.L40Cmd test in Constants.L40Cmd.Values)
            {
                if (test.mCmd.Equals(cmdCommand))
                {
                    selectedTest = test;
                    break;
                }
            }
            return selectedTest;
        }

        public String GenerateResponse(Constants.L40Cmd selectedTest)
        {
            long msec = (long)(DateTimeOffset.Now.ToUniversalTime() - new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc)).TotalMilliseconds ;
            System.Collections.IDictionary dict = new Dictionary<string, string>();

            dict["test"] = selectedTest.mTestId.ToString();
            dict["cmd"] = selectedTest.mCmd;
            dict["ptime"] = msec.ToString();
            dict["lang"] = _config.CurrentLangID;

            switch (selectedTest.mTestId) {
                case 500:
                case 501:
                    break;
                case 502:
                    TextData td = _textHandler.getCurrentTextData();
                    dict["textOne"] = td.Text;
                    dict["ac1"] = td.UnitText;
                    break;
                case 503:
                    TextData tdNext = _textHandler.next();
                    dict["textOne"] = tdNext.Text;
                    dict["ac1"] = tdNext.UnitText;
                    break;
                case 504:
                    TextData tdPrev = _textHandler.previous();
                    dict["textOne"] = tdPrev.Text;
                    dict["ac1"] = tdPrev.UnitText;
                    break;
            }
            return JsonConvert.SerializeObject(dict, Formatting.None);
        }

  
        public void setWebPageByResponse(int testId, String response)
        {
            String html = "";
            switch (testId)
            {
                case 501:
                    html = HtmlHelper.generateHtmlPage(response);
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

                case 505: // - Jackson cross (to adjust the addition)
                    ShowImage("nv_jackson_cross.png");
                    break;

                case 506: //- Red and green test (to adjust the addition)
                    ShowImage("nv_red_green.png");
                    break;
                case 507: //- Amsler grid
                    ShowImage("nv_amsler_grid.png");
                    break;
                case 508: //- Clock for astigmatism
                    ShowImage("nv_parent_clock.png");                
                    break;
                case 509: //-NV_NUMBER_IN_HORIZONTAL_LINE
                    ShowImage("fb_horizontal_opto.png");
                    break;

                case 510: // - Fixation disparity (cross with the dot) - need red/green filters
                    ShowImage("fusion_large.png");
                    break;
                case 511: //- stereo acuity tests - need red/green filters
                    ShowImage("stereo_large.png");
                    break;
                case 512: //-  worth - need red/green filters
                    ShowImage("nv_worth.png");
                    break;
                case 513: //-NV_NUMBER_IN_VERTICAL_LINE
                    ShowImage("nv_vertical_opto.png");
                    break;
                case 514://WESSON
                    ShowImage("nv_wesson.png");
                         //						imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_wesson.png"));
                         //						getBaseActivity().changeScreenBrightness(100);
                         //						imageView.setVisibility(View.VISIBLE);
                         //_nvWebView.setVisibility(View.GONE);
                         //gifImageView.setVisibility(View.GONE);
                         //phoriaView.setVisibility(View.VISIBLE);
                         //phoriaView.initScrollView();
                         //phoriaView.move(155);
                         //getBaseActivity().changeScreenBrightness(100);
                         //						GifDrawable gifFromAssets = null;
                         //						try {
                         //							gifFromAssets = new GifDrawable( getResources().getAssets(), "nv_images/chien.gif" );
                         //							gifImageView.setImageDrawable(gifFromAssets);
                         //
                         //							imageView.setImageBitmap(getBitmapFromAssets("nv_images/chien.gif"));
                         //							getBaseActivity().changeScreenBrightness(100);
                         //							imageView.setVisibility(View.GONE);
                         //							_nvWebView.setVisibility(View.GONE);
                         //							gifImageView.setVisibility(View.VISIBLE);
                         //							_nvWebView.setVisibility(View.GONE);
                         //						} catch (IOException e) {
                         //							e.printStackTrace();
                         //						}
                    break;
                case 515: //- Schober
                    ShowImage("nv_schober.png");
                    break;
                case 516: //- nv_fixation_point
                    ShowImage("nv_fixation_point.png");
                    break;
                case 517://- NV_CROSS_PHORIA
                    ShowImage("nv_cross.png");
                    break;
                case 518://- NV_OXO_HORIZONTAL
                    ShowImage("st_nv_mallet_h.png");
                    break;
                case 519://- NV_OXO_VERTICAL
                    ShowImage("nv_mallet_v.png");
                    break;
                case 520://- NV_BROWSER
                    ShowImage("nv_browser_en.png");
                    break;
                case 521://- NV_METRO
                    ShowImage("nv_metro_en.png");
                    break;

            }
        }

        private void ShowImage(String name)
        {
            Image bm = Bitmap.FromFile("./Resources/nv_images/" + name);

            _imageBox.Image = Image.FromFile("./Resources/nv_images/" + name);
            _textBox.Visible = _textHeader.Visible = _browserBox.Visible = false;
            _imageBox.Visible = true;
        }

        private void ZoomButton_Click(object sender, EventArgs e)
        {
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
            _settingsDlg = new SettingDlg (_config)
            {
                StartPosition = FormStartPosition.CenterScreen,
                TopMost = true
            };

            _settingsDlg.ShowDialog();
        }

        private void MainForm_MouseMove(object sender, MouseEventArgs e)
        {

        }
    }
}
