package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.Staff;
import connections.StaffDatabase;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormStaff {

	private JFrame frame;
	private JTextField sName;
	private JTextField sSex;
	private JTextField sPosition;
	private JTextField sContact;
	private JTextField sAddress;
	private JTextField sSalary;
	private JTextField sPassword;

	
	private JButton btnFormStaff;
	private JLabel passLabel;
	
	private Staff myStaff;
	private JButton btnDelete;
	
	private JFrame frameAdmin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormStaff window = new FormStaff();
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
	public FormStaff() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(173, 101, 100, 30);
		frame.getContentPane().add(lblNewLabel);
		
		sName = new JTextField();
		sName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sName.setBounds(301, 98, 200, 30);
		frame.getContentPane().add(sName);
		sName.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSex.setBounds(173, 147, 100, 30);
		frame.getContentPane().add(lblSex);
		
		sSex = new JTextField();
		sSex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sSex.setColumns(10);
		sSex.setBounds(301, 144, 200, 30);
		frame.getContentPane().add(sSex);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPosition.setBounds(173, 193, 100, 30);
		frame.getContentPane().add(lblPosition);
		
		sPosition = new JTextField();
		sPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sPosition.setColumns(10);
		sPosition.setBounds(301, 190, 200, 30);
		frame.getContentPane().add(sPosition);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContact.setBounds(173, 239, 100, 30);
		frame.getContentPane().add(lblContact);
		
		sContact = new JTextField();
		sContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sContact.setColumns(10);
		sContact.setBounds(301, 236, 200, 30);
		frame.getContentPane().add(sContact);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(173, 285, 100, 30);
		frame.getContentPane().add(lblAddress);
		
		sAddress = new JTextField();
		sAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sAddress.setColumns(10);
		sAddress.setBounds(301, 282, 200, 30);
		frame.getContentPane().add(sAddress);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalary.setBounds(173, 329, 100, 30);
		frame.getContentPane().add(lblSalary);
		
		sSalary = new JTextField();
		sSalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sSalary.setColumns(10);
		sSalary.setBounds(301, 326, 200, 30);
		frame.getContentPane().add(sSalary);
		
		 passLabel = new JLabel("Password");
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passLabel.setBounds(173, 375, 100, 30);
		frame.getContentPane().add(passLabel);
		
		sPassword = new JTextField();
		sPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sPassword.setColumns(10);
		sPassword.setBounds(301, 372, 200, 30);
		frame.getContentPane().add(sPassword);
		
		 btnFormStaff = new JButton("Create");
		btnFormStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(sName.getText().isEmpty() ||  sPosition.getText().isEmpty() || sContact.getText().isEmpty()  ) {
						JOptionPane.showMessageDialog(null, "Invalid Information");
						return;
					}
					StaffDatabase database= new StaffDatabase();
					String name= sName.getText();
					String sex=  sSex.getText();
					String position= sPosition.getText();
					String contact= sContact.getText();
					String address= sAddress.getText();
					double salary= Double.parseDouble(sSalary.getText().toString());
					String password= sPassword.getText();
					
					
					switch (btnFormStaff.getText()) {
					case "Create":	
							Staff staffCreate;
							staffCreate= new Staff(0, name, sex, position, contact, address, salary, password);
							if(database.createStaff(staffCreate) >0) {
								JOptionPane.showMessageDialog(null, "You have created a Staff Record");
							}else {
								JOptionPane.showMessageDialog(null, "Invalid Information");
							}
							
						break;
					case "Update":
						Staff staffUpdate;
						staffUpdate= new Staff(myStaff.getSid(), name, sex, position, contact, address, salary, password);
						if(database.updateStaff(staffUpdate) >0) {
							JOptionPane.showMessageDialog(null, "You have updated a Staff Record");
						}else {
							JOptionPane.showMessageDialog(null, "Invalid Information");
						}
						
						break;
					default:
						break;
					}
					
					getFrame().dispose();
					getFrameAdmin().dispose();
					Admin admin = new Admin();
					admin.getFrame().setVisible(true);
					
					database.closeConnection();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		btnFormStaff.setBounds(178, 454, 150, 30);
		frame.getContentPane().add(btnFormStaff);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(383, 454, 150, 30);
		frame.getContentPane().add(btnCancel);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StaffDatabase database= new StaffDatabase();
					if(database.deleteStaff(myStaff.getSid()) > 0) {
						JOptionPane.showMessageDialog(null, "You have updated a Staff Record");
						getFrame().dispose();
						getFrameAdmin().dispose();
						Admin admin = new Admin();
						admin.getFrame().setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Invalid Information");
					}
				} catch (Exception e2) {
					System.out.println(e);
				}
			}
		});
		btnDelete.setBounds(741, 13, 150, 30);
		frame.getContentPane().add(btnDelete);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getsName() {
		return sName;
	}

	public void setsName(JTextField sName) {
		this.sName = sName;
	}

	public JTextField getsSex() {
		return sSex;
	}

	public void setsSex(JTextField sSex) {
		this.sSex = sSex;
	}

	public JTextField getsPosition() {
		return sPosition;
	}

	public void setsPosition(JTextField sPosition) {
		this.sPosition = sPosition;
	}

	public JTextField getsContact() {
		return sContact;
	}

	public void setsContact(JTextField sContact) {
		this.sContact = sContact;
	}

	public JTextField getsAddress() {
		return sAddress;
	}

	public void setsAddress(JTextField sAddress) {
		this.sAddress = sAddress;
	}

	public JTextField getsSalary() {
		return sSalary;
	}

	public void setsSalary(JTextField sSalary) {
		this.sSalary = sSalary;
	}

	public JTextField getsPassword() {
		return sPassword;
	}

	public void setsPassword(JTextField sPassword) {
		this.sPassword = sPassword;
	}

	public JLabel getPassLabel() {
		return passLabel;
	}

	public void setPassLabel(JLabel passLabel) {
		this.passLabel = passLabel;
	}

	public JButton getBtnFormStaff() {
		return btnFormStaff;
	}

	public void setBtnFormStaff(JButton btnFormStaff) {
		this.btnFormStaff = btnFormStaff;
	}

	public Staff getMyStaff() {
		return myStaff;
	}

	public void setMyStaff(Staff myStaff) {
		this.myStaff = myStaff;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JFrame getFrameAdmin() {
		return frameAdmin;
	}

	public void setFrameAdmin(JFrame frameAdmin) {
		this.frameAdmin = frameAdmin;
	}

	
	
}
