
package PAT;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
adminSearchGUI class
Used as interface for the user to find the person in the database they are looking for
*/
public class AdminSearchGUI extends javax.swing.JFrame {
    public String foundID = ""; //ID of the person found
    public String userType =""; //Type of the current user
    public String userWelcome = ""; //Welcome message displayed in the main GUI
    Admin adm = new Admin(); //Instance of the Admin class
    
    /*
    Constructor Method
    Used when a new instance of the AdminSearchGUI is created
    @parameters: String userType, String user welcome message
    @return: none
    */
    public AdminSearchGUI(String _userType, String _userWelcome) {
        userType = _userType;
        userWelcome = _userWelcome;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        btnAdminHelp = new javax.swing.JButton();
        lblAdminsearch = new javax.swing.JLabel();
        txtFieldNameSearch = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFoundUsers = new javax.swing.JTable();
        txtFieldSearchID = new javax.swing.JTextField();
        lblAthID = new javax.swing.JLabel();
        btnSelect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBack.setText("BACK");
        btnBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAdminHelp.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnAdminHelp.setText("Help");
        btnAdminHelp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnAdminHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminHelpActionPerformed(evt);
            }
        });

        lblAdminsearch.setBackground(new java.awt.Color(255, 255, 255));
        lblAdminsearch.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblAdminsearch.setText("Admin Search");
        lblAdminsearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        txtFieldNameSearch.setText("Enter Name Here");
        txtFieldNameSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFieldNameSearchMouseClicked(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        tblFoundUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "username", "Name", "Surname"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFoundUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFoundUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFoundUsers);

        txtFieldSearchID.setEditable(false);
        txtFieldSearchID.setBackground(new java.awt.Color(255, 255, 255));

        lblAthID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAthID.setText("Username:");

        btnSelect.setText("Select");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAthID)
                        .addGap(69, 69, 69)
                        .addComponent(txtFieldSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSelect)
                .addGap(163, 163, 163))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtFieldNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAdminsearch)
                        .addGap(37, 37, 37)
                        .addComponent(btnAdminHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdminsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdminHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAthID))
                .addGap(18, 18, 18)
                .addComponent(btnSelect)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*
    Method of the Back Button
    Opens an instance of the AdminGUI class and then closes the AdminSearchGUI class
    */
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AdminGUI adm = new AdminGUI(userType, userWelcome);
        adm.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBackActionPerformed
    /*
    Method of the help button
    Opens Help text
    */
    private void btnAdminHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminHelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdminHelpActionPerformed
    /*
    Method txtFieldNameSearchMouseClicked
    Clears the existing text when the user clicks on the text field
    */
    private void txtFieldNameSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFieldNameSearchMouseClicked
        txtFieldNameSearch.setText("");
    }//GEN-LAST:event_txtFieldNameSearchMouseClicked
    /*
    Method of the Find button
    Updates the table with users that match the name provided as input
    */
    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        String name = txtFieldNameSearch.getText(); //get name from the text field
        updateSearchTable(name); //Insert the data into the table
    }//GEN-LAST:event_btnFindActionPerformed
    /*
    Method tblFoundUserMouseClicked
    Loads the username of the user selected into the text Field
    */
    private void tblFoundUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFoundUsersMouseClicked
        //Get the username of the selected user in the table
        int row = tblFoundUsers.rowAtPoint(evt.getPoint());
        //Insert username in the correct text field
        txtFieldSearchID.setText((String)tblFoundUsers.getValueAt(row, 0));
    }//GEN-LAST:event_tblFoundUsersMouseClicked
    /*
    Method of the Select Button
    Sends the username of the found user back to the AdminGui so it can be loaded into the data
    fields there
    */
    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        if(txtFieldSearchID.getText().isEmpty() == false){ //Check if a user has been selected from the table    
            foundID = txtFieldSearchID.getText(); //Get the username
            //Send username to the the AdminGUI
            AdminGUI adm = new AdminGUI(userType, userWelcome, foundID);
            adm.setVisible(true);
            dispose();
        }else{
            //Advise User to select a user first
            JOptionPane.showMessageDialog(null, "No User is selected. Please select a user.");
        }
    }//GEN-LAST:event_btnSelectActionPerformed
    /*
    Method UpdateSearchTable
    Inserts all the users that match the input name into the table
    @parameters: String name provided by the user
    @return: none
    */
    private void updateSearchTable(String name){
        clearTable();
        try {
            //retrieve all the user info that match the inputted name
            ResultSet rs = adm.findUser(name);
            while(rs.next()){
                //extract all the information
                String username = rs.getString("username");
                String _name = rs.getString("uName");
                String sName = rs.getString("uSurname");
                
                String data[] = {username, _name, sName};
                
                DefaultTableModel model = (DefaultTableModel)tblFoundUsers.getModel();
                //Insert data into the table for the user to see
                model.addRow(data);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminSearchGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Method clearTable
    Clears the table of the current information it holds
    */
    private void clearTable(){
        DefaultTableModel model = (DefaultTableModel)tblFoundUsers.getModel();
        while(model.getRowCount()> 0){
            model.removeRow(0);
        }
    }
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
            java.util.logging.Logger.getLogger(AdminSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminSearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminSearchGUI("", "").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminHelp;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSelect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdminsearch;
    private javax.swing.JLabel lblAthID;
    private javax.swing.JTable tblFoundUsers;
    private javax.swing.JTextField txtFieldNameSearch;
    private javax.swing.JTextField txtFieldSearchID;
    // End of variables declaration//GEN-END:variables
}
