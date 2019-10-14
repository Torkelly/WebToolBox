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
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int toolID = Integer.parseInt(request.getParameter("toolID"));
		String toolName = request.getParameter("toolName");
		
		Tool ti = new Tool(toolName);
		ToolHelper dao = new ToolHelper();
		dao.insertTool(ti);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);

	}

}
