package com.apps.tdt.thejan.coolslidersample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.apps.tdt.thejan.coolslider.widgets.CoolSliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    CoolSliderView coolSliderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coolSliderView =  findViewById(R.id.coolslide);
        ArrayList<String> imagesUrls = new ArrayList<>();
        imagesUrls.add("https://upload.wikimedia.org/wikipedia/commons/9/96/Nature_celebrating_India.png");
        imagesUrls.add("http://www.pngmart.com/files/4/Car-PNG-HD.png");
        imagesUrls.add("https://www.thestanleypng.com/wp-content/uploads/2016/12/executive-rooms2.jpg");
        imagesUrls.add("https://www.pixelstalk.net/wp-content/uploads/2016/03/3D-Wallpapers-Beautiful-Nature-Background-HD.jpg");
        imagesUrls.add("http://wallvie.com/wp-content/uploads/2017/02/awesome-hd-desktop-background-nature-full-pics-backgrounds-spring-of-androids.jpg");
        imagesUrls.add("https://www.planwallpaper.com/static/images/autumn-picture-wallpaper-nature-background-66907.jpg");
        imagesUrls.add("https://www.planwallpaper.com/static/images/nature-background-images2.jpg");
        imagesUrls.add("http://www.kanhangadvartha.com/data/out/101/IMG_951445.jpg");
        imagesUrls.add("http://www.kanhangadvartha.com/data/out/103/IMG_1102407.jpg");
        imagesUrls.add("http://www.kanhangadvartha.com/data/out/103/IMG_1102417.jpg");
        imagesUrls.add("http://1.bp.blogspot.com/-dOpeuYQqXjc/Ua63pLHycjI/AAAAAAAAAU0/zkRAzRuaQxQ/s1600/Beautiful+Trees+Full+HD+Wallpapers++%5BSet+1%5D+1920x1080s.jpg");
        imagesUrls.add("https://workwallpaper.com/wp-content/uploads/2018/03/Nature-Android-Phone-HD-Wallpapers-1024x559.jpg");
        imagesUrls.add("https://www.devicespecifications.com/images/editor_review/3b6347/IMG_20170919_130247.jpg");
        imagesUrls.add("http://www.portoalegre.travel/upload/b/23/239495_best-high-quality-wallpapers.jpg");
        imagesUrls.add("http://s1.1zoom.me/big3/736/Seasons_Autumn_Trees_500617.jpg");
        imagesUrls.add("http://s1.1zoom.me/big3/226/Austria_Mountains_Forests_Grasslands_Tyrol_Alps_541870_5000x3000.jpg");
        imagesUrls.add("http://s1.1zoom.me/big3/756/386986-svetik.jpg");

        coolSliderView.setImageSlider(this, imagesUrls, ImageView.ScaleType.CENTER_CROP, 10, R.anim.pull_in_right, R.anim.push_out_left);
    }
}
