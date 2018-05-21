package com.example.antoinerossi.workshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class carte extends AppCompatActivity {



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
        setContentView(R.layout.activity_carte);



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
                Intent pro = new Intent(carte.this,profil.class);
                startActivity(pro);
            }
        });

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nouv = new Intent(carte.this,ajout.class);
                startActivity(nouv);
            }
        });

        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rep = new Intent(carte.this,repertoire.class);
                startActivity(rep);
            }
        });
    }
}
