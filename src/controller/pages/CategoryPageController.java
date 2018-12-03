package controller.pages;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Category;
import services.CategoryServiceImpl;

@WebServlet("/category")
public class CategoryPageController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryServiceImpl categoryService = new CategoryServiceImpl();
		List<Category> categories = categoryService.getCategories();
		req.setAttribute("categoryList", categories);
		req.getRequestDispatcher("categoryPage.jsp").forward(req,resp);
	}
}
