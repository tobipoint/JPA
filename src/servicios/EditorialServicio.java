/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import entidades.Editorial;
import java.util.List;
import persistencia.EditorialDAO;

/**
 *
 * @author Usuario
 */
public class EditorialServicio {

    private final EditorialDAO Dao;

    private AutorServicio AutorService;
    private LibroServicio libroService;

    public EditorialServicio() {
        this.Dao = new EditorialDAO();
    }

    public void setService(AutorServicio AutorService, LibroServicio libroService) {
        this.libroService = libroService;
        this.AutorService = AutorService;
    }

    public Editorial crearEditorial(boolean alta, String id, String nombre) {

        Editorial editorial = new Editorial();

        try {
            editorial.setAlta(alta);
            editorial.setId(id);
            editorial.setNombre(nombre);

            Dao.guardarEditorial(editorial);
            return editorial;
        } catch (Exception e) {
            System.err.println("error en el editorial");
            throw e;
        }

    }

    public List<Editorial> MostrarEditorial() {

        try {
            return Dao.MostrarEditorial();
        } catch (Exception e) {
            System.err.println("problema en mostrar el editorial");
            return null;
        }
    }
    
}
