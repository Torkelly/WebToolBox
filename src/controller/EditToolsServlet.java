package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Tool;

/**
 * Servlet implementation class EditToolsServlet
 */
@WebServlet("/EditToolsServlet")
public class EditToolsServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditToolsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ToolHelper dao = new ToolHelper();
		
		String toolName = request.getParameter("toolName");
		int toolId = Integer.parseInt(request.getParameter("toolId"));
		Integer tempId = Integer.parseInt(request.getParameter("toolId"));
				
		Tool itemToUpdate = dao.searchForToolById(tempId);
		itemToUpdate.setToolName(toolName);
		itemToUpdate.setToolId(toolId);
				
		dao.updateTool(itemToUpdate);

		getServletContext().getRequestDispatcher("/ViewAllToolsServlet").forward(request, response);


	}

}
