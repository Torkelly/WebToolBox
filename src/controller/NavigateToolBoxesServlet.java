  
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ToolBox;
import model.Tool;

/**
 * Servlet implementation class toolBoxNavigationServlet
 */
@WebServlet("/NavigateToolBoxesServlet")
public class NavigateToolBoxesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigateToolBoxesServlet() {
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
		ToolBoxHelper tbh = new ToolBoxHelper();
		String act = request.getParameter("doThisToTool");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/ViewAllToolBoxesServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("toolBoxId"));
				ToolBox toolBoxToDelete = tbh.searchForToolBoxById(tempId);
				tbh.deleteToolBox(toolBoxToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("toolBoxId"));
				ToolBox toolBoxToEdit = tbh.searchForToolBoxById(tempId);
				ToolHelper th = new ToolHelper();
				List<Tool> allTools = th.showAllTools();
				List<Tool> currentToolsInToolBox = toolBoxToEdit.getToolsInToolBox();

				System.out.println("----After removing items-------");
				for (int i = 0; i < allTools.size(); i++) {
					for (int j = 0; j < currentToolsInToolBox.size(); j++) {
						if (allTools.get(i).getId() == currentToolsInToolBox.get(j).getId()) {
							allTools.remove(i);
						}
					}
				}



				request.setAttribute("toolBoxToEdit", toolBoxToEdit);
				request.setAttribute("allToolsToAdd", allTools);
				getServletContext().getRequestDispatcher("/EditTBox.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllToolBoxesServlet").forward(request, response);
			}

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/addToolsForListServlet").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}