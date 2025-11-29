package factory;

public class DatabaseFactory {
    private DatabaseFactory() {

    }

    public static Database createDatabase(DatabaseType type) {
        switch (type) {
            case SQL_SERVER -> {
                return new SqlServerDatabase();
            }
            case ORACLE -> {
                return new OracleDatabase();
            }
            default -> throw new IllegalArgumentException("Unknown database type");
        }
    }
}
