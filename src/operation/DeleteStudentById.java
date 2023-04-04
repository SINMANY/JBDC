package operation;
import database.jdbcImplement;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudentById {
    public static void deleteStudentById(Integer id) throws SQLException {
        jdbcImplement jdbc = new jdbcImplement();
        Student student = new Student();
        try (Connection connection = jdbc.dataSource().getConnection()) {
            String delete = "DELETE from student WHERE id = ? ";
            PreparedStatement deleteStatement = connection.prepareStatement(delete);
            deleteStatement.setInt(1, id);
            int deletedRow = deleteStatement.executeUpdate();
            System.out.println(deletedRow+ " row(s) deleted");
        }
        }
    }