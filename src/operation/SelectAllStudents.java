package operation;
import database.jdbcImplement;
import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectAllStudents {
    public static void selectAllStudent(){
        jdbcImplement jdbc= new jdbcImplement();
        try ( Connection connection = jdbc.dataSource().getConnection()){
            String selectStudent = "SELECT * FROM student";
            connection.prepareStatement(selectStudent);
            PreparedStatement preparedStatement = connection.prepareStatement(selectStudent);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> students = new ArrayList<>();
            System.out.println();
            System.out.println("\tID\t\tName\t\t\tGender\t\t\tClassname\t\t\tScore");
            System.out.println("-----------------------------------------------------------------------------------");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String classname = resultSet.getString("classname");
                Float score = resultSet.getFloat( "score");
                students.add(new Student(name,gender,classname,score));
                System.out.println("\t"+id+"\t\t"+name+"\t\t\t"+gender+"\t\t\t"+classname+"\t\t\t\t\t"+score);
            }
            System.out.println("-----------------------------------------------------------------------------------");
        }catch (SQLException exception){
            System.out.printf(exception.getMessage());;
        }
    }
}
