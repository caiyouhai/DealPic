package com.lc.dealpic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/***
 * 参考：
 * android Matrix类以及ColorMatrix类详解
 * http://www.cnblogs.com/dongtaochen2039/archive/2012/03/29/2423443.html
 *
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void rotate(View view){
        Intent intent=new Intent(this,RotateActivity.class);
        startActivity(intent);
    }
    public void saturation(View view){
        Intent intent=new Intent(this,SaturationActivity.class);
        startActivity(intent);
    }
    public void scale(View view){
        Intent intent=new Intent(this,ScaleActivity.class);
        startActivity(intent);

    }




}
