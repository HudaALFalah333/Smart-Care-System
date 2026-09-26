package smartCare;

public class File_Storage {
	private static File_Storage instance = new File_Storage();

    private File_Storage() {
    }

    public static File_Storage getInstance() {
        return instance;
    }

    public void export_report(Reports report, String format, String file_name) {
        if (report == null) {
            System.out.println("Report can't be null.");
            return;
        }

        if (format.equalsIgnoreCase("text")) {
            report.export_to_text(file_name);
        } else if (format.equalsIgnoreCase("xml")) {
            report.export_to_xml(file_name);
        } else {
            System.out.println("Invalid export format.");
        }
    }
}