package persistencia;

import entidades.Libro;
import java.util.List;

public class LibroDAO extends DAO<Libro> {

    public void guardarLibro(Libro libro) {
        super.guardar(libro);
    }

    public List<Libro> MostrarLibros() {
        conectar();
        List<Libro> libro = em.createQuery("SELECT * FROM Libro")
                .getResultList();
        desconectar();
        return null;
    }

    public Libro BúsquedaPorISBN(Integer isbn) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT * FROM libro WHERE isbn = :isbn")
                .setParameter("isbn", isbn).getSingleResult();
        desconectar();
        return libro;
    }

    public Libro BúsquedaPorNombreAutor(String nombre) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT * FROM libro WHERE nombre = :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return libro;
    }

    public Libro BúsquedaPorTitulo(String titulo) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT * FROM libro WHERE titulo = :titulo")
                .setParameter("titulo", titulo).getSingleResult();
        desconectar();
        return libro;
    }

    public Libro BúsquedaPorEditorial(String editorial) {
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT * FROM libro WHERE editorial = :editorial")
                .setParameter("editorial", editorial).getSingleResult();
        desconectar();
        return libro;
    }

}
