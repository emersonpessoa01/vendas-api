package io.github.emersonpessoa01.vendas_api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.emersonpessoa01.vendas_api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Aqui você pode adicionar métodos personalizados, se necessário
    // Exemplo: List<Produto> findByNome(String nome);
    
}
