package control;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import empleados.Asalariado;
import empleados.Comision;
import empleados.Empleado;
import empleados.Hora;

/**
 * Clase de pruebas a la clase Control
 * @author Sebastián Orozco Medina
 * @author Daniel Andrés Cuartas
 * @autor  Camilo Vargas
 * @version 1.0
 */
class ControlTest
{
	private Control control;
	
	/**
	 * Inicializa el objeto control para realizar las pruebas
	 */
	@BeforeEach
	public void configurar()
	{
		control = new Control();
	}
	
	/**
	 * Prueba que determina si se calcula la nomina correcta cuando no 
	 * hay empleados
	 */
//	@Test
	void testNominaSinEmpleados()
	{
		double nominaEsperada = 0;
		double nominaObtenida = control.valorNomina();
		assertEquals(nominaEsperada, nominaObtenida);
	}
	
	/**
	 * Prueba que se crean 3 empleados, uno de cada tipo, y se verifican
	 * sus datos con una consulta
	 */
//	@Test
	void testCreaYVerificaEmpleados()
	{	
		String idEmpleadoAsalariadoEsperado = "1";
		String nombreEmpleadoAsalariadoEsperado = "Sebastian";
		double salarioEmpleadoAsalariadoEsperado = 200000;
		
		String idEmpleadoPorHorasEsperado = "2";
		String nombreEmpleadoPorHorasEsperado = "Daniel";
		double horasEmpleadoPorHorasEsperado = 41;
		double preciohorasEmpleadoPorHorasEsperado = 12000;
		
		String idEmpleadoPorComisionEsperado = "3";
		String nombreEmpleadoPorComisionEsperado = "Camilo";
		double ventasEmpleadoPorComisionEsperado = 1000000;
		double salarioBaseEmpleadoPorComisionEsperado = 200000;
		
		
		//Se crea un empleado asalariado 
		control.adicionarEmpleado(idEmpleadoAsalariadoEsperado, nombreEmpleadoAsalariadoEsperado,
								  0, 'a', 0, 0, salarioEmpleadoAsalariadoEsperado);
		//Se crea un empleado por horas 
		control.adicionarEmpleado(idEmpleadoPorHorasEsperado, nombreEmpleadoPorHorasEsperado,
								  horasEmpleadoPorHorasEsperado, 'h', 
								  preciohorasEmpleadoPorHorasEsperado, 0, 0);
		//Se crea un empleado por comisión 
		control.adicionarEmpleado(idEmpleadoPorComisionEsperado, nombreEmpleadoPorComisionEsperado, 
								  0, 'v', 0, ventasEmpleadoPorComisionEsperado,
								  salarioBaseEmpleadoPorComisionEsperado);
		//salarioBaseEmpleadoPorComisionEsperado += ventasEmpleadoPorComisionEsperado*0.05;
		
		
		//Se obtiene el empleado asalariado que se ingreso a la base de datos
		Asalariado empleadoAsalariado = (Asalariado) control.buscarEmpleado("1");
		
		String idEmpleadoAsalariadoObtenido = empleadoAsalariado.getIdentificacion();
		String nombreEmpleadoAsalariadoObtenido = empleadoAsalariado.getNombre();
		double salarioEmpleadoAsalariadoObtenido = empleadoAsalariado.getSalario();
		
		
		//Se obtiene el empleado por horas que se ingreso a la base de datos
		Hora empleadoPorHoras = (Hora) control.buscarEmpleado("2");
		
		String idEmpleadoPorHorasObtenido = empleadoPorHoras.getIdentificacion();
		String nombreEmpleadoPorHorasObtenido = empleadoPorHoras.getNombre();
		double horasEmpleadoPorHorasObtenido = empleadoPorHoras.getHorasLaboradas();
		double preciohorasEmpleadoPorHorasObtenido = empleadoPorHoras.getPrecioHora();
		
		
		
		//Se obtiene el empleado por comisión que se ingreso a la base de datos
		Comision empleadoPorComision = (Comision) control.buscarEmpleado("3");
		
		String idEmpleadoPorComisionObtenido = empleadoPorComision.getIdentificacion();
		String nombreEmpleadoPorComisionObtenido = empleadoPorComision.getNombre();
		double ventasEmpleadoPorComisionObtenido = empleadoPorComision.getVentas();
		double salarioBaseEmpleadoPorComisionObtenido = empleadoPorComision.calcularSalario();
		
		
		assertAll(() -> assertEquals(idEmpleadoAsalariadoEsperado, idEmpleadoAsalariadoObtenido),
				  () -> assertEquals(nombreEmpleadoAsalariadoEsperado, nombreEmpleadoAsalariadoObtenido),
				  () -> assertEquals(salarioEmpleadoAsalariadoEsperado, salarioEmpleadoAsalariadoObtenido),
				  
				  () -> assertEquals(idEmpleadoPorHorasEsperado, idEmpleadoPorHorasObtenido),
				  () -> assertEquals(nombreEmpleadoPorHorasEsperado, nombreEmpleadoPorHorasObtenido),
				  () -> assertEquals(horasEmpleadoPorHorasEsperado, horasEmpleadoPorHorasObtenido),
				  () -> assertEquals(preciohorasEmpleadoPorHorasEsperado, preciohorasEmpleadoPorHorasObtenido),
				  
				  () -> assertEquals(idEmpleadoPorComisionEsperado, idEmpleadoPorComisionObtenido),
				  () -> assertEquals(nombreEmpleadoPorComisionEsperado, nombreEmpleadoPorComisionObtenido),
				  () -> assertEquals(ventasEmpleadoPorComisionEsperado, ventasEmpleadoPorComisionObtenido),
				  () -> assertEquals(salarioBaseEmpleadoPorComisionEsperado + ventasEmpleadoPorComisionEsperado*0.05,
						  salarioBaseEmpleadoPorComisionObtenido)
				  );
	}
	
	
	/**
	 * Prueba que se obtiene la nomina correcta de 3 empleados
	 */
	@Test
	void testVerificaNominaEmpleados()
	{
		String idEmpleadoAsalariadoEsperado = "4";
		String nombreEmpleadoAsalariadoEsperado = "Sebastian";
		double salarioEmpleadoAsalariadoEsperado = 200000;
		
		String idEmpleadoPorHorasEsperado = "5";
		String nombreEmpleadoPorHorasEsperado = "Daniel";
		double horasEmpleadoPorHorasEsperado = 41;
		double preciohorasEmpleadoPorHorasEsperado = 12000;
		
		String idEmpleadoPorComisionEsperado = "6";
		String nombreEmpleadoPorComisionEsperado = "Camilo";
		double ventasEmpleadoPorComisionEsperado = 1000000;
		double salarioBaseEmpleadoPorComisionEsperado = 200000;
		
		
		//Se crea un empleado asalariado 
		control.adicionarEmpleado(idEmpleadoAsalariadoEsperado, nombreEmpleadoAsalariadoEsperado,
								  0, 'a', 0, 0, salarioEmpleadoAsalariadoEsperado);
		//Se crea un empleado por horas 
		control.adicionarEmpleado(idEmpleadoPorHorasEsperado, nombreEmpleadoPorHorasEsperado,
								  horasEmpleadoPorHorasEsperado, 'h', 
								  preciohorasEmpleadoPorHorasEsperado, 0, 0);
		//Se crea un empleado por comisión 
		control.adicionarEmpleado(idEmpleadoPorComisionEsperado, nombreEmpleadoPorComisionEsperado, 
								  0, 'v', 0, ventasEmpleadoPorComisionEsperado,
								  salarioBaseEmpleadoPorComisionEsperado);
		
		double nominaEsperado = 200000 + (41*12000)+200000 + 250000;
		
		double nominaObtenido = control.valorNomina();
		
		assertEquals(nominaEsperado, nominaObtenido);
		
	}
	

}
