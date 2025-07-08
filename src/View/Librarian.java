


package View;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Librarian extends javax.swing.JFrame {

    
    public Librarian(String role) {
        initComponents();
        Connect();
        MemberData();
        
        if (!role.equalsIgnoreCase("Admin")) {
        JOptionPane.showMessageDialog(this, "Access denied! Only Admins can perform this action.");
        return;
    }
        
    }
    Connection con;
    PreparedStatement pst;
    
    public void Connect(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Librarian.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Librarian.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void MemberData(){
        
        try {
            int QQ;
            pst=con.prepareStatement("SELECT * FROM lib");
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsmd=rs.getMetaData();
            
            QQ=rsmd.getColumnCount();
            
            DefaultTableModel DFG=(DefaultTableModel)jTable1.getModel();
            
            DFG.setRowCount(0);
            
            while(rs.next()){
                Vector v2=new Vector();
                
                for(int i=1; i<=QQ; i++){
                    v2.add(rs.getString("lId"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("email"));
                    v2.add(rs.getString("contact"));
                
                }
                DFG.addRow(v2);
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Librarian.class.getName()).log(Level.SEVERE, null, ex);
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
        txtLName = new javax.swing.JTextField();
        txtLI = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtSum3 = new javax.swing.JTextField();
        btnSum3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Librarian");

        jButton1.setBackground(new java.awt.Color(204, 204, 0));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(244, 244, 244)
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

        jTable1.setBackground(new java.awt.Color(153, 204, 255));
        jTable1.setForeground(new java.awt.Color(51, 0, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LId", "Name", "Email", "Contact"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel3.setText("LId");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel4.setText("Contact");

        txtLName.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        txtLName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLNameActionPerformed(evt);
            }
        });

        txtLI.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        txtContact.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        btnInsert.setBackground(new java.awt.Color(0, 51, 51));
        btnInsert.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(0, 51, 51));
        btnUpdate.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 51, 51));
        btnDelete.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib22.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel6.setText("Email");

        txtEmail.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N

        txtSum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSum3ActionPerformed(evt);
            }
        });

        btnSum3.setBackground(new java.awt.Color(0, 51, 51));
        btnSum3.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnSum3.setForeground(new java.awt.Color(255, 255, 255));
        btnSum3.setText("Total Librarians");
        btnSum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSum3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btnInsert)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtLI, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(txtLName)
                            .addComponent(txtEmail)
                            .addComponent(txtContact))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSum3)
                        .addGap(18, 18, 18)
                        .addComponent(txtSum3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(69, 69, 69))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate)
                            .addComponent(btnInsert)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 226, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSum3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSum3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            // TODO add your handling code here:
            String name=txtLName.getText();
            String lId=txtLI.getText();
            String contact=txtContact.getText();
            String email=txtEmail.getText();
            
            pst=con.prepareStatement("INSERT INTO lib(lId,name,email,contact)VALUES(?,?,?,?)");
            
            pst.setString(1, lId);
            pst.setString(2, name);
            pst.setString(3, email);
            pst.setString(4, contact);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record inserted Successfuly");
            MemberData();
            
        } catch (SQLException ex) {
            Logger.getLogger(Librarian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            // TODO add your handling code here:
            String name=txtLName.getText();
            String lId=txtLI.getText();
            String contact=txtContact.getText();
            String email=txtEmail.getText();
            
            
            pst=con.prepareStatement("update lib set name=?, email=?, contact=? where lId=?");
            
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, contact);
            pst.setString(4, lId);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record updated Successfuly");
            MemberData();
            
        } catch (SQLException ex) {
            Logger.getLogger(Librarian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        
        
        try {
            // TODO add your handling code here:
            String lId=txtLI.getText();
            
            pst=con.prepareStatement("DELETE FROM lib WHERE lId=?");
            pst.setString(1, lId);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record deleted Successfuly");
            
        } catch (SQLException ex) {
            Logger.getLogger(Librarian.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtLNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLNameActionPerformed

    private void txtSum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSum3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSum3ActionPerformed

    private void btnSum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSum3ActionPerformed
        // TODO add your handling code here:
         try {
            // TODO add your handling code here:
            String sql="select count(name) from lib";
            pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                String sum=rs.getString("count(name)");
                txtSum3.setText(sum);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Librarian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSum3ActionPerformed

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
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Librarian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Librarian("Admin").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnSum3;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLI;
    private javax.swing.JTextField txtLName;
    private javax.swing.JTextField txtSum3;
    // End of variables declaration//GEN-END:variables
}
