package com.dellas.exception;

public class ProdutoException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public ProdutoException(){
		//Default constructor
	}
	
	public ProdutoException(final String message){
		super(message);
	}
	

	public ProdutoException(final String message, final Throwable cause){
		super(message, cause);
	}
	
	public ProdutoException(final Throwable cause){
		super(cause);
	}
	
}
