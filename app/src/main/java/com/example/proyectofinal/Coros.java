package com.example.proyectofinal;

public class Coros {
    private int id;
    private String titulo;
    private String autor;
    private String letra;

    public Coros() {
    }

    public Coros(int id, String titulo, String autor, String letra) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.letra = letra;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra; }

}
