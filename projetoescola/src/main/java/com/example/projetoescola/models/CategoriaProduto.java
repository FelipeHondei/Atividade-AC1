package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CategoriaProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @OneToMany(mappedBy = "categoriaCurso", fetch = FetchType.EAGER)
    private List<Produto> produtos;

    public CategoriaProduto(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaProduto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
