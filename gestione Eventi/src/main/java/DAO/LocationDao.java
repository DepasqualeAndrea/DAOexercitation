package DAO;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.Location;

public class LocationDao {
	private final EntityManager em;

	public LocationDao(EntityManager em) {
		this.em = em;
	}
//metodo save

	public void saveLocation(Location ev) {
		EntityTransaction e = em.getTransaction();
		e.begin();
		em.persist(ev);
		e.commit();
		System.out.println("Location salvata correttamente");
	}

//metodo find	

	public Location findLocationById(UUID id) {

		Location trova = em.find(Location.class, id);
		return trova;
	}

//metodo delete

	public void findLocationByIdAndDelete(UUID id) {
		Location trova = em.find(Location.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Location eliminata con successo");
		} else {
			System.out.println("Location non trovata");
		}
	}

}
