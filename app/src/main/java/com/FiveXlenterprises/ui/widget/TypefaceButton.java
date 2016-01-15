package com.FiveXlenterprises.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;


public class TypefaceButton extends Button {
    public TypefaceButton(Context context) {
        super(context);
    }

    public TypefaceButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttrs(attrs);
    }

    public TypefaceButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyAttrs(attrs);
    }

    private void applyAttrs(AttributeSet attrs) {

    }
}
