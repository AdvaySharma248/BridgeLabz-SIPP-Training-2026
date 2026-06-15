public class EmployeeBonusCalculator {

    public static double[][] generateSalaryAndService(int numberOfEmployees) {
        double[][] data = new double[numberOfEmployees][2];
        for (int i = 0; i < numberOfEmployees; i++) {
            data[i][0] = (int) (Math.random() * 90000) + 10000;
            data[i][1] = (int) (Math.random() * 10) + 1;
        }
        return data;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] data) {
        double[][] newData = new double[data.length][2];
        for (int i = 0; i < data.length; i++) {
            double oldSalary = data[i][0];
            double yearsOfService = data[i][1];
            double bonusPercentage;
            if (yearsOfService > 5) {
                bonusPercentage = 0.05;
            } else {
                bonusPercentage = 0.02;
            }
            double bonus = oldSalary * bonusPercentage;
            double newSalary = oldSalary + bonus;
            newData[i][0] = newSalary;
            newData[i][1] = bonus;
        }
        return newData;
    }

    public static void calculateAndDisplaySummary(double[][] oldData, double[][] newData) {
        double sumOldSalary = 0;
        double sumNewSalary = 0;
        double totalBonus = 0;

        for (int i = 0; i < oldData.length; i++) {
            sumOldSalary = sumOldSalary + oldData[i][0];
            sumNewSalary = sumNewSalary + newData[i][0];
            totalBonus = totalBonus + newData[i][1];
        }

        System.out.println("\nSummary");
        System.out.println("----------------------------------------");
        System.out.println("Sum of Old Salary: " + sumOldSalary);
        System.out.println("Sum of New Salary: " + sumNewSalary);
        System.out.println("Total Bonus Amount: " + totalBonus);
    }

    public static void main(String[] args) {
        int numberOfEmployees = 10;

        double[][] oldData = generateSalaryAndService(numberOfEmployees);
        double[][] newData = calculateNewSalaryAndBonus(oldData);

        System.out.println("Employee Bonus Report for Zara");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("Employee\tOld Salary\tYears of Service\tBonus\t\tNew Salary");
        System.out.println("-----------------------------------------------------------------------------------");

        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println((i + 1) + "\t\t" + oldData[i][0]
                    + "\t\t" + (int) oldData[i][1]
                    + "\t\t\t" + String.format("%.2f", newData[i][1])
                    + "\t\t" + String.format("%.2f", newData[i][0]));
        }

        calculateAndDisplaySummary(oldData, newData);
    }
}
