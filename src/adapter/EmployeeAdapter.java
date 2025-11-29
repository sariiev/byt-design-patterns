package adapter;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter implements Target {
    private final BillingSystem thirdPartyBillingSystem = new BillingSystem();

    @Override
    public void processCompanySalary(String[][] employeesArray) {
        List<Employee> employeeList = new ArrayList<>();

        for (String[] row : employeesArray) {
            int id = Integer.parseInt(row[0]);
            String name = row[1];
            String designation = row[2];
            double salary = Double.parseDouble(row[3]);

            Employee employee = new Employee(id, name, designation, salary);
            employeeList.add(employee);
        }

        thirdPartyBillingSystem.processSalary(employeeList);
    }
}
