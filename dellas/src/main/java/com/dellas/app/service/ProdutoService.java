package com.dellas.app.service;

import java.util.List;

import com.dellas.app.dto.ProdutoDTO;

public interface ProdutoService {

	/**
	 * Persiste uma instancia da entidade Produto.
	 *
	 * @param produto
	 *        Instancia de Acao a ser persistida
	 * @return entidade persistida
	 */
	ProdutoDTO create(ProdutoDTO produto);
	
	ProdutoDTO get(long id);
	
	ProdutoDTO update(ProdutoDTO produto);
	
	void delete(long id);
	
	List<ProdutoDTO> findAll();
	
	List<ProdutoDTO> findByFilter(ProdutoDTO produto);
	
	
	
}
