package com.FiveXlenterprises.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;


public class TypefaceEditText extends EditText {

    public TypefaceEditText(Context context) {
        super(context);
    }

    public TypefaceEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyAttributes(context, attrs);
    }

    public TypefaceEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyAttributes(context, attrs);
    }

    private void applyAttributes(Context context, AttributeSet attrs) {
    }
}
