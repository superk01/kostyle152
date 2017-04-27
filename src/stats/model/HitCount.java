package stats.model;

import java.io.Serializable;

public class HitCount implements Serializable{
	private String s_num;
	private String cnt_prdurl;
	private String cnt_date;
	private String c_num;
	
	public HitCount(){}
	
	public HitCount(String s_num, String cnt_prdurl, String cnt_date, String c_num) {
		super();
		this.s_num = s_num;
		this.cnt_prdurl = cnt_prdurl;
		this.cnt_date = cnt_date;
		this.c_num = c_num;
	}

	public String getS_num() {
		return s_num;
	}

	public void setS_num(String s_num) {
		this.s_num = s_num;
	}

	public String getCnt_prdurl() {
		return cnt_prdurl;
	}

	public void setCnt_prdurl(String cnt_prdurl) {
		this.cnt_prdurl = cnt_prdurl;
	}

	public String getCnt_date() {
		return cnt_date;
	}

	public void setCnt_date(String cnt_date) {
		this.cnt_date = cnt_date;
	}

	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	
	
	
	
}
