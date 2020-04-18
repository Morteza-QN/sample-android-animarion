package com.example.sampleandroidalphaanimation;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //          sample AlphaAnimation
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setRepeatCount(Animation.INFINITE);//repeat for ever
        alphaAnimation.setFillAfter(true);//give stage final
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

        //scale Animation


        final ImageView imageView   = findViewById(R.id.im_main);
        View            playAnimBtn = findViewById(R.id.fab_main);
        playAnimBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(alphaAnimation);
                Log.i(TAG, "onClick: playAnimBtn");
            }
        });

    }
}
