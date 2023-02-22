package com.camapp.sweetme.act;

import static com.camapp.sweetme.act.SweetGalleryList.lst_album_image;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.camapp.sweetme.R;
import com.camapp.sweetme.adapter.PhoneAlbumImageAdapt;
import com.camapp.sweetme.utilsApp.GridSpacingItemDecoration;

public class SweetAlbumListAct extends Activity implements OnClickListener {
    private PhoneAlbumImageAdapt albumAdapter;
    private GridLayoutManager gridLayoutManager;
    private ImageView iv_back_album_image;
    private long mLastClickTime = 0;
    private RecyclerView rcv_album_images;
    private TextView tv_title_album_image;
    public SweetAlbumListAct() {
        String str = "";
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activitysweet_album);
         initView();
            initViewAction();
    }

    private void initView() {
        rcv_album_images =  findViewById(R.id.rcv_album_images);
        tv_title_album_image =  findViewById(R.id.tv_title_album_image);
        iv_back_album_image =  findViewById(R.id.iv_back_album_image);
        gridLayoutManager = new GridLayoutManager(this, 3);
        rcv_album_images.setLayoutManager(gridLayoutManager);
        rcv_album_images.addItemDecoration(new GridSpacingItemDecoration(3, 10, true));
        try {
            albumAdapter = new PhoneAlbumImageAdapt(this, lst_album_image);
            rcv_album_images.setAdapter(albumAdapter);
            tv_title_album_image.setText(getIntent().getExtras().getString("ALBUM_NAME"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initViewAction() {
        iv_back_album_image.setOnClickListener(this);
    }

    public void onBackPressed() {
        finish();
    }

    public void onPause() {

        super.onPause();
    }


    public void onDestroy() {
        super.onDestroy();
    }

    public void onClick(View view) {
        if (SystemClock.elapsedRealtime() - mLastClickTime >= 1000) {
            mLastClickTime = SystemClock.elapsedRealtime();
            int id = view.getId();
            if (id == R.id.iv_back_album_image) {
                onBackPressed();
            }
        }
    }

}
