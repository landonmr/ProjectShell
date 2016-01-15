package com.FiveXlenterprises.manager;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LruCache;

/**
 * Responsible for the loading  fonts and retrieving fonts
 */
public class TypefaceManager {
    private static final String TAG = TypefaceManager.class.getSimpleName();

    public static final int NO_FONT_STYLE = 0;
    private static final LruCache<String, Typeface> mTypefaces = new LruCache<>(4);

    private static TypefaceManager mInstance;

    private final Context mContext;

    private TypefaceManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public synchronized static TypefaceManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new TypefaceManager(context);
        }

        return mInstance;
    }

    /**
     * Builds the name convention for the font file .otf
     *
     * @param typeface      typeface name
     * @param typefaceStyle typeface style (bold, regular, etc)
     * @return String file name of font specified in params.
     */
    private static String buildTypefaceName(String typeface, String typefaceStyle) {
        StringBuilder fontNameBuilder = new StringBuilder();
        fontNameBuilder.append(typeface);
        if (typefaceStyle != null) {
            fontNameBuilder.
                    append("-").
                    append(typefaceStyle);
        }

        return fontNameBuilder.toString();
    }

    /**
     * Registers the font in the map for future use.
     *
     * @param typefaceId      string resource for typeface name
     * @param typefaceStyleId string resource for typeface style (bold, regular, etc)
     */
    public void registerTypeface(int typefaceId, int typefaceStyleId) {
        String fontName = buildTypefaceName(mContext.getString(typefaceId),
                typefaceStyleId == NO_FONT_STYLE ? null : mContext.getString(typefaceStyleId));
        mTypefaces.put(fontName, createTypeface(fontName));
    }

    /**
     * Gets specific font
     *
     * @param typefaceId      string resource for typeface name
     * @param typefaceStyleId string resource for typeface style (bold, regular, etc)
     * @return Typeface based on typeface name and style
     */
    public Typeface getTypeface(int typefaceId, int typefaceStyleId) {
        try {
            String fontName = buildTypefaceName(mContext.getString(typefaceId),
                    typefaceStyleId == NO_FONT_STYLE ? null : mContext.getString(typefaceStyleId));
            return mTypefaces.get(fontName);
        } catch (NullPointerException npe) {
            Log.e(TAG, "NullPointerException caught. " + npe.getMessage());
            npe.printStackTrace();
            return null;
        }
    }

    /**
     * Gets specific font based on attributes set in xml control
     *
     * @param attrs            control attributes
     * @param attrsStyleableId
     * @param fontAttrId
     * @param fontStyleAttrId
     * @return Typeface based on typeface name and style
     */
    public Typeface getTypeface(AttributeSet attrs, int[] attrsStyleableId, int fontAttrId, int fontStyleAttrId) {
        TypedArray a = null;
        try {
            a = mContext.obtainStyledAttributes(attrs, attrsStyleableId);
            String typeface = a.getString(fontAttrId);
            String typefaceStyle = a.getString(fontStyleAttrId);

            return mTypefaces.get(buildTypefaceName(typeface, typefaceStyle));
        } catch (Exception exception) {
            Log.e(TAG, "Exception caught. " + exception.getMessage());
            exception.printStackTrace();
        } finally {
            if (a != null) {
                a.recycle();
            }
        }
        return null;
    }

    /**
     * Creates typeface from font files in assets directory
     *
     * @param typefaceName name of font you would like to retieve
     * @return Typeface
     */
    private Typeface createTypeface(String typefaceName) {
        return Typeface.createFromAsset(mContext.getAssets(), "fonts/" + typefaceName + ".otf");
    }
}
