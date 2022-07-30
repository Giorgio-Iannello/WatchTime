package com.example.application;

import android.graphics.drawable.Drawable;

public class Film {

    public Film(int id, int image, String titolo, String descrizione, String durata, String annoUscita){
        this.id = id;
        this.image = image;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.durata = durata;
        this.annoUscita = annoUscita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDurata() {
        return durata;
    }

    public void setDurata(String durata) {
        this.durata = durata;
    }

    public String getAnnoUscita() {
        return annoUscita;
    }

    public void setAnnoUscita(String annoUscita) {
        this.annoUscita = annoUscita;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private int id;
    private int image;
    private String titolo;
    private String descrizione;
    private String durata;
    private String annoUscita;
}
