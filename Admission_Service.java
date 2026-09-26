
package smartCare;

public interface Admission_Service {
    void add_admission(Admission admission);
    void discharge_patient(int admission_id);
    void add_procedure_to_admission(int admission_id, Madical_Procedure procedure);
    void print_all_admissions();
    Admission search_id_admission(int id);
    void print_patient_admission_history(int patient_id);
    boolean has_active_admission(int patient_id);
}
