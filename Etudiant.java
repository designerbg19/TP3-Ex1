package com.example.walid.tp3_1;

/**
 * Created by walid on 18/02/2017.
 */

public class Etudiant {
    private String option;
    private String nom;
    private String email;
    private int abs;
    private String avatar;

    public Etudiant(String nom, String option, String email, int abs,String avatar) {
        this.option = option;
        this.nom = nom;
        this.email = email;
        this.abs = abs;
        this.avatar = avatar;

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
    public void setAvatar(String imgUrl) {
        this.avatar = imgUrl;
    }

    public String getAvatar() {
        return avatar;
    }
}