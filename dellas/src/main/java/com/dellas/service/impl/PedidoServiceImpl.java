package com.dellas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dellas.dto.PedidoDTO;
import com.dellas.dto.UsuarioDTO;
import com.dellas.exception.MultiplePedidoException;
import com.dellas.exception.MultipleUsuarioException;
import com.dellas.exception.PedidoException;
import com.dellas.exception.UsuarioException;
import com.dellas.repository.PedidoRepository;
import com.dellas.service.PedidoService;

public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository repositorio;
	
	
	private static final String VALOR_TOTAL_ITENS_OBRIGATORIO = "O cmapo Login  é obrigatório.";
	private static final String PRODUTOS_OBRIGATORIO = "O campo senha obrigatório.";

	
	@Override
	public PedidoDTO create(PedidoDTO pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoDTO get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PedidoDTO update(PedidoDTO pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PedidoDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoDTO> findByFilter(PedidoDTO pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//Validacoes
		private void validaValorTotalItens(final PedidoDTO pedido, final ArrayList<PedidoException> errors){
			if( pedido.getValorTotalItens() == 0 ){
				errors.add(new PedidoException(VALOR_TOTAL_ITENS_OBRIGATORIO));
			}
		}
		
		private void validaProdutos(final PedidoDTO pedido, final ArrayList<PedidoException> errors){
			if( pedido.getProdutos().size() == 0){
				errors.add(new PedidoException(PRODUTOS_OBRIGATORIO));
			}
		}
		
		private void checkException(final ArrayList<PedidoException> exceptions) {
			if (!exceptions.isEmpty()) {
				throw new MultiplePedidoException(exceptions);
			}
		}
		
		private ArrayList<PedidoException> validadePersistUsuario(final PedidoDTO pedido) {
			final ArrayList<PedidoException> errors = new ArrayList<PedidoException>();
			validaValorTotalItens(pedido, errors);
			validaProdutos(pedido, errors);
			return errors;
		}
		
		//faz validação para update
		private ArrayList<PedidoException> validadeUpdatePedido(final PedidoDTO pedido) {
			final ArrayList<PedidoException> errors = new ArrayList<PedidoException>();
			validaValorTotalItens(pedido, errors);
			validaProdutos(pedido, errors);
			return errors;
		}
		
		
}
