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
                System.out.println("Выход");
            } else {
                System.out.println("Такой команды пока нет");
            }
        }
    }



    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выйти их приложения");
    }
}

