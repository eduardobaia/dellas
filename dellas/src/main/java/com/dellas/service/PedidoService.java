package com.dellas.service;

import java.util.List;

import com.dellas.dto.PedidoDTO;

public interface PedidoService {

	PedidoDTO create(PedidoDTO pedido);
	
	PedidoDTO get(long id);
	
	PedidoDTO update(PedidoDTO pedido);
	
	List<PedidoDTO> findAll();
	
	List<PedidoDTO> findByFilter(PedidoDTO pedido);
	
	
}
