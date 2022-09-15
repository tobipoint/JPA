package persistencia;

import entidades.Libro;
import java.util.List;

public class LibroDAO extends DAO<Libro> {

    public void guardarLibro(Libro libro) {
        super.guardar(libro);
    }

    public List<Libro> MostrarLibros() {
        conectar();
        List<Libro> libro = em.createQuery("SELECT l FROM Libro l", Libro.class)
                .getResultList();
        
        libro.forEach((aux) -> {
            System.out.println(aux);
        });
        
        desconectar();
        return null;
    }

    public Libro BúsquedaPorISBN(Integer isbn) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE :isbn", Libro.class)
                .setParameter("isbn", isbn).getSingleResult();
        
        System.out.println(libro);
        desconectar();
        return libro;
    }

    public Libro BúsquedaPorNombreAutor(String nombre) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l JOIN  l.autor a WHERE a.nombre LIKE :nombre " ,Libro.class)
                .setParameter("nombre", nombre).getSingleResult();
        
        System.out.println(libro);
        desconectar();
        return libro;
    }

    public Libro BúsquedaPorTitulo(String titulo) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo")
                .setParameter("titulo", titulo).getSingleResult();
        System.out.println(libro);
        desconectar();
        return libro;
    }

    public Libro BúsquedaPorEditorial(String editorial) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l JOIN l.editorial e WHERE e.nombre LIKE :nombre ", Libro.class)
                .setParameter("nombre", editorial).getSingleResult();
        
        System.out.println(libro);
        desconectar();
        return libro;
    }

    
}
