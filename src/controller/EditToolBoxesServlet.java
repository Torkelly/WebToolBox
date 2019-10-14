  
package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ToolBox;
import model.Tool;
import model.Owner;

/**
 * Servlet implementation class editExistingListServlet
 */
@WebServlet("/EditToolBoxesServlet")
public class EditToolBoxesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditToolBoxesServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ToolBoxHelper tbh = new ToolBoxHelper();
		ToolHelper th = new ToolHelper();
		OwnerHelper oh = new OwnerHelper();

		int idToEdit = Integer.parseInt(request.getParameter("toolBoxId"));
		ToolBox toEdit = tbh.searchForToolBoxById(idToEdit);

		String toolBoxName = request.getParameter("toolBoxName");
		System.out.println("ToolBox Name: " + toolBoxName);
		toEdit.setToolBoxName(toolBoxName);

		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		toEdit.setDateAdded(ld);

		// update the owner
		String ownerName = request.getParameter("ownerName");
		Owner owner;
		try {
			owner = oh.searchForOwnerByName(ownerName);
		} catch (NoResultException ex) {
			owner = new Owner(ownerName);
		} catch (Exception ex) {
			owner = new Owner(ownerName);
		}

		toEdit.setOwner(owner);

		// update the list of items
		List<Tool> previousToolsInToolBox = toEdit.getToolsInToolBox();

		String[] selectedTools = request.getParameterValues("toolsToAdd");
		List<Tool> selectedToolsInToolBox = new ArrayList<Tool>();

		if (selectedTools != null && selectedTools.length > 0 ) {
			for (int i = 0; i < selectedTools.length; i++) {
				System.out.println(selectedTools[i]);
				Tool t = th.searchForToolById(Integer.parseInt(selectedTools[i]));
				selectedToolsInToolBox.add(t);

			}

			previousToolsInToolBox.addAll(selectedToolsInToolBox);
		}

		toEdit.setToolsInToolBox(previousToolsInToolBox);

		tbh.updateToolBox(toEdit);

		System.out.println("Success!");
		System.out.println(toEdit.toString());

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