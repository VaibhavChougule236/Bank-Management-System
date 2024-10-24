package Bank;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import UseDao.UserData;
import UseDao.user;
import UseDao.userInfo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartingPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_2;
	private JPasswordField passwordField_1;
	JLabel l11,l22,l33,l44,l55,l66,l77,l88;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartingPage frame = new StartingPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StartingPage() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 844, 621);
		contentPane = new JPanel(null);
		contentPane.setBackground(UIManager.getColor("Button.disabledShadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// Components
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\vaibh\\OneDrive\\Desktop\\PicsOFProject\\Screenshot_20240730_162003_Chrome__2___3_-removebg-preview.png"));
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(" Username");
		lblNewLabel_6.setLabelFor(this);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 19));
		contentPane.add(lblNewLabel_6);

		textField_2 = new JTextField();
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		passwordField_1 = new JPasswordField();
		contentPane.add(passwordField_1);

		JLabel lblNewLabel_7 = new JLabel(" Password ");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 19));
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\vaibh\\OneDrive\\Desktop\\user icon.png"));
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\vaibh\\OneDrive\\Desktop\\lock icon.png"));
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\vaibh\\OneDrive\\Desktop\\bank.png"));
		contentPane.add(lblNewLabel_10);

		JButton btnNewButton_5 = new JButton("Clear");
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBackground(Color.BLACK);
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 10));
		contentPane.add(btnNewButton_5);

		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBackground(Color.BLUE);
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\vaibh\\OneDrive\\Desktop\\PicsOFProject\\bb55.jpg"));
		contentPane.add(lblNewLabel_11);

		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				passwordField_1.setText("");
			}
		});

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Signupone.main(null);
			}
		});

		
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				int width = getContentPane().getWidth();
				int height = getContentPane().getHeight();

				
				lblNewLabel_5.setBounds((width - 340) / 2, 10, 340, 191);
				lblNewLabel_6.setBounds((width - 198) / 2 - 96, 211, 96, 23);
				textField_2.setBounds((width - 198) / 2, 206, 198, 28);
				lblNewLabel_7.setBounds((width - 198) / 2 - 96, 265, 96, 23);
				passwordField_1.setBounds((width - 198) / 2, 260, 198, 28);
				lblNewLabel_8.setBounds((width - 198) / 2 - 124, 206, 24, 28);
				lblNewLabel_9.setBounds((width - 198) / 2 - 124, 260, 24, 28);
				lblNewLabel_10.setBounds((width - 32) / 2, 111, 32, 39);
				btnNewButton.setBounds((width - 119) / 2, 351, 119, 34);
				btnNewButton_1.setBounds((width - 119) / 2 + 127, 402, 119, 39);
				btnNewButton_2.setBounds((width - 119) / 2 - 104 - 24, 402, 104, 39);
				btnNewButton_5.setBounds((width - 88) / 2 + 160, 298, 68, 23);
				lblNewLabel_11.setBounds(0, 0, width, height);
			}
		});
	

	

		btnNewButton.addActionListener(new ActionListener() {
			private static UserData data = new userInfo();

			@Override
			public void actionPerformed(ActionEvent e) {
				String UserName = textField_2.getText();
				String Password = String.valueOf(passwordField_1.getPassword());
				if (data.checkUser(UserName, Password)) {
					JOptionPane.showMessageDialog(null, "You are successfully Logged in...");

					JPanel contentPane;
					Toolkit toolkit = Toolkit.getDefaultToolkit();
					Dimension screenSize = toolkit.getScreenSize();

					setSize(screenSize.width-100, screenSize.height-100);  
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					setResizable(true);  

					contentPane = new JPanel();
					contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
					contentPane.setLayout(null);
					setContentPane(contentPane);

					JPanel FooterPanel = new JPanel();
					FooterPanel.setBackground(Color.LIGHT_GRAY);
					FooterPanel.setLayout(null);

					JScrollPane scrollPane = new JScrollPane(FooterPanel) {
						@Override
						public Dimension getPreferredSize() {
							Dimension dim = super.getPreferredSize();
							dim.height = 50;  
							return dim;
						}
					};
					scrollPane.setBounds(0, 0, getWidth(), 50);

					scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));
					contentPane.add(scrollPane);

					JButton btnNewButton_1 = new JButton("Update Account");
					btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					btnNewButton_1.setBounds(30, 10, 150, 30);
					FooterPanel.add(btnNewButton_1);

					btnNewButton_1.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							String UserName = JOptionPane.showInputDialog(null, "Enter UserName:");
			                String Password = JOptionPane.showInputDialog(null, "Enter Password:");
							updateAcc update=new updateAcc(UserName,Password);
							
						}
						
					});
					
					JButton btnNewButton_2 = new JButton("Delete Account");
					btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					btnNewButton_2.setBounds(190, 10, 150, 30);
					FooterPanel.add(btnNewButton_2);

					JButton btnNewButton_3 = new JButton("Deposite Money");
					btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					btnNewButton_3.setBackground(new Color(240, 240, 240));
					btnNewButton_3.setBounds(350, 10, 150, 30);
					FooterPanel.add(btnNewButton_3);
					
					btnNewButton_3.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							new deposite(UserName);
						}
					});


					JButton btnNewButton_4 = new JButton("Withdraw Money");
					btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					btnNewButton_4.setBounds(510, 10, 150, 30);
					FooterPanel.add(btnNewButton_4);

					btnNewButton_4.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							withdraw.main(null);
						}
					});

					JButton btnNewButton = new JButton("Money Transfer");
					btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					btnNewButton.setBounds(670, 10, 150, 30);
					FooterPanel.add(btnNewButton);
					
					JButton btnNewButton1 = new JButton("Total Balance");
					btnNewButton1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					btnNewButton1.setBounds(830, 10, 150, 30);
					FooterPanel.add(btnNewButton1);
					
					btnNewButton1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							String UserName=JOptionPane.showInputDialog("Enter UserName ");
							String Password=JOptionPane.showInputDialog("Enter Password ");
							JOptionPane.showInternalMessageDialog(null,"Available Balance : Rs."+data.myBalance(UserName,Password));
						}
						
					});
					
					
					JButton btnNewButton2 = new JButton("Transaction History");
					btnNewButton2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					btnNewButton2.setBounds(990, 10, 200, 30);
					FooterPanel.add(btnNewButton2);
					
					btnNewButton2.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							String AccountNumber=JOptionPane.showInputDialog("Enter Account Number ");
							String Password=JOptionPane.showInputDialog("Enter Password ");
							MoneyTransitionHistory m=new MoneyTransitionHistory(AccountNumber); 
							m.displayTransactionHistory();
							
							
						}
						
					});

					FooterPanel.setPreferredSize(new Dimension(screenSize.width-100, 50));

					JPanel panel = new JPanel();
					panel.setBackground(new Color(245, 245, 220));
					panel.setBounds(98, 81, 470, 280);
					contentPane.add(panel);
					panel.setLayout(null);

					JLabel lblNewLabel = new JLabel("Welcome  " + UserName + " !!");
					lblNewLabel.setFont(new Font("Britannic Bold", Font.ITALIC, 20));
					lblNewLabel.setBounds(159, 33, 300, 28);
					panel.add(lblNewLabel);

					JLabel lblName = new JLabel("Name:");
			        lblName.setFont(new Font("Arial", Font.BOLD, 18));
			        lblName.setBounds(36, 100, 126, 30);
			        panel.add(lblName);

			        JLabel lblAccountNo = new JLabel("Account No:");
			        lblAccountNo.setFont(new Font("Arial", Font.BOLD, 18));
			        lblAccountNo.setBounds(36, 150, 126, 29);
			        panel.add(lblAccountNo);

			        JLabel lblIfscCode = new JLabel("IFSC Code:");
			        lblIfscCode.setFont(new Font("Arial", Font.BOLD, 18));
			        lblIfscCode.setBounds(36, 200, 126, 29);
			        panel.add(lblIfscCode);

			        JLabel lblAddress = new JLabel("Address:");
			        lblAddress.setFont(new Font("Arial", Font.BOLD, 18));
			        lblAddress.setBounds(36, 250, 126, 29);
			        panel.add(lblAddress);

			        JLabel lblPhoneNo = new JLabel("Phone No:");
			        lblPhoneNo.setFont(new Font("Arial", Font.BOLD, 18));
			        lblPhoneNo.setBounds(36, 300, 134, 29);
			        panel.add(lblPhoneNo);

			        JLabel lblEmail = new JLabel("E-mail:");
			        lblEmail.setFont(new Font("Arial", Font.BOLD, 18));
			        lblEmail.setBounds(36, 350, 88, 29);
			        panel.add(lblEmail);

			        JLabel lblAadharNo = new JLabel("Aadhar No:");
			        lblAadharNo.setFont(new Font("Arial", Font.BOLD, 18));
			        lblAadharNo.setBounds(35, 400, 114, 29);
			        panel.add(lblAadharNo);

			        JLabel lblDateOfBirth = new JLabel("Date of Birth:");
			        lblDateOfBirth.setFont(new Font("Arial", Font.BOLD, 18));
			        lblDateOfBirth.setBounds(36, 450, 134, 29);
			        panel.add(lblDateOfBirth);
			        
			        try {
			            Connection c = user.getConnection();
			            String sql = "SELECT * FROM user WHERE Username=? AND Password=?";
			            PreparedStatement stmt = c.prepareStatement(sql);

			            stmt.setString(1, UserName);
			            stmt.setString(2, Password);

			            ResultSet rs = stmt.executeQuery();

			            if (rs.next()) {
			                String name1 = rs.getString("UName");
			                l11 = new JLabel();
			                l11.setText(name1);
			                l11.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
			                l11.setBounds(158, 100, 400, 29);
			                panel.add(l11);

			                String Acc=rs.getString("AccNo");
			                l22 = new JLabel();
					        l22.setText(Acc);
					        l22.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
					        l22.setBounds(172, 150, 400, 29);
					        panel.add(l22);
		
					        String IFSC=new String("BOJP0002209");
					        l33 = new JLabel();
					        l33.setText(IFSC);
					        l33.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
					        l33.setBounds(172, 200, 400, 29);
					        panel.add(l33);
			                
			                
			                String add = rs.getString("Address");
			                l44 = new JLabel();
			                l44.setText(add);
			                l44.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
			                l44.setBounds(172, 250, 400, 35);
			                panel.add(l44);

			                String email = rs.getString("E_mail");
			                l55 = new JLabel();
			                l55.setText(email);
			                l55.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
			                l55.setBounds(172, 350, 391, 29);
			                panel.add(l55);

			                String adno = rs.getString("Adhar_Number");
			                l66 = new JLabel();
			                l66.setText(adno);
			                l66.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
			                l66.setBounds(159, 400, 391, 29);
			                panel.add(l66);
			                
			                long phn = rs.getLong("Mobile_No");
			                String phno=Long.toString(phn);
			                l88 = new JLabel();
			                l88.setText(phno);
			                l88.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
			                l88.setBounds(181, 300, 391, 29);
			                panel.add(l88);
			            }

			            rs.close();
			            stmt.close();

			        } catch (SQLException x) {
			            x.printStackTrace();
			        }


			        

			        
			        
			        JPanel panel1 = new JPanel();
			        panel1.setBounds(865, 180, 212, 232);
			        panel.add(panel1);
			        
					JButton btnNewButton_5 = new JButton("< Back");
					btnNewButton_5.setBackground(new Color(255, 128, 128));
					btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
					btnNewButton_5.setBounds(15, 60, 80, 28);
					contentPane.add(btnNewButton_5);
					
					
					btnNewButton_2.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							data.DeletUser(UserName, Password);
							dispose();
						}
					});

					
					
					btnNewButton_5.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
							StartingPage.main(null);
							
							
						}
						
					});

					addComponentListener(new ComponentAdapter() {
						@Override
						public void componentResized(ComponentEvent e) {
							int width = getWidth();
							scrollPane.setBounds(0, 0, getWidth(), 50);

							if (width < 1200) {
								scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
							} else {
								scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
							}

							int panelWidth = Math.max(getWidth() - 300, 470);
							int panelHeight = Math.max(getHeight() - 250, 280);
							panel.setBounds((getWidth() - panelWidth) / 2, 81, panelWidth, panelHeight);
						}
					});
					
					
					JButton setting = new JButton("Settings ");
					setting.setFont(new Font("Times New Roman", Font.PLAIN, 11));
					setting.setToolTipText("");
					setting.setBounds(1300,700, 83, 21);
					contentPane.add(setting);
					
					setting.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							AboutSection a=new AboutSection();
							a.main(null);
						}
						
					});
							
							btnNewButton.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent e) {
									//MoneyTransfer transfer=new MoneyTransfer();
									MoneyTransfer.main(null);
								}
							});
						}else {
							JOptionPane.showMessageDialog(null, "User Not Found ...");
						}
						
					}
			
					
				});
		
		
	     }
}
			
	
	

