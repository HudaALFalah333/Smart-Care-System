package smartCare;

public class Jordanian_Resident implements ResidencyInfo{
	 private String national_number;
	 private String id_card_number;
	public Jordanian_Resident(String national_number, String id_card_number) {
		this.national_number = national_number;
		this.id_card_number = id_card_number;
	}
	@Override
	public String getResidency_Id() {
		return national_number;
	}
	@Override
	public String getResidency_Type() {
		return "Jordanian";
	}

	public String getId_card_number() {
		return id_card_number;
	}
}
