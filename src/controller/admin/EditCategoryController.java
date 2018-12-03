package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Category;
import services.CategoryServiceImpl;

@WebServlet("/admin/category/edit")
public class EditCategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CategoryServiceImpl categoryService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String idCategory = req.getParameter("id");
			if (idCategory != null) {
				int id = Integer.parseInt(idCategory);
				Category category = categoryService.getCategoryById(id);
				req.getSession().setAttribute("categoryEdit", category);
				req.getRequestDispatcher("/views/category/edit.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			req.getSession().setAttribute("err", e.getMessage());
			resp.sendRedirect( getServletContext().getContextPath() + "/admin/category");  
			e.printStackTrace();
		}
	}
}
