package adapter;

public class EmployeeAdapter implements Target {
    private final BillingSystem thirdPartyBillingSystem = new BillingSystem();

    @Override
    public void processCompanySalary(String[][] employeesArray) {

    }
}
