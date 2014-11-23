package br.com.sysconfer.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.sysconfer.dao.EventoDao;
import br.com.sysconfer.entities.Eventos;

@Component
@Scope("request")
public class MBeanEvento {

	private static final Logger logger = LoggerFactory.getLogger(MBeanEvento.class);

	@Autowired
	private EventoDao eventoDao;

	private Eventos evento;

	
	public String getMessage() {
		logger.debug("Returning message from task home bean");
		return "Hello from Spring";
	}	


	public void save() {
		eventoDao.save(evento);
		evento = new Eventos();
	}

}
