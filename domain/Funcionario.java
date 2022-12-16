package com.bruno.petshop.domain;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String funcao;
	
	public Funcionario() {
		
	}

	public Funcionario(Integer id, String nome, String email, String codNacional, String funcao, String tipo) {
		super(id, nome, email, codNacional, funcao, tipo);
		this.funcao = funcao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
}
