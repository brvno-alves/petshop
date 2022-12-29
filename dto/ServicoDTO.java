package com.bruno.petshop.dto;

import java.io.Serializable;

import com.bruno.petshop.domain.Servico;

public class ServicoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String descricao;
	
	public ServicoDTO() {
		
	}

	public ServicoDTO(Servico obj) {
		this.setDescricao(obj.getDescricao());
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
