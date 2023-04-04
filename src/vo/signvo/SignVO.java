package vo.signvo;

import java.sql.Date;
//�씠由�       �꼸?       �쑀�삎            
//-------- -------- ------------- 
//CUSTNO   NOT NULL NUMBER(6)     
//CUSTNAME          NVARCHAR2(20) 
//PHONE             NVARCHAR2(13) 
//ADDRESS           NVARCHAR2(60) 
//JOINDATE          DATE          
//GRADE             NCHAR(1)      
//CITY              NCHAR(2)      

public class SignVO {

	private int custno;
	private String custname;
	private String phone;
	private String address;
	private Date joindate;
	private String grade, city;

	public SignVO() {
	}

	public SignVO(int custno, String custname, String phone, String address, Date joindate, String grade,
			String city) {
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
