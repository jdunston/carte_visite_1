package com.example.antoinerossi.workshare;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ajout extends AppCompatActivity {


    private ImageButton without;
    private ImageButton qrcode;
    private ImageButton meeting;
    private ImageButton manuelajout;
    private ImageButton rep;
    private ImageButton ajout;
    private ImageButton profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);




        rep = (ImageButton) findViewById(R.id.repertoir);
        ajout = (ImageButton) findViewById(R.id.plus);
        profil = (ImageButton) findViewById(R.id.pro);
        without = (ImageButton) findViewById(R.id.nocontact);
        qrcode = (ImageButton) findViewById(R.id.code);
        manuelajout = (ImageButton) findViewById(R.id.manuel);
        meeting = (ImageButton) findViewById(R.id.mode);

        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent prof = new Intent(ajout.this,profil.class);
                startActivity(prof);
            }
        });

        manuelajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent manu = new Intent(ajout.this,ajoutmanuel.class);
                startActivity(manu);
            }
        });

        rep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rep = new Intent(ajout.this,repertoire.class);
                startActivity(rep);
            }
        });

    }
}
