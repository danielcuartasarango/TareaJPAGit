package persistencia;

import java.util.List;

import empleados.Empleado;

/**
 * repositorio donde se almacenar� la informaci�n del sistema
 * @author Sebasti�n Orozco Medina
 * @author Daniel Andr�s Cuartas
 * @autor  Camilo Vargas
 * @version 1.0
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
