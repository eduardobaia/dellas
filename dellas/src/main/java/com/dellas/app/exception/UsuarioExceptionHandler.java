package com.dellas.app.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para varrer a excecao e retornar os erros
 */
public class UsuarioExceptionHandler {

	public static List<String> getExceptionError(final Exception e){
		final StringBuilder excecao = new StringBuilder();
		final List<String> listaExcecao = new ArrayList<String>();
		if(e instanceof MultipleUsuarioException){
			final MultipleUsuarioException me = (MultipleUsuarioException) e;
			for(final UsuarioException exception : me.getExceptions()){
				listaExcecao.add(exception.getMessage());
			}
		}else if( e instanceof UsuarioException){
			final UsuarioException exception = (UsuarioException) e;
			listaExcecao.add(exception.getMessage());
		}else{
			excecao.append("Generic Error");
		}
		return listaExcecao;
		
	}
}
