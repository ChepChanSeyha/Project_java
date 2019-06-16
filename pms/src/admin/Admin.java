package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel; 
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Product;
import classes.Staff;
import connections.ProductDatabase;
import connections.StaffDatabase;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Admin {

	private JFrame frameAdmin;
	private JTable tableProduct;
	private JTable tableStaff;
	DefaultTableModel model;
	
	
	JPanel staff ;
	JPanel product;
	private JLabel lblNewLabel_1;
	private JButton button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frameAdmin.setVisible(true);
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
		frameAdmin = new JFrame();
		frameAdmin.setBackground(Color.WHITE);
		frameAdmin.getContentPane().setBackground(new Color(255, 255, 255));
		frameAdmin.setBounds(100, 100, 1165, 771);
		frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAdmin.getContentPane().setLayout(null);
		 
		 JButton btnStaff = new JButton("Staff");
		 btnStaff.setBounds(351, 649, 154, 47);
		 frameAdmin.getContentPane().add(btnStaff);
		 btnStaff.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 			staff.setVisible(true);
		 			product.setVisible(false);
		 	}
		 });
		 btnStaff.setForeground(new Color(0, 139, 139));
		 btnStaff.setFont(new Font("Khmer UI", Font.BOLD, 30));
		 btnStaff.setBackground(Color.WHITE);
		 
		 JButton btnProduct = new JButton("Product");
		 btnProduct.setBounds(593, 649, 154, 47);
		 frameAdmin.getContentPane().add(btnProduct);
		 btnProduct.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e1) {
		 		staff.setVisible(false);
		 		product.setVisible(true);
		 	}
		 });
		 btnProduct.setForeground(new Color(0, 139, 139));
		 btnProduct.setFont(new Font("Khmer UI", Font.BOLD, 30));
		 btnProduct.setBackground(Color.WHITE);
	
		//Staff Block
		staff = new JPanel();
		staff.setBackground(Color.WHITE);
		staff.setBounds(0, 0, 1123, 636);
		frameAdmin.getContentPane().add(staff);
		staff.setLayout(null);
		
		tableStaff = new JTable();
		tableStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int rowNumber= tableStaff.getSelectedRow();
					int sid= Integer.parseInt(tableStaff.getValueAt(rowNumber, 0).toString());
					try {
						StaffDatabase database= new StaffDatabase();
						FormStaff window = new FormStaff();
						window.getFrame().setVisible(true);
						Staff gotStaff= database.getStaffById(sid);
						
						window.setMyStaff(gotStaff);
						
						window.setFrameAdmin(getFrame());
						
						window.getsName().setText(gotStaff.getName());
						window.getsSex().setText(gotStaff.getSex());
						window.getsPosition().setText(gotStaff.getPosition());
						window.getsContact().setText(gotStaff.getContact());
						window.getsAddress().setText(gotStaff.getAddress());
						window.getsSalary().setText(gotStaff.getSalary()+"");
						window.getsPassword().setVisible(false);
						window.getPassLabel().setVisible(false);
						window.getBtnFormStaff().setText("Update");
						database.closeConnection();
						
					} catch (Exception e) {
						System.out.println(e);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		tableStaff.setBounds(0, 0, 1123, 538);
		 model= new DefaultTableModel();
		tableStaff.setModel(model);
		String[] column= {"StaffId","Name","Gender","Postion","Contact","Address","Salary"};	
		model.setColumnIdentifiers(column);
		try {
			StaffDatabase database= new StaffDatabase();
			database.getAllStaff(model);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		JLabel lblNewLabel = new JLabel("Position");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(413, 13, 260, 50);
		staff.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(1023, 39, 100, 35);
		staff.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FormStaff form= new FormStaff();
					form.getFrame().setVisible(true);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scroll1 = new JScrollPane(tableStaff);
		scroll1.setBounds(12, 95, 1111, 538);
		staff.add(scroll1);
	//End Staff Block
	
	//product Block
		product = new JPanel();
		product.setBackground(Color.WHITE);
		product.setBounds(0, 0, 1123, 636);
		frameAdmin.getContentPane().add(product);
		product.setLayout(null);
		
		tableProduct = new JTable();
		tableProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int rowNumber= tableProduct.getSelectedRow();
					int pid= Integer.parseInt(tableProduct.getValueAt(rowNumber, 0).toString());
					try {
						ProductDatabase database= new ProductDatabase();
						FormProduct window = new FormProduct();
						window.getFrame().setVisible(true);
						Product gotProduct= database.getProductById(pid);
						
						window.setMyProduct(gotProduct);
						
						window.setFrameAdmin(getFrame());
						
						window.getpName().setText(gotProduct.getName());
						window.getSupplier().setText(gotProduct.getSup());
						window.getpSalePrice().setText(gotProduct.getSale()+"");
						window.getpBuyPrice().setText(gotProduct.getBuy()+"");
						window.getInStock().setText(gotProduct.getStock());
						window.getPassLabel().setVisible(false);
						window.getBtnFormProduct().setText("Update");
						database.closeConnection();
						
					} catch (Exception e) {
						System.out.println(e);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		tableProduct.setBounds(0, 0, 1123, 538);
		DefaultTableModel modelProduct= new DefaultTableModel();
		tableProduct.setModel(modelProduct);
		String[] column1= {"ProductId","ProductName","Supplier","Product sale price","Product by price","In stock"};	
		modelProduct.setColumnIdentifiers(column1);
			//End Product Block
				
				lblNewLabel_1 = new JLabel("Product");
				lblNewLabel_1.setBounds(413, 13, 260, 50);
				product.add(lblNewLabel_1);
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		button = new JButton("Add");
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(1023, 39, 100, 35);
		product.add(button);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FormProduct form= new FormProduct();
					form.getFrame().setVisible(true);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
		
//		String[][] data;
	
		JScrollPane scroll2 = new JScrollPane(tableProduct);
		scroll2.setBounds(12, 95, 1111, 538);
		product.add(scroll2);
	}

	public JFrame getFrame() {
		return frameAdmin;
	}

	public void setFrame(JFrame frame) {
		this.frameAdmin = frame;
	}
}
