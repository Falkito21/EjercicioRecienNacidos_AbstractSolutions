package EjercicioRecienNacidos.dao;

import EjercicioRecienNacidos.modelo.Nacidos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NacidosDao {
//      conexion a la base de datos
    public Connection conectar(){
        String baseDatos = "registro";
        String usuario = "root";
        String contrasenia = "";
        String host = "Localhost";
        String puerto = "3306";
        String driver = "com.mysql.jdbc.Driver";
        String conexionUrl = "jdbc:mysql://"
                + host + ":"
                + puerto + "/"
                +baseDatos + "?useSSL=false";
        Connection conexion = null;
        try{
            Class.forName(driver);
            conexion = DriverManager.getConnection(
                    conexionUrl, usuario, contrasenia);
        }catch(Exception ex){
            Logger.getLogger(NacidosDao.class.getName()).log(
                    Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return conexion;
    }
//      almacena a un recien nacido
    public void agregar(Nacidos nacido){
        try{
            System.out.println("Conexion exitosa");
            Connection conexion = conectar();
            String sql = "INSERT INTO `nacidos` ("
                    + "`Dni`, `Nombre`, `Apellido`, `Dia`, `Mes`, `Anio` , `Sexo`) VALUES('"
                    + nacido.getDni() + "', '"
                    + nacido.getNombre() + "', '"
                    + nacido.getApellido() + "', '"
                    + nacido.getDia() + "', '"
                    + nacido.getMes() + "', '"
                    + nacido.getAnio() + "', '"
                    + nacido.getSexo() + "');";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
            JOptionPane.showMessageDialog(null, "Recien Nacido almacenado Correctamente.");
        } catch (Exception ex){
            Logger.getLogger(NacidosDao.class.getName()).log(
                    Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR al guardar Recien Nacido");
        }
    }
//      edita el sexo de un recien nacido previamente almacenado
    public void editar(String dni, char sexo){
        try{
            Connection conexion = conectar();
            String sql = "update `nacidos` set `Sexo` = '" + sexo +
                    "' where `nacidos`.`Dni` = '"+dni+"';";
            Statement statement = conexion.createStatement();
            statement.execute(sql);
        } catch (Exception ex){
            Logger.getLogger(NacidosDao.class.getName()).log(
            Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR al cambiar el sexo");
        }
    }  
//      muestra recien nacido a partir de un D.N.I ingresado por el usuario
    public void mostrarDni(String dni){
        try{
            Connection conexion = conectar();
            String sql = "select * from `nacidos` where `nacidos`.`Dni` = '" + dni + "';";
            Statement st;
            st = conexion.createStatement();
            ResultSet result = st.executeQuery(sql);
            boolean encontro = false;
                while(result.next()){
                    JOptionPane.showMessageDialog(null, "D.N.I: " + result.getString(1) +
                            "\nNombre: " + result.getString(2) +
                            "\nApellido: " + result.getString(3) +
                            "\nFecha: " + result.getString(4) + "/"+ result.getString(5)+"/"+result.getString(6)+
                            "\nSexo: " + result.getString(7));
                    encontro = true;
                }
                if(!encontro){
                        JOptionPane.showMessageDialog(null, "El D.N.I no se ha encontrado.");
                }
            } catch (Exception ex){
            Logger.getLogger(NacidosDao.class.getName()).log(
                    Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR al realizar la busqueda por D.N.I");
        }
    }
//      muestra recien nacido a partir de las primeras tres letras del apellido ingresado por el usuario
    public void mostrarApellido(String primerasTres){
        try{
            Connection conexion = conectar();
            String sql = "select * from `nacidos` where `nacidos`.`Apellido` like '" + primerasTres + "%';";
            Statement st;
            boolean encontro = false;
            st = conexion.createStatement();
            ResultSet result = st.executeQuery(sql);
            while(result.next()){
                    System.out.println("+++++++++++++++++++++++");
                    System.out.println("D.N.I: " + result.getString(1));
                    System.out.println("Nombre: " + result.getString(2));
                    System.out.println("Apellido: " + result.getString(3));
                    System.out.println("Fecha: " + result.getString(4) + 
                            "/"+ result.getString(5)+"/"+result.getString(6));
                    System.out.println("Sexo: " + result.getString(7));
                    System.out.println("+++++++++++++++++++++++");
                    System.out.println("");
                    encontro = true;
                }
                if(!encontro){
                        JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
                }
        } catch (Exception ex){
            Logger.getLogger(NacidosDao.class.getName()).log(
            Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "ERROR al realizar la busqueda por apellido");
        }
    }
      
}
