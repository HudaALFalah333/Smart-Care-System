package smartCare;
import java.util.ArrayList;

public class Section {
	private int section_id;
	private String section_name;
	private ArrayList<Room>rooms;
	public Section(int section_id, String section_name) {
		this.section_id = section_id;
		this.section_name = section_name;
		this.rooms = new ArrayList<>();
	}
	
	public void add_room(Room room) {
		if (room != null) {
			rooms.add(room);
		}
	}

	public boolean remove_room(Room room) {
		return rooms.remove(room);
	}
	
	 public void print_detalis() {
	        System.out.println("Section id: " + section_id);
	        System.out.println("Section name: " + section_name);
	       for (int i =0; i<rooms.size(); i++) {
	    	   System.out.println("Room " + (i+1));
	    	   rooms.get(i).print_detalis();
	       }
	    }

	public int getSection_id() {
		return section_id;
	}

	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	 
}
