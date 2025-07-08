
package Model;

import java.util.ArrayList;
import java.util.List;


public class BookModel {
    private String bookId;
    private String bookname;
    private String author;
    private String publisher;
    private String search;
    private List<MemberModel> borrowers;
    
    public BookModel(String bookId, String bookname, String author, String publisher, String search){
        this.bookId=bookId;
        this.bookname=bookname;
        this.author=author;
        this.publisher=publisher;
        this.search=search;
        this.borrowers = new ArrayList<>();
        
    }
    public String getBookId(){
        return bookId;
    
    }
    public void setBookId(String bookId){
        this.bookId=bookId;
        
    }
    public String getBookname(){
        return bookname;
    
    }
    public void setBookname(String bookname){
        this.bookname=bookname;
    
    }
    public String getAuthor(){
        return author;
    
    }
    public void setAuthor(String author){
        this.author=author;
    
    }
    public String getPublisher(){
        return publisher;
    
    }
    public void setPublisher(String publisher){
        this.publisher=publisher;
    
    }
    public List<MemberModel> getBorrowers() {
        return borrowers;
    }

    public void addBorrower(MemberModel member) {
        if (member != null) {
            borrowers.add(member);
        }
        
    } 
    @Override
    public String toString() {
        return "Book [Id=" + bookId + ", Title=" + bookname + ", Author=" + author + ", Borrowers=" + borrowers.size() + "]";
    }
}
