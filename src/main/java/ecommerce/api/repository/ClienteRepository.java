package ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
