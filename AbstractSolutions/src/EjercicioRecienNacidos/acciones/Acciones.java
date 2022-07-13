package ejercicioRecienNacidos.acciones;

import EjercicioRecienNacidos.dao.NacidosDao;
import ejercicioRecienNacidos.interfaz.Procesos;
import EjercicioRecienNacidos.modelo.Nacidos;
import javax.swing.JOptionPane;
import static org.apache.commons.lang3.StringUtils.isNumeric;

public class Acciones implements Procesos{
    static NacidosDao dao = new NacidosDao();
    
    @Override
//    Pedimos datos al usuario hacerca del bebe que quieren registrar
//    Lo almacenamos en la lista 'listNacidos'
    public void registrar() {
        String dni = JOptionPane.showInputDialog(null, "Ingrese el D.N.I");
        dni = verificarDni(dni);
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el Nombre: ");
        String apellido = JOptionPane.showInputDialog(null, "Ingrese el Apellido: ");
        int dia = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                + "Ingrese el dia en que nacio: "));
        dia = verificarDia(dia);
        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                + "Ingrese el mes en que nacio: "));
        mes = verificarMes(mes);
        int anio = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                + "Ingrese el anio en que nacio: "));
        anio = verificarAnio(anio);
        char sexo = JOptionPane.showInputDialog(null, ""
                + "Ingrese el sexo: ").charAt(0);
        sexo = verificarSexo(sexo);
        Nacidos nacido = new Nacidos(dni, nombre, apellido, dia, mes, anio, sexo);
        dao.agregar(nacido);
    }

//    SobreEscritura del metodo 'busquedaParticular' 
    @Override
//  Busca dentro de la lista a partir del D.N.I ingresado
    public void buscaParticular() {
        String dni = JOptionPane.showInputDialog(null, "Ingrese el D.N.I del Recien Nacido");
        dni = verificarDni(dni);
        dao.mostrarDni(dni);
    }

//    SobreEscritura del metodo 'buscar'
    @Override
//    Busca dentro de la lista a partir de las primeras 3 letras del apellido
    public void buscar() {
        String primerasTres = JOptionPane.showInputDialog(null, "Ingrese las primeras tres "
                + "letras del apellido");
        dao.mostrarApellido(primerasTres);
    }
    
//    SobreEscritura del metodo 'modificar'
    @Override
//    Modifica el valor del 'sexo'
    public void modificar() {
        String dni = JOptionPane.showInputDialog(null, "Ingrese el D.N.I");
        dni = verificarDni(dni);
        char sexo = JOptionPane.showInputDialog(null, ""
                + "Ingrese el sexo: ").charAt(0);
        sexo = verificarSexo(sexo);
        dao.editar(dni, sexo);
    }
    
//      Muestra las opciones que puede elegir el usuario
    public int opciones(){
        int eleccion = 0;
        try{
            eleccion = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "1.Registrar Recien Nacido\n"
                    + "2.Cambiar Sexo a Recien Nacido\n"
                    + "3.Buscar Recien Nacido por D.N.I\n"
                    + "4.Buscar Recien Nacido por Apellido\n"
                    + "5.Salir"));
            while(eleccion > 5 || eleccion <1){
                JOptionPane.showMessageDialog(null, "Accion Incorrecta, porfavor intente nuevamente");
                eleccion = Integer.parseInt(JOptionPane.showInputDialog(""
                    + "1.Registrar Recien Nacido\n"
                    + "2.Cambiar Sexo a Recien Nacido\n"
                    + "3.Buscar Recien Nacido por D.N.I\n"
                    + "4.Buscar Recien Nacido por Apellido\n"
                    + "5.Salir"));
            }
        }
        catch(Exception ex){
            System.out.println("ERROR al seleccionar una opcion"); 
        }
        return eleccion;
    }  
    
//    verifica si el D.N.I contiene solo numeros
    public String verificarDni(String dni){
        while(isNumeric(dni) != true || dni.length()!=8){
            dni = JOptionPane.showInputDialog(null, "El D.N.I debe contener SOLO numeros"
                    + "\nLa longitud del D.N.I debe ser de 8 digitos");
        }
        return dni;
    }
    
//        verifica que la letra para determinar el sexo es correcta
    public char verificarSexo(char sexo){
        while(sexo != 'f' && sexo != 'm'){
            System.out.println("Letra incorrecta para determinar el sexo");
            sexo = JOptionPane.showInputDialog(null, "Letra incorrecta para determinar el sexo\n"
                    + "Ingrese 'm' o 'f'").charAt(0);
        }
        return sexo;
    }

//    verifica el dia de nacimiento 
    public int verificarDia(int dia){
        while(dia<1 || dia>31){
            dia = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                + "Ingrese un dia que este permitido: "));
        }
        return dia;
    }
//    verifica el mes de nacimiento 
    public int verificarMes(int mes){
        while(mes<1 || mes>12){
            mes = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                + "Ingrese un mes que este permitido: "));
        }
        return mes;
    }
//    verifica el anio de nacimiento 
    public int verificarAnio(int anio){
        while(anio<1900 || anio>2022){
            anio = Integer.parseInt(JOptionPane.showInputDialog(null, ""
                + "Ingrese un anio que este permitido: "));
        }
        return anio;
    }
    
}
