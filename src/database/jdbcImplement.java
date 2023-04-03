package database;
import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;
public class jdbcImplement {
    public DataSource dataSource(){
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("postgres");
        dataSource.setPassword("1219");
        dataSource.setDatabaseName("postgres");
        return dataSource;
    }

}