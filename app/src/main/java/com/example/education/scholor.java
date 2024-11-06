package com.example.education;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class scholor extends AppCompatActivity {
    private TextView brightmind, featured, iet, global, educationloan, pragati, NEC, saksham, aicte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholor);

        // Set up insets for edge-to-edge support
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize TextViews
        brightmind = findViewById(R.id.brightmind);
        featured = findViewById(R.id.featured);
        iet = findViewById(R.id.iet);
        global = findViewById(R.id.global);
        educationloan = findViewById(R.id.educationloan);
        pragati = findViewById(R.id.pragati);
        NEC = findViewById(R.id.NEC);
        saksham = findViewById(R.id.saksham);
        aicte = findViewById(R.id.aicte);

        // Apply animations
        applyBlinkingAndColorChange(brightmind);
        applyBlinkingAndColorChange(featured);
        applyBlinkingAndColorChange(iet);
        applyBlinkingAndColorChange(global);
        applyBlinkingAndColorChange(educationloan);
        applyBlinkingAndColorChange(pragati);
        applyBlinkingAndColorChange(NEC);
        applyBlinkingAndColorChange(saksham);
        applyBlinkingAndColorChange(aicte);

        // Set OnClickListeners for each TextView
        brightmind.setOnClickListener(view -> gotoUrl("https://www.buddy4study.com/article/bright-minds-scholarship"));
        featured.setOnClickListener(view -> gotoUrl("https://www.buddy4study.com/article/featured-scholarship"));
        iet.setOnClickListener(view -> gotoUrl("https://www.buddy4study.com/article/iet-scholarship"));
        global.setOnClickListener(view -> gotoUrl("https://www.buddy4study.com/article/global-scholarship"));
        educationloan.setOnClickListener(view -> gotoUrl("https://www.buddy4study.com/article/education-loan-scholarship"));
        pragati.setOnClickListener(view -> gotoUrl("https://www.buddy4study.com/scholarship/aicte-pragati-scholarship-for-girls"));
        NEC.setOnClickListener(view -> gotoUrl("https://scholarships.gov.in/"));
        saksham.setOnClickListener(view -> gotoUrl("https://www.buddy4study.com/article/saksham-scholarship-scheme#:~:text=The%20financial%20assistance%20rendered%20under,%2C%20software%2C%20equipment%2C%20etc."));
        aicte.setOnClickListener(view -> gotoUrl("https://www.aicte-india.org/bureaus/rifd/Scholarship-Schemes"));
    }

    // Helper method to open URLs
    private void gotoUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    // Method to apply blinking and color change animations
    private void applyBlinkingAndColorChange(TextView textView) {
        // Create a blinking effect
        ObjectAnimator blinkAnimation = ObjectAnimator.ofFloat(textView, "alpha", 0f, 1f);
        blinkAnimation.setDuration(400); // 500ms for one blink cycle
        blinkAnimation.setInterpolator(new LinearInterpolator());
        blinkAnimation.setRepeatCount(ObjectAnimator.INFINITE);
        blinkAnimation.setRepeatMode(ObjectAnimator.REVERSE);

        // Create a color change effect
        ValueAnimator colorAnimation = ValueAnimator.ofArgb(Color.RED, Color.GREEN); // Change colors as needed
        colorAnimation.setDuration(500); // Duration should match the alpha animation
        colorAnimation.setInterpolator(new LinearInterpolator());
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);

        colorAnimation.addUpdateListener(animator -> {
            int color = (int) animator.getAnimatedValue();
            textView.setTextColor(color); // Set the color of the text
        });

        // Start both animations
        blinkAnimation.start();
        colorAnimation.start();
    }
}
