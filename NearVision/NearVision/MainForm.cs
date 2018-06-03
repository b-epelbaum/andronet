using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Web.Script.Serialization;
using System.Windows.Forms;
using SimpleWebServer;

namespace NearVision
{
    public partial class MainForm : Form
    {
        static int currentTextParagraph = 8;


        public MainForm()
        {
            InitializeComponent();
            WebServer ws = new WebServer(SendResponse, "http://localhost:8070/");
            ws.Run();
            //Console.WriteLine("A simple webserver. Press a key to quit.");
            //Console.ReadKey();
            //ws.Stop();

            image.SizeMode = PictureBoxSizeMode.StretchImage;
        }

        public string SendResponse(HttpListenerRequest request)
        {
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
               
                return string.Format("<HTML><BODY>{0}</BODY></HTML>", res);
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

        public static String GenerateResponse(Constants.L40Cmd selectedTest)
        {
            long msec = DateTimeOffset.Now.ToUnixTimeMilliseconds();
            System.Collections.IDictionary dict = new Dictionary<string, string>();

            dict["test"] = selectedTest.mTestId.ToString();
            dict["cmd"] = selectedTest.mCmd;
            dict["ptime"] = msec.ToString();

            switch (selectedTest.mTestId) {
                case 500:
                case 501:
                    break;
                case 502:
                    dict["textOne"] = Constants.Paragraphs[currentTextParagraph];
                    dict["ac1"] = Constants.Unit[currentTextParagraph];
                    break;
                case 503:
                    if (currentTextParagraph < 8)
                        currentTextParagraph++;
                    dict["textOne"] = Constants.Paragraphs[currentTextParagraph];
                    dict["ac1"] = Constants.Unit[currentTextParagraph];
                    break;
                case 504:
                    if (currentTextParagraph > 0)
                        currentTextParagraph--;
                    dict["textOne"] = Constants.Paragraphs[currentTextParagraph];
                    dict["ac1"] = Constants.Unit[currentTextParagraph];
                    break;
            }

            //dict["lang"] = sRes.getLangCode();


            return new JavaScriptSerializer().Serialize(dict);
        }

  
        public void setWebPageByResponse(int testId, String response)
        {
            String html = "";
            
            switch (testId)
            {
                case 501:
                    html = HtmlHelper.generateHtmlPage(response);
                    webBrowser.DocumentText = html;

                    webBrowser.Visible = true;
                    image.Visible = false;
                    header.Visible = false;
                    text.Visible = false;

                    ShowImage("nv_fixation_target.png");
                    //gifImageView.setVisibility(View.GONE);
                    //phoriaView.setVisibility(View.GONE);
                    break;

                case 502:
                case 503:
                case 504:

                    text.Width = text.Parent.Width;
                    //text.Location = new Point(0, text.Location.Y);
                    //text.Anchor = AnchorStyles.Left | AnchorStyles.Right;

                    text.Font= new Font(text.Font.FontFamily, Constants.FontSize[currentTextParagraph], GraphicsUnit.Pixel);
                    text.Text = Constants.Paragraphs[currentTextParagraph];
                    header.Text = Constants.Unit[currentTextParagraph];
                    webBrowser.Visible = false;
                    image.Visible = false;
                    header.Visible = true;
                    text.Visible = true;
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
            image.Image = Image.FromFile("./Resources/nv_images/" + name);
            webBrowser.Visible = false;
            image.Visible = true;
            header.Visible = false;
            text.Visible = false;
        }

        private void header_Click(object sender, EventArgs e)
        {

        }
    }
}
