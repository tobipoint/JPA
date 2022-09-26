package servicios;

import entidades.Cliente;
import persistencia.ClienteDAO;

public class clienteServicio {

    private LibroServicio libroService;
    private prestamoServicio prestamoService;

    private final ClienteDAO Dao;

    public clienteServicio() {
        this.Dao = new ClienteDAO();
    }

    public void setService(prestamoServicio ps, LibroServicio ls) {
        this.libroService = ls;
        this.prestamoService = ps;
    }

    public Cliente crearCliente(String nombre, String apellido, String telefono, Integer dni) {
        Cliente cliente = new Cliente();
        try {
            if (Dao.buscarPorNombre(nombre, apellido) == null) {
                System.out.println("datos correctos");
                cliente.setApellido(apellido);
                cliente.setDni(Integer.SIZE);
                cliente.setNombre(nombre);
                cliente.setTelefono(telefono);
                Dao.añadirCliente(cliente);
            } else {
                throw new Exception("datos ya existentes");
            }
            return cliente;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("problema en crear cliente");
            return null;
        }
    }

    public void elimiarCliente(String id) {
        try {
            Dao.eliminarCliente(id);

        } catch (Exception e) {
            System.err.println("error al eliminar cliente");
            throw e;
        }
    }

    public void mostrarClientes() {
        try {
            Dao.mostrarLosClientes();
        } catch (Exception e) {
            System.err.println("problema en mostrar clientes");
        }
    }

    public Cliente buscarClienteId() {
        try {
            return Dao.buscarPorId();
        } catch (Exception e) {
            System.err.println("problema al buscar cliente por id");
            return null;
        }

    }

    public Cliente buscarPorNombre(String nombre, String apellido) {
        try {
            return Dao.buscarPorNombre(nombre, apellido);
        } catch (Exception e) {
            return null;
        }
    }

}
