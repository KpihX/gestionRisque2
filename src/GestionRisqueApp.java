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
        mainFrame.setSize(400, 300);
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
        mainFrame.add(new JScrollPane(textAreaCreditInfo));
        mainFrame.setVisible(true);
    }
    
    private void calculateCredit() {
        try {
            int age = Integer.parseInt(textFieldAge.getText());
            double salary = Double.parseDouble(textFieldSalary.getText());
            Client client = new Client(age, salary);
            double creditAmount = CreditCalculator.calculateCredit(client);
            textAreaCreditInfo.setText("Montant de crédit autorisé: " + creditAmount);
        } catch (NumberFormatException ex) {
            textAreaCreditInfo.setText("Erreur: Veuillez saisir des valeurs numériques valides pour l'âge et le salaire.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionRisqueApp();
            }
        });
    }
}