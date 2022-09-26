package persistencia;

import entidades.Cliente;
import java.util.List;
import java.util.Scanner;

public class ClienteDAO extends DAO {

    public void añadirCliente(Cliente cliente) {
        guardar(cliente);
    }

    public void eliminarCliente(String id) {
        conectar();
        Cliente cliente = em.find(Cliente.class, id);
        eliminar(cliente);
        desconectar();
        if (cliente != null) {
            System.out.println("cliente eliminado con exito");
        }
    }

    public List<Cliente> mostrarLosClientes() {
        conectar();
        List<Cliente> clientes = (List<Cliente>) em.createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();

        clientes.forEach((aux) -> {
            System.out.println(aux);
        });
        desconectar();
        return clientes;
    }

    public Cliente buscarPorId() {
        conectar();
        Scanner leer = new Scanner(System.in);
        System.out.println("ingrese id del cliente a buscar");
        String aux = leer.nextLine();
        Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.id LIKE :aux").setParameter("aux", aux)
                .getSingleResult();
        System.out.println(cliente);
        desconectar();
        return cliente;
    }

    public Cliente buscarPorNombre(String nombre, String apellido) {
        conectar();
        Scanner leer = new Scanner(System.in);
        Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE :nombre"
                + "and c.apellido LIKE :apellido ")
                .getSingleResult();
        desconectar();
        return cliente;
    }

}
