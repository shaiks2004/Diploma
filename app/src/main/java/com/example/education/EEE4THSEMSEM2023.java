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

public class EEE4THSEMSEM2023 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_eee4_thsemsem2023 );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );


        ImageView M3,EM2,PS2,EIAE,EE,GME,EED2;
        M3=findViewById ( R.id.M3 );
        EM2=findViewById ( R.id.EM2 );
        PS2=findViewById ( R.id.PS2 );
        EIAE=findViewById ( R.id.EIAE );
        EE=findViewById ( R.id.EE );
        GME=findViewById ( R.id.GME );
        EED2=findViewById ( R.id.EED2 );

        M3.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/16TzjOdOhu3ePlD7eHPbZpzCoZ1DhZZ4R/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );

        EM2.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/16WKXObFHfjNYc2S3ZoDWr77XLyhg5r7A/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        PS2.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/16fSH_l9Wb4qz941PjZ1X1-GTRGDaDaDZ/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        EIAE.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/16rmoz3oNCrkeqMwbi7g6EledvgIuWhX6/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        EE.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/17-WfH1QxfJ1v3A95rOatINvdaWXCUNLg/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        GME.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/170SU-MLkiVw-CUaMIfGlDg7CY1YTSlYO/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        EED2.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/171UpKoPxovFjrqP5_EPt9RZ1Mygl4YZq/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );

    }
}