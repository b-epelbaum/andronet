package com.example.davids.minitabletapp.logics.network;

import android.util.Log;

import com.example.davids.minitabletapp.logics.Consts;
import com.example.davids.minitabletapp.logics.Consts.L40Cmd;
import com.example.davids.minitabletapp.logics.Consts.Languages;

import org.json.JSONException;
import org.json.JSONObject;


public class NVTabletManager {
    private static NVTabletManager _nvTabletManager;

    private NVTabletManager() {

    }

    public static NVTabletManager getInstance() {
        if (_nvTabletManager == null) {
            synchronized (NVTabletManager.class) {
                _nvTabletManager = new NVTabletManager();
            }
        }
        return _nvTabletManager;
    }

    private String getETDRSImg(char c) {
        String temp;
        switch (c) {
            case 'C':
                temp = "yellow_circle";
                break;
            case '0':
                temp = "grey_circle";
                break;
            case '1':
                temp = "red_circle";
                break;
            case '2':
                temp = "green_circle";
                break;
            default:
                temp = "grey_circle";
                break;
        }

        return temp;

    }

    private String getPelliImg(char c) {
        String temp;
        switch (c) {
            case '2':
                temp = "yellow_circle";
                break;
            case '1':
                temp = "grey_circle";
                break;
            case '4':
                temp = "red_circle";
                break;
            case '3':
                temp = "green_circle";
                break;
            default:
                temp = "grey_circle";
                break;
        }

        return temp;

    }

    public enum Side {
        GREEN,
        RED
    }

    ;

    private Side curSide = Side.RED;

    public String generateHtmlPage(String result) {

        Log.d("anton", "result=" + result);

        JSONObject jObj = null;
        int test = 0;
        String html = "";
        String cmd = "";
        String lang = "";

        String lastResult = result;
        if (result == null || result == "") {
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

        try {
            jObj = new JSONObject(result);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }

        try {

            if (jObj.has("cmd")) cmd = jObj.getString("cmd");
            if (jObj.has("test")) test = jObj.getInt("test");
            if (jObj.has("lang")) lang = jObj.getString("lang");

            if (test == L40Cmd.NV_FIXATION_TEST.mTestId) {
                html = "<html>";
                html += "<style>";
                html += "body{height:100%;";
                html += "width:100%;";
                html += "background-image:url(./nv_images/nv_fixation_target.png);";
                html += "background-repeat:no-repeat;";
                html += "background-size:cover;";
                html += "background-position: center;";
                html += "}";
                html += "</style>";
                html += "<body>";
                html += "</body>";
                html += "</html>";
            } else if (test == L40Cmd.NV_TEXT_TEST.mTestId) {
                Languages currentLang = Consts.Languages.getLangugesByLangPrefix(lang);

                html = "<html>";
                html += "<head>";
                html += "<link href='enyo.css' media='screen' rel='stylesheet' type='text/css'>";
                html += "<link href='onyx.css' media='screen' rel='stylesheet' type='text/css'>";
                html += "<link href='fittable.css' media='screen' rel='stylesheet' type='text/css'>";
                html += "<link href='myfirst.css' media='screen' rel='stylesheet' type='text/css'>";
                html += "<script src='scroll.js'></script>";

                html += "<body onload='bottom();'>";

                switch (currentLang) {
                    case ENGLISH:
                        html += "<img src='nv_images/english_text.jpg' id='nvImage' style='visibility:hidden'>";
                        break;
                    case FRENCH:
                        html += "<img src='nv_images/french_text.png' id='nvImage' style='visibility:hidden'>";
                        break;
                    case GERMAN:
                        html += "<img src='nv_images/german_text.png' id='nvImage' style='visibility:hidden'>";
                        break;
                }
                html += "</body></html>";
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return html;

    }


    private String getSymbol(String symbols, int pos, int opto) {
        String result = "";

        switch (opto) {
            case 2:        // Landolt
            {
                result = "<img src=\"landolt_c" + symbols.substring(pos, pos + 1) + ".png\"  width=\"40px\" , height=\"40px\">";
            }
            break;
            case 3:        // Snellen
            {
                result = "<img src=\"snellen_e" + symbols.substring(pos, pos + 1) + ".png\"  width=\"40px\" , height=\"40px\">";
            }
            break;
            case 4:        // Sender
            {
                result = "<img src=\"sender_";
                switch (symbols.charAt(pos)) {
                    case 'A':
                        result = result + "ballon.jpg";
                        break;
                    case 'B':
                        result = result + "telephone.jpg";
                        break;
                    case 'C':
                        result = result + "canard.jpg";
                        break;
                    case 'D':
                        result = result + "chat.jpg";
                        break;
                    case 'E':
                        result = result + "voiture.jpg";
                        break;
                    case 'F':
                        result = result + "chaussure.jpg";
                        break;
                    case 'G':
                        result = result + "bateau.jpg";
                        break;
                    case 'H':
                        result = result + "avion.jpg";
                        break;
                    case 'I':
                        result = result + "lapin.jpg";
                        break;
                    case 'J':
                        result = result + "poisson.jpg";
                        break;
                    default:
                        result = result + "poisson.jpg";
                        break;
                }
                result = result + "\" class=\"sender\">";

            }
            break;
            case 5:        // Formes
            {
                result = "<img src=\"F" + symbols.substring(pos, pos + 1) + ".png\"  width=\"40px\" , height=\"40px\">";
            }
            break;
            case 8:    // Aux1
            {
                result = "<img src=\"aux1_";
                switch (symbols.charAt(pos)) {
                    case 'A':
                        result = result + "a0.jpg";
                        break;
                    case 'B':
                        result = result + "a1.jpg";
                        break;
                    case 'C':
                        result = result + "a2.jpg";
                        break;
                    case 'D':
                        result = result + "a3.jpg";
                        break;
                    case 'E':
                        result = result + "a4.jpg";
                        break;
                    case 'F':
                        result = result + "a5.jpg";
                        break;
                    case 'G':
                        result = result + "a6.jpg";
                        break;
                    case 'H':
                        result = result + "a7.jpg";
                        break;
                    case 'I':
                        result = result + "a8.jpg";
                        break;
                    case 'J':
                        result = result + "a9.jpg";
                        break;
                    case 'K':
                        result = result + "a10.jpg";
                        break;
                    case 'L':
                        result = result + "a11.jpg";
                        break;
                    case 'M':
                        result = result + "a12.jpg";
                        break;
                    case 'N':
                        result = result + "a13.jpg";
                        break;
                }
                result = result + "\" class=\"sender\">";
            }
            break;
            case 9:    // Aux1
            {
                result = "<img src=\"aux2_";
                switch (symbols.charAt(pos)) {
                    case 'A':
                        result = result + "h0.png";
                        break;
                    case 'B':
                        result = result + "h1.png";
                        break;
                    case 'C':
                        result = result + "h2.png";
                        break;
                    case 'D':
                        result = result + "h3.png";
                        break;
                    case 'E':
                        result = result + "h4.png";
                        break;
                    case 'F':
                        result = result + "h5.png";
                        break;
                    case 'G':
                        result = result + "h6.png";
                        break;
                    case 'H':
                        result = result + "h7.png";
                        break;
                    case 'I':
                        result = result + "h8.png";
                        break;
                    case 'J':
                        result = result + "h9.png";
                        break;
                    case 'K':
                        result = result + "h10.png";
                        break;
                    case 'L':
                        result = result + "h11.png";
                        break;
                    case 'M':
                        result = result + "h12.png";
                        break;
                    case 'N':
                        result = result + "h13.png";
                        break;
                    case 'O':
                        result = result + "h14.png";
                        break;
                }
                result = result + "\" class=\"sender\">";
            }
            break;
            case 13:    // L29
            {
                result = "<img src=\"l29_";
                switch (symbols.charAt(pos)) {
                    case 'A':
                        result = result + "boat.jpg";
                        break;
                    case 'B':
                        result = result + "cat.jpg";
                        break;
                    case 'C':
                        result = result + "duck.jpg";
                        break;
                    case 'D':
                        result = result + "flower.jpg";
                        break;
                    case 'E':
                        result = result + "house.jpg";
                        break;
                    case 'F':
                        result = result + "man.jpg";
                        break;
                    case 'G':
                        result = result + "umbrella.jpg";
                        break;
                    case 'H':
                        result = result + "velo.jpg";
                        break;
                    case 'I':
                        result = result + "car.jpg";
                        break;
                    case 'J':
                        result = result + "sapin.jpg";
                        break;
                    case 'K':
                        result = result + "avion.jpg";
                        break;
                    case 'L':
                        result = result + "cheval.jpg";
                        break;
                    default:
                        result = result + "cheval.jpg";
                        break;
                }
                result = result + "\" class=\"sender\">";
            }
            break;
            case 108:    // Pigassous
            {
                result = "<img src=\"pigassou_";
                switch (symbols.charAt(pos)) {
                    case 'A':
                        result = result + "chat.jpg";
                        break;
                    case 'B':
                        result = result + "enfant.jpg";
                        break;
                    case 'C':
                        result = result + "fleur.jpg";
                        break;
                    case 'D':
                        result = result + "maison.jpg";
                        break;
                    case 'E':
                        result = result + "pie.jpg";
                        break;
                    case 'F':
                        result = result + "soleil.jpg";
                        break;
                    case 'G':
                        result = result + "voiture.jpg";
                        break;
                }
                result = result + "\" class=\"sender\">";
            }
            break;
            case 109:    // Oesterberg
            {
                result = "<img src=\"oesterberg_";
                switch (symbols.charAt(pos)) {
                    case 'A':
                        result = result + "avion.jpg";
                        break;
                    case 'B':
                        result = result + "bateau.jpg";
                        break;
                    case 'C':
                        result = result + "car.jpg";
                        break;
                    case 'D':
                        result = result + "cheval.jpg";
                        break;
                    case 'E':
                        result = result + "chien.jpg";
                        break;
                    case 'F':
                        result = result + "ciseau.jpg";
                        break;
                    case 'G':
                        result = result + "coeur.jpg";
                        break;
                    case 'H':
                        result = result + "etoile.jpg";
                        break;
                    case 'I':
                        result = result + "homme.jpg";
                        break;
                    case 'J':
                        result = result + "poisson.jpg";
                        break;
                    case 'K':
                        result = result + "sapin.jpg";
                        break;
                    case 'L':
                        result = result + "velo.jpg";
                        break;
                    case 'M':
                        result = result + "voiture.jpg";
                        break;
                }
                result = result + "\" class=\"sender\">";
            }
            break;
            default: {
                result = symbols.substring(pos, pos + 1);
            }
        }

        return result;
    }


}
