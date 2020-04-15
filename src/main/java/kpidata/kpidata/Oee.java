package kpidata.kpidata;

public class Oee {

	private String avail;
	private String qual;
	private String perf;
	
	public Oee(){}
	
	public Oee(String avail, String qual, String perf){
	    
	    this.avail = avail;
	    this.qual = qual;
	    this.perf = perf;
	   
	  }
	
	public String getAvail() {
		return avail;
	}
	public void setAvail(String avail) {
		this.avail = avail;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}
	public String getPerf() {
		return perf;
	}
	public void setPerf(String perf) {
		this.perf = perf;
	}

}
