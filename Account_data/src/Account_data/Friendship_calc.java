package Account_data;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Friendship_calc {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Friendship_calc window = new Friendship_calc();
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
	public Friendship_calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(210, 166, 255));
		frame.setBounds(100, 100, 602, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Friendship Calculator");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		lblNewLabel.setBounds(147, 11, 172, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("YOUR NAME");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1.setBounds(76, 94, 125, 22);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("YOUR FRIEND'S NAME");
		lblNewLabel_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(77, 163, 161, 22);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		t1 = new JTextField();
		t1.setBounds(266, 93, 161, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(266, 162, 161, 20);
		frame.getContentPane().add(t2);
		
		JLabel t3 = new JLabel("");
		t3.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		t3.setBounds(90, 242, 450, 34);
		frame.getContentPane().add(t3);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=t1.getText();
				String f=t2.getText();
				Random r=new Random();
				int i=r.nextInt(1,100);
				t3.setText("Hello "+n+" your frienship precentage with "+f+" is "+i);
			
			}
		});
		btnNewButton.setBounds(230, 293, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
