package com.bruno.petshop.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bruno.petshop.domain.Categoria;
import com.bruno.petshop.domain.Cidade;
import com.bruno.petshop.domain.Cliente;
import com.bruno.petshop.domain.Endereco;
import com.bruno.petshop.domain.Especie;
import com.bruno.petshop.domain.Estado;
import com.bruno.petshop.domain.Funcionario;
import com.bruno.petshop.domain.Pagamento;
import com.bruno.petshop.domain.PagamentoCartao;
import com.bruno.petshop.domain.PagamentoDinheiro;
import com.bruno.petshop.domain.Pet;
import com.bruno.petshop.domain.Produto;
import com.bruno.petshop.domain.Raca;
import com.bruno.petshop.domain.Servico;
import com.bruno.petshop.domain.enuns.SituacaoPagamento;
import com.bruno.petshop.repository.CategoriaRepository;
import com.bruno.petshop.repository.CidadeRepository;
import com.bruno.petshop.repository.EnderecoRepository;
import com.bruno.petshop.repository.EspecieRepository;
import com.bruno.petshop.repository.EstadoRepository;
import com.bruno.petshop.repository.PagamentoRepository;
import com.bruno.petshop.repository.PessoaRepository;
import com.bruno.petshop.repository.PetRepository;
import com.bruno.petshop.repository.ProdutoRepository;
import com.bruno.petshop.repository.RacaRepository;
import com.bruno.petshop.repository.ServicoRepository;

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
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	ServicoRepository servicoRepository;
	
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@PostConstruct
	public void cadastrar() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Alimentos");
		Categoria cat2 = new Categoria(null, "Cosm??ticos");
		Categoria cat3 = new Categoria(null, "Rem??dios");
		Categoria cat4 = new Categoria(null, "Vacinas");
		Categoria cat5 = new Categoria(null, "Acess??rios");
				
		Produto p1 = new Produto(null, "Ra????o", 70.0);
		Produto p2 = new Produto(null, "Shampoo", 30.0);
		Produto p3 = new Produto(null, "Enalapril", 20.0);
		Produto p4 = new Produto(null, "Anti-R??bica", 70.0);
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
		Raca rac7 = new Raca (null, "Siam??s");
		Raca rac8 = new Raca (null, "Maine Coom");
		Raca rac9 = new Raca (null, "SRD");
	
		Pet pet1 = new Pet(null, "Chico", 4, esp2, rac9);
		Pet pet2 = new Pet(null, "Mel Gibsa", 3, esp2, rac9);
		Pet pet3 = new Pet(null, "Tigr??o", 8, esp1, rac4);
		
		especieRepository.saveAll(Arrays.asList(esp1, esp2));
		racaRepository.saveAll(Arrays.asList(rac1,rac2,rac3,rac4,rac5,rac6,rac7,rac8,rac9));
		petRepository.saveAll(Arrays.asList(pet1,pet2,pet3));
		
		Estado est1 = new Estado(null, "Maranh??o");
		Estado est2 = new Estado(null, "Piau??");
		
		Cidade cid1 = new Cidade(null, "S??o Lu??s", est1);
		Cidade cid2 = new Cidade(null, "Santa Helena", est1);
		Cidade cid3 = new Cidade(null, "Teresina", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1, cid2));
		est2.getCidades().addAll(Arrays.asList(cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
		Cliente clt1 = new Cliente(null, "Jos?? Maria", "josemaria@hotmail.com", "335.986.654-34","F??sica", "Cliente");
		clt1.getTelefones().addAll(Arrays.asList("3236-8915", "98816-3345"));
		
		Funcionario fnc1 = new Funcionario(null, "Tim??teo Saraiva", "timoteosaraiva@hotmail.com", "606.547.324-28", "Atendente", "Funcionario");
		fnc1.getTelefones().addAll(Arrays.asList("3238-6366", "98420-4038"));
		
		Endereco end1 = new Endereco(null, "Rua Amadeu Amaral", "23", "Quadra E", "Ipase", "65061-070", cid1, clt1);
		Endereco end2 = new Endereco(null, "Rua Cec??lia Meireles", "17", "Quadra E", "Ipase", "65062-070", cid1, clt1);
		Endereco end3 = new Endereco(null, "Rua Z?? Butin??o", "13", "Apto 201", "Queimadas", "60061-050", cid2, fnc1);
		
		pessoaRepository.saveAll(Arrays.asList(clt1, fnc1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Servico srv1 = new Servico(null, sdf.parse("02/09/2021 09:00"), sdf.parse("02/09/2021 12:00"), "Tosa", clt1, fnc1, pet1);
		Servico srv2 = new Servico(null, sdf.parse("03/09/2021 12:00"), sdf.parse("21/12/2022 12:00"), "Hotel", clt1, fnc1, pet2);
		Servico srv3 = new Servico(null, sdf.parse("03/09/2021 12:00"), sdf.parse("23/12/2021 16:30"), "Vermifuga????o", clt1, fnc1, pet3);
		
		Pagamento pgt1 = new PagamentoCartao(null, 60.0, SituacaoPagamento.Quitado, srv2, 6);
		srv2.setPagamento(pgt1);

		Pagamento pgt2 = new PagamentoDinheiro(null, 100.0, SituacaoPagamento.Pendente, srv1, sdf.parse("21/12/2022"), null);
		srv1.setPagamento(pgt2);

		Pagamento pgt3 = new PagamentoDinheiro(null, 50.0, SituacaoPagamento.Quitado, srv3, sdf.parse("23/12/2021 16:30"), null);
		srv2.setPagamento(pgt3);
		
		clt1.getServico().addAll(Arrays.asList(srv1, srv2));
		fnc1.getServico().addAll(Arrays.asList(srv1, srv2));
		
		srv2.getProdutos().addAll(Arrays.asList(p1, p2, p4));
		srv3.getProdutos().addAll(Arrays.asList(p3));

		servicoRepository.saveAll(Arrays.asList(srv1, srv2, srv3));
		pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2, pgt3));
	}
	
}