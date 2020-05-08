package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AgendaController {

	@Autowired
	public AgendaService agenda;
	
	@RequestMapping("/nombre")
	@ResponseBody
	public int nombre() {
		return agenda.nombreContactes();
	}
	
	@RequestMapping("/telefon")
	@ResponseBody
	public String telefon(String id) {
		return agenda.recupera(id).getTelefon();
	}
	
	@RequestMapping("/contacte/{clau}")
	@ResponseBody
	public Persona contacte(@PathVariable String clau) {
		if (!agenda.containsId(clau)) {
			throw new ContacteNotFound();
		}
		return agenda.recupera(clau);
	}
	
	@RequestMapping(path="/afegir", method=RequestMethod.POST)
	@ResponseBody
	public String afegir(String id, String nom, String telefon) {
		agenda.inserta(id, nom, telefon);
		return "S'ha inserit correctament el contacte amb id: " + agenda.recupera(id).getClau() + ", nom: " + agenda.recupera(id).getNom() + " i telefon: " + agenda.recupera(id).getTelefon();
	}
}
