package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Tool;

public class ToolHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebToolBox");
	
	public void insertTool(Tool t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Tool> showAllTools() {
		EntityManager em = emfactory.createEntityManager();
		List<Tool> allTools = em.createQuery("SELECT t FROM Tool t").getResultList();
		return allTools;
	}
	
	public void	deleteTool(Tool toDelete)	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Tool>typedQuery = em.createQuery(
				"select t from Tool t where t.toolName = :selectedName",
				Tool.class);
		typedQuery.setParameter("selectedName", toDelete.getToolName());
		
		typedQuery.setMaxResults(1);
		
		Tool result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Tool searchForToolById(int idToEdit)	{
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    Tool found = em.find(Tool.class, idToEdit);
	    em.close();
	    return found;
	}
	
	public List<Tool> searchForToolByName(String toolName)	{
	    EntityManager em = emfactory.createEntityManager();
	    em.getTransaction().begin();
	    TypedQuery<Tool> typedQuery = em.createQuery("select t from Tool t where t.toolName = :selectedName", Tool.class);
	    typedQuery.setParameter("selectedName", toolName);
	    List<Tool>	found =	typedQuery.getResultList();
	    em.close();
	    return found;
	}
	
	public void updateTool(Tool toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);	
		em.getTransaction().commit();
		em.close();
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
