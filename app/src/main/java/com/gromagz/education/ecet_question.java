package com.gromagz.education;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ecet_question extends AppCompatActivity {
    Button sn1, sn2, sn3, sn4, sn5;
    TextView toolkit;
    ImageView backarrow;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_ecet_question );

        // Initialize buttons
        sn1 = findViewById ( R.id.sn1 );
        sn2 = findViewById ( R.id.sn2 );
        sn3 = findViewById ( R.id.sn3 );
        sn4 = findViewById ( R.id.sn4 );
        sn5 = findViewById ( R.id.sn5 );

        toolkit = findViewById ( R.id.toolkit );
        backarrow = findViewById ( R.id.back_arrow );

        startBlinkingAnimation ();
        startColorAnimation ();


        toolkit.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String ECET = "https://ecet-sche.aptonline.in/ECET/Views/index.aspx";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(ECET));
                startActivity(intent);

            }
        } );
        backarrow.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( ecet_question.this, question_papers.class );
                startActivity ( intent );
            }
        } );

        // Set click listeners
        sn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://competitorsacademy.in/ecet-syllabus/");
            }
        });

        sn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.youtube.com/playlist?list=PLKwJ7O39XRfC6PMYSp6_8CpgXBfkBGdCw");
            }
        });

        sn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://competitorsacademy.in/ecet-chemistry/");
            }
        });

        sn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://competitorsacademy.in/ecet-all-branches-question-papers/");
            }
        });

        sn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://competitorsacademy.in/ecet-quiz/");
            }
        });
    }

    private void gotoUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
    private void startColorAnimation() {
        // Define the start and end color
        int startColor = Color.RED;
        int endColor = Color.BLUE;

        // Create a ValueAnimator for color change
        ValueAnimator colorAnimator = ValueAnimator.ofObject ( new ArgbEvaluator ( ), startColor, endColor );
        colorAnimator.setDuration ( 500 ); // Duration of color transition
        colorAnimator.setRepeatCount ( ValueAnimator.INFINITE ); // Infinite looping
        colorAnimator.setRepeatMode ( ValueAnimator.REVERSE ); // Reverse the color after each loop

        // Update the text color with the animated value
        colorAnimator.addUpdateListener ( animator -> {
            int animatedColor = (int) animator.getAnimatedValue ( );
            toolkit.setTextColor ( animatedColor );
        } );

        // Start the animation
        colorAnimator.start ( );
    }


    // Method to make the text blink
    private void startBlinkingAnimation() {
        AlphaAnimation blinkAnimation = new AlphaAnimation ( 1.0f, 0.0f ); // Full opacity to invisible
        blinkAnimation.setDuration ( 400 ); // Duration of the blink effect
        blinkAnimation.setRepeatCount ( Animation.INFINITE ); // Infinite repeat
        blinkAnimation.setRepeatMode ( Animation.REVERSE ); // Reverse after each blink

        // Start the blink animation
        toolkit.startAnimation ( blinkAnimation );
    }

}
