package io.github.emersonpessoa01.vendas_api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "produto")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Lembrando que não é necessário colocar o @Column em todos os atributos,
    // pois o JPA já faz isso por padrão. No entanto, definimos atributos como
    // length, nullable e unique explicitamente por clareza e controle.
    
    @Column(name = "nome", length = 100, nullable = false)
    @NotBlank
    @Size(max = 100)
    private String nome;

    @Column(name = "descricao", length = 255, nullable = false)
    @NotBlank
    @Size(max = 255)
    private String descricao;

    @Column(name = "preco", precision = 16, scale = 2, nullable = false)
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal preco;

    @Column(name = "sku", length = 20, nullable = false, unique = true)
    @NotBlank
    @Size(max = 20)
    private String sku;

    @Column(name = "data_cadastro", nullable = false, updatable = false)
    private LocalDate dataCadastro;

    /* Fazer o prePersist para setar a data de cadastro do produto */
    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", sku=" + sku
                + ", dataCadastro=" + dataCadastro + "]";
    }
}
