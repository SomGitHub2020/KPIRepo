package kpidata.kpidata;

public class OrderDetail{
	  
	private String ordernum;
	private String actual;
	private String target;


	public OrderDetail(){}

	public OrderDetail(String actual, String target){

		this.actual = actual;
		this.target = target;

	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	
	public String getActual() {
		return actual;
	}

	public void setActual(String actual) {
		this.actual = actual;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	 
}

