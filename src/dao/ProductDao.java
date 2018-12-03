package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Product;

public class ProductDao extends GenericDao {
	@SuppressWarnings("unchecked")
	public List<Product> getAllCategories() {
		Session session = null;
		Transaction tx = null;
		List<Product> categories = null;
		try {
			// 1. create session
			session = getFactory().openSession();
			// 2. begin transaction
			tx = session.beginTransaction();
			// 3. select hql
			categories = session.createQuery("FROM Product").list();
			// 4. close connect
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	public boolean deleteProduct(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = getFactory().openSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("Delete Product c where c.id=:idProduct");
			q.setParameter("idProduct", id);
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
	public Product findById(int id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = getFactory().openSession();
			tx = session.beginTransaction();
			Query q = session.createQuery("FROM Product c where c.id=:idProduct");
			q.setParameter("idProduct", id);
			List<Product> categories = (List<Product>) q.list();
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

	public boolean updateProduct(Product product) {
		Session session = null;
		Transaction tx = null;
		try {
			session = getFactory().openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(product);
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

	public Integer saveProduct(Product productNew) {
		Session session = null;
		Transaction tx = null;
		Integer id = null;

		try {
			session = getFactory().openSession();
			tx = session.beginTransaction();
			Product product = new Product();
			product.setName(productNew.getName());
			product.setCategory(productNew.getCategory());
			id = (Integer) session.save(product);
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
