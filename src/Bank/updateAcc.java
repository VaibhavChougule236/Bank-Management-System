package Bank;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import UseDao.UserData;
import UseDao.user;
import UseDao.userInfo;

import javax.swing.border.EmptyBorder;

public class updateAcc extends JFrame {
		JFrame frame ,frame1,frame2;
		JRadioButton b1,b2,b3;
		JTextField t1,t2,t3,t4,t5,t6,t8,tt3,tt4,tt5,tt6;
		JDateChooser calender;
		JButton btn ,BackButton1;
		private JTextField textField;
		private String UserName;
		private String Password;
		updateAcc(String userName, String password)
		{
			this.UserName = userName;
		    this.Password = password;
		
		
			frame = new JFrame("Application  form ");
			frame.getContentPane().setBackground(new Color(255, 255, 255));
			frame.setSize(761,800);
			frame.setLocation(450,0);
			frame.getContentPane().setLayout(null);
			
			JLabel l1 = new JLabel("Update your profile here --");
			l1.setFont(new Font("Raleway",Font.BOLD,38));
			l1.setBounds(121, 10, 548, 48);
			frame.getContentPane().add(l1);	
			
			JLabel l2 = new JLabel("Personal Details");
			l2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
			l2.setBounds(285, 68, 286, 32);
			frame.getContentPane().add(l2);
			
			JLabel l3 = new JLabel("Name :");
			l3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			l3.setBounds(59, 113, 80, 26);
			frame.getContentPane().add(l3);
			
			t1 = new JTextField();
			t1.setFont(new Font("Cambria", Font.BOLD, 18));
			t1.setBounds(178, 110, 428, 32);
			frame.getContentPane().add(t1);
			t1.setColumns(10);
			
			JLabel l4 = new JLabel("E-Mail :");
			l4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			l4.setBounds(59, 167, 80, 26);
			frame.getContentPane().add(l4);
			
			JLabel l5 = new JLabel(" Address :");
			l5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			l5.setBounds(59, 217, 80, 26);
			frame.getContentPane().add(l5);
			
			JLabel l6 = new JLabel("Gender :");
			l6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			l6.setBounds(59, 264, 80, 26);
			frame.getContentPane().add(l6);
			
		    b1 = new JRadioButton("Male");
			b1.setBackground(new Color(255, 255, 255));
			b1.setFont(new Font("Bahnschrift", Font.BOLD, 17));
			b1.setBounds(178, 263, 103, 32);
			frame.getContentPane().add(b1);
			
			JLabel l7 = new JLabel("Date of Birth :");
			l7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			l7.setBounds(402, 318, 112, 26);
			frame.getContentPane().add(l7);
			
			JLabel l8 = new JLabel("City :");
			l8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			l8.setBounds(59, 365, 80, 26);
			frame.getContentPane().add(l8);
			
			JLabel l9 = new JLabel("State :");
			l9.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			l9.setBounds(59, 412, 80, 26);
			frame.getContentPane().add(l9);
			
			JLabel l10 = new JLabel("Pincode :");
			l10.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			l10.setBounds(59, 463, 80, 26);
			frame.getContentPane().add(l10);
			
			t2 = new JTextField();
			t2.setFont(new Font("Cambria", Font.BOLD, 18));
			t2.setColumns(10);
			t2.setBounds(178, 163, 428, 32);
			frame.getContentPane().add(t2);
			
			t3 = new JTextField();
			t3.setFont(new Font("Cambria", Font.BOLD, 18));
			t3.setColumns(10);
			t3.setBounds(178, 213, 428, 32);
			frame.getContentPane().add(t3);
			
			t4 = new JTextField();
			t4.setFont(new Font("Cambria", Font.BOLD, 18));
			t4.setColumns(10);
			t4.setBounds(178, 361, 428, 32);
			frame.getContentPane().add(t4);
			
			t5 = new JTextField();
			t5.setFont(new Font("Cambria", Font.BOLD, 18));
			t5.setColumns(10);
			t5.setBounds(178, 412, 428, 32);
			frame.getContentPane().add(t5);
			
			t6 = new JTextField();
			t6.setFont(new Font("Cambria", Font.BOLD, 18));
			t6.setColumns(10);
			t6.setBounds(178, 459, 197, 32);
			frame.getContentPane().add(t6);
			
			 b2 = new JRadioButton("Female");
			b2.setBackground(new Color(255, 255, 255));
			b2.setFont(new Font("Bahnschrift", Font.BOLD, 17));
			b2.setBounds(302, 263, 103, 32);
			frame.getContentPane().add(b2);
			
	        b3 = new JRadioButton("Transgender");
			b3.setBackground(new Color(255, 255, 255));
			b3.setFont(new Font("Bahnschrift", Font.BOLD, 17));
			b3.setBounds(453, 263, 135, 32);
			frame.getContentPane().add(b3);
			
			ButtonGroup bg = new ButtonGroup();
			bg.add(b1);
			bg.add(b2);
			bg.add(b3);
			
			calender = new JDateChooser();
			calender.setDateFormatString("dd, MMM, y");
			calender.setForeground(new Color(0, 0, 0));
			calender.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
			calender.setBounds(524, 318, 167, 26);
			frame.getContentPane().add(calender);
			
			
			
			JLabel l14 = new JLabel("Mobile No :");
			l14.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			l14.setBounds(59, 318, 86, 26);
			frame.getContentPane().add(l14);
			
			t8 = new JTextField();
			t8.setFont(new Font("Cambria", Font.BOLD, 18));
			t8.setColumns(10);
			t8.setBounds(178, 314, 197, 32);
			frame.getContentPane().add(t8);
			
			JLabel l9_1 = new JLabel("Qualification :");
			l9_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			l9_1.setBounds(392, 463, 112, 26);
			frame.getContentPane().add(l9_1);
			
	String arr[]= {"Non Graduate","Graduate","Post Graduate","Other"};
			JComboBox qualification = new JComboBox(arr);
			qualification.setFont(new Font("Cambria", Font.BOLD, 18));
			qualification.setBounds(514, 459, 176, 32);
			qualification.setBackground(Color.white);
			frame.getContentPane().add(qualification);
			
			
	        
	        JLabel lblIncome = new JLabel("Income  :");
	        lblIncome.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
	        lblIncome.setBounds(59, 511, 96, 26);
	        frame.getContentPane().add(lblIncome);
	        
	        textField = new JTextField();
	        textField.setFont(new Font("Cambria", Font.BOLD, 18));
	        textField.setColumns(10);
	        textField.setBounds(178, 507, 428, 32);
	        frame.getContentPane().add(textField);
			
	        JLabel ll3 = new JLabel("Religion :");
			ll3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			ll3.setBounds(59, 560, 80, 26);
			frame.getContentPane().add(ll3);
			 
			String arr1[]= {"Hindu","Jain","Cristan","Muslim"};
			JComboBox religion = new JComboBox(arr1);
			religion.setBackground(Color.white);
			religion.setFont(new Font("Cambrai",Font.BOLD,18));
			religion.setBounds(178, 560, 428, 32);
			frame.getContentPane().add(religion);
			
			JLabel ll4 = new JLabel("Category :");
			ll4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
			ll4.setBounds(59, 618, 91, 26);
			frame.getContentPane().add(ll4);
			
			String arr2[]= {"Open","OBC","ST","NT","VJNT","SC"};
			JComboBox category = new JComboBox(arr2);
			category.setFont(new Font("Cambria", Font.BOLD, 18));
			category.setBackground(Color.white);
			category.setBounds(178, 614, 428, 32);
			frame.getContentPane().add(category);
		    
			
			BackButton1 = new JButton("< Back");
	        BackButton1.setForeground(Color.WHITE);
	        BackButton1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
	        BackButton1.setBackground(new Color(0, 128, 192));
	        BackButton1.setBounds(476, 694, 112, 32);
	        frame.getContentPane().add(BackButton1);
	        
	        
			btn = new JButton("Update");
			btn.setForeground(Color.WHITE);
			btn.setBackground(new Color(255, 128, 0));
			btn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
			btn.setBounds(613, 694, 112, 32);
			frame.getContentPane().add(btn);
		
			frame.setVisible(true);
			
			BackButton1.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.setVisible(false);
				}
			});
			 
			
			btn.addActionListener(new ActionListener() {
                       UserData data=new userInfo();
				@Override
				public void actionPerformed(ActionEvent e) {
					String name = t1.getText();
	                String email = t2.getText();
	                String address = t3.getText();
	                String city = t4.getText();
	                String state = t5.getText();
	                int pincode = Integer.parseInt(t6.getText());
	                String mobileNo = t8.getText();
	                
	                
	               
	                int income=Integer.parseInt(textField.getText());
	                String Qualification=(String) qualification.getSelectedItem();		
	                 String Religion=(String)religion.getSelectedItem();
	                String Category=(String)category.getSelectedItem();
	                String gender = null;

	                if (b1.isSelected()) {
	                    gender = "Male";
	                } else if (b2.isSelected()) {
	                    gender = "Female";
	                } else if (b3.isSelected()) {
	                    gender = "Transgender";
	                }
	                
	                if ( (t1.getText()).isEmpty() ||  (t2.getText()).isEmpty() ||  (t3.getText()).isEmpty() ||  (t4.getText()).isEmpty() || (t5.getText()).isEmpty()  || (t6.getText()).isEmpty() || (t8.getText()).isEmpty() )
	   			 {
	   				 JOptionPane.showMessageDialog(null, "Please fill all feild");
	   				 return;
	   				 
	   			 }
	                

	                if (!validateEmail(t2.getText())) {
				        JOptionPane.showMessageDialog(null,
				                "Invalid email format. Please enter a valid email (e.g., example@domain.com).",
				                "Invalid Email",
				                JOptionPane.ERROR_MESSAGE);
				        return;
				    }
	   				 
	                Timestamp currentTimestamp = Timestamp.valueOf(LocalDateTime.now());
	   				 
	                data.updateAcc(name, email, address, gender ,mobileNo, city, state, pincode,Qualification,UserName,Password, Religion, Category,income,currentTimestamp);
	   			 
					
				}
				
			});
		
		}
		
		

		private boolean validateEmail(String email) {
	        
	        String emailPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

	        if (!Pattern.matches(emailPattern, email)) {
	            return false;
	        }
	        return true;
	    }
		
		
		
}