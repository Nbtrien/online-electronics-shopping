package com.shopping.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.shopping.model.ProductMeta;
import com.shopping.model.ProductReview;
import com.shopping.paging.PageRequest;
import com.shopping.paging.Pageble;
import com.shopping.service.ICategoryService;
import com.shopping.service.IProductMetaService;
import com.shopping.service.IProductReviewService;
import com.shopping.service.IProductService;
import com.shopping.sort.Sorter;

@WebServlet(urlPatterns = { "/product/*", "/category/*" })
public class ProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductService productService;
	@Inject
	private IProductMetaService productMetaService;
	@Inject
	private ICategoryService categoryService;
	@Inject 
	private IProductReviewService reviewService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("/tabServlet");
		rd.include(req, resp);

		String path = req.getServletPath() != null ? req.getServletPath() : "";
		if (path.startsWith("/product")) {
			int id = Integer.valueOf(req.getParameter("id"));
			Product product = productService.findById(id);
			
			List<ProductReview> reviews = reviewService.findByProductId(id);
			product.setReviews(reviews);
			
			float rating = (float) 0;
			for (ProductReview productReview : reviews) {
				rating +=  productReview.getRating();
			}
			product.setRating(rating/reviews.size());

			List<ProductMeta> productMetas = productMetaService.findByProductId(product.getId());

			Pageble pageble = new PageRequest(1, 6, new Sorter(null, null));
			List<Product> relatedProducts = productService.findRelated(product, pageble);

			product.setProductMetas(productMetas);
			req.setAttribute("model", product);
			req.setAttribute("relatedProducts", relatedProducts);

			RequestDispatcher rd2 = req.getRequestDispatcher("/views/web/product.jsp");
			rd2.forward(req, resp);
		} else if (path.startsWith("/category")) {
			
			
			int category_id = Integer.valueOf(req.getParameter("id"));
			Category category = categoryService.findById(category_id);
			
			List<Product> products = productService.findByCategoryId(category_id, new PageRequest(null, null, new Sorter(null, null)));
			category.setProducts(products);
			
			req.setAttribute("model", category);
			
			RequestDispatcher rd2 = req.getRequestDispatcher("/views/web/productsGrid.jsp");
			rd2.forward(req, resp);
		}

	}

}
