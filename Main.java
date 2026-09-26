package smartCare;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static System_Smart_Care system = new System_Smart_Care();
    static Input_Helper helper = new Input_Helper(input);

    static Admin_actions adminActions = new Admin_actions(input, system, helper);
    static Doctor_actions doctorActions = new Doctor_actions(input, system, helper);
    static Nurse_actions nurseActions = new Nurse_actions(input, system, helper);

    public static void main(String[] args) {
        int choice;

        System.out.println("****************************************");
        System.out.println("     Welcome to Smart Care System");
        System.out.println("****************************************");

        do {
            System.out.println("\n****************************************");
            System.out.println("           SMART CARE SYSTEM");
            System.out.println("****************************************");
            System.out.println("1. Admin Menu");
            System.out.println("2. Doctor Menu");
            System.out.println("3. Nurse Menu");
            System.out.println("4. Exit");
            System.out.println("****************************************");
            System.out.print("Enter your choice: ");

            choice = helper.read_int();

            switch (choice) {
                case 1:
                    if (adminActions.verify_admin_access()) {
                        adminActions.admin_menu();
                        System.out.println("\n****************************************");
                        System.out.println("        Back to Main Menu");
                        System.out.println("****************************************");
                    }
                    break;
                case 2:
                    if (doctorActions.verify_doctor_access()) {
                        doctorActions.doctor_menu();
                        System.out.println("\n****************************************");
                        System.out.println("        Back to Main Menu");
                        System.out.println("****************************************");
                    }
                    break;
                case 3:
                    if (nurseActions.verify_nurse_access()) {
                        nurseActions.nurse_menu();
                        System.out.println("\n****************************************");
                        System.out.println("        Back to Main Menu");
                        System.out.println("****************************************");
                    }
                    break;
                case 4:
                    System.out.println("\n****************************************");
                    System.out.println("           System closed.");
                    System.out.println("     Thank you for using Smart Care");
                    System.out.println("****************************************");
                    break;
                default:
                    System.out.println("\n****************************************");
                    System.out.println("           Invalid choice.");
                    System.out.println("****************************************");
            }

        } while (choice != 4);
    }
}
