package com.gromagz.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class csec23questions extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_csec23questions );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );
        ImageView english,M1,Physics,chemistry,BCE,program,drawing;
        english=findViewById ( R.id.english );
        M1=findViewById ( R.id.M1 );
        Physics=findViewById ( R.id.Physics );
        chemistry=findViewById ( R.id.chemistry );
        BCE=findViewById ( R.id.BCE );
        program=findViewById ( R.id.program );
        drawing=findViewById ( R.id.drawing );

        english.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
//                String pdfUrl = "";
//                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
//                startActivity(intent);
                Toast.makeText ( csec23questions.this, "The Papers are not uploaded", Toast.LENGTH_SHORT ).show ( );

            }
        } );
        M1.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
//                String pdfUrl = "";
//                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
//                startActivity(intent);
                Toast.makeText ( csec23questions.this, "The Papers are not uploaded", Toast.LENGTH_SHORT ).show ( );

            }
        } );
        Physics.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Toast.makeText ( csec23questions.this, "The Papers are not uploaded yet", Toast.LENGTH_SHORT ).show ( );
            }
        } );
        chemistry.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/127_-28fK1NCMr_d-4SSa3eJz_6HGwBs0/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);

            }
        } );
        BCE.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String pdfUrl = "https://drive.google.com/file/d/126RdqzNqPDZG2CB5gXolkOul2uXRWhNo/view?usp=sharing";
                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
                startActivity(intent);

            }
        } );
        program.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
//                String pdfUrl = "";
//                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
//                startActivity(intent);
                Toast.makeText ( csec23questions.this, "The Papers are not Uploaded Yet", Toast.LENGTH_SHORT ).show ( );
            }
        } );
        drawing.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
//                String pdfUrl = "https://drive.google.com/file/d/11nSgHjq0i443SIEHd_nkmhx76tdNtQ8_/view?usp=drive_link";
//                Intent intent = new Intent( Intent.ACTION_VIEW, Uri.parse(pdfUrl));
//                startActivity(intent);
                Toast.makeText ( csec23questions.this, "The Papers are not Uploaded Yet", Toast.LENGTH_SHORT ).show ( );

            }
        } );
    }
}