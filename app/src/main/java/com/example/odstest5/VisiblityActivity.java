package com.example.odstest5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class VisiblityActivity extends AppCompatActivity {

    LinearLayout l1,l2;
    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visiblity);

        l1=findViewById(R.id.l1);
        l2=findViewById(R.id.l2);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);

        login.setBackgroundColor(getResources().getColor(R.color.pink));
        signup.setBackgroundColor(getResources().getColor(R.color.gray));
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.setBackgroundColor(getResources().getColor(R.color.pink));
                signup.setBackgroundColor(getResources().getColor(R.color.gray));
                l1.setVisibility(View.VISIBLE);
                l2.setVisibility(View.GONE);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup.setBackgroundColor(getResources().getColor(R.color.pink));
                login.setBackgroundColor(getResources().getColor(R.color.gray));
                l2.setVisibility(View.VISIBLE);
                l1.setVisibility(View.GONE);
            }
        });
    }

   /* public void login(View view) {
        l1.setVisibility(View.VISIBLE);
        l2.setVisibility(View.GONE);
    }

    public void signup(View view) {
        l2.setVisibility(View.VISIBLE);
        l1.setVisibility(View.GONE);
    }*/
}