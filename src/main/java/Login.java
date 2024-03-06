import dao.ConnectionProvider;
import javax.swing.JOptionPane;
import java.sql.*;

public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Login");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 80, 40));

        jLabel2.setText("Email Address:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 280, -1));

        jLabel3.setText("Password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 280, -1));

        jCheckBox1.setText("Remember me");
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel4.setText("Forget Password?");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 100, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 204));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 280, 40));

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, -1));

        jLabel5.setText("Doesn't have an account yet? Sign up");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 220, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 330, 350));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/login1.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int a = JOptionPane.showConfirmDialog(null, "Do you want to close application", "Select", JOptionPane.YES_NO_OPTION);
        if(a == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        
        int temp = 0;
        try{
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            //ResultSet store whatever data we get from databse
            ResultSet rs = st.executeQuery("select * from appuser where email='" + email + "'and password ='" + password +"' and status = 'Active'");
            while(rs.next()){
                temp = 1;
                setVisible(false);
                new Home(rs.getString("userRole")).setVisible(true);
            }
            if(temp == 0){
                JOptionPane.showMessageDialog(null, "Incorrect Email or Password");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
