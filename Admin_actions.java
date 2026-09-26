package smartCare;

import java.util.Scanner;

public class Admin_actions {
    private Scanner input;
    private System_Smart_Care system;
    private Input_Helper helper;

    public Admin_actions() {
    }

    public Admin_actions(Scanner input, System_Smart_Care system, Input_Helper helper) {
        this.input = input;
        this.system = system;
        this.helper = helper;
    }

    public boolean verify_admin_access() {
        Person_Manager personManager = (Person_Manager) system.getPerson_manager();

        if (personManager.getAdminCount() == 0) {
            System.out.println("\n****************************************");
            System.out.println("     Initial setup: no admin found.");
            System.out.println("****************************************");
            return true;
        }

        System.out.println("\n****************************************");
        System.out.println("            ADMIN LOGIN");
        System.out.println("****************************************");
        System.out.print("Enter admin id: ");
        int id = helper.read_int();

        Admin admin = personManager.search_id_admin(id);

        if (admin == null) {
            System.out.println("\n****************************************");
            System.out.println("   Access denied. Admin not found.");
            System.out.println("****************************************");
            return false;
        }

        System.out.println("\n****************************************");
        System.out.println("Welcome Admin: " + admin.getName());
        System.out.println("****************************************");
        return true;
    }

    public void admin_menu() {
        Person_Manager personManager = (Person_Manager) system.getPerson_manager();

        if (personManager.getAdminCount() == 0) {
            initial_admin_setup();
            return;
        }

        int choice;

        do {
            System.out.println("\n****************************************");
            System.out.println("              ADMIN MENU");
            System.out.println("****************************************");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Nurse");
            System.out.println("3. Add Admin");
            System.out.println("4. Add Section");
            System.out.println("5. Add Room to Section");
            System.out.println("6. Generate Report");
            System.out.println("7. Back");
            System.out.println("****************************************");
            System.out.print("Enter your choice: ");

            choice = helper.read_int();

            switch (choice) {
                case 1:
                    add_doctor_from_input();
                    break;
                case 2:
                    add_nurse_from_input();
                    break;
                case 3:
                    add_admin_from_input();
                    break;
                case 4:
                    add_section_from_input();
                    break;
                case 5:
                    add_room_to_section_from_input();
                    break;
                case 6:
                    generate_report_from_input();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("\n****************************************");
                    System.out.println("           Invalid choice.");
                    System.out.println("****************************************");
            }

        } while (choice != 7);
    }

    private void initial_admin_setup() {
        int choice;

        do {
            System.out.println("\n****************************************");
            System.out.println("        INITIAL ADMIN SETUP");
            System.out.println("****************************************");
            System.out.println("Please create the first admin account.");
            System.out.println("1. Add Admin");
            System.out.println("2. Back");
            System.out.println("****************************************");
            System.out.print("Enter your choice: ");

            choice = helper.read_int();

            switch (choice) {
                case 1:
                    add_admin_from_input();
                    if (((Person_Manager) system.getPerson_manager()).getAdminCount() > 0) {
                        System.out.println("\n****************************************");
                        System.out.println("First admin created successfully.");
                        System.out.println("Please open Admin Menu again and login with your admin id.");
                        System.out.println("****************************************");
                        return;
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("\n****************************************");
                    System.out.println("           Invalid choice.");
                    System.out.println("****************************************");
            }

        } while (choice != 2);
    }

    public void add_doctor_from_input() {
        int id = helper.read_unique_int("Enter doctor id: ", helper.getUsedPersonIds());

        System.out.print("Enter doctor name: ");
        String name = input.nextLine();

        String phone = helper.read_unique_text("Enter phone number: ", helper.getUsedPhones());
        System.out.print("Enter address: ");
        String address = input.nextLine();
        ResidencyInfo residencyInfo = helper.create_residency_info();

        Doctor doctor = new Doctor(id, name, phone, address, residencyInfo);
        add_doctor(system.getPerson_manager(), doctor);
    }

    public void add_nurse_from_input() {
        int id = helper.read_unique_int("Enter nurse id: ", helper.getUsedPersonIds());

        System.out.print("Enter nurse name: ");
        String name = input.nextLine();

        String phone = helper.read_unique_text("Enter phone number: ", helper.getUsedPhones());
        System.out.print("Enter address: ");
        String address = input.nextLine();
        ResidencyInfo residencyInfo = helper.create_residency_info();

        Nurse nurse = new Nurse(id, name, phone, address, residencyInfo);
        add_nurse(system.getPerson_manager(), nurse);
    }

    public void add_admin_from_input() {
        int id = helper.read_unique_int("Enter admin id: ", helper.getUsedPersonIds());

        System.out.print("Enter admin name: ");
        String name = input.nextLine();

        String phone = helper.read_unique_text("Enter phone number: ", helper.getUsedPhones());
        System.out.print("Enter address: ");
        String address = input.nextLine();
        ResidencyInfo residencyInfo = helper.create_residency_info();

        Admin admin = new Admin(id, name, phone, address, residencyInfo);
        add_admin(system.getPerson_manager(), admin);
    }

    public void add_section_from_input() {
        int sectionId = helper.read_unique_int("Enter section id: ", helper.getUsedSectionIds());

        System.out.print("Enter section name: ");
        String sectionName = input.nextLine();

        Section section = new Section(sectionId, sectionName);
        add_section(system.getSection_manager(), section);
    }

    public void add_room_to_section_from_input() {
        System.out.print("Enter section id: ");
        int sectionId = helper.read_int();

        Section section = system.getSection_manager().search_id_section(sectionId);

        if (section == null) {
            System.out.println("Section not found.");
            return;
        }

        System.out.print("Enter room number: ");
        int roomNumber = helper.read_int();

        for (Room room : section.getRooms()) {
            if (room.getNumber_room() == roomNumber) {
                System.out.println("This room number already exists in this section.");
                return;
            }
        }
        System.out.println("\n****************************************");
        System.out.println("            CHOOSE ROOM TYPE");
        System.out.println("****************************************");
        System.out.println("1. Private");
        System.out.println("2. Shared 2");
        System.out.println("3. Shared 4");
        System.out.println("****************************************");
        System.out.print("Choose room type: ");

        int type = helper.read_int();

        String roomType = "";
        int capacity = 0;

        switch (type) {
            case 1:
                roomType = "Private";
                capacity = 1;
                break;

            case 2:
                roomType = "Shared 2";
                capacity = 2;
                break;

            case 3:
                roomType = "Shared 4";
                capacity = 4;
                break;

            default:
                System.out.println("Invalid room type.");
                return;
        }

        Room room = new Room(roomNumber, roomType, capacity);
        add_room(section, room);
    }

    public void generate_report_from_input() {
        System.out.println("\n****************************************");
        System.out.println("          CHOOSE REPORT TYPE");
        System.out.println("****************************************");
        System.out.println("1. Patients Report");
        System.out.println("2. Rooms Report");
        System.out.println("3. Sections Report");
        System.out.println("4. Procedures Report");
        System.out.println("****************************************");
        System.out.print("Choose report type: ");
        int type = helper.read_int();

        String title = "";
        String summary = "";
        String content = "";

        switch (type) {
            case 1:
                title = "Patients Statistical Report";
                summary = "Report showing all registered patients";
                content = system.getReport_manager().generate_patient_report(system.getPerson_manager());
                break;
            case 2:
                title = "Rooms Statistical Report";
                summary = "Report showing room status and bed availability";
                content = system.getReport_manager().generate_room_report(system.getSection_manager());
                break;
            case 3:
                title = "Sections Statistical Report";
                summary = "Report showing hospital sections";
                content = system.getReport_manager().generate_section_report(system.getSection_manager());
                break;
            case 4:
                title = "Procedures Statistical Report";
                summary = "Report showing medical procedures status";
                content = system.getReport_manager().generate_procedure_report(system.getAdmission_manager());
                break;
            default:
                System.out.println("Invalid report type.");
                return;
        }

        System.out.print("Enter report date: ");
        String date = input.nextLine();

        System.out.print("Enter admin name: ");
        String adminName = input.nextLine();

        Reports report = new Reports(title, summary, content, date, adminName);
        generate_report(system.getReport_manager(), report);

        System.out.print("Export to text? yes/no: ");
        if (input.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Enter file name: ");
            File_Storage.getInstance().export_report(report, "text", input.nextLine());
        }

        System.out.print("Export to XML? yes/no: ");
        if (input.nextLine().equalsIgnoreCase("yes")) {
            System.out.print("Enter file name: ");
            File_Storage.getInstance().export_report(report, "xml", input.nextLine());
        }
    }

    public void add_doctor(Person_Service person_manager, Doctor doctor) {
        if (person_manager != null) {
            person_manager.add_doctor(doctor);
        } else {
            System.out.println("Person manager can't be found.");
        }
    }

    public void add_nurse(Person_Service person_manager, Nurse nurse) {
        if (person_manager != null) {
            person_manager.add_nurses(nurse);
        } else {
            System.out.println("Person manager can't be found.");
        }
    }

    public void add_admin(Person_Service person_manager, Admin admin) {
        if (person_manager != null) {
            person_manager.add_admins(admin);
        } else {
            System.out.println("Person manager can't be found.");
        }
    }

    public void add_section(Section_Service section_manager, Section section) {
        if (section_manager != null) {
            section_manager.add_section(section);
        } else {
            System.out.println("Section manager can't be found.");
        }
    }

    public void add_room(Section section, Room room) {
        if (section != null && room != null) {
            section.add_room(room);
            System.out.println("Room added successfully.");
        } else {
            System.out.println("Room can't be added.");
        }
    }

    public void generate_report(Report_Service report_manager, Reports report) {
        if (report_manager != null && report != null) {
            report_manager.add_report(report);
            report.print_detalis();
        } else {
            System.out.println("Report generation failed.");
        }
    }
}
