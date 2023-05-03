package com.shopping.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shopping.model.User;
import com.shopping.utils.SessionUtil;

public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		User user = (User) SessionUtil.getInstance().getValue(req, "userLogin");

		String url = req.getRequestURI();
		PrintWriter out = resp.getWriter();
		if (url.startsWith("/admin")) {
			if (user != null) {
				if (user.getRole().getName().equals("admin")) {

					chain.doFilter(request, response);
				} else {
					resp.sendRedirect(req.getContextPath() + "/home");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/auth/login");
			}
		} else if (url.startsWith("/auth")) {
			if (url.equals("/auth/logout")) {
				chain.doFilter(request, response);
			} else if (user != null) {
				resp.sendRedirect(req.getContextPath() + "/home");
			} else {
				chain.doFilter(request, response);
			}
		} else if (url.startsWith("/cart")) {
			if (user != null) {
				chain.doFilter(request, response);
			} else {
				resp.sendRedirect(req.getContextPath() + "/auth/login");
			}
		} else if (url.startsWith("/orders")) {
			if (user != null) {
				chain.doFilter(request, response);
			} else {
				resp.sendRedirect(req.getContextPath() + "/auth/login");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

}
