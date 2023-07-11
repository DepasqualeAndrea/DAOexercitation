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
		Event evento = new Event("ciao", "ciao di nuovo", TipoEvento.PUBBLICO, 100);

		EventoDAO ev = new EventoDAO(em);

		// salva evento

		ev.saveEvent(evento);

		System.out.println(evento);

		// evento trovato

		Event finded = ev.findEventById(UUID.fromString("94055471-7531-45de-8338-9cc41abf0383"));
		System.out.println(finded);
		System.out.println("Evento trovato Correttamente");

		// trovatoed eliminato

		ev.findByIdAndDelete(UUID.fromString("94055471-7531-45de-8338-9cc41abf0383"));

		// refresh

		ev.refresh(UUID.fromString("b9391b4f-a368-4b38-85c1-13f51402fe34"));
		// chiusura

		em.close();
		emf.close();
	}

}
