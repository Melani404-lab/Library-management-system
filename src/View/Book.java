


package View;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Controller.BookController;
import Model.BookModel;

public class Book extends javax.swing.JFrame {
    private BookController bookController = new BookController();
    private String bookname;
    private BookModel books;

    
    public Book(String role) {
        
         this.role=role;
         
        initComponents();
        Connect();
        BookData();
        setAccessControl();
        
    }
    private void setAccessControl(){    
        if(role.equalsIgnoreCase("Admin")){
            btnInsert1.setEnabled(true);
            btnUpdate1.setEnabled(true);
            btnDelete1.setEnabled(true);
        
        }else if(role.equalsIgnoreCase("M")){
            btnInsert1.setEnabled(false);
            btnUpdate1.setEnabled(false);
            btnDelete1.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Welcome member you have view-only access.");
        
        }
        
        
    }
    Connection con;
    PreparedStatement pst;
    
    public void Connect(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void BookData(){
        
        try {
            int QQ;
            pst=con.prepareStatement("SELECT * FROM book");
            ResultSet rs=pst.executeQuery();
            
            ResultSetMetaData rsmd=rs.getMetaData();
            
            QQ=rsmd.getColumnCount();
            
            DefaultTableModel DFG=(DefaultTableModel)jTable1.getModel();
            
            DFG.setRowCount(0);
            
            while(rs.next()){
                Vector v2=new Vector();
                
                for(int i=1; i<=QQ; i++){
                    v2.add(rs.getString("bookId"));
                    v2.add(rs.getString("bookname"));
                    v2.add(rs.getString("author"));
                    v2.add(rs.getString("publisher"));
                    v2.add(rs.getString("search"));
                    
                
                }
                DFG.addRow(v2);
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    
    }

    
    @SuppressWarnings("unchecked")
    
    private String role;
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBName = new javax.swing.JTextField();
        txtBI = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        btnInsert1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPublisher = new javax.swing.JTextField();
        btnSum2 = new javax.swing.JButton();
        txtSum2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book Management");

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jButton2.setText("X");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(211, 211, 211)
                .addComponent(jButton2)
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTable1.setBackground(new java.awt.Color(153, 255, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookID", "Book Name", "Author", "Publisher", "Search"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel2.setText("Book Name");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel3.setText("Book ID");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel4.setText("Author");

        txtBName.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        txtBI.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        txtAuthor.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        btnInsert1.setBackground(new java.awt.Color(0, 102, 0));
        btnInsert1.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnInsert1.setForeground(java.awt.Color.white);
        btnInsert1.setText("Insert");
        btnInsert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsert1ActionPerformed(evt);
            }
        });

        btnUpdate1.setBackground(new java.awt.Color(0, 102, 0));
        btnUpdate1.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnUpdate1.setForeground(java.awt.Color.white);
        btnUpdate1.setText("Update");
        btnUpdate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdate1ActionPerformed(evt);
            }
        });

        btnDelete1.setBackground(new java.awt.Color(0, 102, 0));
        btnDelete1.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnDelete1.setForeground(java.awt.Color.white);
        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic2.jpeg"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel6.setText("Publisher");

        btnSum2.setBackground(new java.awt.Color(0, 102, 0));
        btnSum2.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnSum2.setForeground(new java.awt.Color(255, 255, 255));
        btnSum2.setText("Total Books");
        btnSum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSum2ActionPerformed(evt);
            }
        });

        txtSum2.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel7.setText("Search Book");

        btnSearch.setBackground(new java.awt.Color(0, 102, 0));
        btnSearch.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnSearch.setForeground(java.awt.Color.white);
        btnSearch.setText("Search Book");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(35, 35, 35))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnSearch)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsert1)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate1)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPublisher, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                .addComponent(txtBI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                .addComponent(txtAuthor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btnSum2)
                                .addGap(18, 18, 18)
                                .addComponent(txtSum2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtBI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete1)
                            .addComponent(btnUpdate1)
                            .addComponent(btnInsert1)
                            .addComponent(btnSearch)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSum2)
                            .addComponent(txtSum2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsert1ActionPerformed
        
        try {
            // TODO add your handling code here:
            String bookname=txtBName.getText();
            String bookId=txtBI.getText();
            String author=txtAuthor.getText();
            String publisher=txtPublisher.getText();
            
            
            pst=con.prepareStatement("INSERT INTO book(bookId,bookname,author,publisher)VALUES(?,?,?,?)");
            
            pst.setString(1, bookId);
            pst.setString(2, bookname);
            pst.setString(3, author);
            pst.setString(4, publisher);
            
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record inserted Successfuly");
            BookData();
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnInsert1ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        try {
            // TODO add your handling code here:
            String bookname=txtBName.getText();
            String bookId=txtBI.getText();
            String author=txtAuthor.getText();
            String publisher=txtPublisher.getText();
            
            
            pst=con.prepareStatement("update book set bookname=?, author=?, publisher=? where bookId=?");
            
            
            pst.setString(1, bookname);
            pst.setString(2, author);
            pst.setString(3, publisher);
            pst.setString(4, bookId);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record updated Successfuly");
            BookData();
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        
        
        try {
            // TODO add your handling code here:
            String bookId=txtBI.getText();
            
            if (bookController.deleteBook(bookId)) {
        JOptionPane.showMessageDialog(this, "Book deleted successfully!");
        BookData(); // Refresh table
    } else {
        JOptionPane.showMessageDialog(this, "Failed to delete book.");
    }
            
            pst=con.prepareStatement("DELETE FROM book WHERE bookId=?");
            pst.setString(1, bookId);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Record deleted Successfuly");
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnSum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSum2ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String sql="select count(bookname) from book";
            pst=con.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                String sum=rs.getString("count(bookname)");
                txtSum2.setText(sum);
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSum2ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
         
        String searchInput = txtSearch.getText().trim();

    if (searchInput.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a book name or book name and author to search");
        return;
    }
    if(searchInput.contains(",")){
        
        String[] parts = searchInput.split(",");
        if (parts.length == 2) {
            searchBooks(parts[0].trim(), parts[1].trim());
        } else {
            JOptionPane.showMessageDialog(this, "Invalid search format. Use 'bookname,author'.");
        }
    } else {
        // Search by bookname only
        searchBooks(searchInput);
    }
        
}

private void searchBooks(String bookname){
            try {
        pst = con.prepareStatement("SELECT * FROM book WHERE bookname LIKE ?");
        pst.setString(1, "%" + bookname + "%");
        ResultSet rs = pst.executeQuery();

        populateTable(rs);

    } catch (SQLException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    }

}    

public void searchBooks(String bookname, String author) {
    try {
        pst = con.prepareStatement("SELECT * FROM book WHERE bookname LIKE ? AND author LIKE ?");
        pst.setString(1, "%" + bookname + "%");
        pst.setString(2, "%" + author + "%");
        ResultSet rs = pst.executeQuery();

        populateTable(rs);

    } catch (SQLException ex) {
        Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
    }
}

// Helper method to populate JTable
private void populateTable(ResultSet rs) throws SQLException {
    DefaultTableModel DFG = (DefaultTableModel) jTable1.getModel();
    DFG.setRowCount(0);

    while (rs.next()) {
        Vector v2 = new Vector();
        v2.add(rs.getString("bookId"));
        v2.add(rs.getString("bookname"));
        v2.add(rs.getString("author"));
        v2.add(rs.getString("publisher"));
        v2.add(rs.getString("search"));
        DFG.addRow(v2);
    }
        
    }//GEN-LAST:event_btnSearchActionPerformed

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book("Admin").setVisible(true);
            }
        });
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnInsert1;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSum2;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtBI;
    private javax.swing.JTextField txtBName;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSum2;
    // End of variables declaration//GEN-END:variables

  
}
