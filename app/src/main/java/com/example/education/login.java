package com.example.education;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.education.HelperFiles.GlobalInterface;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class login extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private FirebaseAuth auth;
    private Toolbar toolBar;
    private GoogleSignInClient mGoogleSignInClient;
    private LinearLayout btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return;
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);

        MaterialButton logButton = findViewById(R.id.click);
        btnGoogle = findViewById(R.id.btn_google);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        TextView sign = findViewById(R.id.signup);
        toolBar = findViewById(R.id.ttoolbar);

        _InitToolbar();
        setupGoogleSignIn();

        btnGoogle.setOnClickListener(v -> signInWithGoogle());

        sign.setOnClickListener(view -> {
            startActivity(new Intent(this, signup.class));
            finish();
        });

        logButton.setOnClickListener(view -> {
            String Email = email.getText().toString().trim();
            String pass = password.getText().toString().trim();
            String emailPattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}";

            if (TextUtils.isEmpty(Email)) {
                Toast.makeText(this, "Enter EMAIL to continue", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(pass)) {
                Toast.makeText(this, "Enter PASSWORD to continue", Toast.LENGTH_SHORT).show();
            } else if (!Email.matches(emailPattern)) {
                email.setError("Invalid email format");
            } else if (pass.length() < 6) {
                Toast.makeText(this, "Password length is too short", Toast.LENGTH_SHORT).show();
            } else {
                progressDialog.show();
                auth.signInWithEmailAndPassword(Email, pass).addOnCompleteListener(task -> {
                    progressDialog.dismiss();
                    if (task.isSuccessful()) {
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void setupGoogleSignIn() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(GlobalInterface.web_Client_id) // Set your Web client ID from Firebase console
                .requestIdToken(GlobalInterface.web_Client_id_firebase)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }

    private void signInWithGoogle() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, GlobalInterface.Google_Signin);
    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) {
            Log.d("GoogleSignIn", "User already signed in: " + account.getDisplayName());
            updateUIForSignedInUser(account);
        } else {
            showSignInUI();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GlobalInterface.Google_Signin) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                Toast.makeText(this, "Google sign-in failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.d("Login.Java","The code coming fromt the onactivity result"+e);
                Log.d("Login.Java","The code coming fromt the onactivity result"+auth);

            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        progressDialog.show();
        auth.signInWithCredential(GoogleAuthProvider.getCredential(idToken, null))
                .addOnCompleteListener(this, task -> {
                    progressDialog.dismiss();
                    if (task.isSuccessful()) {
                        FirebaseUser user = auth.getCurrentUser();
                        Toast.makeText(this, "Signed in as " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void updateUIForSignedInUser(GoogleSignInAccount account) {
        btnGoogle.setVisibility(View.GONE);
        Toast.makeText(this, "Welcome, " + account.getDisplayName(), Toast.LENGTH_SHORT).show();
        // Uncomment below lines if you want to move to main screen after sign-in
         startActivity(new Intent(this, MainActivity.class));
         finish();
    }

    private void showSignInUI() {
        btnGoogle.setVisibility(View.VISIBLE);
    }

    private void updateUIForSignedOutUser() {
        btnGoogle.setVisibility(View.VISIBLE);
    }

    private void _InitToolbar() {
        setSupportActionBar(toolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("LOGIN");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
