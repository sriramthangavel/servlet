

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {

	private Emp[] list;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		out.println("<a href='crud.html'>Add New Employees</a>");
		out.println("<h1>Employee List</h1>");
		List Emp =EmpDao.getAllEmployee();
		out.println("<table border='1' width='100%'");
		out.println("<tr><th>Id<th><th>Name</th><th>Email</th><th>Password</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for(Emp e:list) {
			
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
