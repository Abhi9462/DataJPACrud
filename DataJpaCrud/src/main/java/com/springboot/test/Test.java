package com.springboot.test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.entity.Employee;
import com.springboot.repo.EmpRepo;

@Component
public class Test implements CommandLineRunner {
	Scanner sc = new Scanner(System.in);
	ArrayList<Employee> list = new ArrayList<Employee>();
	@Autowired
	EmpRepo er;

	private void checkEmp() {

		System.out.println("Please enter ID to check");
		int id = sc.nextInt();
		if (er.existsById(id))
			System.out.println("Exist");
		else
			System.out.println("Not Exist");

	}

	private void countRows() {
		long numberOfEmployees = er.count();
		System.out.println(numberOfEmployees);
	}

	private void deleteAllEmployees() {
		er.deleteAll();

	}

	private void deleteEmployee() {
		System.out.println("Please enter ID to update");
		int id = sc.nextInt();
		er.deleteById(id);
	}

	private void updateEmployee() {

		System.out.println("Please enter ID to update");
		int id = sc.nextInt();
		Optional<Employee> emp = er.findById(id);
		Employee emp2 = emp.get();

		System.out.println("Please Enter new Employee Name");
		sc.nextLine();
		String name = sc.nextLine();

		System.out.println("Please Enter new Employee Email");
		String email = sc.nextLine();

		System.out.println("Please Enter new Employee Address");
		String address = sc.nextLine();

		System.out.println("Please Enter new Employee Phone");
		long phone = sc.nextLong();

		emp2.setEmpName(name);
		emp2.setEmpEmail(email);
		emp2.setEmpAddress(address);
		emp2.setEmpPhone(phone);
		er.save(emp2);

	}

	private void listEmployees() {
		Iterable<Employee> empList = er.findAll();
		for (Employee employee : empList) {
			System.out.println(employee);
		}

	}

	private void searchEmployee() {

		System.out.println("Please enter employee id to search");
		int id = sc.nextInt();

		Optional<Employee> emp = er.findById(id);
		System.out.println(emp);

	}

	private void insertMultipleEmployees() {
		System.out.println("Please Enter number of employees to insert");
		int num = sc.nextInt();
		int empNum = 1;

		while (num-- != 0) {
			System.out.println("Please Enter number" + empNum + " Employee Name");
			sc.nextLine();
			String name = sc.nextLine();

			System.out.println("Please Enter number" + empNum + " Employee Email");
			String email = sc.nextLine();

			System.out.println("Please Enter number" + empNum + " Employee Address");
			String address = sc.nextLine();

			System.out.println("Please Enter number" + empNum + " Employee Phone");
			long phone = sc.nextLong();
			System.out.println("");
			Employee emp = new Employee(name, email, address, phone);

			list.add(emp);
			empNum++;

		}
		er.saveAll(list);

	}

	private void insertEmployee() {

		System.out.println("Please Enter Employee Name");
		sc.nextLine();
		String name = sc.nextLine();

		System.out.println("Please Enter Employee Email");
		String email = sc.nextLine();

		System.out.println("Please Enter Employee Address");
		String address = sc.nextLine();

		System.out.println("Please Enter Employee Phone");
		long phone = sc.nextLong();

		Employee emp = new Employee(name, email, address, phone);

		er.save(emp);

	}

	@Override
	public void run(String... args) throws Exception {

		while (true) {
			System.out.println(
					"Press 1 to insert employee\nPress 2 to insert multiple employee\nPress 3 to search employee\n"
							+ "Press 4 to show list of all employees\nPress 5 to update employee\nPress 6 to delete employee\n"
							+ "Press 7 to delete all employees\nPress 8 to count rows in table\nPress 9 to check employee exist or not\nPress 10 to exit");

			int num = sc.nextInt();

			switch (num) {
			case 1:
				insertEmployee();
				break;
			case 2:
				insertMultipleEmployees();
				break;
			case 3:
				searchEmployee();
				break;
			case 4:
				listEmployees();
				break;
			case 5:
				updateEmployee();
				break;
			case 6:
				deleteEmployee();
				break;
			case 7:
				deleteAllEmployees();
				break;
			case 8:
				countRows();
				break;
			case 9:
				checkEmp();
				break;
			case 10:
				System.exit(0);
			}
		}

	}

}
