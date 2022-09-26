package persistencia;

import entidades.Prestamo;
import java.util.List;
import java.util.Scanner;

public class PrestamoDAO extends DAO {

    public void guardarPrestamo(Prestamo prestamo) {
        guardar(prestamo);
    }

    public Prestamo añadirPrestamos(Prestamo prestamo) {

        return prestamo;
    }

    public List<Prestamo> mostrarPrestamo() {
        conectar();
        List<Prestamo> prestamo = (List<Prestamo>) em.createQuery("SELECT p FROM Prestamo p", Prestamo.class)
                .getResultList();
        prestamo.forEach((aux) -> {
            System.out.println(aux);
        });
        desconectar();
        return prestamo;
    }

    public void eliminarPrestamos() {
        Prestamo prestamo;
        System.out.println("ingrese id del prestamo a eliminar");
        Scanner leer = new Scanner(System.in);
        String aux = leer.nextLine();
        prestamo = em.find(Prestamo.class, "aux");
        eliminar(prestamo);
    }

    public List<Prestamo> prestamosDeCliente(String nombre) {
        conectar();
        
        List<Prestamo> prestamos = (List<Prestamo>) em.createQuery("SELECT p FROM Prestamo p JOIN Cliente c WHERE c.nombre = :nombre")
                .setParameter("nombre", nombre).getResultList();
        
        prestamos.forEach((aux) -> {
            System.out.println(aux.getId()+ " / " +aux.getCliente()+ " / " +aux.getLibro());
        });
        
        desconectar();
        return prestamos;
    }

}
