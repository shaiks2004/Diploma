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

public class EEE2NDSEM2023 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_eee2_ndsem2023 );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );
        ImageView M2,EM1,PS1,EEMI,EC,C,EED;
        M2=findViewById ( R.id.M2 );
        EM1=findViewById ( R.id.EM1 );
        PS1=findViewById ( R.id.PS1 );
        EEMI= findViewById ( R.id.EEMI );
        EC=findViewById ( R.id.EC );
        C=findViewById ( R.id.C );
        EED=findViewById ( R.id.EED );

        M2.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/15fnCYHIT-5kwY_k7dAnkF61puisDYuZU/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );

        EM1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/15d9rh2FGNaUy2EMafyDyJASwSNeP7SgV/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        PS1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/15j77nU5b52VDFhdr6lC-7sp_Y5RYi93C/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        EEMI.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        EC.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/15n8EKXQoduX6898uN2L0vqFOuLdbHEwa/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        C.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/15s3BEEq7wepKjt428f2LsoJKjJQ15J1B/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        EED.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/15v0QupCtVt8UeLXnzAX2MXx0RcU1se-o/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
    }
}