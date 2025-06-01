package com.example.education;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private FirebaseAuth auth;
    Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Check if user is already logged in
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            // User is signed in, redirect to MainActivity
            Intent intent = new Intent(login.this, MainActivity.class);
            startActivity(intent);
            finish();  // Close the login activity
            return;  // Exit onCreate to prevent showing login screen
        }

        // Set up layout insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String emailPattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}";

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);

        Button logButton = findViewById(R.id.click);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        TextView sign = findViewById(R.id.signup);
        toolBar= findViewById(R.id.ttoolbar);
        _IntiToolbar();
        sign.setOnClickListener(view -> {
            Intent red = new Intent(login.this, signup.class);
            startActivity(red);
            finish();
        });

        logButton.setOnClickListener(view -> {
            String Email = email.getText().toString();
            String pass = password.getText().toString();

            if (TextUtils.isEmpty(Email)) {
                Toast.makeText(login.this, "Enter EMAIL to continue", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(pass)) {
                Toast.makeText(login.this, "Enter PASSWORD to continue", Toast.LENGTH_SHORT).show();
            } else if (!Email.matches(emailPattern)) {
                email.setError("Invalid email format");
            } else if (pass.length() < 6) {
                Toast.makeText(this, "Password length is too short", Toast.LENGTH_SHORT).show();
            } else {
                // Show progress dialog
                progressDialog.show();

                auth.signInWithEmailAndPassword(Email, pass).addOnCompleteListener(task -> {
                    // Dismiss progress dialog
                    progressDialog.dismiss();

                    if (task.isSuccessful()) {
                        Intent intent = new Intent(login.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } else {
                        Toast.makeText(login.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void _IntiToolbar() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("LOGIN");
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id==android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
