package com.example.antoinerossi.workshare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.antoinerossi.workshare.model.Identification;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String IDENTIFICATION_KEY = "ID";
    public static final String IDENTIFICATION_NOM = "NOM";
    public static final String IDENTIFICATION_MDP = "MDP";

    public static final String CARTE_KEY = "REGISTER";
    public static final String CARTE_FOREIGNKEY = "ID_UTI";
    public static final String CARTE_NOM = "NOM";
    public static final String CARTE_PRENOM = "PRENOM";
    public static final String CARTE_NUM = "NUM";
    public static final String CARTE_ENTREPRISE = "ENTREPRISE";
    public static final String CARTE_MAIL = "MAIL";


    public static final String IDENTIFICATION_TABLE_NAME = "IDENTIFICATION";
    public static final String CARTE_TABLE_NAME = "CARTE";


    public static final String IDENTIFICATION_TABLE_CREATE =
            "CREATE TABLE " + IDENTIFICATION_TABLE_NAME + " (" +
                    IDENTIFICATION_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    IDENTIFICATION_NOM + " TEXT, " +
                    IDENTIFICATION_MDP + " TEXT) ;";

    public static final String CARTE_TABLE_CREATE =
            "CREATE TABLE " + CARTE_TABLE_NAME + " ( " +
                    CARTE_KEY + "INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    CARTE_FOREIGNKEY+ "INTEGRER"
                    + CARTE_NOM + "TEXT"
                    + CARTE_PRENOM + "TEXT"
                    + CARTE_NUM + "TEXT"
                    + CARTE_ENTREPRISE + "TEXT"
                    + CARTE_MAIL + "TEXT ) ;";

    public static final String IDENTIFICATION_TABLE_DROP = "DROP TABLE IF EXISTS " + IDENTIFICATION_TABLE_NAME + ";";
    public static final String CARTE_TABLE_DROP = "DROP TABLE IF EXISTS " + CARTE_TABLE_NAME + ";";

    private SQLiteDatabase readDatabase;
    private SQLiteDatabase writeDatabase;

    public DatabaseHandler(Context context) {
        super(context, "acceuil", null, 1);

        readDatabase = getReadableDatabase();
        writeDatabase = getWritableDatabase();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(IDENTIFICATION_TABLE_DROP);
        db.execSQL(CARTE_TABLE_DROP);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(IDENTIFICATION_TABLE_CREATE);
        db.execSQL(CARTE_TABLE_CREATE);
    }

    public long addIdentification(String name, String mdp) {
        ContentValues values = new ContentValues();
        values.put(IDENTIFICATION_NOM, name);
        values.put(IDENTIFICATION_MDP, mdp);

        long pk = writeDatabase.insertWithOnConflict(IDENTIFICATION_TABLE_NAME, null, values,
                SQLiteDatabase.CONFLICT_REPLACE);

        return pk;
    }
    public long addCarte(String prenom, String nom , String num, String entreprise, String mail ) {
        ContentValues values = new ContentValues();
        values.put(CARTE_NOM, nom);
        values.put(CARTE_PRENOM, prenom);
        values.put(CARTE_MAIL, mail);
        values.put(CARTE_ENTREPRISE, entreprise);
        values.put(CARTE_FOREIGNKEY, IDENTIFICATION_KEY);

        long pk = writeDatabase.insertWithOnConflict( CARTE_TABLE_NAME, null, values,
                SQLiteDatabase.CONFLICT_REPLACE);

        return pk;
    }

    public Identification getIdentification(long idPk) {
        Cursor c = readDatabase.query(IDENTIFICATION_TABLE_NAME,
                new String[] {IDENTIFICATION_NOM, IDENTIFICATION_MDP},
                IDENTIFICATION_KEY + "=" + idPk,
                null, null, null, null);
        c.moveToNext();

        String name = c.getString(c.getColumnIndex(IDENTIFICATION_NOM));
        String mdp = c.getString(c.getColumnIndex(IDENTIFICATION_MDP));

        c.close();

        return new Identification(name, mdp);
    }

    public List<Identification> getAllIdentifications() {
        List<Identification> result = new ArrayList<>();

        Cursor c = readDatabase.query(IDENTIFICATION_TABLE_NAME,
                new String[] {IDENTIFICATION_NOM, IDENTIFICATION_MDP},
                null,
                null, null, null, null);

        while (c.moveToNext()) {
            String name = c.getString(c.getColumnIndex(IDENTIFICATION_NOM));
            String mdp = c.getString(c.getColumnIndex(IDENTIFICATION_MDP));

            result.add(new Identification(name, mdp));
        }
        c.close();

        return result;
    }
    public List<Carte>  getAllcarte() {
        List<carte> result = new ArrayList<>();

        Cursor c = readDatabase.query(CARTE_TABLE_NAME,
                new String[] {CARTE_NOM, CARTE_PRENOM, CARTE_NUM, CARTE_MAIL, CARTE_ENTREPRISE},
                null,
                null, null, null, null);

        while (c.moveToNext()) {
            String entrepise = c.getString(c.getColumnIndex(CARTE_ENTREPRISE));
            String mail = c.getString(c.getColumnIndex(CARTE_MAIL));
            String num = c.getString(c.getColumnIndex(CARTE_NUM));
            String prenom = c.getString(c.getColumnIndex(CARTE_PRENOM));
            String nom = c.getString(c.getColumnIndex(CARTE_NOM));


            result.add(new Identification(name, mdp));
        }
        c.close();

        return result;
    }



}
