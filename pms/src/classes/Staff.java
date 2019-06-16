package classes;

public class Staff {
	private int sid;
	private String Name;
	private String sex;
	private String position;
	private String contact;
	private String address;
	private double salary;
	private String password;
	
	
	public Staff(int sid, String name, String sex, String position, String contact, String address, double salary,
			String password) {
		super();
		this.sid = sid;
		this.Name = name;
		this.sex = sex;
		this.position = position;
		this.contact = contact;
		this.address = address;
		this.salary = salary;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Staff [sid=" + sid + ", Name=" + Name + ", sex=" + sex + ", position=" + position + ", contact="
				+ contact + ", address=" + address + ", salary=" + salary + ", password=" + password + "]";
	}

	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
