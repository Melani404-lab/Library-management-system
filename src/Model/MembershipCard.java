package Model;

public class MembershipCard {
    private String cardNumber;
    private String expirationDate;

    public MembershipCard(String cardNumber, String expirationDate) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }
}



/*
package Model;

class MembershipCard {
    private String cardNumber;
    
    
    public MembershipCard(String cardNumber){
        this.cardNumber=cardNumber;
        
        
    
    }
    public String getCardNumber(){
        return cardNumber;
    
    }
    public void setCardNumber(String cardNumber){
        this.cardNumber=cardNumber;
    
    }
    
    
}
*/