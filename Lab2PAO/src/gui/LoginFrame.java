package gui;

import model.User;
import services.LoginServices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();

    private JLabel e1 = new JLabel("Username: ");
    private JTextField textField1 = new JTextField(10);
    private JLabel e2 = new JLabel("Password: ");
    private JPasswordField textField2 = new JPasswordField(10);
    private JButton loginButton = new JButton("Log In");

    public LoginFrame() {
        setLayout(new GridLayout(3, 1));


        add(p1);
        add(p2);
        add(p3);
        p1.add(e1);
        p1.add(textField1);
        p2.add(e2);
        p2.add(textField2);
        p3.add(loginButton);
        loginButton.addActionListener(ev -> login());  // echivalent cu ce genereaza IntelliJ
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void login() {
        String username = textField1.getText();
        String password = textField2.getText();

        User user = new User(username, password);

        LoginServices service = LoginServices.getInstance();

        if(service.login(user)) {
            JOptionPane.showMessageDialog(null, "Login reusit!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Login nereusit!");
        }
    }
}
