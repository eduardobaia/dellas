package com.dellas.app.exception;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MultipleUsuarioException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Lista de excecoes
	 */
	private final Set<UsuarioException> exceptions = new HashSet<UsuarioException>();

	
	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param message mensagem de erro
	 */
	public MultipleUsuarioException(final UsuarioException message) {
		exceptions.add(message);
	}
	

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param messageList mensagem de erro
	 */
	public MultipleUsuarioException(final Collection<? extends UsuarioException> messageList) {
		exceptions.addAll(messageList);
	}
	
	public MultipleUsuarioException() {
		//Construtor padrao
	}
	
	
	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param message a mensagem de detalhe
	 */
	public void addException(final UsuarioException message) {
		exceptions.add(message);
	}
	
	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param messageList a mensagem de detalhe
	 */
	public void addExceptionList(final Collection<? extends UsuarioException> messageList) {
		exceptions.addAll(messageList);
	}

	public Set<UsuarioException> getExceptions() {
		return exceptions;
	}

	public boolean contains(final UsuarioException ex) {
		return (null != exceptions && !exceptions.isEmpty()) && exceptions.contains(ex);
	}
	
	
}
