package com.shopping.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.model.Product;
import com.shopping.model.ProductReview;
import com.shopping.model.User;
import com.shopping.service.IProductReviewService;
import com.shopping.utils.FormUtil;

@WebServlet(urlPatterns = { "/product-reviews" })
public class ProductReviewController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductReviewService reviewService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("reivews");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String content = req.getParameter("content");
		ProductReview review = FormUtil.toModel(ProductReview.class, req);
		int productId = Integer.valueOf(req.getParameter("productId"));
		int userId = Integer.valueOf(req.getParameter("userId"));

		Product product = new Product();
		product.setId(productId);

		User user = new User();
		user.setId(userId);

		review.setProduct(product);
		review.setUser(user);

		int save = reviewService.save(review);

		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		if (save != 0) {
			resp.getWriter().print("Successful!");
		} else {
			resp.getWriter().print("Fail!");
		}
		
	}

}
