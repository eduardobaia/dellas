package com.dellas.app.exception;

public class UsuarioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioException(){
		//Default constructor
	}
	
	public UsuarioException(final String message){
		super(message);
	}
	

	public UsuarioException(final String message, final Throwable cause){
		super(message, cause);
	}
	
	public UsuarioException(final Throwable cause){
		super(cause);
	}
	
}
