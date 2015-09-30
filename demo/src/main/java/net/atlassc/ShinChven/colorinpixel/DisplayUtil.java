package net.atlassc.ShinChven.colorinpixel;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ShinChven on 2014/10/31.
 */
public class DisplayUtil {

    public static void fit(View view, DisplayMatrix matrix) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = matrix.height;
        layoutParams.width = matrix.width;
        view.setLayoutParams(layoutParams);
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static DisplayMatrix getScreenDisplayMatrix(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;
        DisplayMatrix displayMatrix = new DisplayMatrix(width, height);
        return displayMatrix;
    }

    /**
     * 按比例缩放
     *
     * @param displayWidth   显示宽度
     * @param originalWidth  原始宽度
     * @param originalHeight 原始高度
     * @return
     */
    public static DisplayMatrix zoomWithWidth(int displayWidth, int originalWidth, int originalHeight) {
        float ratio = (float) displayWidth / (float) originalWidth;
        float adjustedHeight = originalHeight * ratio;
        return new DisplayMatrix(displayWidth, (int) adjustedHeight);
    }

    /**
     * 按比例缩放
     *
     * @param displayHeight  显示高度
     * @param originalWidth  原始宽度
     * @param originalHeight 原始高度
     * @return
     */
    public static DisplayMatrix zoomWithHeight(int displayHeight, int originalWidth, int originalHeight) {
        float ratio = (float) displayHeight / (float) originalHeight;
        float adjustedWidth = originalWidth * ratio;
        return new DisplayMatrix((int) adjustedWidth, displayHeight);
    }

    /**
     * 保存高宽
     */
    public static class DisplayMatrix {

        public DisplayMatrix(int width, int height) {
            this.width = width;
            this.height = height;
        }

        /**
         * 宽度
         */
        public int width;
        /**
         * 高度
         */
        public int height;
    }
}
