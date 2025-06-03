package com.gromagz.education;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import com.gromagz.education.HelperFiles.GlobalInterface;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class login extends AppCompatActivity {


    private static final String TAG = "LoginActivity";

    private boolean showOneTapUI = true;
    private SignInClient oneTapClient;
    private BeginSignInRequest signInRequest;

    private FirebaseAuth auth;
    private ProgressDialog progressDialog;
    private Toolbar toolBar;
    private LinearLayout btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d(TAG, "onCreate: Activity started");
        auth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
//            Log.d(TAG, "User already signed in: " + currentUser.getEmail());
//            startActivity(new Intent(this, MainActivity.class));
//            finish();
//            return;
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

// 🔁 Restore saved credentials
        SharedPreferences sharedPref = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String savedEmail = sharedPref.getString("email", "");
        String savedPassword = sharedPref.getString("password", "");

        if (!savedEmail.isEmpty()) {
            email.setText(savedEmail);
        }
        if (!savedPassword.isEmpty()) {
            password.setText(savedPassword);
        }

        _InitToolbar();
        setupOneTapLogin();

        btnGoogle.setOnClickListener(v -> beginGoogleOneTap());

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
//                        SharedPreferences sharedPref1 = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("email", Email );     // fixed
                        editor.putString("password", pass);   // fixed
                        editor.apply();

                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void setupOneTapLogin() {
        oneTapClient = Identity.getSignInClient(this);
        Log.d(TAG, "Setting up One Tap Login...");
        signInRequest = BeginSignInRequest.builder()
                .setGoogleIdTokenRequestOptions(BeginSignInRequest.GoogleIdTokenRequestOptions.builder() // CORRECTED LINE
                        .setSupported(true)
                        .setServerClientId(GlobalInterface.Web_Client_id)
                        .setFilterByAuthorizedAccounts(false) // Set to true to only show accounts already authorized for your app
                        .build())
                .setAutoSelectEnabled(true) // Set to true to automatically sign in if only one eligible account is found
                .build();
        Log.d(TAG, "One Tap sign-in request built successfully");
    }

    private void beginGoogleOneTap() {
        Log.d(TAG, "Initiating Google One Tap...");
        oneTapClient.beginSignIn(signInRequest)
                .addOnSuccessListener(this, result -> {
                    Log.d(TAG, "One Tap sign-in intent received.");
                    try {
                        startIntentSenderForResult(result.getPendingIntent().getIntentSender(),
                               GlobalInterface.REQ_ONE_TAP, null, 0, 0, 0);
                    } catch (IntentSender.SendIntentException e) {
                        Log.e(TAG, "Couldn't start One Tap UI: " + e.getLocalizedMessage());
                        Log.e("OneTap", "Couldn't start One Tap UI: " + e.getLocalizedMessage());
                    }
                })
                .addOnFailureListener(this, e -> {
                    Log.e(TAG, "One Tap failed: " + e.getLocalizedMessage());
                    Toast.makeText(this, "Google login failed", Toast.LENGTH_SHORT).show();
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GlobalInterface.REQ_ONE_TAP) {
            Log.d(TAG, "Received result from One Tap"+requestCode);
            try {
                SignInCredential credential = oneTapClient.getSignInCredentialFromIntent(data);
                String idToken = credential.getGoogleIdToken();

                if (idToken != null) {
                    firebaseAuthWithGoogle(idToken);
                } else {
                    Log.e(TAG, "ID Token is null");
                }
            } catch (ApiException e) {
                switch (e.getStatusCode()) {
                    case CommonStatusCodes.CANCELED:
                        Log.d("OneTap", "One-tap dialog was closed.");
                        showOneTapUI = false;
                        break;
                    case CommonStatusCodes.NETWORK_ERROR:
                        Log.d("OneTap", "One-tap encountered a network error.");
                        break;
                    default:
                        Log.d("OneTap", "Couldn't get credential: " + e.getLocalizedMessage());
                        break;
                }
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        progressDialog.show();
        Log.d(TAG, "Authenticating with Firebase using Google ID token...");
        auth.signInWithCredential(GoogleAuthProvider.getCredential(idToken, null))
                .addOnCompleteListener(this, task -> {
                    progressDialog.dismiss();
                    if (task.isSuccessful()) {
                        FirebaseUser user = auth.getCurrentUser();
                        Log.d(TAG, "Firebase auth successful. User: " + user.getEmail());
                        Toast.makeText(this, "Signed in as " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    } else {
                        Log.e(TAG, "Firebase auth failed: " + task.getException().getMessage());
                        Toast.makeText(this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void _InitToolbar() {
        setSupportActionBar(toolBar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("LOGIN");
        }
    }
}
