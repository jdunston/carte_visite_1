package com.example.antoinerossi.workshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {


    private ImageButton enter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        enter = (ImageButton) findViewById(R.id.button);


        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent hello = new Intent(MainActivity.this,acceuil.class);
                startActivity(hello);

            }
        });
    }


}