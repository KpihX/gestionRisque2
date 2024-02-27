public class CreditCalculator {
    public static double calculateCredit(Client client) {
        int age = client.getAge();
        double salary = client.getSalary();
        double creditAmount = 0.0;

        if (salary >= 50000 && salary <= 100000) {
            creditAmount = (age <= 45) ? 1000000 : 0.0;
        } else if (salary > 100000 && salary <= 200000) {
            if (age <= 45) {
                creditAmount = 2000000;
            } else if (age > 45 && age <= 55) {
                creditAmount = 1000000;
            }
        } else if (salary > 200000 && salary < 300000) {
            if (age <= 45) {
                creditAmount = 3000000;
            } else if (age > 45 && age <= 55) {
                creditAmount = 2000000;
            }
        } else if (salary >= 300000) {
            if (age <= 45) {
                creditAmount = 5000000;
            } else if (age > 45 && age <= 55) {
                creditAmount = 3000000;
            }
        }

        return creditAmount;
    }
}