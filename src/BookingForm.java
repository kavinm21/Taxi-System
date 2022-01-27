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
public class BookingForm extends JFrame{
	static BookingForm frame;
	private JTextField textField_4;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BookingForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public BookingForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 414);
		setLayout(null);
		JLabel lblAddBooking = new JLabel("Add Booking ");
		lblAddBooking.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddBooking.setForeground(Color.DARK_GRAY);
		
		JLabel lblCusID = new JLabel("Customer ID:");
		JLabel lblCabType = new JLabel("Cab Type:");
		JLabel lblDistance = new JLabel("Distance:");
		JLabel lblAmount = new JLabel("Amount:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnAddBooking = new JButton("Confirm Add Booking");
		btnAddBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cust_id = Integer.parseInt(textField_1.getText());
				String cab_type = textField_2.getText(); 
				int dist = Integer.parseInt(textField_3.getText());
				int amt = Integer.parseInt(textField_4.getText());
				
				if(CustomerDao.checkCustomer(cust_id)){
				
					int i=BookingDao.addBooking(cust_id,cab_type,dist,amt);
					if(i>0){
						JOptionPane.showMessageDialog(BookingForm.this,"Added Booking successfully!");
						BookingSuccess.main(new String[]{});
						frame.dispose();
					
					}else{
						JOptionPane.showMessageDialog(BookingForm.this,"Unable to add booking!");
					}
				}else{
					JOptionPane.showMessageDialog(BookingForm.this,"Given Customer Number doesn't exist!");
				}
			}
		});
		btnAddBooking.setForeground(Color.DARK_GRAY);
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BookingSuccess.main(new String[]{});
			frame.dispose();
			}
		});
		
		lblAddBooking.setBounds(100, 30, 400, 30);
		lblCusID.setBounds(80, 70, 200, 30);
		lblCabType.setBounds(80, 110, 200, 30);
		lblDistance.setBounds(80, 150, 200, 30);
		lblAmount.setBounds(80, 190, 200, 30);
		textField_1.setBounds(300, 70, 200, 30);
		textField_2.setBounds(300, 110, 200, 30);
		textField_3.setBounds(300, 150, 200, 30);
		textField_4.setBounds(300, 190, 200, 30);
		btnBack.setBounds(50, 230, 100, 30);
		btnAddBooking.setBounds(170, 230, 200, 30);
		add(lblAddBooking);
		add(lblCusID);
		add(lblCabType);
		add(lblDistance);
		add(lblAmount);
		add(textField_1);
		add(textField_2);
		add(textField_3);
		add(textField_4);
		add(btnBack);
		add(btnAddBooking);		
	}
}
