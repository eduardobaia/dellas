package com.dellas.converter;

import java.util.ArrayList;
import java.util.List;

import com.dellas.dto.ProdutoDTO;
import com.dellas.model.Produto;

public class ProdutoConverter {

	public static Produto toProduto (final ProdutoDTO dto){
		final Produto produto = new Produto();
		produto.setId(dto.getId());
		produto.setNome(dto.getNome());
		produto.setDescricao(dto.getDescricao());
		produto.setPreco(dto.getPreco());
		produto.setQuantidade(dto.getQuantidade());
		produto.setDataValidade(dto.getDataValidade());
		produto.setFornecedor(dto.getFornecedor());
		produto.setPedido(dto.getPedido());

		return produto;
	}
	
	public static ProdutoDTO toProdutoDTO(final Produto produto){
		final ProdutoDTO model = new ProdutoDTO();
		model.setId(produto.getId());
		model.setNome(produto.getNome());
		model.setDescricao(produto.getDescricao());
		model.setPreco(produto.getPreco());
		model.setDataValidade(produto.getDataValidade());
		model.setQuantidade(produto.getQuantidade());
		model.setFornecedor(produto.getFornecedor());
		model.setPedido(produto.getPedido());
		
		return model;
	}

	public static List<ProdutoDTO> toListProdutoDTO(final List<Produto> lista){
		final List<ProdutoDTO> listProdutoDTO = new ArrayList<>();
		if( lista != null){
			for( final Produto produto: lista){
				listProdutoDTO.add(toProdutoDTO(produto));
			}
		}
		return listProdutoDTO;
	}
	
	
	
}
