package ecommerce.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String descricao;

    @Column(length = 50)
    private String categoria;

    private double peso;
    private double altura;
    private double largura;
    private double profundidade;
    private double valor;
    private double valorFrete;
    
    public double calcularFrete() {
        double freteDimensao = (altura * profundidade * largura) / 6000;

        if (peso > freteDimensao) {
            valorFrete = (freteDimensao * 18.40) + ((peso - freteDimensao) * 18.40) + 50;
        } else {
            valorFrete = freteDimensao * 18.40 + 50;
        }

        return valorFrete;

    }

}
