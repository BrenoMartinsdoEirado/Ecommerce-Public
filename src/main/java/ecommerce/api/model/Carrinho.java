package ecommerce.api.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "carrinhos")
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int quantidadeItem;

    @Enumerated(EnumType.STRING)
    private FormaDePagamento pagamento;
    @OneToMany
    private List<Produto> listadeItens;
    private long cepOrigem;
    private long cepDestino;
    private double valorFrete;
    @ManyToOne
    private Cartao cartao;
}
