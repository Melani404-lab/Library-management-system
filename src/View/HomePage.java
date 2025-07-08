
package View;


public class HomePage extends javax.swing.JFrame {
    private String role;

   
    public HomePage(String role) {
        this.role=role;
        initComponents();
        setAccessControl();
        
    }
    private void setAccessControl(){
        if("M".equals(role)){
            btnLibrarian.setEnabled(false);
            btnBook.setEnabled(true);
            btnBorrow.setEnabled(true);
        
        }else if("Admin".equals(role)){
            btnMember.setEnabled(true);
        
        }
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnMember = new javax.swing.JButton();
        btnBook = new javax.swing.JButton();
        btnBorrow = new javax.swing.JButton();
        btnLibrarian = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Library Management System");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/new.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        btnMember.setBackground(new java.awt.Color(255, 153, 153));
        btnMember.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnMember.setText("Member");
        btnMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMemberActionPerformed(evt);
            }
        });

        btnBook.setBackground(new java.awt.Color(255, 153, 153));
        btnBook.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnBorrow.setBackground(new java.awt.Color(255, 153, 153));
        btnBorrow.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnBorrow.setText("Borrowing");
        btnBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrowActionPerformed(evt);
            }
        });

        btnLibrarian.setBackground(new java.awt.Color(255, 153, 153));
        btnLibrarian.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnLibrarian.setText("Librarian");
        btnLibrarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibrarianActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 0, 51));
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
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btnMember, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91)
                .addComponent(btnLibrarian, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBorrow)
                .addGap(76, 76, 76)
                .addComponent(jButton1)
                .addGap(66, 66, 66))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnBorrow)
                    .addComponent(btnBook)
                    .addComponent(btnLibrarian)
                    .addComponent(btnMember))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, Short.MAX_VALUE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMemberActionPerformed
       
        new Member().setVisible(true);
        
        
    }//GEN-LAST:event_btnMemberActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        
         new Book("Admin").setVisible(true);
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrowActionPerformed
        
        new Borrow("Admin").setVisible(true);
        
    }//GEN-LAST:event_btnBorrowActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLibrarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibrarianActionPerformed
        
        new Librarian("Admin").setVisible(true);
        
    }//GEN-LAST:event_btnLibrarianActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage("M").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnBorrow;
    private javax.swing.JButton btnLibrarian;
    private javax.swing.JButton btnMember;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
