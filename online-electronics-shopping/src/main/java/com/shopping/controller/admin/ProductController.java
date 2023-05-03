package com.shopping.controller.admin;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.shopping.dao.IProductMetaDAO;
import com.shopping.model.Brand;
import com.shopping.model.Category;
import com.shopping.model.Image;
import com.shopping.model.Product;
import com.shopping.model.ProductMeta;
import com.shopping.service.IBrandService;
import com.shopping.service.ICategoryService;
import com.shopping.service.IProductMetaService;
import com.shopping.service.IProductService;
import com.shopping.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin/products", "/admin/products/create", "/admin/products/meta/create" })
@MultipartConfig()
public class ProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;
	@Inject
	private IBrandService brandService;
	@Inject
	private IProductService productService;
	@Inject 
	private IProductMetaService productMetaService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath() != null ? req.getServletPath() : "";
		switch (path) {
		case "/admin/products": {
			List<Product> products = productService.findAll();
			products.forEach((Product product) -> {
				System.out.println(product.toString());
			});

			req.setAttribute("model", products);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/products.jsp");
			rd.forward(req, resp);
		}
			break;
		case "/admin/products/create": {
			List<Category> categories = categoryService.findAll();
			List<Brand> brands = brandService.findAll();

			req.setAttribute("model", categories);
			req.setAttribute("brands", brands);

			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/createProduct.jsp");
			rd.forward(req, resp);
		}
			break;

		case "/admin/products/meta/create": {
			int product_id = Integer.valueOf(req.getParameter("id"));
			String product_name = req.getParameter("name");

			req.setAttribute("product_id", product_id);
			req.setAttribute("product_name", product_name);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/createProductMeta.jsp");
			rd.forward(req, resp);
		}
			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath() != null ? req.getServletPath() : "";
		switch (path) {
		case "/admin/products/create": {
			Product product = FormUtil.toModel(Product.class, req);
			int category_id = Integer.parseInt(req.getParameter("category_id"));
			Category category = new Category();
			category.setId(category_id);

			int brand_id = Integer.parseInt(req.getParameter("brand_id"));
			Brand brand = new Brand();
			brand.setId(brand_id);

			product.setCategory(category);
			product.setBrand(brand);

			Part filePart = req.getPart("image");
			Image image = new Image();
			image.setFilePart(filePart);

			product.setImage(image);

			if (productService.save(product) != 0) {
				resp.sendRedirect(req.getContextPath() + "/admin/products/create");
			}
		}
			break;
		case "/admin/products/meta/create": {
			String[] keys = req.getParameterValues("keys"); 
			String[] contents = req.getParameterValues("contents"); 
			int product_id = Integer.valueOf(req.getParameter("product_id"));
			Product product = new Product();
			product.setId(product_id);
			for(int i = 0; i < keys.length; i++) {
				ProductMeta productMeta = new ProductMeta();
				productMeta.setKey(keys[i]);
				productMeta.setContent(contents[i]);
				productMeta.setProduct(product);
				
				System.out.println(productMetaService.save(productMeta));
				
			}
		}
			break;
		default:
			break;
		}

	}

}
