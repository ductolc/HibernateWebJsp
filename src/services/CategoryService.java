package services;

import java.util.List;

import entities.Category;

public interface CategoryService {
	
	List<Category> getCategories();
	boolean deleteCategory(int id);
	boolean updateCategory(Category productUpdate);
	Integer createCategory(Category productNew);
	Category getCategoryById(int id);
}
