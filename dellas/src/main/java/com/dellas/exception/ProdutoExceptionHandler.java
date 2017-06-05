package com.dellas.exception;

import java.util.ArrayList;
import java.util.List;

public class ProdutoExceptionHandler {


	public static List<String> getExceptionError(final Exception e){
		final StringBuilder excecao = new StringBuilder();
		final List<String> listaExcecao = new ArrayList<String>();
		if(e instanceof MultipleProdutoException){
			final MultipleProdutoException me = (MultipleProdutoException) e;
			for(final ProdutoException exception : me.getExceptions()){
				listaExcecao.add(exception.getMessage());
			}
		}else if( e instanceof ProdutoException){
			final ProdutoException exception = (ProdutoException) e;
			listaExcecao.add(exception.getMessage());
		}else{
			excecao.append("Generic Error");
		}
		return listaExcecao;
		
	}
	
}
