package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== TEST 1: department findById ===");
		Department dep1 = departmentDao.findById(2);
		System.out.println(dep1);

		System.out.println("\n=== TEST 2: department findAll ===");
		List<Department> deps = departmentDao.findAll();
		for (Department dep : deps) {
			System.out.println(dep);
		}

		System.out.println("\n=== TEST 3: department insert ===");
		Department newDep = new Department(null, "Accessories");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());
		
		System.out.println("\n=== TEST 4: department update ===");
		dep1 = departmentDao.findById(8);
		dep1.setName("Utilities");
		departmentDao.update(dep1);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: department delete ===");
		departmentDao.deleteById(1);
		System.out.println("Delete completed");
	}
}
