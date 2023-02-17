package employee_info_servlet_controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import employee_info_servlet_dao.EmployeeDAO;
import employee_info_servlet_dto.Employee;

public class Employee_logIn_bymail_controller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String email =req.getParameter("email");
		String password = req.getParameter("password");
		
		Employee employee = new Employee();
		employee.setEmail(email);
		employee.setPassword(password);
		
		EmployeeDAO dao = new EmployeeDAO();
		String getPassword =dao.loginbyEmail(email);
		
		if(password.equals(getPassword)) {
//			it is used to redirect within application
//			RequestDispatcher dispatcher = req.getRequestDispatcher("Successfulllogin.html");
//			dispatcher.forward(req, resp);
			
//			it is used to redirect to different page of different application
			resp.sendRedirect("https://www.google.com/");
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("employee_login.html");
			dispatcher.forward(req, resp);
		}
	}
}
