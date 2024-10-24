package Bank;
import javax.swing.*;
import java.awt.*;

public class AboutSection extends JFrame {

    private JTextArea infoArea; 

    public AboutSection() {
        setTitle("Banking Management System");
        setSize(851, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel aboutPanel = AboutSection();
        JPanel settingsPanel = SettingsSection();

        tabbedPane.addTab("About", aboutPanel);
        tabbedPane.addTab("Settings", settingsPanel);

        getContentPane().add(tabbedPane);
    }

    private JPanel AboutSection() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        String aboutText = "Bank Management System for managing customer accounts, transactions, etc.\n\n" +
                " -Developer Credits:\n  Developed by: Vaibhav Chougule, Gurudas Bhosale, Vedant Chougule, Ravsaheb Bansode\n\n" +
                " -Version Information:\n  Version 1.0\n\n" +
                " -License Information:\n  Licensed under SBI License.\n\n" +
                " -Contact Information:\n  Contact support at: bankofjaysingpur@boj.com";

        JTextArea aboutArea = new JTextArea(aboutText);
        aboutArea.setEditable(false);  
        aboutArea.setLineWrap(true);   
        aboutArea.setWrapStyleWord(true);  

        JScrollPane scrollPane = new JScrollPane(aboutArea); 
        scrollPane.setPreferredSize(new Dimension(480, 380));

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private JPanel SettingsSection() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel();  // Panel for buttons
        buttonPanel.setLayout(new FlowLayout());

        JButton notificationBtn = new JButton("Notification & emails");
        notificationBtn.addActionListener(e -> showNotificationInfo());

        JButton privacySecurityBtn = new JButton("Privacy & Security");
        privacySecurityBtn.addActionListener(e -> showPrivacyInfo());

        JButton feedback = new JButton("Help & Feedback");
        feedback.addActionListener(e -> showFeedbackInfo());

        JButton signout = new JButton("Sign Out");
        signout.addActionListener(e -> showSignOutInfo());

        buttonPanel.add(notificationBtn);
        buttonPanel.add(privacySecurityBtn);
        buttonPanel.add(feedback);
        buttonPanel.add(signout);

        infoArea = new JTextArea();
        infoArea.setEditable(false);  // Users shouldn't edit this
        infoArea.setLineWrap(true);
        infoArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(infoArea);
        scrollPane.setPreferredSize(new Dimension(480, 300));

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void showNotificationInfo() {
        String notificationText = "Manage your notifications:\n" +
                "- Email notifications\n" +
                "- SMS alerts\n" +
                "- Push notifications\n\n" +
                "Please adjust your settings as per your preference.";
        infoArea.setText(notificationText); 
    }

    private void showPrivacyInfo() {
        String privacyText = "Privacy & Security settings:\n" +
                "You can update your password and manage two-factor authentication.";
        infoArea.setText(privacyText);
    }

    private void showFeedbackInfo() {
        String feedbackText = "Help & Feedback:\n\n" +
                "For help with using the Banking Management System, follow these steps:\n" +
                "1. Visit our support page at: support.bankingms.com\n" +
                "2. Contact our customer service at: +1-800-123-4567\n\n" +
                "To provide feedback:\n" +
                " - Email your feedback to: bankofjaysingpu@boj.com\n" +
                " - Fill out the feedback form on our website.";
        infoArea.setText(feedbackText); 
    }

    private void showSignOutInfo() {
        String signOutText = "You have signed out successfully.";
        infoArea.setText(signOutText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	AboutSection bankingSystem = new AboutSection();
            bankingSystem.setVisible(true);
        });
    }
}