package kpidata.kpidata;

public class ProdOrderList {

	private String site;
	private String order;
	
	public ProdOrderList(String site, String order)
	{
		super();
		this.site = site;
		this.order = order;
	};
	
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
}
