package com.example.education;

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

public class ECE2NDSEM extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_ece2_ndsem );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );
        Button c22,c23;

        c22=findViewById ( R.id.c2022);
        c23=findViewById ( R.id.c2023);

        c22.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (ECE2NDSEM.this,ECE3RDSEM2022.class);
                startActivity ( intent );
            }
        } );
        c23.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (ECE2NDSEM.this,ECE3RDSEM2023.class);
                startActivity ( intent );
            }
        } );

    }
}