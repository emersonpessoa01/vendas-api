package io.github.emersonpessoa01.vendas_api.rest.produtos;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<ProdutoFormRequest> salvar(@RequestBody ProdutoFormRequest produto) {
        Produto entidadeProduto = produto.toModel();
        produtoRepository.save(entidadeProduto);
        return ResponseEntity.ok(ProdutoFormRequest.fromModel(entidadeProduto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id,
            @RequestBody ProdutoFormRequest produto) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        // Atualiza os dados do produto existente com os novos dados

        Produto entidadeProduto = produto.toModel();
        entidadeProduto.setId(id);
        produtoRepository.save(entidadeProduto);
        return ResponseEntity.ok().build();
    }
}