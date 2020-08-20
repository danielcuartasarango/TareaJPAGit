package control;

import java.util.List;

import empleados.Empleado;
import empleados.FabricaEmpleados;
import persistencia.OrmEmpleados;
import persistencia.Repositorio;

/**
 * Clase que lleva el control de los empleados y sus nóminas
 * @author Sebastián Orozco Medina
 * @author Daniel Andrés Cuartas
 * @autor  Camilo Vargas
 * @version 1.0
 */
public class Control {
	
	
	private Repositorio repositorio;

	public Control() {
		repositorio = new OrmEmpleados();
	}

	/**
	 * Permite adicionar un empleado a la base de datos
	 * @param identificacion	Es la identificación del empleado
	 * @param nombre			Es el nombre del empleado
	 * @param horasLaboradas	Son las horas que laboró el empleado en una semana
	 * @param tipo				Es el tipo de empleado -> Asalariado, por horas, por comisión
	 * @param precioHora		Es el precio que cobra por horas el empleado por horas
	 * @param ventas			Son las ventas que realizó el empleado
	 * @param salario			Es el Salario base del empleado
	 * @return					Retorna si se pudo adicionar o no el empleado
	 */
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
	
	/**
	 * Permite calcular el valor de nóminas a pagar a los empleados
	 * @return	Retorna la nómina de la empresa
	 */
	public double valorNomina() {
		
			List<Empleado> empleados = repositorio.consultarEmpleados();
			double nomina = 0;
			for (Empleado empleado : empleados) {
				nomina += empleado.calcularSalario();
				System.out.println(nomina);
			}
			return nomina;
		}
	
	/**
	 * Busca un empleado de la empresa en la base de datos
	 * @param identificacion	Es la identificación del empleado a buscar
	 * @return		Retorna el empleado a buscar
	 */
	public Empleado buscarEmpleado(String identificacion) {
		return repositorio.buscarEmpleado(identificacion);
	}

}
