package empleados;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

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

}
