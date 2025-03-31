package io.github.emersonpessoa01.vendas_api.rest.produtos;

import java.math.BigDecimal;

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
    private String descricao;
    private String nome;
    private BigDecimal preco;
    private String sku;

    /* Imprimir os dados do produto */  
    @Override
    public String toString() {
        return "ProdutoFormRequest [descricao=" + descricao + ", nome=" + nome + ", preco=" + preco + ", sku=" + sku
                + "]";
    }


}
