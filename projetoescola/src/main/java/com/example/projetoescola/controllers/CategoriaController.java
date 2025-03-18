package com.example.projetoescola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoescola.models.Produto;
import com.example.projetoescola.repositories.ProdutoRepository;

@RestController
@RequestMapping("/Produtos")
public class CategoriaController {
    @Autowired
    private ProdutoRepository ProdutoRepository;

    @GetMapping()
    public List<Produto> getTodosProdutos() {
        return ProdutoRepository.obterTodos();
    }

    @PostMapping()
    public Produto postProduto(@RequestBody Produto Produto) {
        return ProdutoRepository.salvar(Produto);
    }
}
