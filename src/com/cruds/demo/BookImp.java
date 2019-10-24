package com.cruds.demo;

import com.cruds.db.BookDAO;




public class BookImp {
	public static void main(String[] args){
		
		BookDAO dao=new BookDAO();
		
		Book b=new Book(101, "java", "j1", 20);
		Book b1=new Book(102, "c", "c1", 20);
		Book b2=new Book(103, "c++", "c2", 20);
		Book b3=new Book(104, "dbms", "d1", 20);
		
		boolean flag=false;
		
		flag = dao.create(b);
		flag=dao.create(b1);
		flag = dao.create(b2);
		flag=dao.create(b3);
		
		/*
		if(flag==true){
			System.out.println(" book added Successfull");
		}
		else{
			System.out.println("not added");
		}
*/
		
	}

}
