package control;

import java.util.List;

import empleados.Empleado;
import empleados.FabricaEmpleados;
import persistencia.OrmEmpleados;
import persistencia.Repositorio;


public class Control {
	
	
	private Repositorio repositorio;

	public Control() {
		repositorio = new OrmEmpleados();
	}


	public boolean adicionarEmpleado(String identificacion, String nombre,
			double horasLaboradas, char tipo, double precioHora,  double ventas, double salario ) 
			 {

				Empleado empleadoBuscado = repositorio.buscarEmpleado(identificacion);
				if (empleadoBuscado == null) {
					Empleado empleadoNuevo = FabricaEmpleados.crearEmpleado(identificacion, nombre,
							horasLaboradas, tipo, precioHora,   ventas,  salario );
					return repositorio.adicionarEmpleado(empleadoNuevo);
				}
				return false;
			}
	
	public double valorNomina() {
		
			List<Empleado> empleados = repositorio.consultarEmpleados();
			double nomina = 0;
			for (Empleado empleado : empleados) {
				nomina += empleado.calcularSalario();
				System.out.println(nomina);
			}
			return nomina;
		}
	

}
