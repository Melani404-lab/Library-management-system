
package View;

import Controller.MController;
import Controller.MembershipCard;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Member extends javax.swing.JFrame {

    
    public Member() {
        initComponents();
        Connect();
        MemberData();
        
    }
    Connection con;
    PreparedStatement pst;
    
    public void Connect(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void MemberData(){
        
        try {
            int QQ;
            pst=con.prepareStatement("SELECT * FROM members");
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsmd=rs.getMetaData();
            
            QQ=rsmd.getColumnCount();
            
            DefaultTableModel DFG=(DefaultTableModel)jTable1.getModel();
            
            DFG.setRowCount(0);
            
            while(rs.next()){
                Vector v2=new Vector();
                
                for(int i=1; i<=QQ; i++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("membershipCard"));
                    v2.add(rs.getString("memberName"));
                    v2.add(rs.getString("email"));
                    v2.add(rs.getString("contact"));
                
                }
                DFG.addRow(v2);
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtMI = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSum1 = new javax.swing.JTextField();
        btnSum1 = new javax.swing.JButton();
        txtCard = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Member Management");

        jButton1.setBackground(new java.awt.Color(153, 0, 102));
        jButton1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(150, 150, 150)
                .addComponent(jButton1)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(255, 204, 153));
        jTable1.setForeground(new java.awt.Color(51, 0, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MemberID", "Card No", "Name", "Email", "Contact"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel3.setText("Member ID");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel4.setText("Contact");

        txtName.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtMI.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        txtContact.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        btnInsert.setBackground(new java.awt.Color(153, 0, 0));
        btnInsert.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(153, 0, 0));
        btnUpdate.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(153, 0, 0));
        btnDelete.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/member1.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel6.setText("Email");

        txtEmail.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        txtSum1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        txtSum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSum1ActionPerformed(evt);
            }
        });

        btnSum1.setBackground(new java.awt.Color(153, 0, 51));
        btnSum1.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnSum1.setForeground(new java.awt.Color(255, 255, 255));
        btnSum1.setText("Total Members");
        btnSum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSum1ActionPerformed(evt);
            }
        });

        txtCard.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel7.setText("Card No");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnInsert)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCard)
                            .addComponent(txtMI, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(txtName)
                            .addComponent(txtEmail)
                            .addComponent(txtContact))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSum1)
                                .addGap(18, 18, 18)
                                .addComponent(txtSum1)))
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate)
                            .addComponent(btnInsert)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSum1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSum1)
                                .addGap(2, 2, 2)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        
        
        try {
            // TODO add your handling code here:
            String memberName=txtName.getText();
            String id=txtMI.getText();
            String contact=txtContact.getText();
            String email=txtEmail.getText();
            String membershipCard=txtCard.getText();
            
            pst=con.prepareStatement("INSERT INTO members(id,membershipCard,memberName,email,contact)VALUES(?,?,?,?,?)");
            
            pst.setString(1, id);
            pst.setString(2, membershipCard);
            pst.setString(3, memberName);
            pst.setString(4, email);
            pst.setString(5, contact);
            
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record inserted Successfuly");
            MemberData();
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            // TODO add your handling code here:
            String membershipCard=txtCard.getText();
            String memberName=txtName.getText();
            String id=txtMI.getText();
            String contact=txtContact.getText();
            String email=txtEmail.getText();
            
            
            pst=con.prepareStatement("update members set membershipCard=?, memberName=?, email=?, contact=? where id=?");
            
            pst.setString(1, membershipCard);
            pst.setString(2, memberName);
            pst.setString(3, email);
            pst.setString(4, contact);
            pst.setString(5, id);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record updated Successfuly");
            MemberData();
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        
        try {
            // TODO add your handling code here:
            String id=txtMI.getText();
            
            pst=con.prepareStatement("DELETE FROM members WHERE id=?");
            pst.setString(1, id);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record deleted Successfuly");
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtSum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSum1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSum1ActionPerformed

    private void btnSum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSum1ActionPerformed
        try {
            // TODO add your handling code here:
            String sql="select count(memberName) from members";
            pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                String sum=rs.getString("count(memberName)");
                txtSum1.setText(sum);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnSum1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSum1;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCard;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMI;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSum1;
    // End of variables declaration//GEN-END:variables

  
}
