package operation;
import database.jdbcImplement;
import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class selectAllStudents {
    private static jdbcImplement jdbc;
    public static void selectAllStudent(){
        try ( Connection connection = jdbc.dataSource().getConnection()){
            String selectsql = "SELECT * FROM student";
            connection.prepareStatement(selectsql);
            PreparedStatement preparedStatement = connection.prepareStatement(selectsql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> students = new ArrayList<>();
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
                students.add(new Student(name,gender,classname,score));
                System.out.println("\t"+id+"\t\t"+name+"\t\t\t\t\t"+gender+"\t\t\t"+classname+"\t\t\t\t\t"+score);
            }
        }catch (SQLException exception){
            System.out.printf(exception.getMessage());;
        }
    }
}
