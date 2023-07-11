package MainEvent;

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
		Event evento = new Event("Andrea De Pasquale", "Alla ricerca di un ventilatore", TipoEvento.PUBBLICO, 2000);
		EventoDAO ev = new EventoDAO(em);

		// salva evento

		ev.saveEvent(evento);

		System.out.println(evento);

		// evento trovato

		// Event finded =
		// ev.findEventById(UUID.fromString("c0322bb8-e603-46c1-90b8-477be461f6af"));
		// System.out.println(finded);
		// System.out.println("Evento trovato Correttamente");

		// trovatoed eliminato

		// ev.findByIdAndDelete(UUID.fromString("785ff35d-91c0-44fb-ac56-bd0873470627"));

		// chiusura

		em.close();
		emf.close();
	}

}
