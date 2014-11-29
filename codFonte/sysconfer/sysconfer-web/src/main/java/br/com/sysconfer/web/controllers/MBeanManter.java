package br.com.sysconfer.web.controllers;

import java.util.List;

public abstract class MBeanManter {
	
	public abstract void salvar();
	public abstract List<?> listarTodos();
	public abstract void excluir();
	public abstract void init();
	
}
