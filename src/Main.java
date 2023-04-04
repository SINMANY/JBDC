import database.jdbcImplement;
import model.Student;

import javax.sound.midi.Soundbank;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

            private static jdbcImplement jdbc;
            private static void selectAllStudents(){
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
            private static void selectRecordById() throws SQLException {
                try (Connection connection = jdbc.dataSource().getConnection()){
                    String selectarecordbyid = "SELECT * FROM student WHERE id = 4";
                    connection.prepareStatement(selectarecordbyid);
                    PreparedStatement preparedStatement = connection.prepareStatement(selectarecordbyid);
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

    private static void selectRecordByName(){
        try (Connection connection = jdbc.dataSource().getConnection()){
            String selectarecordbyid = "SELECT * FROM student WHERE name = 'sreyneang'";
            connection.prepareStatement(selectarecordbyid);
            PreparedStatement preparedStatement = connection.prepareStatement(selectarecordbyid);
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
        }catch (SQLException e){
            System.out.printf(e.getMessage());
        }
    }



            private static void insertStudent(Student student){
                try (Connection connection = jdbc.dataSource().getConnection()){
                    String insertSql = "INSERT INTO student (name,gender,classname,score) VALUES (?,?,?,?)";
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
            public static void inputRecord(){
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
            private static void updateARecordById() throws SQLException {
                try (Connection connection = jdbc.dataSource().getConnection()){
                    PreparedStatement updateStatement = connection.prepareStatement("UPDATE student SET name='Tata' WHERE id = 1");
//                    updateStatement.setInt(1,1);
                    int updatedRows = updateStatement.executeUpdate();
                }
            }

            private static void deleteRecordById(){
                try (Connection con = jdbc.dataSource().getConnection()) {
                    PreparedStatement deleteStatement = con.prepareStatement("DELETE from student WHERE id = 4");
//                    deleteStantement.setInt(1,1);
                    int deletedRows = deleteStatement.executeUpdate();
                }catch (SQLException exception){
                    System.out.printf(exception.getMessage());
                }
            }
            public static void main(String[] args) throws SQLException {
                Scanner input = new Scanner(System.in);
                jdbc = new jdbcImplement();
                int option;
                do {
                    System.out.println(">>> ===================");
                    System.out.println("1. Select all records");
                    System.out.println("2. Select a record by ID");
                    System.out.println("3. Select all record by name");
                    System.out.println("4. Insert a record");
                    System.out.println("5. Update a record by ID");
                    System.out.println("6. Delete a record by ID");
                    System.out.print(">>> Choose your option : ");
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> {
                            System.out.println("================ All Records ==============");
                            selectAllStudents();
                        }
                        case 2 -> {
                            System.out.println("================ Select a record by ID ===============");
                            selectRecordById();
                        }
                        case 3 -> {
                            System.out.println("================= Select records by name");
//                            System.out.println("Enter name : ");
                            selectRecordByName();

                        }
                        case 4 -> {
                            System.out.println("================ Insert a record ================");
                            inputRecord();
                        }
                        case 5 -> {
                            updateARecordById();
                        }
                        case 6 -> {
                            deleteRecordById();
                        }
                    }

                }while (option != 7) ;
            }
    }
