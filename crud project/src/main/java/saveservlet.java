

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/saveservlet")
public class saveservlet extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String country=request.getParameter("country");
		
		Emp e=new Emp();
		e.setName(name);
		e.setEmail(email);
		e.setPassword(password);
		e.setCountry(country);
		
		int status=EmpDao.save(e);
		if(status>0) {
			out.println("Record saved successfully");
			request.getRequestDispatcher("crud.html").include(request, response);
		}
		else {out.println("Sorry unable to save record");}
		 
		out.close();
		
	}

}
