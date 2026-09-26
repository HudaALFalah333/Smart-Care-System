package smartCare;

import java.util.ArrayList;

public class Section_Manager implements Section_Service{
	  private ArrayList<Section> sections;
	  public Section_Manager() {
	      this.sections = new ArrayList<>();
	  }
	  @Override
	  public void add_section(Section section) {
	      if (section != null) {
	          sections.add(section);
	          System.out.println("The section " + section.getSection_name() + " added successfully.");
	      } 
	      else 
	      {
	            System.out.println("The section can't be null.");
	        }
	    }
	  @Override
	  public Section search_id_section(int id) {
	      for (int i = 0; i < sections.size(); i++) {
	          if (sections.get(i).getSection_id() == id) {
	              return sections.get(i);
	            }
	     }
	     return null;
	  }
	  @Override
	  public void print_all_sections() {
	      for (int i = 0; i < sections.size(); i++) {
	          sections.get(i).print_detalis();
	      }
	  }

	  public ArrayList<Section> getSections() {
	      return sections;
	  }

	  public void setSections(ArrayList<Section> sections) {
	      this.sections = sections;
	  }
	
}
