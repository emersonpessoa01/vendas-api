package io.github.emersonpessoa01.vendas_api.rest.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.emersonpessoa01.vendas_api.model.Produto;
import io.github.emersonpessoa01.vendas_api.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")

public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ProdutoFormRequest salvar(@RequestBody ProdutoFormRequest produto) {
        // Produto entidadeProduto = new Produto(null, produto.getNome(), produto.getDescricao(), produto.getPreco(),
        //         produto.getSku());
        /* EntidadeProduto foi substituído por produto.toModel() */
        Produto entidadeProduto = produto.toModel(); // Converte o ProdutoFormRequest para Produto

        // Salva o produto no banco de dados
        produtoRepository.save(entidadeProduto);
        // System.out.println("Imprimindo Entidade Produto" + entidadeProduto);
        // System.out.println(produto +": Produto salvo com sucesso!");
        // return produto; // Retorna o produto com os dados preenchidos
        return ProdutoFormRequest.fromModel(entidadeProduto); // Retorna o produto com os dados preenchidos
    }
}
