package com.bruno.petshop.utils;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bruno.petshop.domain.Categoria;
import com.bruno.petshop.domain.Especie;
import com.bruno.petshop.domain.Pet;
import com.bruno.petshop.domain.Produto;
import com.bruno.petshop.domain.Raca;
import com.bruno.petshop.repository.CategoriaRepository;
import com.bruno.petshop.repository.EspecieRepository;
import com.bruno.petshop.repository.PetRepository;
import com.bruno.petshop.repository.ProdutoRepository;
import com.bruno.petshop.repository.RacaRepository;

@Component
public class PopulaDados {
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	EspecieRepository especieRepository;
	
	@Autowired
	RacaRepository racaRepository;
	
	@Autowired
	PetRepository petRepository;
	
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
		
		Especie esp1 = new Especie (null, "Cachorro");
		Especie esp2 = new Especie (null, "Gato");
		
		Raca rac1 = new Raca (null, "Shitzu");
		Raca rac2 = new Raca (null, "Chow-Chow");
		Raca rac3 = new Raca (null, "Akita");
		Raca rac4 = new Raca (null, "Husky Siberiano");
		Raca rac5 = new Raca (null, "Persa");
		Raca rac6 = new Raca (null, "Sphynx");
		Raca rac7 = new Raca (null, "Siamês");
		Raca rac8 = new Raca (null, "Maine Coom");
		Raca rac9 = new Raca (null, "SRD");
	
		Pet pet1 = new Pet(null, "Chico", 4, esp2, rac9);
		Pet pet2 = new Pet(null, "Mel Gibsa", 3, esp2, rac9);
		Pet pet3 = new Pet(null, "Tigrão", 8, esp1, rac4);
		
		especieRepository.saveAll(Arrays.asList(esp1, esp2));
		racaRepository.saveAll(Arrays.asList(rac1,rac2,rac3,rac4,rac5,rac6,rac7,rac8,rac9));
		petRepository.saveAll(Arrays.asList(pet1,pet2,pet3));
	}
}