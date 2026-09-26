package smartCare;

public interface Person_Service {
	void add_doctor(Doctor doctor);
    void add_patients(Patient patient);
    void add_nurses(Nurse nurse);
    void add_admins(Admin admin);
    Patient search_id_patient(int id);
    Doctor search_id_doctor(int id);
    Nurse search_id_nurse(int id);
    Admin search_id_admin(int id);
}
