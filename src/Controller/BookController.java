
package Controller;

import Model.BookModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookController {
    private Connection con;

    public BookController() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public boolean addBook(BookModel book) {
        try {
            PreparedStatement pst = con.prepareStatement("INSERT INTO book(bookId, bookname, author, publisher) VALUES (?, ?, ?, ?)");
            pst.setString(1, book.getBookId());
            pst.setString(2, book.getBookname());
            pst.setString(3, book.getAuthor());
            pst.setString(4, book.getPublisher());
            pst.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     public boolean updateBook(BookModel book) {
        try {
            PreparedStatement pst = con.prepareStatement("UPDATE book SET bookname = ?, author = ?, publisher = ? WHERE bookId = ?");
            pst.setString(1, book.getBookname());
            pst.setString(2, book.getAuthor());
            pst.setString(3, book.getPublisher());
            pst.setString(4, book.getBookId());
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     public boolean deleteBook(String bookId) {
        try {
            PreparedStatement pst = con.prepareStatement("DELETE FROM book WHERE bookId = ?");
            pst.setString(1, bookId);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     public List<BookModel> searchBooks(String bookname) {
        return searchBooks(bookname, null);
    }

    // Search Book by title and author
    public List<BookModel> searchBooks(String bookname, String author) {
        List<BookModel> books = new ArrayList<>();
        try {
            String query = "SELECT * FROM book WHERE bookname LIKE ?";
            if (author != null) query += " AND author LIKE ?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, "%" + bookname + "%");
            if (author != null) pst.setString(2, "%" + author + "%");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                BookModel book=new BookModel(
                    rs.getString("bookId"),
                    rs.getString("bookname"),
                    rs.getString("author"),
                    rs.getString("publisher"),
                    rs.getString("search")    
                        
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    
}
    
