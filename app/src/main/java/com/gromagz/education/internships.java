package com.gromagz.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class internships extends AppCompatActivity {
    Button applynow;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_internships );

        applynow=findViewById ( R.id.applynow );
        applynow.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.naukri.com/polytechnic-jobs");
            }

            private void gotoUrl(String url) {
                Uri uri = Uri.parse(url);
               startActivity(new Intent (Intent.ACTION_VIEW, uri));
            }
        } );


    }
}