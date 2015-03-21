package com.comet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommetServlet
 */
public class CommetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ThreadLocal<String> tl = new ThreadLocal<String>() {
		protected String initialValue() {
			System.out.println("=================");
			return "abc";
		};
	};

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.write("success");
		tl.get();
		System.out.println(Thread.currentThread().getId());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
