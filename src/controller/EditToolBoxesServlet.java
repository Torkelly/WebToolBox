package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ToolBox;

/**
 * Servlet implementation class editItemServlet
 */
@WebServlet("/EditToolBoxesItemServlet")
public class EditToolBoxesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditToolBoxesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ToolBoxHelper dao = new ToolBoxHelper();

		int toolBoxId = Integer.parseInt(request.getParameter("toolBoxId"));
		String toolBoxName = request.getParameter("toolBoxName");
		Integer tempId = Integer.parseInt(request.getParameter("id"));

		ToolBox itemToUpdate = dao.searchForToolBoxById(tempId);
		itemToUpdate.setToolBoxId(toolBoxId);
		itemToUpdate.setToolBoxName(toolBoxName);

		dao.updateToolBox(itemToUpdate);

		getServletContext().getRequestDispatcher("/ViewAllToolBoxesServlet").forward(request, response);

	}

}
