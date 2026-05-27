package Deber;

public class Validador {
    public static boolean campoVacio(String s){
        return s == null || s.trim().isEmpty();
    }

    public static boolean correoValido(String correo){
        return correo.contains("@") && correo.contains(".");
    }

    public static boolean telefonoValido(String telefono){
        return telefono.matches("\\d+");
    }
}
