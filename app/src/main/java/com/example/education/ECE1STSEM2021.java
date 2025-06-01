package com.example.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ECE1STSEM2021 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_ece1_stsem2021 );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );
        ImageView english,M1,physics,chemistry,ECPS,EEE,drawing;
        english=findViewById ( R.id.english );
        M1=findViewById ( R.id.M1 );
        physics=findViewById ( R.id.physics );
        chemistry=findViewById ( R.id.chemistry );
        ECPS=findViewById ( R.id.ECPS );
        EEE=findViewById ( R.id.EEE );
        drawing=findViewById ( R.id.drawing );

        english.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/151sjXIUFBv7fYAyQiTyUqVtDpTlwu4RR/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);

            }
        } );
        M1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/159tYGi8BR54SISH6F7Gq2w_sOQVz5OXt/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);

            }
        } );
        physics.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/15AFcuMh7vZB1vSa1o9j2bLJMQibAcfqx/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);

            }
        } );
        chemistry.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/15DkgvILdcmG0eCSa9VknjizFfVB0Whxo/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);

            }
        } );
        ECPS.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/15EpD6mpEszrsV6vkKhwu6h4mGSS7Cn1a/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);

            }
        } );
        EEE.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/15IrfdaFuOj4AyOTx3hHlZFv5Zvbs3nQ8/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);

            }
        } );
        drawing.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/15PXFxEPB3YEL9bRuv5DKTYW6Yxiv2vXD/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);

            }
        } );



    }
}