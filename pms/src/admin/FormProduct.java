package admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classes.Product;
import connections.ProductDatabase;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormProduct {

	private JFrame frame;
	private JTextField pID;
	private JTextField pName;
	private JTextField Supplier;
	private JTextField pSalePrice;
	private JTextField pBuyPrice;
	private JTextField InStock;

	
	private JButton btnFormProduct;
	private JLabel passLabel;
	
	private Product myProduct;
	private JButton btnDelete;
	
	private JFrame frameAdmin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProduct window = new FormProduct();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormProduct() {
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
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(173, 101, 100, 30);
		frame.getContentPane().add(lblNewLabel);
		
		pID = new JTextField();
		pID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pID.setBounds(301, 98, 200, 30);
		frame.getContentPane().add(pID);
		pID.setColumns(10);
		
		JLabel lblSex = new JLabel("Product Name");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSex.setBounds(173, 147, 100, 30);
		frame.getContentPane().add(lblSex);
		
		pName = new JTextField();
		pName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pName.setColumns(10);
		pName.setBounds(301, 144, 200, 30);
		frame.getContentPane().add(pName);
		
		JLabel lblPosition = new JLabel("Supplier");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPosition.setBounds(173, 193, 100, 30);
		frame.getContentPane().add(lblPosition);
		
		Supplier = new JTextField();
		Supplier.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Supplier.setColumns(10);
		Supplier.setBounds(301, 190, 200, 30);
		frame.getContentPane().add(Supplier);
		
		JLabel lblContact = new JLabel("Prodcut Sales Price");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContact.setBounds(173, 239, 100, 30);
		frame.getContentPane().add(lblContact);
		
		pSalePrice = new JTextField();
		pSalePrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pSalePrice.setColumns(10);
		pSalePrice.setBounds(301, 236, 200, 30);
		frame.getContentPane().add(pSalePrice);
		
		JLabel lblAddress = new JLabel("Product Buy Price");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(173, 285, 100, 30);
		frame.getContentPane().add(lblAddress);
		
		pBuyPrice = new JTextField();
		pBuyPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pBuyPrice.setColumns(10);
		pBuyPrice.setBounds(301, 282, 200, 30);
		frame.getContentPane().add(pBuyPrice);
		
		JLabel lblSalary = new JLabel("In Stock");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSalary.setBounds(173, 329, 100, 30);
		frame.getContentPane().add(lblSalary);
		
		InStock = new JTextField();
		InStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		InStock.setColumns(10);
		InStock.setBounds(301, 326, 200, 30);
		frame.getContentPane().add(InStock);
		
		 btnFormProduct = new JButton("Create");
		 btnFormProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if( pID.getText().isEmpty() || pName.getText().isEmpty() ||  Supplier.getText().isEmpty() || pSalePrice.getText().isEmpty() || pBuyPrice.getText().isEmpty() || InStock.getText().isEmpty() ) {
						JOptionPane.showMessageDialog(null, "Invalid Information");
						return;
					}
					ProductDatabase database= new ProductDatabase();
					String name=  pName.getText();
					String sup= Supplier.getText();
					double sale= Double.parseDouble(pSalePrice.getText());
					double buy= Double.parseDouble(pBuyPrice.getText());
					String stock= toString();
					
					
					switch (btnFormProduct.getText()) {
					case "Create":	
							Product productCreate;
							productCreate= new Product(0, name, sup, sale, buy, stock);
							if(database.createProduct(productCreate) >0) {
								JOptionPane.showMessageDialog(null, "You have created a Product Record");
							}else {
								JOptionPane.showMessageDialog(null, "Invalid Information");
							}
							
						break;
					case "Update":
						Product productUpdate;
						productUpdate= new Product(myProduct.getPid(), stock, stock, buy, buy, stock);
						if(database.updateProduct(productUpdate) >0) {
							JOptionPane.showMessageDialog(null, "You have updated a Product Record");
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
		btnFormProduct.setBounds(178, 454, 150, 30);
		frame.getContentPane().add(btnFormProduct);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(383, 454, 150, 30);
		frame.getContentPane().add(btnCancel);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProductDatabase database= new ProductDatabase();
					if(database.deleteProduct(myProduct.getPid()) > 0) {
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

	public JTextField getpID() {
		return pID;
	}

	public void setpID(JTextField pID) {
		this.pID = pID;
	}

	public JTextField getpName() {
		return pName;
	}

	public void setpName(JTextField pName) {
		this.pName = pName;
	}

	public JTextField getSupplier() {
		return Supplier;
	}

	public void setSupplier(JTextField supplier) {
		Supplier = supplier;
	}

	public JTextField getpSalePrice() {
		return pSalePrice;
	}

	public void setpSalePrice(JTextField pSalePrice) {
		this.pSalePrice = pSalePrice;
	}

	public JTextField getpBuyPrice() {
		return pBuyPrice;
	}

	public void setpBuyPrice(JTextField pBuyPrice) {
		this.pBuyPrice = pBuyPrice;
	}

	public JTextField getInStock() {
		return InStock;
	}

	public void setInStock(JTextField inStock) {
		InStock = inStock;
	}

	public JButton getBtnFormProduct() {
		return btnFormProduct;
	}

	public void setBtnFormProduct(JButton btnFormProduct) {
		this.btnFormProduct = btnFormProduct;
	}

	public JLabel getPassLabel() {
		return passLabel;
	}

	public void setPassLabel(JLabel passLabel) {
		this.passLabel = passLabel;
	}

	public Product getMyProduct() {
		return myProduct;
	}

	public void setMyProduct(Product myProduct) {
		this.myProduct = myProduct;
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
