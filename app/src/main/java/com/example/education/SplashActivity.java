package com.example.education;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashActivity extends AppCompatActivity {
private ImageView logoimg;
private  TextView logoname,logobutton;
Animation topAnim,botomAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_splash );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );
        logoimg=findViewById ( R.id.imglogo );
        logoname=findViewById ( R.id.logoname );
        logobutton=findViewById ( R.id.logobottom );


        topAnim= AnimationUtils.loadAnimation ( this,R.anim.topanim );
        botomAnim=AnimationUtils.loadAnimation ( this,R.anim.botomanim );

        logoimg.setAnimation ( topAnim );
        logoname.setAnimation ( topAnim );
        logobutton.setAnimation ( botomAnim );



        new Handler ().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent( SplashActivity.this , Welcome_Screen.class);
                startActivity(splash);
                finish ();
            }
        }, 3000);

    }
    }