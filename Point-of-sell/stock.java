import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class stock extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stock frame = new stock();
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
	public stock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel piclbl = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/st.png")).getImage();
		piclbl.setIcon(new ImageIcon(img));
		piclbl.setBounds(10, 47, 152, 163);
		contentPane.add(piclbl);
		
		JLabel lblCheckOutYour = new JLabel("       check out your stock");
		lblCheckOutYour.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCheckOutYour.setBounds(159, 11, 219, 25);
		contentPane.add(lblCheckOutYour);
		
		JLabel lblNewLabel = new JLabel("   Add catagory");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(143, 65, 89, 25);
		contentPane.add(lblNewLabel);
		
		txt1 = new JTextField();
		txt1.setBounds(271, 67, 131, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("    elements");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(151, 122, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		txt2 = new JTextField();
		txt2.setBounds(271, 116, 131, 20);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		JButton btnAdd = new JButton("  Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				File f = new File("stock.txt");
				try {
					FileWriter fw = new FileWriter(f);
					fw.write(txt1.getText());
					fw.write(txt2.getText());
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAdd.setBounds(297, 159, 81, 23);
		contentPane.add(btnAdd);
		
		JButton log = new JButton("Logout");
		Image imgh = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		log.setIcon(new ImageIcon(imgh));
		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		log.setBounds(297, 228, 105, 23);
		contentPane.add(log);
		
		JButton back = new JButton("back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				another1 an = new another1();
				an.setVisible(true);
			}
		});
		back.setBounds(10, 13, 81, 23);
		contentPane.add(back);
	}
}
