# Deber_integrador
Herencia:
Empleado es la clase padre y Medico y Administrativo son clases hijas.

Encapsulamiento:
Los atributos son privados y se accede mediante getters y setters.

Polimorfismo:
Se utiliza ArrayList<Empleado> para almacenar diferentes tipos de empleados.

Excepciones:
Se aplico try-catch para menu, conversiones, datos numericos y busquedas.

Conversiones:
Integer.parseInt()
Double.parseDouble()

Validaciones:
- Menu invalido
- Edad positiva
- Cedula duplicada
- Campos vacios
- Correo valido
- Telefono numerico
- Valores mayores a cero

- Empleado
- cedula
- nombre
- edad
- telefono
- correo
+ mostrarInformacion()
+ calcularPago()


Medico
- especialidad
- numeroPacientesAtendidos
- valorConsulta

- Administrativo
- departamento
- horasTrabajadas
- valorHora
