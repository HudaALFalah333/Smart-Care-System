package smartCare;

public interface Report_Service {

    void add_report(Reports report);
    void print_all_reports();
    Reports search_report(String title);
    String generate_patient_report(Person_Service person_manager);
    String generate_room_report(Section_Service section_manager);
    String generate_section_report(Section_Service section_manager);
    String generate_procedure_report(Admission_Service admission_manager);

}
