package com.gromagz.education;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class curriculam extends AppCompatActivity {
    Button curriculamc20,curriculamc23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_curriculam );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );
    curriculamc20=findViewById ( R.id.curiculamc20 );
    curriculamc23=findViewById ( R.id.curiculamc23 );


    curriculamc20.setOnClickListener ( new View.OnClickListener ( ) {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent ( curriculam.this,guidencec20.class );
            startActivity ( intent );
        }
    } );
        curriculamc23.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( curriculam.this,guidencec23.class );
                startActivity ( intent );
            }
        } );
    }
}