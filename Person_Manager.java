package smartCare;

import java.util.ArrayList;

public class Person_Manager implements Person_Service{
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Admin> admins = new ArrayList<>();
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Nurse> nurses = new ArrayList<>();
    
    @Override
    public Patient search_id_patient(int id) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                return patients.get(i);
            }
        }
        return null;
    }
    @Override
    public Doctor search_id_doctor(int id) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == id) {
                return doctors.get(i);
            }
        }
        return null;
    }
    @Override
    public Nurse search_id_nurse(int id) {
        for (int i = 0; i < nurses.size(); i++) {
            if (nurses.get(i).getId() == id) {
                return nurses.get(i);
            }
        }
        return null;
    }
    @Override
    public Admin search_id_admin(int id) {
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).getId() == id) {
                return admins.get(i);
            }
        }
        return null;
    }
    @Override
    public void add_doctor(Doctor doctor) {
        if (doctor != null) {
            doctors.add(doctor);
            System.out.println("The Dr. " + doctor.getName() + " added successfully.");
        } else {
            System.out.println("The doctor can't be null.");
        }
    }
    @Override
    public void add_patients(Patient patient) {
        if (patient != null) {
            patients.add(patient);
            System.out.println("The patient " + patient.getName() + " added successfully.");
        } else {
            System.out.println("The patient can't be null.");
        }
    }
    @Override
    public void add_nurses(Nurse nurse) {
        if (nurse != null) {
            nurses.add(nurse);
            System.out.println("The nurse " + nurse.getName() + " added successfully.");
        } else {
            System.out.println("The nurse can't be null.");
        }
    }
    @Override
    public void add_admins(Admin admin) {
        if (admin != null) {
            admins.add(admin);
            System.out.println("The admin " + admin.getName() + " added successfully.");
        } else {
            System.out.println("The admin can't be null.");
        }
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }
    public int getAdminCount() {
        return admins.size();
    }
}