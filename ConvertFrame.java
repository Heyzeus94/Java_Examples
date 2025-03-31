import javax.swing.*;
import java.awt.*;

public class ConvertFrame extends JFrame {
    private JTextField currencyInputField;
    private JTextField currencyOutputField;
    private JRadioButton fromUSD, fromMXN, fromEUR, toUSD, toMXN, toEUR;

    public ConvertFrame() {
        super("Currency Converter");
        setLayout(new GridLayout(11, 1));

        // Input field
        currencyInputField = new JTextField("0.0");
        currencyOutputField = new JTextField();
        currencyOutputField.setEditable(false);

        // "Convert From" section with icons above radio buttons
        add(new JLabel("Convert from:"));
        JPanel fromPanel = new JPanel(new FlowLayout());

        // Load images as icons
        ImageIcon usdIcon = new ImageIcon(getClass().getResource("/dollar.jpg"));
        ImageIcon mxnIcon = new ImageIcon(getClass().getResource("/peso.jpg"));
        ImageIcon eurIcon = new ImageIcon(getClass().getResource("/euro.jpg"));

        // US Dollar icon and radio button
        JLabel usdIconLabel = new JLabel(usdIcon);
        fromPanel.add(usdIconLabel);
        fromUSD = new JRadioButton("US Dollar", true);
        fromPanel.add(fromUSD);

        // Mexican Peso icon and radio button
        JLabel mxnIconLabel = new JLabel(mxnIcon);
        fromPanel.add(mxnIconLabel);
        fromMXN = new JRadioButton("Mexican Peso");
        fromPanel.add(fromMXN);

        // Euro icon and radio button
        JLabel eurIconLabel = new JLabel(eurIcon);
        fromPanel.add(eurIconLabel);
        fromEUR = new JRadioButton("Euro");
        fromPanel.add(fromEUR);

        // Group the "Convert from" radio buttons
        ButtonGroup fromGroup = new ButtonGroup();
        fromGroup.add(fromUSD);
        fromGroup.add(fromMXN);
        fromGroup.add(fromEUR);

        add(fromPanel);

        // Add input field for amount
        add(new JLabel("Enter Currency:"));
        add(currencyInputField);

        // "Convert To" section with icons above radio buttons
        add(new JLabel("Convert to:"));
        JPanel toPanel = new JPanel(new FlowLayout());

        // US Dollar icon and radio button
        JLabel toUsdIconLabel = new JLabel(usdIcon);
        toPanel.add(toUsdIconLabel);
        toUSD = new JRadioButton("US Dollar", true);
        toPanel.add(toUSD);

        // Mexican Peso icon and radio button
        JLabel toMxnIconLabel = new JLabel(mxnIcon);
        toPanel.add(toMxnIconLabel);
        toMXN = new JRadioButton("Mexican Peso");
        toPanel.add(toMXN);

        // Euro icon and radio button
        JLabel toEurIconLabel = new JLabel(eurIcon);
        toPanel.add(toEurIconLabel);
        toEUR = new JRadioButton("Euro");
        toPanel.add(toEUR);

        // Group the "Convert to" radio buttons
        ButtonGroup toGroup = new ButtonGroup();
        toGroup.add(toUSD);
        toGroup.add(toMXN);
        toGroup.add(toEUR);

        add(toPanel);

        // Add output label for converted currency
        add(new JLabel("Comparable Currency is:"));
        add(currencyOutputField);

        // Buttons for actions
        JPanel buttonPanel = new JPanel();
        JButton convertButton = new JButton("Convert");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        // Add action listeners to buttons
        convertButton.addActionListener(e -> performConversion());
        clearButton.addActionListener(e -> clearFields());
        exitButton.addActionListener(e -> confirmExit());

        buttonPanel.add(convertButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
        add(buttonPanel);

        // Menu setup
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem convertMenuItem = new JMenuItem("Convert");
        JMenuItem clearMenuItem = new JMenuItem("Clear");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        JMenuItem aboutMenuItem = new JMenuItem("About");

        // Add menu items to the file menu
        fileMenu.add(convertMenuItem);
        fileMenu.add(clearMenuItem);
        fileMenu.add(exitMenuItem);
        fileMenu.add(aboutMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Add action listeners to menu items
        convertMenuItem.addActionListener(e -> performConversion());
        clearMenuItem.addActionListener(e -> clearFields());
        exitMenuItem.addActionListener(e -> confirmExit());
        aboutMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "Currency Conversion Program using menus and buttons\nJesus Gutierrez\nLab 4"));

        // Configure frame settings
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void performConversion() {
        String input = currencyInputField.getText();
        try {
            double amount = Double.parseDouble(input);

            // Conversion rates relative to USD
            double usdToUsd = 1.00;
            double usdToMxn = 20.31;
            double usdToEur = 0.94;

            double convertedAmount = 0;
            String fromCurrency = "";
            String toCurrency = "";

            // Determine "from" and "to" conversion
            if (fromUSD.isSelected() && toUSD.isSelected()) {
                convertedAmount = amount * usdToUsd;
                fromCurrency = "US Dollar";
                toCurrency = "US Dollar";
            } else if (fromUSD.isSelected() && toMXN.isSelected()) {
                convertedAmount = amount * usdToMxn;
                fromCurrency = "US Dollar";
                toCurrency = "Mexican Peso";
            } else if (fromUSD.isSelected() && toEUR.isSelected()) {
                convertedAmount = amount * usdToEur;
                fromCurrency = "US Dollar";
                toCurrency = "Euro";
            } else if (fromMXN.isSelected() && toUSD.isSelected()) {
                convertedAmount = amount / usdToMxn;
                fromCurrency = "Mexican Peso";
                toCurrency = "US Dollar";
            } else if (fromMXN.isSelected() && toMXN.isSelected()) {
                convertedAmount = amount;
                fromCurrency = "Mexican Peso";
                toCurrency = "Mexican Peso";
            } else if (fromMXN.isSelected() && toEUR.isSelected()) {
                convertedAmount = (amount / usdToMxn) * usdToEur;
                fromCurrency = "Mexican Peso";
                toCurrency = "Euro";
            } else if (fromEUR.isSelected() && toUSD.isSelected()) {
                convertedAmount = amount / usdToEur;
                fromCurrency = "Euro";
                toCurrency = "US Dollar";
            } else if (fromEUR.isSelected() && toMXN.isSelected()) {
                convertedAmount = (amount / usdToEur) * usdToMxn;
                fromCurrency = "Euro";
                toCurrency = "Mexican Peso";
            } else if (fromEUR.isSelected() && toEUR.isSelected()) {
                convertedAmount = amount;
                fromCurrency = "Euro";
                toCurrency = "Euro";
            }

            currencyOutputField.setText(String.format("%.2f", convertedAmount));

            // Show secondary display with conversion details
            JOptionPane.showMessageDialog(this, fromCurrency + " to " + toCurrency + ", " + amount + " is equivalent to " + String.format("%.2f", convertedAmount));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    private void clearFields() {
        currencyInputField.setText("");
        currencyOutputField.setText("");
    }

    private void confirmExit() {
        int response = JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ConvertFrame();
    }
}
