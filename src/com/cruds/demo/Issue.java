package com.cruds.demo;

import java.util.Date;



public class Issue extends Student{

	private Date issueDate;
	private Date returnDate;
	private int bISBN;
	
	
	public Issue(String usn,String name, Date issueDate, Date returnDate, int bISBN) {
		super(usn, name);
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.bISBN = bISBN;
	}

	public Issue(String usn,String name, int bISBN) 
	{
		super(usn,name);
		this.bISBN = bISBN;		
	}
	
	
	
	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	

	public int getbIsbn() {
		return bISBN;
	}

	public void setbIsbn(int bIsbn) {
		this.bISBN = bIsbn;
	}

	@Override
	public String toString() {
		return "Issue [issueDate=" + issueDate + ", returnDate=" + returnDate + ", bISBN=" + bISBN + "]";
	}
	
	
}
