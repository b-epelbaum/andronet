using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Script.Serialization;
using static NearVision.Constants;

namespace NearVision
{
    class HtmlHelper
    {
        public static String generateHtmlPage(String result)
        {
            int test = 0;
            string html = "";
            string cmd = "";
            string lang = "";

            string curDir = Directory.GetCurrentDirectory();

            String lastResult = result;
            if (result == null || result == "")
            {
                //mFeedBackView.loadDataWithBaseURL("file:///android_asset/", "No connection with chart display, please retry", "text/html", "UTF-8", null);
                html = "<html>";
                html += "<head><style>";
                html += "	#noConnection {";
                html += "position:fixed;";
                html += "top: 25%;";
                html += "left: 25%;";
                html += "}";
                html += "</style>";
                html += "</head>";
                html += "<body>";
                html += "	<div id='noConnection'><b>No connection with chart display, please retry</b></div></body></html>";

                return html;
            }

            var dict = (System.Collections.IDictionary)(new JavaScriptSerializer().DeserializeObject(result));

            try
            {
            
                if (dict.Contains("cmd")) cmd = (string)dict["cmd"];
                if (dict.Contains("test")) int.TryParse((string)dict["test"], out test);
                if (dict.Contains("lang")) lang = (string)dict["lang"];

                if (test == L40Cmd.NV_FIXATION_TEST.mTestId)
                {
                    html = "<html>";
                    html += "<style>";
                    html += "body{height:100%;";
                    html += "width:100%;";

                    
                    html += String.Format("background-image:url(file:///{0}\\Resources\\nv_images\\nv_fixation_target.png);", curDir);

                    //html += "background-image:url(" + @".Resources\nv_images\nv_fixation_target.png" + ");";
                    //html += "background-image:url(./nv_images/nv_fixation_target.png);";
                    html += "background-repeat:no-repeat;";
                    html += "background-size:cover;";
                    html += "background-position: center;";
                    html += "background-size: 100% 100%;";
                    html += "}";
                    html += "</style>";
                    html += "<body>";
                    html += "</body>";
                    html += "</html>";
                }
                else if (test == L40Cmd.NV_TEXT_TEST.mTestId)
                {
                    //Languages currentLang = Consts.Languages.getLangugesByLangPrefix(lang);

                    html = "<html>";
                    html += "<head>";
                    html += "<link href='enyo.css' media='screen' rel='stylesheet' type='text/css'>";
                    html += "<link href='onyx.css' media='screen' rel='stylesheet' type='text/css'>";
                    html += "<link href='fittable.css' media='screen' rel='stylesheet' type='text/css'>";
                    html += "<link href='myfirst.css' media='screen' rel='stylesheet' type='text/css'>";
                    html += "<script src='scroll.js'></script>";

                    html += "<body onload='bottom();'>";

                    //switch (currentLang)
                    //{
                    //    case ENGLISH:
                    //        html += "<img src='nv_images/english_text.jpg' id='nvImage' style='visibility:hidden'>";
                    //        break;
                    //    case FRENCH:
                    //        html += "<img src='nv_images/french_text.png' id='nvImage' style='visibility:hidden'>";
                    //        break;
                    //    case GERMAN:
                    //        html += "<img src='nv_images/german_text.png' id='nvImage' style='visibility:hidden'>";
                    //        break;
                    //}
                    html += "</body></html>";
                }

            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message);
            }

            return html;

        }
    }
}
