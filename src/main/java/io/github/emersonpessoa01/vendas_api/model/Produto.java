package io.github.emersonpessoa01.vendas_api.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    // Lembrando que não é necessário colocar o @Column em todos os atributos, pois
    // o JPA já faz isso por padrão.
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;
    @Column(name = "preco", precision = 16, scale = 2, nullable = false)
    private BigDecimal preco;
    @Column(name = "sku", length = 20, nullable = false, unique = true)
    private String sku;
    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    // Remove constructor since @AllArgsConstructor is already providing it

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", sku=" + sku
                + ", dataCadastro=" + dataCadastro + "]";
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public String getSku() {
        return sku;
    }
    public void setSku(String sku) {
        this.sku = sku;
    }
    
    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    /* Fazer o prePersist para setar a data de cadastro do produto */
    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDate.now());
    }

}
