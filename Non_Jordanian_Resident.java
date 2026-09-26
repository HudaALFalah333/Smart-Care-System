package smartCare;

public class Non_Jordanian_Resident implements ResidencyInfo{
	 private String residential_number;
	 private String nationality;
	 
	 
	public Non_Jordanian_Resident(String residential_number, String nationality) {
		super();
		this.residential_number = residential_number;
		this.nationality = nationality;
	}
	@Override
	public String getResidency_Id() {
		return residential_number;
	}
	@Override
	public String getResidency_Type() {
		return "Non-Jordanian";
	}

	public String getNationality() {
		return nationality;
	}
}
