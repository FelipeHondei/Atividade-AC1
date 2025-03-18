package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto salvar(Produto Produto) {
        return entityManager.merge(Produto);
    }

    public List<Produto> obterTodos() {
        return entityManager.createQuery("from Produto", Produto.class)
                .getResultList();
    }
    @Transactional
    public void excluir(Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
    }
    public Produto obterPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }
    @Transactional
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produtoExistente = entityManager.find(Produto.class, id);
        if (produtoExistente != null) {
            produtoExistente.setNome(produtoAtualizado.getNome());
            produtoExistente.setId(produtoAtualizado.getId());
            produtoExistente.setQtd(produtoAtualizado.getQtd());
            return entityManager.merge(produtoExistente);
        }
        return null;
    }

}
