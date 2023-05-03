package com.shopping.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.model.Category;
import com.shopping.model.Product;
import com.shopping.paging.PageRequest;
import com.shopping.paging.Pageble;
import com.shopping.service.ICategoryService;
import com.shopping.service.IProductService;
import com.shopping.sort.Sorter;

@WebServlet(urlPatterns = { "/home" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject
	private ICategoryService categoryService;
	@Inject
	private IProductService productService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/tabServlet");
		rd.include(req,resp);

		Pageble pageble = new PageRequest(1, 8, new Sorter(null, null));
		List<Category> categories = categoryService.findByProductOwner(pageble);

		categories.forEach(category -> {
			List<Product> products = productService.findByCategoryId(category.getId(), pageble);
			category.setProducts(products);
		});

		req.setAttribute("model", categoryService.findAll());
		req.setAttribute("categories", categories);

		RequestDispatcher rd2 = req.getRequestDispatcher("/views/web/home.jsp");
		rd2.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
