package com.bruno.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bruno.petshop.domain.Categoria;
import com.bruno.petshop.repository.CategoriaRepository;

@Component
public class PopulaDados {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PostConstruct
	public void cadastrar() {
		
		Categoria cat1 = new Categoria(null, "Alimentos");
		Categoria cat2 = new Categoria(null, "Cosméticos");
		Categoria cat3 = new Categoria(null, "Remédios");
		Categoria cat4 = new Categoria(null, "Vacinas");
		Categoria cat5 = new Categoria(null, "Acessórios");
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));
	}
}
