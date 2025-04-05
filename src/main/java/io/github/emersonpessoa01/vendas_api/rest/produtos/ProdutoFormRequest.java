package io.github.emersonpessoa01.vendas_api.rest.produtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.github.emersonpessoa01.vendas_api.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity
// @Table(name = "produtos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProdutoFormRequest {

    private Long id;
    private String descricao;
    private String nome;
    private BigDecimal preco;
    private String sku;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataCadastro;


    public Produto toModel() {
        return new Produto(id, nome, descricao, preco, sku, null);
    }
    // Constructor already provided by @AllArgsConstructor annotation
    // Empty constructor already provided by @NoArgsConstructor annotation

    public static ProdutoFormRequest fromModel(Produto produto) {
        return new ProdutoFormRequest(
                produto.getId(),
                produto.getDescricao(),
                produto.getNome(),
                produto.getPreco(),
                produto.getSku(),
                produto.getDataCadastro());
    }

    @Override
    public String toString() {
        return "ProdutoFormRequest [id=" + id + ", descricao=" + descricao + ", nome=" + nome + ", preco=" + preco
                + ", sku=" + sku + ", dataCadastro=" + dataCadastro + "]";
    }

}
