package com.example.projetoescola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetoescola.models.Categoria;
import com.example.projetoescola.models.CategoriaProduto;
import com.example.projetoescola.models.Produto;
import com.example.projetoescola.repositories.CategoriaProdutoRepository;
import com.example.projetoescola.repositories.CategoriaRepository;
import com.example.projetoescola.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoescolaApplication {

	@Bean
	public CommandLineRunner init(
			@Autowired ProdutoRepository ProdutoRepository,
			@Autowired CategoriaProdutoRepository categoriaRepository,
			@Autowired CategoriaRepository CategoriaRepository) {
		return args -> {
			ProdutoRepository.salvar(
					new Produto(null, "teste", 2000));
			ProdutoRepository.salvar(
					new Produto(null, "teste2", 2050));
			List<Produto> listaProdutos = ProdutoRepository.obterTodos();
			System.out.println("*** Produtos cadastrados:");
			listaProdutos.forEach(System.out::println);
			System.out.println("*** Inserir Categoria:");
			CategoriaProduto categoria = categoriaRepository.salvar(
					new CategoriaProduto(null, "Informática"));
			System.out.println("*** Vincular Categoria ao Produto ***");
			Produto Produto = ProdutoRepository.obterTodos().get(0);
			Produto.setCategoriaProduto(categoria);
			System.out.println("*** Criar categoria ***");
			Categoria categoria1 = CategoriaRepository.salvar(
					new Categoria(null, "João", "Descrição"));

			System.out.println("*** Criar categoria ***");
			Categoria categoria2 = CategoriaRepository.salvar(
					new Categoria(null, "maria", "Descrição"));

			System.out.println("*** Vincular Categoria ao Produto ***");
			Produto.addCategoria(categoria1);
			Produto.addCategoria(categoria2);

			ProdutoRepository.salvar(Produto);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoescolaApplication.class, args);
	}

}
