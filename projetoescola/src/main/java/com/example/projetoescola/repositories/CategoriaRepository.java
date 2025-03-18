package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public Categoria salvar(Categoria categoria) {
        return entityManager.merge(categoria);
    }

    public List<Categoria> obterTodos() {
        return entityManager.createQuery("FROM Categoria", Categoria.class).getResultList();
    }
    @Transactional
    public void excluir(Long id) {
        Categoria categoria = entityManager.find(Categoria.class, id);
        if (categoria != null) {
            entityManager.remove(categoria);
        }
    }
        public Categoria obterPorId(Long id) {
        return entityManager.find(Categoria.class, id);
    }
    @Transactional
    public Categoria atualizar(Long id, Categoria categoriaAtualizado) {
        Categoria categoriaExistente = entityManager.find(Categoria.class, id);
        if (categoriaExistente != null) {
            categoriaExistente.setNome(categoriaAtualizado.getNome());
            categoriaExistente.setId(categoriaAtualizado.getId());
            categoriaExistente.setDescricao(categoriaAtualizado.getDescricao());
            return entityManager.merge(categoriaExistente);
        }
        return null;
    }
}
