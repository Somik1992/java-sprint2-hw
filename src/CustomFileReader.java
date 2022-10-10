import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class CustomFileReader {

    public static ArrayList findAllFilesbyMask(String mask) {
        ArrayList<String> result = new ArrayList<String>();
        String[] pathnames;
        File f = new File("resources/");
        pathnames = f.list();
        for (String pathname : pathnames) {
            if (pathname.startsWith(mask)) {
                result.add(f + "/" + pathname);
            }
        }
        return result;
    }

    public static String readFileContentsOrNull(String path)  {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("���������� ��������� ���� � �������� �������. ��������, ���� �� ��������� � ������ ����������.");
            return null;
        }
    }

    public static boolean checkReports () {
        return YearlyReport.yearlyReport.isEmpty() || MonthlyReport.TotalReport.isEmpty();
    }
}
