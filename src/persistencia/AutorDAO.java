package persistencia;

import entidades.Autor;
import java.util.Collection;

public class AutorDAO extends DAO<Autor> {

    public void guardarAutor(Autor autor) {
        guardar(autor);
    }

    public Autor BúsquedaAutorPorNombre(String nombre) {
        conectar();

        Collection<Autor> autor = em.createQuery("SELECT a FROM autor a WHERE nombre = :nombre")
                .setParameter("nombre", nombre).getResultList();

        autor.forEach((aux) -> {
            System.out.println(aux.getNombre());
        });

        desconectar();
        return (Autor) autor;
    }

    public Collection<Autor> MostrarAutor() {
        conectar();
        Collection<Autor> autor = (Collection<Autor>) em.createQuery("SELECT * FROM autor ").getResultList();
//                em.createQuery("SELECT * FROM Libro").getResultList();
        autor.forEach((aux) -> {
            System.out.println(aux);
        });

        desconectar();
        return autor;
    }

}
