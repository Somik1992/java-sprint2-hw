import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class YearlyReport {
    static HashMap<String, ArrayList<Integer>> yearlyReport= new HashMap<String, ArrayList<Integer>>();
    static String mask = "y.";

    YearlyReport() {
    }

    public static void readYerlyFile() {
        ArrayList<String> names = CustomFileReader.findAllFilesbyMask(mask);
        for (String name : names) {
            String file = CustomFileReader.readFileContentsOrNull(name);
            String[] lines = file.split("\n");
            ArrayList<Integer> report = new ArrayList<>();;
            String month = "";
            for (int i = 1; i < lines.length; i++) {

                String[] line = lines[i].split(",");
                int amount = Integer.parseInt(line[1]);
                boolean isExpense = Boolean.parseBoolean(line[2]);

                if (isExpense) {
                    amount = -1 * amount;
                }
                if (Objects.equals(line[0], month) || month.isEmpty()) {
                    month = line[0];
                    report.add(amount);
                    yearlyReport.put(month, report);
                } else {
                    report = new ArrayList<>();
                    month = line[0];
                    report.add(amount);
                }
            }
            System.out.println("Годовой отчет считан");
        }
    }
}
