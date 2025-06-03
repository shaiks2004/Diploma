package com.gromagz.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class c20resouces extends AppCompatActivity {

    private EditText searchInput;
    private Button searchButton;
    private CardView cardM1, cardPhysics, cardChemistry, cardCProgramming, cardCFB, cardCFP;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_c16resouces);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find each CardView by ID
        cardM1 = findViewById(R.id.m1);
        cardPhysics = findViewById(R.id.physics);
        cardChemistry = findViewById(R.id.chemistry);
        cardCProgramming = findViewById(R.id.program);
        cardCFB = findViewById(R.id.card_cfb);
        cardCFP = findViewById(R.id.cfp);

        // Initialize search EditText and Button
        searchInput = findViewById(R.id.search_input);
        searchButton = findViewById(R.id.search_button);

        // Set OnClickListener for search button
        searchButton.setOnClickListener(v -> {
            String query = searchInput.getText().toString().trim().toLowerCase();
            if (!query.isEmpty()) {
                search(query);
            }
        });

        // Set OnClickListener for each CardView
        cardM1.setOnClickListener(v -> openLink("https://www.youtube.com/results?search_query=naveen+reddy+maths"));
        cardPhysics.setOnClickListener(v -> openLink("https://www.youtube.com/results?search_query=diploma+c20+physics+"));
        cardChemistry.setOnClickListener(v -> openLink("https://www.youtube.com/watch?v=0X4AAkQCgBY&list=PLcUNSjfrXkxPKVEjTGWjL1gU1Z3u4_QfL"));
        cardCProgramming.setOnClickListener(v -> openLink("https://www.youtube.com/watch?v=C5GCFEMcIGQ&list=PLqleLpAMfxGBn9v-K17ztBfNXHzPnX5sN"));
        cardCFB.setOnClickListener(v -> openLink("https://www.youtube.com/watch?v=W7-u_w-0zHc&list=PLqleLpAMfxGAkXyW-QIwBPYDXpxAmb5La"));
        cardCFP.setOnClickListener(v -> openLink("https://www.youtube.com/watch?v=7J6P-93CDBk&list=PLqleLpAMfxGCNYZtZ03-dZiALgBQ_yNrL"));
    }

    // Helper method to open a link in a browser
    private void openLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    // Helper method for search functionality
    private void search(String query) {
        boolean isFound = false;

        // Set all cards to invisible first
        cardM1.setVisibility(View.GONE);
        cardPhysics.setVisibility(View.GONE);
        cardChemistry.setVisibility(View.GONE);
        cardCProgramming.setVisibility(View.GONE);
        cardCFB.setVisibility(View.GONE);
        cardCFP.setVisibility(View.GONE);

        // Show the card if the query matches a keyword
        if ("maths".contains(query) || "m1".contains(query)) {
            cardM1.setVisibility(View.VISIBLE);
            isFound = true;
        }
        if ("physics".contains(query)) {
            cardPhysics.setVisibility(View.VISIBLE);
            isFound = true;
        }
        if ("chemistry".contains(query)) {
            cardChemistry.setVisibility(View.VISIBLE);
            isFound = true;
        }
        if ("programming".contains(query) || "c programming".contains(query)) {
            cardCProgramming.setVisibility(View.VISIBLE);
            isFound = true;
        }
        if ("cfb".contains(query)) {
            cardCFB.setVisibility(View.VISIBLE);
            isFound = true;
        }
        if ("cfp".contains(query)) {
            cardCFP.setVisibility(View.VISIBLE);
            isFound = true;
        }

        if (!isFound) {
            // Display a message or a placeholder indicating no results found
            searchInput.setError("No matching card found");
        }
    }
}
