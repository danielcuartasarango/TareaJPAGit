package empleados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("comision")
public class Comision extends Empleado{
	
	private double ventas;
	public Comision() {
		// TODO Auto-generated constructor stub
	}
	
	public Comision(String identificacion,String nombre,double ventas) {
		super(identificacion, nombre);
		this.ventas= ventas;
	}
	
	

}
