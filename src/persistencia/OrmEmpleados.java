package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import empleados.Empleado;

/**
 * Clase que permite modelar la base de datos del sistema
 * @author Sebastián Orozco Medina
 * @author Daniel Andrés Cuartas
 * @autor  Camilo Vargas
 * @version 1.0
 */
public class OrmEmpleados implements Repositorio{

private EntityManager gestorBd;
	
	/** 
	 * La unidad de persistencia ("Persistence unit") llamada Barcos7
	 * está definida en el archivo de configuración persistence.xml,
	 * en la carpeta META-INF
	 */
	public OrmEmpleados() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Empleados");
		gestorBd = fabrica.createEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> consultarEmpleados() {
		Query query = gestorBd.createQuery("select b from Empleado b");
		List<Empleado> barcos = query.getResultList();
		return barcos;
	}

	@Override
	public boolean adicionarEmpleado(Empleado empleado) {
		try	{
			gestorBd.getTransaction().begin();
			gestorBd.persist(empleado);
			gestorBd.getTransaction().commit();
		}
		catch (Exception errorCrear)	{
			return false;
		}
		return true;
	}
	
	@Override
	public Empleado buscarEmpleado(String identificacion) {
		Empleado empleado = gestorBd.find(Empleado.class, identificacion);
		return empleado;
	}

	@Override
	public boolean borrarEmpleado(Empleado empleado) {
		try	{
			gestorBd.getTransaction().begin();
			// Esto funciona porque el EntityManager está abierto todo el tiempo
			// Y el objeto barco ha sido consultado previamente,
			// por lo que está "enlazado" con la base de datos.
			// Si no fuera el caso debe "enlazarse" (ver clase OrmBarcos2)
			gestorBd.remove(empleado);
			gestorBd.getTransaction().commit();
		}
		catch (Exception errorBorrar)	{
			return false;
		}
		return true;
	}
	
	/**
	 * Cierra el EntitiyManager cuando se vaya a destruir este objeto
	 */
	@Override
	protected void finalize() {
		gestorBd.close();
	}

}
