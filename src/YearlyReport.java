import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    static HashMap<String, ArrayList<Integer>> yearlyReport;
    static String mask = "y.";

    YearlyReport() {
        yearlyReport = new HashMap<String, ArrayList<Integer>>();
    }

    public static void readYerlyFile() {
        ArrayList<String> names = CustomFileReader.findAllFilesbyMask(mask);
        for (String name : names) {
            String file = CustomFileReader.readFileContentsOrNull(name);
            String[] lines = file.split("\n");
            for (int i = 1; i < lines.length; i++) {
                ArrayList<Integer> report = new ArrayList<>();
                String[] line = lines[i].split(",");
                String month = line[0];
                int amount = Integer.parseInt(line[1]);
                boolean isExpense = Boolean.parseBoolean(line[2]);
                report.add(amount);
                yearlyReport.put(month, report);
                System.out.println(yearlyReport);
            }
        }
    }

}
