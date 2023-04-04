package operation;

import database.jdbcImplement;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        jdbcImplement jdbc = new jdbcImplement();
        int option;
        do {
            System.out.println(">>> ");
            System.out.println("1. Select all students");
            System.out.println("2. Select a student by ID");
            System.out.println("3. Select a student by name");
            System.out.println("4. Insert a student");
            System.out.println("5. Update a student by ID");
            System.out.println("6. Delete a student by ID");
            System.out.println("7. Exit the program..!");
            System.out.print(">>> Choose your option : ");
            option = input.nextInt();
            switch (option) {
                case 1 -> {
                    System.out.println("================ All Records ==============");
                    selectAllStudents()
                }
                case 2 -> {
                    System.out.println("================ Select a record by ID ===============");

                }
                case 3 -> {
                    System.out.println("================= Select records by name");


                }
                case 4 -> {
                    System.out.println("================ Insert a record ================");

                }
                case 5 -> {

                }
                case 6 -> {
                }
            }

        }while (option != 7) ;
    }
}
