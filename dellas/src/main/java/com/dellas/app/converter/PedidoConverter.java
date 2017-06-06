package com.dellas.app.converter;

import java.util.ArrayList;
import java.util.List;

import com.dellas.app.dto.PedidoDTO;
import com.dellas.app.model.Pedido;

public class PedidoConverter {

	public static Pedido toPedido(final PedidoDTO dto){
		final Pedido pedido= new Pedido();
		pedido.setId(dto.getId());
		pedido.setDescricao(dto.getDescricao());
		pedido.setData(dto.getData());
		pedido.setObservacao(dto.getObservacao());
		pedido.setUsuario(dto.getUsuario());
		pedido.setProdutos(dto.getProdutos());
		pedido.setStatus(dto.getStatus());
		pedido.setValorDesconto(dto.getValorDesconto());
		pedido.setValorTotalItens(dto.getValorTotalItens());

		return pedido;
	}


	public static PedidoDTO toPedidoDTO(final Pedido pedido){
		final PedidoDTO model = new PedidoDTO();
		model.setId(pedido.getId());
		model.setDescricao(pedido.getDescricao());
		model.setData(pedido.getData());
		model.setObservacao(pedido.getObservacao());
		model.setUsuario(pedido.getUsuario());
		model.setProdutos(pedido.getProdutos());
		model.setStatus(pedido.getStatus());
		model.setValorDesconto(pedido.getValorDesconto());
		model.setValorTotalItens(pedido.getValorTotalItens());

		return model;
	}

	public static List<PedidoDTO> toListPedidoDTO(final List<Pedido> lista){
		final List<PedidoDTO> listPedidoDTO= new ArrayList<>();
		if(lista != null){
			for(final Pedido pedido: lista){
				listPedidoDTO.add(toPedidoDTO(pedido));
			}
		}
		return listPedidoDTO;
	}

}
