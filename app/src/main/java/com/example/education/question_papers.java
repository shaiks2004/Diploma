package com.example.education;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class question_papers extends AppCompatActivity {
    Button Ecet,diploma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_question_papers );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );

        Ecet=findViewById ( R.id.ecet );
        diploma=findViewById ( R.id.diploma );


//        Ecet.setOnClickListener ( new View.OnClickListener ( ) {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent ( question_papers.this, ecet_question.class );
//                startActivity ( intent );
//            }
//        } );
        Ecet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(question_papers.this, ecet_question.class);
                    startActivity(intent);
                } catch (Exception e) {
                    Log.e("Error", "Error starting activity: " + e.getMessage());
                }
            }
        });

        diploma.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( question_papers.this, diploma_question.class );
                startActivity ( intent );
            }
        } );
    }
}