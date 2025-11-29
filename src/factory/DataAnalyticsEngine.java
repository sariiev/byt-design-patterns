package factory;

public class DataAnalyticsEngine {
    private final Database database;

    public DataAnalyticsEngine(Database database) {
        this.database = database;
    }

    public void processData(String query) {
        database.connect();
        database.executeQuery(query);
    }
}
