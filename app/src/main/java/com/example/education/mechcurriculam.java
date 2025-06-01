package com.example.education;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.barteksc.pdfviewer.PDFView;

public class mechcurriculam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_mechcurriculam );
        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
            return insets;
        } );



        PDFView pdfView;
        pdfView=findViewById ( R.id.pdfview );
        pdfView.fromAsset ( "mechcu.pdf" )
                .load ();
    }
}