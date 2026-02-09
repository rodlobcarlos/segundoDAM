package repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import modelo.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	Set<Product> findAll();

	Set<Product> findByCategory(String category);
	
	Product finByIdProduct(int id);

}
