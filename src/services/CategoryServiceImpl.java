package services;

import java.util.List;

import dao.CategoryDao;
import entities.Category;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDao categoryDao = new CategoryDao();

	@Override
	public List<Category> getCategories() {
		try {
			return categoryDao.getAllCategories();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteCategory(int id) {
		try {
			return categoryDao.deleteCategory(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCategory(Category productUpdate) {
		try {
			Category category = categoryDao.findById(productUpdate.getId());
			category.setName(productUpdate.getName());
			category.setProducts(productUpdate.getProducts());
			return categoryDao.updateCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Integer createCategory(Category categoryNew) {
		try {
			return categoryDao.saveCategory(categoryNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Category getCategoryById(int id) {
		try {
			return categoryDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
