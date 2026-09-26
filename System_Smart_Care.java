package smartCare;

public class System_Smart_Care {
	 private Person_Service person_manager;
	 private Section_Service section_manager;
	 private Admission_Service admission_manager;
	 private Report_Service report_manager;
	public System_Smart_Care() {
		this.person_manager = new Person_Manager();
		this.section_manager = new Section_Manager();
	    this.admission_manager = new Admission_Manager();
	    this.report_manager = new Report_Manager();
	}
	public Person_Service getPerson_manager() {
		return person_manager;
	}
	public void setPerson_manager(Person_Service person_manager) {
		this.person_manager = person_manager;
	}
	public Section_Service getSection_manager() {
		return section_manager;
	}
	public void setSection_manager(Section_Service section_manager) {
		this.section_manager = section_manager;
	}
	public Admission_Service getAdmission_manager() {
		return admission_manager;
	}
	public void setAdmission_manager(Admission_Service admission_manager) {
		this.admission_manager = admission_manager;
	}
	public Report_Service getReport_manager() {
		return report_manager;
	}
	public void setReport_manager(Report_Service report_manager) {
		this.report_manager = report_manager;
	}
	 
	 
}