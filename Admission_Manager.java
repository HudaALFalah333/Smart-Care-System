package smartCare;
import java.util.ArrayList;


public class Admission_Manager implements Admission_Service{
	private ArrayList<Admission> admissions;

    public Admission_Manager() {
        this.admissions = new ArrayList<>();
    }
    @Override
    public void add_admission(Admission admission) {
        if (admission != null) {
            admissions.add(admission);
            System.out.println("Admission added successfully.");
        }
        else {
            System.out.println("Admission can't be null.");
        }
    }
    @Override
    public Admission search_id_admission(int id) {
        for (int i = 0; i < admissions.size(); i++) {
            if (admissions.get(i).getAdmission_id() == id) {
                return admissions.get(i);
            }
        }
        return null;
    }
    @Override
    public void discharge_patient(int admission_id) {

        Admission admission = search_id_admission(admission_id);

        if (admission == null) {
            System.out.println("Admission not found.");
        }
        else {
            admission.discharge_patient();
        }
    }
    @Override
    public void add_procedure_to_admission(int admission_id, Madical_Procedure procedure) {

        Admission admission = search_id_admission(admission_id);

        if (admission == null) {
            System.out.println("Admission not found.");
        }
        else if (procedure == null) {
            System.out.println("Medical procedure can't be null.");
        }
        else {
            admission.add_procedures(procedure);

            System.out.println("Medical procedure "
                    + procedure.getProcedure_name()
                    + " added successfully.");
        }
    }
    @Override
    public void print_all_admissions() {
        for (int i = 0; i < admissions.size(); i++) {
            admissions.get(i).print_detalis();
        }
    }

    public ArrayList<Admission> getAdmissions() {
        return admissions;
    }

    public void setAdmissions(ArrayList<Admission> admissions) {
        this.admissions = admissions;
    }

    @Override
    public void print_patient_admission_history(int patient_id) {
        boolean found = false;

        for (int i = 0; i < admissions.size(); i++) {
            Admission admission = admissions.get(i);

            if (admission.getPatient().getId() == patient_id) {
                System.out.println("Admission Record " + (i + 1));
                admission.print_detalis();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No admissions found for this patient.");
        }
    }

    @Override
    public boolean has_active_admission(int patient_id) {
        for (int i = 0; i < admissions.size(); i++) {
            Admission admission = admissions.get(i);

            if (admission.isActive() && admission.getPatient().getId() == patient_id) {
                return true;
            }
        }

        return false;
    }
}
