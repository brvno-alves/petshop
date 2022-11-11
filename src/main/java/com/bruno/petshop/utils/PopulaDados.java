package com.bruno.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bruno.petshop.domain.Categoria;
import com.bruno.petshop.domain.Produto;
import com.bruno.petshop.repository.CategoriaRepository;
import com.bruno.petshop.repository.ProdutoRepository;

@Component
public class PopulaDados {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostConstruct
	public void cadastrar() {
		
		Categoria cat1 = new Categoria(null, "Alimentos");
		Categoria cat2 = new Categoria(null, "Cosméticos");
		Categoria cat3 = new Categoria(null, "Remédios");
		Categoria cat4 = new Categoria(null, "Vacinas");
		Categoria cat5 = new Categoria(null, "Acessórios");
				
		Produto p1 = new Produto(null, "Ração", 70.0);
		Produto p2 = new Produto(null, "Shampoo", 30.0);
		Produto p3 = new Produto(null, "Enalapril", 20.0);
		Produto p4 = new Produto(null, "Anti-Rábica", 70.0);
		Produto p5 = new Produto(null, "Coleira", 40.0);
		
		cat1.getProdutos().addAll(Arrays.asList(p1));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p3,p4));
		cat4.getProdutos().addAll(Arrays.asList(p4));
		cat5.getProdutos().addAll(Arrays.asList(p5));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat2));
		p3.getCategorias().addAll(Arrays.asList(cat3,cat4));
		p4.getCategorias().addAll(Arrays.asList(cat4));
		p5.getCategorias().addAll(Arrays.asList(cat5));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	}
}