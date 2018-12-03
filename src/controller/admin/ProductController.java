package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Product;
import services.ProductServiceImpl;

@WebServlet("/admin/product")
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductServiceImpl productServices = new ProductServiceImpl();
		List<Product> products = productServices.getAllProduct();

		req.setAttribute("productList", products);
		req.getRequestDispatcher("/views/product/list.jsp").forward(req, resp);
	}
}
