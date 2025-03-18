package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.CategoriaProduto;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public CategoriaProduto salvar(CategoriaProduto categoriaCurso) {
        return entityManager.merge(categoriaCurso);
    }

    public List<CategoriaProduto> obterTodos() {
        return entityManager.createQuery("FROM CategoriaProduto", CategoriaProduto.class).getResultList();
    }
}
