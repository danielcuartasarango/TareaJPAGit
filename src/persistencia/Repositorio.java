package persistencia;

import java.util.List;

import empleados.Empleado;


/**
 * 
 * @author Daniel Cuartas
 *
 */

public interface Repositorio {
	
	/**
	 * metodo para obtener la lista de empleados de la empresa
	 * @return una lista de empleados
	 */
	public List<Empleado> consultarEmpleados();
	
	/**
	 * adiciona un nuevo empleado a la empresa 
	 * @param empleado
	 * @return
	 */
	public abstract boolean adicionarEmpleado(Empleado empleado);
	
	/**
	 * 
	 * @param identificacion
	 * @return
	 */
	public abstract  Empleado buscarEmpleado(String identificacion);

	
	/**
	 * 
	 * @param empleado
	 * @return
	 */
	public abstract boolean borrarEmpleado(Empleado empleado);
	
}
