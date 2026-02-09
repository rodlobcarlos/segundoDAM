package interfaces;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.Product;
import repository.ProductRepository;
import service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Set<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Set<Product> findByCategory(String category) {
		return productRepository.findByCategory(category);
	}
}
