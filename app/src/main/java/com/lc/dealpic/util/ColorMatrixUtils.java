package com.lc.dealpic.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;

/**
 * @author youhai.cai
 * @date 2017/12/30.
 */

public class ColorMatrixUtils {

    /**
     * 将颜色矩阵matA和matB复合，相当与对图片进行matA矩阵处理再进行矩阵matB处理
     * */
    public static Bitmap setConcat(Bitmap bitmap,ColorMatrix matA,ColorMatrix matB){
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.reset();
        colorMatrix.setConcat(matA,matB);
        colorMatrix.setConcat(matA,matB);
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        return createNewBitmap(bitmap,colorFilter);
    }

    /**
     * 设置颜色分量旋转：axis==0旋转红色；axis==1对应绿色；axis==2对应蓝色
     * @param degrees 旋转角度，360的倍数是原图
     * */
    public static Bitmap setRotate(Bitmap bitmap,int axis, float degrees){
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.reset();

        colorMatrix.setRotate(axis,degrees);
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        return createNewBitmap(bitmap,colorFilter);
    }

    /**
     * 设置矩阵的R，G，B，A等变量到对应的倍数。
     * 原图值:rScale=fgScale=bScale=aScale=1 ;
     * 黑图：rScale=fgScale=bScale=aScale=0;
     * aScale 透明度，范围：0<=aScale<=1,若大于1，则按1算
     * @param bitmap
     * @param rScale
     * @param gScale
     * @param bScale
     * @param aScale
     * */
    public static Bitmap setScale(Bitmap bitmap,float rScale, float gScale, float bScale,float aScale){
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.reset();
        colorMatrix.setScale( rScale,  gScale,  bScale, aScale);
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        return createNewBitmap(bitmap,colorFilter);
    }



    /**
     * 设置图片的饱和度。
     *
     * */
    public static Bitmap setSaturation(Bitmap bitmap, float sat) {

        /*
        ColorMatrix :4 x5矩阵,用于改变位图的颜色和透明度

        */
        ColorMatrix colorMatrix = new ColorMatrix();
        //设置颜色矩阵的饱和度，0是灰色的，1是原图
        //设置图像的饱和度,范围: 0<=sat<=1,0是灰色的，1是原图
        colorMatrix.setSaturation(sat);
        ColorMatrixColorFilter colorFilter = new ColorMatrixColorFilter(colorMatrix);
        return createNewBitmap(bitmap,colorFilter);
    }

    private static Bitmap createNewBitmap(Bitmap bitmap, ColorMatrixColorFilter colorFilter) {
        // 得到图片的长和宽
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap newBit = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(newBit);
        Paint paint = new Paint();
        paint.setColorFilter(colorFilter);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return newBit;
    }

}
