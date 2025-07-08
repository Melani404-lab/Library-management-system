
package View;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;





public class Borrow extends javax.swing.JFrame {

    
    public Borrow(String role) {
        initComponents();
        Connect();
        BorrowData();
        
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
            Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void BorrowData(){
        
        try {
            int QQ;
            pst=con.prepareStatement("SELECT * FROM borrow");
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsmd=rs.getMetaData();
            
            QQ=rsmd.getColumnCount();
            
            DefaultTableModel DFG=(DefaultTableModel)jTable1.getModel();
            
            DFG.setRowCount(0);
            
            while(rs.next()){
                Vector v2=new Vector();
                
                for(int i=1; i<=QQ; i++){
                    v2.add(rs.getString("bookId"));
                    v2.add(rs.getString("memberName"));
                    v2.add(rs.getString("bookname"));
                    v2.add(rs.getString("date_borrowed"));
                    v2.add(rs.getString("date_return"));
                
                }
                DFG.addRow(v2);
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnexit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMName = new javax.swing.JTextField();
        txtBI = new javax.swing.JTextField();
        btnInsert2 = new javax.swing.JButton();
        btnUpdate2 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtBook = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        btnSum3 = new javax.swing.JButton();
        txtSum3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Borrowing");

        btnexit.setBackground(new java.awt.Color(255, 0, 102));
        btnexit.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        btnexit.setText("X");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(214, 214, 214)
                .addComponent(btnexit)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnexit))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(255, 204, 255));
        jTable1.setForeground(new java.awt.Color(51, 0, 51));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Member Name", "Book", "Date_Borrowed", "Date_Return"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
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
        jLabel2.setText("Member Name");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel3.setText("Book ID");

        jLabel4.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel4.setText("Date_Borrowed");

        txtMName.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        txtMName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMNameActionPerformed(evt);
            }
        });

        txtBI.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        btnInsert2.setBackground(new java.awt.Color(51, 0, 51));
        btnInsert2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnInsert2.setForeground(new java.awt.Color(255, 255, 255));
        btnInsert2.setText("Insert");
        btnInsert2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsert2ActionPerformed(evt);
            }
        });

        btnUpdate2.setBackground(new java.awt.Color(51, 0, 51));
        btnUpdate2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnUpdate2.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate2.setText("Update");
        btnUpdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate2ActionPerformed(evt);
            }
        });

        btnDelete2.setBackground(new java.awt.Color(51, 0, 51));
        btnDelete2.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnDelete2.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete2.setText("Delete");
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel6.setText("Book");

        txtBook.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel5.setText("Date_Return");

        dateChooserCombo2.addCommitListener(new datechooser.events.CommitListener() {
            public void onCommit(datechooser.events.CommitEvent evt) {
                dateChooserCombo2OnCommit(evt);
            }
        });

        btnSum3.setBackground(new java.awt.Color(51, 0, 51));
        btnSum3.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnSum3.setForeground(new java.awt.Color(255, 255, 255));
        btnSum3.setText("Total Borrowing");
        btnSum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSum3ActionPerformed(evt);
            }
        });

        txtSum3.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(264, 264, 264))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMName, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBI, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnUpdate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnInsert2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDelete2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(99, 99, 99))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSum3)
                .addGap(29, 29, 29)
                .addComponent(txtSum3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnInsert2)
                        .addGap(2, 2, 2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnUpdate2)
                        .addGap(28, 28, 28)
                        .addComponent(btnDelete2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSum3)
                    .addComponent(txtSum3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsert2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsert2ActionPerformed
        try {
            // TODO add your handling code here:
            String bookId=txtBI.getText();
            String memberName=txtMName.getText();
            String bookname=txtBook.getText();
            
            
            pst=con.prepareStatement("INSERT INTO borrow(bookId,memberName,bookname,date_borrowed,date_return)VALUES(?,?,?,?,?)");
            
            pst.setString(1, bookId);
            pst.setString(2, memberName);
            pst.setString(3, bookname);
            
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date borrowedDate = dateChooserCombo2.getSelectedDate().getTime();
            java.util.Date returnDate = dateChooserCombo1.getSelectedDate().getTime();
            
            String date_borrowed = sdf.format(borrowedDate);
            String date_return = sdf.format(returnDate);
            
            pst.setString(4, date_borrowed);
            pst.setString(5, date_return);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record inserted Successfuly");
            BorrowData();
            
        } catch (SQLException ex) {
            Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnInsert2ActionPerformed

    private void btnUpdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate2ActionPerformed
        try {
            // TODO add your handling code here:
            String memberName=txtMName.getText();
            String bookId=txtBI.getText();
            String bookname=txtBook.getText();
            
            
            pst=con.prepareStatement("update borrow set memberName=?, bookname=?, date_borrowed=?, date_return=? where bookId=?");
            
            
            pst.setString(1, memberName);
            pst.setString(2, bookname);
            
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date borrowedDate = dateChooserCombo2.getSelectedDate().getTime();
            java.util.Date returnDate = dateChooserCombo1.getSelectedDate().getTime();
            
            String date_borrowed = sdf.format(borrowedDate);
            String date_return = sdf.format(returnDate);
            
            pst.setString(3, date_borrowed);
            pst.setString(4, date_return);
            pst.setString(5, bookId);
            
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record updated Successfuly");
            BorrowData();
            
        } catch (SQLException ex) {
            Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnUpdate2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        
        
        try {
            // TODO add your handling code here:
            String bookId=txtBI.getText();
            
            pst=con.prepareStatement("DELETE FROM borrow WHERE bookId=?");
            pst.setString(1, bookId);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record deleted Successfuly");
            
        } catch (SQLException ex) {
            Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void txtMNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMNameActionPerformed

    private void btnSum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSum3ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String sql="select count(memberName) from borrow";
            pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                String sum=rs.getString("count(memberName)");
                txtSum3.setText(sum);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Member.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSum3ActionPerformed

    private void dateChooserCombo2OnCommit(datechooser.events.CommitEvent evt) {//GEN-FIRST:event_dateChooserCombo2OnCommit
        // TODO add your handling code here:
        
    }//GEN-LAST:event_dateChooserCombo2OnCommit

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
            java.util.logging.Logger.getLogger(Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Borrow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Borrow("Admin").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnInsert2;
    private javax.swing.JButton btnSum3;
    private javax.swing.JButton btnUpdate2;
    private javax.swing.JButton btnexit;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtBI;
    private javax.swing.JTextField txtBook;
    private javax.swing.JTextField txtMName;
    private javax.swing.JTextField txtSum3;
    // End of variables declaration//GEN-END:variables
}
