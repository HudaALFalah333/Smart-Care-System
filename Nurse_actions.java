package smartCare;

import java.util.Scanner;

public class Nurse_actions {
    private Scanner input;
    private System_Smart_Care system;
    private Input_Helper helper;

    public Nurse_actions() {
    }

    public Nurse_actions(Scanner input, System_Smart_Care system, Input_Helper helper) {
        this.input = input;
        this.system = system;
        this.helper = helper;
    }

    public boolean verify_nurse_access() {
        System.out.println("\n****************************************");
        System.out.println("            NURSE LOGIN");
        System.out.println("****************************************");
        System.out.print("Enter nurse id: ");
        int id = helper.read_int();

        Nurse nurse = system.getPerson_manager().search_id_nurse(id);

        if (nurse == null) {
            System.out.println("\n****************************************");
            System.out.println("   Access denied. Nurse not found.");
            System.out.println("****************************************");
            return false;
        }

        System.out.println("\n****************************************");
        System.out.println("Welcome Nurse: " + nurse.getName());
        System.out.println("****************************************");
        return true;
    }

    public void nurse_menu() {
        int choice;

        do {
            System.out.println("\n****************************************");
            System.out.println("              NURSE MENU");
            System.out.println("****************************************");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patient History");
            System.out.println("3. View Required Procedures");
            System.out.println("4. Mark Procedure As Done");
            System.out.println("5. Back");
            System.out.println("****************************************");
            System.out.print("Enter your choice: ");

            choice = helper.read_int();

            switch (choice) {
                case 1:
                    register_patient_from_input();
                    break;
                case 2:
                    view_patient_history_from_input();
                    break;
                case 3:
                    view_required_procedures_from_input();
                    break;
                case 4:
                    mark_procedure_done_from_input();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\n****************************************");
                    System.out.println("           Invalid choice.");
                    System.out.println("****************************************");
            }

        } while (choice != 5);
    }

    public void register_patient_from_input() {
        int id = helper.read_unique_int("Enter patient id: ", helper.getUsedPersonIds());

        System.out.print("Enter patient name: ");
        String name = input.nextLine();

        String phone = helper.read_unique_text("Enter phone number: ", helper.getUsedPhones());

        System.out.print("Enter address: ");
        String address = input.nextLine();
        ResidencyInfo residencyInfo = helper.create_residency_info();

        System.out.print("Enter medical history: ");
        String medicalHistory = input.nextLine();

        System.out.print("Enter patient condition: ");
        String patientCondition = input.nextLine();

        Patient patient = new Patient(id, name, phone, address, residencyInfo, medicalHistory, patientCondition);
        register_patient(system.getPerson_manager(), patient);
    }

    public void view_patient_history_from_input() {
        System.out.print("Enter patient id: ");
        int patientId = helper.read_int();

        Patient patient = system.getPerson_manager().search_id_patient(patientId);
        view_patient_history(patient);
    }

    public void view_required_procedures_from_input() {
        System.out.print("Enter admission id: ");
        int admissionId = helper.read_int();

        Admission admission = system.getAdmission_manager().search_id_admission(admissionId);
        view_required_procedures(admission);
    }

    public void mark_procedure_done_from_input() {
        System.out.print("Enter admission id: ");
        int admissionId = helper.read_int();

        Admission admission = system.getAdmission_manager().search_id_admission(admissionId);

        if (admission == null) {
            System.out.println("Admission not found.");
            return;
        }

        System.out.print("Enter procedure id: ");
        int procedureId = helper.read_int();

        Madical_Procedure selectedProcedure = null;

        for (int i = 0; i < admission.getProcedures().size(); i++) {
            if (admission.getProcedures().get(i).getProcedure_id() == procedureId) {
                selectedProcedure = admission.getProcedures().get(i);
                break;
            }
        }

        if (selectedProcedure == null) {
            System.out.println("Procedure not found.");
            return;
        }

        mark_procedure_as_done(selectedProcedure);
    }

    public void register_patient(Person_Service person_manager, Patient patient) {
        if (person_manager != null && patient != null) {
            person_manager.add_patients(patient);
        } else {
            System.out.println("Patient registration failed.");
        }
    }

    public void view_patient_history(Patient patient) {
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        patient.print_detalis();
        system.getAdmission_manager().print_patient_admission_history(patient.getId());
    }

    public void view_required_procedures(Admission admission) {
        if (admission != null) {
            for (int i = 0; i < admission.getProcedures().size(); i++) {
                System.out.println("Procedure " + (i + 1));
                admission.getProcedures().get(i).print_detalis();
            }
        } else {
            System.out.println("Admission not found.");
        }
    }

    public void mark_procedure_as_done(Madical_Procedure procedure) {
        if (procedure != null) {
            procedure.mark_as_done();
        } else {
            System.out.println("Medical procedure not found.");
        }
    }
}
