package com.gromagz.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class diploma_question extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_diploma_question );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );
        Button c16,c20,c23;
//        c16=findViewById ( R.id.c16 );
        c20=findViewById ( R.id.c20 );
        c23=findViewById ( R.id.c23 );
//        c16.setOnClickListener ( new View.OnClickListener ( ) {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent ( diploma_question.this,regulationc16.class );
//                startActivity ( intent );
//            }
//        } );



        c20.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( diploma_question.this, regularc20.class );
                startActivity ( intent );
            }

        } );



        c23.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( diploma_question.this,regulationc23.class );
                startActivity ( intent );
            }
        } );
    }
}