package com.example.antoinerossi.workshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class acceuil extends AppCompatActivity {

    private EditText mdp_co;        // Mot de passe de connexion
    private EditText mail_co;       // Mail connexion
    private EditText mdp_insc;     // Mot de passe inscription
    private EditText mail_insc;    // Mail inscription
    private EditText confir;       // Confirmation mot de passe
    private Button co;             // Bouton pour entrer dans l'application
    private Button inscription;

    private DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        /// On affecte les elements graphiques aux variables

        mail_co = (EditText) findViewById(R.id.mail_connexion);
        mail_insc = (EditText) findViewById(R.id.mail_inscription);
        mdp_co = (EditText) findViewById(R.id.mdp_connexion);
        mdp_insc = (EditText) findViewById(R.id.mdp_inscription);
        confir = (EditText) findViewById(R.id.confirmdp);
        co = (Button) findViewById(R.id.connexion);
        inscription = (Button) findViewById(R.id.inscription);


        /// On desactive les autres boutons si l'utilisateur n'a rien saisi
        co.setEnabled(false);
        /// Si l'utilisateur saisi dans connexion ou inscription bouton debloqué
        mdp_co.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                co.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent enter = new Intent(acceuil.this, profil.class);
                startActivity(enter);

            }
        });


        inscription.setEnabled(false);

        confir.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inscription.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                public long addIdentification(mail_insc, mdp_insc);
                    Intent enter = new Intent(acceuil.this, profil.class);
                    enter.putExtra("pk", pk);
                    startActivity(enter);
                }

            }
        });

        databaseHandler = new DatabaseHandler(this);

    }

    public EditText getMail_insc() {
        return mail_insc;
    }

    public void setMail_insc(EditText mail_insc) {
        this.mail_insc = mail_insc;
    }

    public EditText getMdp_insc() {
        return mdp_insc;
    }

    public void setMdp_insc(EditText mdp_insc) {
        this.mdp_insc = mdp_insc;
    }

    public EditText getMdp_co() {
        return mdp_co;
    }

    public void setMdp_co(EditText mdp_co) {
        this.mdp_co = mdp_co;
    }

    public EditText getConfir() {
        return confir;
    }

    public void setConfir(EditText confir) {
        this.confir = confir;
    }
}
