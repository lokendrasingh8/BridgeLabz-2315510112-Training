package EmployeeManagement;
import java.util.*;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee(101, "Alice", 50000));
        employees.add(new PartTimeEmployee(102, "Bob", 0, 40, 500));

        for (Employee e : employees) {
            e.displayDetails();
            System.out.println("Calculated Salary: " + e.calculateSalary());
            System.out.println("------------");
        }
    }
}
