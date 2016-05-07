package it.ecipar.helloweb.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.ecipar.helloweb.business.PersonaManager;


@WebServlet(urlPatterns = { "/hello" })
public class HelloServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7175122398680683147L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// http://localhost:8080/HelloWeb/hello?persona=Alessio
		
		String n = req.getParameter("persona");
		
		// text/plain
		// application/json
		// resp.setContentType("text/html");
		resp.setContentType("application/json");
		
		PersonaManager pm = new PersonaManager(n);
		
		PrintWriter writer = resp.getWriter();
		 //writer.print("<img src=\"/HelloWeb/img/prova.jpg\">");
		pm.serializza();
		pm.deserializza();
		writer.print(pm.getJsonSE());
		writer.print(pm.getJsonDESE());
		resp.setContentType("text/html");
		writer.print("<img src=\"/HelloWeb/img/download.jpg\">");
		
	}

}
