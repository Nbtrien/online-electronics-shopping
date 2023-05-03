package com.shopping.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;

import com.shopping.model.User;
import com.shopping.service.impl.UserService;
import com.shopping.utils.FormUtil;
import com.shopping.utils.SessionUtil;

@WebServlet(urlPatterns = { "/auth/login", "/auth/register", "/auth/logout" })
public class AuthController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private UserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath() != null ? req.getServletPath() : "";
		switch (path) {
		case "/auth/login": {

			RequestDispatcher rd = req.getRequestDispatcher("/views/authentication/login.jsp");
			rd.forward(req, resp);
		}
			break;
		case "/auth/register": {
			RequestDispatcher rd = req.getRequestDispatcher("/views/authentication/register.jsp");
			rd.forward(req, resp);
		}
			break;
		case "/auth/logout": {		
			SessionUtil.getInstance().removeValue(req, "userLogin");
			resp.sendRedirect(req.getContextPath() + "/home");
		}
			break;
		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath() != null ? req.getServletPath() : "";
		PrintWriter out = resp.getWriter();
		switch (path) {
		case "/auth/login": {
			User user = FormUtil.toModel(User.class, req);

			System.out.println(user.toString());
			user = userService.findByLoginInfor(user);
			if (user != null) {
				SessionUtil.getInstance().putValue(req, "userLogin", user);
				resp.sendRedirect(req.getContextPath() + "/home");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("/views/authentication/login.jsp");
				out.println("<font color=red>Password is wrong.</font>");
				rd.include(req, resp);
			}

		}
			break;
		case "/auth/register": {

			User user = FormUtil.toModel(User.class, req);

			String originalPassword = user.getPassWord();
			String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));

			user.setPassWord(generatedSecuredPasswordHash);

			System.out.println(user.toString());
			user = userService.save(user);

			if (user != null) {
				SessionUtil.getInstance().putValue(req, "userLogin", user);
				resp.sendRedirect(req.getContextPath() + "/home");
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("/views/authentication/register.jsp");
				out.println("<font color=red>Fail!.</font>");
				rd.include(req, resp);
			}
//			RequestDispatcher rd = req.getRequestDispatcher("/views/authentication/register.jsp");
//			rd.forward(req, resp);
		}
			break;
		default:
			break;
		}
	}

}
