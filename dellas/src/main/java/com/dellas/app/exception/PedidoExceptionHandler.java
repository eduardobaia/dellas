package com.dellas.app.exception;

import java.util.ArrayList;
import java.util.List;

public class PedidoExceptionHandler {


	public static List<String> getExceptionError(final Exception e){
		final StringBuilder excecao = new StringBuilder();
		final List<String> listaExcecao = new ArrayList<String>();
		if(e instanceof MultiplePedidoException){
			final MultiplePedidoException me = (MultiplePedidoException) e;
			for(final PedidoException exception : me.getExceptions()){
				listaExcecao.add(exception.getMessage());
			}
		}else if( e instanceof PedidoException){
			final PedidoException exception = (PedidoException) e;
			listaExcecao.add(exception.getMessage());
		}else{
			excecao.append("Generic Error");
		}
		return listaExcecao;
		
	}
	
}
