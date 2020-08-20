package empleados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase que permite modelar un empleado asalariado
 * @author Sebastián Orozco Medina
 * @author Daniel Andrés Cuartas
 * @autor  Camilo Vargas
 * @version 1.0
 */
@Entity
@DiscriminatorValue("asalariado")
public class Asalariado extends Empleado {
	private double salario;
	
	
	public Asalariado() {
		// TODO Auto-generated constructor stub
	}
	
	public Asalariado(String identificacion, String nombre,double salario) {
		super(identificacion, nombre);
		this.salario=salario;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	/**
	 * @retorna el salario semanal del empleado
	 */
	public double calcularSalario() {
		return this.salario;
	}
	

}
