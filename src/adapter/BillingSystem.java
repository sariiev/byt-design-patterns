package adapter;

import java.util.List;

public class BillingSystem {
    public void processSalary(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.println("Rs." + employee.getSalary() + " Salary Credited to " + employee.getName() + " Account");
        }
    }
}
