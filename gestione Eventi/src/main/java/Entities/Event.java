package Entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Enum.TipoEvento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "eventi")
@Getter
@Setter
@NoArgsConstructor
public class Event {
	@Id // genera un id indipendente
	@GeneratedValue // generea un id univoco per ogni evento che abbiamo nel main
	private UUID id;
	private String titolo;
	private String descrizione;
	@Enumerated(EnumType.STRING) // rendere stringa gli enum, altrimenti prendono valore 0/1 ossia vero o falso
	private TipoEvento evento;
	private long numeroMassimoPartecipanti;

	// fk per la parteipazione
	@OneToMany(mappedBy = "event")
	// @OrderBy("nome DESC")
	private Set<Partecipazione> partecipazione;

	// da evento a location

	@ManyToOne
	@JoinColumn(name = "location_id", referencedColumnName = "id")
	private Location location;

	public Event(String titolo, String descrizione, TipoEvento evento, long numeroMassimoPartecipanti) {
		super();
		this.evento = evento;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", evento=" + evento
				+ ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "]";
	}

}
