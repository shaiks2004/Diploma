package com.gromagz.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.gromagz.education.Utility.Home_page;

public class Welcome_Screen extends AppCompatActivity {
    private TextView signup, welcome_text;
    private MaterialButton login;

    private String Tag = "Welcome Screen .java";
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.welcome_screen);

        Log.d(Tag, "The onCreate method in Welcome Screen started");

        mAuth = FirebaseAuth.getInstance();

        checkUserStatus();

        initializeViews();



        setupClickListeners();
    }

    private void checkUserStatus() {
        // Check if user is already authenticated with Firebase
        FirebaseUser currentUser = mAuth.getCurrentUser();

        // Check if user has completed onboarding (using SharedPreferences)
        SharedPreferences prefs = getSharedPreferences("user_prefs", MODE_PRIVATE);
        boolean isFirstTime = prefs.getBoolean("is_first_time", true);
        boolean hasCompletedProfile = prefs.getBoolean("profile_completed", false);

        if (currentUser != null && hasCompletedProfile) {
            // User is logged in and has completed profile, go to main activity
            Log.d(Tag, "User already logged in, redirecting to main activity");
            startActivity(new Intent(Welcome_Screen.this, Home_page.class));
            finish();
            return;
        } else if (currentUser != null && !hasCompletedProfile) {
            // User is logged in but hasn't completed profile, go to profile setup
            Log.d(Tag, "User logged in but profile incomplete");
            // You can redirect to profile completion activity here
            // startActivity(new Intent(Welcome_Screen.this, ProfileSetup.class));
            // finish();
            // return;
        }

        // If we reach here, show the welcome screen (new user or not fully set up)
        Log.d(Tag, "Showing welcome screen for new/incomplete user");
    }

    private void initializeViews() {
        signup = findViewById(R.id.signupbutton);
        login = findViewById(R.id.loginbut);
        welcome_text = findViewById(R.id.welcome_text);

        // Set styled text for signup
        signup.setText(Html.fromHtml("Don't have an account?   <font color='#5D3CAA'>Sign Up</font>"));
    }



    private void setupClickListeners() {
        // Login button click
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAction();
            }
        });

        // Signup text click
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupAction();
            }
        });
    }

    private void loginAction() {
        Log.d(Tag, "Login button clicked");
        Intent intent = new Intent(Welcome_Screen.this, login.class);
        startActivity(intent);
    }

    private void signupAction() {
        Log.d(Tag, "Signup button clicked");
        Intent intent = new Intent(Welcome_Screen.this, signup.class);
        startActivity(intent);
    }



    // Call this method when user successfully completes login/signup
    public static void markUserAsLoggedIn(AppCompatActivity activity) {
        SharedPreferences prefs = activity.getSharedPreferences("user_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("is_first_time", false);
        editor.putBoolean("profile_completed", true);
        editor.apply();
    }
}