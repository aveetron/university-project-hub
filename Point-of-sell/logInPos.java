
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class logInPos {

	private JFrame frame;
	private JTextField TF1;
	private JTextField TF2;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel loginlbl;
	private JButton aboutUs;
	/**
	 * made those class as private 
	 */
	class checkNameAndPass{
		void check(String userName,int password){
			if(userName.equals("admin")  && password ==  12345){
				try{		
					JOptionPane.showMessageDialog(null, "hello Mr.admin,you successfully logged in !");
					frame.dispose();
					another1 newPage1 = new another1();
					newPage1.setVisible(true);
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, "wrong username! or password");
				}
				
			}
			else{	
				JOptionPane.showMessageDialog(null, "error log in");
			}
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logInPos window = new logInPos();
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
	public logInPos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 435, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lbl1 = new JLabel("        Welcome,Open your store");
		lbl1.setBackground(Color.LIGHT_GRAY);
		lbl1.setForeground(Color.BLACK);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl1.setBounds(145, 33, 246, 51);
		frame.getContentPane().add(lbl1);
		
		lbl2 = new JLabel("   User Name");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl2.setBounds(33, 139, 89, 23);
		frame.getContentPane().add(lbl2);
		
		TF1 = new JTextField();
		TF1.setBounds(145, 141, 228, 21);
		frame.getContentPane().add(TF1);
		TF1.setColumns(10);
		
		lbl3 = new JLabel("   Password");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl3.setBounds(33, 173, 83, 23);
		frame.getContentPane().add(lbl3);
		
		TF2 = new JTextField();
		TF2.setBounds(145, 175, 228, 20);
		frame.getContentPane().add(TF2);
		TF2.setColumns(10);
		
		JButton Go = new JButton("Go");
		Image img2 = new ImageIcon(this.getClass().getResource("/ok1.png")).getImage();
		Go.setIcon(new ImageIcon(img2));
		Go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName;
				int password;
				userName = TF1.getText();
				password = Integer.parseInt(TF2.getText());
				
				//check the code
				checkNameAndPass nowCheck = new checkNameAndPass();
				nowCheck.check(userName,password);
				
			}
		});
		Go.setFont(new Font("Tahoma", Font.BOLD, 14));
		Go.setBounds(145, 220, 89, 31);
		frame.getContentPane().add(Go);
		
		loginlbl = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		loginlbl.setIcon(new ImageIcon(img1));
		loginlbl.setBounds(10, 11, 125, 117);
		frame.getContentPane().add(loginlbl);
		
		aboutUs = new JButton("about us\r\n");
		Image img3 = new ImageIcon(this.getClass().getResource("/about.png")).getImage();
		aboutUs.setIcon(new ImageIcon(img3));
		aboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"pont-of-sell (POS)"+"\n"+"made by : Void soft"+"\n\n"+"1 - Avee chakraborty"+"\n"+"2 - Diganta Protic Biswas"+"\n"+"3 - Faisal Sadiq Shvon");
			}
		});
		aboutUs.setFont(new Font("Tahoma", Font.BOLD, 12));
		aboutUs.setBounds(255, 221, 118, 31);
		frame.getContentPane().add(aboutUs);
	}

	

}
