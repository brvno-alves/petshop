package com.bruno.petshop.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.bruno.petshop.domain.enuns.SituacaoPagamento;

@Entity
public class PagamentoDinheiro extends Pagamento {

	private static final long serialVersionUID = 1L;

	private Date dataVencimento;
	private Double desconto;
	
	public PagamentoDinheiro() {
		
	}

	public PagamentoDinheiro(Integer id, Double valor, SituacaoPagamento situacao, Servico servico, Date dataVencimento, Double desconto) {
		super(id, valor, situacao, servico);
		this.dataVencimento = dataVencimento;
		this.desconto = desconto;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataPagamento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	
}
