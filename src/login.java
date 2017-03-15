
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mokleters
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
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

        jLabel1 = new javax.swing.JLabel();
        Password = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        signin = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 120, 80, 30);
        getContentPane().add(Password);
        Password.setBounds(160, 150, 200, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(230, 50, 80, 30);

        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        getContentPane().add(Username);
        Username.setBounds(160, 80, 200, 30);

        signin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        signin.setText("SignIn");
        signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinActionPerformed(evt);
            }
        });
        getContentPane().add(signin);
        signin.setBounds(340, 210, 110, 50);

        signup.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        signup.setText("SignUp");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });
        getContentPane().add(signup);
        signup.setBounds(70, 210, 110, 50);

        exit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(210, 210, 110, 50);

        setBounds(0, 0, 544, 339);
    }// </editor-fold>//GEN-END:initComponents

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
        Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_utspbo?zeroDateTimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `tb_login` WHERE username = ? AND password = ?");
            ps.setString(1, Username.getText());
            ps.setString(2, Password.getText());
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                new menu().show();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                Password.setText("");
                Username.requestFocus();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "gagal");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_signinActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
       String username = Username.getText();
       String password = Password.getText();
       
       try{
           try(Statement statement = (Statement) file_koneksi.getConnection().createStatement()){
            statement.executeUpdate("INSERT INTO `tb_login`(username, password) VALUES ('"+username+"', '"+password+"')") ;
           }
           JOptionPane.showMessageDialog(null, "Selamat! anda berhasil sign up!");
       }
       catch(Exception t){
         JOptionPane.showMessageDialog(null, "Mohon maaf, ulangi lagi prosedur");  
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_signupActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exitActionPerformed

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsernameActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton signin;
    private javax.swing.JButton signup;
    // End of variables declaration//GEN-END:variables
}
