package control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import empleados.Asalariado;
import empleados.Empleado;

public class pruebajpa {

	public static void main(String[] args) {
		EntityManagerFactory fabrica =
				Persistence.createEntityManagerFactory("Empleados");
				EntityManager gestorBD = fabrica.createEntityManager();
				gestorBD.getTransaction().begin();
				Empleado empleado =  new Asalariado("100001","simon", 2300);
				
				gestorBD.persist(empleado);
				gestorBD.getTransaction().commit();
				Empleado empleadoBuscado= gestorBD.find(Empleado.class, "100001");
				System.out.println(empleadoBuscado.getNombre());
				gestorBD.close();


	}

}
