package Entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import Enum.Sesso;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Partecipazione")
@Getter
@Setter
@NoArgsConstructor
public class Persona {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate data_nascita;
	@Enumerated(EnumType.STRING)
	private Sesso sesso;

	@OneToMany(mappedBy = "persona")
	// @OrderBy("nome DESC")
	private Set<Partecipazione> partecipazione;

	public Persona(String nome, String cognome, String email, LocalDate data_nascita, Sesso sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.data_nascita = data_nascita;
		this.sesso = sesso;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", data_nascita="
				+ data_nascita + ", sesso=" + sesso + "]";
	}

}
