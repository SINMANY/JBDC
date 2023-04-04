package operation;

import database.jdbcImplement;
import model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateStudentById {

    public static void update(){
        jdbcImplement jdbc = new jdbcImplement();
        Student student = new Student();
        try (Connection connection= jdbc.dataSource().getConnection()){
            String update = "UPDATE topics SET name=?, description=?, status=? WHERE id = "+ student.getId();
            PreparedStatement statement = connection.prepareStatement(update);
            statement.setString(1,student.getName());
            statement.setString(2,student.getGender());
            statement.setString(3,student.getClassname());
            statement.setFloat(4,student.getScore());
            int count = statement.executeUpdate();
            System.out.println(count);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void updateStudentById(){
        Scanner input = new Scanner(System.in);
        Student student = new Student();
        System.out.print("Enter student ID : ");
        student.setId(input.nextInt());
        System.out.print("Enter student name : ");
        input.nextLine();
        student.setName(input.nextLine());
        System.out.print("Enter student gender : ");
        student.setGender(input.nextLine());
        System.out.print("Enter student class name: ");
        student.setClassname(input.nextLine());
        System.out.print("Enter score : ");
        student.setScore(input.nextFloat());
        update();
    }
}

