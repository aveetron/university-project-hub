import java.util.Arrays;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class sell extends JFrame {

	private JPanel contentPane;
	private JTextField txt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sell frame = new sell();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public sell() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pic = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/sell3.png")).getImage();
		pic.setIcon(new ImageIcon(img));
		pic.setBounds(22, 48, 138, 152);
		contentPane.add(pic);
		
		JLabel lblSell = new JLabel("  Quick Sell");
		lblSell.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSell.setBounds(245, 22, 102, 27);
		contentPane.add(lblSell);
		
		JLabel lblNewLabel = new JLabel("    Sell");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(170, 75, 67, 21);
		contentPane.add(lblNewLabel);
		
		txt = new JTextField();
		txt.setBounds(245, 77, 138, 20);
		contentPane.add(txt);
		txt.setColumns(10);
		
		JLabel lblTk = new JLabel("  TK");
		lblTk.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTk.setBounds(397, 79, 27, 14);
		contentPane.add(lblTk);
		
		JButton done = new JButton("  Done");
		done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File f = new  File("sell.txt");
				try {
					FileWriter fw = new FileWriter(f,true);
					fw.write(txt.getText());
					fw.write("\n");
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		done.setFont(new Font("Tahoma", Font.BOLD, 13));
		done.setBounds(320, 131, 89, 27);
		contentPane.add(done);
		
		JButton btnClear = new JButton("   clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt.setText(" ");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(203, 133, 89, 23);
		contentPane.add(btnClear);
		
		JButton back = new JButton("go back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				another1 an = new another1();
				an.setVisible(true);
			}
		});
		back.setFont(new Font("Tahoma", Font.BOLD, 12));
		back.setBounds(10, 11, 89, 23);
		contentPane.add(back);
		
		JButton btnLogout = new JButton("Logout");
		Image imgg = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnLogout.setIcon(new ImageIcon(imgg));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogout.setBounds(300, 228, 109, 23);
		contentPane.add(btnLogout);
	}
}
