package persistencia;

import entidades.Editorial;
import java.util.List;

public class EditorialDAO extends DAO<Editorial> {

    public void guardarEditorial(Editorial editorial) {
        super.guardar(editorial);
    }
    
    public List<Editorial> MostrarEditorial() {
        conectar();
        List<Editorial> editorial = em.createQuery("SELECT e FROM Editorial e" , Editorial.class )
                .getResultList();
        
        editorial.forEach((aux) -> {
            System.out.println(aux);
        });
        desconectar();
        return editorial;
    }
}
