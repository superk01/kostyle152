package Customer.model;

import java.io.Serializable;
import java.util.Date;


public class C_Board implements Serializable{
	private int q_Num;
	private String q_Title;
	private String q_Content;
	private Date q_Date;
	private String c_Id;
	private String s_Name;
	
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

	public String getC_Id() {
		return c_Id;
	}

	public void setC_Id(String c_Id) {
		this.c_Id = c_Id;
	}

	public String getS_Name() {
		return s_Name;
	}

	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}
	@Override
	public String toString() {
		return "C_Board [q_Num=" + q_Num + ", q_Title=" + q_Title + ", q_Content=" + q_Content + ", q_Date=" + q_Date
				+ ", c_Id=" + c_Id + ", s_Name=" + s_Name + "]";
	}
	
	
}
