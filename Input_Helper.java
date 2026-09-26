package smartCare;

import java.util.HashSet;
import java.util.Scanner;

public class Input_Helper {
    private Scanner input;

    private HashSet<Integer> usedPersonIds = new HashSet<>();
    private HashSet<Integer> usedSectionIds = new HashSet<>();
    private HashSet<Integer> usedAdmissionIds = new HashSet<>();
    private HashSet<Integer> usedProcedureIds = new HashSet<>();

    private HashSet<String> usedPhones = new HashSet<>();
    private HashSet<String> usedAddresses = new HashSet<>();
    private HashSet<String> usedNationalNumbers = new HashSet<>();
    private HashSet<String> usedIdCards = new HashSet<>();
    private HashSet<String> usedResidentialNumbers = new HashSet<>();

    public Input_Helper(Scanner input) {
        this.input = input;
    }

    public int read_int() {
        while (!input.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            input.nextLine();
        }

        int number = input.nextInt();
        input.nextLine();
        return number;
    }

    public int read_unique_int(String message, HashSet<Integer> usedSet) {
        int value;

        while (true) {
            System.out.print(message);
            value = read_int();

            if (!usedSet.contains(value)) {
                usedSet.add(value);
                return value;
            }

            System.out.println("This value already exists. Please enter another one.");
        }
    }

    public String read_unique_text(String message, HashSet<String> usedSet) {
        String value;

        while (true) {
            System.out.print(message);
            value = input.nextLine();

            if (!usedSet.contains(value)) {
                usedSet.add(value);
                return value;
            }

            System.out.println("This value already exists. Please enter another one.");
        }
    }

    public ResidencyInfo create_residency_info() {
        int type;

        do {
            System.out.println("\n****************************************");
            System.out.println("        CHOOSE RESIDENCY TYPE");
            System.out.println("****************************************");
            System.out.println("1. Jordanian");
            System.out.println("2. Non-Jordanian");
            System.out.println("****************************************");
            System.out.print("Choose residency type: ");
            type = read_int();
        } while (type != 1 && type != 2);

        if (type == 1) {
            String nationalNumber = read_unique_text("Enter national number: ", usedNationalNumbers);
            String idCardNumber = read_unique_text("Enter ID card number: ", usedIdCards);

            return new Jordanian_Resident(nationalNumber, idCardNumber);
        } else {
            String residentialNumber = read_unique_text("Enter residential number: ", usedResidentialNumbers);

            System.out.print("Enter nationality: ");
            String nationality = input.nextLine();

            return new Non_Jordanian_Resident(residentialNumber, nationality);
        }
    }

    public HashSet<Integer> getUsedPersonIds() {
        return usedPersonIds;
    }

    public HashSet<Integer> getUsedSectionIds() {
        return usedSectionIds;
    }

    public HashSet<Integer> getUsedAdmissionIds() {
        return usedAdmissionIds;
    }

    public HashSet<Integer> getUsedProcedureIds() {
        return usedProcedureIds;
    }

    public HashSet<String> getUsedPhones() {
        return usedPhones;
    }

    public HashSet<String> getUsedAddresses() {
        return usedAddresses;
    }
}
