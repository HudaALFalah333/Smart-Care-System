package smartCare;

public class Medication extends Madical_Procedure{
	public Medication(int procedure_id, String procedure_name) {
		super(procedure_id, procedure_name);
	}

	@Override
	public String getProcedure_type() {
	    return "Medication";
	}
}