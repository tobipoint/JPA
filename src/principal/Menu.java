package principal;

import entidades.Autor;
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
    
    public void ejecucion() {

//        // creo los objetos 
//        Autor aa = as.crearAutor("juan", true);
//        Editorial editorial = es.crearEditorial(true, "40", "aaa");
//        Libro libro = ls.crearLibro("1", "zzz", 2005, aa, editorial);
        
        Scanner leer = new Scanner(System.in);
        int op = 0;
        
        System.out.println(
                " 1) Búsqueda de un Autor por nombre" + "\n"
                + " 2) Búsqueda de un libro por ISBN " + "\n"
                + " 3) Búsqueda de un libro por Título " + "\n"
                + " Búsqueda de un libro " + "\n"
                + " 5) /s por nombre de Autor " + "\n"
                + " 6) /s por nombre de Editorial " + "\n"
                + "8) mostrar libro " + "\n" 
                + "9) mostrar Autor " + "\n"
                + "10) mostrar editorial " + "\n"
                + "11) salir");
        
        do {
            op = leer.nextInt();
            switch (op) {
                case 1:
                    as.BuscarPorNombre("juan");
                    break;
                case 2:
                    ls.BúsquedaPorISBN(55);
                    break;
                case 3:
                    ls.BúsquedaPorTitulo("zzz");
                    break;
                case 5:
                    
                    break;
                case 6:
//                  ls.BúsquedaPorEditorial(editorial);
                    break;
                case 8:
                    ls.MostrarLibros();
                    break;
                case 9:
                    as.listaAutor();
                    break;
                case 10:
                    es.MostrarEditorial();
                    break;
            }
            
        } while (op != 11);
        
    }
    
}
