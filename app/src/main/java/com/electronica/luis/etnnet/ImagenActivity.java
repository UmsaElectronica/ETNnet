package com.electronica.luis.etnnet;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Window;

import com.electronica.luis.etnnet.R;
import com.github.snowdream.android.widget.SmartImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ImagenActivity extends Activity {
    private SmartImageView sivp;
    PhotoViewAttacher photoViewAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_imagen);
        final String ur=getIntent().getStringExtra("url");

        sivp=(SmartImageView)findViewById(R.id.img);
        Rect rect=new Rect(sivp.getLeft(),sivp.getTop(),sivp.getRight(),sivp.getBottom());
        sivp.setImageUrl(ur,rect);

        photoViewAttacher=new PhotoViewAttacher(sivp);

    }
}
