package com.example.profesores_Logica;

import com.example.profesores_Datos.Departamento;
import com.example.profesores_Datos.Profesor;
import com.vaadin.ui.Notification;

import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class crud {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProfesoresVaadin");
	
	public ArrayList<Profesor> getProfesores()
	{
		EntityManager em = emf.createEntityManager();//Select UPPER(e.ename) from Employee e
		Query q = em.createQuery("Select u from Profesor u");//
		ArrayList<Profesor> lista_profesores =new ArrayList<Profesor>(q.getResultList());
		return lista_profesores;
	}
	
	public String getDepartamento(int codigo)
	{
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u from Departamento u where u.depCodigo=:depCodigo");
		q.setParameter("depCodigo", codigo);
		ArrayList<Departamento> lista_dep =new ArrayList<Departamento>(q.getResultList());
		return lista_dep.get(0).getNombre();
		
	}
	public ArrayList<Profesor> getProfesor(String email)
	{
		EntityManager em2 = emf.createEntityManager();
		Query q = em2.createQuery("Select u from Profesor u where u.email=:email");
		q.setParameter("email", email);
		ArrayList<Profesor> profesor =new ArrayList<Profesor>(q.getResultList());
		return profesor;
	}
	public void deleteProfesor(String email)
	{
		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("ProfesoresVaadin");
		EntityManager em = emf2.createEntityManager();
		EntityTransaction emm=em.getTransaction();
		emm.begin();
		Query q = em.createQuery("Delete from Profesor r where r.email=:email");
		q.setParameter("email", email);
		q.executeUpdate();
		emm.commit();
		Notification.show("Registro Eliminado");
	}
	
	
	public void updateProfesor(String email,String nom,String fecha,int tel,String dir,int codigo)
	{
		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("ProfesoresVaadin");
		EntityManager em = emf2.createEntityManager();
		EntityTransaction emm=em.getTransaction();
		emm.begin();
		Query q = em.createQuery("UPDATE Profesor r SET  r.nombres=:nombres, r.fechaNacimiento=:fechaNacimiento, r.telefono=:telefono, r.direccion=:direccion, r.depCodigo=:depCodigo where r.email=:email");
		q.setParameter("email", email);
		q.setParameter("nombres", nom);
		q.setParameter("fechaNacimiento", fecha);
		q.setParameter("telefono", tel);
		q.setParameter("direccion", dir);
		q.setParameter("depCodigo", codigo);
		q.executeUpdate();
		emm.commit();
	}
	
	public void addProfesor(String email,String nom,String fecha,int tel,String dir,int codigo)
	{

		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("ProfesoresVaadin");
		EntityManager em = emf2.createEntityManager();
		EntityTransaction emm=em.getTransaction();
		
		if(!validacion(email))
		{
			em.getTransaction().begin();
			Profesor profe=new Profesor();
			profe.setEmail(email);
			profe.setNombres(nom);
			profe.setFechaNacimiento(fecha);
			profe.setTelefono(tel);
			profe.setDireccion(dir);
			profe.setDepCodigo(codigo);
			em.persist(profe);
			em.getTransaction().commit();
			Notification.show("Profesor\n  Insertado con Exito");
		}else{Notification.show("La clave ya existe");}
		
	}
	
	public boolean validacion(String clave)
	{
		ArrayList<Profesor> listap =new ArrayList<Profesor>();
		listap=getProfesores();
		boolean repetida=false;
		
		for(int i=0;i<listap.size();i++)
		{
			if(listap.get(i).getEmail()==clave)
			{
				repetida=true;
			}
		}return repetida;
	}
}
