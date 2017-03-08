package com.example.walid.tp1_6;

/**
 * Created by walid on 18/02/2017.
 */

public class Etudiant {
    private String option;
    private String nom;
    private String email;
    private int abs;

    public Etudiant(String option, String nom, String email, int abs) {
        this.option = option;
        this.nom = nom;
        this.email = email;
        this.abs = abs;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(int abs) {
        this.email = email;
    }
    public int getAbs() {
        return abs;
    }

    public void setAbs(int abs) {
        this.abs = abs;
    }
}