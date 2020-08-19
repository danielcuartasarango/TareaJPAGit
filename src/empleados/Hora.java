package empleados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("hora")
public class Hora extends Empleado {
	double horasLaboradas=0;
	double precioHora=0;
	public Hora() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Hora(String identificacion, String nombre, double horasLaboradas, double precioHora) {
		super(identificacion, nombre);
		this.horasLaboradas=horasLaboradas;
		this.precioHora= precioHora;
		
	}

}
