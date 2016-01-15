package com.FiveXlenterprises.util;

public class AnimationUtil {
    public int FPS = 30;  // animation FPS

    // single instance procedures
    private static AnimationUtil mInstance;

    private AnimationUtil() {
    };

    public static AnimationUtil getInstance() {
        if (mInstance == null)
            mInstance = new AnimationUtil();
        return mInstance;
    }
}
