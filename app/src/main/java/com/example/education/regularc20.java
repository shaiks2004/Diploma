package com.example.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class regularc20 extends AppCompatActivity {
CardView cme,ece,eee,mech,civil;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_regularc20 );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );
        cme=findViewById ( R.id.cme );
        ece=findViewById ( R.id.ece );
        eee=findViewById ( R.id.eee );
        mech=findViewById ( R.id.mech );
        civil=findViewById ( R.id.civil );
        cme.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (regularc20.this , regularc20branchlist.class);
                startActivity ( intent );
            }
        } );
        ece.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (regularc20.this , regularc20ECEbranchlist.class);
                startActivity ( intent );
            }
        } );
        eee.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (regularc20.this , regularc20EEEbranchlist.class);
                startActivity ( intent );
            }
        } );
        mech.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
//                Intent intent=new Intent (regularc20.this , cmec20.class);
//                startActivity ( intent );
                Toast.makeText ( regularc20.this, "Comming soon working on that", Toast.LENGTH_SHORT ).show ( );
            }
        } );
        civil.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Toast.makeText ( regularc20.this, "Comming soon our team working on that", Toast.LENGTH_LONG ).show ( );
//                Intent intent=new Intent (regularc20.this , cmec20.class);
//                startActivity ( intent );
            }
        } );
    }
}