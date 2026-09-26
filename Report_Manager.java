package smartCare;

import java.util.ArrayList;

public class Report_Manager  implements Report_Service{
    private ArrayList<Reports> reports;

    public Report_Manager() {
        this.reports = new ArrayList<>();
    }
    @Override
    public void add_report(Reports report) {
        if (report != null) {
            reports.add(report);
            System.out.println("The report is added successfully.");
        } else {
            System.out.println("Report can't be null.");
        }
    }
    @Override
    public Reports search_report(String title) {
        for (int i = 0; i < reports.size(); i++) {
            if (reports.get(i).getTitle().equalsIgnoreCase(title)) {
                return reports.get(i);
            }
        }
        return null;
    }
    @Override
    public void print_all_reports() {
        for (int i = 0; i < reports.size(); i++) {
            reports.get(i).print_detalis();
        }
    }

    public ArrayList<Reports> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Reports> reports) {
        this.reports = reports;
    }

    @Override
    public String generate_patient_report(Person_Service person_manager) {
        Person_Manager manager = (Person_Manager) person_manager;
        ArrayList<Patient> patients = manager.getPatients();
        String content = "Total Patients: " + patients.size() + "\n";

        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            content += "Patient ID: " + patient.getId()
                    + ", Name: " + patient.getName()
                    + ", Condition: " + patient.getPatient_condition()
                    + ", Residency: " + patient.getResidencyInfo().getResidency_Type()
                    + "\n";
        }

        return content;
    }

    @Override
    public String generate_room_report(Section_Service section_manager) {
        Section_Manager manager = (Section_Manager) section_manager;
        ArrayList<Section> sections = manager.getSections();
        int totalRooms = 0;
        int totalBeds = 0;
        int availableBeds = 0;
        String content = "";

        for (int i = 0; i < sections.size(); i++) {
            Section section = sections.get(i);
            ArrayList<Room> rooms = section.getRooms();

            for (int j = 0; j < rooms.size(); j++) {
                Room room = rooms.get(j);
                totalRooms++;
                totalBeds += room.getCapacity();
                availableBeds += room.getAvailable_beds();

                content += "Section: " + section.getSection_name()
                        + ", Room: " + room.getNumber_room()
                        + ", Type: " + room.getType_room()
                        + ", Capacity: " + room.getCapacity()
                        + ", Available Beds: " + room.getAvailable_beds()
                        + "\n";
            }
        }

        return "Total Rooms: " + totalRooms
                + "\nTotal Beds: " + totalBeds
                + "\nAvailable Beds: " + availableBeds
                + "\nOccupied Beds: " + (totalBeds - availableBeds)
                + "\n" + content;
    }

    @Override
    public String generate_section_report(Section_Service section_manager) {
        Section_Manager manager = (Section_Manager) section_manager;
        ArrayList<Section> sections = manager.getSections();
        String content = "Total Sections: " + sections.size() + "\n";

        for (int i = 0; i < sections.size(); i++) {
            Section section = sections.get(i);
            content += "Section ID: " + section.getSection_id()
                    + ", Name: " + section.getSection_name()
                    + ", Rooms Count: " + section.getRooms().size()
                    + "\n";
        }

        return content;
    }

    @Override
    public String generate_procedure_report(Admission_Service admission_manager) {
        Admission_Manager manager = (Admission_Manager) admission_manager;
        ArrayList<Admission> admissions = manager.getAdmissions();
        int totalProcedures = 0;
        int pendingProcedures = 0;
        int doneProcedures = 0;
        String content = "";

        for (int i = 0; i < admissions.size(); i++) {
            Admission admission = admissions.get(i);
            ArrayList<Madical_Procedure> procedures = admission.getProcedures();

            for (int j = 0; j < procedures.size(); j++) {
                Madical_Procedure procedure = procedures.get(j);
                totalProcedures++;

                if (procedure.getStatus().equalsIgnoreCase("Done")) {
                    doneProcedures++;
                } else {
                    pendingProcedures++;
                }

                content += "Admission ID: " + admission.getAdmission_id()
                        + ", Procedure ID: " + procedure.getProcedure_id()
                        + ", Name: " + procedure.getProcedure_name()
                        + ", Type: " + procedure.getProcedure_type()
                        + ", Status: " + procedure.getStatus()
                        + "\n";
            }
        }

        return "Total Procedures: " + totalProcedures
                + "\nPending Procedures: " + pendingProcedures
                + "\nDone Procedures: " + doneProcedures
                + "\n" + content;
    }
}
