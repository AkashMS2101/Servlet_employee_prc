package employee_info_servlet_dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import employee_info_servlet_dto.Employee;

public class EmployeeDAO {
	
	public EntityManager getEntitymanager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("akash");
		return entityManagerFactory.createEntityManager();
	}
	
	public void saveEmployee(Employee employee) {
		EntityManager entityManager = getEntitymanager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
	}

	public void updateEmployee(int eid,Employee employee) {
		EntityManager entityManager = getEntitymanager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee employee2 = entityManager.find(Employee.class, eid);
		employee.setId(eid);
		if(employee2!=null) {
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		}else {
			System.out.println("employee doesn't exist");
		}
	}
	public String loginbyEmail(String email) {
		EntityManager entityManager = getEntitymanager();
		
		String jpql = "SELECT e FROM Employee e WHERE e.email=?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, email);
		Employee employee= (Employee) query.getSingleResult();
		return employee.getPassword();
	}
	
	public String loginbyEid(int eid) {
		EntityManager entityManager = getEntitymanager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Employee employee2 = entityManager.find(Employee.class, eid);
		return employee2.getPassword();
	}
}


















