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

import com.github.barteksc.pdfviewer.PDFView;

public class guidencec20 extends AppCompatActivity {
    Button cme,ece,eee,mech,civil;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_guidencec20 );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );

        cme=findViewById ( R.id.cme );
        ece=findViewById ( R.id.ece );
        eee=findViewById ( R.id.eee );
        mech=findViewById ( R.id.mech );
        civil=findViewById ( R.id.civil );

        cme.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( guidencec20.this, cmecurriculam.class );
                startActivity ( intent );
            }
        } );
        ece.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (guidencec20.this,ececurriculam.class);
                startActivity ( intent );
            }
        } );
        eee.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (guidencec20.this,eeecurriculam.class);
                startActivity ( intent );
            }
        } );
        mech.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( guidencec20.this,mechcurriculam.class );
                startActivity ( intent );
            }
        } );

        civil.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( guidencec20.this,civilcurriculam.class );
                startActivity ( intent );
            }
        } );

    }
}