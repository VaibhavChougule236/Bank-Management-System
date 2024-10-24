package Bank;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import UseDao.UserData;
import UseDao.userInfo;


public class Signupone extends JFrame   {
	JFrame frame ,frame_1,frame2;
	long random;
	JRadioButton b1,b2,b3;
	static JTextField t1,t2,t3,t4,t5,t6,t7,t8,tt3,tt4,tt5,tt6;
	JDateChooser calender;
	JButton btn ,btn1;
    JPasswordField passwordField, passwordField1;
    private JButton BackButton1;

	
	Signupone()
	{
		frame = new JFrame("Application  form ");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setSize(762,821);
		frame.setLocation(450,0);
		frame.getContentPane().setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		JLabel l1 = new JLabel("Application Form No :- "+random);
		l1.setFont(new Font("Raleway",Font.BOLD,38));
		l1.setBounds(88, 10, 548, 48);
		frame.getContentPane().add(l1);	
		
		JLabel l2 = new JLabel("Personal Details");
		l2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		l2.setBounds(285, 68, 286, 32);
		frame.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("Name :");
		l3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l3.setBounds(88, 131, 80, 26);
		frame.getContentPane().add(l3);
		
		t1 = new JTextField();
		t1.setFont(new Font("Cambria", Font.BOLD, 18));
		t1.setBounds(178, 131, 428, 32);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		
		JLabel l4 = new JLabel("E-Mail :");
		l4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l4.setBounds(88, 223, 80, 26);
		frame.getContentPane().add(l4);
		
		JLabel l5 = new JLabel(" Address :");
		l5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l5.setBounds(88, 276, 80, 26);
		frame.getContentPane().add(l5);
		
		JLabel l6 = new JLabel("Gender :");
		l6.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l6.setBounds(88, 318, 80, 26);
		frame.getContentPane().add(l6);
		
	    b1 = new JRadioButton("Male");
		b1.setBackground(new Color(255, 255, 255));
		b1.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		b1.setBounds(178, 317, 103, 32);
		frame.getContentPane().add(b1);
		
		JLabel l7 = new JLabel("Date of Birth :");
		l7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l7.setBounds(392, 365, 112, 26);
		frame.getContentPane().add(l7);
		
		JLabel l8 = new JLabel("City :");
		l8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l8.setBounds(88, 424, 80, 26);
		frame.getContentPane().add(l8);
		
		JLabel l9 = new JLabel("State :");
		l9.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l9.setBounds(88, 478, 80, 26);
		frame.getContentPane().add(l9);
		
		JLabel l10 = new JLabel("Pincode :");
		l10.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l10.setBounds(88, 530, 80, 26);
		frame.getContentPane().add(l10);
		
		t2 = new JTextField();
		t2.setFont(new Font("Cambria", Font.BOLD, 18));
		t2.setColumns(10);
		t2.setBounds(178, 219, 428, 32);
		frame.getContentPane().add(t2);
		
		t3 = new JTextField();
		t3.setFont(new Font("Cambria", Font.BOLD, 18));
		t3.setColumns(10);
		t3.setBounds(178, 272, 428, 32);
		frame.getContentPane().add(t3);
		
		t4 = new JTextField();
		t4.setFont(new Font("Cambria", Font.BOLD, 18));
		t4.setColumns(10);
		t4.setBounds(178, 424, 428, 32);
		frame.getContentPane().add(t4);
		
		t5 = new JTextField();
		t5.setFont(new Font("Cambria", Font.BOLD, 18));
		t5.setColumns(10);
		t5.setBounds(178, 472, 428, 32);
		frame.getContentPane().add(t5);
		
		t6 = new JTextField();
		t6.setFont(new Font("Cambria", Font.BOLD, 18));
		t6.setColumns(10);
		t6.setBounds(178, 527, 197, 32);
		InputVerify.addInputValidation(t6,frame);
		frame.getContentPane().add(t6);
		
		 b2 = new JRadioButton("Female");
		b2.setBackground(new Color(255, 255, 255));
		b2.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		b2.setBounds(321, 317, 103, 32);
		frame.getContentPane().add(b2);
		
        b3 = new JRadioButton("Transgender");
		b3.setBackground(new Color(255, 255, 255));
		b3.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		b3.setBounds(471, 317, 135, 32);
		frame.getContentPane().add(b3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		
		calender = new JDateChooser();
		calender.setDateFormatString("dd, MMM, y");
		calender.setForeground(new Color(0, 0, 0));
		calender.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		calender.setBounds(533, 365, 167, 26);
		frame.getContentPane().add(calender);
		
		
		btn = new JButton("Next >");
		btn.setForeground(Color.WHITE);
		btn.setBackground(new Color(255, 128, 0));
		btn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
		btn.setBounds(588, 742, 112, 32);
		frame.getContentPane().add(btn);
		
		JLabel l11 = new JLabel("Username :");
		l11.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l11.setBounds(76, 583, 96, 26);
		frame.getContentPane().add(l11);
		
		t7 = new JTextField();
		t7.setFont(new Font("Cambria", Font.BOLD, 18));
		t7.setColumns(10);
		t7.setBounds(178, 579, 428, 32);
		frame.getContentPane().add(t7);
		
		JLabel l12 = new JLabel("Password :");
		l12.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l12.setBounds(76, 636, 96, 26);
		frame.getContentPane().add(l12);
		
		JLabel l13 = new JLabel("Confirm Password :");
		l13.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l13.setBounds(74, 686, 153, 26);
		frame.getContentPane().add(l13);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 636, 430, 32);
		frame.getContentPane().add(passwordField);
		
		passwordField1 = new JPasswordField();
		passwordField1.setBounds(237, 686, 369, 32);
		frame.getContentPane().add(passwordField1);
		
		JLabel l14 = new JLabel("Mobile No :");
		l14.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l14.setBounds(88, 365, 86, 26);
		frame.getContentPane().add(l14);
		
		t8 = new JTextField();
		t8.setFont(new Font("Cambria", Font.BOLD, 18));
		t8.setColumns(10);
		t8.setBounds(178, 361, 197, 32);
		InputVerify.addInputValidation(t8,frame);
		frame.getContentPane().add(t8);
		
		JLabel l9_1 = new JLabel("Qualification :");
		l9_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		l9_1.setBounds(392, 530, 112, 26);
		frame.getContentPane().add(l9_1);
		
String arr[]= {"Non Graduate","Graduate","Post Graduate","Other"};
		JComboBox qualification = new JComboBox(arr);
		qualification.setFont(new Font("Cambria", Font.BOLD, 18));
		qualification.setBounds(524, 526, 176, 32);
		qualification.setBackground(Color.white);
		frame.getContentPane().add(qualification);
		
		BackButton1 = new JButton("< Back");
        BackButton1.setForeground(Color.WHITE);
        BackButton1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        BackButton1.setBackground(new Color(0, 128, 192));
        BackButton1.setBounds(437, 742, 112, 32);
        frame.getContentPane().add(BackButton1);
        
        JButton btnNewButton = new JButton("Upload Photo");
        btnNewButton.setBackground(new Color(192, 192, 192));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 8));
        btnNewButton.setBounds(503, 177, 103, 32);
        frame.getContentPane().add(btnNewButton);
        
        JLabel fileLabel = new JLabel("  No file selected");
        fileLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        fileLabel.setForeground(new Color(255, 0, 0));
        
        fileLabel.setBounds(178, 177, 323, 32);
        frame.getContentPane().add(fileLabel);
        
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create a file chooser
                JFileChooser fileChooser = new JFileChooser();
                
                // Open the file chooser dialog
                int result = fileChooser.showOpenDialog(frame);
                
                // Check if a file was selected
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    // Display the selected file path in the label
                    fileLabel.setText("Selected file : " + selectedFile.getAbsolutePath());
                    fileLabel.setForeground(Color.BLUE);
                } else {
                    fileLabel.setText("No file selected");
                    fileLabel.setForeground(Color.red);
                }
            }
        });
		
		 String checkPassword=String.valueOf(passwordField.getPassword());
		 String checkPassword1=String.valueOf(passwordField1.getPassword());
		
	    
	
		frame.setVisible(true);
		
		BackButton1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		//next button
		
		
	btn.addActionListener(new ActionListener() {
		
	
	public void actionPerformed(ActionEvent e)
	{
		
		
				 {
				 if ( (t1.getText()).isEmpty() ||  (t2.getText()).isEmpty() ||  (t3.getText()).isEmpty() ||  (t4.getText()).isEmpty() || (t5.getText()).isEmpty()  || (t6.getText()).isEmpty() || (t7.getText()).isEmpty() || (t8.getText()).isEmpty() )
				 {
					 JOptionPane.showMessageDialog(null, "Please fill all feild");
					 
				 }
				 if (validateEmail(t2.getText()) && validatePassword(passwordField1.getText())) {
					    
					 frame.dispose();
					 frame_1 = new JFrame("Application  form ");
						frame_1.getContentPane().setBackground(new Color(255, 255, 255));
						frame_1.setSize(839,671);
						frame_1.setVisible(false);
						frame_1.setLocation(450,0);
						frame_1.getContentPane().setLayout(null);
						
						JLabel l2 = new JLabel("Additional Details");
						l2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 21));
						l2.setBounds(287, 40, 286, 32);
						frame_1.getContentPane().add(l2);
						
						JLabel l3 = new JLabel("Religion :");
						l3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						l3.setBounds(88, 131, 80, 26);
						frame_1.getContentPane().add(l3);
						 
						String arr1[]= {"Hindu","Jain","Cristan","Muslim"};
						JComboBox religion = new JComboBox(arr1);
						religion.setBackground(Color.white);
						religion.setFont(new Font("Cambrai",Font.BOLD,18));
						religion.setBounds(230, 127, 428, 32);
						frame_1.getContentPane().add(religion);
						
						JLabel l4 = new JLabel("Category :");
						l4.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						l4.setBounds(88, 178, 91, 32);
						frame_1.getContentPane().add(l4);
						
						String arr2[]= {"Open","OBC","ST","NT","VJNT","SC"};
						JComboBox category = new JComboBox(arr2);
						category.setFont(new Font("Cambria", Font.BOLD, 18));
						category.setBackground(Color.white);
						category.setBounds(230, 177, 428, 32);
						frame_1.getContentPane().add(category);
						
						JLabel l5 = new JLabel("Income :");
						l5.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						l5.setBounds(88, 227, 80, 26);
						frame_1.getContentPane().add(l5);
						
						JLabel l7 = new JLabel("Occupation:");
						l7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						l7.setBounds(88, 366, 112, 26);
						frame_1.getContentPane().add(l7);
						
						JLabel l8 = new JLabel("Aadhar Number :");
						l8.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						l8.setBounds(88, 425, 135, 26);
						frame_1.getContentPane().add(l8);
						
						
						
						JTextField tt3 = new JTextField();
						tt3.setFont(new Font("Cambria", Font.BOLD, 18));
						tt3.setColumns(10);
						tt3.setBounds(230, 223, 428, 32);
						frame_1.getContentPane().add(tt3);
						
						
						
						
						JTextField tt5 = new JTextField();
						tt5.setFont(new Font("Cambria", Font.BOLD, 18));
						tt5.setColumns(10);
						tt5.setBounds(230, 362, 428, 32);
						frame_1.getContentPane().add(tt5);
						
						JLabel l10 = new JLabel("Pan No :");
						l10.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						l10.setBounds(88, 278, 80, 26);
						frame_1.getContentPane().add(l10);
						
						JTextField tt6 = new JTextField();
						tt6.setFont(new Font("Cambria", Font.BOLD, 18));
						tt6.setColumns(10);
						tt6.setBounds(230, 274, 428, 32);
						frame_1.getContentPane().add(tt6);
						
						JButton PanCard=new JButton("Upload PanCard");
						PanCard.setBackground(new Color(192, 192, 192));
						PanCard.setFont(new Font("Tahoma", Font.BOLD, 8));
						PanCard.setBounds(558, 316, 100, 32);
				        frame_1.getContentPane().add(PanCard);
				        
				        JLabel fileLabel = new JLabel("  No file selected");
						fileLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
						fileLabel.setBounds(230, 316, 323, 32);
						frame_1.getContentPane().add(fileLabel);
				        
				        PanCard.addActionListener(new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				                // Create a file chooser
				                JFileChooser fileChooser = new JFileChooser();
				                
				                // Open the file chooser dialog
				                int result = fileChooser.showOpenDialog(frame_1);
				                
				                if (result == JFileChooser.APPROVE_OPTION) {
				                    File selectedFile = fileChooser.getSelectedFile();
				                    // Display the selected file path in the label
				                    fileLabel.setText("Selected file: " + selectedFile.getAbsolutePath());
				                    fileLabel.setForeground(Color.BLUE);
				                } else {
				                    fileLabel.setText("No file selected");
				                    fileLabel.setForeground(Color.red);
				                }
				            }
				        });
						
				        
				        
				        JTextField tt4 = new JTextField();
						tt4.setFont(new Font("Cambria", Font.BOLD, 18));
						tt4.setColumns(10);
						tt4.setBounds(230, 421, 428, 32);
						InputVerify.addInputValidation(tt4,frame_1);
						frame_1.getContentPane().add(tt4);
						
						JButton Adhar=new JButton("Upload Adhar");
						Adhar.setBackground(new Color(192, 192, 192));
						Adhar.setFont(new Font("Tahoma", Font.BOLD, 8));
						Adhar.setBounds(558, 474, 100, 32);
				        frame_1.getContentPane().add(Adhar);
				        
				        JLabel fileLabel1 = new JLabel("  No file selected");
						fileLabel1.setFont(new Font("Tahoma", Font.BOLD, 11));
						fileLabel1.setBounds(230, 474, 323, 31);
						frame_1.getContentPane().add(fileLabel1);
				        
				        Adhar.addActionListener(new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				                // Create a file chooser
				                JFileChooser fileChooser = new JFileChooser();
				                
				                // Open the file chooser dialog
				                int result = fileChooser.showOpenDialog(frame_1);
				                
				                // Check if a file was selected
				                if (result == JFileChooser.APPROVE_OPTION) {
				                    File selectedFile = fileChooser.getSelectedFile();
				                    // Display the selected file path in the label
				                    fileLabel1.setText("Selected file: " + selectedFile.getAbsolutePath());
				                    fileLabel1.setForeground(Color.BLUE);
				                } else {
				                    fileLabel1.setText("No file selected");
				                    fileLabel1.setForeground(Color.red);
				                }
				            }
				        });
						
						JButton BackButton = new JButton(" < Back");
						BackButton.setForeground(Color.WHITE);
				        BackButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
				        BackButton.setBackground(new Color(0, 128, 192));
						BackButton.setBounds(88, 572, 112, 32);
						frame_1.getContentPane().add(BackButton);
						
						JButton btn1 = new JButton("Preview>");
						btn1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
							}
						});
						btn1.setForeground(Color.WHITE);
						btn1.setBackground(new Color(255, 128, 0));
						btn1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
						btn1.setBounds(533, 572, 125,32);
						frame_1.getContentPane().add(btn1);
						
						
						
						frame_1.setVisible(true);

						 //verification
					    
						   
						   
						   
						
					
					
					BackButton.addActionListener(new ActionListener() {
					    @Override
					    public void actionPerformed(ActionEvent e) {
					        frame_1.setVisible(false);  
					        frame.setVisible(true);    
					    }
					});
					
					btn1.addActionListener(new ActionListener() {
						
					public void actionPerformed(ActionEvent e)
					{
						if (   (tt3.getText()).isEmpty() ||  (tt4.getText()).isEmpty() || (tt5.getText()).isEmpty()  || (tt6.getText()).isEmpty()  )
						 {
							 JOptionPane.showMessageDialog(null, "Please fill all feild");
						 }else {
							 frame_1.dispose();
						frame2 = new JFrame("Preview ");
						frame2.getContentPane().setBackground(new Color(255, 255, 255));
						frame2.setSize(839,671);
						frame2.setLocation(450,0);
						//frame1.setVisible(false);
						frame2.getContentPane().setLayout(null);
						
						Random random = new Random();
						String fixedPart = "50405100260";
				        String randomPart = String.format("%05d", random.nextInt(100000));
				        String cardnumber = fixedPart + randomPart;
				        
				        
						JLabel name1 = new JLabel("Name :");
						name1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						name1.setBounds(30, 20, 80, 29);
						frame2.getContentPane().add(name1);
						
						
						JLabel nn1 = new JLabel();
						nn1.setFont(new Font("Cambria", Font.BOLD, 18));
						nn1.setBounds(110,15, 428, 35);
						nn1.setText(t1.getText());
						frame2.getContentPane().add(nn1);
										
						JLabel email1 = new JLabel("Email :");
						email1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						email1.setBounds(30,63, 80, 29);
						frame2.getContentPane().add(email1);
						
						JLabel ee1 = new JLabel();
						ee1.setFont(new Font("Cambria", Font.BOLD, 18));
						ee1.setBounds(110,59, 428, 35);
						ee1.setText(t2.getText());
						frame2.getContentPane().add(ee1);
						
						JLabel add1 = new JLabel("Address :");
						add1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						add1.setBounds(30,108, 80, 26);
						frame2.getContentPane().add(add1);
						
						JLabel aa1 = new JLabel();
						aa1.setFont(new Font("Cambria", Font.BOLD, 18));
						aa1.setBounds(110,102, 428, 32);
						aa1.setText(t3.getText());
						frame2.getContentPane().add(aa1);
						
						JLabel cardno = new JLabel("Account-Number : "+cardnumber);
						cardno.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						cardno.setBounds(30,151, 300, 26);
						frame2.getContentPane().add(cardno);
						
						JLabel gen = new JLabel("Gender :");
						gen.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						gen.setBounds(30,195, 80, 26);
						frame2.getContentPane().add(gen);
						
					    String gender1 = null;
						if(b1.isSelected()) {
							gender1 ="Male";
						}
					    else if(b2.isSelected())
						{
							gender1 = "Female";
						}
						else if(b3.isSelected())
						{
							gender1 = "Transgender";
						}
						JLabel gg1 = new JLabel();
							gg1.setFont(new Font("Cambria", Font.BOLD, 18));
					    gg1.setBounds(110,189, 220, 32);
						gg1.setText(gender1);
					    frame2.getContentPane().add(gg1);
					    
					    JLabel dob = new JLabel("Date of Birth :");
						dob.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						dob.setBounds(409,195, 110, 26);
						frame2.getContentPane().add(dob);
					    String dob1 = ((JTextField) calender.getDateEditor().getUiComponent()).getText();
						
					    JLabel bb1 = new JLabel();
							bb1.setFont(new Font("Cambria", Font.BOLD, 18));
					    bb1.setBounds(529,189, 220, 32);
						bb1.setText(dob1);
					    frame2.getContentPane().add(bb1);
						
					    JLabel cit = new JLabel("City :");
						cit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
						cit.setBounds(30,293, 40, 26);
						frame2.getContentPane().add(cit);
						
						 JLabel cc1 = new JLabel();
								cc1.setFont(new Font("Cambria", Font.BOLD, 18));
					        cc1.setBounds(110,289, 157, 32);
							cc1.setText(t4.getText());
						    frame2.getContentPane().add(cc1);
						
						    JLabel sta = new JLabel("state :");
							sta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
							sta.setBounds(409,293, 80, 26);
							frame2.getContentPane().add(sta);
						
							JLabel ss1 = new JLabel();
								ss1.setFont(new Font("Cambria", Font.BOLD, 18));
					        ss1.setBounds(471,289, 278, 32);
						    ss1.setText(t5.getText());
							frame2.getContentPane().add(ss1);
						
							JLabel pin = new JLabel("Pincode :");
							pin.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,16));
							pin.setBounds(30,344,80,26);
							frame2.getContentPane().add(pin);
							
							JLabel pp1 = new JLabel();
							pp1.setFont(new Font("Cambria",Font.BOLD,18));
							pp1.setBounds(110,340,241,32);
							pp1.setText(t6.getText());
							frame2.getContentPane().add(pp1);
							
							JLabel user = new JLabel("Username :");
							user.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,16));
							user.setBounds(30,393,100,26);
							frame2.getContentPane().add(user);
							
							JLabel uu1 = new JLabel();
							uu1.setFont(new Font("Cambria",Font.BOLD,18));
							uu1.setBounds(120,389,399,32);
							uu1.setText(t7.getText());
							frame2.getContentPane().add(uu1);
							
							JLabel pass = new JLabel("Password :");
							pass.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,16));
							pass.setBounds(30,437,100,26);
							frame2.getContentPane().add(pass);
							
							JLabel p1 = new JLabel();
							p1.setFont(new Font("Cambria",Font.BOLD,18));
							p1.setBounds(123,433,428,32);
							p1.setText(String.valueOf(passwordField.getPassword()));
							frame2.getContentPane().add(p1);
							
							JLabel reli = new JLabel("Religion :");
							reli.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,16));
							reli.setBounds(30,477,100,26);
							frame2.getContentPane().add(reli);
							
							JLabel rr1 = new JLabel();
							rr1.setFont(new Font("Cambria",Font.BOLD,18));
							rr1.setBounds(116,473,253,32);
							rr1.setText((String)religion.getSelectedItem());
							frame2.getContentPane().add(rr1);
							
							JLabel cat = new JLabel("Category :");
							cat.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,16));
							cat.setBounds(409,477,100,26);
							frame2.getContentPane().add(cat);
							
							JLabel c1 = new JLabel();
							c1.setFont(new Font("Cambria",Font.BOLD,18));
							c1.setBounds(508,473,259,32);
							c1.setText((String)category.getSelectedItem());
							frame2.getContentPane().add(c1);
							
							JLabel income = new JLabel("Income :");
							income.setFont(new Font("Arial Rounded MT Bold",Font.PLAIN,16));
							income.setBounds(409,517,80,26);
							frame2.getContentPane().add(income);
							
							JLabel i1 = new JLabel();
							i1.setFont(new Font("Cambria",Font.BOLD,18));
							i1.setBounds(508,513,241,32);
							i1.setText(tt3.getText());
							frame2.getContentPane().add(i1);
							
							JLabel mob = new JLabel("Mobile No :");
							mob.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
							mob.setBounds(30, 242, 86, 26);
							frame2.getContentPane().add(mob);
							
							JLabel mm1 = new JLabel();
							mm1.setText(t8.getText());
							mm1.setFont(new Font("Cambria", Font.BOLD, 18));
							mm1.setBounds(128, 238, 241, 32);
							frame2.getContentPane().add(mm1);
							
							JLabel qual = new JLabel("Qualification :");
							qual.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
							qual.setBounds(409, 242, 110, 26);
							frame2.getContentPane().add(qual);
							
							JLabel qq1 = new JLabel();
							qq1.setText((String) qualification.getSelectedItem());
							qq1.setFont(new Font("Cambria", Font.BOLD, 18));
							qq1.setBounds(529, 238, 241, 32);
							frame2.getContentPane().add(qq1);
							
							JLabel pan = new JLabel("Pan No :");
							pan.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
							pan.setBounds(30, 521, 80, 26);
							frame2.getContentPane().add(pan);
							
							JLabel p11 = new JLabel();
							p11.setText(tt5.getText());
							p11.setFont(new Font("Cambria", Font.BOLD, 18));
							p11.setBounds(110, 515, 253, 32);
							frame2.getContentPane().add(p11);
							
							JButton sub = new JButton("SUBMIT ");
							sub.setForeground(new Color(255, 255, 255));
							sub.setBackground(new Color(255, 128, 0));
							sub.setBounds(550, 589, 112, 32);
							sub.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
							frame2.getContentPane().add(sub);
							
							JLabel aadhar = new JLabel("Aadhar No :");
							aadhar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
							aadhar.setBounds(409, 344, 100, 26);
							frame2.getContentPane().add(aadhar);
							
							JLabel aad1 = new JLabel();
							aad1.setText(tt4.getText());
							aad1.setFont(new Font("Cambria", Font.BOLD, 18));
							aad1.setBounds(510, 340, 150, 35);
							frame2.getContentPane().add(aad1);	
							
							JButton BackButton= new JButton("< Back");
							BackButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
							BackButton.setBounds(250, 589, 112, 32);
							frame2.getContentPane().add(BackButton);
						    
						
						
						    JButton Docs= new JButton("View Documents");
						    Docs.setFont(new Font("Times New Roman", Font.BOLD, 10));
						    Docs.setBounds(400, 589, 112, 32);
							frame2.getContentPane().add(Docs);
						    frame2.setVisible(true);
						    
						    Docs.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									Documents d=new Documents();
									d.main(null);
									
								}
						    	
						    });
						    
						   
						    
						BackButton.addActionListener(new ActionListener() {
						    @Override
						    public void actionPerformed(ActionEvent e) {
						        frame2.setVisible(false);  
						        frame_1.setVisible(true);    
						    }
						});
						sub.addActionListener(new ActionListener(){
							private static UserData data=new userInfo();
							@Override
							public void actionPerformed(ActionEvent e) {
								String name = t1.getText();
				                String email = t2.getText();
				                String address = t3.getText();
				                String city = t4.getText();
				                String state = t5.getText();
				                int pincode = Integer.parseInt(t6.getText());
				                String mobileNo = t8.getText();
				                String username = t7.getText();
				                String password = new String(passwordField.getPassword());
				                String adhar=tt4.getText();
				                int income=Integer.parseInt(tt3.getText());
				                String Qualification=(String) qualification.getSelectedItem();		
				                String panNo=tt6.getText();
				                String Religion=(String)religion.getSelectedItem();
				                String Category=(String)category.getSelectedItem();
				                String Occupation=tt5.getText();
				                String gender = null;
				                
				                Timestamp currentTimestamp = Timestamp.valueOf(LocalDateTime.now());

				                if (b1.isSelected()) {
				                    gender = "Male";
				                } else if (b2.isSelected()) {
				                    gender = "Female";
				                } else if (b3.isSelected()) {
				                    gender = "Transgender";
				                }
				                if (!checkPassword.equals(checkPassword1)) {
				                    JOptionPane.showMessageDialog(null, "Passwords do not match. Please re-enter.");
				                    return;
				                }
				                
				                data.insertUser(name, email, address, gender ,mobileNo, city, state, pincode,Qualification, cardnumber, username, password, Religion, Category,gender, income, panNo, Occupation,adhar,currentTimestamp);
				                dispose();
							}
							
						});
					}
					}
					});
					
				 }else {
					    if (!validateEmail(t2.getText())) {
					        JOptionPane.showMessageDialog(null,
					                "Invalid email format. Please enter a valid email (e.g., example@domain.com).",
					                "Invalid Email",
					                JOptionPane.ERROR_MESSAGE);
					    }
					    if (!validatePassword(passwordField1.getText())) {
					        JOptionPane.showMessageDialog(null,
					                "Password must contain:\n" +
					                        "- At least one lowercase letter\n" +
					                        "- At least one uppercase letter\n" +
					                        "- At least one digit\n" +
					                        "- At least one special character (@$!%*?&)\n" +
					                        "- Minimum length of 8 characters",
					                "Invalid Password",
					                JOptionPane.ERROR_MESSAGE);
					    }
					}
						
					
			
			    
			    
			}
				 
		
				
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

    
    private boolean validatePassword(String password) {
        
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        if (!Pattern.matches(passwordPattern, password)) {
            return false;
        }
        return true;
    }
	    
	public static void main(String[] args)
	{
		new Signupone() ;
	}
	
	public static boolean isEmpty(String a)
	{
		return a== null;
	}
	public static boolean check(String a,String b) {
		return a.equals(b);
	}
}