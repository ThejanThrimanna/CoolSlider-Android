package com.apps.tdt.thejan.coolslider.helper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import com.apps.tdt.thejan.coolslider.R;
import com.squareup.picasso.Picasso;

/**
 * This is the app utils which use the image libraries to load the images in to the imageview
 */

public class AppUtils {

    public static void loadImageWithPicasoAnimNewUrl(Context context, String url, ImageView img) {

        Picasso.get()
                .load(url)
                .placeholder(img.getDrawable())
                .noFade()
                .into(img);
    }

    public static void loadImageWithPicasoAnimNewUrl(Context context, int url, ImageView img) {

        Picasso.get()
                .load(url)
                .placeholder(img.getDrawable())
                .noFade()
                .into(img);
    }

}
