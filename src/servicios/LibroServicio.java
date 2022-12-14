
package servicios;

import entidades.Autor;
import entidades.Editorial;
import entidades.Libro;
import java.util.List;
import persistencia.LibroDAO;


public class LibroServicio {

    private final LibroDAO Dao;

    private AutorServicio AutorService;
    private EditorialServicio editorialService;

    public LibroServicio() {
        this.Dao = new LibroDAO();
    }

    public void setService(AutorServicio AutorService, EditorialServicio editorialService) {
        this.AutorService = AutorService;
        this.editorialService = editorialService;
    }

    public Libro crearLibro(String id, String titulo, Integer anio, Autor autor, Editorial editorial) {
        Libro libro = new Libro();
        try {
            libro.setId(id);
            libro.setTitulo(titulo);
            libro.setAlta(true);
            libro.setAnio(anio);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            
            Dao.guardarLibro(libro);
            return libro;
        } catch (Exception e) {
            System.err.println("error en crear libro");
            throw e;
        }

    }

    public List<Libro> MostrarLibros() {
        try {
            return Dao.MostrarLibros();
        } catch (Exception e) {
            System.err.println("problema en listar libros");
            return null;
        }

    }

    public Libro BúsquedaPorISBN(Integer isbn) {
        try {
            return Dao.BúsquedaPorISBN(isbn);
        } catch (Exception e) {
            System.err.println("problema en isbn");
            return null;
        }
    }

    public Libro BúsquedaPorNombreAutor(String nombre) {
        try {
            return Dao.BúsquedaPorNombreAutor(nombre);
        } catch (Exception e) {
            System.err.println("problema en nombre del autor");
            return null;
        }
    }

    public Libro BúsquedaPorTitulo(String titulo) {
        try {
            return Dao.BúsquedaPorTitulo(titulo);
        } catch (Exception e) {
            System.err.println("problema en titulo");
            return null;
        }
    }

    public Libro BúsquedaPorEditorial(String editorial) {
        try {
            return Dao.BúsquedaPorEditorial(editorial);
        } catch (Exception e) {
            System.err.println("poblema en editorial");
            return null;
        }
    }
    
}
