package Deber;

import java.util.ArrayList;

public class EmpleadoServicio {
    private ArrayList<Empleado> empleados = new ArrayList<>();

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public boolean cedulaExiste(String cedula){
        return buscar(cedula) != null;
    }

    public void registrar(Empleado e){
        empleados.add(e);
    }

    public void mostrar(){
        if(empleados.isEmpty()){
            System.out.println("No hay registros.");
            return;
        }
        for(Empleado e : empleados){
            System.out.println("----------------");
            e.mostrarInformacion();
        }
    }

    public Empleado buscar(String cedula){
        for(Empleado e : empleados){
            if(e.getCedula().equals(cedula)){
                return e;
            }
        }
        return null;
    }

    public boolean eliminar(String cedula){
        Empleado e = buscar(cedula);
        if(e != null){
            empleados.remove(e);
            return true;
        }
        return false;
    }

    public void estadisticas(){
        int medicos=0, administrativos=0;
        double pagoMed=0, pagoAdm=0;
        Empleado mayor=null;

        for(Empleado e: empleados){
            if(e instanceof Medico){
                medicos++;
                pagoMed += e.calcularPago();
            } else {
                administrativos++;
                pagoAdm += e.calcularPago();
            }

            if(mayor == null || e.calcularPago() > mayor.calcularPago()){
                mayor = e;
            }
        }

        System.out.println("Total medicos: " + medicos);
        System.out.println("Total administrativos: " + administrativos);
        System.out.println("Total empleados: " + empleados.size());
        System.out.println("Pago total medicos: " + pagoMed);
        System.out.println("Pago total administrativos: " + pagoAdm);

        if(mayor != null){
            System.out.println("Empleado con mayor ingreso: " + mayor.getNombre() + " - " + mayor.calcularPago());
        }
    }
}
