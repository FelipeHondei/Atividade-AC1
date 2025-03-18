package com.example.projetoescola.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(nullable = false)
    private Integer qtd;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Produto_Categoria", joinColumns = {
            @JoinColumn(name = "Produto_ID") }, inverseJoinColumns = {
                    @JoinColumn(name = "Categoria_ID") })
    private List<Categoria> categorias;

    public void addCategoria(Categoria p) {
        categorias.add(p);
    }

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaProduto categoriaProduto;

    public  Produto(Long id, String nome, Integer qtd) {
        this.id = id;
        this.nome = nome;
        this.qtd = qtd;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", cargaHoraria=" + qtd + "]";
    }

    public CategoriaProduto getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
}
