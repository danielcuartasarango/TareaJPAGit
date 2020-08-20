package empleados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("hora")
public class Hora extends Empleado {
	double horasLaboradas;
	double precioHora;
	public Hora() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Hora(String identificacion, String nombre, double horasLaboradas, double precioHora) {
		super(identificacion, nombre);
		this.horasLaboradas=horasLaboradas;
		this.precioHora= precioHora;
		
	}


	public double getHorasLaboradas() {
		return horasLaboradas;
	}


	public void setHorasLaboradas(double horasLaboradas) {
		this.horasLaboradas = horasLaboradas;
	}


	public double getPrecioHora() {
		return precioHora;
	}


	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}
	
	/**
	 * @return Retorna el salario correspondiente a las horas trabajadas
	 * 		   por el salario establecido.
	 */
	public double calcularSalario() {
		return this.precioHora*this.horasLaboradas;
	}

}
