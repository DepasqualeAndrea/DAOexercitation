package Entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import Enum.Stato;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Partecipazione")
@Getter
@Setter
@NoArgsConstructor
public class Partecipazione {
	@Id
	@GeneratedValue
	private UUID id;
	@Enumerated(EnumType.STRING)
	private Stato stato;

	@ManyToOne
	@JoinColumn(name = "persona_id", referencedColumnName = "id")
	private Persona persona;

	@ManyToOne
	@JoinColumn(name = "event_id", referencedColumnName = "id")
	private Event event;

	public Partecipazione(Persona people, Event event, Stato stato) {
		super();
		this.persona = people;
		this.event = event;
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", persona=" + persona + ", evento=" + event + ", stato=" + stato + "]";
	}

}
