package com.gromagz.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class Welcome_Screen extends AppCompatActivity {
    private TextView signup,welcome_text;
    MaterialButton login;
    Animation topAnim,botomAnim;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.welcome_screen);
        TextView signup=findViewById(R.id.signupbutton);
        login=findViewById(R.id.loginbut);
        welcome_text=findViewById(R.id.welcome_text);
        signup.setText(Html.fromHtml("Don’t have an account?   <font color='#274CDE'>Sign Uu</font>"));

        topAnim= AnimationUtils.loadAnimation ( this,R.anim.topanim );
        botomAnim=AnimationUtils.loadAnimation ( this,R.anim.botomanim );

        login.setAnimation(topAnim);
        welcome_text.setAnimation(topAnim);

        singup_action(signup);
        login_action(login);
}

    private void login_action(MaterialButton login) {
    Intent intent = new Intent(Welcome_Screen.this, login.class);
    startActivity(intent);
    }

    private void singup_action(TextView signup) {
        Intent intent=new Intent(Welcome_Screen.this, signup.class);
        startActivity(intent);

    }
}