public class CreditCalculator {
    public static String calculateCredit(Client client, double requestedCredit) {
        String ageCategory = client.getAgeCategory();
        String salaryCategory = client.getSalaryCategory();

        double maxCredit = 0.0;

        if ("<= 45".equals(ageCategory)) {
            if ("50,000 - 100,000".equals(salaryCategory)) {
                maxCredit = 1000000;
            } else if ("100,001 - 200,000".equals(salaryCategory)) {
                maxCredit = 2000000;
            } else if ("200,001 - 300,000".equals(salaryCategory)) {
                maxCredit = 3000000;
            } else if (">= 300,001".equals(salaryCategory)) {
                maxCredit = 5000000;
            }
        } else if ("46 - 55".equals(ageCategory)) {
            if ("50,000 - 100,000".equals(salaryCategory)) {
                maxCredit = 0.0;
            } else if ("100,001 - 200,000".equals(salaryCategory)) {
                maxCredit = 1000000;
            } else if ("200,001 - 300,000".equals(salaryCategory)) {
                maxCredit = 2000000;
            } else if (">= 300,001".equals(salaryCategory)) {
                maxCredit = 3000000;
            }
        } // Ajoutez des catégories d'âge supplémentaires si nécessaire.

        if (requestedCredit > maxCredit) {
            return "Désolé, nous ne pouvons vous accorder que " + maxCredit;
        } else if (maxCredit == 0.0) {
            return "Aucun crédit ne peut être accordé pour votre catégorie.";
        } else {
            return "Votre demande de crédit de " + requestedCredit + " a été approuvée.";
        }
    }
}