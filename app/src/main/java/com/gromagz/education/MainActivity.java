package com.gromagz.education;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.gromagz.education.profile_dashbord.internships;

public class MainActivity extends AppCompatActivity {
    private int[] images = {R.drawable.slider1, R.drawable.slider2, R.drawable.diplomasilder};
    private ViewPager2 viewPager;
    private Handler sliderHandler = new Handler(Looper.getMainLooper());
    private ImageView share,sbtet;

    private FirebaseAuth author;

    public FloatingActionButton bot;
    LinearLayout b1, b2, b3, internship, scholorship,carrier,about;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Firebase Authentication
        author = FirebaseAuth.getInstance();
        if (author.getCurrentUser() == null) {
            Intent redirect = new Intent(MainActivity.this, login.class);
            startActivity(redirect);
            finish();
            return;
        }

        // for sharing of the app
        share = findViewById(R.id.share);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareContent();
            }
        });
        sbtet=findViewById (  R.id.sbtet);
        sbtet.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                openLink("https://sbtet.ap.gov.in/APSBTET/");
            }

            private void openLink(String url) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData( Uri.parse(url));
                startActivity(intent);
            }
        } );

        // ViewPager2 setup for image slider
        viewPager = findViewById(R.id.viewPager);
        ImageSliderAdapter adapter = new ImageSliderAdapter(this, images);
        viewPager.setAdapter(adapter);

        b1 = findViewById(R.id.btn1);
        b1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, question_papers.class);
            startActivity(intent);
        });

        b2 = findViewById(R.id.btn2);
        b2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, curriculam.class);
            startActivity(intent);
        });

        b3 = findViewById(R.id.btn3);
        b3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, youtube.class);
            startActivity(intent);
        });

        bot = findViewById(R.id.chatbot);
        if (bot != null) {
            bot.setOnClickListener(view -> {
                Intent intent = new Intent(MainActivity.this, chatbot.class);
                startActivity(intent);
            });
        } else {
            Toast.makeText(this, "Error occurring at bot", Toast.LENGTH_SHORT).show();
        }

        internship = findViewById(R.id.internship);
        internship.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, internships.class);
            startActivity(intent);
        });

        scholorship = findViewById(R.id.scholorship);
        scholorship.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, scholor.class);
            startActivity(intent);
        });
        carrier=findViewById ( R.id.carrier );
        carrier.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent ( MainActivity.this,Giudence.class );
                startActivity ( intent );
            }
        } );
        about=findViewById ( R.id.about );
        about.setOnClickListener ( new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (MainActivity.this, Profile_details.class);
                startActivity ( intent );
            }
        } );

        // Image slider logic
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                // Reset position to 0 if last page is reached (for infinite looping)
                if (position == images.length - 1) {
                    sliderHandler.postDelayed(() -> viewPager.setCurrentItem(0, true), 3000); // Slide back to the first image after 3 seconds
                } else {
                    sliderHandler.removeCallbacks(sliderRunnable);
                    sliderHandler.postDelayed(sliderRunnable, 2000); // Slide every 2 seconds
                }
            }
        });
    }

    private final Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            int nextItem = viewPager.getCurrentItem() + 1;
            // Check if we've reached the end of the list, if so loop back to the first image
            if (nextItem >= images.length) {
                viewPager.setCurrentItem(0, true); // Loop back to the start
            } else {
                viewPager.setCurrentItem(nextItem, true);
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable); // Stop sliding when the activity is paused
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 2000); // Resume sliding when the activity is resumed
    }

    private void shareContent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        String shareSubject = "Check out this Polytechnic Diploma!";
        String shareBody = "Hey, I found this amazing Polytechnic Diploma content. Check it out! " +
                "+ \"https://play.google.com/store/apps/details?id=com.gromagz.education\";";

        shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}
