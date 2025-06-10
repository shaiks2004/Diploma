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
import com.gromagz.education.R;

public class Home_page extends AppCompatActivity {


    private ImageView profile_image, notify, message, img_slider;
    private TextView Profile_User;

//    private ImageView ;
    //nav_bar_menu


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.home_page);
        BottomNavigationView nav_menu = findViewById(R.id.bottom_navigation);
        Bottom_Nav_Action(nav_menu);

        View includedCard1 = findViewById(R.id.internship);
        TextView title1 = includedCard1.findViewById(R.id.card_title);
        ImageView img1=includedCard1.findViewById(R.id.card_image);
        img1.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_internship));
        title1.setText("Apply for Internships");

        View includedCard2 = findViewById(R.id.scholorship);
        TextView title2 = includedCard2.findViewById(R.id.card_title);
        ImageView img2=includedCard2.findViewById(R.id.card_image);
        img2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_scholorship));
        title2.setText("Apply for Scholarships");

        View includedCard3 = findViewById(R.id.contest_winner);
        TextView title3 = includedCard3.findViewById(R.id.card_title);
        ImageView img3=includedCard3.findViewById(R.id.card_image);
        img3.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_contest_winner));
        title3.setText("Participate in\ncontests and\nwin");

        View includedCard4 = findViewById(R.id.carrier_guidence);
        TextView title4 = includedCard4.findViewById(R.id.card_title);
        ImageView img4=includedCard4.findViewById(R.id.card_image);
        img4.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_carrier_guidence));
        title4.setText("Carrer\nGuidence");

        View includedCard5 = findViewById(R.id.top_colleges);
        TextView title5 = includedCard5.findViewById(R.id.card_title);
        ImageView img5=includedCard4.findViewById(R.id.card_image);
        img5.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_colleges));
        title5.setText("Top Collages\n& Universities");



        //recomend for you
        View card1=findViewById(R.id.educationloan);
        TextView rec1= (TextView) (card1=findViewById(R.id.rec_title));
        rec1.setText("Education\nLoans");
        ImageView recimg1=(ImageView)(card1=findViewById(R.id.rec_image));
        recimg1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.home_scholorship));

        View card2=findViewById(R.id.educationloan);
        TextView rec2= (TextView) (card2=findViewById(R.id.rec_title));
        rec2.setText("Education\nLoans");
        ImageView recimg2=(ImageView)(card2=findViewById(R.id.rec_image));
        recimg2.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_scholorship));

        View card3=findViewById(R.id.educationloan);
        TextView rec3= (TextView) (card3=findViewById(R.id.rec_title));
        rec3.setText("Education\nLoans");
        ImageView recimg3=(ImageView)(card3=findViewById(R.id.rec_image));
        recimg3.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.home_scholorship));
    }

    void Bottom_Nav_Action(BottomNavigationView nav) {
        nav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    Intent home = new Intent(Home_page.this, Home_page.class);
                    startActivity(home);

                    return true;
//                case R.id.nav_search:
//                    Intent search = new Intent(Home_page.this, Home_page.class);
//                    return true;
//                case R.id.chatbot:
//                    Intent chatbot = new Intent(Home_page.this, Home_page.class);
//                    return true;
//                case R.id.resourses:
//                    Intent resourse = new Intent(Home_page.this, Home_page.class);
//                    return true;
//                case R.id.nav_community:
//                    Intent comminity = new Intent(Home_page.this, Home_page.class);
//                    return true;
            }
            return false;
        });


    }

}
