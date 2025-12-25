// ItemData.java (en el paquete com.example.intento)

package com.example.intento;

public class data {
    private String titulo;
    private String director;
    private int imagenID;
    // Constructor
    public data(String titulo, String director,int imagenID) {
        this.titulo = titulo;
        this.director = director;
        this.imagenID = imagenID;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }
    public int getImagenID() {
        return imagenID;
    }
}