package net.atlassc.ShinChven.colorinpixel;

import android.app.Application;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * Created by ShinChven on 15/9/30.
 */
public class AppContext extends Application {


    private static AppContext sInstance;
    private ImageLoader mImageLoader;

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    /**
     * @return ApplicationController singleton instance
     */
    public static synchronized AppContext getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // initialize the singleton
        sInstance = this;
        // get loader
        mImageLoader = UniversalImageLoaderAssist.getLoader(this, 400, 400);

    }
}
