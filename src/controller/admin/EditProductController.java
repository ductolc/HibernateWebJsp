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

@WebServlet("/admin/product/edit")
public class EditProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ProductServiceImpl productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Product> categories = productService.getAllProduct();
		
		req.setAttribute("productList", categories);
		req.getRequestDispatcher("/views/product/edit.jsp").forward(req,resp);
	}
}
