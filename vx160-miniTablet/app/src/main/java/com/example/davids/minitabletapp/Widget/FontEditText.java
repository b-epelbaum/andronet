package com.example.davids.minitabletapp.Widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.example.davids.minitabletapp.R;


public class FontEditText extends EditText {
    String fonts[]={"HelveticaNeue.ttf","HelveticaNeueLight.ttf","HelveticaNeueLTStd-BlkCn.otf","HelveticaNeueLTStd-It.otf",
            "HelveticaNeueLTStd-Lt.otf","motschcc.ttf","symbol.ttf","UniversLTStd-BoldCn.otf","UniversLTStd-LightCn.otf"   ,
            "timesi.ttf" , " timesbi.ttf" , "timesbd.ttf" , "times.ttf",""};
    public FontEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    public FontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        if(!isInEditMode()) {
            init(attrs);
        }

    }

    public FontEditText(Context context) {
        super(context);
        if(!isInEditMode()) {
            init(null);
        }
    }

    private void init(AttributeSet attrs) {
        if (attrs!=null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.FontTextView);
            if (a.getString(R.styleable.FontTextView_font_type)!=null) {
                String fontName = fonts[Integer.valueOf(a.getString(R.styleable.FontTextView_font_type))];

                if (fontName != null) {
                    Typeface myTypeface = Typeface.createFromAsset(getContext().getAssets(), "font/" + fontName);
                    setTypeface(myTypeface);
                }
                a.recycle();
            }
        }
    }

}