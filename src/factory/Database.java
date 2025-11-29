package factory;

public interface Database {
    void connect();
    void executeQuery(String query);
}
