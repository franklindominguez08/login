package com.fdlsolution.firstappexample;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class ProfileActivity extends AppCompatActivity {

    Intent myintent;
    TextView myname,mymemo,myrepo,myprojects,mystars;
    Profile myprofile;
    Button btnshare;
    ImageView myImage;

    @Override
    protected void onResume() {
        super.onResume();
        if(myprofile != null) {
            this.setTitle(myprofile.getName()+" Profile");
        }
        else
        {
            this.setTitle(R.string.ProfileTittle);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        myname = findViewById(R.id.txtFullName);
        mymemo = findViewById(R.id.txtMemo);
        myrepo = findViewById(R.id.txtRepos);
        myprojects = findViewById(R.id.txtProjects);
        mystars = findViewById(R.id.txtStars);
        btnshare = findViewById(R.id.btnShare);
        myImage = findViewById(R.id.myImage);


        myintent = getIntent();
        if(myintent.hasExtra("profile")) {
             myprofile = (Profile) myintent.getExtras().getSerializable("profile");
        }

        if(myprofile != null)
        {
            myname.setText(myprofile.getName());
            mymemo.setText(myprofile.getMemo());
            myrepo.setText(String.valueOf(myprofile.getRepos()));
            myprojects.setText(String.valueOf(myprofile.getProjects()));
            mystars.setText(String.valueOf( myprofile.getStars()));

        }

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(Intent.ACTION_SEND);
                 intent.setType("image/jpeg");
                 intent.putExtra(Intent.EXTRA_STREAM,Uri.parse(MediaStore.Images.Media.EXTERNAL_CONTENT_URI+"/"+ R.drawable.employee));
                 startActivity(Intent.createChooser(intent,"Share Profile using"));
            }
        });

    }
}
