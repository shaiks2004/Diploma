package com.example.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class c22question extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_c22question );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );

        ImageView english,M1,physics,chemistry,BCE,program,drawing;
        english=findViewById ( R.id.english );
        M1=findViewById ( R.id.M1 );
        physics=findViewById ( R.id.Phy );

        chemistry=findViewById ( R.id.chemistry );
        BCE=findViewById ( R.id.BCE );
        program=findViewById ( R.id.program );
        drawing=findViewById ( R.id.drawing );

        english.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( c22question.this, Englishc22.class );
                startActivity ( intent );
            }
        } );
        M1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( c22question.this,M1c22.class );
                startActivity ( intent );
            }
        } );
        physics.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( c22question.this,physicsc22.class );
                startActivity ( intent );
            }
        } );
        chemistry.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( c22question.this,chemistryc22.class );
                startActivity ( intent );
            }
        } );
        BCE.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (c22question.this,BCEc22.class);
                startActivity ( intent );
            }
        } );
        program.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (c22question.this,prgramc22.class);
                startActivity ( intent );
            }
        } );
        drawing.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( c22question.this,drawingc22.class );
                startActivity ( intent );
            }
        } );
    }
}