package empleados;



public class FabricaEmpleados {
	
	
	public static Empleado crearEmpleado(String identificacion, String nombre,
			double horasLaboradas, char tipo, double precioHora,  double ventas, double salario ) {
		switch (tipo){
			case 'a':
			case 'A': 	return new Asalariado(identificacion,nombre, salario);
			case 'h':
			case 'H': 	return new Hora(identificacion, nombre, horasLaboradas, precioHora);
			case 'v':
			case 'V': 	return new Comision(identificacion, nombre,ventas);
		}
		return null;
	}

}
