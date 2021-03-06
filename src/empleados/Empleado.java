package empleados;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Clase que permite modelar un empleado de la empresa
 * @author Sebasti�n Orozco Medina
 * @author Daniel Andr�s Cuartas
 * @autor  Camilo Vargas
 * @version 1.0
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class Empleado {
	@Id
	private String identificacion;
	private String nombre;

	
	
	public Empleado() {
		
	}
	
	public Empleado(String identificacion, String nombre) {
		this.identificacion= identificacion;
		this.nombre= nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
	/**
	 * Metodo abstracto para calcular salario de los empleados
	 */
	public abstract double calcularSalario();

	
}

