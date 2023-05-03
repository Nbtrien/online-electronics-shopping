package com.shopping.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shopping.model.Brand;
import com.shopping.model.Image;
import com.shopping.service.IBrandService;

@WebServlet(urlPatterns = { "/admin/brands" })
@MultipartConfig()
public class BrandController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IBrandService brandService;

	private ServletFileUpload uploader = null;

	@Override
	public void init() throws ServletException {
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String name = req.getParameter("name");

		Part filePart = req.getPart("image");
		Image image = new Image();
		image.setFilePart(filePart);
	
		Brand brand = new Brand();
		brand.setName(name);
		brand.setImage(image);

//		System.out.println(brandService.save(brand));
		if (brandService.save(brand) != 0) {
			resp.sendRedirect(req.getContextPath() + "/admin/categories");
		}
	}

}
