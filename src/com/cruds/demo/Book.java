package com.cruds.demo;

public class Book extends Author {
	int bISBN;
	String btittle;
	String category;
	int Nbooks;
	
	
	
	
	public Book(int bISBN, String btittle, String category, int nbooks) {
		super();
		this.bISBN = bISBN;
		this.btittle = btittle;
		this.category = category;
		Nbooks = nbooks;
	}
	
	public int getbISBN() {
		return bISBN;
	}
	public void setbISBN(int bISBN) {
		this.bISBN = bISBN;
	}
	public String getBtittle() {
		return btittle;
	}
	public void setBtittle(String btittle) {
		this.btittle = btittle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNbooks() {
		return Nbooks;
	}
	public void setNbooks(int nbooks) {
		Nbooks = nbooks;
	}
	@Override
	public String toString() {
		return "Book [bISBN=" + bISBN + ", btittle=" + btittle + ", category=" + category + ", Nbooks=" + Nbooks + "]";
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public void printInfo()
	{
		
		System.out.println("  ISBN : " + bISBN+ ",\t tittle : " + btittle + ",\tCategory : " + category + ",\tAuthor Name : " + this.getName());
	}

	public Book(int bISBN, String btittle, String category, int nbooks,String name, String mail) {
		super(name, mail);
		this.bISBN = bISBN;
		this.btittle = btittle;
		this.category = category;
		Nbooks = nbooks;
	}

	
	

	

}
