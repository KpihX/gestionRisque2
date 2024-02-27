import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestionRisqueApp {
    private JFrame mainFrame;
    private JComboBox<String> comboBoxAge;
    private JComboBox<String> comboBoxSalary;
    private JTextField textFieldCredit;
    private JTextArea textAreaCreditInfo;

    public GestionRisqueApp() {
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Gestion des Risques de Crédit");
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new GridLayout(5, 2));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelAge = new JLabel("Catégorie d'âge: ");
        JLabel labelSalary = new JLabel("Catégorie de salaire: ");
        JLabel labelCredit = new JLabel("Crédit demandé: ");
        
        comboBoxAge = new JComboBox<>(new String[]{"<= 45", "46 - 55"});
        comboBoxSalary = new JComboBox<>(new String[]{"50,000 - 100,000", "100,001 - 200,000", "200,001 - 300,000", ">= 300,001"});
        textFieldCredit = new JTextField();
        
        JButton evaluateButton = new JButton("Évaluer le Crédit");
        
        textAreaCreditInfo = new JTextArea();
        textAreaCreditInfo.setEditable(false);

        evaluateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                evaluateCredit();
            }
        });

        mainFrame.add(labelAge);
        mainFrame.add(comboBoxAge);
        mainFrame.add(labelSalary);
        mainFrame.add(comboBoxSalary);
        mainFrame.add(labelCredit);
        mainFrame.add(textFieldCredit);
        mainFrame.add(evaluateButton);
        mainFrame.add(new JScrollPane(textAreaCreditInfo));
        mainFrame.setVisible(true);
    }

    private void evaluateCredit() {
        try {
            String ageCategory = (String) comboBoxAge.getSelectedItem();
            String salaryCategory = (String) comboBoxSalary.getSelectedItem();
            double requestedCredit = Double.parseDouble(textFieldCredit.getText());
    
            Client client = new Client(ageCategory, salaryCategory);
            String creditEvaluation = CreditCalculator.calculateCredit(client, requestedCredit);
            textAreaCreditInfo.setText(creditEvaluation);
        } catch (NumberFormatException ex) {
            textAreaCreditInfo.setText("Veuillez entrer un nombre valide pour le crédit demandé.");
        }
    }
    
    public static void main(String[] args) {
        GestionRisqueApp riskApp = new GestionRisqueApp();
    }
}