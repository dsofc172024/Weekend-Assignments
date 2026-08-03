package io.assignments.streams;

//Program to find all the statistics [avg, min, max, sum, count] for salary of employee per department

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamEmpAssignement {

	public static void main(String[] args) {
		StreamEmpAssignement obj = new StreamEmpAssignement();
		
		obj.addEmployees(obj);
	}
		
		public void addEmployees(StreamEmpAssignement obj) {
			Employee e1 = new Employee();
			e1.setId(1);
			e1.setName("Alex");
			e1.setSalary(50000);
			e1.setDeptId(101);

			Employee e2 = new Employee();
			e2.setId(2);
			e2.setName("Cam");
			e2.setSalary(70000);
			e2.setDeptId(101);

			Employee e3 = new Employee();
			e3.setId(3);
			e3.setName("Jay");
			e3.setSalary(60000);
			e3.setDeptId(102);

			Employee e4 = new Employee();
			e4.setId(4);
			e4.setName("Gloria");
			e4.setSalary(90000);
			e4.setDeptId(102);

			Employee e5 = new Employee();
			e5.setId(5);
			e5.setName("Manny");
			e5.setSalary(100000);
			e5.setDeptId(102);

			List<Employee> employees = List.of(e1, e2, e3, e4, e5);

			obj.statisticsOfEmp(employees);
		}
		
		public void statisticsOfEmp(List<Employee> listOfEmp) {
			Map<Integer, DoubleSummaryStatistics> statistics= listOfEmp.stream().distinct().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.summarizingDouble(Employee::getSalary)));
			statistics.forEach((deptId, stat) -> {
				System.out.println("DeptID:: "+deptId);
				System.out.println("Average:: "+stat.getAverage());
				System.out.println("Max:: "+stat.getMax());
				System.out.println("Min:: "+stat.getMin());
				System.out.println("Count:: "+stat.getCount());
				System.out.println("Sum:: "+stat.getCount()+"\n");
			});
		}
}

	class Employee {
		private int id;
		private String name;
		private long salary;
		private int deptId;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getSalary() {
			return salary;
		}

		public void setSalary(long salary) {
			this.salary = salary;
		}

		public int getDeptId() {
			return deptId;
		}

		public void setDeptId(int deptId) {
			this.deptId = deptId;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", deptId=" + deptId + "]";
		}
		

	}
