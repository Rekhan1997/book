package com.cruds.project;


import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.security.auth.Subject;

import com.cruds.db.BookDAO;
import com.cruds.db.IssueDAO;
import com.cruds.demo.Book;
import com.cruds.demo.Issue;
import com.cruds.demo.Student;

public class Test11 {
	public static void main(String[] args)  
	{
		BookDAO dao=new BookDAO();


		/*Book b=new Book(101, "java", "j1", 20);
		Book b1=new Book(102, "c", "c1", 20);
		Book b2=new Book(103, "c++", "c2", 20);
		Book b3=new Book(104, "dbms", "d1", 20);

		boolean flag=false;

		flag = dao.create(b);
		flag=dao.create(b1);
		flag = dao.create(b2);
		flag=dao.create(b3);*/
	
		Student dao1=new Student();
		
		Student s1=new Student("15cs074", "rekha");
	Student s2=new Student("15cs075","ram");
	
		boolean flag=false;

		IssueDAO dao2=new IssueDAO();
		
		//Issue i1=new Issue("15cs074", "rekha",19-jan-2019,2019-10-27, 1);
		
		
		/*Issue u1=new Issue("15cs074", "rekha", 1);
		Issue u2=new Issue("15cs075", "sagar", 2);
		Issue u3=new Issue("15cs076", "jaysi", 3);

		flag=dao2.issueBook(u1);
		flag=dao2.issueBook(u2);
		flag=dao2.issueBook(u3);*/



		

	
		
		
		
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
				int isbn = sc.nextInt();
				sc.nextLine();
				/*try{
					isbn = sc.nextInt();
					if(isbn!=0){
						throw new SQLException("Book Isbn field cannot be empty");
					}
				}
				catch(SQLException e)
				{
					while(isbn!=0){
						System.out.println("Invalid title, null\nEnter the Book Isbn again");
						isbn = sc.nextInt();	
					}
					System.out.println(e);
				}
				 */
				System.out.println("Enter book title");
				String title = sc.nextLine();
				sc.nextLine();
				/*try{
					title = sc.nextLine();
					if(title.equals("") || title.equals(null)){
						throw new SQLException("Book Title field cannot be empty");
					}
				}
				catch(SQLException e)
				{
					while(title.equals("") || title.equals(null)){
						System.out.println("Invalid title , null\nEnter the Book Title again");
						title = sc.nextLine();	
					}
					System.out.println(e);
				}
				 */

				System.out.println("Enter book category");
				String cat = sc.nextLine();

				System.out.println("Enter no of books");
				int nob = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter book Author");
				String name = sc.nextLine();

				System.out.println("Enter Author mailId");
				String mail = sc.nextLine();

				Book b = new Book(isbn,title,cat,nob,name,mail);
				System.out.println(b);
				dao.create(b);

				System.out.println("The book has been added");




				break;

			case "2":
				//Retrieving data from tables
				System.out.println("Enter title to search");
				String searchTitle=sc.nextLine();

				try{

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
				int bISBN = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the usn to issue book");
				String usn = sc.nextLine();
			
				System.out.println("Enter the student name to issue book");
				String name1 = sc.nextLine();

				try {
					if(idao.issueBook(new Issue(usn, name1, bISBN)))
					{
						System.out.println("Book " + bISBN + " is issued");
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


		}while(!choice.equals("9"));


		sc.close();
	}

}



