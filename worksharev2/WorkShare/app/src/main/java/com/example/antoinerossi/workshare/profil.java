package com.example.antoinerossi.workshare;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Arrays;

public class profil extends AppCompatActivity {
    private Button carte;
    private Button perso;
    private ImageButton rep;
    private ImageButton ajout;
    private ImageButton profil;

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        carte = (Button) findViewById(R.id.macarte);
        perso = (Button) findViewById(R.id.personalisation);
        rep = (ImageButton) findViewById(R.id.repertoir);
        ajout = (ImageButton) findViewById(R.id.plus);
        profil = (ImageButton) findViewById(R.id.pro);

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent more = new Intent(profil.this,ajout.class);
                startActivity(more);

            }
        });

        carte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ma = new Intent(profil.this,carte.class);
                startActivity(ma);

            }
        });

        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rep = new Intent(profil.this,repertoire.class);
                startActivity(rep);
            }
        });

        databaseHandler = new DatabaseHandler(this);

        Log.d("!!!!", databaseHandler.getIdentification(
                getIntent().getLongExtra("pk", 0)).toString());

        Log.d("!!!!", Arrays.toString(databaseHandler.getAllIdentifications().toArray()));

    }
}
