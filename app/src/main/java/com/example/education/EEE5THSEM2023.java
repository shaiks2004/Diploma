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

public class EEE5THSEM2023 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_eee5_thsem2023 );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );

        ImageView IMST,EM3,PS3,PE,DEE,EUT;
        IMST=findViewById ( R.id.IMST );
        EM3=findViewById ( R.id.EM3 );
        PS3=findViewById ( R.id.PS3 );
        PE=findViewById ( R.id.PE );
        DEE=findViewById ( R.id.DEE );
        EUT=findViewById ( R.id.EUT );

        IMST.setOnClickListener(new View.OnClickListener (){
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/17Sd1X-EID3Ko4IMtlLaHZG2s9KN6Hpu7/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );

        EM3.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/17T3hTUvjUXFG8uRuONuDfF8paDr4SzoF/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        PS3.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl ="https://drive.google.com/file/d/17VgY_NL2YqfcM4uQTmnusj7NfzwNEUf3/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        PE.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/17au2Mif--ElYWrcNEejQix-kjM_7jPRC/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        DEE.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/17clzOjW2gYHKN9Q4y7wjEn_s6Hx0mVKe/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
        EUT.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/17kPJSia8y3eX6yxb9HNYIPDuDQcV7j74/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);
            }
        } );
    }
}