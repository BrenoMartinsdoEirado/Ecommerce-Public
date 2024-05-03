package ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.api.model.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao,Long> {
    
}
