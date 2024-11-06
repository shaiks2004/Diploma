package com.example.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Giudence extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_giudence );
//        ViewCompat.setOnApplyWindowInsetsListener ( findViewById ( R.id.main ), (v, insets) -> {
//            Insets systemBars = insets.getInsets ( WindowInsetsCompat.Type.systemBars ( ) );
//            v.setPadding ( systemBars.left, systemBars.top, systemBars.right, systemBars.bottom );
//            return insets;
//        } );

        ImageView carrier,cources,job,sector,moreinfo;
         carrier = findViewById(R.id.options);
         cources = findViewById(R.id.cources);
         job = findViewById(R.id.job);
         sector = findViewById(R.id.sector);
         moreinfo = findViewById(R.id.moreinfo);

    sector.setOnClickListener ( new View.OnClickListener ( ) {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent (Giudence.this, sectorGuidence.class);
            startActivity ( intent );
        }
    } );
       carrier.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (Giudence.this, carrierGuidence.class);
                startActivity ( intent );
            }
        } );
        cources.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (Giudence.this, courcesGuidence.class);
                startActivity ( intent );
            }
        } );
        job.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (Giudence.this, JobGuidence.class);
                startActivity ( intent );
            }
        } );
        moreinfo.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                String url = "https://www.collegedekho.com/articles/best-career-options-after-polytechnic/";
                Intent intent = new Intent ( Intent.ACTION_VIEW );
                intent.setData ( Uri.parse ( url ) );

                // Log the intent to check if it's correct
                Log.d ( "MoreInfoButton", "URL: " + url );

                // Check if there is an activity to handle the intent
                if (intent.resolveActivity ( getPackageManager ( ) ) != null) {
                    startActivity ( intent );
                } else {
                    // Show a Toast if no activity found
                    Toast.makeText ( Giudence.this, "No application can handle this request. Please install a web browser.", Toast.LENGTH_SHORT ).show ( );
                }
            }
        } );

    }
}