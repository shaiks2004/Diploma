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

public class regularc20EEEbranchlist extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_regularc20_eeebranchlist );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );


        Button sem1,sem3,sem4,sem5;
        sem1=findViewById ( R.id.sem1 );
        sem1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (  regularc20EEEbranchlist.this, EEE1STSEM.class);
                startActivity ( intent );
            }
        } );
        sem3=findViewById ( R.id.sem3 );
        sem3.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (  regularc20EEEbranchlist.this, EEE2NDSEM.class);
                startActivity ( intent );
            }
        } );
        sem4=findViewById ( R.id.sem4 );
        sem4.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (regularc20EEEbranchlist.this,EEE4THSEM.class);
                startActivity ( intent );
            }
        } );
        sem5=findViewById ( R.id.sem5 );
        sem5.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( regularc20EEEbranchlist.this,EEE5THSEM.class );
                startActivity ( intent );
            }
        } );
    }
}