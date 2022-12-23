package com.bruno.petshop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = 1L;

	private String funcao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "funcionario")
	List<Servico> servico = new ArrayList<>();
	
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

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}
	
}
