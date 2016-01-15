package com.FiveXlenterprises.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;


public class TypefaceTextView extends TextView {

    public TypefaceTextView(Context context) {
        super(context);
    }

    public TypefaceTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttributes(context, attrs);
    }

    public TypefaceTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyAttributes(context, attrs);
    }

    private void applyAttributes(Context context, AttributeSet attrs) {
    }
}
