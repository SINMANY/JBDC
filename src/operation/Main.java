package operation;

import database.jdbcImplement;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void pressAnyKey(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press Enter to continue...!");
        input.nextLine();
    }
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        jdbcImplement jdbc = new jdbcImplement();
        int option;
        System.out.println("\n>>> Practicing with JDBC <<<");
        System.out.println("--------------------------------------------------------");
        do {
            System.out.println("\t1. Select all students");
            System.out.println("\t2. Select a student by ID");
            System.out.println("\t3. Select a student by name");
            System.out.println("\t4. Insert a student");
            System.out.println("\t5. Update a student by ID");
            System.out.println("\t6. Delete a student by ID");
            System.out.println("\t7. Exit the program..!");
            System.out.println("--------------------------------------------------------");
            System.out.print(">>> Choose your option : ");
            option = input.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("=============================== Select all students =============================");
                    SelectAllStudents.selectAllStudent();
                }
                case 2 -> {
                    System.out.println("============================= Select a student by ID ===========================");
                    int id = 0;
                    System.out.print("Enter student ID to search : ");
                    id = input.nextInt();
                    SelectStudentById.selectStudentById(id);


                }
                case 3 -> {
                    System.out.println("============================= Select student by name ==========================");
                   String name;
                    System.out.print("Enter student name to search : ");
                    input.nextLine();
                    name = input.nextLine();
                    SelectStudentByName.SelectRecordByName(name);
                }
                case 4 -> {
                    System.out.println("============================== Insert a student ==============================");
                    InsertStudent.inputStudent();
                }
                case 5 -> {
                    System.out.println("============================= Update a student by ID =========================");
                    int id;
                    System.out.print("Enter student ID to update : ");
                    id = input.nextInt();
                    UpdateStudentById.update();
                }
                case 6 -> {
                    int deletedStudent;
                    System.out.println("Enter student ID to delete : ");
                    deletedStudent = input.nextInt();
                    DeleteStudentById.deleteStudentById(deletedStudent);
                }
            }
        pressAnyKey();
        }while (option != 7) ;
    }
}
