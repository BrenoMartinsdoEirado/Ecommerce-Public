package ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.api.model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    
}
