package com.alessiogavioli.servletscuolaballo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alessiogavioli.scuolaballo.model.Scuola;

import flexjson.JSONDeserializer;

/**
 * Servlet implementation class ServletScuolaBallo
 */
@SuppressWarnings("serial")
@WebServlet("/save")
public class ServletScuolaBallo extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String n = req.getParameter("data");
		
		// text/plain
		// application/json
		// resp.setContentType("text/html");
		resp.setContentType("application/json");
			
		PrintWriter writer = resp.getWriter();
		JSONDeserializer<Scuola> ds = new JSONDeserializer<>();
		Scuola sc = ds.use(null, Scuola.class).deserialize(n);
		System.out.println("Deserializzazione: " + sc.toString());
		writer.print("Lettura terminata");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
