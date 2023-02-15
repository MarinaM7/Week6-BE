package it.epicode.be.prenotazioni.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.epicode.be.prenotazioni.model.Citta;
import it.epicode.be.prenotazioni.model.Postazione;
import it.epicode.be.prenotazioni.service.CittaService;
import it.epicode.be.prenotazioni.service.PostazioneService;

@RestController
@RequestMapping("/api")
public class GestioneController {

	@Autowired
	CittaService csrv;
	
	@Autowired
	PostazioneService psrv;
	
	Pageable paging = (Pageable) PageRequest.of(1, 4);
	
	@GetMapping("/postazioni")
	public Page<Postazione> postazioni(){
		return psrv.findAll(paging);
	}
	
	@GetMapping("/postazioni/{segment}")
	public Optional<Postazione> postazioneById(@PathVariable long segment){
		return psrv.findById(segment);
	}
	
	@PostMapping("/citta/post")
	public Citta postCitta( @RequestBody Citta p){
		return csrv.save(p);
	}
	
}
