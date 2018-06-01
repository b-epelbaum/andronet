package com.example.davids.minitabletapp.Widget;

/**
 * Created by Anton on 1/22/2017.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.davids.minitabletapp.R;


public class PhoriaView extends RelativeLayout {


    public static String RIGHT="R";
    public static String LEFT="L";
    private LayoutInflater _inflater;


    private HorizontalScrollView scrollView;

    private Context _context;
    private View rootView;




    //for showing lm data table




    public PhoriaView(Context context)
    {
        super(context);
        _context = context;
        _inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(!isInEditMode()){
            init();
        }
    }

    public PhoriaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        _context = context;
        _inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(!isInEditMode()){
            init(attrs);
            init();
        }
    }

    public PhoriaView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        _context = context;
        _inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(!isInEditMode()){
            init(attrs);
            init();
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public PhoriaView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        _context = context;
        _inflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(!isInEditMode()){
            init(attrs);
            init();
        }

    }
    public void init() {
        rootView = _inflater.inflate(R.layout.view_phoria, this, true);
           initViews();
           initData();
    }

    public void initData() {

        scrollView.scrollTo(scrollView.getScrollX()+393 ,0);
        scrollView.setSmoothScrollingEnabled(true);
        Log.w("pos",""+scrollView.getScrollX() );

    }

    private void init(AttributeSet attrs) {
        if (attrs!=null) {

            }

    }
    private void initViews() {
        scrollView= (HorizontalScrollView) rootView.findViewById(R.id.scrollView);


    }


    public void move(int value)
      {
            scrollView.scrollTo(scrollView.getScrollX()+value ,0);

        Log.w("pos",""+scrollView.getScrollX() );
    }

    public void initScrollView() {
        scrollView.scrollTo(0,0);
    }
}
