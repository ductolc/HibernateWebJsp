package main;

import entities.Category;
import entities.Product;
import services.CategoryServiceImpl;
import services.ProductServiceImpl;

public class TestHibernateProduct {
	
	public static void main(String[] args) {
		int id = (int) createProduct();
		
		CategoryServiceImpl categoryService = new CategoryServiceImpl();
		Category category = new Category();
		category.setName("abc");
		int idC = (int) categoryService.createCategory(category);
		
		edit("OldProduct", id, idC);
		//delete(id);
	}
	
	static int createProduct() {
		ProductServiceImpl productService = new ProductServiceImpl();
		CategoryServiceImpl categoryService = new CategoryServiceImpl();
		Product product = new Product();
		product.setName("New Product");
		
		Category category = new Category();
		category.setName("abc");
		int id = (int) categoryService.createCategory(category);
		product.setCategory(categoryService.getCategoryById(id));
		return productService.createProduct(product);
	}
	
	static void delete(int id) {
		ProductServiceImpl productService = new ProductServiceImpl();
		productService.deleteProduct(id);
	}
	
	static void edit(String name, int id, int categoryId) {
		ProductServiceImpl productService = new ProductServiceImpl();
		CategoryServiceImpl categoryService = new CategoryServiceImpl();
		
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setCategory(categoryService.getCategoryById(categoryId));
		productService.updateProduct(product);
	}
}
