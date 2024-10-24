package Bank;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import UseDao.userInfo;
import UseDao.UserData;

public class MoneyTransfer extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JTextField textField_1;
    private JTextField textField_2;

   
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MoneyTransfer frame = new MoneyTransfer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   
    public MoneyTransfer() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 806, 598);
        contentPane = new JPanel();
        contentPane.setForeground(Color.BLACK);
        contentPane.setBackground(new Color(253, 245, 230));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        
        JLabel lblFrom = new JLabel("From:");
        lblFrom.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblFrom.setBounds(77, 200, 110, 24);
        contentPane.add(lblFrom);

        JLabel lblAccountNumber = new JLabel("Account Number:");
        lblAccountNumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblAccountNumber.setBounds(197, 234, 169, 24);
        contentPane.add(lblAccountNumber);

        textField = new JTextField();
        textField.setBounds(472, 224, 208, 34);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblUpiPin = new JLabel("UPI PIN:");
        lblUpiPin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblUpiPin.setBounds(197, 292, 169, 24);
        contentPane.add(lblUpiPin);

        passwordField = new JPasswordField();
        passwordField.setBounds(472, 282, 208, 34); 
        contentPane.add(passwordField);

        JLabel lblTo = new JLabel("To:");
        lblTo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblTo.setBounds(77, 407, 45, 13);
        contentPane.add(lblTo);

        JLabel lblMobileNumber1 = new JLabel("Account Number :");
        lblMobileNumber1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblMobileNumber1.setBounds(207, 457, 169, 24);
        contentPane.add(lblMobileNumber1);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(472, 447, 208, 34);
        contentPane.add(textField_1);

        JLabel lblImage = new JLabel("");
        lblImage.setIcon(new ImageIcon("C:\\Users\\vaibh\\OneDrive\\Desktop\\PicsOFProject\\new_logo-removebg-preview (1).png"));
        lblImage.setBounds(244, -45, 351, 188);
        contentPane.add(lblImage);

        JButton btnTransfer = new JButton("Transfer");
        btnTransfer.setBackground(new Color(0, 255, 0));
        btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnTransfer.setBounds(586, 527, 94, 24);
        contentPane.add(btnTransfer);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCancel.setBackground(new Color(255, 0, 0));
        btnCancel.setBounds(77, 527, 94, 24);
        contentPane.add(btnCancel);

        JLabel lblAmount = new JLabel("Amount:");
        lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblAmount.setBounds(197, 353, 169, 21);
        contentPane.add(lblAmount);

        textField_2 = new JTextField();
        textField_2.setBounds(472, 340, 208, 34);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JButton btnBack = new JButton("Back");
        btnBack.setBackground(new Color(255, 128, 128));
        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnBack.setBounds(10, 47, 61, 21);
        contentPane.add(btnBack);

        JPanel FooterPanel = new JPanel();
        FooterPanel.setBackground(Color.LIGHT_GRAY);
        FooterPanel.setSize(getWidth(), 40);
        FooterPanel.setLayout(null);
        contentPane.add(FooterPanel, BorderLayout.NORTH);

        JButton btnAccountNo = new JButton("Pay Ac No");
        btnAccountNo.setBounds(51, 10, 101, 21);
        FooterPanel.add(btnAccountNo);

        boolean selected = true;
        
        

        btnAccountNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selected) {
                    dispose();
                    MoneyTransfer.main(null);
                }
            }
        });

        JButton btnPhoneNo = new JButton("Pay Phn No");
        btnPhoneNo.setBounds(162, 10, 109, 21);
        FooterPanel.add(btnPhoneNo);

        btnPhoneNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selected) {
                    dispose();
                    MoneyTransfer.main(null);
                }
            }
        });

        JButton btnAdharNo = new JButton("Pay Adhar No");
        btnAdharNo.setBounds(281, 10, 109, 21);
        FooterPanel.add(btnAdharNo);

        btnAdharNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selected) {
                    dispose();
                    MonyTransferbyAdharNo.main(null);
                }
            }
        });

        JButton btnProfile = new JButton("Profile");
        btnProfile.setBackground(new Color(240, 240, 240));
        btnProfile.setForeground(Color.BLACK);
        btnProfile.setFont(new Font("Times New Roman", Font.BOLD, 12));
        btnProfile.setBounds(693, 10, 76, 21);
        FooterPanel.add(btnProfile);

        FooterPanel.setVisible(true);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                FooterPanel.setSize(getWidth(), 40);
            }
        });

        UserData data=new userInfo();
        btnTransfer.addActionListener(new ActionListener() {
        	UserData data=new userInfo();
            @Override
            public void actionPerformed(ActionEvent e) {
            	String senderAccount="50405100260"+textField.getText();
            	String receiverAccount="50405100260"+textField_1.getText();
            	double amountToTransfer=Double.parseDouble(textField_2.getText());
            	String password=passwordField.getText();
            	data.transferMoney(senderAccount, receiverAccount,password,amountToTransfer);
            	LocalDateTime now = LocalDateTime.now();
                Timestamp timestamp = Timestamp.valueOf(now);
            	data.addTransactionHostry(senderAccount,receiverAccount,amountToTransfer,timestamp);
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current frame
            }
        });
    }
}





//package Bank;
//
//import java.awt.EventQueue;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Font;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JPasswordField;
//import javax.swing.JButton;
//import javax.swing.ImageIcon;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.ComponentAdapter;
//import java.awt.event.ComponentEvent;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import javax.swing.JOptionPane;
//import UseDao.userInfo;
//import UseDao.UserData;
//
//public class MoneyTransfer extends JFrame {
//
//    private static final long serialVersionUID = 1L;
//    private JPanel contentPane;
//    private JTextField textField;
//    private JPasswordField passwordField;
//    private JTextField textField_1;
//    private JTextField textField_2;
//
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    MoneyTransfer frame = new MoneyTransfer();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//    public MoneyTransfer() {
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        setBounds(100, 100, 806, 598);
//        contentPane = new JPanel();
//        contentPane.setForeground(Color.BLACK);
//        contentPane.setBackground(new Color(253, 245, 230));
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//        setContentPane(contentPane);
//        contentPane.setLayout(null);
//
//        JLabel lblFrom = new JLabel("From:");
//        lblFrom.setFont(new Font("Times New Roman", Font.BOLD, 20));
//        lblFrom.setBounds(77, 200, 110, 24);
//        contentPane.add(lblFrom);
//
//        JLabel lblAccountNumber = new JLabel("Account Number:");
//        lblAccountNumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//        lblAccountNumber.setBounds(197, 234, 169, 24);
//        contentPane.add(lblAccountNumber);
//
//        textField = new JTextField();
//        textField.setBounds(472, 224, 208, 34);
//        contentPane.add(textField);
//        textField.setColumns(10);
//
//        JLabel lblUpiPin = new JLabel("UPI PIN:");
//        lblUpiPin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//        lblUpiPin.setBounds(197, 292, 169, 24);
//        contentPane.add(lblUpiPin);
//
//        passwordField = new JPasswordField();
//        passwordField.setBounds(472, 282, 208, 34);
//        contentPane.add(passwordField);
//
//        JLabel lblTo = new JLabel("To:");
//        lblTo.setFont(new Font("Times New Roman", Font.BOLD, 20));
//        lblTo.setBounds(77, 407, 45, 13);
//        contentPane.add(lblTo);
//
//        JLabel lblMobileNumber1 = new JLabel("Account Number :");
//        lblMobileNumber1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//        lblMobileNumber1.setBounds(207, 457, 169, 24);
//        contentPane.add(lblMobileNumber1);
//
//        textField_1 = new JTextField();
//        textField_1.setColumns(10);
//        textField_1.setBounds(472, 447, 208, 34);
//        contentPane.add(textField_1);
//
//        JLabel lblImage = new JLabel("");
//        lblImage.setIcon(new ImageIcon("C:\\Users\\vaibh\\OneDrive\\Desktop\\PicsOFProject\\new_logo-removebg-preview (1).png"));
//        lblImage.setBounds(244, -45, 351, 188);
//        contentPane.add(lblImage);
//
//        JButton btnTransfer = new JButton("Transfer");
//        btnTransfer.setBackground(new Color(0, 255, 0));
//        btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 12));
//        btnTransfer.setBounds(586, 527, 94, 24);
//        contentPane.add(btnTransfer);
//
//        JButton btnCancel = new JButton("Cancel");
//        btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
//        btnCancel.setBackground(new Color(255, 0, 0));
//        btnCancel.setBounds(77, 527, 94, 24);
//        contentPane.add(btnCancel);
//
//        JLabel lblAmount = new JLabel("Amount:");
//        lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 20));
//        lblAmount.setBounds(197, 353, 169, 21);
//        contentPane.add(lblAmount);
//
//        textField_2 = new JTextField();
//        textField_2.setBounds(472, 340, 208, 34);
//        contentPane.add(textField_2);
//        textField_2.setColumns(10);
//
//        JButton btnBack = new JButton("Back");
//        btnBack.setBackground(new Color(255, 128, 128));
//        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 12));
//        btnBack.setBounds(10, 47, 61, 21);
//        contentPane.add(btnBack);
//
//        JPanel FooterPanel = new JPanel();
//        FooterPanel.setBackground(Color.LIGHT_GRAY);
//        FooterPanel.setSize(getWidth(), 40);
//        FooterPanel.setLayout(null);
//        contentPane.add(FooterPanel, BorderLayout.NORTH);
//
//        JButton btnAccountNo = new JButton("Pay Ac No");
//        btnAccountNo.setBounds(51, 10, 101, 21);
//        FooterPanel.add(btnAccountNo);
//
//        boolean selected = true;
//
//        btnAccountNo.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (selected) {
//                    dispose();
//                    MoneyTransfer.main(null);
//                }
//            }
//        });
//
//        JButton btnPhoneNo = new JButton("Pay Phn No");
//        btnPhoneNo.setBounds(162, 10, 109, 21);
//        FooterPanel.add(btnPhoneNo);
//
//        btnPhoneNo.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (selected) {
//                    dispose();
//                    MoneyTransfer.main(null);
//                }
//            }
//        });
//
//        JButton btnAdharNo = new JButton("Pay Adhar No");
//        btnAdharNo.setBounds(281, 10, 109, 21);
//        FooterPanel.add(btnAdharNo);
//
//        btnAdharNo.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (selected) {
//                    dispose();
//                    MonyTransferbyAdharNo.main(null);
//                }
//            }
//        });
//
//        JButton btnProfile = new JButton("Profile");
//        btnProfile.setBackground(new Color(240, 240, 240));
//        btnProfile.setForeground(Color.BLACK);
//        btnProfile.setFont(new Font("Times New Roman", Font.BOLD, 12));
//        btnProfile.setBounds(693, 10, 76, 21);
//        FooterPanel.add(btnProfile);
//
//        FooterPanel.setVisible(true);
//        addComponentListener(new ComponentAdapter() {
//            @Override
//            public void componentResized(ComponentEvent e) {
//                FooterPanel.setSize(getWidth(), 40);
//            }
//        });
//
//        UserData data = new userInfo();
//        btnTransfer.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            	String senderAccount="50405100260"+textField.getText();
//            	String receiverAccount="50405100260"+textField_1.getText();
//            	double amountToTransfer=Double.parseDouble(textField_2.getText());
//            	String password=passwordField.getText();
//               
//                if (!isValidAmount(textField_2.getText())) {
//                    JOptionPane.showMessageDialog(contentPane, "Invalid Amount. Please enter a positive number.", "Error", JOptionPane.ERROR_MESSAGE);
//                    return;
//                }
//
//                amountToTransfer = Double.parseDouble(textField_2.getText());
//
//                data.transferMoney(senderAccount, receiverAccount,password, amountToTransfer);
//
//                LocalDateTime now = LocalDateTime.now();
//                Timestamp timestamp = Timestamp.valueOf(now);
//                data.addTransactionHostry(senderAccount, receiverAccount, amountToTransfer, timestamp);
//            }
//        });
//
//        btnCancel.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//            }
//        });
//
//        btnBack.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                dispose();
//            }
//        });
//    }
//
//    private boolean isValidAmount(String amount) {
//        try {
//            double value = Double.parseDouble(amount);
//            return value > 0;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
//}
