import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                MonthlyReport.readMounthlyFile();
            } else if (command == 2) {
                YearlyReport.readYerlyFile();
            } else if (command == 3) {
                Reconciliation.reconcilReport();
            } else if (command == 4) {
                MonthlyReport.printMountlyReport();
            } else if (command == 5) {
                YearlyReport.printYearlyReport();
            } else if (command == 0) {
                System.out.println("�����");
            } else {
                System.out.println("����� ������� ���� ���");
            }
        }
    }



    public static void printMenu() {
        System.out.println("��� �� ������ �������? ");
        System.out.println("1 - ������� ��� �������� ������");
        System.out.println("2 - ������� ������� �����");
        System.out.println("3 - ������� ������");
        System.out.println("4 - ������� ���������� � ���� �������� �������");
        System.out.println("5 - ������� ���������� � ������� ������");
        System.out.println("0 - ����� �� ����������");
    }
}

