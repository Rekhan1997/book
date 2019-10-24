package com.cruds.db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.demo.Author;
import com.cruds.demo.Book;


public class BookDAO {
	public boolean create(Book book)
	{


		String insertSQL = "insert into book values(?,?,?,?)";
		int row=0;

		try(Connection con=DBConnectionManager.getConnection())
		{


			PreparedStatement ps = con.prepareStatement(insertSQL);
			ps.setInt(1, book.getbISBN());
			ps.setString(2, book.getBtittle());
			ps.setString(3, book.getCategory());
			ps.setInt(4, book.getNbooks());
			row = ps.executeUpdate();


		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		

		String sql1 = "insert into author values(?,?,?)";

		int rows1 = 0;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			//Author a = new Author();
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setString(1, book.getName());
			ps.setString(2, book.getMail());
			ps.setInt(3, book.getbISBN());
			rows1 = ps.executeUpdate();

		}catch (SQLException e)
		{
			e.printStackTrace();
		}

		return row > 0 && row == rows1 ;


	}
	//search by title	
	public List<Book> searchTitle(String title) {
		String sql=null;
		sql = "select b.bISBN,b.btittle,b.category,b.Nbooks,a.name,a.mail from book b, author a where b.bISBN = a.bISBN and b.btittle LIKE(?) and b.Nbooks!=0";

		List<Book> bookList = new ArrayList<>();
		Book temp = null;

		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + title + "%");
			ResultSet rs = ps.executeQuery();

			while (rs != null && rs.next()) {
				temp = new Book(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5), rs.getString(6));
				bookList.add(temp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(bookList.isEmpty()){
			System.out.println("No books found");
		}
		return bookList;

	}

	//search by category	
	public List<Book> searchCat(String category) 
	{
		String sql=null;
		sql = "select b.bISBN,b.btittle,b.category,b.Nbooks,a.name,a.mail from book b, author a where b.bISBN = a.bISBN and b.category LIKE(?) and b.Nbooks!=0";

		List<Book> bookList = new ArrayList<>();
		Book temp = null;


		try (Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, "%" + category + "%");


			ResultSet rs = ps.executeQuery();

			while (rs != null && rs.next()) 
			{
				temp = new Book(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5), rs.getString(6));
				bookList.add(temp);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		if(bookList.isEmpty()){
			System.out.println("No books found");
		}
		return bookList;

	}

	//search by author name	
	public List<Book> searchAuthor(String authorName) 
	{
		String sql=null;
		sql = "select b.bISBN, b.btittle,b.category,b.Nbooks,a.name,a.mail from book b, author a where b.bISBN = a.bISBN and a.name LIKE(?) and b.Nbooks!=0";

		List<Book> bookList = new ArrayList<>();
		Book temp = null;


		try (Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + authorName + "%");

			ResultSet rs = ps.executeQuery();

			while (rs != null && rs.next()) {

				temp = new Book(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5), rs.getString(6));
				bookList.add(temp);

			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		if(bookList.isEmpty()){
			System.out.println("No books found");
		}
		return bookList;

	}
	//getting all data from book
	public List<Book> getAll()
	{
		String sql = "select b.bISBN,b.btittle,b.category,b.Nbooks,a.name,a.mail from book b, author a where b.bISBN=a.bISBN";
		List<Book> bookList = new ArrayList<>();
		Book temp = null;

		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs!=null && rs.next())
			{
				temp = new Book(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
				bookList.add(temp);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return bookList;
	}





}
