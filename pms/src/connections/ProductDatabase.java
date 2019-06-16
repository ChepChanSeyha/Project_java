package connections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import classes.Product;

public class ProductDatabase extends Connections{

	public ProductDatabase() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public void getAllProduct(DefaultTableModel model) {
		try {
			String[] row= new String[5];
			String query= "SELECT * FROM product";
			Statement statement= super.getConnection().createStatement();
			ResultSet results= statement.executeQuery(query);
			while(results.next()) {
				row[0]= results.getInt(1)+"";
				row[1]= results.getString(1);
				row[2]= results.getString(2);
				row[3]= results.getDouble(3)+"";
				row[4]= results.getDouble(4)+"";
				row[5]= results.getString(5);
				
				model.addRow(row);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Product getProductById(int id) {
		Product product= null;
		try {
			String query= "SELECT * FROM product WHERE ProductId = ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, id);
			ResultSet results= pStatement.executeQuery();
			while(results.next()) {
				int pid= results.getInt(1);
				String name= results.getString(2);
				String sup= results.getString(3);
				double sale= results.getDouble(4);
				double buy= results.getDouble(5);
				String stock= results.getString(6);
				
				product= new Product (pid, name, sup, sale, buy, stock);		
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return product;
	}
	
	public int createProduct(Product product) {
		int effectedRow=0;
		try {
			String query= "INSERT INTO staff(ProductName, Supplier, ProductSalePrice, ProductBuyPrice, InStock) VALUES(?,?,?,?,?)";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setString(1, product.getName());
			pStatement.setString(2, product.getSup());
			pStatement.setDouble(3, product.getSale());
			pStatement.setDouble(4, product.getBuy());
			pStatement.setString(5, product.getStock());
			
			effectedRow=pStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return effectedRow;
	}
	
	public int updateProduct(Product product) {
		int effectedRow=0;
		try {
			String query= "UPDATE product SET ProductName = ?,Supplier = ?, ProductSalePrice = ?, ProductBuyPrice = ?,InStock = ? WHERE StaffId = ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setString(1, product.getName());
			pStatement.setString(2, product.getSup());
			pStatement.setDouble(3, product.getSale());
			pStatement.setDouble(4, product.getBuy());
			pStatement.setString(5, product.getStock());
			
			effectedRow= pStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return effectedRow;
	}
	
	public int deleteProduct(int id) {
		int effectedRow=0;
		try {
			String query= "DELETE FROM product WHERE ProductId LIKE ?";
			PreparedStatement pStatement=super.getConnection().prepareStatement(query);
			pStatement.setInt(1, id);
			
			effectedRow= pStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return effectedRow;
	}
}
