package ecommerce.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
