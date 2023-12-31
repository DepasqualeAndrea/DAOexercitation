package Entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
public class Location {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String citta;

	@OneToMany(mappedBy = "location")
//	@OrderBy("nome DESC")
	private Set<Event> event;

	public Location(String nome, String citta) {
		this.nome = nome;
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", nome=" + nome + ", citta=" + citta + "]";
	}

}
