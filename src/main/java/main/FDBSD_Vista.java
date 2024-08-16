package main;
import view.*;
import model.*;
// @author Brandon Aguirre Ortiz

public class FDBSD_Vista {

    public static void main(String[] args) {
        //Llamar al inicio del programa
        Gestion g = new Gestion();
        /*
        g.mostrar();
        g.listar();*/
        
        MenuPrincipal m = new MenuPrincipal();
        m.setVisible(true);
    }
}
