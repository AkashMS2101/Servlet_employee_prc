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

public class Employee_update_controller extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name =req.getParameter("name");
		String email =req.getParameter("email");
		String password = req.getParameter("password");
		String address= req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phonenumber"));
		int eid =Integer.parseInt( req.getParameter("eid"));
		
		Employee employee = new Employee();
		employee.setEmail(email);
		employee.setName(name);
		employee.setId(eid);
		employee.setAddress(address);
		employee.setPassword(password);
		employee.setPhone(phone);
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.updateEmployee(eid,employee);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("SuccessfullyUpdate.html");
		dispatcher.forward(req, resp);
	}
}

