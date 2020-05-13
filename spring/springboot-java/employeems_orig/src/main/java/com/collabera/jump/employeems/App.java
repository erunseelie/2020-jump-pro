package com.collabera.jump.employeems;

import com.collabera.jump.ems.app.EmployeeManagementSystem;
import com.collabera.jump.ems.model.Employee;
import com.collabera.jump.ems.util.ScannerUtil;
import com.collabera.jump.ems.util.ScannerUtil.Result;
import com.collabera.jump.ems.util.ScannerUtil.TYPES;

import java.util.Scanner;

public class App {

    private static boolean exitFlag = true;

    public static void main(String[] args) {

        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        // ScannerUtil scannerUtil = new ScannerUtil();

//		System.out.println("++++++++++++++++++++");
//		System.out.println("+++++++++EMS++++++++");
//		System.out.println("++++++++++++++++++++");

        System.out.println(
                " #####  ####### #       #          #    ######  ####### ######     #    \n" +
                        "#     # #     # #       #         # #   #     # #       #     #   # #   \n" +
                        "#       #     # #       #        #   #  #     # #       #     #  #   #  \n" +
                        "#       #     # #       #       #     # ######  #####   ######  #     # \n" +
                        "#       #     # #       #       ####### #     # #       #   #   ####### \n" +
                        "#     # #     # #       #       #     # #     # #       #    #  #     # \n" +
                        " #####  ####### ####### ####### #     # ######  ####### #     # #     # \n" +
                        "                                                                        \n" +
                        "");

        System.out.println(
                " _       __     __                             __           ________  ________\n" +
                        "| |     / /__  / /________  ____ ___  ___     / /_____     / ____/  |/  / ___/\n" +
                        "| | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\   / __/ __ \\   / __/ / /|_/ /\\__ \\ \n" +
                        "| |/ |/ /  __/ / /__/ /_/ / / / / / /  __/  / /_/ /_/ /  / /___/ /  / /___/ / \n" +
                        "|__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/   \\__/\\____/  /_____/_/  /_//____/  \n" +
                        "                                                                              ");

        do {
            System.out.println("Please choose an option to proceed:");

            System.out.println("1. CREATE");
            System.out.println("2. UPDATE");
            System.out.println("3. DELETE");
            System.out.println("4. SEARCH");
            System.out.println("5. EXIT");

            Employee emp = new Employee();

            Employee emp1 = new Employee();

            if (emp.equals(emp1)) {
                System.out.println("They are same employee");
            }

            Result option = ScannerUtil.retryUntilSucceeds("Your input: ", TYPES.INT, 5);

            switch (option.getValueAsInt()) {
                case 1: {
                    System.out.println("Please choose an option to proceed:");
                    System.out.println("1. EMPLOYEE");
                    System.out.println("2. MANAGER");
                    option = ScannerUtil.retryUntilSucceeds("Your input: ", TYPES.INT, 2);
                    // scanner.nextLine();
                    switch (option.getValueAsInt()) {
                        case 1:
                            ems.createEmployeeWithInputs();
                            break;
                        case 2:
                            System.out.println("Create Manager");
                            ems.createEmployeeWithInputs();
                            ems.createManagerWithInputs();
                            break;
                        default:
                            System.out.println("Invalid Input");
                            break;
                    }

                }
                break;


                // ======================================================================
                // Matthew: complete UPDATE functionality.
                // ======================================================================

                case 2:

                    Scanner stdin = new Scanner(System.in);

                    System.out.println("Enter the employee's ID to be updated:");
                    ems.updateEmployee(Integer.parseInt(stdin.nextLine()));

                    stdin.close();

                    break;

                // ======================================================================

                case 3:
                    System.out.println(3);
                    break;
                case 4:
                    System.out.println(4);
                    break;
                case 5:
                    exitFlag = false;
                    System.out.println("Thanks for using EMS!");
                    break;
                default:
                    break;
            }
        } while (exitFlag);

        ScannerUtil.close();

    }

}
