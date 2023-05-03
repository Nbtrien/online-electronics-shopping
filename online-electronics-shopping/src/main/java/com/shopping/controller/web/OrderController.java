package com.shopping.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shopping.model.Order;
import com.shopping.model.OrderItem;
import com.shopping.model.Product;
import com.shopping.model.User;
import com.shopping.service.IOrderItemService;
import com.shopping.service.IOrderService;
import com.shopping.utils.SessionUtil;

@WebServlet(urlPatterns = { "/orders", "/orders/create" })
public class OrderController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IOrderService orderService;
	@Inject
	private IOrderItemService itemService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/tabServlet");
		rd.include(req, resp);
		User user = (User) SessionUtil.getInstance().getValue(req, "userLogin");

		List<Order> orders = orderService.findByUserId(user.getId());

		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for (Order order : orders) {
			List<OrderItem> items = itemService.findByOrderId(order.getId());
			order.setOrderItems(items);
			orderItems = Stream.concat(orderItems.stream(), items.stream()).collect(Collectors.toList());
		}

		Float total = (float) 0;
		for (Order order : orders) {
			total = total + order.getSubTotal();
		}

		req.setAttribute("model", orders);
		req.setAttribute("orderItems", orderItems);
		req.setAttribute("total", total);

		RequestDispatcher rd2 = req.getRequestDispatcher("/views/web/order.jsp");
		rd2.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Order order = new Order();
		Float subTotal = Float.valueOf(req.getParameter("subTotal"));
		int userId = Integer.valueOf(req.getParameter("userId"));

		order.setSubTotal(subTotal);
		order.setGrandTotal(subTotal);
		order.setFullName(req.getParameter("fullName"));
		order.setMobile(req.getParameter("mobile"));
		order.setAddress(req.getParameter("email"));
		order.setEmail(req.getParameter("address"));

		User user = new User();
		user.setId(userId);
		order.setUser(user);

		String[] productIds = req.getParameterValues("productIds[]");
		String[] productPrices = req.getParameterValues("productPrices[]");
		String[] productQuantities = req.getParameterValues("productQuantities[]");

		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		for (int i = 0; i < productIds.length; i++) {
			OrderItem orderItem = new OrderItem();

			Product product = new Product();
			product.setId(Integer.valueOf(productIds[i]));

			orderItem.setProduct(product);
			orderItem.setPrice(Float.valueOf(productPrices[i]));
			orderItem.setQuantity(Integer.valueOf(productQuantities[i]));

			orderItems.add(orderItem);
		}
		order.setOrderItems(orderItems);

		int result = orderService.save(order);

		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");

		if (result != 0) {
			resp.getWriter().print("SUCCESSFUL!");
		} else {
			resp.getWriter().print("FAIL!");
		}

	}
}
