package com.proyecto.libreria;

import java.util.List;

public class Author {

    String nombre;
    String apellido;
    String biografia;
    List<String> librosPublicados;

    public Author(String nombre, String apellido, String biografia, List<String> librosPublicados) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.biografia = biografia;
        this.librosPublicados = librosPublicados;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getBiografia() {
        return biografia;
    }

    public List<String> getLibrosPublicados() {
        return librosPublicados;
    }

    public void mostrarDatosAutor(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Biografia: " + biografia);
        System.out.println("Libros publicados: " + librosPublicados);
        System.out.println("--------------------------------");
    }
}
