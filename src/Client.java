public class Client {
    private String ageCategory;
    private String salaryCategory;

    public Client(String ageCategory, String salaryCategory) {
        this.ageCategory = ageCategory;
        this.salaryCategory = salaryCategory;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public String getSalaryCategory() {
        return salaryCategory;
    }
}