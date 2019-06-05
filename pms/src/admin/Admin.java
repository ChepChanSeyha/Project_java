package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Admin {

	private JFrame frame;
	private JTable tableProduct;
	private JTable tableStaff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1165, 771);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 99, 71));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 13, 1147, 56);
		frame.getContentPane().add(panel);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setForeground(new Color(0, 139, 139));
		lblPosition.setFont(new Font("Khmer UI", Font.BOLD, 40));
		lblPosition.setBackground(Color.WHITE);
		panel.add(lblPosition);
		
		JPanel staff = new JPanel();
		staff.setBackground(Color.WHITE);
		staff.setBounds(12, 98, 1123, 538);
		frame.getContentPane().add(staff);
		staff.setLayout(null);
		
		tableStaff = new JTable();
		tableStaff.setBounds(0, 0, 1123, 538);
		DefaultTableModel model= new DefaultTableModel();
		tableStaff.setModel(model);
		tableStaff.setBounds(129, 100, 500, 100);
		frame.getContentPane().add(tableStaff);
		String[] column= {"StaffId","Name","Gender","Postion","Contact","Address","Salary"};	
		model.setColumnIdentifiers(column);
		String[][] data= {
				{"1","asd","asdads"},
				{"2","asd","asdads"},
				{"3","asd","asdads"}
				};
		model.addRow(data[0]);
		model.addRow(data[1]);
		model.addRow(data[2]);
		
		JScrollPane scroll1 = new JScrollPane(tableStaff);
		scroll1.setBounds(0, 0, 1123, 538);
		staff.add(scroll1);
		
		JPanel product = new JPanel();
		product.setBackground(Color.WHITE);
		product.setBounds(12, 98, 1123, 538);
		frame.getContentPane().add(product);
		product.setLayout(null);
		
		tableProduct = new JTable();
		tableProduct.setBounds(0, 0, 1123, 538);
		DefaultTableModel model1= new DefaultTableModel();
		tableProduct.setModel(model1);
		String[] column1= {"ProductId","ProductName","Supplier","Product sale price","Product by price","In stock"};	
		model1.setColumnIdentifiers(column1);
		String[][] data1= {
				{"1","asd","asdads"},
				{"2","asd","asdads"},
				{"3","asd","asdads"}
				};
		model1.addRow(data1[0]);
		model1.addRow(data1[1]);
		model1.addRow(data1[2]);
		
		JScrollPane scroll2 = new JScrollPane(tableProduct);
		scroll2.setBounds(0, 0, 1123, 538);
		product.add(scroll2);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(new Color(0, 139, 139));
		separator.setBounds(10, 82, 1125, 2);
		frame.getContentPane().add(separator);
		
		JButton btnStaff = new JButton("Staff");
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStaff.setForeground(new Color(0, 139, 139));
		btnStaff.setFont(new Font("Khmer UI", Font.BOLD, 30));
		btnStaff.setBackground(Color.WHITE);
		btnStaff.setBounds(398, 649, 154, 47);
		frame.getContentPane().add(btnStaff);
		
		JButton btnProduct = new JButton("Product");
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
			}
		});
		btnProduct.setForeground(new Color(0, 139, 139));
		btnProduct.setFont(new Font("Khmer UI", Font.BOLD, 30));
		btnProduct.setBackground(Color.WHITE);
		btnProduct.setBounds(593, 649, 154, 47);
		frame.getContentPane().add(btnProduct);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
