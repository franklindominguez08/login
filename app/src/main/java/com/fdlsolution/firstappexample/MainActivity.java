package com.fdlsolution.firstappexample;

import android.content.Intent;
import android.os.Parcelable;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MainActivity extends AppCompatActivity {

    EditText username ;
    EditText password;
    Button btnAccess;
    ArrayList<Profile> profiles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
 */       setContentView(R.layout.activity_main);


        username = findViewById(R.id.txtUser);
        password = findViewById(R.id.txtPassword);
        btnAccess = findViewById(R.id.btnAccess);
        profiles = new ArrayList<>();

        profiles.add(new Profile("Franklin Dominguez","I am a Software Developer Specialized in Web Development","franklin",300,200,100,"123"));
        profiles.add(new Profile("Yamell García","I am a Software Developer Girl Specialized in Android Development","yamellgarcia@gmail.com",100,100,500,"12345"));
        profiles.add(new Profile("Wilson Reyes","I am a Software Developer Specialized in c# Development","wilsonreyes@gmail.com",500,400,100,"123"));

        if(btnAccess != null)
        {
            btnAccess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(username != null)
                    {
                        //Log.i("MSJ","Ya entro al click");
                        if(username.getText().equals("") || username.getText().length()==0 )
                        {
                          //  Log.i("MSJ","Ya entro cuando es vacio");
                            Toast myToast = Toast.makeText(getApplicationContext(),"Can not be an EMPTY email",Toast.LENGTH_LONG);
                            myToast.setGravity(Gravity.CENTER,0,0);
                            myToast.show();
                        }
                        else
                        {
                            int existss = 0;
                            for(Profile p : profiles)
                            {
                                if(p.getEmail().toLowerCase().equals(username.getText().toString().toLowerCase()) && p.getPassword().equals(password.getText().toString()))
                                {
                                    existss = 1;
                                    try {
                                        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                                        Bundle bunlde = new Bundle();
                                        bunlde.putSerializable("profile",p);
                                        intent.putExtras(bunlde);
                                        startActivity(intent);
                                    }
                                    catch (Exception ex)
                                    {
                                        Log.i("Error en intent",ex.getMessage());
                                    }
                                }
                            }

                            if(existss==0)
                            {
                                Toast myToast = Toast.makeText(getApplicationContext(),"Invalid username/password",Toast.LENGTH_LONG);
                                myToast.setGravity(Gravity.CENTER,0,0);
                                myToast.show();
                            }
                        }

                    }
                }
            });
        }
    }


}
