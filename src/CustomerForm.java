import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
//19pd18 & 19pd33 Kavin M & Shankar Subramanian
public class CustomerForm extends JFrame{
	static CustomerForm frame;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new CustomerForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public CustomerForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		setLayout(null);
		JLabel lblAddCustomer = new JLabel("Add Customer");
		lblAddCustomer.setBackground(Color.DARK_GRAY);
		lblAddCustomer.setFont(new Font("Ariel", Font.PLAIN,22));
		
		JLabel lblname = new JLabel("Name: ");
		JLabel lblnum = new JLabel("Mobile Number: ");
		textField = new JTextField();
		textField.setColumns(10);
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm to add Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String num=textField_1.getText();

			int i=CustomerDao.addCustomer(name, num);
			if(i>0){
				JOptionPane.showMessageDialog(CustomerForm.this,"Customer added successfully!");
				CustomerSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(CustomerForm.this,"Sorry, unable to save!");
			}
			}
		});
		btnNewButton.setForeground(Color.DARK_GRAY);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			CustomerSuccess.main(new String[]{});
			frame.dispose();
			}
		});
		
		lblAddCustomer.setBounds(100, 30, 400, 30);
		lblname.setBounds(80, 70, 200, 30);
		lblnum.setBounds(80, 110, 200, 30);
		textField.setBounds(300, 70, 200, 30);
		textField_1.setBounds(300, 110, 200, 30);
		btnBack.setBounds(50, 150, 100, 30);
		btnNewButton.setBounds(170, 150, 200, 30);
		add(lblAddCustomer);
		add(lblname);
		add(lblnum);
		add(textField);
		add(textField_1);
		add(btnBack);
		add(btnNewButton);
	}
}
