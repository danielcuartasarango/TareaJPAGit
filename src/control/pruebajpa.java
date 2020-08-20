package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import empleados.Asalariado;
import empleados.Empleado;
import empleados.Hora;

public class pruebajpa {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica =
				Persistence.createEntityManagerFactory("Empleados");
				EntityManager gestorBD = fabrica.createEntityManager();
				gestorBD.getTransaction().begin();
				Empleado empleado =  new Asalariado("100005","simon", 5000);
				Empleado empleado2 =  new Hora("100601","simon", 5,2500);
				
				gestorBD.persist(empleado);
				gestorBD.persist(empleado2);
				gestorBD.getTransaction().commit();
				Empleado empleadoBuscado= gestorBD.find(Empleado.class, "100001");
				System.out.println(empleadoBuscado.getNombre());
				gestorBD.close();
				
			
		
		Control control = new Control();
		double valor=control.valorNomina();
		System.out.println("el valor de la nomina es de "+valor);


	}

}
