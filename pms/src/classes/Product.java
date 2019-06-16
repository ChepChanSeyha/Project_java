package classes;

public class Product {
	
	private int pid;
	private String name;
	private String sup;
	private double sale;
	private double buy;
	private String stock;
	
	public Product(int pid, String name, String sup, double sale, double buy, String stock) {
		this.pid = pid;
		this.name = name;
		this.sup = sup;
		this.sale = sale;
		this.buy = buy;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", sup=" + sup + ", sale=" + sale + ", buy=" + buy
				+ ", stock=" + stock + "]";
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSup() {
		return sup;
	}

	public void setSup(String sup) {
		this.sup = sup;
	}

	public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

}
