package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Owner;

public class OwnerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebToolBox");
	
			public void insertOwner(Owner o) {
			    EntityManager em = emfactory.createEntityManager();
			    em.getTransaction().begin();
			    em.persist(o);
			    em.getTransaction().commit();
			    em.close();
			}
			
			public List<Owner> showAllOwners() {
				EntityManager em = emfactory.createEntityManager();
				List<Owner> allOwners = em.createQuery("SELECT o FROM Owner o").getResultList();
				return allOwners;
			}
			
			public Owner searchForOwnerByName(String shopperName) {
				EntityManager em = emfactory.createEntityManager();
				em.getTransaction().begin();
				TypedQuery<Owner> typedQuery = em.createQuery("select o from Owner o where o.ownerName = :selectedName", Owner.class);
				typedQuery.setParameter("selectedName", shopperName);
				typedQuery.setMaxResults(1);

				Owner found = typedQuery.getSingleResult();
				em.close();
				return found;
			}
}
