package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ToolBox;

/**
 * Servlet implementation class ViewAllToolBoxesServlet
 */
@WebServlet("/ViewAllToolBoxesServlet")
public class ViewAllToolBoxesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllToolBoxesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ToolBoxHelper tbh = new ToolBoxHelper();
		List<ToolBox> ltb = tbh.getToolBoxes();
		request.setAttribute("allToolBoxes", ltb);
		
		if(ltb.isEmpty()){
				request.setAttribute("allToolBoxes", " ");
		}

		getServletContext().getRequestDispatcher("/ToolBoxByOwner.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}