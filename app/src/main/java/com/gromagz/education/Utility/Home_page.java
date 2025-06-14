package com.gromagz.education.Utility;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.gromagz.education.BCEc21;
import com.gromagz.education.R;
import com.gromagz.education.Profile_details;
import com.gromagz.education.carrierGuidence;
import com.gromagz.education.chatbot;
import com.gromagz.education.curriculam;
import com.gromagz.education.profile_dashbord.internships;
import com.gromagz.education.login;
import com.gromagz.education.profile_dashbord.notification;
import com.gromagz.education.scholor;
import com.gromagz.education.youtube;

public class Home_page extends AppCompatActivity {


    private ImageView profile_image, notify, message, img_slider;
    private TextView Profile_User;

    private FirebaseAuth author;
//    private ImageView ;
    //nav_bar_menu


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_page);
    //bottom navigation
        BottomNavigationView nav_menu = findViewById(R.id.nav_menu);

        //id finding
        profile_image=(ImageView) findViewById(R.id.profile_image);
        notify=(ImageView) findViewById(R.id.notification_icon);
        message=(ImageView) findViewById(R.id.message);

        //the user login name will apper here
        Profile_User=findViewById(R.id.Profile_User);
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userName = FirebaseAuth.getInstance().getUid();
            if (userName != null && !userName.isEmpty()) {
                Profile_User.setText(userName);
            } else {
                Profile_User.setText("User"); // Default text if no display name is set
            }
        }

        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_page.this, Profile_details.class);
                startActivity(intent);
            }
        });
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_page.this, notification.class);
                startActivity(intent);
            }
        });
            message.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Home_page.this, Profile_details.class);
                    startActivity(intent);
                }
            });

        // Firebase Authentication
        author = FirebaseAuth.getInstance();
        if (author.getCurrentUser() == null) {
            Intent redirect = new Intent(Home_page.this, login.class);
            startActivity(redirect);
            finish();
            return;
        }

        nav_menu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.nav_home) {
                    startActivity(new Intent(Home_page.this, Home_page.class));
                    return true;
                } else if (itemId == R.id.nav_search) {
                    startActivity(new Intent(Home_page.this, youtube.class));
                    return true;
                } else if (itemId == R.id.chatbot) {
                    startActivity(new Intent(Home_page.this, chatbot.class));
                    return true;
                } else if (itemId == R.id.resourses) {
                    startActivity(new Intent(Home_page.this, carrierGuidence.class));
                    return true;
                } else if (itemId == R.id.nav_community) {
                    startActivity(new Intent(Home_page.this, BCEc21.class));
                    return true;
                }
                return false;
            }
        });



        View includedCard1 = findViewById(R.id.internship);
        TextView title1 = includedCard1.findViewById(R.id.card_title);
        ImageView img1=includedCard1.findViewById(R.id.card_image);
        img1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_internship));
        title1.setText("Apply for Internships");
        includedCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_page.this, internships.class);
                startActivity(intent);
            }
        });


        View includedCard2 = findViewById(R.id.scholorship);
        TextView title2 = includedCard2.findViewById(R.id.card_title);
        ImageView img2=includedCard2.findViewById(R.id.card_image);
        img2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_scholorship));
        title2.setText("Apply for Scholarships");
        includedCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_page.this, scholor.class);
                startActivity(intent);
            }
        });

        View includedCard3 = findViewById(R.id.contest_winner);
        TextView title3 = includedCard3.findViewById(R.id.card_title);
        ImageView img3=includedCard3.findViewById(R.id.card_image);
        img3.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_contest_winner));
        title3.setText("Apply for\nContests");
        includedCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_page.this, scholor.class);
                startActivity(intent);
            }
        });

        View includedCard4 = findViewById(R.id.carrier_guidence);
        TextView title4 = includedCard4.findViewById(R.id.card_title);
        ImageView img4=includedCard4.findViewById(R.id.card_image);
        img4.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_carrier_guidence));
        title4.setText("Carrer\nGuidence");
        includedCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_page.this, carrierGuidence.class);
                startActivity(intent);
            }
        });

        View includedCard5 = findViewById(R.id.top_colleges);
        TextView title5 = includedCard5.findViewById(R.id.card_title);
        ImageView img5=includedCard4.findViewById(R.id.card_image);
        img5.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_colleges));
        title5.setText("Top Collages\n& Universities");
        includedCard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_page.this, curriculam.class);
                startActivity(intent);
            }
        });



        //recomend for you
        View card1=findViewById(R.id.educationloan);
        TextView rec1= (TextView) (card1=findViewById(R.id.rec_title));
        rec1.setText("Education Loans");
        ImageView recimg1=(ImageView)(card1=findViewById(R.id.rec_image));
        recimg1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.home_scholorship));

        View card2=findViewById(R.id.study_tips);
        TextView rec2= (TextView) (card2=findViewById(R.id.rec_title));
        rec2.setText("Study Tips");
        ImageView recimg2=(ImageView)(card2=findViewById(R.id.rec_image));
        recimg2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_scholorship));

        View card3=findViewById(R.id.courses);
        TextView rec3= (TextView) (card3=findViewById(R.id.rec_title));
        rec3.setText("Courses");
        ImageView recimg3=(ImageView)(card3=findViewById(R.id.rec_image));
        recimg3.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_scholorship));
    }
    }
