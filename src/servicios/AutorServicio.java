/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Autor;
import java.util.List;
import persistencia.AutorDAO;

/**
 *
 * @author Usuario
 */
public class AutorServicio {

    private final AutorDAO Dao;
    private EditorialServicio editorialService;
    private LibroServicio libroService;

    public AutorServicio() {
        this.Dao = new AutorDAO();
    }

    public void setService(EditorialServicio editorialService,LibroServicio libroService ) {
        this.editorialService = editorialService;
        this.libroService = libroService;
    }

    public Autor crearAutor(String nombre, boolean alta) {
        try {
            Autor autor = new Autor();
            autor.setNombre(nombre);
            autor.setAlta(true);

            Dao.guardarAutor(autor);
            return autor;

        } catch (Exception e) {
            System.out.println("error en el autor");
            throw e;
        }

    }

    public List<Autor> listaAutor() {

        try {
            return (List<Autor>) Dao.MostrarAutor();
        } catch (Exception e) {
            System.out.println("problema en listar Autores");
            return null;
        }
    }

    public Autor BuscarPorNombre(String nombre) {
        try {
            return Dao.BúsquedaAutorPorNombre(nombre);
        } catch (Exception e) {
            System.out.println("problema en buscar autor");
            return null;
        }

    }

}
