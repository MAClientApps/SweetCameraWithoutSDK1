package com.camapp.sweetme.remote;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.RelativeLayout;

import com.camapp.sweetme.R;

public class SupporterClass {

    public static boolean isUserInSplash = false;
    public static boolean isFullScreenInView = false;

    public static boolean getFullScreenIsInView() {
        return isFullScreenInView;
    }

    public static void setFullScreenIsInView(boolean value) {
        isFullScreenInView = value;
    }

    public static boolean getUserInSplashIntro() {
        return isUserInSplash;
    }

    public static void setUserInSplashIntro(boolean value) {
        isUserInSplash = value;
    }

   /* public static void loadBannerAds(RelativeLayout adContainerView, Activity activity) {
        adContainerView.setVisibility(View.GONE);

        if (SupporterClass.checkConnection(activity)) {
            String adId = "";
            adId = activity.getString(R.string.admob_banner_ads_id_test);
            if (adId == null) {
                return;
            }
            if (adId.isEmpty()) {
                return;
            }
        }
    }
*/
    public static boolean checkConnection(Context mContext) {
        ConnectivityManager conMgr = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        if (netInfo == null) {
            return false;
        } else {
            return true;
        }
    }
}
