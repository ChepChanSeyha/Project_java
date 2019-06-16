package connections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import classes.Staff;

public class StaffDatabase extends Connections{

	public StaffDatabase() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public void getAllStaff(DefaultTableModel model) {
		try {
			String[] row= new String[7];
			String query= "SELECT * FROM staff";
			Statement statement= super.getConnection().createStatement();
			ResultSet results= statement.executeQuery(query);
			while(results.next()) {
				row[0]= results.getInt(1)+"";
				row[1]= results.getString(2);
				row[2]= results.getString(3);
				row[3]= results.getString(4);
				row[4]= results.getString(5);
				row[5]= results.getString(6);
				row[6]= results.getDouble(7)+"";
				
				model.addRow(row);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Staff getStaffById(int id) {
		Staff staff=null;
		try {
			String query= "SELECT * FROM staff WHERE StaffId = ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setInt(1, id);
			ResultSet results= pStatement.executeQuery();
			while(results.next()) {
				int sid= results.getInt(1);
				String name= results.getString(2);
				String sex= results.getString(3);
				String position= results.getString(4);
				String contact= results.getString(5);
				String address= results.getString(6);
				double salary= results.getDouble(7);
				
				staff= new Staff(sid, name, sex, position, contact, address, salary, "");		
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return staff;
	}
	
	public int createStaff(Staff staff) {
		int effectedRow=0;
		try {
			String query= "INSERT INTO staff(Name,Sex,Position,Contact,Address,Salary,Password) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setString(1, staff.getName());
			pStatement.setString(2, staff.getSex());
			pStatement.setString(3, staff.getPosition());
			pStatement.setString(4, staff.getContact());
			pStatement.setString(5, staff.getAddress());
			pStatement.setDouble(6, staff.getSalary());
			pStatement.setString(7, staff.getPassword());
			
			effectedRow=pStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return effectedRow;
	}
	
	public int updateStaff(Staff staff) {
		int effectedRow=0;
		try {
			String query= "UPDATE staff SET Name = ?,Sex = ?, Position = ?, Contact = ?,Address = ?, Salary = ? WHERE StaffId = ?";
			PreparedStatement pStatement= super.getConnection().prepareStatement(query);
			pStatement.setString(1, staff.getName());
			pStatement.setString(2, staff.getSex());
			pStatement.setString(3, staff.getPosition());
			pStatement.setString(4, staff.getContact());
			pStatement.setString(5, staff.getAddress());
			pStatement.setDouble(6, staff.getSalary());
			pStatement.setInt(7, staff.getSid());
			
			effectedRow= pStatement.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return effectedRow;
	}
	
	public int deleteStaff(int id) {
		int effectedRow=0;
		try {
			String query= "DELETE FROM staff WHERE StaffId LIKE ?";
			PreparedStatement pStatement=super.getConnection().prepareStatement(query);
			pStatement.setInt(1, id);
			
			effectedRow= pStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		return effectedRow;
	}
}
