import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateLoginForm extends JFrame implements ActionListener {
    private JButton jButtonSubmit, jButtonExit, jButtonCreateAccount;
    private JTextField textField1, textField2;

    public CreateLoginForm() {
        setTitle("Lab 5 Login Window");
        setLayout(new BorderLayout());

        JLabel infoLabel = new JLabel(new ImageIcon(getClass().getResource("user-login-305.png")));
        add(infoLabel, BorderLayout.NORTH);

        JPanel newPanel = new JPanel(new GridLayout(4, 1));
        newPanel.add(new JLabel("Username: "));
        textField1 = new JTextField(15);
        newPanel.add(textField1);

        newPanel.add(new JLabel("Password: "));
        textField2 = new JPasswordField(15);
        newPanel.add(textField2);

        jButtonSubmit = new JButton("SUBMIT");
        jButtonExit = new JButton("EXIT");
        newPanel.add(jButtonSubmit);
        newPanel.add(jButtonExit);

        add(newPanel, BorderLayout.CENTER);

        jButtonCreateAccount = new JButton("Create an Account");
        add(jButtonCreateAccount, BorderLayout.SOUTH);

        jButtonSubmit.addActionListener(this);
        jButtonExit.addActionListener(e -> System.exit(0));
        jButtonCreateAccount.addActionListener(e -> {
            CreateAccount createAccountForm = new CreateAccount();
            createAccountForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            createAccountForm.setSize(300, 220);
            createAccountForm.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = textField1.getText();
        String password = textField2.getText();
        boolean authenticated = false;

        try (Scanner scanner = new Scanner(new File("users.txt"))) {
            while (scanner.hasNextLine()) {
                String[] credentials = scanner.nextLine().split(" ");
                if (credentials[0].equals(username) && credentials[1].equals(password)) {
                    authenticated = true;
                    break;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading users.txt file.", "File Error", JOptionPane.ERROR_MESSAGE);
        }

        if (authenticated) {
            CellPhoneInventory inventory = new CellPhoneInventory();
            inventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            inventory.setSize(400, 300);
            inventory.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        CreateLoginForm loginForm = new CreateLoginForm();
        loginForm.setSize(320, 240);
        loginForm.setVisible(true);
    }
}
