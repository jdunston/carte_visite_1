package com.example.antoinerossi.workshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class ajoutmanuel extends AppCompatActivity {

    private EditText nom;
    private EditText prenom;
    private EditText entreprise;
    private EditText tel;
    private EditText mail;
    private ImageButton rep;
    private ImageButton ajout;
    private ImageButton profil;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoutmanuel);



        private DatabaseHandler databaseHandler;


        rep = (ImageButton) findViewById(R.id.repertoir);
        ajout = (ImageButton) findViewById(R.id.plus);
        profil = (ImageButton) findViewById(R.id.pro);
        nom = (EditText) findViewById(R.id.nom);
        prenom = (EditText) findViewById(R.id.prenom);
        entreprise = (EditText) findViewById(R.id.boite);
        tel = (EditText) findViewById(R.id.tel);
        mail = (EditText) findViewById(R.id.mail);


        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent prof = new Intent(ajoutmanuel.this,profil.class);
                startActivity(prof);
            }
        });

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCarte( prenom,  nom ,  tel, entreprise, mail);

                Intent ajout = new Intent(ajoutmanuel.this,ajout.class);
                startActivity(ajout);
            }
        });

        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rep = new Intent(ajoutmanuel.this,repertoire.class);
                startActivity(rep);
            }
        });

    }
}
