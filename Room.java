package smartCare;

public class Room {
	private int number_room;
	private String type_room;
	private int capacity;
	private int available_beds;
	
	public Room(int number_room, String type_room, int capacity) {
		this.number_room = number_room;
		this.type_room = type_room;
		this.capacity = capacity;
		this.available_beds = capacity;
	}
	 public boolean has_available_bed() {
	        if (available_beds > 0) {
	            return true;
	        }
	        else 
	        {
	           return false;
	        }
	    }

	    public void assign_bed() {
	        if (available_beds > 0) {
	            available_beds--;
	            System.out.println("The bed is assigned successfully.");
	        }
	        else {
	            System.out.println("No available beds.");
	        }
	    }

	    public void release_bed() {
	        if (available_beds < capacity) {
	            available_beds++;
	            System.out.println("Bed released successfully.");
	        }
	        else {
	            System.out.println("Room is already empty.");
	        }
	    }

	    public void print_detalis() {
	        System.out.println("Room Number: " + number_room);
	        System.out.println("Room Type: " + type_room);
	        System.out.println("Capacity: " + capacity);
	        System.out.println("Available Beds: " + available_beds);
	    }
		public int getNumber_room() {
			return number_room;
		}
		public void setNumber_room(int number_room) {
			this.number_room = number_room;
		}
		public String getType_room() {
			return type_room;
		}
		public void setType_room(String type_room) {
			this.type_room = type_room;
		}
		public int getCapacity() {
			return capacity;
		}
		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}
		public int getAvailable_beds() {
			return available_beds;
		}
		public void setAvailable_beds(int available_beds) {
			this.available_beds = available_beds;
		}
}
