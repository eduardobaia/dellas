package com.dellas.repository;

import org.springframework.data.repository.CrudRepository;

import com.dellas.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
