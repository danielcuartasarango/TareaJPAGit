package empleados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * Clase que permite modelar un empleado por comisión
 * @author Sebastián Orozco Medina
 * @author Daniel Andrés Cuartas
 * @autor  Camilo Vargas
 * @version 1.0
 */
@Entity
@DiscriminatorValue("comision")
public class Comision extends Empleado{
	private double salario;
	private double ventas;
	public Comision() {
		// TODO Auto-generated constructor stub
	}
	
	public Comision(String identificacion,String nombre,double salario, double ventas) {
		super(identificacion, nombre);	
		this.salario=salario;
		this.ventas= ventas;
	}

	public double getVentas() {
		return ventas;
	}

	public void setVentas(double ventas) {
		this.ventas = ventas;
	}
	
	/**
	 * Calcula la comision por ventas del empleado y luego su salario semanal
	 * @return Retorna la suma de la comision por ventas mas el salario base del empleado
	 */
	public double calcularSalario() {
		double comision= this.ventas*0.05;
		return this.salario+comision;
	}
	

}
