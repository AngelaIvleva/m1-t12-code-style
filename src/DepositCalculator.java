import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod ) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
            return roundingTheAmount (pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundingTheAmount(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundingTheAmount(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void calculateProfit() {
        int period;
        int action;

        Scanner scn = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");

        int amount = scn.nextInt();

        System.out.println("Введите срок вклада в годах:");

        period = scn.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");

        action = scn.nextInt();

        double totalAmount = 0;

        if (action == 1) {
            totalAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            totalAmount = calculateComplexPercent(amount, 0.06, period);
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalAmount);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateProfit();
    }
}
