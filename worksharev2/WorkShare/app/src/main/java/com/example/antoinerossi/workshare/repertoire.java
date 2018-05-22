package com.example.antoinerossi.workshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;



public class repertoire extends AppCompatActivity {


    private ImageButton rep;
    private ImageButton ajout;
    private ImageButton profil;
    private carte;

    public List<carte> getallcarte();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repertoire);


        rep = (ImageButton) findViewById(R.id.repertoir);
        ajout = (ImageButton) findViewById(R.id.plus);
        profil = (ImageButton) findViewById(R.id.pro);
        String nom;
        String prenom;
        String mail;
        String num;
        String entreprise;



        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prof = new Intent(repertoire.this,profil.class);
                startActivity(prof);
            }
        });

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ajout = new Intent(repertoire.this,ajout.class);
                startActivity(ajout);
            }
        });
    }
}
