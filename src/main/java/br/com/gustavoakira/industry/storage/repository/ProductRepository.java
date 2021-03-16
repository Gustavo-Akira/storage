package br.com.gustavoakira.industry.storage.repository;

import br.com.gustavoakira.industry.storage.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
