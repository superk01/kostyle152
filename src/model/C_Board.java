package model;

import java.sql.Date;

public class C_Board {
	private int q_Num;
	private String q_Title;
	private String q_Content;
	private Date q_Date;
	private int c_Num;
	private int s_Num;
	
	public C_Board(){}

	public int getQ_Num() {
		return q_Num;
	}

	public void setQ_Num(int q_Num) {
		this.q_Num = q_Num;
	}

	public String getQ_Title() {
		return q_Title;
	}



	public void setQ_Title(String q_Title) {
		this.q_Title = q_Title;
	}

	public String getQ_Content() {
		return q_Content;
	}

	public void setQ_Content(String q_Content) {
		this.q_Content = q_Content;
	}

	public Date getQ_Date() {
		return q_Date;
	}

	public void setQ_Date(Date q_Date) {
		this.q_Date = q_Date;
	}

	public int getC_Num() {
		return c_Num;
	}

	public void setC_Num(int c_Num) {
		this.c_Num = c_Num;
	}

	public int getS_Num() {
		return s_Num;
	}

	public void setS_Num(int s_Num) {
		this.s_Num = s_Num;
	}
	@Override
	public String toString() {
		return "C_Board [q_Num=" + q_Num + ", q_Title=" + q_Title + ", q_Content=" + q_Content + ", q_Date=" + q_Date
				+ ", c_Num=" + c_Num + ", s_Num=" + s_Num + "]";
	}
	
	
}
