package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ToolBox;

public class ToolBoxHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebToolBox");
	
			public void insertNewToolBox(ToolBox tb) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				em.persist(tb);
				em.getTransaction().commit();
				em.close();
			}
			
			public List<ToolBox> getToolBoxes() {
				EntityManager em = emfactory.createEntityManager();
				List<ToolBox> allContents = em.createQuery("SELECT tb FROM ToolBox tb").getResultList();
				return allContents;
			}
			
			public ToolBox searchForToolBoxById(Integer tempId) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				ToolBox found = em.find(ToolBox.class, tempId);
				em.close();
				return found;
			}
			
			public void deleteToolBox(ToolBox listToDelete) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();//ID or Id?
				TypedQuery<ToolBox> typedQuery = em.createQuery("select tb from ToolBox tb where tb.toolBoxId = :selectedId", ToolBox.class);
				typedQuery.setParameter("selectedId", listToDelete.getToolBoxId());
			
				typedQuery.setMaxResults(1);
				
				ToolBox result = typedQuery.getSingleResult();
				em.remove(result);
				em.getTransaction().commit();
				em.close();
			}
			
			public void updateToolBox(ToolBox toEdit) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
					
				em.merge(toEdit);
				em.getTransaction().commit();
				em.close();
			}
}
