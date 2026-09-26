package smartCare;

public class Lab_Test  extends Madical_Procedure{

	public Lab_Test(int procedure_id, String procedure_name) {
		super(procedure_id, procedure_name);
	}
	@Override
	public String getProcedure_type() {
		return "Lab Test";
	}

}
