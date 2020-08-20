package empleados;


/**
 * Clase F�brica de objetos empleados dependiendo el tipo de empleado que sea
 * @author Sebasti�n Orozco Medina
 * @author Daniel Andr�s Cuartas
 * @autor  Camilo Vargas
 * @version 1.0
 */

public class FabricaEmpleados {
	
	
	
	public static Empleado crearEmpleado(String identificacion, String nombre,
			double horasLaboradas, char tipo, double precioHora,  double ventas, double salario ) {
		switch (tipo){
			case 'a':
			case 'A': 	return new Asalariado(identificacion,nombre, salario);
			case 'h':
			case 'H': 	return new Hora(identificacion, nombre, horasLaboradas, precioHora);
			case 'v':
			case 'V': 	return new Comision(identificacion, nombre,salario,ventas);
		}
		return null;
	}

}
