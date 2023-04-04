package operation;

import database.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateStudentById {
    private static jdbcImplement jdbc;
    private static void updateARecordById() throws SQLException {
        try (Connection connection = jdbc.dataSource().getConnection()){
            PreparedStatement updateStatement = connection.prepareStatement("UPDATE student SET name='Tata' WHERE id = 1");
//                    updateStatement.setInt(1,1);
            int updatedRows = updateStatement.executeUpdate();
        }
    }
    
}
