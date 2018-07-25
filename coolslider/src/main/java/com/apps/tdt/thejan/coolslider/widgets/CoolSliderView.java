package com.apps.tdt.thejan.coolslider.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.AnimRes;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.apps.tdt.thejan.coolslider.R;
import com.apps.tdt.thejan.coolslider.helper.AppUtils;

import java.util.ArrayList;
import java.util.Random;

public class CoolSliderView extends ViewFlipper {

    Context mContext;

    ImageView mImageView1, mImageView2, mImageView3;

    ImageView.ScaleType scaleType;

    int i;

    Handler handlerImage;
    Runnable runnableImage;

    public CoolSliderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        style(context, attrs);
    }

    private void style(Context context, AttributeSet attrs){

        mImageView1 = new ImageView(mContext);
        mImageView1.setTag("1");
        mImageView2 = new ImageView(mContext);
        mImageView2.setTag("2");
        mImageView3 = new ImageView(mContext);
        mImageView3.setTag("3");

        this.addView(mImageView1);
        this.addView(mImageView2);
        this.addView(mImageView3);

        setSliderAnimation();

    }

    private void setSliderAnimation() {

        setInAnimation(mContext, R.anim.pull_in_right);
        setOutAnimation(mContext, R.anim.push_out_left);

    }

    /**
     *
     * @param mContext
     * @param imagesUrls
     * @param interval interval in seconds
     */

    public void setImageSlider(Context mContext, ArrayList<String> imagesUrls, ImageView.ScaleType scaleType, long interval, @AnimRes int inAnimation, @AnimRes int outAnimation){

        long intervalConvert = interval*1000;

        //setSliderAnimation();

        setScaleType(scaleType);

        if (imagesUrls.size() > 0) {
            if (imagesUrls.size() > 1)
                LoadSliderListUrl(mContext, imagesUrls, intervalConvert);
            else AppUtils.loadImageWithPicasoAnimNewUrl(mContext, imagesUrls.get(0), mImageView1);
        }

    }

    private void setScaleType(ImageView.ScaleType scaleType) {
        mImageView1.setScaleType(scaleType);
        mImageView2.setScaleType(scaleType);
        mImageView3.setScaleType(scaleType);
    }

    private void LoadSliderListUrl(final Context mContext, final ArrayList<String> imagesUrls, final long interval) {

        if (imagesUrls.isEmpty()) {
            Toast.makeText(mContext, "No Images Avilable", Toast.LENGTH_LONG).show();
        } else {
            if (imagesUrls.size() > 2) {
                AppUtils.loadImageWithPicasoAnimNewUrl(mContext, imagesUrls.get(0), mImageView1);
                AppUtils.loadImageWithPicasoAnimNewUrl(mContext, imagesUrls.get(1), mImageView2);
                AppUtils.loadImageWithPicasoAnimNewUrl(mContext, imagesUrls.get(2), mImageView3);
                i = 2;
            } else if (imagesUrls.size() > 1) {

                AppUtils.loadImageWithPicasoAnimNewUrl(mContext, imagesUrls.get(0), mImageView1);
                AppUtils.loadImageWithPicasoAnimNewUrl(mContext, imagesUrls.get(1), mImageView2);
                i = 1;
            }

            handlerImage = new Handler();
            runnableImage = new Runnable() {

                public void run() {
                    //mSlider.setImageResource(imageArray[i]);
                    i++;
                    if (i > imagesUrls.size() - 1) {
                        i = 0;
                    }

                    showNext();

                    switch (getCurrentView().getTag().toString()) {
                        case "1":
                            AppUtils.loadImageWithPicasoAnimNewUrl(mContext, imagesUrls.get(i), mImageView2);


                            break;
                        case "2":
                            AppUtils.loadImageWithPicasoAnimNewUrl(mContext, imagesUrls.get(i), mImageView3);

                            break;
                        case "3":
                            AppUtils.loadImageWithPicasoAnimNewUrl(mContext, imagesUrls.get(i), mImageView1);

                            break;
                    }

                    handlerImage.postDelayed(this, interval);


                }
            };
            handlerImage.postDelayed(runnableImage, interval);

        }
    }

}
