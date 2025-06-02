package com.example.education;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import de.hdodenhof.circleimageview.CircleImageView;

public class signup extends AppCompatActivity {
    private TextView loginbut;
    private EditText rg_username, rg_email, rg_num, rg_password, rg_repassword,rg_college;
    private Button rg_signup;
    private CircleImageView rg_profileImg;
    private FirebaseAuth auth;
    private FirebaseStorage storage;
    private FirebaseDatabase database;
    private String email_pattern = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}";
    private Uri imageURI;
    private String imageuri;
    private ProgressDialog progressDialog;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase instances
        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

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
        rg_password = findViewById(R.id.rgPassword);
        rg_repassword = findViewById(R.id.rgrePassword);
        rg_signup = findViewById(R.id.signupbutton);
        rg_profileImg = findViewById(R.id.rg_profileImg);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

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
            } else if (num.length() < 10) {
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
                                                Intent intent = new Intent(signup.this, MainActivity.class);
                                                startActivity(intent);
                                                finish();
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
                                    Intent intent = new Intent(signup.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(signup.this, "Error in creating the user", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    } else {
                        progressDialog.dismiss();  // Dismiss progress dialog
                        Toast.makeText(signup.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == RESULT_OK && data != null) {
            imageURI = data.getData();
            rg_profileImg.setImageURI(imageURI);
        }
    }
}
