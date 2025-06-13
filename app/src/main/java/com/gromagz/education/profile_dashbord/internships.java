package com.gromagz.education.profile_dashbord;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gromagz.education.R;

import java.util.ArrayList;
import java.util.List;

public class internships extends AppCompatActivity {
     private Toolbar toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_internships);
        toolbar = findViewById(R.id.ttoolbar);

        _InitToolbar();

    }

    private void _InitToolbar() {
//        getActionBar().setTitle("Internships");
//        getActionBar().setHomeButtonEnabled(true);
    }

}




