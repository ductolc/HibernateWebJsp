package services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dao.ProductDao;
import entities.Category;
import entities.Product;
import ulti.HibernateUtil;

public class ProductServiceImpl implements ProductService {

	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	private ProductDao productDao = new ProductDao();

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProduct() {
		List<Product> categories = null;
		try {
			// 1. create session
			Session session = factory.openSession();
			// 2. begin transaction
			Transaction tx = session.beginTransaction();
			// 3. select hql
			categories = session.createQuery("FROM Product").list();
			// 4. close connect
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public boolean deleteProduct(int id) {
		try {
			return productDao.deleteProduct(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product productUpdate) {
		try {
			Product product = productDao.findById(productUpdate.getId());
			product.setName(productUpdate.getName());
			product.setCategory(productUpdate.getCategory());
			return productDao.updateProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Integer createProduct(Product productNew) {
		try {
			return productDao.saveProduct(productNew);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
