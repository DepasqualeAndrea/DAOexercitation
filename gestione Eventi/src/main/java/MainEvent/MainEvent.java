package MainEvent;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import DAO.EventoDAO;
import DAO.LocationDao;
import DAO.PartecipazioneDao;
import DAO.PersonaDao;
import Entities.Event;
import Entities.Location;
import Entities.Partecipazione;
import Entities.Persona;
import Enum.Sesso;
import Enum.Stato;
import Enum.TipoEvento;
import Util.JpaUtil;

public class MainEvent {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {

		creazioneDb();

	}

	public static void creazioneDb() {
		EntityManager em = emf.createEntityManager();
		// creazione persona
		Persona persona = new Persona("Luca", "Greco", "luca@live.com", LocalDate.now(), Sesso.MASCHIO);
		PersonaDao p = new PersonaDao(em);
		// creazione evento
		Event evento = new Event("Concerto Ultimo", "Ad un passo da te ", TipoEvento.PUBBLICO, 2000);
		EventoDAO ev = new EventoDAO(em);
		// partecipazione
		Partecipazione part = new Partecipazione(persona, evento, Stato.CONFERMATO);
		PartecipazioneDao pt = new PartecipazioneDao(em);
		// salva evento
		Location loc = new Location("Ascoli Piceno", "Marche");
		LocationDao lo = new LocationDao(em);

		// salvataggio classi
		p.savePersona(persona);
		ev.saveEvent(evento);
		pt.savePartecipazione(part);
		lo.saveLocation(loc);

		System.out.println(evento);

		// evento trovato

//		Event finded = ev.findEventById(UUID.fromString("94055471-7531-45de-8338-9cc41abf0383"));
//		System.out.println(finded);
//		System.out.println("Evento trovato Correttamente");

		// trovatoed eliminato

		// ev.findByIdAndDelete(UUID.fromString("94055471-7531-45de-8338-9cc41abf0383"));

		// chiusura

		em.close();
		emf.close();
	}

}
