package com.bruno.petshop.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.bruno.petshop.domain.enuns.SituacaoPagamento;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pagamento implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Double valor;
	private Integer situacao;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name = "id_servico")
	@MapsId
	private Servico servico;
	
	public Pagamento() {
		
	}
	
	public Pagamento(Integer id, Double valor, SituacaoPagamento situacao, Servico servico) {
		super();
		this.id = id;
		this.valor = valor;
		this.situacao = situacao.getCod();
		this.servico = servico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public SituacaoPagamento getSituacao() {
		return SituacaoPagamento.toEnum(situacao);
	}

	public void setSituacao(SituacaoPagamento situacao) {
		this.situacao = situacao.getCod();
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	
}
