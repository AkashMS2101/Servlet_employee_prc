package employee_info_servlet_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employee_info_servlet_dao.EmployeeDAO;
import employee_info_servlet_dto.Employee;

public class Employee_login_byeid_controller extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int eid =Integer.parseInt(req.getParameter("eid"));
		String password = req.getParameter("password");
		
		Employee employee = new Employee();
		employee.setId(eid);
		employee.setPassword(password);
		
		EmployeeDAO dao = new EmployeeDAO();
		String getPassword =dao.loginbyEid(eid);
		
		if(password.equals(getPassword)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("Successfulllogin.html");
			dispatcher.forward(req, resp);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("employee_login.html");
			dispatcher.forward(req, resp);
		}
	}

}
