package it.uniroma3.siw.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Stylist {
	private String nome;
	private String cognome;
	private String indirizzo;
	private String email;
	@OneToMany
	private List<Dress> dresses;
}
