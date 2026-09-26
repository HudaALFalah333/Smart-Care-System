package smartCare;

public class Monitoring_Measurement extends Madical_Procedure{

	public Monitoring_Measurement(int procedure_id, String procedure_name) {
		super(procedure_id, procedure_name);
	}

	@Override
	public String getProcedure_type() {
		return "Monitoring Measurement";
	}

}
