package servicios;

import entidades.Cliente;
import entidades.Libro;
import entidades.Prestamo;
import java.util.List;
import persistencia.PrestamoDAO;

public class prestamoServicio {

    private LibroServicio libroService;
    private clienteServicio clienteService;

    private final PrestamoDAO Dao;

    public prestamoServicio() {
        this.Dao = new PrestamoDAO();
    }

    public void setService(clienteServicio cs, LibroServicio ls) {
        this.libroService = ls;
        this.clienteService = cs;
    }

    public Prestamo CrearPrestamo(Cliente cliente, String id, Libro libro) {
        Prestamo prestamo = new Prestamo();
        try {
            prestamo.setCliente(cliente);
            prestamo.setId(id);
            prestamo.setLibro(libro);
            prestamo.setCliente(null);

            Dao.guardarPrestamo(prestamo);
            return prestamo;

        } catch (Exception e) {
            System.err.println("problema en crear prestamo");
            return null;
        }
    }

    public void añadirPrestamo() {
        try {
//            Dao.añadirPrestamos();
        } catch (Exception e) {
            System.err.println("problema al añadir un prestamo");
            throw e;
        }
    }

    public void mostrarPrestamo() {
        try {
            Dao.mostrarPrestamo();
        } catch (Exception e) {
            System.err.println("problema al mostrar prestamo");
            throw e;
        }
    }

    public Prestamo prestamoYcliente() {
        Prestamo prestamo = new Prestamo();
        try {
             prestamo.setLibro(libroService.BúsquedaPorNombreAutor("autor"));
            if (prestamo.getLibro() != null) {
                System.out.println("lirro añadido");
            }else{
                throw new Exception("el libro con ese autor no existe");
            }
            prestamo.setCliente(clienteService.buscarClienteId());
            if (prestamo.getCliente() != null) {
                System.out.println("creando prestamo al cliente");
            }else{
                throw new Exception("el cliente con ese id no existe");
            }
            
            Dao.guardarPrestamo(prestamo);
            return prestamo;
        } catch (Exception e){
            System.err.println(e.getMessage());
            System.err.println("problema al añadir prestamo");
            return null;
        } finally {
            Dao.mostrarPrestamo();
        }

    }

    public void eliminar() {
        try {
            Dao.eliminarPrestamos();
        } catch (Exception e) {
            System.err.println("no se encontro el prestamo a eliminar");
            throw e;
        }
    }

    public List<Prestamo> prestamosDeCliente(String nombre) {
        try {
            List<Prestamo> prestamos = Dao.prestamosDeCliente(nombre);

            if (prestamos == null) {
                throw new Exception("problema en listar prestamos");
            }

            return prestamos;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
