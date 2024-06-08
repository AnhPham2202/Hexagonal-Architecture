package anh.pham.iss.infrastucture.adapters.output.persistence.repository;

import anh.pham.iss.infrastucture.adapters.output.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
