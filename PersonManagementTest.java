package smartCare;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonManagementTest {

    @Test
    void testAddDoctor() {
        Person_Manager personManager = new Person_Manager();

        ResidencyInfo residency = new Jordanian_Resident("123", "123");
        Doctor doctor = new Doctor(1, "Huda", "077", "Amman", residency);

        personManager.add_doctor(doctor);

        assertNotNull(personManager.search_id_doctor(1));
    }

    @Test
    void testSearchDoctorNotFound() {
        Person_Manager personManager = new Person_Manager();

        assertNull(personManager.search_id_doctor(999));
    }

    @Test
    void testAddPatient() {
        Person_Manager personManager = new Person_Manager();

        ResidencyInfo residency = new Jordanian_Resident("123", "123");
        Patient patient = new Patient(2, "Ali", "078", "Amman", residency, "No history", "stomach ulcer");

        personManager.add_patients(patient);

        assertNotNull(personManager.search_id_patient(2));
    }

}
