package com.gromagz.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

public class aboutus extends AppCompatActivity {

    private EditText reviewEditText;
    private RatingBar ratingBar;
    private LinearLayout share, emailButton, ratingButton;
    private FirebaseDatabase database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);



         share = findViewById(R.id.share);
         emailButton = findViewById(R.id.email);


        database = FirebaseDatabase.getInstance();

        // Share button click listener
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareContent();
            }

            private void shareContent() {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareSubject = "Check out this Polytechnic Diploma!";
                String shareBody = "Hey, I found this amazing Polytechnic Diploma content. Check it out! " +
                        "https://play.google.com/store/apps/details?id=com.gromagz.education";

                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

                startActivity(Intent.createChooser(shareIntent, "Share via"));
            }
        });

        // Rating button click listener
//        ratingButton.setOnClickListener(v -> {
//            float rating = ratingBar.getRating();
//
//            if (rating == 0.0f) {
//                Toast.makeText(this, "Please select a rating", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            saveRatingToFirebase(rating);
//            Toast.makeText(this, "Rating submitted successfully!", Toast.LENGTH_SHORT).show();
//        });

        // Email button click listener
        emailButton.setOnClickListener(v -> {
            String email = "sau8476@gmail.com";
            sendEmail(email, "Contact from About Us", "Please provide your message here...");
        });
    }

//    private void saveRatingToFirebase(float rating) {
//        DatabaseReference ratingsRef = database.getReference("ratings");
//        String key = ratingsRef.push().getKey();
//        Rating newRating = new Rating(rating);
//        ratingsRef.child(key).setValue(newRating);
//    }

    private void sendEmail(String recipient, String subject, String messageBody) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");  // This MIME type helps to filter only email clients
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, messageBody);

        try {
            startActivity(Intent.createChooser(intent, "Send email via"));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "No email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }


}
