package com.example.davids.minitabletapp.fragments;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;

import com.example.davids.minitabletapp.NearVisionApplication;
import com.example.davids.minitabletapp.R;
import com.example.davids.minitabletapp.Widget.FontTextView;
import com.example.davids.minitabletapp.Widget.PhoriaView;
import com.example.davids.minitabletapp.logics.Consts;
import com.example.davids.minitabletapp.logics.network.NVTabletManager;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;

import pl.droidsonroids.gif.GifImageView;

public class NearVisionFragment extends BaseFragment implements OnClickListener {
    private Button _settingsBtn;
    private WebView _nvWebView;
    private FontTextView stringText;
    private FontTextView headerText;
    private String _nvResponse;
    private ImageView imageView;
    private GifImageView gifImageView;
    private PhoriaView phoriaView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _nvResponse = getBaseActivity().generateServerResponse(Consts.L40Cmd.NV_FIXATION_TEST);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.near_vision_fragment, container, false);

        initViews(view);
        initListeners();
        initHandler();
        return view;

    }


    @Override
    protected void initViews(View view) {

        phoriaView = (PhoriaView) view.findViewById(R.id.phoriaView);
        gifImageView = (GifImageView) view.findViewById(R.id.gifImageView);
        _settingsBtn = (Button) view.findViewById(R.id.settings_btn);
        stringText = (FontTextView) view.findViewById(R.id.stringText);
        imageView = (ImageView) view.findViewById(R.id.image);
        headerText = (FontTextView) view.findViewById(R.id.headerText);
        _nvWebView = (WebView) view.findViewById(R.id.nv_webview);
        JavaScriptInterface jsInterface = new JavaScriptInterface();
        _nvWebView.getSettings().setJavaScriptEnabled(true);
        _nvWebView.addJavascriptInterface(jsInterface, "AndroidCode");
        _nvWebView.setBackgroundColor(Color.argb(1, 0, 0, 0));
        _nvWebView.setWebChromeClient(new WebChromeClient() {
            public void onConsoleMessage(String message, int lineNumber, String sourceID) {
                Log.d("chart_dc", message + " -- From line " + lineNumber + " of " + sourceID);
            }

            public boolean onConsoleMessage(ConsoleMessage cm) {
                Log.d("chart_dc", cm.message() + " -- From line " + cm.lineNumber() + " of " + cm.sourceId());
                return true;
            }
        });
        _nvWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                if (_nvWebView.getVisibility() != View.VISIBLE) {
                    _nvWebView.setVisibility(View.VISIBLE);
                }
            }
        });

    }


    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Animation anim = super.onCreateAnimation(transit, enter, nextAnim);

        if (anim == null && nextAnim != 0) {
            anim = AnimationUtils.loadAnimation(getActivity(), nextAnim);
        }

        if (anim != null) {
            anim.setAnimationListener(new AnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    initData();
                }

                @Override
                public void onAnimationStart(Animation animation) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    // TODO Auto-generated method stub

                }
            });
        }

        return anim;
    }

    @Override
    protected void initListeners() {
        _settingsBtn.setOnClickListener(this);
    }

    @Override
    protected void initHandler() {
        _handler = new Handler();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.settings_btn:
                getBaseActivity().replaceFragment(SettingsFragment.class, null);
                break;
        }
    }

    @Override
    public void showUI() {
        _settingsBtn.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideUI() {
        _settingsBtn.setVisibility(View.GONE);
    }

    @Override
    protected void initData() {
//		if(NearVisionApplication._changedLanguagePrefix!=null)
//		{
//			String selectedLanguagePrefix = NearVisionApplication._changedLanguagePrefix;
//			_nvResponse = generateCustomLanguageResponse(selectedLanguagePrefix);//changed manualy language in settings screen
//
//			NearVisionApplication._changedLanguagePrefix = null;
//		}

//		Log.d("anton","nvRequest="+_nvResponse);
//		String html = NVTabletManager.getInstance().generateHtmlPage(_nvResponse);
//		_nvWebView.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "UTF-8", null);


    }


    private String generateCustomLanguageResponse(String selectedLanguagePrefix) {


        JsonObject textJObj = new JsonObject();
        textJObj.addProperty("test", Consts.L40Cmd.NV_TEXT_TEST.mTestId);
        textJObj.addProperty("cmd", Consts.L40Cmd.NV_TEXT_TEST.mCmd);
        textJObj.addProperty("ptime", "1473755126179");
        textJObj.addProperty("lang", selectedLanguagePrefix);

        return textJObj.toString();
    }

    @Override
    public void onResume() {
        super.onResume();
        ///	getBaseActivity().changeScreenBrightness(0);
    }

    @Override
    public void setWebPageByResponse(final int testId, final String response) {

        _handler.post(new Runnable() {
            @SuppressLint("NewApi")
            @Override
            public void run() {
                String html = "";
                switch (testId) {


                    case 501:
                        _nvWebView.setVisibility(View.VISIBLE);
                        html = NVTabletManager.getInstance().generateHtmlPage(response);
                        _nvWebView.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "UTF-8", null);
                        getBaseActivity().changeScreenBrightness(70);
                        _nvResponse = response;
                        imageView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 502:
                        getBaseActivity().changeScreenBrightness(100);
                        stringText.setTextSize(TypedValue.COMPLEX_UNIT_PX, NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagrph()).getFontSize());
                        stringText.setText(NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagrph()).getText());
                        headerText.setText(NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagrph()).getTextHeader());
                        _nvWebView.setVisibility(View.GONE);
                        imageView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 503: //for scrolling image up
                        imageView.setVisibility(View.GONE);
                        getBaseActivity().changeScreenBrightness(100);
                        stringText.setTextSize(TypedValue.COMPLEX_UNIT_PX, NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagrph()).getFontSize());
                        stringText.setText(NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagrph()).getText());
                        headerText.setText(NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagrph()).getTextHeader());
                        _nvWebView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;

                    case 504: //for scrolling image down
                        getBaseActivity().changeScreenBrightness(100);
                        stringText.setTextSize(TypedValue.COMPLEX_UNIT_PX, NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagrph()).getFontSize());
                        stringText.setText(NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagrph()).getText());
                        headerText.setText(NearVisionApplication.getTextArrayList().get(NearVisionApplication.getCurrentTextParagrph()).getTextHeader());
                        _nvWebView.setVisibility(View.GONE);
                        imageView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 505: // - Jackson cross (to adjust the addition)
                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_jackson_cross.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 506: //- Red and green test (to adjust the addition)

                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_red_green.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 507: //- Amsler grid

                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_amsler_grid.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 508: //- Clock for astigmatism

                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_parent_clock.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 509: //-NV_NUMBER_IN_HORIZONTAL_LINE


                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/fb_horizontal_opto.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;

                    case 510: // - Fixation disparity (cross with the dot) - need red/green filters

                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/fusion_large.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 511: //- stereo acuity tests - need red/green filters

                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/stereo_large.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 512: //-  worth - need red/green filters

                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_worth.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 513: //-NV_NUMBER_IN_VERTICAL_LINE
                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_vertical_opto.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 514://WESSON
//						imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_wesson.png"));
//						getBaseActivity().changeScreenBrightness(100);
//						imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.VISIBLE);
                        phoriaView.initScrollView();
                        phoriaView.move(155);
                        getBaseActivity().changeScreenBrightness(100);
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
                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_schober.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        break;
                    case 516: //- nv_fixation_point
                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_fixation_point.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        break;
                    case 517://- NV_CROSS_PHORIA
                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_cross.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 518://- NV_OXO_HORIZONTAL
                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/st_nv_mallet_h.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 519://- NV_OXO_VERTICAL
                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_mallet_v.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 520://- NV_BROWSER
                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_browser_en.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;
                    case 521://- NV_METRO
                        imageView.setImageBitmap(getBitmapFromAssets("nv_images/nv_metro_en.png"));
                        getBaseActivity().changeScreenBrightness(100);
                        imageView.setVisibility(View.VISIBLE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        phoriaView.setVisibility(View.GONE);
                        break;

                    case 522://-//for scrolling right
                        getBaseActivity().changeScreenBrightness(100);
                        Log.w("scrolling", "right");
                        phoriaView.move(-1);
                        phoriaView.setVisibility(View.VISIBLE);
                        imageView.setVisibility(View.GONE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        break;
                    case 523:// for scrolling left
                        getBaseActivity().changeScreenBrightness(100);
                        Log.w("scrolling", "left");
                        phoriaView.setVisibility(View.VISIBLE);
                        phoriaView.move(1);
                        imageView.setVisibility(View.GONE);
                        _nvWebView.setVisibility(View.GONE);
                        gifImageView.setVisibility(View.GONE);
                        break;

                }

            }
        });
    }

    public Bitmap getBitmapFromAssets(String fileName) {
        AssetManager assetManager = getActivity().getAssets();

        InputStream istr = null;
        try {
            istr = assetManager.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);

        return bitmap;
    }

    public class JavaScriptInterface {
        @JavascriptInterface
        public void selectRedGreen(int i) {
            //			if (i == 0)
            //			{
            //				Logics.getInstance().getL40Manager().setSide(Side.RED);
            //			}
            //			else
            //			{
            //				Logics.getInstance().getL40Manager().setSide(Side.GREEN);
            //			}
            //
            //			_chartDisplayWebView.post(new Runnable()
            //			{
            //
            //				@Override
            //				public void run()
            //				{
            //					String html = Logics.getInstance().getL40Manager().generateHtmlPage(_lastResult);
            //					_chartDisplayWebView.loadDataWithBaseURL("file:///android_asset/", html, "text/html", "UTF-8", null);
            //				}
            //			});
        }

        @JavascriptInterface
        public void selectManualVaValue(final String vaValue) {
            //			_chartDisplayWebView.post(new Runnable()
            //			{
            //
            //				@Override
            //				public void run()
            //				{
            //					_chartListener.onManualVa(vaValue);
            //
            //				}
            //			});
        }

    }

}
