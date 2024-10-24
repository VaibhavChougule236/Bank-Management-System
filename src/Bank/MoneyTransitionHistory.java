//package Bank;
//
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.awt.*;
//import java.sql.*;
//import UseDao.user;
//
//public class MoneyTransitionHistory {
//    
//    private String userAccNo;
//
//    public MoneyTransitionHistory(String userAccNo) {
//        this.userAccNo = userAccNo;
//    }
//
//    public void displayTransactionHistory() {
//        JFrame frame = new JFrame("Money Transaction History");
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setSize(800, 400);
//
//        DefaultTableModel model = new DefaultTableModel();
//        model.setColumnIdentifiers(new String[]{"Transaction ID", "User/Sender AccNo", "Receiver AccNo", "Amount", "Date/Time"});
//
//        JTable table = new JTable(model);
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//        JScrollPane scrollPane = new JScrollPane(table);
//        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//
//        try {
//            
//            conn = user.getConnection(); 
//            System.out.println("Connected to the database successfully!");
//
//            String sql = "SELECT Transaction_id, senderAccNo, ReceiverAccNo, Amount, Date_Time FROM money_transition_history WHERE senderAccNo = ?";
//      
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, "50405100260"+userAccNo); 
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                int transactionId = rs.getInt("Transaction_id");
//                String senderId = rs.getString("senderAccNo");
//                String receiverId = rs.getString("ReceiverAccNo");
//                double amount = rs.getDouble("Amount");
//                Timestamp dateTime = rs.getTimestamp("Date_Time");
//
//                model.addRow(new Object[]{transactionId, senderId, receiverId, amount, dateTime});
//            }
//
//            rs.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(frame, "Error fetching data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        } finally {
//            try {
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//        frame.setVisible(true);
//    }
//}


package Bank;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import UseDao.user;

public class MoneyTransitionHistory {

    private String userAccNo;

    public MoneyTransitionHistory(String userAccNo) {
        this.userAccNo = userAccNo;
    }

    public void displayTransactionHistory() {
        JFrame frame = new JFrame("Money Transaction History");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 400);

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Transaction ID", "Sender Name", "User/Sender AccNo", "Receiver Name", "Receiver AccNo", "Amount", "Date/Time"});

        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = user.getConnection();
            String sql = "SELECT Transaction_id, Sender_Name, senderAccNo, Receiver_Name, ReceiverAccNo, Amount, Date_Time FROM money_transition_history WHERE senderAccNo = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "50405100260" + userAccNo); 
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int transactionId = rs.getInt("Transaction_id");
                String senderName = rs.getString("Sender_Name");
                String senderId = rs.getString("senderAccNo");
                String receiverName = rs.getString("Receiver_Name");
                String receiverId = rs.getString("ReceiverAccNo");
                double amount = rs.getDouble("Amount");
                Timestamp dateTime = rs.getTimestamp("Date_Time");

                model.addRow(new Object[]{transactionId, senderName, senderId, receiverName, receiverId, amount, dateTime});
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error fetching data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        frame.setVisible(true);
    }
}
