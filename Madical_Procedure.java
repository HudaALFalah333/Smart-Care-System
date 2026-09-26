package smartCare;

public abstract class Madical_Procedure {
	private int procedure_id;
	private String procedure_name;
	private String status;
	public abstract String getProcedure_type();
	
	public Madical_Procedure(int procedure_id, String procedure_name) {
		this.procedure_id = procedure_id;
		this.procedure_name = procedure_name;
		this.status = "Pending";
	}
	
	public void mark_as_done() {
		if (status.equalsIgnoreCase("Pending")) {
			status = "Done";
			System.out.println("The medical procedure is done.");
		}
		else{
			System.out.println("This medical procedure is already done.");
		}
	}
	public void print_detalis() {
		System.out.println("Procedure Id:" + procedure_id);
		System.out.println("Procedure Name:"+ procedure_name);
		System.out.println("Procedure Type:"+ getProcedure_type());
		System.out.println("Status:"+ status);
	}

	public int getProcedure_id() {
		return procedure_id;
	}

	public void setProcedure_id(int procedure_id) {
		this.procedure_id = procedure_id;
	}

	public String getProcedure_name() {
		return procedure_name;
	}

	public void setProcedure_name(String procedure_name) {
		this.procedure_name = procedure_name;
	}

	public void setStatus(String status) {
		if(status.equalsIgnoreCase("Pending") || status.equalsIgnoreCase("Done")) {
		this.status = status;
		}
		else {
			System.out.println("Invalid status.");
		}
	}
	public String getStatus() {
	    return status;
	}
}
