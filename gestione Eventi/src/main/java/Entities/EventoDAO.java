package Entities;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
	private final EntityManager em;

	public EventoDAO(EntityManager em) {
		this.em = em;
	}
//metodo save

	public void saveEvent(Event ev) {
		EntityTransaction e = em.getTransaction();
		e.begin();
		em.persist(ev);
		e.commit();
		System.out.println("Evento salvato correttamente");
	}

//metodo find	

	public Event findEventById(UUID id) {

		Event trova = em.find(Event.class, id);
		return trova;
	}

//metodo delete

	public void findByIdAndDelete(UUID id) {
		Event trova = em.find(Event.class, id);
		if (trova != null) {
			EntityTransaction t = em.getTransaction();
			t.begin();
			em.remove(trova);
			t.commit();
			System.out.println("Evento eliminato con successo");
		} else {
			System.out.println("Evento non trovato");
		}
	}

//metodo refresh

	public void refresh(UUID id) {
		Event trova = em.find(Event.class, id);
		em.refresh(trova);

	}

}
