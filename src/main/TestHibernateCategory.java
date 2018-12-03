package main;

import entities.Category;
import services.CategoryServiceImpl;

public class TestHibernateCategory {
	
	public static void main(String[] args) {
		int id = (int) createCategory();
		edit("OldCategory", id);
		//delete(id);
	}
	
	static int createCategory() {
		CategoryServiceImpl categoryService = new CategoryServiceImpl();
		Category category = new Category();
		category.setName("New Category");
		return categoryService.createCategory(category);
	}
	
	static void delete(int id) {
		CategoryServiceImpl categoryService = new CategoryServiceImpl();
		categoryService.deleteCategory(id);
	}
	
	static void edit(String name, int id) {
		CategoryServiceImpl categoryService = new CategoryServiceImpl();
		
		Category category = new Category();
		category.setId(id);
		category.setName(name);
		categoryService.updateCategory(category);
	}
	
}
