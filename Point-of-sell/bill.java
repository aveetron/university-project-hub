import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class bill extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bill frame = new bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pic = new JLabel("");
		Image img  = new ImageIcon(this.getClass().getResource("/bill2.png")).getImage();
		pic.setIcon(new ImageIcon(img));
		pic.setBounds(10, 62, 146, 164);
		contentPane.add(pic);
		
		JLabel lblCheckOutBill = new JLabel("         Check out Bill");
		lblCheckOutBill.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCheckOutBill.setBounds(200, 32, 167, 21);
		contentPane.add(lblCheckOutBill);
		
		JButton btnShowBill = new JButton("Show Bill");
		Image img2 = new ImageIcon(this.getClass().getResource("/bill3.png")).getImage();
		btnShowBill.setIcon(new ImageIcon(img2));
		btnShowBill.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnShowBill.addActionListener(new ActionListener() {

			private Scanner input;

			public void actionPerformed(ActionEvent arg0) {
				File f = new File("bill.txt");
				try {
					String name= "";
					input = new Scanner(f);
					while(input.hasNext()){
						name += input.nextLine();
					}
					JOptionPane.showMessageDialog(null, name);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnShowBill.setBounds(200, 121, 167, 57);
		contentPane.add(btnShowBill);
		
		JButton btnLogout = new JButton("    logout");
		Image img4 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnLogout.setIcon(new ImageIcon(img4));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnLogout.setBounds(286, 228, 103, 23);
		contentPane.add(btnLogout);
		
		JButton btnBack = new JButton("  Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				another1 an = new another1();
				an.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(10, 32, 89, 23);
		contentPane.add(btnBack);
	}
}
