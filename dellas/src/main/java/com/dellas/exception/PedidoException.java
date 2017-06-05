package com.dellas.exception;

public class PedidoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public PedidoException(){
		//Default constructor
	}
	
	public PedidoException(final String message){
		super(message);
	}
	

	public PedidoException(final String message, final Throwable cause){
		super(message, cause);
	}
	
	public PedidoException(final Throwable cause){
		super(cause);
	}
	
}
