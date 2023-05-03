package com.shopping.controller.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.model.Category;
import com.shopping.service.ICategoryService;
import com.shopping.service.impl.CategoryService;
import com.shopping.utils.HttpUtil;


@WebServlet(urlPatterns = {"/api/categories"})
public class CategoryController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		Category category = HttpUtil.of(req.getReader()).toModel(Category.class);
		
		int id = categoryService.save(category);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), id);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		List<Category> categories = categoryService.findAll();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), categories);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		Category category = HttpUtil.of(req.getReader()).toModel(Category.class);
		category = categoryService.update(category);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(resp.getOutputStream(), category);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		Category category = HttpUtil.of(req.getReader()).toModel(Category.class);
		categoryService.delete(category.getIds());
	}
	
}
