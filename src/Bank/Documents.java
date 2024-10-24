package Bank;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import UseDao.UserData;
import UseDao.userInfo;

public class Documents {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Documents window = new Documents();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Documents() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UserData data=new userInfo();
		frame = new JFrame();
		frame.setBounds(100, 100, 828, 766);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 54, 231, 287);
		BufferedImage imgPhoto=data.getPhoto(Signupone.t7.getText());
		if(imgPhoto!=null) {
			JLabel photo=new JLabel(new ImageIcon(imgPhoto));
			panel.add(photo);
		}else {
			JLabel photo1=new JLabel("No image found for the specified username.");
			panel.add(photo1);
		}
		frame.getContentPane().add(panel);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(510, 54, 231, 287);
		BufferedImage imgAdhar=data.getPhoto(Signupone.t7.getText());
		if(imgAdhar!=null) {
			JLabel Adhar=new JLabel(new ImageIcon(imgAdhar));
			panel_1.add(Adhar);
		}else {
			JLabel Adhar1=new JLabel("No image found for the specified username.");
			panel_1.add(Adhar1);
		}
		frame.getContentPane().add(panel_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(50, 407, 231, 287);
		BufferedImage imgPanCard=data.getPhoto(Signupone.t7.getText());
		if(imgPanCard!=null) {
			JLabel panCard=new JLabel(new ImageIcon(imgPanCard));
			panel_2.add(panCard);
		}else {
			JLabel panCard1=new JLabel("No image found for the specified username.");
			panel_2.add(panCard1);
		}
		frame.getContentPane().add(panel_2);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setBounds(686, 673, 85, 21);
		frame.getContentPane().add(btnNewButton);
	
	btnNewButton.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			
		}
		
	});
 }
}
