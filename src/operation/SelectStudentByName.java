package operation;

import database.jdbcImplement;
import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectStudentByName {
    public static void SelectRecordByName(String name) throws SQLException {
        jdbcImplement jdbc = new jdbcImplement();
        try (Connection connection = jdbc.dataSource().getConnection()){
            String selectStudentById = "SELECT * FROM student WHERE name = ? ";
            PreparedStatement statement = connection.prepareStatement(selectStudentById);
            statement.setString(1,name);
            statement.executeQuery();
            ResultSet resultSet = statement.executeQuery();
            Student student = new Student();
            System.out.println("================================ Students Information =============================");
            System.out.println("");
            System.out.println("\tID\t\tName\t\t\t\t\tGender\t\t\tClassname\t\t\tScore");
            System.out.println("-----------------------------------------------------------------------------------");
            while (resultSet.next()){
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setGender(resultSet.getString("gender"));
                student.setClassname(resultSet.getString("classname"));
                student.setScore(resultSet.getFloat("score"));
            }
            System.out.println("\t"+student.getId()+"\t\t"+student.getName()+"\t\t\t\t\t"+student.getGender()+"\t\t\t"+student.getClassname()+"\t\t\t\t"+student.getScore());
            System.out.println("-----------------------------------------------------------------------------------");
        }
    }
}
