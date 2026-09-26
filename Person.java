package smartCare;

public abstract class Person {
	private int id;
	private String name;
	private String phone_number;
	private String address;
	private ResidencyInfo residencyInfo;
	public Person(int id, String name, String phone_number, String address, ResidencyInfo residencyInfo) {
		this.id = id;
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
		this.residencyInfo = residencyInfo;
	}
	public void print_detalis () {
		System.out.println("Id: " + id);
		System.out.println("Name: " + name);
		System.out.println("Phone Number: " + phone_number);
		System.out.println("Address: " + address);
		System.out.println("Residency Type: " + residencyInfo.getResidency_Type());

		if (residencyInfo instanceof Jordanian_Resident) {
			Jordanian_Resident jordanian = (Jordanian_Resident) residencyInfo;
			System.out.println("National Number: " + jordanian.getResidency_Id());
			System.out.println("ID Card Number: " + jordanian.getId_card_number());
		} else if (residencyInfo instanceof Non_Jordanian_Resident) {
			Non_Jordanian_Resident nonJordanian = (Non_Jordanian_Resident) residencyInfo;
			System.out.println("Residential Number: " + nonJordanian.getResidency_Id());
			System.out.println("Nationality: " + nonJordanian.getNationality());
		} else {
			System.out.println("Residency ID: " + residencyInfo.getResidency_Id());
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public ResidencyInfo getResidencyInfo() {
		return residencyInfo;
	}
	public void setResidencyInfo(ResidencyInfo residencyInfo) {
		this.residencyInfo = residencyInfo;
	}
	
}
