package smartCare;

public class Radiology extends Madical_Procedure{

	public Radiology(int procedure_id, String procedure_name) {
		super(procedure_id, procedure_name);
	}

	@Override
	public String getProcedure_type() {
		return "Radiology";
	}

}
