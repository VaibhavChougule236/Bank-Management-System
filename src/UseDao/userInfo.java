package UseDao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class userInfo implements UserData {
	public boolean checkUser(String userName, String password) {
	    String query = "SELECT * FROM user WHERE UserName = ? AND Password = ?;";
	    try (Connection connection = user.getConnection();
	         PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setString(1, userName);
	        statement.setString(2, password);
	        ResultSet result = statement.executeQuery();
	        return result.next(); // Returns true if a record is found
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	public void DeletUser(String userName, String password) {
		String query = "DELETE FROM user WHERE UserName = ? AND Password = ?";
	    try (Connection connection = user.getConnection();
	         PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setString(1, userName);
	        statement.setString(2, password);
	        int ans=JOptionPane.showConfirmDialog(null, "You really want to delete account from bank .. ?");
	        if(ans==JOptionPane.YES_OPTION) {
	        int result = statement.executeUpdate();
            if(result>0) {
	        	JOptionPane.showMessageDialog(null, "Account deleted Succssesfully..");
	        }else {
	        	JOptionPane.showMessageDialog(null, "Please Try Again ..");
	        }
	        }
	        
	     }catch (SQLException e) {
           e.printStackTrace();
         }
     }
	public void insertUser(String name, String mail, String Address, String Gender, String MobNo, String city,
			String state, int pincode, String Qualification, String AccNo, String UserName, String Password,
			String Religion, String category, String category2, int Income, String PAN, String Occupation,
			String Adhar,Timestamp currentTimestamp) {
		String query = "INSERT INTO user(UName, E_mail, Address, Gender, Mobile_No, City, State, Pincode, Qualification,AccNo, Username, Password, Religion, Category, Income, PAN_NO, Occupation, Adhar_Number,AccountCreated) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	    try (Connection connection = user.getConnection()) {
	        PreparedStatement statement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
	        statement.setString(1, name);
	        statement.setString(2, mail);
	        statement.setString(3, Address);
	        statement.setString(4, Gender);
	        statement.setString(5, MobNo);  
	        statement.setString(6, city);
	        statement.setString(7, state);
	        statement.setInt(8, pincode);
	        statement.setString(9, Qualification);
	        statement.setString(10,AccNo);
	        statement.setString(11, UserName);
	        statement.setString(12, Password);
	        statement.setString(13, Religion);
	        statement.setString(14, category);
	        statement.setInt(15, Income);
	        statement.setString(16, PAN);
	        statement.setString(17, Occupation);
	        statement.setString(18, Adhar);
	        statement.setTimestamp(19, currentTimestamp);

	        int affectedRows = statement.executeUpdate();
	        if (affectedRows > 0) {
	            JOptionPane.showMessageDialog(null, "Account Created Successfully...");
	            
	        } else {
	            JOptionPane.showMessageDialog(null, "Failed to Create Account. Please Try Again Later...");
	        }
	    } catch (SQLIntegrityConstraintViolationException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Duplicate entry. Please check your data.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Failed to Create Account. Please Try Again Later...");
	    }

	    String updateQuery = "UPDATE user SET BankId = ? WHERE SR_NO IS NOT NULL";

	    try (Connection connection = user.getConnection(); 
	         PreparedStatement statement = connection.prepareStatement(updateQuery)) {
	        statement.setString(1, "BOJP01");
	        int rowsUpdated = statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
	}
	
	public void uploadFile(String username, String password, String photoPath, String panCardPath, String adharCardPath) {
		String sql = "INSERT INTO documents (Username, Password, Photo, PanCard, AdharCard) VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = user.getConnection();
	             PreparedStatement statement = connection.prepareStatement(sql);
	             FileInputStream photoStream = new FileInputStream(new File(photoPath));
	             FileInputStream panCardStream = new FileInputStream(new File(panCardPath));
	             FileInputStream adharCardStream = new FileInputStream(new File(adharCardPath))) {

		            statement.setString(1, username);
		            statement.setString(2, password);
		            
		            // Set the binary stream for each file
		            statement.setBinaryStream(3, photoStream, (int) new File(photoPath).length());
		            statement.setBinaryStream(4, panCardStream, (int) new File(panCardPath).length());
		            statement.setBinaryStream(5, adharCardStream, (int) new File(adharCardPath).length());

		            int rowsInserted = statement.executeUpdate();
		            if (rowsInserted > 0) {
		                System.out.println("Files uploaded successfully!");
		            }

		        } catch (SQLException | IOException ex) {
		            ex.printStackTrace();
		        }
	}
	
	public  BufferedImage getPhoto(String username) {
        String sql = "SELECT Photo FROM documents WHERE Username = ?";
        BufferedImage img = null;

        try (Connection conn = user.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                byte[] imageBytes = rs.getBytes("Photo");
                try (InputStream is = new ByteArrayInputStream(imageBytes)) {
                    img = ImageIO.read(is);
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error while reading the image: " + e.getMessage());
            e.printStackTrace();
        }

        return img;
    }

	public static BufferedImage getAdhar(String username) {
        String sql = "SELECT Adhar FROM documents WHERE Username = ?";
        BufferedImage img = null;

        try (Connection conn = user.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                byte[] imageBytes = rs.getBytes("Adhar");
                try (InputStream is = new ByteArrayInputStream(imageBytes)) {
                    img = ImageIO.read(is);
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error while reading the image: " + e.getMessage());
            e.printStackTrace();
        }

        return img;
    }
	
	public static BufferedImage getPan(String username) {
        String sql = "SELECT PanCard FROM documents WHERE Username = ?";
        BufferedImage img = null;

        try (Connection conn = user.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                byte[] imageBytes = rs.getBytes("PanCard");
                try (InputStream is = new ByteArrayInputStream(imageBytes)) {
                    img = ImageIO.read(is);
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error while reading the image: " + e.getMessage());
            e.printStackTrace();
        }

        return img;
    }
	
	public void addTransactionHostry(String senderAccNo, String RecieverAccNo, double amount, Timestamp dateTime) {
		    String fetchNameQuery = "SELECT UName FROM user WHERE AccNo = ?";
	    String insertQuery = "INSERT INTO money_transition_history (Sender_Name, SenderAccNo, Receiver_Name, ReceiverAccNo, Amount, Date_Time) VALUES (?,?,?,?,?,?)";

	    String senderName = null;
	    String receiverName = null;

	    try (Connection connection = user.getConnection()) {
	        
	        try (PreparedStatement fetchSenderNameStmt = connection.prepareStatement(fetchNameQuery)) {
	            fetchSenderNameStmt.setString(1, senderAccNo);
	            try (ResultSet rs = fetchSenderNameStmt.executeQuery()) {
	                if (rs.next()) {
	                    senderName = rs.getString("UName");
	                } else {
	                    System.out.println("Sender account not found!");
	                    return;
	                }
	            }
	        }

	        try (PreparedStatement fetchReceiverNameStmt = connection.prepareStatement(fetchNameQuery)) {
	            fetchReceiverNameStmt.setString(1, RecieverAccNo);
	            try (ResultSet rs = fetchReceiverNameStmt.executeQuery()) {
	                if (rs.next()) {
	                    receiverName = rs.getString("UName");
	                } else {
	                    System.out.println("Receiver account not found!");
	                    return;
	                }
	            }
	        }

	        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
	            insertStmt.setString(1, senderName);
	            insertStmt.setString(2, senderAccNo);
	            insertStmt.setString(3, receiverName);
	            insertStmt.setString(4, RecieverAccNo);
	            insertStmt.setDouble(5, amount);
	            insertStmt.setTimestamp(6, dateTime);

	            int rowsInserted = insertStmt.executeUpdate();
	            if (rowsInserted > 0) {
	                System.out.println("A new transaction inserted successfully.");
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	
	
	public void updateAcc(String name, String mail, String Address, String Gender, String MobNo, String city, String state, int pincode, String Qualification, String UserName, String Password, String Religion, String category, int Income,Timestamp dateAndTime) {
	    String sql = "UPDATE user SET UName = ?, E_mail = ?, Address = ?, Gender = ?, Mobile_No = ?, City = ?, State = ?, Pincode = ?, Qualification = ?, Religion = ?, Category = ?, Income = ? , AccountUpdated= ?  WHERE Username = ? AND Password = ?";

	    try (Connection connection = user.getConnection()) {
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1, name);
	        statement.setString(2, mail);
	        statement.setString(3, Address);
	        statement.setString(4, Gender);
	        statement.setString(5, MobNo);  
	        statement.setString(6, city);
	        statement.setString(7, state);
	        statement.setInt(8, pincode);
	        statement.setString(9, Qualification);
	        statement.setString(10, Religion);  
	        statement.setString(11, category); 
	        statement.setInt(12, Income);  
	        statement.setTimestamp(13, dateAndTime);
	        statement.setString(14, UserName); 
	        statement.setString(15, Password); 

	        int affectedRows = statement.executeUpdate();
	        if (affectedRows > 0) {
	            JOptionPane.showMessageDialog(null, "Account Updated Successfully...");
	        } else {
	            JOptionPane.showMessageDialog(null, "Failed to Update Account. Please Try Again Later...");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	public double myBalance(String UserName, String password) {
	    String query = "SELECT Amount FROM user WHERE Username = ? AND Password = ?";
	    
	    try (Connection conn = user.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(query)) {

	        stmt.setString(1, UserName);
	        stmt.setString(2, password);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                return rs.getDouble("Amount");
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();  
	    }
	    
	    return 0.0;  
	}
	
	public boolean transferMoney(String senderAccount, String receiverAccount ,String password, double amountToTransfer) {
	    Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    boolean transferSuccess = false;

	    try {
	        connection = user.getConnection();

	        connection.setAutoCommit(false);

	        String validateAccountsQuery = "SELECT AccNo, BankId FROM user WHERE AccNo = ?";
	        ps = connection.prepareStatement(validateAccountsQuery);

	        ps.setString(1, senderAccount);
	        rs = ps.executeQuery();

	        String senderBankID = null;
	        if (rs.next()) {
	            senderBankID = rs.getString("BankId");
	        } else {
                JOptionPane.showMessageDialog(null,"Sender account not found.");
	            return false;
	        }

	        ps.setString(1, receiverAccount);
	        rs = ps.executeQuery();

	        String receiverBankID = null;
	        if (rs.next()) {
	            receiverBankID = rs.getString("BankId");
	        } else {
	        	JOptionPane.showMessageDialog(null,"Reciever account not found.");
	            return false;
	        }

	        if (!senderBankID.equals(receiverBankID)) {
	            //System.out.println("Sender and receiver are not in the same bank.");
	            JOptionPane.showMessageDialog(null,"Sender and receiver are not in the same bank.");
	            return false;
	        }

	        String fetchBalanceQuery = "SELECT Amount FROM user WHERE AccNo = ?";
	        ps = connection.prepareStatement(fetchBalanceQuery);
	        ps.setString(1, senderAccount);
	        rs = ps.executeQuery();

	        double senderBalance = 0;
	        if (rs.next()) {
	            senderBalance = rs.getDouble("Amount");
	        }

	        if (senderBalance >= (amountToTransfer+500.0)) {
	            String deductMoneyQuery = "UPDATE user SET Amount = Amount - ? WHERE AccNo = ?";
	            ps = connection.prepareStatement(deductMoneyQuery);
	            ps.setDouble(1, amountToTransfer);
	            ps.setString(2, senderAccount);
	            ps.executeUpdate();

	            String addMoneyQuery = "UPDATE user SET Amount = Amount + ? WHERE AccNo = ?";
	            ps = connection.prepareStatement(addMoneyQuery);
	            ps.setDouble(1, amountToTransfer);
	            ps.setString(2, receiverAccount);
	            ps.executeUpdate();

	            connection.commit();
	            transferSuccess = true;
	            JOptionPane.showMessageDialog(null,"Amount Rs : "+ amountToTransfer +" Transferred Successfully..");
	        } else {
	            System.out.println("Insufficient balance in sender's account.");
	            JOptionPane.showMessageDialog(null,"Insufficient balance in sender's account.");

	            
	        }

	    } catch (SQLException e) {
	        if (connection != null) {
	            try {
	                connection.rollback(); 
	            } catch (SQLException rollbackException) {
	                rollbackException.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (connection != null) {
	                connection.setAutoCommit(true);  
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return transferSuccess;
	}
	
	public boolean transferMoneyByAadhaar(String senderAadhaar, String receiverAadhaar,String password , double amountToTransfer) {
	    Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    boolean transferSuccess = false;

	    try {
	        connection = user.getConnection();  

	        connection.setAutoCommit(false); 
	       
	        String validateAadhaarQuery = "SELECT Adhar_Number, BankId, Amount FROM user WHERE Adhar_Number = ?";
	        ps = connection.prepareStatement(validateAadhaarQuery);

	        ps.setString(1, senderAadhaar);
	        rs = ps.executeQuery();

	        String senderBankID = null;
	        double senderBalance = 0;
	        if (rs.next()) {
	            senderBankID = rs.getString("BankId");
	            senderBalance = rs.getDouble("Amount");
	        } else {
	            JOptionPane.showMessageDialog(null, "Sender Aadhaar not found.");
	            return false;
	        }

	        ps.setString(1, receiverAadhaar);
	        rs = ps.executeQuery();

	        String receiverBankID = null;
	        if (rs.next()) {
	            receiverBankID = rs.getString("BankId");
	        } else {
	            JOptionPane.showMessageDialog(null, "Receiver Aadhaar not found.");
	            return false;
	        }

	        if (!senderBankID.equals(receiverBankID)) {
	            JOptionPane.showMessageDialog(null, "Sender and receiver are not in the same bank.");
	            return false;
	        }

	        if (senderBalance >= (amountToTransfer + 500.0)) {  
	            String deductMoneyQuery = "UPDATE user SET Amount = Amount - ? WHERE Adhar_Number = ?";
	            ps = connection.prepareStatement(deductMoneyQuery);
	            ps.setDouble(1, amountToTransfer);
	            ps.setString(2, senderAadhaar);
	            ps.executeUpdate();

	            String addMoneyQuery = "UPDATE user SET Amount = Amount + ? WHERE Adhar_Number = ?";
	            ps = connection.prepareStatement(addMoneyQuery);
	            ps.setDouble(1, amountToTransfer);
	            ps.setString(2, receiverAadhaar);
	            ps.executeUpdate();

	            connection.commit();
	            transferSuccess = true;
	            JOptionPane.showMessageDialog(null, "Amount Rs : " + amountToTransfer + " Transferred Successfully.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Insufficient balance in sender's account.");
	        }

	    } catch (SQLException e) {
	        if (connection != null) {
	            try {
	                connection.rollback();
	            } catch (SQLException rollbackException) {
	                rollbackException.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	    } finally {
	        
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (connection != null) {
	                connection.setAutoCommit(true);  
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return transferSuccess;
	}


	public boolean transferMoneybyPhoneNo(String senderPhnNo, String receiverPhnNo,String password , double amountToTransfer){
	    Connection connection = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    boolean transferSuccess = false;

	    try {
	        connection = user.getConnection();  // Assuming user class has the method for DB connection

	        connection.setAutoCommit(false);  // Turn off auto-commit

	        // Validate sender and receiver by phone numbers
	        String validatePhoneQuery = "SELECT Mobile_No, BankId, Amount FROM user WHERE Mobile_No = ? AND Password = ?";
	        ps = connection.prepareStatement(validatePhoneQuery);

	        // Validate sender
	        ps.setString(1, senderPhnNo);
	        ps.setString(2, password);
	        rs = ps.executeQuery();

	        String senderBankID = null;
	        double senderBalance = 0;
	        if (rs.next()) {
	            senderBankID = rs.getString("BankId");
	            senderBalance = rs.getDouble("Amount");
	        } else {
	            JOptionPane.showMessageDialog(null, "Sender phone number not found.");
	            return false;
	        }

	        // Validate receiver
	        ps.setString(1, receiverPhnNo);
	        rs = ps.executeQuery();

	        String receiverBankID = null;
	        if (rs.next()) {
	            receiverBankID = rs.getString("BankId");
	        } else {
	            JOptionPane.showMessageDialog(null, "Receiver phone number not found.");
	            return false;
	        }

	        // Check if sender and receiver are in the same bank
	        if (!senderBankID.equals(receiverBankID)) {
	            JOptionPane.showMessageDialog(null, "Sender and receiver are not in the same bank.");
	            return false;
	        }

	        // Check if sender has enough balance
	        if (senderBalance >= (amountToTransfer + 500.0)) {  // Assuming 500 is the minimum balance requirement

	            // Deduct money from sender
	            String deductMoneyQuery = "UPDATE user SET Amount = Amount - ? WHERE Mobile_No = ? AND Password=?";
	            ps = connection.prepareStatement(deductMoneyQuery);
	            ps.setDouble(1, amountToTransfer);
	            ps.setString(2, senderPhnNo);
	            ps.executeUpdate();

	            // Add money to receiver
	            String addMoneyQuery = "UPDATE user SET Amount = Amount + ? WHERE PhoneNumber = ?";
	            ps = connection.prepareStatement(addMoneyQuery);
	            ps.setDouble(1, amountToTransfer);
	            ps.setString(2, receiverPhnNo);
		        ps.setString(2, password);
	            ps.executeUpdate();

	            // Commit the transaction
	            connection.commit();
	            transferSuccess = true;
	            JOptionPane.showMessageDialog(null, "Amount Rs : " + amountToTransfer + " Transferred Successfully.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Insufficient balance in sender's account.");
	        }

	    } catch (SQLException e) {
	        // Rollback the transaction in case of any failure
	        if (connection != null) {
	            try {
	                connection.rollback();
	            } catch (SQLException rollbackException) {
	                rollbackException.printStackTrace();
	            }
	        }
	        e.printStackTrace();
	    } finally {
	        // Close all resources
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (connection != null) {
	                connection.setAutoCommit(true);  // Turn auto-commit back on
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return transferSuccess;
	}

	

	
}
