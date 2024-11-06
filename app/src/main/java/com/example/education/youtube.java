package com.example.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class youtube extends AppCompatActivity {
    LinearLayout c20resources,c16resouces,c23resources;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_youtube );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );
        c23resources=findViewById ( R.id.c23resources );
        c23resources.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (youtube.this,c20resouces.class);
                startActivity ( intent );
            }
        } );
        c20resources=findViewById ( R.id.c20resources );
        c20resources.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (youtube.this,com.example.education.c20resouces.class);
                startActivity ( intent );
            }
        } );
        c16resouces=findViewById ( R.id.c16resources );
        c16resouces.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (youtube.this, c16resouces.class);
                startActivity ( intent );
            }
        } );
        ImageView back;
        back=findViewById ( R.id.back );
         back.setOnClickListener ( new View.OnClickListener ( ) {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent ( youtube.this, MainActivity.class );
                 startActivity ( intent );
             }
         } );
    }
}