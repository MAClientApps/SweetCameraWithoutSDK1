package com.camapp.sweetme.act;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.view.View;
import android.widget.LinearLayout;

import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class SweetViewAdMob {

    public static final String UNITY_GAME_ID = "5100381";
    public static final String UNITY_BANNER_ID = "Banner_Android";
    public static Boolean UNITY_IS_VISIBLE = true;


    public static boolean isConnectionAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return (cm != null && cm.getActiveNetworkInfo() != null) && cm
                .getActiveNetworkInfo().isConnectedOrConnecting();
    }

    public static void showBannerAds(Activity activity, final LinearLayout layoutAds) {
        if (UNITY_IS_VISIBLE && isConnectionAvailable(activity)) {

            final BannerView view = new BannerView(activity, UNITY_BANNER_ID, UnityBannerSize.getDynamicSize(activity));
            view.setListener(new BannerView.IListener() {
                @Override
                public void onBannerLoaded(BannerView bannerView) {
                    layoutAds.setVisibility(View.VISIBLE);
                    layoutAds.removeAllViews();
                    layoutAds.addView(view);
                }

                @Override
                public void onBannerClick(BannerView bannerView) {

                }

                @Override
                public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
                    layoutAds.setVisibility(View.GONE);
                }

                @Override
                public void onBannerLeftApplication(BannerView bannerView) {

                }
            });

            view.load();
        }
    }
}
