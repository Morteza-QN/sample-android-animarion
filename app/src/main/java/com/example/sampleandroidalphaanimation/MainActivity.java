package com.example.sampleandroidalphaanimation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //      sample AlphaAnimation       //start
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setFillAfter(true);//give stage final
        alphaAnimation.setRepeatCount(Animation.INFINITE);//repeat for ever
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.i(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i(TAG, "onAnimationEnd: ");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.i(TAG, "onAnimationRepeat: ");
            }
        });

        //          scale Animation         //start

        final ScaleAnimation scaleAnimation =
                new ScaleAnimation(1, 2, 1, 2, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setRepeatMode(Animation.REVERSE);

        //          Transaction Animation

        final TranslateAnimation translateAnimation =
                new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                                       Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0.6f);
        translateAnimation.setDuration(1500);
        translateAnimation.setFillAfter(true);
        //        translateAnimation.setInterpolator(new AccelerateInterpolator());//speed slow after fast
        //        translateAnimation.setInterpolator(new DecelerateInterpolator());//speed fast after slow
        //        translateAnimation.setInterpolator(new BounceInterpolator());//ball
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());//fast slow

        //      Rotate Animation

        final RotateAnimation rotateAnimation =
                new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(1000);

        //      AnimationSet

        final AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(1500);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setFillAfter(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);


        final ImageView imageView   = findViewById(R.id.im_main);
        View            playAnimBtn = findViewById(R.id.fab_main);
        playAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(animationSet);
                Log.i(TAG, "onClick: playAnimBtn");
            }
        });

    }
}
