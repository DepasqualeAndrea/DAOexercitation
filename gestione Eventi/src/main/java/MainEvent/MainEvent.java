package MainEvent;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Entities.Event;
import Entities.EventoDAO;
import Entities.JpaUtil;
import Entities.TipoEvento;

public class MainEvent {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		creazioneDb();

	}

	public static void creazioneDb() {
		EntityManager em = emf.createEntityManager();
		Event evento = new Event("Concerto Ultimo", "Concerto di beneficienza", TipoEvento.PUBBLICO, 1000);
		EventoDAO ev = new EventoDAO(em);
		ev.saveEvent(evento);
		System.out.println(evento);

		Event finded = ev.findEventById(UUID.fromString("8ecca0e9-3b10-4bec-a67b-44f70c9da692"));
		System.out.println(finded);
		System.out.println("Evento trovato Correttamente");

		ev.findByIdAndDelete(UUID.fromString("8ecca0e9-3b10-4bec-a67b-44f70c9da692"));

		em.close();
		emf.close();
	}

}
