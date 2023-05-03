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

import com.shopping.dao.ICartItemDAO;
import com.shopping.model.Cart;
import com.shopping.model.CartItem;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.service.ICartItemService;
import com.shopping.service.ICartService;
import com.shopping.utils.FormUtil;
import com.shopping.utils.SessionUtil;

@WebServlet(urlPatterns = { "/cart-items/create", "/cart" })
public class CartController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ICartItemService cartItemService;
	@Inject
	private ICartService cartService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/tabServlet");
		rd.include(req, resp);
		User user = (User) SessionUtil.getInstance().getValue(req, "userLogin");

		Cart cart = cartService.findByUserId(user.getId());

		List<CartItem> cartItems = cartItemService.findByCartId(cart.getId());

		cart.setCartItems(cartItems);
//		cart.getCartItems().forEach(item -> System.out.println(item.getProduct().toString()));
		req.setAttribute("model", cart);
		req.setAttribute("cartItems", cartItems);

		RequestDispatcher rd2 = req.getRequestDispatcher("/views/web/shoppingCart.jsp");
		rd2.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath() != null ? req.getServletPath() : "";
		switch (path) {
		case "/cart-items/create": {
			CartItem cartItem = FormUtil.toModel(CartItem.class, req);
			int userId = Integer.valueOf(req.getParameter("userId"));

			int productId = Integer.valueOf(req.getParameter("productId"));
			Product product = new Product();
			product.setId(productId);
			cartItem.setProduct(product);

			resp.setContentType("text/plain");
			resp.setCharacterEncoding("UTF-8");

			int result = cartItemService.save(cartItem, userId);
			if (result != 0) {
				resp.getWriter().print("SUCCESSFUL!");
			} else {
				resp.getWriter().print("FAIL!");
			}
		}
			break;

		default:
			break;
		}
	}
}
