package com.example.application;


import java.io.Serializable;

public class Film implements Serializable {

    public Film(int id, int image, String titolo, String descrizione, String durata, String idVideo){
        this.id = id;
        this.image = image;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.durata = durata;
        this.idVideo = idVideo;
        this.isSaved = false;
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

    public String getIdVideo() {
        return idVideo;
    }

    public void setIdVideo(String idVideo) {
        this.idVideo = idVideo;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    private int id;
    private int image;
    private boolean isSaved;
    private String titolo;
    private String descrizione;
    private String durata;
    private String idVideo;
}
