package com.dellas.dto;

import java.util.Date;
import java.util.List;

import com.dellas.model.Produto;
import com.dellas.model.Usuario;
import com.dellas.suport.CustomDateDeserializer;
import com.dellas.suport.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class PedidoDTO {

	private Long id;
	private String descricao;
	@JsonSerialize(using = CustomDateSerializer.class)
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date data;
	private double valorTotalItens;
	private double valorDesconto;
	private Usuario funcionario;
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
	public Usuario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Usuario funcionario) {
		this.funcionario = funcionario;
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
