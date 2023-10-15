package views;

import controllers.EmpleadoController;

public class EmpleadoView1 {
	
	public static void main (String[] args) {
		
		String empleado;
		//---Metodo CreateEmpleado--------------------------------------------------
	    //--empleado= new EmpleadoController().createEmpleado("Sysy","Martinez",29,"Femenino",8000);
		
		//---Metodo DeleteEmpleado--------------------------------------------------
	    //--empleado= new EmpleadoController().deleteEmpleado(1);		
		
		//---Metodo UpdateEmpleado--------------------------------------------------
	    //--empleado= new EmpleadoController().updateEmpleado(2,"Paz");

		//---Metodo GetEmpleado--------------------------------------------------
		empleado= new EmpleadoController().getEmpleado(3);
		
		System.out.print(empleado);
	}
}
