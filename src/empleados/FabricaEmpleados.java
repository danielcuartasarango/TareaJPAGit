package empleados;



public class FabricaEmpleados {
	
	
	public static Empleado crearEmpleado(String identificacion, String nombre,
			double horasLaboradas, char tipo, double ventas, double salario ) {
			
		Empleado empleado=null;
		
		if(tipo=='a'||tipo=='A')
			empleado= new Asalariado(identificacion, nombre, salario);
		
		if(tipo=='c'||tipo=='C')
			empleado = new Comision(identificacion,nombre,salario,ventas);
		
		if(tipo=='h'||tipo=='H')
			empleado = new Hora(identificacion,nombre,horasLaboradas,salario);
		
		return empleado;
	}

}
