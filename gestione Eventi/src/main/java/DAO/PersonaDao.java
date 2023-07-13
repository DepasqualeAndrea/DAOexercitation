package DAO;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import Entities.Persona;

public class PersonaDao {
	private final EntityManager em;

	public PersonaDao(EntityManager em) {
		this.em = em;
	}
//metodo save

	public void savePersona(Persona ev) {
		EntityTransaction e = em.getTransaction();
		e.begin();
		em.persist(ev);
		e.commit();
		System.out.println("Persona salvata correttamente");
	}

//metodo find	

	public Persona findPersonaById(UUID id) {

		Persona trova = em.find(Persona.class, id);
		return trova;
	}

//metodo delete

	public void findPersonaByIdAndDelete(UUID id) {
		Persona trova = em.find(Persona.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Persona eliminata con successo");
		} else {
			System.out.println("Persona non trovata");
		}
	}

}
