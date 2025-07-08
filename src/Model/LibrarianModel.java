
package Model;


public class LibrarianModel {
    private int lId;
    private String name;
    private String email;
    private int contact;
    
    public LibrarianModel(int lId, String name, String email, int contact){
        this.lId=lId;
        this.name=name;
        this.email=email;
        this.contact=contact;
          
    
    }
    public int getLId(){
        return lId;
    
    }
    public void setLId(int lId){
        this.lId=lId;
    
    }
    public String getName(){
        return name;
    
    }
    public void setName(String name){
        this.name=name;
    
    }
    public String getEmail(){
        return email;
    
    }
    public void setEmail(String email){
        this.email=email;
        
    }
    public int getContact(){
        return contact;
    
    }
    public void setContact(int contact){
        this.contact=contact;
    
    }
    
}
