package Bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class withdraw {

    private JTextField textField;
    private String userName;
    private String password;
    private JTextField textFieldUserName;
    private JTextField textFieldPassword;

    public withdraw() {

        JFrame frame = new JFrame();
        frame.setSize(859, 600);
        frame.getContentPane().setBackground(new Color(220, 221, 225));
        frame.getContentPane().setLayout(null);

        JLabel lblEnterYourAmount = new JLabel("ENTER YOUR AMOUNT HERE");
        lblEnterYourAmount.setFont(new Font("Arial Narrow", Font.BOLD, 30));
        lblEnterYourAmount.setBounds(211, 163, 547, 40);
        frame.getContentPane().add(lblEnterYourAmount);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 21));
        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.WHITE);
        textField.setBounds(211, 226, 346, 40);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textFieldUserName = new JTextField();
        textFieldUserName.setBounds(319, 53, 268, 37);
        frame.getContentPane().add(textFieldUserName);
        textFieldUserName.setColumns(10);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(319, 100, 268, 37);
        frame.getContentPane().add(textFieldPassword);
        textFieldPassword.setColumns(10);

        JLabel lblUserName = new JLabel("Enter User Name :");
        lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblUserName.setBounds(64, 53, 346, 40);
        frame.getContentPane().add(lblUserName);

        JLabel lblPassword = new JLabel("Enter Password :");
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblPassword.setBounds(64, 100, 346, 40);
        frame.getContentPane().add(lblPassword);

        JButton withdrawButton = new JButton("WITHDRAW");
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.setBackground(new Color(19, 15, 64));
        withdrawButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        withdrawButton.setBounds(246, 427, 298, 40);
        frame.getContentPane().add(withdrawButton);

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userName = textFieldUserName.getText();
                password = textFieldPassword.getText();

                if (userName.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both username and password.");
                    return;
                }

                try {
                    String amountStr = textField.getText();
                    if (amountStr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Fill the amount");
                        return;
                    }

                    double amount = Double.parseDouble(amountStr);
                    if (amount <= 0) {
                        JOptionPane.showMessageDialog(null, "Amount must be greater than zero");
                        return;
                    }

                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Vbcd@123")) {

                        String selectQuery = "SELECT Amount FROM user WHERE Username = ? AND Password = ?";
                        PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
                        selectStmt.setString(1, userName);
                        selectStmt.setString(2, password);
                        ResultSet rs = selectStmt.executeQuery();

                        if (rs.next()) {
                            double currentBalance = rs.getDouble("Amount");
                            if (amount > currentBalance) {
                                JOptionPane.showMessageDialog(null, "Insufficient funds!");
                                return;
                            }

                            double newBalance = currentBalance - amount;

                            String updateQuery = "UPDATE user SET Amount = ? WHERE Username = ? AND Password = ?";
                            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                            updateStmt.setDouble(1, newBalance);
                            updateStmt.setString(2, userName);
                            updateStmt.setString(3, password);
                            updateStmt.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Rs: " + amount + " withdrawn successfully. New Balance: Rs " + newBalance);
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "User not found or incorrect credentials!");
                        }

                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
                }
            }
        });

        JButton cancelButton = new JButton("CANCEL");
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBackground(new Color(19, 15, 64));
        cancelButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        cancelButton.setBounds(515, 336, 128, 40);
        frame.getContentPane().add(cancelButton);

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JButton clearButton = new JButton("CLEAR");
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        clearButton.setBackground(new Color(19, 15, 64));
        clearButton.setBounds(156, 336, 128, 40);
        frame.getContentPane().add(clearButton);

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new withdraw();
    }
}
