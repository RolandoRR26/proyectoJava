package com.proyecto.libreria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {

    public static List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("100 años de soledad", "Gabriel García Márquez", 1967, 9780060114183L),
            new Book("El diario de Anna Frank", "Ana Frank", 1947, 9780307807533L),
            new Book("El niño de la pijama de rayas", "John Boyne", 2006, 9780060114323L),
            new Book("El alquimista", "Paulo Coelho", 1988, 9780060114324L),
            new Book("Sinuhe el egipcio", "Mika Waltari", 1945, 978006023455L)
    ));

    public static List<Author> author = new ArrayList<>(Arrays.asList(
                new Author("Paulo", "Coelho", "sdsd", Arrays.asList("El Alquimista", "Brida", "El Zahir", "A orillas del río Piedra me senté y lloré", "El Valkyrie", "El peregrino")),
                new Author("Ana", "Frank", "Escritora y diarista judía, conocida por su diario durante la Segunda Guerra Mundial.", Arrays.asList("El diario de Ana Frank")),
                new Author("John", "Boyne", "Escritor irlandés, conocido por su obra 'El niño con el pijama de rayas'.", Arrays.asList("El niño con el pijama de rayas", "El sol bajo la lluvia", "El regreso", "La casa del árbol", "La novela de mi vida")),
                new Author("Gabriel", "García Márquez", "Escritor colombiano, uno de los más grandes exponentes del realismo mágico.", Arrays.asList("100 años de soledad", "El amor en los tiempos del cólera", "Crónica de una muerte anunciada")),
                new Author("Mika", "Waltari", "Escritor finlandés conocido por su obra histórica 'Sinuhe el egipcio'.", Arrays.asList("Sinuhe el egipcio", "El romano", "La isla de los muertos"))
        ));


    private static List<User> usuarios = new ArrayList<>(Arrays.asList(
            new User("Rolando", "rolando@gmail.com", "Rodriguez1", Arrays.asList("El Alquimista", "Sinuhe el egipcio")),
            new User("Ana", "ana@outlook.com", "Ana2021", Arrays.asList("El diario de Ana Frank")),
            new User("Juan", "juan@yahooo.com", "Boyne2022", Arrays.asList("El niño de la pijama de rayas", "El sol bajo la lluvia"))
    ));



    public static void existeLibro(String libroBuscar){
        boolean existeLibro = books.stream()
                .anyMatch(book -> book.getTitulo().equalsIgnoreCase(libroBuscar));
        if (!existeLibro){
            throw new RuntimeException("El libro " + libroBuscar + " no se encuentra disponible en la libreria.");

        }

        System.out.println("El libro " + libroBuscar + " se encuentra en la libreria");

    }

    public static void agregarLibro(String titulo, String autor, int anio, int isbn) {
        Book nuevoLibro = new Book(titulo,autor,anio,isbn);
        books.add(nuevoLibro);
        System.out.println("=====Se agrego el nuevo libro a la lista=====");
        books.stream().forEach(Book::mostrarDatosLibro);
        System.out.println("Libro agregado: " + nuevoLibro.getTitulo());
    }

    public static void eliminarLibro(String tituloLibroEliminar){
        System.out.println("====Eliminar Libro====");
        Boolean libroEliminado = books.removeIf(book -> book.getTitulo().equalsIgnoreCase(tituloLibroEliminar));
        if(!libroEliminado){
            throw new MisExepcionesPersonalizadas("El libro " + tituloLibroEliminar + " no fue encontrado");
        }
        books.stream().forEach(Book::mostrarDatosLibro);
        System.out.println("El libro: " + tituloLibroEliminar +" se elimino");
    }

    public static void buscarLibro(String titulo){
        System.out.println("====Libro buscar====");

           Book libroBuscado =  books.stream().filter(b -> b.getTitulo().equalsIgnoreCase(titulo)).findFirst()
                 .orElseThrow(() -> new MisExepcionesPersonalizadas("El libro: " + titulo +" no existe en la libreria"));
           libroBuscado.mostrarDatosLibro();
    }

    public static void actualizarLibro(String libroActualizarTitutlo, String titulo, String autor, int anio, int isbn){
        Book libroActualizado = new Book(titulo,autor,anio,isbn);
        for (int i = 0; i < books.size(); i++) {
            Book libro = books.get(i);
            if (libro.getTitulo().equalsIgnoreCase(libroActualizarTitutlo)) {
                books.set(i, libroActualizado);
                System.out.println("Libro actualizado correctamente.");
                books.stream().forEach(Book::mostrarDatosLibro);
                return;
            }
        }
        throw new MisExepcionesPersonalizadas("El libro con título '" + libroActualizarTitutlo + "' no fue encontrado en la librería.");

    }

    public static void existeAutor(String autorBuscar){

        boolean existeAutor = books.stream()
                .anyMatch(autor -> autor.getAutor().equalsIgnoreCase(autorBuscar));
        if(!existeAutor){
            throw new RuntimeException("El autor " + autorBuscar + " no se encuentra en la libreria.");
        }
        System.out.println("El autor " + autorBuscar + " se encuentra en la libreria.");
    }

    public static void  agregarAutor(String nombre, String apellido, String biografia, List<String> listaLibros){

        Author nuevoAutor = new Author(nombre,apellido,biografia,listaLibros);
        author.add(nuevoAutor);
        System.out.println("=====Se agrego el nuevo autor a la lista=====");
        author.stream().forEach(Author::mostrarDatosAutor);
        System.out.println("Autor agregado: " + nuevoAutor.getNombre() + " " + nuevoAutor.getApellido());

    }

    public static void eliminarAutor(String nombreAutorEliminar, String apellidoAutorEliminar) {
        System.out.println("====Eliminar Autor====");

            boolean eliminado = author.removeIf(autor ->
                    autor.getNombre().equalsIgnoreCase(nombreAutorEliminar) &&
                            autor.getApellido().equalsIgnoreCase(apellidoAutorEliminar)
            );

            if (!eliminado) {
                throw new MisExepcionesPersonalizadas("El autor " + nombreAutorEliminar + " " + apellidoAutorEliminar + " no fue encontrado.");
            }
            author.stream().forEach(Author::mostrarDatosAutor);
            System.out.println("El autor " + nombreAutorEliminar + " " + apellidoAutorEliminar + " se eliminó.");

    }

    public static void buscarAutor(String autorBuscar){
        System.out.println("====Autor buscar====");
        Author buscaAutor = author.stream().filter(a -> a.getNombre().equalsIgnoreCase(autorBuscar)).findFirst()
                .orElseThrow(()->new MisExepcionesPersonalizadas("El autor: " + autorBuscar +" no existe en la libreria"));
      buscaAutor.mostrarDatosAutor();
    }

    public static void actualizarAutor(String nombreAutorActualizar,String nombre, String apellido, String biografia, List<String> librosPublicados){
        Author autorActualizado = new Author(nombre,apellido,biografia,librosPublicados);
        for (int i = 0; i < author.size(); i++) {
            Author autor = author.get(i);
            if (autor.getNombre().equalsIgnoreCase(nombreAutorActualizar)) {
                author.set(i, autorActualizado);
                System.out.println("Autor actualizado correctamente.");
                author.stream().forEach(Author::mostrarDatosAutor);
                return;
            }
        }
        throw new MisExepcionesPersonalizadas("El autor '" + nombreAutorActualizar + "' no fue encontrado en la librería.");

    }

    public static void agregarUsuario(String nombre, String correo, String password, List<String> librosPrestados) {
        User nuevoUsuario = new User(nombre, correo, password, librosPrestados);
        usuarios.add(nuevoUsuario);
        usuarios.stream().forEach(User::mostrarDatosUsuario);
        System.out.println("===== Se agregó el nuevo usuario a la lista =====");
        nuevoUsuario.mostrarDatosUsuario();
    }

    public static void eliminarUsuario(String nombreUsuarioEliminar) {
        System.out.println("====Eliminar Usuario====");

        boolean eliminado = usuarios.removeIf(usuario ->
                usuario.getNombre().equalsIgnoreCase(nombreUsuarioEliminar)
        );

        if (!eliminado) {
            throw new MisExepcionesPersonalizadas("El usuario " + nombreUsuarioEliminar + " no fue encontrado.");
        }

        usuarios.stream().forEach(User::mostrarDatosUsuario);
        System.out.println("El usuario " + nombreUsuarioEliminar + " se eliminó.");
    }

    public static void buscarUsuario(String nombreUsuario) {
        System.out.println("====Buscar Usuario====");

        User usuarioEncontrado = usuarios.stream()
                .filter(u -> u.getNombre().equalsIgnoreCase(nombreUsuario))
                .findFirst()
                .orElseThrow(() -> new MisExepcionesPersonalizadas("El usuario: " + nombreUsuario + " no esta registrado."));

        usuarioEncontrado.mostrarDatosUsuario();
    }

    public static void actualizarUsuario(String nombreUsuarioActualizar, String nombre, String correo, String password, List<String> librosPrestados) {
        User usuarioActualizado = new User(nombre, correo, password, librosPrestados);
        for (int i = 0; i < usuarios.size(); i++) {
            User usuario = usuarios.get(i);
            if (usuario.getNombre().equalsIgnoreCase(nombreUsuarioActualizar)) {
                usuarios.set(i, usuarioActualizado);
                System.out.println("Usuario actualizado correctamente.");
                usuarios.stream().forEach(User::mostrarDatosUsuario);
                return;
            }
        }

        throw new MisExepcionesPersonalizadas("El usuario '" + nombreUsuarioActualizar + "' no fue encontrado en la librería.");
    }




    public static void main(String[] args) {

        //=====LIBROS=====
        //existeLibro("100 años de soledad");

        //agregarLibro("Prueba","Prueba",2020,202020200);

        //eliminarLibro("100 años de soledad");

        //buscarLibro("El alquimista");

        //actualizarLibro("El alquimista", "Prueba2","Prueba2",2023,232323232);

        //=====AUTORES=====
        //existeAutor("Paulo Coelho");

        //agregarAutor("Rolando","Rodriguez R","Biografia de prueba Biografia de pruebaBiografia de pruebaBiografia de pruebaBiografia de prueba",Arrays.asList("Programacion Java","Full Stack desde cero","Programacion for dummies"));

        //eliminarAutor("Paulo","Coelho");

        //buscarAutor("Paulo");

        //actualizarAutor("Paulo","Prueba","Prueba","ppspspspps",Arrays.asList("Prueba1","Prueba2"));

        //=====USUARIOS=====
        // agregarUsuario("Rolando","rolando@gmail.com","12345",Arrays.asList("100 años de soledad","Don Quijote de la mancha"));

        // eliminarUsuario("Rolando");

        //buscarUsuario("Rolando");

        //actualizarUsuario("Rolando","Jose Lopez", "jose@outllok.com","000000",Arrays.asList("Libro 1","Libo 2","Libro 3"));
    }



}
