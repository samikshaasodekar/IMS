import dao.ConnectionProvider;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.table.TableModel;

public class ManageUser extends javax.swing.JFrame {

    private int appuserpk = 0;

    public ManageUser() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private boolean validateFields(String formType) {
        if (formType.equals("edit") && !txtName.getText().equals("") && !txtMobileNumber.getText().equals("") && !txtEmail.getText().equals("") && !txtAddress.getText().equals("")) {
            return false;
        } else if (formType.equals("new") && !txtName.getText().equals("") && !txtMobileNumber.getText().equals("") && !txtEmail.getText().equals("") && !txtAddress.getText().equals("") && !txtPassword.getText().equals("")) {
            return false;
        } else {
            return true;

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMobileNumber = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comboBoxStatus = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manage User");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email", "Address", "Status"
            }
        ));
        tableUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableUserMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableUser);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 535, -1));
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 324, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mobile Number:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, -1, -1));
        jPanel2.add(txtMobileNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 324, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Email:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, -1, -1));
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 324, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Address:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, -1, -1));
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 220, 324, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Status:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, -1, -1));

        comboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        jPanel2.add(comboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 360, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Password:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 270, -1, -1));
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 290, 324, -1));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, -1, -1));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel2.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 410, -1, -1));

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel2.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 410, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(306, 306, 306))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        DefaultTableModel model = (DefaultTableModel) tableUser.getModel();
        //database get the data as:
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            //ResultSet store whatever data we get from databse
            ResultSet rs = st.executeQuery("select * from appuser where userRole = 'Admin'");
            //to fetch the data:-
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("appuser_pk"), rs.getString("name"), rs.getString("mobilenumber"), rs.getString("email"), rs.getString("address"), rs.getString("status")});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String name = txtName.getText();
        String mobileNumber = txtMobileNumber.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String address = txtAddress.getText();
        String status = (String) comboBoxStatus.getSelectedItem();

        if (validateFields("new")) {
            JOptionPane.showMessageDialog(null, "All field are required");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                //create the statement but in this one we are updating the values dynamically
                PreparedStatement ps = con.prepareStatement("insert into appuser (userRole, name, mobileNumber, email, password, address, status) values ('Admin', ?, ?, ?, ?, ?, ?)");
                ps.setString(1, name);
                ps.setString(2, mobileNumber);
                ps.setString(3, email);
                ps.setString(4, password);
                ps.setString(5, address);
                ps.setString(6, status);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "User Added Successfully");
                setVisible(false);
                new ManageUser().setVisible(true);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tableUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableUserMouseClicked
        int index = tableUser.getSelectedRow();
        TableModel model = tableUser.getModel();
        
        String id = model.getValueAt(index, 0).toString();
        appuserpk = Integer.parseInt(id);
        
        String name = model.getValueAt(index, 1).toString();
        txtName.setText(name);
        
        String mobileNumber = model.getValueAt(index, 2).toString();
        txtMobileNumber.setText(mobileNumber);
        
        String email = model.getValueAt(index, 3).toString();
        txtEmail.setText(email);
        
        String address = model.getValueAt(index, 4).toString();
        txtAddress.setText(address);
        
        String status = model.getValueAt(index, 5).toString();
        comboBoxStatus.removeAllItems();
        if(status.equals("Active")){
            comboBoxStatus.addItem("Active");
            comboBoxStatus.addItem("Inactive");
        }else
        {
            comboBoxStatus.addItem("Inactive");
            comboBoxStatus.addItem("Active");            
        }
        
        txtPassword.setEditable(false);
        txtPassword.setBackground(Color.DARK_GRAY);
        
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_tableUserMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String name = txtName.getText();
        String mobileNumber = txtMobileNumber.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String status = (String) comboBoxStatus.getSelectedItem();

        if (validateFields("new")) {
            JOptionPane.showMessageDialog(null, "All field are required");
        } else {
            try {
                Connection con = ConnectionProvider.getCon();
                //create the statement but in this one we are updating the values dynamically
                PreparedStatement ps = con.prepareStatement("update appuser set name=?, mobileNumber=?, email=?, address=?, status=? where appuserpk=?");
                ps.setString(1, name);
                ps.setString(2, mobileNumber);
                ps.setString(3, email);
                ps.setString(4, address);
                ps.setString(5, status);
                ps.setInt(6, appuserpk);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "User Updated Successfully");
                setVisible(false);
                new ManageUser().setVisible(true);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }       
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        setVisible(false);
        new ManageUser().setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

//public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManageUser().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> comboBoxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableUser;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobileNumber;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
