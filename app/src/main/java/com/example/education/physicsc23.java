package com.example.education;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.barteksc.pdfviewer.PDFView;

public class physicsc23 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_physicsc23 );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );

        PDFView p1,p2;
        p1=findViewById ( R.id.p1 );
        p2=findViewById ( R.id.p2 );
        p1.fromAsset ( "C20-CM-103-JAN-2023.pdf" )
                .load ();

        p2.fromAsset ( "C20-C-CM-103-MAY-2023-1.pdf" )
                .load ();
    }
}