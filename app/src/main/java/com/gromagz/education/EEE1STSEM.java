package com.gromagz.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class EEE1STSEM extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_eee1_stsem );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );

        Button c21,c22,c23;
        c21=findViewById ( R.id.c21 );
        c21.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (EEE1STSEM.this, EEE1STSEM2021.class);
                startActivity ( intent );

            }
        } );
        c22=findViewById ( R.id.c22 );
        c22.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (EEE1STSEM.this,EEE1STSEM2022.class);
                startActivity ( intent );
            }
        } );
        c23=findViewById ( R.id.c23 );
        c23.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (EEE1STSEM.this,EEE1STSEM2023.class);
                startActivity ( intent );
            }
        } );

    }
}