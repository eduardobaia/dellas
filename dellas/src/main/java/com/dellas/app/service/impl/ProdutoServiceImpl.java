package com.dellas.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dellas.app.converter.ProdutoConverter;
import com.dellas.app.dto.ProdutoDTO;
import com.dellas.app.exception.MultipleProdutoException;
import com.dellas.app.exception.ProdutoException;
import com.dellas.app.model.Produto;
import com.dellas.app.repository.ProdutoRepository;
import com.dellas.app.service.ProdutoService;

@Transactional(readOnly = true)
@Service
public class ProdutoServiceImpl implements ProdutoService{


	@Autowired
	private ProdutoRepository repositorio;

	private static final String NOME__OBRIGATORIO = "O Nome do produto  é obrigatório.";
	private static final String VALIDADE_OBRIGATORIO = "A Validade é origatória";

	@Transactional(readOnly = false)
	@Override
	public ProdutoDTO create(final ProdutoDTO produto) {
		checkException(validadePersistProduto(produto));
		return ProdutoConverter.toProdutoDTO(repositorio.save(ProdutoConverter.toProduto(produto)));
	}

	@Override
	public ProdutoDTO get(final long id) {
		return ProdutoConverter.toProdutoDTO(repositorio.findOne(id));
	}

	@Transactional(readOnly = false)
	@Override
	public ProdutoDTO update(final ProdutoDTO produto) {
		final Produto produtoModel= ProdutoConverter.toProduto(produto);
		checkException(validadeUpdateProduto(produto));
		return ProdutoConverter.toProdutoDTO(repositorio.save(produtoModel));
	}

	@Override
	public List<ProdutoDTO> findAll() {
		return ProdutoConverter.toListProdutoDTO((List<Produto>) repositorio.findAll());
	}

	@Override
	public List<ProdutoDTO> findByFilter(final ProdutoDTO produto) {
		final ProdutoDTO entidade = new ProdutoDTO();
		final List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();
		lista.add(entidade);
		return lista;
	}

	@Transactional(readOnly = false)
	@Override
	public void delete(final long id) {
		repositorio.delete(id);
	}

	public void checkException(final ArrayList<ProdutoException> exceptions){
		if(!exceptions.isEmpty()){
			throw new MultipleProdutoException(exceptions);
		}
	}


	//Validacoes
	private void validaNome(final ProdutoDTO produto, final ArrayList<ProdutoException> errors){
		if( StringUtils.isBlank(produto.getNome())){
			errors.add(new ProdutoException(NOME__OBRIGATORIO));
		}
	}


	private void validaValidade(final ProdutoDTO produto, final ArrayList<ProdutoException> errors){
		if(produto.getDataValidade() == null){
			errors.add(new ProdutoException(VALIDADE_OBRIGATORIO));
		}
	}

	private ArrayList<ProdutoException> validadePersistProduto(final ProdutoDTO produto) {
		final ArrayList<ProdutoException> errors = new ArrayList<ProdutoException>();
		validaNome(produto, errors);
		validaValidade(produto, errors);
		return errors;
	}

	//faz validação para update
	private ArrayList<ProdutoException> validadeUpdateProduto(final ProdutoDTO produto) {
		final ArrayList<ProdutoException> errors = new ArrayList<ProdutoException>();
		validaNome(produto, errors);
		validaValidade(produto, errors);
		return errors;
	}
}
