package com.cruds.project;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cruds.db.BookDAO;
import com.cruds.db.IssueDAO;
import com.cruds.demo.Book;
import com.cruds.demo.Issue;


public class Test {

	public static void main(String[] args)  
	{
BookDAO dao=new BookDAO();
		
		
		Scanner sc = new Scanner(System.in);
		String choice = null;


		do
		{
			System.out.println("Please select yout choice");
			System.out.println("1. Add book");
			System.out.println("2. Search Book by Title");
			System.out.println("3. Search Book by Category");
			System.out.println("4. Search Book by Author");
			System.out.println("5. Display Book details");
			System.out.println("6. Issue Book to student");
			System.out.println("7. Issued Books");
			System.out.println("8. Books to be returned");
			choice = sc.nextLine();
			
			IssueDAO idao= new IssueDAO();

			switch(choice)
			{
			case "1":
				//Add Book (Finalized)
				
				System.out.println("Enter book details");
				
				System.out.println("Enter book isbn");
				String isbn = sc.nextLine();
				try{
					isbn = sc.nextLine();
					if(isbn.equals("") || isbn.equals(null)){
						throw new SQLException("Book Isbn field cannot be empty");
					}
				}
				catch(SQLException e)
				{
					while(isbn.equals("") || isbn.equals(null)){
						System.out.println("Invalid title, null\nEnter the Book Isbn again");
						isbn = sc.nextLine();	
					}
					System.out.println(e);
				}
				System.out.println("Enter book title");
				String title = sc.nextLine();
				try{
					title = sc.nextLine();
					if(title.equals("") || title.equals(null)){
						throw new SQLException("Book Title field cannot be empty");
					}
				}
				catch(SQLException e)
				{
					/*while(title.equals("") || title.equals(null)){
						System.out.println("Invalid title , null\nEnter the Book Title again");
						title = sc.nextLine();	
					}*/
					System.out.println(e);
				}
				System.out.println("Enter book category");
				String cat = sc.nextLine();
				try{
					cat = sc.nextLine();
					if(cat.equals("") || cat.equals(null)){
						throw new SQLException("Book Isbn field cannot be empty");
					}
				}
				catch(SQLException e)
				{
					/*while(cat.equals("") || cat.equals(null)){
						System.out.println("Invalid title, null\nEnter the Book Isbn again");
						cat = sc.nextLine();	
					}*/
					System.out.println(e);
				}
				System.out.println("Enter no of books");
				int nob = sc.nextInt();
				sc.nextLine();
				try {
					nob = sc.nextInt();
					if(nob <= 0){
						throw new SQLException("Number of books cannot be zero or negative number");
					}
				}
				catch (SQLException e){
					while(nob <= 0 ){
						System.out.println("Invalid number, null\nEnter no of books again");
						nob = sc.nextInt();
					}
				}
				System.out.println("Enter book Author");
				String name = sc.nextLine();
				try{
					name = sc.nextLine();
					if(name.equals("") || name.equals(null)){
						throw new SQLException("Author Name cannot be empty");
					}
				}
				catch(SQLException e)
				{
					while(name.equals("") || name.equals(null)){
						System.out.println("Invalid title, null\nEnter the Author Name again");
						name = sc.nextLine();	
					}
				}
				System.out.println("Enter Author mailId");
				String mail = sc.nextLine();
				try{
					mail = sc.nextLine();
					if(mail.equals("") || mail.equals(null)){
						throw new SQLException("Auhtor Mail Id cannot be empty");
					}
				}
				catch(SQLException e)
				{
					while(mail.equals("") || mail.equals(null)){
						System.out.println("Invalid title, null\nEnter the Auhtor Mail Id again");
						mail = sc.nextLine();	
					}
				}


				dao.create(new Book(111, "btittle", "category", 123, "name", "mail"));

				System.out.println("The book has been added");




				break;

			/*case "2":
				//Retrieving data from tables
				System.out.println("Enter title to search");
				String searchTitle=sc.nextLine();

				try{
					searchTitle = sc.nextLine();
					if(searchTitle.equals("") || searchTitle.equals(null)){
						throw new SQLException("Book Title field cannot be empty");
					}
				}
				catch(SQLException e)
				{
					while(searchTitle.equals("") || searchTitle.equals(null)){
						System.out.println("Invalid title , null\nEnter the Book Title again");
						searchTitle = sc.nextLine();	
					}
				}

				List<Book> s1list = dao.searchTitle(searchTitle);

				for(Book s : s1list)
				{
					s.printInfo();
				}

				break;


			case "3":
				System.out.println("Enter category to search");
				String searchCategory=sc.nextLine();

				try{
					searchCategory = sc.nextLine();
					if(searchCategory.equals("") || searchCategory.equals(null)){
						throw new SQLException("Book Isbn field cannot be empty");
					}
				}
				catch(SQLException e)
				{
					while(searchCategory.equals("") || searchCategory.equals(null)){
						System.out.println("Invalid title, null\nEnter the Book Isbn again");
						searchCategory = sc.nextLine();	
					}
				}
				List<Book> s2list = dao.searchCat(searchCategory);

				for(Book s : s2list)
				{
					s.printInfo();
				}

				break;


			case "4":
				System.out.println("Enter author name to search");
				String searchAuthor=sc.nextLine();

				try{
					searchAuthor = sc.nextLine();
					if(searchAuthor.equals("") || searchAuthor.equals(null)){
						throw new SQLException("Author Name cannot be empty");
					}
				}
				catch(SQLException e)
				{
					while(searchAuthor.equals("") || searchAuthor.equals(null)){
						System.out.println("Invalid title, null\nEnter the Author Name again");
						searchAuthor = sc.nextLine();	
					}
				}

				List<Book> s3list = dao.searchAuthor(searchAuthor);

				for(Book s : s3list)
				{
					s.printInfo();
				}

				break;


			case "5":
				//Retrieving all data (Finalized)
				List<Book> slist = dao.getAll();

				for(Book s : slist)
				{
					s.printInfo();
				}

				break;


			case "6":			
				idao.getBook();
				System.out.println("Select the Book ISBN");
				String bIsbn = sc.nextLine();
				System.out.println("Enter the usn and student name to issue book");
				String sUsn = sc.nextLine();
				String sName = sc.nextLine();

				try {
					if(idao.issueBook(new Issue(sName,sUsn,11)))
					{
						System.out.println("Book " + bIsbn + " is issued");
					}
				} catch(Exception e) {
					e.printStackTrace();
					
				}

				break;


			case "7":
				idao.getIssuedBook();
				break;


			case "8":
				idao.returnBook();
				break;


			default:
				break;
			}

*/
			}
		}while(!choice.equals("9"));


		sc.close();
	}

}
