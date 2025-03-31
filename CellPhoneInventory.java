import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class CellPhoneInventory extends JFrame {
    JLabel labelModel, labelManufacturer, labelRetailPrice, labelBanner;
    JTextField jTextFieldModel, jTextFieldManufacturer, jTextFieldRetailPrice;
    JButton jButtonAdd, jButtonSave, jButtonNext, jButtonShow;
    JPanel newPanel, buttonPanel;
    ArrayList<CellPhone> phoneArrayList = new ArrayList<>();

    CellPhoneInventory() {
        setTitle("Cellphone Inventory");
        setLayout(new BorderLayout());

        labelBanner = new JLabel("Cellphone Inventory Management");
        labelBanner.setFont(new Font("Serif", Font.BOLD, 20));
        labelBanner.setForeground(Color.BLUE);

        labelModel = new JLabel("Model");
        labelManufacturer = new JLabel("Manufacturer");
        labelRetailPrice = new JLabel("Retail Price");

        jTextFieldModel = new JTextField(15);
        jTextFieldManufacturer = new JTextField(15);
        jTextFieldRetailPrice = new JTextField(15);

        jButtonAdd = new JButton("Add");
        jButtonSave = new JButton("Save");
        jButtonNext = new JButton("Next");
        jButtonShow = new JButton("Show Inventory");

        newPanel = new JPanel(new GridLayout(3, 2));
        newPanel.add(labelModel);
        newPanel.add(jTextFieldModel);
        newPanel.add(labelManufacturer);
        newPanel.add(jTextFieldManufacturer);
        newPanel.add(labelRetailPrice);
        newPanel.add(jTextFieldRetailPrice);

        buttonPanel = new JPanel(new GridLayout(2, 2));
        buttonPanel.add(jButtonAdd);
        buttonPanel.add(jButtonNext);
        buttonPanel.add(jButtonSave);
        buttonPanel.add(jButtonShow);

        add(labelBanner, BorderLayout.NORTH);
        add(newPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add ActionListener for the Add button
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String model = jTextFieldModel.getText();
                    String manufacturer = jTextFieldManufacturer.getText();

                    // Check if retail price field is empty
                    if (jTextFieldRetailPrice.getText().isEmpty()) {
                        throw new InvalidRetailPriceException("Invalid Retail Price");
                    }

                    double price = Double.parseDouble(jTextFieldRetailPrice.getText());

                    // Validation for model, manufacturer, and retail price
                    if (model.isEmpty()) {
                        throw new InvalidModelException("Model cannot be empty.");
                    }
                    if (manufacturer.isEmpty()) {
                        throw new InvalidManufacturerException("Manufacturer cannot be empty.");
                    }
                    if (price < 0 || price > 1500) {
                        throw new InvalidRetailPriceException("Invalid Retail Price");
                    }

                    // Add the phone to the list if valid
                    phoneArrayList.add(new CellPhone(model, manufacturer, price));

                    // Display the inventory
                    String inventoryDisplay = "";
                    for (CellPhone p : phoneArrayList) {
                        inventoryDisplay += p + "\n";
                    }
                    JOptionPane.showMessageDialog(null, inventoryDisplay);

                } catch (InvalidModelException | InvalidManufacturerException | InvalidRetailPriceException ex) {
                    // Display error in pop-up window
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                    // Also log the error to the console
                    System.err.println("Error: " + ex.getMessage());
                } catch (NumberFormatException ex) {
                    // Display error for invalid number
                    JOptionPane.showMessageDialog(null, "Retail Price must be a valid number.", "Error", JOptionPane.ERROR_MESSAGE);

                    // Also log the error to the console
                    System.err.println("Error: Retail Price must be a valid number.");
                }
            }
        });

        // Add ActionListener for the Next button (clears text fields)
        jButtonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldModel.setText(null);
                jTextFieldManufacturer.setText(null);
                jTextFieldRetailPrice.setText(null);
            }
        });

        // Add ActionListener for the Save button (save inventory to a file)
        jButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Formatter outCellPhoneList = new Formatter("cellPhones.txt")) {
                    // Save all phone entries to the file
                    for (CellPhone phone : phoneArrayList) {
                        outCellPhoneList.format("%s %s %.2f\n", phone.getModel(),
                                phone.getManufacturer(),
                                phone.getRetailPrice());
                    }
                    JOptionPane.showMessageDialog(null, "Cellphone list saved.");
                } catch (FileNotFoundException fileNotFoundException) {
                    JOptionPane.showMessageDialog(null, "Error saving file: " + fileNotFoundException.getMessage());
                    System.err.println("Error saving file: " + fileNotFoundException.getMessage());
                }
            }
        });

        // Add ActionListener for the Show button (shows all phones saved in file)
        jButtonShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = String.format("%-20s%-20s%10s%n", "Model", "Manufacturer", "Retail Price");
                try (Scanner input = new Scanner(Paths.get("cellPhones.txt"))) {
                    // Read records from file and display them
                    while (input.hasNext()) {
                        msg += String.format("%-20s%-20s%10.2f%n", input.next(), input.next(), input.nextDouble());
                    }
                } catch (IOException | NoSuchElementException | IllegalStateException exception) {
                    JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage());
                    System.err.println("Error: " + exception.getMessage());
                }
                JOptionPane.showMessageDialog(null, msg);
            }
        });
    }
}
