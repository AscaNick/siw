package it.uniroma3.siw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.model.Dress;
import it.uniroma3.siw.repository.DressRepository;
@Controller
public class DressController {
	@Autowired DressRepository dressRepository;
		@GetMapping("/index.html")
		public String index() {
			return "index.html";
		}
	
		@GetMapping("/formNewDress")
	public String formNewDress(Model model) {
		model.addAttribute("dress",new Dress());
		model.addAttribute("stylist",new Stylist());
		return "formNewDress.html";
	}
	@PostMapping("/dresses")
	public String newDress(@ModelAttribute("dress") Dress dress, Model model) {
		if(!dressRepository.existsByNomeAndPrezzo(dress.getNome(), dress.getPrezzo())) {
			this.dressRepository.save(dress);
			model.addAttribute("dress",dress);
			return "dress.html";
		}else {
			model.addAttribute("messaggioErrore","Questo vestito esiste già");
			return "formNewDress.html";
		}
	}
	@GetMapping("/dresses/{id}")
	  public String getDress(@PathVariable("id") Long id, Model model) {
	    model.addAttribute("dress", this.dressRepository.findById(id).get());
	    return "dress.html";
	  }

	  @GetMapping("/dresses")
	  public String showDresses(Model model) {
	    model.addAttribute("dresses", this.dressRepository.findAll());
	    return "dresses.html";
	  }

	  @GetMapping("/formSearchDresses")
	  public String formSearchDresses() {
	    return "formSearchDresses.html";
	  }

	  @PostMapping("/searchDresses")
	  public String searchDresses(Model model, @RequestParam Integer prezzo) {
	    model.addAttribute("dresses", this.dressRepository.findByPrezzo(prezzo));
	    return "foundDresses.html";
	  }
	}
