package Controller;

import ExceptionHandling.*;
import Model.BookModel;
import Model.MemberModel;
import Model.MembershipCard;

import java.util.HashMap;
import java.util.Map;

public class LibraryController {
    private Map<String, BookModel> books;
    private Map<String, MemberModel> members;
    private String loggedInAdminRole;
    private String loggedInMemberRole;
    

    public LibraryController() {
        this.books = new HashMap<>();
        this.members = new HashMap<>();
    }

    // Login method
    public void login(String username, String password) throws InvalidLoginException {
        if ("Iresha".equals(username) && "1111".equals(password)) {
            loggedInAdminRole = "Admin";
        } else if ("member".equals(username) && "1234".equals(password)) {
            loggedInMemberRole = "Member";
        } else {
            throw new InvalidLoginException("Invalid username or password!");
        }
    }

    // Add a new book
    public void addBook(String bookId, String bookname, String author, String publisher, String search) throws EmptyFieldException {
        if (bookId.isEmpty() || bookname.isEmpty() || author.isEmpty()) {
            throw new EmptyFieldException("All fields are required to add a book!");
        }
        
        books.put(bookId, new BookModel(bookId, bookname, author, publisher, search));
        System.out.println("Book added successfully!");
    }

    // Add a new member
    public void addMember(String id, String memberName, String email, String contact, String membershipCard, MembershipCard card) throws EmptyFieldException {
        
        if (id.isEmpty() || memberName.isEmpty() || contact.isEmpty()) {
            throw new EmptyFieldException("All fields are required to add a member!");
        }
        members.put(id, new MemberModel(id, memberName, email, contact, card));
        System.out.println("Member added successfully!");
    }

    // Borrow a book
    public void borrowBook(String bookId, String memberId) throws PermissionDeniedException, EmptyFieldException {
        
        
        if (!"Member".equals(loggedInMemberRole)) {
            throw new PermissionDeniedException("Only members can borrow books!");
        }
        if (bookId.isEmpty() || memberId.isEmpty()) {
            throw new EmptyFieldException("Both Book ID and Member ID are required to borrow a book!");
        }
        BookModel book = books.get(bookId);
        MemberModel member = members.get(memberId);
        if (book == null) { // Check if book is null
        System.out.println("Book with ID " + bookId + " does not exist!");
        return;
    }
    if (member == null) { // Check if member is null
        System.out.println("Member with ID " + memberId + " does not exist!");
        return;
    }
        book.addBorrower(member); // Safe to call
        System.out.println(member.getMemberName() + " borrowed " + book.getBookname());
    }

    // Get book details
    public void getBookDetails(String bookId) {
        BookModel book = books.get(bookId);
        
        if (book == null) {
            throw new IllegalArgumentException("Book with ID " + bookId + " does not exist.");
        }
         if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book with ID " + bookId + " not found!");
        }
    }
}
