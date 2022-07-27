package com.example.application.ui;

import android.graphics.drawable.Drawable;

public class film {

    public film(Drawable image, String titolo, String descrizione, String durata, String annoUscita){
        this.image = image;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.durata = durata;
        this.annoUscita = annoUscita;
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

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    Drawable image;
    String titolo;
    String descrizione;
    String durata;
    String annoUscita;
}
