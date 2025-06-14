package com.gromagz.education.profile_dashbord;

import static com.gromagz.education.network.ApiClient.retrofit;

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

import com.gromagz.education.Adapters.InternshipAdapter;
import com.gromagz.education.Models.internship_model;
import com.gromagz.education.R;
import com.gromagz.education.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class internships extends AppCompatActivity {
     private Toolbar toolbar;
     RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_internships);
        toolbar = findViewById(R.id.ttoolbar);

        ApiClient api = retrofit.create(InternshipAPI.class);

        Call<List<internship_model>> call = api.getInternships();

        call.enqueue(new Callback<List<internship_model>>() {
            @Override
            public void onResponse(Call<List<internship_model>> call, Response<List<internship_model>> response) {
                if (response.isSuccessful()) {
                    List<internship_model> internships = response.body();
                    adapter = new InternshipAdapter(InternshipActivity.this, internships);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(InternshipActivity.this, "Failed to load", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<internship_model>> call, Throwable t) {
                Toast.makeText(InternshipActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("RETROFIT", "onFailure: ", t);
            }
        });



        recyclerView=findViewById(R.id.recyclerViewInternships);
        InternshipAdapter adapter = new InternshipAdapter(this, internshiplist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        _InitToolbar();

    }

    private void _InitToolbar() {
//        getActionBar().setTitle("Internships");
//        getActionBar().setHomeButtonEnabled(true);
    }

}




