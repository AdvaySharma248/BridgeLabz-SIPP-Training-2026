import java.util.Scanner;

public class CalendarDisplay {

    public static String getMonthName(int month) {
        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return monthNames[month - 1];
    }

    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }

    public static int getNumberOfDays(int month, int year) {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month - 1];
    }

    public static int getFirstDayOfMonth(int month, int year) {
        int y = year;
        int m = month;
        if (m < 3) {
            m = m + 12;
            y = y - 1;
        }
        int k = y % 100;
        int j = y / 100;
        int dayOfWeek = (1 + (13 * (m + 1)) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
        return dayOfWeek;
    }

    public static void displayCalendar(int month, int year) {
        String monthName = getMonthName(month);
        int numberOfDays = getNumberOfDays(month, year);
        int firstDay = getFirstDayOfMonth(month, year);

        System.out.println("    " + monthName + " " + year);
        System.out.println(" Su Mo Tu We Th Fr Sa");

        int dayOfWeek = (firstDay + 6) % 7;

        for (int i = 0; i < dayOfWeek; i++) {
            System.out.print("   ");
        }

        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%3d", day);
            dayOfWeek++;
            if (dayOfWeek % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        displayCalendar(month, year);

        scanner.close();
    }
}
