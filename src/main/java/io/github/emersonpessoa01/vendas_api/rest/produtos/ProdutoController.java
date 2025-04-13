package io.github.emersonpessoa01.vendas_api.rest.produtos;

import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.emersonpessoa01.vendas_api.model.Produto;
import io.github.emersonpessoa01.vendas_api.model.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    // Injeção de dependência via construtor (recomendada)
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // POST: Criar novo produto
    @PostMapping
    public ResponseEntity<ProdutoFormRequest> criarProduto(
             @RequestBody ProdutoFormRequest produto) {
        Produto entidadeProduto = produto.toModel();
        produtoRepository.save(entidadeProduto);
        return ResponseEntity.ok(ProdutoFormRequest.fromModel(entidadeProduto));
    }

    // PUT: Atualizar produto existente
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoFormRequest> atualizarProduto(
            @PathVariable Long id,
            @RequestBody ProdutoFormRequest produto) {

        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Produto entidadeProduto = produto.toModel();
        entidadeProduto.setId(id);
        produtoRepository.save(entidadeProduto);

        return ResponseEntity.ok(ProdutoFormRequest.fromModel(entidadeProduto));
    }

    // GET: Buscar produto por ID (boa prática para complementar POST e PUT)
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoFormRequest> buscarPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto
                .map(p -> ResponseEntity.ok(ProdutoFormRequest.fromModel(p)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
