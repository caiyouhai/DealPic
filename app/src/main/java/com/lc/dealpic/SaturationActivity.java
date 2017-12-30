package com.lc.dealpic;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.lc.dealpic.util.ColorMatrixUtils;

public class SaturationActivity extends AppCompatActivity {

    private ImageView iv_src;
    private ImageView iv_dest;


    private TextView tv_sat_value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saturation);

        iv_src= (ImageView) findViewById(R.id.iv_src);

        iv_dest= (ImageView) findViewById(R.id.iv_dest);

        tv_sat_value= (TextView) findViewById(R.id.tv_sat_value);
        SeekBar seek_bar= (SeekBar) findViewById(R.id.seek_bar);
        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int process = seekBar.getProgress();
                float max=seekBar.getMax();
                float value=process/max;
                tv_sat_value.setText("饱和度："+value);


                BitmapDrawable drawable= (BitmapDrawable) iv_src.getDrawable();
                Bitmap bitmapSrc=drawable.getBitmap();

                Bitmap bitmapGray= ColorMatrixUtils.setSaturation(bitmapSrc,value);
                iv_dest.setImageBitmap(bitmapGray);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {  }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }
}
