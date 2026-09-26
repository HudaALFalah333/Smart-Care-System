package smartCare;
import java.util.ArrayList;

public class Admission {
	private int admission_id;
	private Patient patient;
	private Doctor doctor;
	private Room room;
	private String start_date;
	private String end_date;
	private boolean active;
	private ArrayList<Madical_Procedure> procedures;

	public Admission(int admission_id, Patient patient, Doctor doctor, Room room,
            String start_date, String end_date) {

		this.admission_id = admission_id;
		this.patient = patient;
		this.doctor = doctor;
		this.room = room;
		this.start_date = start_date;
		this.end_date = end_date;
		this.active = true;
		this.procedures = new ArrayList<>();
	}
	public void add_procedures(Madical_Procedure procedure) {
		procedures.add(procedure);
	}
	
	 public void discharge_patient() {
	        if (active == true) {
	            active = false;
	            room.release_bed();
	            System.out.println("The patient discharged is successfully.");
	        } else {
	            System.out.println("The patient is already discharged.");
	        }
	    }

	    public void extend_admission(String new_end_date) {
	        if (active == true) {
	            end_date = new_end_date;
	            System.out.println("the admission extended is successfully.");
	        } else {
	            System.out.println("This can't extend. The patient is discharged.");
	        }
	    }

	    public void print_detalis() {
	        System.out.println("Admission ID: " + admission_id);
	        System.out.println("Patient Name: " + patient.getName());
	        System.out.println("Doctor Name: " + doctor.getName());
	        System.out.println("Room Number: " + room.getNumber_room());
	        System.out.println("Start Date: " + start_date);
	        System.out.println("End Date: " + end_date);
	        System.out.println("Active: " + active);

	        for (int i = 0; i < procedures.size(); i++) {
	            System.out.println("Procedure " + (i + 1));
	            procedures.get(i).print_detalis();
	        }
	    }

		public int getAdmission_id() {
			return admission_id;
		}

		public void setAdmission_id(int admission_id) {
			this.admission_id = admission_id;
		}

		public Patient getPatient() {
			return patient;
		}

		public void setPatient(Patient patient) {
			this.patient = patient;
		}

		public Doctor getDoctor() {
			return doctor;
		}

		public void setDoctor(Doctor doctor) {
			this.doctor = doctor;
		}

		public Room getRoom() {
			return room;
		}

		public void setRoom(Room room) {
			this.room = room;
		}

		public String getStart_date() {
			return start_date;
		}

		public void setStart_date(String start_date) {
			this.start_date = start_date;
		}

		public String getEnd_date() {
			return end_date;
		}

		public void setEnd_date(String end_date) {
			this.end_date = end_date;
		}

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public ArrayList<Madical_Procedure> getProcedures() {
			return procedures;
		}

		public void setProcedures(ArrayList<Madical_Procedure> procedures) {
			this.procedures = procedures;
		}
	    
}
