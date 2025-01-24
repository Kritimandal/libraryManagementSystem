import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MainJFrame extends javax.swing.JFrame {
    
    private final String username;
    private final String password;

   
    public MainJFrame(String username, String password) {
        initComponents();
        this.username = username;  // Store username
        this.password = password; 
        setExtendedState(MainJFrame.MAXIMIZED_BOTH);
        show_table();
    }

    
    Connection con = null;
    PreparedStatement pst = null;
    
    private void show_table(){
       
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagementSystem",username, password);
            pst = con.prepareStatement("SELECT * FROM book");
            
            ResultSet Rs = pst.executeQuery();
            ResultSetMetaData RSMD = Rs.getMetaData();
            int CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel)jTable1.getModel();
            DFT.setColumnIdentifiers(new Object[]{"ID", "Title", "Author", "ISBN", "Genre", "Year"});

        DFT.setRowCount(0);  // Clear existing rows in the table

        while (Rs.next()) {
            ArrayList<String> row = new ArrayList<>();  // Use ArrayList instead of Vector

            // Loop through the columns dynamically
            for (int i = 1; i <= CC; i++) {
                row.add(Rs.getString(i));  // Add each column's value to the ArrayList
            }

            // Add the ArrayList as a new row in the table model
            DFT.addRow(row.toArray());
        }
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "Error while connect database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        txtTitle = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        txtGenre = new javax.swing.JTextField();
        txtAuthor = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnSearch1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Library Management System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jTable1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Title", "Author", "ISBN", "Genre", "Year"
            }
        ));
        jTable1.setIntercellSpacing(new java.awt.Dimension(1, 1));
        jTable1.setRowHeight(25);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Title");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Author");

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("ISBN");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Genre");

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Year");

        txtIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIsbnActionPerformed(evt);
            }
        });

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

        txtYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYearActionPerformed(evt);
            }
        });

        txtGenre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGenreActionPerformed(evt);
            }
        });

        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });

        btnAdd.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnSearch.setText("Query");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnSearch1.setFont(new java.awt.Font("Noto Serif CJK TC", 0, 18)); // NOI18N
        btnSearch1.setText("All Records");
        btnSearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearch1MouseClicked(evt);
            }
        });
        btnSearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch1ActionPerformed(evt);
            }
        });

        jButton1.setText("Export");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(txtYear, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(txtGenre))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(txtIsbn))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAuthor)
                            .addComponent(txtTitle))))
                .addGap(165, 165, 165)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addComponent(btnSearch1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(btnSearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIsbnActionPerformed

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void txtYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearActionPerformed

    private void txtGenreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGenreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGenreActionPerformed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        String title, author, isbn, genre, year;
        
        title = txtTitle.getText();
        author = txtAuthor.getText();
        isbn = txtIsbn.getText();
        genre = txtGenre.getText();
        year = txtYear.getText();
        
         if(title.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter a title");
        }
         else if(author.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter a title"); 
        }
         else if(isbn.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter a ISBN"); 
        }
         else if(genre.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter a genre"); 
        }
         else if(year.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter a year"); 
        }
         
         else{
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagementSystem",username, password);
                pst = con.prepareStatement("insert into book (title, author, isbn,genre, year ) values(?,?,?,?,?)");
                pst.setString(1, title);
            pst.setString(2, author);
            pst.setString(3, isbn);
            pst.setString(4, genre);
            pst.setString(5, year);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data inserted successfully!");
            
            
            txtTitle.setText("");
            txtAuthor.setText("");
            txtIsbn.setText("");
            txtGenre.setText("");
            txtYear.setText("");
            
             show_table();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error while connect database", "Error", JOptionPane.ERROR_MESSAGE);
            }
         }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
       DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(selectedIndex,0).toString());
        txtTitle.setText(model.getValueAt(selectedIndex,1).toString());
        txtAuthor.setText(model.getValueAt(selectedIndex,2).toString());
        txtIsbn.setText(model.getValueAt(selectedIndex,3).toString());
        txtGenre.setText(model.getValueAt(selectedIndex,4).toString());
        txtYear.setText(model.getValueAt(selectedIndex,5).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
           String title, author, isbn, genre, year;
        
        title = txtTitle.getText();
        author = txtAuthor.getText();
        isbn = txtIsbn.getText();
        genre = txtGenre.getText();
        year = txtYear.getText();
        
         if(title.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter a title");
        }
         else if(author.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter a title"); 
        }
         else if(isbn.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter a ISBN"); 
        }
         else if(genre.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter a genre"); 
        }
         else if(year.equals("")){
        JOptionPane.showMessageDialog(null, "Please enter a year"); 
        }
         
         else{
           
               try {
                   
                 DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int selectedIndex = jTable1.getSelectedRow();
        int id = Integer.parseInt(model.getValueAt(selectedIndex,0).toString());
                   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagementSystem",username, password);
                   String updateQuery = "UPDATE book SET title = ?, author = ?, isbn = ?, genre = ?, year = ? WHERE id = ?";
        
        
        pst = con.prepareStatement(updateQuery);
        
        
          
        pst.setString(1, title);  
        pst.setString(2, author);  
        pst.setString(3, isbn);    
        pst.setString(4, genre);   
        pst.setString(5, year);       // Year
              
        pst.setInt(6, id); 
       
        pst.executeUpdate();  
        JOptionPane.showMessageDialog(null, "Record Updated Successfully"); 

        
        show_table();
        
        txtTitle.setText("");
        txtAuthor.setText("");
        txtIsbn.setText("");
        txtGenre.setText("");
        txtYear.setText("");
        
               } catch (SQLException ex) {
                   JOptionPane.showMessageDialog(this, "Error while connect database", "Error", JOptionPane.ERROR_MESSAGE);
               }
         }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
            // TODO add your handling code here:
            
            DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
            int selectedIndex = jTable1.getSelectedRow();
            int id = Integer.parseInt(model.getValueAt(selectedIndex,0).toString());
 try {           
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagementSystem",username, password);
            String deleteQuery = "DELETE FROM book WHERE id = ?";
            pst = con.prepareStatement(deleteQuery);
            pst.setInt(1, id); 
       
        pst.executeUpdate();  
        JOptionPane.showMessageDialog(null, "Record deleted Successfully"); 

        
        show_table();
        
        txtTitle.setText("");
        txtAuthor.setText("");
        txtIsbn.setText("");
        txtGenre.setText("");
        txtYear.setText("");
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(this, "Error while connect database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String title, author, isbn, genre, year;
        
        title = txtTitle.getText();
        author = txtAuthor.getText();
        isbn = txtIsbn.getText();
        genre = txtGenre.getText();
        year = txtYear.getText();
        
        try {           
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagementSystem",username, password);
            String query = "SELECT * FROM book WHERE title LIKE ? OR author LIKE ? OR isbn LIKE ? OR genre LIKE ? OR year LIKE ?";
            pst = con.prepareStatement(query);
             pst.setString(1, title);  
        pst.setString(2, author);  
        pst.setString(3, isbn);    
        pst.setString(4, genre);   
        pst.setString(5, year);       
       
        ResultSet Rs = pst.executeQuery();  
        JOptionPane.showMessageDialog(null, "Record queried Successfully"); 

        
        ResultSetMetaData RSMD = Rs.getMetaData();
            int CC = RSMD.getColumnCount();
            DefaultTableModel DFT = (DefaultTableModel)jTable1.getModel();
            DFT.setColumnIdentifiers(new Object[]{"ID", "Title", "Author", "ISBN", "Genre", "Year"});

        DFT.setRowCount(0);  // Clear existing rows in the table

        while (Rs.next()) {
            ArrayList<String> row = new ArrayList<>();  // Use ArrayList instead of Vector

            // Loop through the columns dynamically
            for (int i = 1; i <= CC; i++) {
                row.add(Rs.getString(i));  // Add each column's value to the ArrayList
            }

            // Add the ArrayList as a new row in the table model
            DFT.addRow(row.toArray());
        }
        
          txtTitle.setText("");
        txtAuthor.setText("");
        txtIsbn.setText("");
        txtGenre.setText("");
        txtYear.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error while connect database", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearch1ActionPerformed

    private void btnSearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearch1MouseClicked
        // TODO add your handling code here:
        show_table();
    }//GEN-LAST:event_btnSearch1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
       JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Specify a file save");
    int userSelection = fileChooser.showSaveDialog(this);
    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File fileToSave = fileChooser.getSelectedFile();
        try {
           
            FileWriter fw = new FileWriter(fileToSave);
            BufferedWriter bw = new BufferedWriter(fw);

           
            for (int column = 0; column < jTable1.getColumnCount(); column++) {
                bw.write(jTable1.getColumnName(column)); 
                if (column < jTable1.getColumnCount() - 1) {
                    bw.write(","); 
                }
            }
            bw.newLine();  // New line after column names

            // Writing the data from the table
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                for (int j = 0; j < jTable1.getColumnCount(); j++) {
                    bw.write(jTable1.getValueAt(i, j).toString()); 
                    if (j < jTable1.getColumnCount() - 1) {
                        bw.write(","); 
                    }
                }
                bw.newLine(); 
            }

           
            JOptionPane.showMessageDialog(this, "Data successfully saved to file!", "Information", JOptionPane.INFORMATION_MESSAGE);

           
            bw.close();
            fw.close();

        } catch (IOException ex) {
           
            JOptionPane.showMessageDialog(this, "Error while saving data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButton1MouseClicked

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch1;
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
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtGenre;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables
}
