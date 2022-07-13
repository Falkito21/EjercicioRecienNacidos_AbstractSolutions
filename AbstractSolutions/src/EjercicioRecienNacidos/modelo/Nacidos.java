package EjercicioRecienNacidos.modelo;

public class Nacidos {
    private String dni;
    private String nombre;
    private String apellido;
    private int dia;
    private int mes;
    private int anio;
    private char sexo;

    public Nacidos(String dni, String nombre, String apellido, int dia, int mes, int anio, char sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
        this.sexo = sexo;
    }
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}

