import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    static HashMap<String, ArrayList<Integer>> MonthlyReport = new HashMap<>();
    static HashMap<String, HashMap<String , ArrayList<Integer>>> TotalReport = new HashMap<>();
    static String mask = "m.";

    MonthlyReport() {
    }

    public static void readMounthlyFile() {
        ArrayList<String> names = CustomFileReader.findAllFilesbyMask(mask);
        for (String name : names) {
            String file = CustomFileReader.readFileContentsOrNull(name);
            String[] lines = file.split("\n");
            ArrayList<Integer> report = new ArrayList<>();
            String item = "";
            for (int i = 1; i < lines.length; i++) {

                String[] line = lines[i].split(",");
                int amount = Integer.parseInt(line[3]);
                boolean isExpense = Boolean.parseBoolean(line[1]);
                int quantity = Integer.parseInt(line[2]);

                if (isExpense) {
                    amount = -1 * amount;
                }
                item = line[0];
                report.add(amount * quantity);
                MonthlyReport.put(item, report);
                TotalReport.put(name.split("/")[1].substring(6, 8), MonthlyReport);
                report = new ArrayList<>();
            }
            System.out.println("Месячный отчет за" + name.split("/")[1].substring(6, 8) + "считан");
            MonthlyReport = new HashMap<>();
        }
    }
}
