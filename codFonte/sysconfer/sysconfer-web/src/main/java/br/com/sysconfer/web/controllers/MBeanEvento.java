package br.com.sysconfer.web.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.sysconfer.dao.EventoDao;
import br.com.sysconfer.entities.Eventos;

@Component("mBeanEvento")
@Scope("request")
public class MBeanEvento extends MBeanManter {

	@Autowired
	private EventoDao eventoDao;

	private Eventos evento;

	private List<?> eventos;

	@Override
	@PostConstruct
	public void init() {
		evento = new Eventos();
	}

	@Override
	public void salvar() {
		try {
			eventoDao.save(evento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<?> listarTodos() {
		setEventos(eventoDao.listAll());
		return null;
	}

	@Override
	public void excluir() {
		eventoDao.delete(evento);
	}

	/**
	 * GETTERS and SETTERS
	 */
	public Eventos getEvento() {
		return evento;
	}

	public void setEvento(Eventos evento) {
		this.evento = evento;
	}

	public List<?> getEventos() {
		return eventos;
	}

	public void setEventos(List<?> eventos) {
		this.eventos = eventos;
	}

}
