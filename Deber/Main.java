package Deber;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static EmpleadoServicio servicio = new EmpleadoServicio();

    public static void main(String[] args) {
        int op;

        do{
            System.out.println("\n===== CLINICA SALUD TOTAL =====");
            System.out.println("1. Registrar medico");
            System.out.println("2. Registrar administrativo");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Buscar por cedula");
            System.out.println("5. Reemplazar informacion");
            System.out.println("6. Eliminar registro");
            System.out.println("7. Calcular pagos");
            System.out.println("8. Mostrar estadisticas");
            System.out.println("9. Salir");

            try{
                op = Integer.parseInt(sc.nextLine());

                switch(op){
                    case 1: registrarMedico(); break;
                    case 2: registrarAdministrativo(); break;
                    case 3: servicio.mostrar(); break;
                    case 4: buscar(); break;
                    case 5: reemplazar(); break;
                    case 6: eliminar(); break;
                    case 7: calcularPagos(); break;
                    case 8: servicio.estadisticas(); break;
                    case 9: System.out.println("Saliendo..."); break;
                    default: System.out.println("Error: opcion invalida.");
                }
            }catch(Exception e){
                System.out.println("Error: opcion invalida.");
                op = 0;
            }

        }while(op != 9);
    }

    static String leerTexto(String msg){
        String dato;
        do{
            System.out.print(msg);
            dato = sc.nextLine();
        }while(Validador.campoVacio(dato));
        return dato;
    }

    static int leerEnteroPositivo(String msg){
        while(true){
            try{
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                if(n > 0) return n;
            }catch(Exception e){}
            System.out.println("Valor invalido.");
        }
    }

    static double leerDoublePositivo(String msg){
        while(true){
            try{
                System.out.print(msg);
                double n = Double.parseDouble(sc.nextLine());
                if(n > 0) return n;
            }catch(Exception e){}
            System.out.println("Valor invalido.");
        }
    }

    static void registrarMedico(){
        String cedula = leerTexto("Cedula: ");
        if(servicio.cedulaExiste(cedula)){
            System.out.println("Cedula duplicada.");
            return;
        }

        String nombre = leerTexto("Nombre: ");
        int edad = leerEnteroPositivo("Edad: ");
        String telefono;

        do{
            telefono = leerTexto("Telefono: ");
        }while(!Validador.telefonoValido(telefono));

        String correo;
        do{
            correo = leerTexto("Correo: ");
        }while(!Validador.correoValido(correo));

        String especialidad = leerTexto("Especialidad: ");
        int pacientes = leerEnteroPositivo("Pacientes atendidos: ");
        double valor = leerDoublePositivo("Valor consulta: ");

        servicio.registrar(new Medico(cedula,nombre,edad,telefono,correo,especialidad,pacientes,valor));
        System.out.println("Medico registrado.");
    }

    static void registrarAdministrativo(){
        String cedula = leerTexto("Cedula: ");
        if(servicio.cedulaExiste(cedula)){
            System.out.println("Cedula duplicada.");
            return;
        }

        String nombre = leerTexto("Nombre: ");
        int edad = leerEnteroPositivo("Edad: ");
        String telefono;

        do{
            telefono = leerTexto("Telefono: ");
        }while(!Validador.telefonoValido(telefono));

        String correo;
        do{
            correo = leerTexto("Correo: ");
        }while(!Validador.correoValido(correo));

        String dep = leerTexto("Departamento: ");
        int horas = leerEnteroPositivo("Horas trabajadas: ");
        double valor = leerDoublePositivo("Valor hora: ");

        servicio.registrar(new Administrativo(cedula,nombre,edad,telefono,correo,dep,horas,valor));
        System.out.println("Administrativo registrado.");
    }

    static void buscar(){
        try{
            String c = leerTexto("Cedula: ");
            Empleado e = servicio.buscar(c);
            if(e != null) e.mostrarInformacion();
            else System.out.println("Registro no encontrado.");
        }catch(Exception e){
            System.out.println("Error en busqueda.");
        }
    }

    static void reemplazar(){
        String c = leerTexto("Cedula a reemplazar: ");
        Empleado e = servicio.buscar(c);
        if(e == null){
            System.out.println("Registro no encontrado.");
            return;
        }

        String nombre = leerTexto("Nuevo nombre: ");
        e.setNombre(nombre);
        System.out.println("Informacion actualizada.");
    }

    static void eliminar(){
        String c = leerTexto("Cedula: ");
        if(servicio.eliminar(c))
            System.out.println("Registro eliminado.");
        else
            System.out.println("Registro no encontrado.");
    }

    static void calcularPagos(){
        for(Empleado e : servicio.getEmpleados()){
            System.out.println(e.getNombre() + ": " + e.calcularPago());
        }
    }
}
