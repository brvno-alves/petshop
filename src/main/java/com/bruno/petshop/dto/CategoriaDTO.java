package com.bruno.petshop.dto;

import java.io.Serializable;

import com.bruno.petshop.domain.Categoria;

public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private String nome;
	
	public CategoriaDTO() {
		
	}

	public CategoriaDTO(Categoria obj) {
		this.setNome(obj.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
