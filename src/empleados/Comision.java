package empleados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
/**
 * Clase de empleados que ganan un salario semanal fijo
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
		double comision= ((this.salario/100)*5)*this.ventas;
		return this.salario+comision;
	}
	

}
