package com.example.antoinerossi.workshare.model;


public  Carte{

private String nom;
private String prenom;
private String mail;
private String num;
private String entreprise;
        }


public Identification(String name, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.num = num;
        this.entreprise = entrepris;


        }

public String getName() {
        return name;
        }

public String getMdp() {
        return mdp;
        }

@Override
public String toString() {
        return "Identification{" +
        "name='" + name + '\'' +
        ", mdp='" + mdp + '\'' +
        '}';
        }
        }
