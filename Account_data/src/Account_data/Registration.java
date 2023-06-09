package Account_data;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField tb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 419, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 18));
		lblNewLabel.setBounds(148, 11, 109, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 66, 75, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender");
		lblNewLabel_1_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(10, 115, 75, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Branch");
		lblNewLabel_1_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 165, 75, 20);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		tb = new JTextField();
		tb.setBounds(151, 64, 120, 20);
		frame.getContentPane().add(tb);
		tb.setColumns(10);
		
		JRadioButton r1 = new JRadioButton("Male");
		r1.setBackground(SystemColor.menu);
		r1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		r1.setBounds(151, 114, 67, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Female");
		r2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		r2.setBackground(SystemColor.menu);
		r2.setBounds(227, 114, 84, 23);
		frame.getContentPane().add(r2);
		
		 ButtonGroup bg=new ButtonGroup();
		 bg.add(r1);
		 bg.add(r2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Programming ");
		lblNewLabel_1_2_1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(10, 214, 131, 20);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Language");
		lblNewLabel_1_2_2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		lblNewLabel_1_2_2.setBounds(51, 230, 75, 20);
		frame.getContentPane().add(lblNewLabel_1_2_2);
		
		JComboBox co = new JComboBox();
		co.setModel(new DefaultComboBoxModel(new String[] {"Select", "CSE", "EEE", "ECE", "IT", "MECH", "CIVIL", "MINING"}));
		co.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		co.setBounds(151, 162, 106, 22);
		frame.getContentPane().add(co);
		JCheckBox c1 = new JCheckBox("Python");
		c1.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		c1.setBounds(151, 211, 97, 23);
		frame.getContentPane().add(c1);
		
		JCheckBox c3 = new JCheckBox("C");
		c3.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		c3.setBounds(151, 253, 97, 23);
		frame.getContentPane().add(c3);
		
		JCheckBox c2 = new JCheckBox("Java");
		c2.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		c2.setBounds(270, 211, 97, 23);
		frame.getContentPane().add(c2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n=tb.getText();
				String g;
				if(r1.isSelected())
				{
				g="Male";
				}
				else if(r2.isSelected())
				{
				g="Female";
				
				}
				else
				{
				g="Invalid";
				}
				String b=(String) co.getSelectedItem();
				String p="";
				if(c1.isSelected())
				{
				p="Python";
				}
				if(c2.isSelected())
				{
				p=p+","+"Java";
				}
				if(c3.isSelected())
				{
				p=p+","+"C";
				}
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aiml","root","mrec");
					String q="insert into registration values('"+n+"','"+g+"','"+b+"','"+p+"')";
					Statement sta=con.createStatement();
					sta.execute(q);
					con.close();
					JOptionPane.showMessageDialog(btnNewButton, "Registration Successful");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 14));
		btnNewButton.setBounds(151, 324, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
