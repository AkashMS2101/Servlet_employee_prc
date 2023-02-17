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

public class Employee_controler extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter printWriter = resp.getWriter();
		
		String name =req.getParameter("name");
		String email =req.getParameter("email");
		String password=req.getParameter("password");
		String address = req.getParameter("address");
		long phone = Long.parseLong(req.getParameter("phonenumber"));
		
		Employee employee = new Employee();
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setName(name);
		employee.setPassword(password);
		employee.setPhone(phone);
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.saveEmployee(employee);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("SuccessfullSignin.html");
		dispatcher.forward(req, resp);
	}
}
