package smartCare;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SystemOperationsTest {

    @Test
    void testAdminAddDoctorSectionAndRoom() {
        Person_Manager personManager = new Person_Manager();
        Section_Manager sectionManager = new Section_Manager();

        ResidencyInfo residency = new Jordanian_Resident("123", "123");
        Doctor doctor = new Doctor(1, "Huda", "077", "Amman", residency);

        personManager.add_doctor(doctor);

        Section section = new Section(1, "Emergency");
        Room room = new Room(1, "Private", 1);

        sectionManager.add_section(section);
        section.add_room(room);

        assertNotNull(personManager.search_id_doctor(1));
        assertNotNull(sectionManager.search_id_section(1));
        assertEquals(1, section.getRooms().size());
    }

    @Test
    void testDoctorAdmitPatientAndAddProcedure() {
        Admission_Manager admissionManager = new Admission_Manager();

        ResidencyInfo residency = new Jordanian_Resident("123", "123");
        Patient patient = new Patient(1, "Ali", "078", "Amman", residency, "No history", "stomach ulcer");
        Doctor doctor = new Doctor(2, "Huda", "077", "Amman", residency);
        Room room = new Room(1, "Private", 1);

        room.assign_bed();

        Admission admission = new Admission(1, patient, doctor, room, "2026-06-01", "2026-06-05");
        admissionManager.add_admission(admission);

        Madical_Procedure procedure = new Medication(100, "Anti-inflammatory and antistomach medications");
        admissionManager.add_procedure_to_admission(1, procedure);

        assertNotNull(admissionManager.search_id_admission(1));
        assertEquals(1, admission.getProcedures().size());
        assertEquals(0, room.getAvailable_beds());
    }

    @Test
    void testNurseRegisterPatientAndMarkProcedureDone() {
        Person_Manager personManager = new Person_Manager();
        Admission_Manager admissionManager = new Admission_Manager();

        ResidencyInfo residency = new Jordanian_Resident("123", "123");
        Patient patient = new Patient(1, "Ali", "078", "Amman", residency, "No history", "stomach ulcer");
        Doctor doctor = new Doctor(2, "Huda", "077", "Amman", residency);
        Room room = new Room(1, "Private", 1);

        personManager.add_patients(patient);

        room.assign_bed();
        Admission admission = new Admission(1, patient, doctor, room, "2026-06-01", "2026-06-05");
        admissionManager.add_admission(admission);

        Madical_Procedure procedure = new Medication(100, "Anti-inflammatory and antistomach medications");
        admissionManager.add_procedure_to_admission(1, procedure);

        Madical_Procedure procedureFromAdmission = admission.getProcedures().get(0);
        procedureFromAdmission.mark_as_done();

        assertNotNull(personManager.search_id_patient(1));
        assertEquals(1, admission.getProcedures().size());
        assertEquals("Done", procedureFromAdmission.getStatus());
    }

}
