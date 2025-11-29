import adapter.EmployeeAdapter;
import adapter.Target;
import factory.DataAnalyticsEngine;
import factory.DatabaseFactory;
import factory.DatabaseType;
import observer.ConcreteObserver;
import observer.ConcreteSubject;
import observer.Subject;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        dbEngines();
        Thread.sleep(2000);
        System.out.println();
        employeesAdapterDemo();
        Thread.sleep(2000);
        System.out.println();
        observingThings();
    }

    public static void dbEngines() {
        var sqlEngine = new DataAnalyticsEngine(DatabaseFactory.createDatabase(DatabaseType.SQL_SERVER));
        sqlEngine.processData("Query to process data for SQL Server");

        var oracleEngine = new DataAnalyticsEngine(DatabaseFactory.createDatabase(DatabaseType.ORACLE));
        oracleEngine.processData("Query to process data for Oracle");
    }

    public static void employeesAdapterDemo() {
        String[][] employeesArray = new String[][] {
                {"101","John","SE","10000"},
                {"102","Smith","SE","20000"},
                {"103","Dev","SSE","30000"},
                {"104","Pam","SE","40000"},
                {"105","Sara","SSE","50000"}
        };

        System.out.println("HR system passes employee string array to Adapter");
        System.out.println();
        Target target = new EmployeeAdapter();
        target.processCompanySalary(employeesArray);
    }

    public static void observingThings() throws InterruptedException {
        ConcreteSubject redMI = new ConcreteSubject("Red MI Mobile", 10000, "Out Of Stock");

        ConcreteObserver user1 = new ConcreteObserver("Anurag");
        user1.addSubscriber(redMI);

        ConcreteObserver user2 = new ConcreteObserver("Pranaya");
        user2.addSubscriber(redMI);

        ConcreteObserver user3 = new ConcreteObserver("Priyanka");
        user3.addSubscriber(redMI);

        Thread.sleep(1000);

        System.out.println("Red MI Mobile current state : " + redMI.getAvailability());
        System.out.println();

        Thread.sleep(1000);

        user3.removeSubscriber(redMI);

        Thread.sleep(1000);
        redMI.setAvailability("Available");
    }
}
