package com.proyecto.libreria;

public class MisExepcionesPersonalizadas extends RuntimeException {

    public MisExepcionesPersonalizadas() {
        super("Ocurrio un error");
    }

    public MisExepcionesPersonalizadas(String message) {
        super("Error: " + message);
    }

}
