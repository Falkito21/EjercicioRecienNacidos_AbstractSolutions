package EjercicioRecienNacidos;

import ejercicioRecienNacidos.acciones.Acciones;
import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) {
        int eleccion;
        Acciones proceso = new Acciones();
        JOptionPane.showMessageDialog(null, "Registro de Recie Nacidos");
        JOptionPane.showMessageDialog(null, "Indique lo que desea hacer:");
        eleccion = proceso.opciones();
        do{
            switch (eleccion) {
            case 1:
                proceso.registrar();
                break;
            case 2:
                proceso.modificar();
                break;
            case 3:
                proceso.buscaParticular();
                break;
            case 4:
                proceso.buscar(); 
                break;
            }
            JOptionPane.showMessageDialog(null, "Desea realizar alguna otra accion?");
            eleccion = proceso.opciones();
        }while(eleccion != 5);
        JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro programa!");
    }
   
}
