package Controller;

import Model.MemberModel;
import Model.MembershipCard;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MController {
    private Connection con;

    // Constructor to establish database connection
    public MController() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to add a new member
    public void addMember(MemberModel member) {
        try {
            String sql = "INSERT INTO members (id, memberName, email, contact, cardNumber, expirationDate) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, member.getId());
            pst.setString(2, member.getMemberName());
            pst.setString(3, member.getEmail());
            pst.setString(4, member.getContact());
            pst.setString(5, member.getMembershipCard().getCardNumber());
            pst.setString(6, member.getMembershipCard().getExpirationDate());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an existing member
    public void updateMember(MemberModel member) {
        try {
            String sql = "UPDATE members SET memberName = ?, email = ?, contact = ?, cardNumber = ?, expirationDate = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, member.getMemberName());
            pst.setString(2, member.getEmail());
            pst.setString(3, member.getContact());
            pst.setString(4, member.getMembershipCard().getCardNumber());
            pst.setString(5, member.getMembershipCard().getExpirationDate());
            pst.setString(6, member.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a member by ID
    public void deleteMember(String id) {
        try {
            String sql = "DELETE FROM members WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to fetch all members
    public List<MemberModel> getAllMembers() {
        List<MemberModel> members = new ArrayList<>();
        try {
            String sql = "SELECT * FROM members";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                MembershipCard membershipCard = new MembershipCard(rs.getString("membershipCard"), rs.getString("expirationDate"));
                MemberModel member = new MemberModel(
                        rs.getString("id"),
                        rs.getString("memberName"),
                        rs.getString("email"),
                        rs.getString("contact"),
                        membershipCard
                );
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
}
