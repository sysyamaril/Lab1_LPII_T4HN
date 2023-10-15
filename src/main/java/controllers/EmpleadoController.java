package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;

public class EmpleadoController {
	//Creacion empleado
	
	public String createEmpleado(String apellidos, String nombres, int edad, String sexo, double salario) {
	    SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
	    Session session = sessionFactory.openSession();

	    try {
	        session.beginTransaction();
	        Empleado empleado = new Empleado(apellidos, nombres, edad, sexo, salario);
	        session.save(empleado);
	        session.getTransaction().commit();
	        return "Empleado creado";
	    } catch (Exception e) {
	        e.printStackTrace();
	        session.getTransaction().rollback();
	    } finally {
	        session.close();
	        sessionFactory.close();
	    }

	    return "Error al crear Empleado";
	}

	    //Eliminar Empleado
		
		public String deleteEmpleado(int idEmpleado) {
			
			SessionFactory sessionFactory;
			sessionFactory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		  
			Session session;
			session =sessionFactory.openSession();
			
			try {
				 session.beginTransaction();
				 Empleado Empleado=session.get(Empleado.class, idEmpleado);
				 session.delete(Empleado);
				 session.getTransaction().commit();
				 
				 sessionFactory.close();
				 
				 return "Empleado eliminado correctamente";
				
			}
			catch(Exception e) {
				
				e.printStackTrace();

			}
			
			return "Error al eliminar Empleado";
					
			
		}

		
		//Actualizar  o modificar Empleado
		
		public String updateEmpleado(int idEmpleado,String apellidos) {
			
			SessionFactory sessionFactory;
			sessionFactory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session;
			session = sessionFactory.openSession();
			
			try {
				session.beginTransaction();
				
				Empleado Empleado=session.get(Empleado.class,idEmpleado);
				Empleado.setApellidos(apellidos);
				session.update(Empleado);
				session.getTransaction().commit();
				
				sessionFactory.close();
				
				return "Empleado actualizado correctamente";
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
	        return "Error al actualizar Empleado";
		}
		
		public static String getEmpleado(int idempleado) {
			
			SessionFactory sessionFactory;
			sessionFactory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session;
			session = sessionFactory.openSession();
			
			try {
				session.beginTransaction();
				Empleado empleado=session.get(Empleado.class,idempleado);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return empleado.toString();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
	        return "Usuario no existe";
		}
		

}

