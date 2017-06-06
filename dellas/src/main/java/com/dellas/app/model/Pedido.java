package com.dellas.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PEDIDO")
public class Pedido implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SQ_PEDIDO", precision = 12, scale = 0)
	private Long id;

	@Column(name = "DESCRICAO", nullable = false, length = 200)
	private String descricao;

	@Column(name = "DATA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Column(name = "VALOR_TOTAL_ITENS")
	private double valorTotalItens;

	@Column(name = "VALOR_DESCONTO")
	private double valorDesconto;

	@ManyToOne
	@JoinColumn(name = "SQ_USUARIO", referencedColumnName="SQ_USUARIO", nullable = false)
	private Usuario usuario;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "OBSERVACAO" , length = 200)
	private String observacao;

	@ManyToMany
	@JoinTable(name = "PEDIDO_PRODUTO",
	joinColumns = {@JoinColumn(name = "SQ_PEDIDO", referencedColumnName = "SQ_PEDIDO")},
	inverseJoinColumns = @JoinColumn(name = "SQ_PRODUTO", referencedColumnName = "SQ_PRODUTO") )
	private List<Produto> produtos;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(final Date data) {
		this.data = data;
	}

	public double getValorTotalItens() {
		return valorTotalItens;
	}

	public void setValorTotalItens(final double valorTotalItens) {
		this.valorTotalItens = valorTotalItens;
	}

	public double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(final double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(final List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(final String observacao) {
		this.observacao = observacao;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((produtos == null) ? 0 : produtos.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorDesconto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(valorTotalItens);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		final Pedido other = (Pedido) obj;
		if (data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!data.equals(other.data)) {
			return false;
		}
		if (descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!descricao.equals(other.descricao)) {
			return false;
		}
		if (usuario == null) {
			if (other.usuario != null) {
				return false;
			}
		} else if (!usuario.equals(other.usuario)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (observacao == null) {
			if (other.observacao != null) {
				return false;
			}
		} else if (!observacao.equals(other.observacao)) {
			return false;
		}
		if (produtos == null) {
			if (other.produtos != null) {
				return false;
			}
		} else if (!produtos.equals(other.produtos)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (Double.doubleToLongBits(valorDesconto) != Double.doubleToLongBits(other.valorDesconto)) {
			return false;
		}
		if (Double.doubleToLongBits(valorTotalItens) != Double.doubleToLongBits(other.valorTotalItens)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", descricao=" + descricao + ", data=" + data + ", valorTotalItens="
				+ valorTotalItens + ", valorDesconto=" + valorDesconto + ", funcionario=" + usuario + ", status="
				+ status + ", produtos=" + produtos + ", observacao=" + observacao + "]";
	}





}

