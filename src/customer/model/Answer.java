package customer.model;

import java.io.Serializable;
import java.sql.Date;

public class Answer implements Serializable{
	private String as_num;
	private String as_Content;
	private String as_Title;
	private Date as_Date;
	private int q_Num;
	
	public Answer(){}

	public Answer(String as_num, String as_Content, String as_Title, Date as_Date, int q_Num) {
		super();
		this.as_num = as_num;
		this.as_Content = as_Content;
		this.as_Title = as_Title;
		this.as_Date = as_Date;
		this.q_Num = q_Num;
	}

	public String getAs_num() {
		return as_num;
	}

	public void setAs_num(String as_num) {
		this.as_num = as_num;
	}

	public String getAs_Content() {
		return as_Content;
	}

	public void setAc_Content(String ac_Content) {
		this.as_Content = ac_Content;
	}

	public String getAs_Title() {
		return as_Title;
	}

	public void setAs_Title(String as_Title) {
		this.as_Title = as_Title;
	}

	public Date getAs_Date() {
		return as_Date;
	}

	public void setAs_Date(Date as_Date) {
		this.as_Date = as_Date;
	}

	public int getQ_Num() {
		return q_Num;
	}

	public void setQ_Num(int q_Num) {
		this.q_Num = q_Num;
	}
	
}
