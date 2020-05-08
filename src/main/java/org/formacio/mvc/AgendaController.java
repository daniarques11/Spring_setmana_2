package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
