package com.example.antoinerossi.workshare.model;

public class Identification {
    private String name;
    private String mdp;

    public Identification(String name, String mdp) {
        this.name = name;
        this.mdp = mdp;
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
