package ecommerce.api.model;

import java.time.LocalDate;

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
@Entity(name="cartoes")
public class Cartao {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String numeroCartao;
private int codigoTraseiro;
private String NomeTitular;
private LocalDate Validade;

    
}
