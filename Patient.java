package smartCare;

public class Patient extends Person {
	private String medical_history;
	private String patient_condition;
	
	public Patient(int id, String name, String phone_number, String address, ResidencyInfo residencyInfo,
			String medical_history, String patient_condition) {
		super(id, name, phone_number, address, residencyInfo);
		this.medical_history = medical_history;
		this.patient_condition = patient_condition;
	}
	
	@Override
	public void print_detalis() {
		super.print_detalis();
		System.out.println("Medical History: " + medical_history);
		System.out.println("Patient Condition: " + patient_condition);
	}
	
	public String getMedical_history() {
		return medical_history;
	}

	public void setMedical_history(String medical_history) {
		this.medical_history = medical_history;
	}

	public String getPatient_condition() {
		return patient_condition;
	}

	public void setPatient_condition(String patient_condition) {
		this.patient_condition = patient_condition;
	}
	
}
