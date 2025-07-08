package Model;

public class  MemberModel {
    private String id;
    private String memberName;
    private String email;
    private String contact;
    private MembershipCard membershipCard;

    public MemberModel(String id, String memberName, String email, String contact, MembershipCard membershipCard) {
        this.id = id;
        this.memberName = memberName;
        this.email = email;
        this.contact = contact;
        this.membershipCard = membershipCard;
    }

    public String getId() {
        return id;
    
    }
    public void setId(String id) {
        this.id = id; 
    
    }

    public String getMemberName() {
        return memberName; 
    
    }
    public void setMemberName(String memberName) { 
        this.memberName = memberName;
    
    }

    public String getEmail() {
        return email;
    
    }
    public void setEmail(String email) {
        this.email = email; 
    
    }

    public String getContact() {
        return contact; 
    
    }
    public void setContact(String contact) {
        this.contact = contact; 
    
    }

    public MembershipCard getMembershipCard() {
        return membershipCard; 
    
    }
    public void setMembershipCard(MembershipCard membershipCard) {
        this.membershipCard = membershipCard;
    
    }
    @Override
    public String toString() {
        return "Member [ID=" + id + ", Name=" + memberName + "]";
    }
}
