package principal;

import java.util.Scanner;
import servicios.AutorServicio;
import servicios.EditorialServicio;
import servicios.LibroServicio;

public class Menu {

    private final AutorServicio as = new AutorServicio();
    private final LibroServicio ls = new LibroServicio();
    private final EditorialServicio es = new EditorialServicio();

    public Menu() {
        as.setService(es, ls);
        ls.setService(as, es);
        es.setService(as, ls);
    }

    public void CrearObjetos(){
//             creo los objetos 
//        Autor aa = as.crearAutor("juan", true);
//        Editorial editorial = es.crearEditorial(true, "40", "aaa");
//        Libro libro = ls.crearLibro("1", "zzz", 2005, aa, editorial);7


    }
    
    public void ejecucion() {

        Scanner leer = new Scanner(System.in);
        int op = 0;

        System.out.println(
                  " 1) Búsqueda de un Autor por nombre" + "\n"
                + " 2) Búsqueda de un libro por ISBN " + "\n"
                + " 3) Búsqueda de un libro por Título " + "\n"
                + " ---- Búsqueda de un libro ----- " + "\n"
                + " 4)  por nombre de Autor " + "\n"
                + " 5) por nombre de Editorial " + "\n"
                + "  ----------------- " + "\n"
                + " 6) mostrar libro " + "\n"
                + " 7) mostrar Autor " + "\n"
                + " 8) mostrar editorial " + "\n"
                + " 9) salir");

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

}
