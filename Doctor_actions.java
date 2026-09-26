package smartCare;

import java.util.Scanner;

public class Doctor_actions {
    private Scanner input;
    private System_Smart_Care system;
    private Input_Helper helper;

    public Doctor_actions() {
    }

    public Doctor_actions(Scanner input, System_Smart_Care system, Input_Helper helper) {
        this.input = input;
        this.system = system;
        this.helper = helper;
    }

    public boolean verify_doctor_access() {
        System.out.println("\n****************************************");
        System.out.println("           DOCTOR LOGIN");
        System.out.println("****************************************");
        System.out.print("Enter doctor id: ");
        int id = helper.read_int();

        Doctor doctor = system.getPerson_manager().search_id_doctor(id);

        if (doctor == null) {
            System.out.println("\n****************************************");
            System.out.println("  Access denied. Doctor not found.");
            System.out.println("****************************************");
            return false;
        }

        System.out.println("\n****************************************");
        System.out.println("Welcome Dr. " + doctor.getName());
        System.out.println("****************************************");
        return true;
    }

    public void doctor_menu() {
        int choice;

        do {
            System.out.println("\n****************************************");
            System.out.println("             DOCTOR MENU");
            System.out.println("****************************************");
            System.out.println("1. Admit Patient");
            System.out.println("2. Discharge Patient");
            System.out.println("3. Insert Required Procedure");
            System.out.println("4. View Patient History");
            System.out.println("5. Extend Admission");
            System.out.println("6. Back");
            System.out.println("****************************************");
            System.out.print("Enter your choice: ");

            choice = helper.read_int();

            switch (choice) {
                case 1:
                    admit_patient_from_input();
                    break;
                case 2:
                    discharge_patient_from_input();
                    break;
                case 3:
                    insert_procedure_from_input();
                    break;
                case 4:
                    view_patient_history_from_input();
                    break;
                case 5:
                    extend_admission_from_input();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\n****************************************");
                    System.out.println("           Invalid choice.");
                    System.out.println("****************************************");
            }

        } while (choice != 6);
    }

    public void admit_patient_from_input() {
        int admissionId = helper.read_unique_int("Enter admission id: ", helper.getUsedAdmissionIds());

        System.out.print("Enter patient id: ");
        int patientId = helper.read_int();

        Patient patient = system.getPerson_manager().search_id_patient(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        if (system.getAdmission_manager().has_active_admission(patientId)) {
            System.out.println("Patient already has an active admission.");
            return;
        }

        System.out.print("Enter doctor id: ");
        int doctorId = helper.read_int();

        Doctor doctor = system.getPerson_manager().search_id_doctor(doctorId);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.print("Enter section id: ");
        int sectionId = helper.read_int();

        Section section = system.getSection_manager().search_id_section(sectionId);

        if (section == null) {
            System.out.println("Section not found.");
            return;
        }

        System.out.print("Enter room number: ");
        int roomNumber = helper.read_int();

        Room selectedRoom = null;

        for (int i = 0; i < section.getRooms().size(); i++) {
            if (section.getRooms().get(i).getNumber_room() == roomNumber) {
                selectedRoom = section.getRooms().get(i);
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Room not found in this section.");
            return;
        }

        if (!selectedRoom.has_available_bed()) {
            System.out.println("No available beds in this room.");
            return;
        }

        System.out.print("Enter start date: ");
        String startDate = input.nextLine();

        System.out.print("Enter end date: ");
        String endDate = input.nextLine();

        selectedRoom.assign_bed();

        Admission admission = new Admission(admissionId, patient, doctor, selectedRoom, startDate, endDate);
        admit_patient(system.getAdmission_manager(), admission);
    }

    public void discharge_patient_from_input() {
        System.out.print("Enter admission id: ");
        int admissionId = helper.read_int();
        discharge_patient(system.getAdmission_manager(), admissionId);
    }

    public void insert_procedure_from_input() {
        System.out.print("Enter admission id: ");
        int admissionId = helper.read_int();

        Admission admission = system.getAdmission_manager().search_id_admission(admissionId);

        if (admission == null) {
            System.out.println("Admission not found.");
            return;
        }

        if (!admission.isActive()) {
            System.out.println("Cannot add procedure. Patient is discharged.");
            return;
        }

        int procedureId = helper.read_unique_int("Enter procedure id: ", helper.getUsedProcedureIds());

        System.out.print("Enter procedure name: ");
        String procedureName = input.nextLine();

        System.out.println("\n****************************************");
        System.out.println("        CHOOSE PROCEDURE TYPE");
        System.out.println("****************************************");
        System.out.println("1. Medication");
        System.out.println("2. Lab Test");
        System.out.println("3. Radiology");
        System.out.println("4. Monitoring Measurement");
        System.out.println("****************************************");
        System.out.print("Choose procedure type: ");

        int type = helper.read_int();
        Madical_Procedure procedure = null;

        switch (type) {
            case 1:
                procedure = new Medication(procedureId, procedureName);
                break;
            case 2:
                procedure = new Lab_Test(procedureId, procedureName);
                break;
            case 3:
                procedure = new Radiology(procedureId, procedureName);
                break;
            case 4:
                procedure = new Monitoring_Measurement(procedureId, procedureName);
                break;
            default:
                System.out.println("Invalid procedure type.");
                return;
        }

        insert_required_procedure(system.getAdmission_manager(), admissionId, procedure);
    }

    public void view_patient_history_from_input() {
        System.out.print("Enter patient id: ");
        int patientId = helper.read_int();

        Patient patient = system.getPerson_manager().search_id_patient(patientId);
        view_patient_history(patient);
    }

    public void extend_admission_from_input() {
        System.out.print("Enter admission id: ");
        int admissionId = helper.read_int();

        System.out.print("Enter new end date: ");
        String newEndDate = input.nextLine();

        extend_admission(system.getAdmission_manager(), admissionId, newEndDate);
    }

    public void admit_patient(Admission_Service admission_manager, Admission admission) {
        if (admission_manager != null && admission != null) {
            admission_manager.add_admission(admission);
        } else {
            System.out.println("Patient admission failed.");
        }
    }

    public void discharge_patient(Admission_Service admission_manager, int admission_id) {
        if (admission_manager != null) {
            admission_manager.discharge_patient(admission_id);
        } else {
            System.out.println("Admission manager can't be found.");
        }
    }

    public void insert_required_procedure(Admission_Service admission_manager, int admission_id, Madical_Procedure procedure) {
        if (admission_manager != null && procedure != null) {
            admission_manager.add_procedure_to_admission(admission_id, procedure);
        } else {
            System.out.println("Adding medical procedure failed.");
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

    public void extend_admission(Admission_Service admission_manager, int admission_id, String new_end_date) {
        if (admission_manager == null) {
            System.out.println("Admission manager can't be found.");
            return;
        }

        Admission admission = admission_manager.search_id_admission(admission_id);

        if (admission == null) {
            System.out.println("Admission not found.");
            return;
        }

        admission.extend_admission(new_end_date);
    }

}
