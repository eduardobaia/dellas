package com.dellas.app.dto;

import java.util.Date;
import java.util.List;

import com.dellas.app.model.Produto;
import com.dellas.app.model.Usuario;
import com.dellas.app.suport.CustomDateDeserializer;
import com.dellas.app.suport.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class PedidoDTO {

	private Long id;
	private String descricao;
	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date data = new Date();
	private double valorTotalItens;
	private double valorDesconto;
	private Usuario usuario;
	private String status;
	private List<Produto> produtos;
	private String observacao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public double getValorTotalItens() {
		return valorTotalItens;
	}
	public void setValorTotalItens(double valorTotalItens) {
		this.valorTotalItens = valorTotalItens;
	}
	public double getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
