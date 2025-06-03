package com.gromagz.education;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.api.identity.SignInClient;
import com.google.android.gms.auth.api.identity.SignInCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.gromagz.education.HelperFiles.GlobalInterface;

import de.hdodenhof.circleimageview.CircleImageView;

public class signup extends AppCompatActivity {
    private TextView loginbut;
    private EditText rg_username, rg_email, rg_num, rg_password, rg_repassword,rg_college;
    private Button rg_signup;
    private CircleImageView rg_profileImg;
    private FirebaseAuth auth;
    private RelativeLayout layout2;
    private FirebaseStorage storage;
    private Toolbar toolBar;
    private FirebaseDatabase database;
    private String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}";
    private Uri imageURI;
    private String imageuri;
    private ProgressDialog progressDialog;
    private static final String TAG = "Signup";
    private LinearLayout btnGoogle;
    private boolean showOneTapUI = true;
    private SignInClient oneTapClient;
    private BeginSignInRequest signInRequest;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase instances
        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();
        Log.d(TAG, "onCreate: Activity started");

        // Initialize ProgressDialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing up, please wait...");
        progressDialog.setCancelable(false);

        // Check if user is already logged in
        FirebaseUser currentUser = auth.getCurrentUser();
        if (currentUser != null) {
            // User is signed in, redirect to MainActivity
            Intent intent = new Intent(signup.this, MainActivity.class);
            startActivity(intent);
            finish();  // Close the signup activity
            return;  // Exit onCreate to prevent showing signup screen
        }

        // Initialize UI components
        loginbut = findViewById(R.id.loginbut);
        rg_username = findViewById(R.id.rgusername);
        rg_email = findViewById(R.id.rgemail);
        rg_college=findViewById ( R.id.college );
        rg_num = findViewById(R.id.rgnum);
        toolBar = findViewById(R.id.ttoolbar);
        rg_password = findViewById(R.id.rgPassword);
        rg_repassword = findViewById(R.id.rgrePassword);
        rg_signup = findViewById(R.id.signupbutton);
        rg_profileImg = findViewById(R.id.rg_profileImg);
        btnGoogle=findViewById(R.id.btn_google);


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        _InitToolbar();
        setupOneTapLogin();
        beginGoogleOneTap(btnGoogle);
        TextView loginbut = findViewById(R.id.loginbut);
        loginbut.setText(Html.fromHtml("Already have an account?  <font color='#274CDE'>Log in</font>"));

        // Navigate to login activity
        loginbut.setOnClickListener(view -> {
            Intent intent = new Intent(signup.this, login.class);
            startActivity(intent);
            finish();
        });

        // Sign up button logic
        rg_signup.setOnClickListener(view -> {
            String namee = rg_username.getText().toString();
            String emaill = rg_email.getText().toString();
            String college=rg_college.getText ().toString ();
            String num = rg_num.getText().toString();
            String Password = rg_password.getText().toString();
            String cPassword = rg_repassword.getText().toString();

            if (TextUtils.isEmpty(namee) || TextUtils.isEmpty(emaill) || TextUtils.isEmpty(Password) || TextUtils.isEmpty(cPassword)) {
                Toast.makeText(signup.this, "Please check the details", Toast.LENGTH_SHORT).show();
            } else if (!emaill.matches(email_pattern)) {
                rg_email.setError("Invalid email format");
            } else if (college.length ()<4) {
                rg_college.setError ( "Give the college Full name!" );
            } else if (Password.length() < 6) {
                rg_password.setError("Password must be at least 6 characters");
            } else if (!Password.equals(cPassword)) {
                rg_password.setError("Passwords do not match");
            } else if (num.length() <10) {
                rg_num.setError("Phone number is incorrect");
            } else {
                progressDialog.show();  // Show progress dialog

                auth.createUserWithEmailAndPassword(emaill, Password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        String id = task.getResult().getUser().getUid();
                        DatabaseReference reference = database.getReference().child("user").child(id);
                        StorageReference storageReference = storage.getReference().child("Upload").child(id);

                        if (imageURI != null) {
                            storageReference.putFile(imageURI).addOnCompleteListener(uploadTask -> {
                                if (uploadTask.isSuccessful()) {
                                    storageReference.getDownloadUrl().addOnSuccessListener(uri -> {
                                        imageuri = uri.toString();
                                        Users users = new Users(id, namee, emaill, college,num, Password, imageuri, "Hey new user loged");
                                        reference.setValue(users).addOnCompleteListener(userTask -> {
                                            progressDialog.dismiss();  // Dismiss progress dialog
                                            if (userTask.isSuccessful()) {


//                                                Intent intent = new Intent(signup.this, MainActivity.class);
//                                                startActivity(intent);
//                                                finish();
                                                    Log.d("Signup.java", "User created with details: " +
                                                            "ID = " + id + ", " +
                                                            "Name = " + namee + ", " +
                                                            "Email = " + emaill + ", " +
                                                            "College = " + college + ", " +
                                                            "Phone = " + num + ", " +
                                                            "Password = " + Password + ", " +
                                                            "Image URI = " + imageuri + ", " +
                                                            "Status = Hey new user logged");
                                                  } else {
                                                Toast.makeText(signup.this, "Error in creating the user", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    });
                                } else {
                                    progressDialog.dismiss();  // Dismiss progress dialog
                                    Toast.makeText(signup.this, "Error uploading image", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            imageuri = "https://firebasestorage.googleapis.com/v0/b/splash-screeen-3f2a4.appspot.com/o/user.png?alt=media&token=494856ac-1501-44ea-a2d0-2ab9d80618d6";
                            Users users = new Users(id, namee, emaill,college, num, Password, imageuri, "new user is loged in ");
                            reference.setValue(users).addOnCompleteListener(userTask -> {
                                progressDialog.dismiss();  // Dismiss progress dialog
                                if (userTask.isSuccessful()) {

                                    Log.d("Signup.java", "User created with details: " +
                                            "ID = " + id + ", " +
                                            "Name = " + namee + ", " +
                                            "Email = " + emaill + ", " +
                                            "College = " + college + ", " +
                                            "Phone = " + num + ", " +
                                            "Password = " + Password + ", " +
                                            "Image URI = " + imageuri + ", " +
                                            "Status = Hey new user logged");
//                                    Intent intent = new Intent(signup.this, MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
                                    setContentView(R.layout.setup_password);



                                } else {
                                    Toast.makeText(signup.this, "Error in creating the user", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    } else {
                        progressDialog.dismiss();  // Dismiss progress dialog
                        Toast.makeText(signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(this,"mail bosidka",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        // Profile image click listener
        rg_profileImg.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 10);
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

    private void beginGoogleOneTap(LinearLayout btnGoogle) {

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

    private void _InitToolbar() {
        setSupportActionBar(toolBar);
        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("SIGNUP");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==GlobalInterface.REQ_ONE_TAP && resultCode == RESULT_OK && data != null) {
            imageURI = data.getData();
            rg_profileImg.setImageURI(imageURI);
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
}
