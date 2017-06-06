package com.dellas.app.service;

import java.util.List;

import com.dellas.app.dto.PedidoDTO;

public interface PedidoService {

	PedidoDTO create(PedidoDTO pedido);
	
	PedidoDTO get(long id);
	
	PedidoDTO update(PedidoDTO pedido);
	
	void delete(long id);
	
	List<PedidoDTO> findAll();
	
	List<PedidoDTO> findByFilter(PedidoDTO pedido);
	
	
}
