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

public class deposite {

    private JTextField textField;
    private String userName;
    private static JTextField textField_1;

    public deposite(String userName) {
        this.userName = userName;

        JFrame frame = new JFrame();
        frame.setSize(859, 600);
        frame.getContentPane().setBackground(new Color(220, 221, 225));
        frame.getContentPane().setLayout(null);

        JLabel lblEnterYourAmount = new JLabel("ENTER YOUR AMOUNT HERE");
        lblEnterYourAmount.setFont(new Font("Arial Narrow", Font.BOLD, 35));
        lblEnterYourAmount.setBounds(189, 134, 703, 40);
        frame.getContentPane().add(lblEnterYourAmount);

        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 21));
        textField.setForeground(Color.BLACK);
        textField.setBackground(Color.WHITE);
        textField.setBounds(248, 222, 346, 40);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        JButton depositButton = new JButton("DEPOSIT");
        depositButton.setForeground(Color.WHITE);
        depositButton.setBackground(new Color(19, 15, 64));
        depositButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        depositButton.setBounds(274, 427, 298, 40);
        frame.getContentPane().add(depositButton);

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

                    // Fetch current balance and update the amount using PreparedStatement
                    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Vbcd@123")) {

                        // Select the current balance for the user
                        String selectQuery = "SELECT Amount FROM user WHERE Username = ?";
                        PreparedStatement selectStmt = conn.prepareStatement(selectQuery);
                        selectStmt.setString(1, userName);
                        ResultSet rs = selectStmt.executeQuery();

                        if (rs.next()) {
                            double currentBalance = rs.getDouble("Amount");
                            double newBalance = currentBalance + amount;

                            // Update the user's balance
                            String updateQuery = "UPDATE user SET Amount = ? WHERE Username = ?";
                            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                            updateStmt.setDouble(1, newBalance);
                            updateStmt.setString(2, userName);
                            updateStmt.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Rs: " + amount + " Deposited successfully. New Balance: Rs " + newBalance);
                            frame.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "User not found!");
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

        cancelButton.addActionListener(e -> frame.dispose());

        JButton clearButton = new JButton("CLEAR");
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial Black", Font.BOLD, 18));
        clearButton.setBackground(new Color(19, 15, 64));
        clearButton.setBounds(211, 336, 128, 40);
        frame.getContentPane().add(clearButton);

        clearButton.addActionListener(e -> textField.setText(""));
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
        textField_1.setBounds(409, 63, 268, 37);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Enter User Name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(86, 63, 346, 40);
        frame.getContentPane().add(lblNewLabel);

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    	String uname=textField_1.getText();
        new deposite(uname);  
    }
}
