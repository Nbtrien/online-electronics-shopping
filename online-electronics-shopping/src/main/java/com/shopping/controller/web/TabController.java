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
import com.shopping.paging.PageRequest;
import com.shopping.paging.Pageble;
import com.shopping.service.ICategoryService;
import com.shopping.sort.Sorter;

//@WebServlet(urlPatterns = { "/*" })
@WebServlet(name="tabServlet", urlPatterns={"/tabServlet"})
public class TabController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject 
	private ICategoryService categoryService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Pageble pageble = new PageRequest(1, 12, new Sorter(null, null));
		List<Category> categories = categoryService.findAll(pageble);
		req.setAttribute("tabs", categories);
	}
}
