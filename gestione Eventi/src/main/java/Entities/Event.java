package Entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eventi")
public class Event {
	@Id // genera un id indipendente
	@GeneratedValue // generea un id univoco per ogni evento che abbiamo nel main
	private UUID id;
	private String titolo;
	private String descrizione;
	@Enumerated(EnumType.STRING) // rendere stringa gli enum, altrimenti prendono valore 0/1 ossia vero o falso
	private TipoEvento evento;
	private long numeroMassimoPartecipanti;

	public Event() {

	}

	public Event(String titolo, String descrizione, TipoEvento evento, long numeroMassimoPartecipanti) {
		super();
		this.evento = evento;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getEvento() {
		return evento;
	}

	public void setEvento(TipoEvento evento) {
		this.evento = evento;
	}

	public long getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(long numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", titolo=" + titolo + ", descrizione=" + descrizione + ", evento=" + evento
				+ ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + ", getTitolo()=" + getTitolo()
				+ ", getDescrizione()=" + getDescrizione() + ", getEvento()=" + getEvento()
				+ ", getNumeroMassimoPartecipanti()=" + getNumeroMassimoPartecipanti() + "]";
	}

}
