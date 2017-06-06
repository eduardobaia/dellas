package com.dellas.app.exception;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MultiplePedidoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Lista de excecoes
	 */
	private final Set<PedidoException> exceptions = new HashSet<PedidoException>();

	
	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param message mensagem de erro
	 */
	public MultiplePedidoException(final PedidoException message) {
		exceptions.add(message);
	}
	

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param messageList mensagem de erro
	 */
	public MultiplePedidoException(final Collection<? extends PedidoException> messageList) {
		exceptions.addAll(messageList);
	}
	
	public MultiplePedidoException() {
		//Construtor padrao
	}
	
	
	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param message a mensagem de detalhe
	 */
	public void addException(final PedidoException message) {
		exceptions.add(message);
	}
	
	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param messageList a mensagem de detalhe
	 */
	public void addExceptionList(final Collection<? extends PedidoException> messageList) {
		exceptions.addAll(messageList);
	}

	public Set<PedidoException> getExceptions() {
		return exceptions;
	}

	public boolean contains(final PedidoException ex) {
		return (null != exceptions && !exceptions.isEmpty()) && exceptions.contains(ex);
	}
	
	
}
