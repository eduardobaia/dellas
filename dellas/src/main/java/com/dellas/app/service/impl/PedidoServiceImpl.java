package com.dellas.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellas.app.converter.PedidoConverter;
import com.dellas.app.dto.PedidoDTO;
import com.dellas.app.exception.MultiplePedidoException;
import com.dellas.app.exception.PedidoException;
import com.dellas.app.model.Pedido;
import com.dellas.app.repository.PedidoRepository;
import com.dellas.app.service.PedidoService;

@Transactional(readOnly = true)
@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository repositorio;

	private static final String VALOR_TOTAL_ITENS_OBRIGATORIO = "O campo Login  é obrigatório.";
	private static final String PRODUTOS_OBRIGATORIO = "O campo senha obrigatório.";

	@Transactional(readOnly = false)
	@Override
	public PedidoDTO create(final PedidoDTO pedido) {
		return PedidoConverter.toPedidoDTO(repositorio.save(PedidoConverter.toPedido(pedido)));
	}

	@Override
	public PedidoDTO get(final long id) {
		return PedidoConverter.toPedidoDTO(repositorio.findOne(id));
	}

	@Transactional(readOnly = false)
	@Override
	public PedidoDTO update(final PedidoDTO pedido) {
		return PedidoConverter.toPedidoDTO(repositorio.save(PedidoConverter.toPedido(pedido)));
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(final long id) {
		repositorio.delete(id);
	}

	@Override
	public List<PedidoDTO> findAll() {
		return PedidoConverter.toListPedidoDTO((List<Pedido>) repositorio.findAll());
	}

	@Override
	public List<PedidoDTO> findByFilter(final PedidoDTO pedido) {
		return PedidoConverter.toListPedidoDTO((List<Pedido>) repositorio.findAll());
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
