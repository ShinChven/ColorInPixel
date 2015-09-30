package net.atlassc.ShinChven.colorinpixel;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.cache.disc.impl.LimitedAgeDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by ShinChven on 15/4/15.
 */
public class UniversalImageLoaderAssist {

    /**
     * 快速获得默认options
     *
     * @return
     */
    public static DisplayImageOptions loadQuickOptions() {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.nopicture_x3) // resource or drawable
//                .showImageForEmptyUri(R.drawable.nopicture_x3) // resource or drawable
//                .showImageOnFail(R.drawable.nopicture_x3) // resource or drawable
                .resetViewBeforeLoading(true)  // default
                .delayBeforeLoading(0)
                .cacheInMemory(false) // default
                .cacheOnDisk(true) // default
//                .preProcessor(...)
//                .postProcessor(...)
//                .extraForDownloader(...)
                .considerExifParams(true) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
//                .decodingOptions(...)
                .displayer(new SimpleBitmapDisplayer()) // default
                .handler(new Handler()) // default
                .build();
        return options;
    }

    public static DisplayImageOptions loadQuickOptions(int defaultRes) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(defaultRes) // resource or drawable
                .showImageForEmptyUri(defaultRes) // resource or drawable
                .showImageOnFail(defaultRes) // resource or drawable
                .resetViewBeforeLoading(true)  // default
                .delayBeforeLoading(0)
                .cacheInMemory(false) // default
                .cacheOnDisk(true) // default
//                .preProcessor(...)
//                .postProcessor(...)
//                .extraForDownloader(...)
                .considerExifParams(true) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_4444) // default
//                .decodingOptions(...)
                .displayer(new SimpleBitmapDisplayer()) // default
                .handler(new Handler()) // default
                .build();
        return options;
    }


    /**
     * 快速获得默认options
     *
     * @return
     */
    public static DisplayImageOptions loadFadeInOptionsWithDefault() {

        DisplayImageOptions options = new DisplayImageOptions.Builder()

                .resetViewBeforeLoading(true)  // default
                .delayBeforeLoading(0)
                .cacheInMemory(false) // default
                .cacheOnDisk(true) // default
//                .preProcessor(...)
//                .postProcessor(...)
//                .extraForDownloader(...)
                .considerExifParams(true) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
//                .decodingOptions(...)
                .displayer(new FadeInBitmapDisplayer(500)) // default
                .handler(new Handler()) // default
                .build();
        return options;
    }

    /**
     * 快速获得默认options
     *
     * @return
     */
    public static DisplayImageOptions loadFadeInOptionsWithDefault(int defaultRes) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(defaultRes) // resource or drawable
                .showImageForEmptyUri(defaultRes) // resource or drawable
                .showImageOnFail(defaultRes) // resource or drawable
                .resetViewBeforeLoading(true)  // default
                .delayBeforeLoading(0)
                .cacheInMemory(false) // default
                .cacheOnDisk(true) // default
//                .preProcessor(...)
//                .postProcessor(...)
//                .extraForDownloader(...)
                .considerExifParams(true) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
//                .decodingOptions(...)
                .displayer(new FadeInBitmapDisplayer(100)) // default
                .handler(new Handler()) // default
                .build();
        return options;
    }

    /**
     * 快速获得默认options
     *
     * @return
     */
    public static DisplayImageOptions loadFadeInOptions() {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.nopicture_x3) // resource or drawable
//                .showImageForEmptyUri(R.drawable.nopicture_x3) // resource or drawable
//                .showImageOnFail(R.drawable.nopicture_x3) // resource or drawable
                .resetViewBeforeLoading(true)  // default
                .delayBeforeLoading(0)
                .cacheInMemory(false) // default
                .cacheOnDisk(true) // default
//                .preProcessor(...)
//                .postProcessor(...)
//                .extraForDownloader(...)
                .considerExifParams(true) // default
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
//                .decodingOptions(...)
                .displayer(new FadeInBitmapDisplayer(0)) // default
                .handler(new Handler()) // default
                .build();
        return options;
    }

//    public static DisplayImageOptions getCircleDisplayOptions(int borderColor, int borderWidth) {
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .resetViewBeforeLoading(true)  // default
//                .delayBeforeLoading(0)
//                .cacheInMemory(false) // default
//                .cacheOnDisk(true) // default
//                .considerExifParams(false) // default
//                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
//                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
//                .displayer(new CircleBitmapDisplayer(borderColor, borderWidth)) // default
//                .handler(new Handler()) // default
//                .build();
//        return options;
//    }
//
//    public static DisplayImageOptions getCircleDisplayOptionsWithDefault(int borderColor, int borderWidth, int defaultDrawable) {
//        DisplayImageOptions options = new DisplayImageOptions.Builder()
//                .showImageOnLoading(defaultDrawable) // resource or drawable
//                .showImageForEmptyUri(defaultDrawable) // resource or drawable
//                .showImageOnFail(defaultDrawable) // resource or drawable
//                .resetViewBeforeLoading(true)  // default
//                .delayBeforeLoading(0)
//                .cacheInMemory(false) // default
//                .cacheOnDisk(true) // default
//                .considerExifParams(false) // default
//                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // default
//                .bitmapConfig(Bitmap.Config.ARGB_8888) // default
//                .displayer(new CircleBitmapDisplayer(borderColor, borderWidth)) // default
//                .handler(new Handler()) // default
//                .build();
//        return options;
//    }


    /**
     * 圆角狂魔
     *
     * @param context
     * @param cornerRadiusPixels
     * @param marginPixels
     * @return
     */
    public static ImageLoader getRoundedBitmapLoader(Context context, int cornerRadiusPixels, int marginPixels) {
        RoundedBitmapDisplayer displayer = new RoundedBitmapDisplayer(cornerRadiusPixels, marginPixels);
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .displayer(displayer)
                .build();
        File cacheDir = StorageUtils.getCacheDirectory(context);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
                .diskCacheExtraOptions(480, 800, null)
                .threadPoolSize(3) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCache(new LimitedAgeDiskCache(cacheDir, 30 * 24 * 60 * 60 * 1000)) // default
                .imageDownloader(new BaseImageDownloader(context)) // default
                .imageDecoder(new BaseImageDecoder(false)) // default
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .defaultDisplayImageOptions(options) // default
                .writeDebugLogs()
                .build();

        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
        return imageLoader;
    }

    /**
     * 获得默认配置的loader.
     *
     * @param context
     * @return
     */
    public static ImageLoader getLoader(Context context) {
        File cacheDir = StorageUtils.getCacheDirectory(context);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(100, 100) // default = device screen dimensions
                .diskCacheExtraOptions(100, 100, null)
                .threadPoolSize(6) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(5 * 2 * 1024 * 1024))
                .memoryCacheSize(5 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCache(new LimitedAgeDiskCache(cacheDir, 30 * 24 * 60 * 60 * 1000)) // default
                .imageDownloader(new BaseImageDownloader(context)) // default
                .imageDecoder(new BaseImageDecoder(false)) // default
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .defaultDisplayImageOptions(loadQuickOptions()) // default
                .writeDebugLogs()
                .build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
        return imageLoader;
    }

    /**
     * 获得默认配置的loader.
     *
     * @param context
     * @return
     */
    public static ImageLoader getLoader(Context context, int maxWidth, int maxHeight) {
        File cacheDir = StorageUtils.getCacheDirectory(context);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(maxWidth, maxHeight) // default = device screen dimensions
                .diskCacheExtraOptions(maxWidth, maxHeight, null)
                .threadPoolSize(6) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(5 * 2 * 1024 * 1024))
                .memoryCacheSize(5 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCache(new LimitedAgeDiskCache(cacheDir, 30 * 24 * 60 * 60 * 1000)) // default
                .imageDownloader(new BaseImageDownloader(context)) // default
                .imageDecoder(new BaseImageDecoder(false)) // default
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .defaultDisplayImageOptions(loadQuickOptions()) // default
                .writeDebugLogs()
                .build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
        return imageLoader;
    }

    /**
     * 获得默认配置的loader.
     *
     * @param activity
     * @return
     */
    public static ImageLoader getLoader(Context activity, DisplayUtil.DisplayMatrix displayMatrix) {
        File cacheDir = StorageUtils.getCacheDirectory(activity);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(activity)
                .memoryCacheExtraOptions(displayMatrix.width, displayMatrix.height) // default = device screen dimensions
                .diskCacheExtraOptions(displayMatrix.width, displayMatrix.height, null)
                .threadPoolSize(6) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(5 * 2 * 1024 * 1024))
                .memoryCacheSize(5 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCache(new LimitedAgeDiskCache(cacheDir, 30 * 24 * 60 * 60 * 1000)) // default
                .imageDownloader(new BaseImageDownloader(activity)) // default
                .imageDecoder(new BaseImageDecoder(false)) // default
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .defaultDisplayImageOptions(loadQuickOptions()) // default
                .writeDebugLogs()
                .build();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
        return imageLoader;
    }


}
