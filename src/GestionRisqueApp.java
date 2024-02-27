import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionRisqueApp {
    private JFrame mainFrame;
    private JTextField textFieldAge;
    private JTextField textFieldSalary;
    private JTextArea textAreaCreditInfo;

    public GestionRisqueApp() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Calcul de Crédit Bancaire");
        mainFrame.setSize(300, 200);
        mainFrame.setLayout(new GridLayout(4, 2));

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelAge = new JLabel("Age: ");
        JLabel labelSalary = new JLabel("Salaire: ");
        
        textFieldAge = new JTextField();
        textFieldSalary = new JTextField();
        JButton calculateButton = new JButton("Calculer Crédit");
        
        textAreaCreditInfo = new JTextArea();
        textAreaCreditInfo.setEditable(false);

        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateCredit();
            }
        });

        mainFrame.add(labelAge);
        mainFrame.add(textFieldAge);
        mainFrame.add(labelSalary);
        mainFrame.add(textFieldSalary);
        mainFrame.add(calculateButton);
        mainFrame.add(textAreaCreditInfo);
        mainFrame.setVisible(true);
    }
    
    private void calculateCredit() {
        int age = Integer.parseInt(textFieldAge.getText());
        double salary = Double.parseDouble(textFieldSalary.getText());
        double creditAmount = 0.0;

        if (salary >= 50000 && salary <= 100000) {
            if (age <= 45) {
                creditAmount = 1000000; // Crédit minimal
            }
        } else if (salary > 100000 && salary <= 200000) {
            if (age <= 45) {
                creditAmount = 2000000; // Crédit junior
            } else if (age > 45 && age <= 55) {
                creditAmount = 1000000; // Crédit minimal
            }
        } else if (salary > 200000 && salary < 300000) {
            if (age <= 45) {
                creditAmount = 3000000; // Crédit équilibré
            } else if (age > 45 && age <= 55) {
                creditAmount = 2000000; // Crédit junior
            }
        } else if (salary >= 300000) {
            if (age <= 45) {
                creditAmount = 5000000; // Crédit gold
            } else if (age > 45 && age <= 55) {
                creditAmount = 3000000; // Crédit équilibré
            }
        }
        textAreaCreditInfo.setText("Montant de crédit autorisé: " + creditAmount);
    }

    public static void main(String[] args) {
        GestionRisqueApp app = new GestionRisqueApp();
    }
}