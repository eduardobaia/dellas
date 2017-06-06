package com.dellas.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.dellas.app.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{

}
