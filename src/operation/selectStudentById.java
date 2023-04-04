package operation;

import database.jdbcImplement;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class selectStudentById {
    private static jdbcImplement jdbc;
    private static void selectStudentById() throws SQLException {
        try (Connection connection = jdbc.dataSource().getConnection()){
            String selectStudentById = "SELECT * FROM student" + " WHERE VALUE (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(selectStudentById);
//                    preparedStatement.setInt(1,);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> student = new ArrayList<>();
            System.out.println("======================== Students Information =======================");
            System.out.println("");
            System.out.println("\tID\t\tName\t\t\t\t\tGender\t\t\tClassname\t\t\tScore");
            System.out.println("---------------------------------------------------------------------");
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String classname = resultSet.getString("classname");
                Float score = resultSet.getFloat( "score");
                student.add(new Student(name,gender,classname,score));
                System.out.println("\t"+id+"\t\t"+name+"\t\t\t\t\t"+gender+"\t\t\t"+classname+"\t\t\t\t\t"+score);
            }
        }
    }

}
