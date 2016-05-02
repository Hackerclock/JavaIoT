package com.alessiogavioli.catalogoarte.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alessiogavioli.catalogoarte.business.JsonManager;
import com.alessiogavioli.catalogoarte.business.Status;

/**
 * Servlet implementation class ServletCatalogoArte
 */
@WebServlet("/save")
public class ServletCatalogoArte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCatalogoArte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String n = req.getParameter("data");
		
		resp.setContentType("application/json");
			
		PrintWriter writer = resp.getWriter();
		JsonManager.jsonSe = n;
		System.out.println("Deserializzazione: " + JsonManager.deserializza());
		JsonManager.serializza(new Status("OK"));
		writer.print(JsonManager.jsonSe);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
