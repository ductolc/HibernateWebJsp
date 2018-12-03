package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Category;

public class CategoryDao extends GenericDao {

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		Session session = null;
		Transaction tx = null;
		List<Category> categories = null;
		try {
			// 1. create session
			session = getFactory().openSession();
			// 2. begin transaction
			tx = session.beginTransaction();
			// 3. select hql
			categories = session.createQuery("FROM Category").list();
			// 4. close connect
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	public boolean deleteCategory(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = getFactory().openSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("Delete Category c where c.id=:idCategory");
			q.setParameter("idCategory", id);
			q.executeUpdate();
			tx.commit();
			return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				tx = null;
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public Category findById(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = getFactory().openSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("FROM Category c where c.id=:idCategory");
			q.setParameter("idCategory", id);
			List<Category> categories = (List<Category>) q.list();
			if (categories != null) {
				return categories.get(0);
			}
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateCategory(Category category) {
		Session session = null;
		Transaction tx = null;
		try {
			session = getFactory().openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(category);
			tx.commit();
			
			return true;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
				tx = null;
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	public Integer saveCategory(Category categoryNew) {
		Session session = null;
		Transaction tx = null;
		Integer id = null;

		try {
			session = getFactory().openSession();
			tx = session.beginTransaction();
			Category category = new Category();
			category.setName(categoryNew.getName());
			category.setProducts(categoryNew.getProducts());
			id = (Integer) session.save(category);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return id;
	}
}
