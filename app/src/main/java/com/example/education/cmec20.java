package com.example.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cmec20 extends AppCompatActivity {
    Button c21,c22,c23;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_cmec20 );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );

        c21=findViewById ( R.id.c21);
        c22=findViewById ( R.id.c22);
        c23=findViewById ( R.id.c2023);

        c21.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( cmec20.this, C21question.class );
                startActivity ( intent );
            }
        } );

        c22.setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent ( cmec20.this, c22question.class );
                    startActivity ( intent );
                }
            } );
        c23.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( cmec20.this, c23question.class );
                startActivity ( intent );
            }
        } );

    }
}