
package servicios;

import entidades.Autor;
import java.util.List;
import persistencia.AutorDAO;


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
            System.err.println("error en crear autor");
            throw e;
        }

    }

    public List<Autor> listaAutor() {
        try {
            return (List<Autor>) Dao.MostrarAutor();
        } catch (Exception e) {
            System.err.println("problema en listar Autores");
            return null;
        }
    }

    public List<Autor> BuscarPorNombre(String nombre) {
        try {
            return (List<Autor>) Dao.BúsquedaAutorPorNombre(nombre);
        } catch (Exception e) {
            System.err.println("problema en buscar autor");
            return null;
        }

    }

}
