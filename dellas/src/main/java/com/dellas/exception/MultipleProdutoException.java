package com.dellas.exception;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MultipleProdutoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Lista de excecoes
	 */
	private final Set<ProdutoException> exceptions = new HashSet<ProdutoException>();

	
	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param message mensagem de erro
	 */
	public MultipleProdutoException(final ProdutoException message) {
		exceptions.add(message);
	}
	

	/**
	 * Constroi uma instancia desta classe.
	 *
	 * @param messageList mensagem de erro
	 */
	public MultipleProdutoException(final Collection<? extends ProdutoException> messageList) {
		exceptions.addAll(messageList);
	}
	
	public MultipleProdutoException() {
		//Construtor padrao
	}
	
	
	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param message a mensagem de detalhe
	 */
	public void addException(final ProdutoException message) {
		exceptions.add(message);
	}
	
	/**
	 * Setter dos parametros para formatacao da mensagem.
	 *
	 * @param messageList a mensagem de detalhe
	 */
	public void addExceptionList(final Collection<? extends ProdutoException> messageList) {
		exceptions.addAll(messageList);
	}

	public Set<ProdutoException> getExceptions() {
		return exceptions;
	}

	public boolean contains(final ProdutoException ex) {
		return (null != exceptions && !exceptions.isEmpty()) && exceptions.contains(ex);
	}
	
	
}
