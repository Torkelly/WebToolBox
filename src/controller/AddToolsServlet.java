package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tool;

/**
 * Servlet implementation class addItemServlet
 */
@WebServlet("/AddToolsServlet")
public class AddToolsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToolsServlet() {
		super();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toolName = request.getParameter("toolName");
		
		Tool ti = new Tool(toolName);
		ToolHelper dao = new ToolHelper();
		dao.insertTool(ti);
		
		getServletContext().getRequestDispatcher("/Index.html").forward(request, response);

	}

}
