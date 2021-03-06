package com.wzes.huddle.util;

import android.app.Activity;
import android.content.Context;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.yancy.gallerypick.inter.ImageLoader;
import com.yancy.gallerypick.widget.GalleryImageView;

public class GalleryGlideImageLoader implements ImageLoader {
    public void displayImage(Activity activity, Context context, String path, GalleryImageView galleryImageView, int width, int height) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerCrop();
        Glide.with(context).load(path).apply(requestOptions).into(galleryImageView);
    }

    public void clearMemoryCache() {
    }
}
