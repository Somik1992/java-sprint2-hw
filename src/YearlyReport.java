public class YearlyReport {
    String file = "";


    YearlyReport () {
    }

    public void readYerlyFile () {
        file = FileReader.readFileContentsOrNull("resources/m.202101.csv");
        System.out.println(file);

    }


}
