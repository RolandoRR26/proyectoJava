package com.proyecto.libreria;

import java.util.List;

public class User {

    String nombre;
    String email;
    String password;
    List<String> librosPrestados;

    public User(String nombre, String email, String password, List<String> librosPrestados) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.librosPrestados = librosPrestados;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getLibrosPrestados() {
        return librosPrestados;
    }

    public void mostrarDatosUsuario(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Libros prestados: " + librosPrestados);
        System.out.println("--------------------------------");
    }
}
