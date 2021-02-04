package com.demotxt.myapp.myapplication.activities;

import android.content.Intent;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;



import com.demotxt.myapp.myapplication.R;


public class MainActivity extends AppCompatActivity {
    private Button FindRestaurantsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FindRestaurantsButton = (Button)findViewById(R.id.findRestaurantsButton);
        FindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, about.class);
                startActivity(intent);

            }

        });
            }
        };

