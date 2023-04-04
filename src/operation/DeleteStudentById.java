package operation;

import database.jdbcImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudentById {
    private static jdbcImplement jdbc;

    private static void deleteRecordById(){
        try (Connection con = jdbc.dataSource().getConnection()) {
            PreparedStatement deleteStatement = con.prepareStatement("DELETE from student WHERE id = 4");
//                    deleteStantement.setInt(1,1);
            int deletedRows = deleteStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.printf(exception.getMessage());
        }
    }
}
