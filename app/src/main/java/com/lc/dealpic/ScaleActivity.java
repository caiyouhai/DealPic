package com.lc.dealpic;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.lc.dealpic.util.ColorMatrixUtils;

public class ScaleActivity extends AppCompatActivity {

    private ImageView iv_src;
    private ImageView iv_dest;
    private TextView red_value;
    private TextView green_value;
    private TextView blue_value;
    private TextView alpha_value;
    private SeekBar seek_bar_red;
    private SeekBar seek_bar_green;
    private  SeekBar seek_bar_blue;
    private SeekBar seek_bar_alpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);


        iv_src= (ImageView) findViewById(R.id.iv_src);
        iv_dest= (ImageView) findViewById(R.id.iv_dest);

        red_value= (TextView) findViewById(R.id.red_value);;
        green_value= (TextView) findViewById(R.id.green_value);;
        blue_value= (TextView) findViewById(R.id.blue_value);;
        alpha_value= (TextView) findViewById(R.id.alpha_value);

        seek_bar_red= (SeekBar) findViewById(R.id.seek_bar_red);
        seek_bar_green= (SeekBar) findViewById(R.id.seek_bar_green);
        seek_bar_blue= (SeekBar) findViewById(R.id.seek_bar_blue);
        seek_bar_alpha= (SeekBar) findViewById(R.id.seek_bar_alpha);

        SeekBar.OnSeekBarChangeListener listener=new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int process = seekBar.getProgress();
                if (seek_bar_red.getId()==seekBar.getId()){
                    red_value.setText("red："+process);
                }else if (seek_bar_green.getId()==seekBar.getId()){
                    green_value .setText("green："+process);
                }else if (seek_bar_blue.getId()==seekBar.getId()){
                    blue_value .setText("blue："+process);
                }else if (seek_bar_alpha.getId()==seekBar.getId()){
                    alpha_value .setText("alpha："+process);
                }

                changeScale();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {  }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        };
        seek_bar_red.setOnSeekBarChangeListener(listener);
        seek_bar_green.setOnSeekBarChangeListener(listener);
        seek_bar_blue.setOnSeekBarChangeListener(listener);
        seek_bar_alpha.setOnSeekBarChangeListener(listener);
    }

    private void changeScale(){
        int rScale = seek_bar_red.getProgress();
        int gScale = seek_bar_green.getProgress();
        int bScale =seek_bar_blue .getProgress();
//        float rScale = seek_bar_red.getProgress()/(float)seek_bar_red.getMax();
//        float gScale = seek_bar_green.getProgress()/(float)seek_bar_green.getMax();
//        float bScale =seek_bar_blue .getProgress()/(float)seek_bar_blue.getMax();
        float aScale =seek_bar_alpha .getProgress()/(float)seek_bar_alpha.getMax();

        BitmapDrawable drawable= (BitmapDrawable) iv_src.getDrawable();
        Bitmap bitmapSrc=drawable.getBitmap();
        Bitmap bitmap= ColorMatrixUtils.setScale(bitmapSrc,rScale,gScale,bScale,aScale);
        iv_dest.setImageBitmap(bitmap);
    }
}
