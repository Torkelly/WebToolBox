  
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tool;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/NavigateToolsServlet")
public class NavigateToolsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigateToolsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ToolHelper th = new ToolHelper();
		String act = request.getParameter("doThisToTool");

		if (act == null) {
			getServletContext().getRequestDispatcher("/ViewAllToolsServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("toolId"));
				Tool toolToDelete = th.searchForToolById(tempId);
				th.deleteTool(toolToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/ViewAllToolsServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("toolId"));
				Tool toolToEdit = th.searchForToolById(tempId);
				request.setAttribute("toolToEdit", toolToEdit);
				getServletContext().getRequestDispatcher("/EditTool.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllToolsServlet").forward(request, response);
			} 

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/Index.html").forward(request, response);
		}

	}

}