package com.bruno.petshop.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.petshop.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> mostrar() {
		Categoria cat1 = new Categoria (1, "Alimentos");
		Categoria cat2 = new Categoria (2, "Cosméticos");
		Categoria cat3 = new Categoria (2, "Remédios");
		
		List<Categoria> lista = new ArrayList<>();
		
		lista.add(cat1);
		lista.add(cat2);
		lista.add(cat3);
		return lista;
	}
}
