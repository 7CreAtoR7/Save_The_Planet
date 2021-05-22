package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class splash extends AppCompatActivity {

    ImageView appname, splashimg;
    LottieAnimationView lottieAnimationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        appname = findViewById(R.id.app_name_main);
        splashimg = findViewById(R.id.img);
        lottieAnimationView = findViewById(R.id.lottie);

        splashimg.animate().translationY(-2500).setDuration(1000).setStartDelay(3000);
        appname.animate().translationY(-2000).setDuration(1000).setStartDelay(3000);
        lottieAnimationView.animate().translationY(1500).setDuration(1000).setStartDelay(3000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash.this, MainActivity.class));
            }
        }, 4000);


    }
}