package com.camapp.sweetme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.camapp.sweetme.remote.SupporterClass;
import com.camapp.sweetme.utilsApp.TypefaceUtils;
import com.google.firebase.FirebaseApp;

public class SweetMyAplication extends MultiDexApplication {
    private static SweetMyAplication mInstance;
    private static SweetMyAplication myApplication;
    public final String TAG = SweetMyAplication.class.getSimpleName();
    public Context sContext = null;

    public static SweetMyAplication getApplication() {
        return myApplication;
    }

    public static void setApplication(SweetMyAplication application) {
        myApplication = application;
    }

    public static synchronized SweetMyAplication getInstance() {
        synchronized (SweetMyAplication.class) {
            synchronized (SweetMyAplication.class) {
                myApplication = mInstance;
            }
        }
        return myApplication;
    }

    public void onCreate() {
        super.onCreate();

        mInstance = this;
        sContext = getApplicationContext();
        setApplication(this);
        TypefaceUtils.overrideFont(getApplicationContext(), "serif", "fonts/rubik_regular.ttf");

        mInstance = this;
        FirebaseApp.initializeApp(mInstance);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        checkAppReplacingState();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    private void checkAppReplacingState() {
        Log.d(this.TAG, "app start...");
        if (getResources() == null) {
            Log.d(this.TAG, "app is replacing...kill");
            Process.killProcess(Process.myPid());
        }
    }

    public void showInterstitial(final Activity act, final Intent intent, final boolean isFinished) {

        if (!SupporterClass.checkConnection(sContext)) {
            SupporterClass.setFullScreenIsInView(false);
            if (intent != null)
                act.startActivity(intent);
            if (isFinished) {
                if (act != null && !act.isFinishing())
                    act.finish();
            }
            return;
        }
        SupporterClass.setFullScreenIsInView(false);
        if (intent != null)
            act.startActivity(intent);
        if (isFinished) {
            if (act != null && !act.isFinishing())
                act.finish();
        }
    }

}
