import java.util.Random;

class EmployeeBonus {
    static double[][] getSalaryAndService() {
        double[][] arr = new double[10][2];
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i][0] = r.nextInt(90000) + 10000;
            arr[i][1] = r.nextInt(11);
        }
        return arr;
    }

    static double[][] calculateBonus(double[][] arr) {
        double[][] res = new double[10][2];
        for (int i = 0; i < 10; i++) {
            double salary = arr[i][0];
            int years = (int) arr[i][1];
            double bonus = years > 5 ? 0.05 * salary : 0.02 * salary;
            res[i][0] = salary + bonus;
            res[i][1] = bonus;
        }
        return res;
    }

    static void display(double[][] oldArr, double[][] newArr) {
        double sumOld = 0, sumNew = 0, sumBonus = 0;
        System.out.printf("%-10s %-12s %-12s %-12s %-12s %-12s\n",
                "Emp", "OldSalary", "ServiceYrs", "Bonus", "NewSalary", " ");
        for (int i = 0; i < 10; i++) {
            double oldSal = oldArr[i][0];
            double yrs = oldArr[i][1];
            double bonus = newArr[i][1];
            double newSal = newArr[i][0];
            sumOld += oldSal;
            sumNew += newSal;
            sumBonus += bonus;
            System.out.printf("%-10d %-12.2f %-12.0f %-12.2f %-12.2f\n",
                    i + 1, oldSal, yrs, bonus, newSal);
        }
        System.out.println("--------------------------------------------------------------");
        System.out.printf("Totals -> Old: %.2f  New: %.2f  Bonus: %.2f\n", sumOld, sumNew, sumBonus);
    }

    public static void main(String[] args) {
        double[][] oldArr = getSalaryAndService();
        double[][] newArr = calculateBonus(oldArr);
        display(oldArr, newArr);
    }
}
