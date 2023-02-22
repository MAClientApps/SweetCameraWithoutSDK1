package com.camapp.sweetme.utilsApp;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;

import java.lang.reflect.Field;

public class TypefaceUtils {
    public static void overrideFont(Context context, String str, String str2) {
        try {
            Typeface createFromAsset = Typeface.createFromAsset(context.getAssets(), str2);
            Field declaredField = Typeface.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(null, createFromAsset);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Can not ");
            sb.append(str2);
            sb.append(" instead of ");
            sb.append(str);
            Log.e(sb.toString(), "=="+unused.getMessage());
        }
    }
}
