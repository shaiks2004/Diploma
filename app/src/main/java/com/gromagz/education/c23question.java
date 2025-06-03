package com.gromagz.education;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class c23question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_c23question );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );
        ImageView english,M1,physics,chemistry,BCE,program,drawing;
        english=findViewById ( R.id.english );
        M1=findViewById ( R.id.M1 );
       physics=findViewById ( R.id.Physics);
        chemistry=findViewById ( R.id.chemistry );
        BCE=findViewById ( R.id.BCE );
        program=findViewById ( R.id.program );
        drawing=findViewById ( R.id.drawing );

        english.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( c23question.this, Englishc23.class );
                startActivity ( intent );
            }
        } );
        M1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( c23question.this,M1c23.class );
                startActivity ( intent );
            }
        } );
        physics.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( c23question.this,physicsc23.class );
                startActivity ( intent );
            }
        } );
        chemistry.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( c23question.this,chemistryc23.class );
                startActivity ( intent );
            }
        } );
        BCE.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (c23question.this,BCEc23.class);
                startActivity ( intent );
            }
        } );
        program.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (c23question.this,prgramc23.class);
                startActivity ( intent );
            }
        } );
        drawing.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( c23question.this,drawingc23.class );
                startActivity ( intent );
            }
        } );
    }
}