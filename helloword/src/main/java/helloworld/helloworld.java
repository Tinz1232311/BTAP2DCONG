package helloworld;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class helloworld
 */
public class helloworld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helloworld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<h1>Hello world<h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String quantity = request.getParameter("quantity");
			int numtoP = Integer.parseInt(quantity);
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String[] KOT = request.getParameterValues("Type");
			double Price = 9.95;
			double Cost = Price * numtoP;
			response.getWriter().append("<p>Name: "+name+"<p>");
			response.getWriter().append("<p>Email: "+email+"<p>");
			response.getWriter().append("<p>Cost: "+Cost+"<p>");
			response.getWriter().append("<span>Chosen Transport: </span>");
			for(int i=0;i<KOT.length;i++)
			{
				if(i!=KOT.length-1)
				{
					response.getWriter().append("<span>"+KOT[i]+", </span>");
				}
				else
				{
					response.getWriter().append("<span>"+KOT[i]+"</span>");
				}
			}
		}
}
