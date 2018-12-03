package services;

import java.util.List;

import entities.Product;

public interface ProductService {
	
	List<Product> getAllProduct();
	boolean deleteProduct(int id);
	boolean updateProduct(Product productUpdate);
	Integer createProduct(Product productNew);
	
}
