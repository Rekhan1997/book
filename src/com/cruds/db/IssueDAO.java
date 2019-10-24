package com.cruds.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.cruds.demo.Book;
import com.cruds.demo.Issue;



public class IssueDAO {
	
	public void getBook()
	{
		String sql= "select b.bISBN,b.btittle,b.category,b.Nbooks,a.name,a.mail from book b, author a,issue i where b.bISBN=a.bISBN";
		List<Book> bookList = new ArrayList<>();
		Book temp = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				temp = new Book(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
				bookList.add(temp);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		System.out.println("Available Books");
		for(Book s : bookList)
		{
			s.printInfo();
		}
		
		
	}
	
	//inserting values to issue & student tables
	public boolean issueBook(Issue issue)
	{
		String sql = "insert into student values(?,?)";
		int rows = 0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, issue.getUsn());
			ps.setString(2, issue.getName());
			
			rows = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		String sql1 = "insert into Issue values(?,?,?,?)";
		
		int rows1=0;
		
		try(Connection conn=DBConnectionManager.getConnection())
		{
			PreparedStatement ps=conn.prepareStatement(sql1);
			//ps.setInt(1, issue.getId());
			Calendar cal = Calendar.getInstance();
			java.sql.Date dd = new java.sql.Date(cal.getTime().getTime());
			ps.setDate(1, dd);
			
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			cal.add(Calendar.DAY_OF_MONTH, 7);
			java.sql.Date dd1 = new java.sql.Date(cal.getTime().getTime()); 
			//java.sql.Date dd2 = new java.sql.Date(cal.getTime().getTime()); 
			System.out.println(dd1);
			ps.setDate(3, dd1);
			ps.setDate(2, dd1);
			ps.setString(1, issue.getUsn());
			ps.setInt(4, issue.getbIsbn());
			
			rows1 = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		String sql2 = "update Book b, Issue i set Nbooks=Nbooks-1 where b.bISBN=(?)";
		int rows2 =0;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql2);
			ps.setInt(1, issue.getbIsbn());
			
			rows2 = ps.executeUpdate();
		} catch (SQLException e) {
					e.printStackTrace();
		}
		
		return rows > 0 && rows == rows1 && rows2 == 1;
		
	}
	
	//Retrieving all data from student, Issue & book tables for issued books
		public void getIssuedBook() 
		{
			
			String sql = "select b.bISBN, b.btittle,s.name,i.issueDate,i.returnDate from book b, Issue i, student s where b.bISBN=i.bISBN and i.usn=s.usn";
			
						
			try(Connection conn = DBConnectionManager.getConnection())
			{
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
							
				while(rs.next())
				{
					System.out.println("book ISBN:" +rs.getInt(1) + "\t Book tittle : " + rs.getString(2) + "\t Name : " + rs.getString(3) + "\t Issue Date : " + rs.getDate(4)+"\t Return Date : " + rs.getDate(5));

				}
							
							
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
		}

		//data based on current date 
		public void returnBook() 
		{
			
		
			String sql = "select b.btittle,s.name,i.returnDate from book b, Issue i, student s where b.bIsbn=i.bIsbn and i.usn=s.usn and i.returnDate=(?)";
			
			
			try(Connection conn = DBConnectionManager.getConnection())
			{
				Calendar cal = Calendar.getInstance();
				java.sql.Date dd = new java.sql.Date(cal.getTime().getTime());
				
				
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setDate(1, dd);
				ResultSet rs = ps.executeQuery();
							
				while(rs.next())
				{
					System.out.println(" Book tittle : " + rs.getString(1) + "\t Name : " + rs.getString(2) + "\t Return Date : " + rs.getDate(3));

				}
							
							
			} catch (SQLException e) {
				e.printStackTrace();
			}


			
		}	




}
