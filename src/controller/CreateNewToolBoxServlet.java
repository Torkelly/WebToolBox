package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ToolBox;
import model.Tool;
import model.Owner;

/**
 * Servlet implementation class tbreateNewListServlet
 */
@WebServlet("/CreateNewToolBoxServlet")
public class CreateNewToolBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewToolBoxServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ToolHelper th = new ToolHelper();
		String toolBoxName = request.getParameter("toolBoxName");
		System.out.println("ToolBox Name: " + toolBoxName);

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String ownerName = request.getParameter("ownerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		String[] selectedTools = request.getParameterValues("allToolsToAdd");
		List<Tool> selectedToolsInToolBox = new ArrayList<Tool>();
		if (selectedTools != null && selectedTools.length > 0) {
			for (int i = 0; i < selectedTools.length; i++) {
				System.out.println(selectedTools[i]);
				Tool t = th.searchForToolById(Integer.parseInt(selectedTools[i]));
				selectedToolsInToolBox.add(t);

			}
		}

		Owner owner = new Owner(ownerName);
		ToolBox tb = new ToolBox(toolBoxName, ld, owner);
		tb.setToolsInToolBox(selectedToolsInToolBox);
		ToolBoxHelper tbh = new ToolBoxHelper();
		tbh.insertNewToolBox(tb);

		System.out.println("Success!");
		System.out.println(tb.toString());

		getServletContext().getRequestDispatcher("/ViewAllToolBoxesServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}