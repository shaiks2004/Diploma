package com.example.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class regulationc23 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_regulationc23 );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );
        CardView cme,ece,eee,civil,mech;
        cme=findViewById ( R.id.cme );
        ece=findViewById ( R.id.ece23 );
        eee=findViewById ( R.id.eee );
        civil=findViewById ( R.id.civil );
        mech=findViewById ( R.id.mech );


        ece.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (regulationc23.this, ecec23questions.class);
                startActivity ( intent );
            }
        } );
        cme.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (regulationc23.this, csec23questions.class);
                startActivity ( intent );
            }
        } );
        eee.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Toast.makeText ( regulationc23.this, "coming soon working on that", Toast.LENGTH_SHORT ).show ( );
            }
        } );
        civil.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Toast.makeText ( regulationc23.this, "coming soon working on that", Toast.LENGTH_SHORT ).show ( );
            }
        } );
        mech.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Toast.makeText ( regulationc23.this, "coming soon working on that", Toast.LENGTH_SHORT ).show ( );
            }
        } );


    }
}