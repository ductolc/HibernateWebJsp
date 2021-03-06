package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.ProductServiceImpl;

@WebServlet("/admin/product/delete")
public class DeleteProductController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ProductServiceImpl productService = new ProductServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String idCategory = req.getParameter("id");
			if (idCategory != null) {
				int id = Integer.parseInt(idCategory);
				boolean deleteSuccess = productService.deleteProduct(id);
				if (deleteSuccess) {
					req.getSession().setAttribute("msg", deleteSuccess);
				} else {
					req.getSession().setAttribute("msg", deleteSuccess);
				}
				resp.sendRedirect( getServletContext().getContextPath() + "/admin/product");  
			}
		} catch (Exception e) {
			req.getSession().setAttribute("err", e.getMessage());
			resp.sendRedirect( getServletContext().getContextPath() + "/admin/product");  
			e.printStackTrace();
		}
	}
}
