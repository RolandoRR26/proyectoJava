package com.proyecto.libreria;

import java.util.List;


public class Contexto {

    public static void main(String[] args) {
        int anio= 1940;
        String buscarLibro = "El niño de la pijama de rayas";

      //  List<Book> books = Library.books();

        /*/ libros publicados después del año especificadoe n variable anio
        books.stream()
                .filter(b -> b.getAnio() > anio)
                .forEach(Book::mostrarDatosLibro);/*/

        /*/  ordenar por autor
        System.out.println("---- Ordenados por autor ----");
        books.stream()
                .sorted((b1, b2) -> b1.getAutor().compareToIgnoreCase(b2.getAutor()))
                .forEach(Book::mostrarDatosLibro);/*/

        /*/ordenar por año de lanzamaiento
        System.out.println("---- Ordenados por año de lanzamiento ----");
        books.stream()
                .sorted((a1,a2)-> Integer.compare(a1.getAnio(), a2.getAnio()))
                .forEach(Book::mostrarDatosLibro); /*/

               /*/ System.out.println("---- Encontrar libro ----");

        boolean existeLibro = books.stream()
                .anyMatch(book -> book.getTitulo().equalsIgnoreCase(buscarLibro));
        if (!existeLibro){
            throw new RuntimeException("El libro " + buscarLibro + " no se encuentra en la libreria.");
        }
        System.out.println("El libro " + buscarLibro + " se encuentra en la libreria");        /*/


    }

}
