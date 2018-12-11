import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class another1 extends JFrame {

	private JPanel logout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					another1 frame = new another1();
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
	public another1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		logout = new JPanel();
		logout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(logout);
		logout.setLayout(null);
		
		JButton a1lbl1 = new JButton("Sell");
		Image img5 = new ImageIcon(this.getClass().getResource("/sell.png")).getImage();
		a1lbl1.setIcon(new ImageIcon(img5));
		a1lbl1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sell newsell = new sell();
				newsell.setVisible(true);
			}
		});
		a1lbl1.setFont(new Font("Tahoma", Font.BOLD, 13));
		a1lbl1.setBounds(26, 152, 103, 52);
		logout.add(a1lbl1);
		
		JButton a1lbl2 = new JButton("Stock\r\n");
		Image img1 = new ImageIcon(this.getClass().getResource("/stock.png")).getImage();
		a1lbl2.setIcon(new ImageIcon(img1));
		a1lbl2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				stock st = new stock();
				st.setVisible(true);
			}
		});
		a1lbl2.setFont(new Font("Tahoma", Font.BOLD, 13));
		a1lbl2.setBounds(151, 152, 114, 52);
		logout.add(a1lbl2);
		
		JButton a1lbl3 = new JButton("Bills");
		Image img6 = new ImageIcon(this.getClass().getResource("/bill.png")).getImage();
		a1lbl3.setIcon(new ImageIcon(img6));
		a1lbl3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bill b = new bill();
				b.setVisible(true);
			}
		});
		a1lbl3.setFont(new Font("Tahoma", Font.BOLD, 13));
		a1lbl3.setBounds(286, 152, 114, 52);
		logout.add(a1lbl3);
		
		JLabel managelbl = new JLabel("Hello Mr.admin,Do as you want to do");
		managelbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		managelbl.setBounds(139, 48, 273, 60);
		logout.add(managelbl);
		
		JButton btnLogout = new JButton("  LogOut");
		Image img = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnLogout.setIcon(new ImageIcon(img));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(286, 221, 114, 30);
		logout.add(btnLogout);
		
		JLabel iconlbl = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/manage2.png")).getImage();
		iconlbl.setIcon(new ImageIcon(img4));
		iconlbl.setBounds(47, 31, 94, 102);
		logout.add(iconlbl);
	}
}
