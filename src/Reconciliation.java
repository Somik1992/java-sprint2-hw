import java.util.ArrayList;
import java.util.HashMap;

public class Reconciliation {
    static HashMap<String, Integer> reconcileYearlyReport= new HashMap<String, Integer>();
    static HashMap<String, Integer> reconcileMountlyReport= new HashMap<String, Integer>();
    public static void reconcilReport() {

        if (CustomFileReader.checkReports()) {
            System.out.println("—начала нужно закачать мес€чные и годовый отчет");
        } else {

            for (String month: YearlyReport.yearlyReport.keySet()) {
                int resultYearlyReport = 0;
                for (Integer value : YearlyReport.yearlyReport.get(month)) {
                    resultYearlyReport += value;
                    reconcileYearlyReport.put(month, resultYearlyReport);
                }
            }

            for (String month: MonthlyReport.TotalReport.keySet()) {
                int resultMountlyReport = 0;
                HashMap<String, ArrayList<Integer>> expenses = MonthlyReport.TotalReport.get(month);
                for (String value : expenses.keySet()) {
                    resultMountlyReport += expenses.get(value).get(0);
                    reconcileMountlyReport.put(month, resultMountlyReport);
                }
            }
            if (reconcileYearlyReport.equals(reconcileMountlyReport)) {
                System.out.println("–еконсил€ци€ прошла успешно, данные верны");
            } else {
                if (reconcileYearlyReport.size() == reconcileMountlyReport.size()) {
                    for (String mounth : reconcileMountlyReport.keySet()) {
                        if (!reconcileMountlyReport.get(mounth).equals(reconcileYearlyReport.get(mounth))) {
                            System.out.println("ќшибка реконсил€ции");
                            System.out.println("ѕроблема в мес€це " + mounth);
                        }
                    }
                } else {
                    System.out.println(" оличество мес€цев в годовых отчетах и количество мес€цев в мес€чных отчетах " +
                            "не равно, скорее всего вы не загрузили какой-то отчет");
                }
            }
        }
    }
}

