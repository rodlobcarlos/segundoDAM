package service;

import java.util.Set;

import modelo.Product;

public interface ProductService {

	Set<Product> findByCategory(String category);

	Set<Product> findAll();

}
