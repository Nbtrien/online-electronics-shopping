package com.shopping.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.shopping.model.Brand;
import com.shopping.model.Category;
import com.shopping.model.Image;
import com.shopping.service.IBrandService;
import com.shopping.service.ICategoryService;

@WebServlet(urlPatterns = { "/admin/categories" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
		maxFileSize = 1024 * 1024 * 50, // 50 MB
		maxRequestSize = 1024 * 1024 * 100)
public class CategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "uploads";

	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IBrandService brandService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> categories = categoryService.findAll();
		List<Brand> brands = brandService.findAll();

		req.setAttribute("model", categories);
		req.setAttribute("brands", brands);
	
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/categories.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		
		Part filePart = req.getPart("image");
		Image image = new Image();
		image.setFilePart(filePart);

        Category category = new Category();
        category.setName(name);

        category.setImage(image);
        
        if (categoryService.save(category) != 0) {
        	resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }

	}

	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
//		System.out.println("content-disposition header= " + contentDisp);
		String[] tokens = contentDisp.split(";");
		for (String token : tokens) {
			if (token.trim().startsWith("filename")) {
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}
}
