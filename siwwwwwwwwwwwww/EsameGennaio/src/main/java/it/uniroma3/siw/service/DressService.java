package it.uniroma3.siw.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.uniroma3.siw.model.Dress;
import it.uniroma3.siw.repository.DressRepository;

public class DressService {
	@Autowired DressRepository dressRepository;
	
	public void inserisciVestito(Dress vestito) {
		dressRepository.save(vestito);
	} 
	
	public List<Dress> tuttiIVestiti() { 
	    List<Dress> all = new ArrayList<Dress>();
	    for (Dress p: dressRepository.findAll()) {
	        all.add(p);
	    }
	    return all;
	}
	
	public List<Dress> trovaVestitiPerPrezzo(int prezzo) { 
	    List<Dress> trovati = new ArrayList<Dress>();
	    for (Dress p: dressRepository.findByPrezzo(prezzo)) {
	    	trovati.add(p);
	    }
	    return trovati;
	}

}

