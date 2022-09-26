package principal;

import entidades.Autor;
import entidades.Cliente;
import entidades.Editorial;
import entidades.Libro;
import entidades.Prestamo;
import java.util.Scanner;
import servicios.AutorServicio;
import servicios.EditorialServicio;
import servicios.LibroServicio;
import servicios.clienteServicio;
import servicios.prestamoServicio;

public class Menu {

    private final AutorServicio as = new AutorServicio();
    private final LibroServicio ls = new LibroServicio();
    private final EditorialServicio es = new EditorialServicio();
    private final clienteServicio cs = new clienteServicio();
    private final prestamoServicio ps = new prestamoServicio();

    public Menu() {
        as.setService(es, ls);
        ls.setService(as, es);
        es.setService(as, ls);
        cs.setService(ps, ls);
        ps.setService(cs, ls);
    }

    public void CrearObjetos() {
//             creo los objetos 
        try {
            
            Autor autor = as.crearAutor("autor", true);
            Autor autor1 = as.crearAutor("autor1", true);
            
            Editorial editorial = es.crearEditorial(true, "40", "editorial");
            Editorial editorial1 = es.crearEditorial(true, "1", "editorial2");
            
            Libro libro = ls.crearLibro("1", "libro", 2005, autor, editorial);
            Libro libro1 = ls.crearLibro("2", "cazafantasmas", 2001, autor1, editorial1);

            Cliente cliente = cs.crearCliente("cliente", "mattiazzo", "231542", 44757090);
            Cliente cliente1 = cs.crearCliente("cliente1", "pointe", "22554", 12346);

//            Prestamo prestamo = ps.CrearPrestamo(cliente, "1", libro);
//            Prestamo prestamo1 = ps.CrearPrestamo(cliente1, "2", libro1);
            
        } catch (Exception e) {
            System.err.println("problema en crear los objetos ");
            throw e;
        }
    }

    public void ejecucion1() {
//        CREAR LIBRO - AUTOR - EDITORIAL
//        BUSQUEDA 
        Scanner leer = new Scanner(System.in);
        int op;

        System.out.println(
                " 1) Búsqueda de un Autor por nombre" + "\n"
                + " 2) Búsqueda de un libro por ISBN " + "\n"
                + " 3) Búsqueda de un libro por Título " + "\n"
                + "    ---- Búsqueda de un libro ----- " + "\n"
                + " 4)  por nombre de Autor " + "\n"
                + " 5) por nombre de Editorial " + "\n"
                + "    ----------------- " + "\n"
                + " 6) mostrar libro " + "\n"
                + " 7) mostrar Autor " + "\n"
                + " 8) mostrar editorial " + "\n"
                + " 9)  salir");

        do {
            op = leer.nextInt();
            switch (op) {
                case 1:
                    as.BuscarPorNombre("juan");
                    break;
                case 2:
                    ls.BúsquedaPorISBN(0);
                    break;
                case 3:
                    ls.BúsquedaPorTitulo("zzz");
                    break;
                case 4:
                    ls.BúsquedaPorNombreAutor("juan");
                    break;
                case 5:
                    ls.BúsquedaPorEditorial("aaa");
                    break;
                case 6:
                    ls.MostrarLibros();
                    break;
                case 7:
                    as.listaAutor();
                    break;
                case 8:
                    es.MostrarEditorial();
                    break;
            }
        } while (op != 9);
    }

    public void ejecucion2() {
//      EJERCICIO EXTRA - PRESTAMOS - CLIENTES

        Scanner leer = new Scanner(System.in);
        int op;
        System.out.println(
                "   elija una opcion" + "\n"
                + " 1) crear nuevo cliente" + "\n"
                + " 2) eliminar cliente" + "\n"
                + " 3) añadir prestamo al cliente" + "\n"
                + " 4) Devolución de un libro (eliminar prestamos)" + "\n"
                + " 5) Búsqueda de todos los préstamos de un Cliente" + "\n"
                + "6) mostrar todos los clientes y prestamos " + "\n"
                + " 7) salir");

        do {
            op = leer.nextInt();
            switch (op) {
                case 1:
                    cs.crearCliente("cliente", "mattiazzo", "26124183", 44757090);
                    break;
                case 2:
                    cs.elimiarCliente("402");
                    break;
                case 3:
                    ps.prestamoYcliente();
                    break;
                case 4:
                    ps.eliminar();
                    break;
                case 5:
                    ps.prestamosDeCliente("cliente");
//                    hay que añadirle prestamos al cliente
                    break;
                case 6:
                    cs.mostrarClientes();
                    ps.mostrarPrestamo();
                    break;
            }

        } while (op != 7);
    }

}
