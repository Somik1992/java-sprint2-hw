import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    static HashMap<String, ArrayList<Double>> MonthlyReport;
    static String mask = "m.";

    MonthlyReport() {
        MonthlyReport = new HashMap<>();
    }

    public static void readYerlyFile() {
        ArrayList<String> names = CustomFileReader.findAllFilesbyMask(mask);
        for (String name: names) {
            String file = CustomFileReader.readFileContentsOrNull(name);
            System.out.println(file);
        }
    }
}
