package smartCare;
import java.io.FileWriter;
import java.io.IOException;
public class Reports {
	private String title;
	private String summary;
	private String content;
	private String date;
	private String admin_name;
	public Reports(String title, String summary, String content, String date, String admin_name) {
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.date = date;
		this.admin_name = admin_name;
	}
	
    public void print_detalis() {
        System.out.println("Title Report: " + title);
        System.out.println("Summary: " + summary);
        System.out.println("Content: " + content);
        System.out.println("Date: " + date);
        System.out.println("Admin  Generated: " + admin_name);
    }
    
    public void export_to_text(String file_name) {
        try {
            FileWriter writer = new FileWriter(file_name);

            writer.write("Title Report: " + title + "\n");
            writer.write("Summary: " + summary + "\n");
            writer.write("Content: " + content + "\n");
            writer.write("Date: " + date + "\n");
            writer.write("Create Admin: " + admin_name + "\n");

            writer.close();

            System.out.println("The report exported to text successfully.");
        }
        catch (IOException e) {
            System.out.println("Error while exporting report.");
        }
    }

    public void export_to_xml(String file_name) {
        try {
            FileWriter writer = new FileWriter(file_name);

            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<report>\n");
            writer.write("  <title>" + escape_xml(title) + "</title>\n");
            writer.write("  <summary>" + escape_xml(summary) + "</summary>\n");
            writer.write("  <content><![CDATA[" + content + "]]></content>\n");
            writer.write("  <date>" + escape_xml(date) + "</date>\n");
            writer.write("  <admin>" + escape_xml(admin_name) + "</admin>\n");
            writer.write("</report>\n");

            writer.close();

            System.out.println("The report exported to XML successfully.");
        }
        catch (IOException e) {
            System.out.println("Error while exporting XML report.");
        }
    }
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

    private String escape_xml(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
    
}
