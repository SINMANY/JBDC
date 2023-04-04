package operation;

import database.jdbcImplement;
import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertStudent {
    public static void insertStudent(Student student){
        jdbcImplement jdbc = new jdbcImplement();
        try (Connection connection = jdbc.dataSource().getConnection()){
            String insertSql =  "INSERT INTO student (name,gender,classname,score) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2,student.getGender());
            preparedStatement.setString(3,student.getClassname());
            preparedStatement.setFloat(4,student.getScore());
            preparedStatement.executeUpdate();
        }catch (SQLException exception){
            System.out.printf(exception.getMessage());
        }
    }
    public static void inputStudent(){
        Student student = new Student();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student name : ");
        student.setName(input.nextLine());
        System.out.print("Enter student gender : ");
        student.setGender(input.nextLine());
        System.out.print("Enter student class name : ");
        student.setClassname(input.nextLine());
        System.out.print("Enter student score : ");
        student.setScore(input.nextFloat());
        insertStudent(student);
    }
}
