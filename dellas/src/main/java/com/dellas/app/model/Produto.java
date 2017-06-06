package com.dellas.app.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="PRODUTO")
public class Produto implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SQ_PRODUTO", precision = 12, scale = 0)
	private Long id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "PRECO")
	private double preco;

	@Column(name = "QUANTIDADE")
	private int quantidade;

	@Column(name = "DATA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataValidade;

	@Column(name = "FORNECEDOR")
	private String fornecedor;


	public Long getId() {
		return id;
	}


	public void setId(final Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(final String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(final double preco) {
		this.preco = preco;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(final int quantidade) {
		this.quantidade = quantidade;
	}


	public Date getDataValidade() {
		return dataValidade;
	}


	public void setDataValidade(final Date dataValidade) {
		this.dataValidade = dataValidade;
	}


	public String getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(final String fornecedor) {
		this.fornecedor = fornecedor;
	}





	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", quantidade=" + quantidade + ", dataValidade=" + dataValidade + ", fornecedor=" + fornecedor
				+ ", pedido=" + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataValidade == null) ? 0 : dataValidade.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + quantidade;
		return result;
	}


	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Produto other = (Produto) obj;
		if (dataValidade == null) {
			if (other.dataValidade != null) {
				return false;
			}
		} else if (!dataValidade.equals(other.dataValidade)) {
			return false;
		}
		if (descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!descricao.equals(other.descricao)) {
			return false;
		}
		if (fornecedor == null) {
			if (other.fornecedor != null) {
				return false;
			}
		} else if (!fornecedor.equals(other.fornecedor)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco)) {
			return false;
		}
		if (quantidade != other.quantidade) {
			return false;
		}
		return true;
	}
}
