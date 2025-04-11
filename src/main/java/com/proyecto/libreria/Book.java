package com.proyecto.libreria;

import java.util.Arrays;
import java.util.List;

public class Book {

    String titulo;
    String autor;
    int anio;
    long isbn;

    public Book(String titulo,String autor, int anio, long isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.anio = anio;
        this.isbn = isbn;
    }


    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnio() {
        return anio;
    }

    public long getIsbn() {
        return isbn;
    }

    public void mostrarDatosLibro() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año: " + anio);
        System.out.println("ISBN: " + isbn);
        System.out.println("--------------------------------");

    }



}
