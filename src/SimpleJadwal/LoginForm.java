/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SimpleJadwal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author hecke
 */
public class LoginForm extends javax.swing.JFrame {
// Komponen GUI
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        // Judul JFrame
        setTitle("Jadwal Simple");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Label judul
        JLabel titleLabel = new JLabel("Jadwal Simple");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(50, 20, 300, 30);
        add(titleLabel);

        // Label Username
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        usernameLabel.setBounds(50, 80, 80, 30);
        add(usernameLabel);

        // Field Username
        usernameField = new JTextField();
        usernameField.setBounds(150, 80, 200, 30);
        add(usernameField);

        // Label Password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordLabel.setBounds(50, 130, 80, 30);
        add(passwordLabel);

        // Field Password
        passwordField = new JPasswordField();
        passwordField.setBounds(150, 130, 200, 30);
        add(passwordField);

        // Tombol Login
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 180, 80, 30);
        add(loginButton);

        // Event Listener untuk Tombol Login
        loginButton.addActionListener(new ActionListener() {
            @Override
    public void actionPerformed(ActionEvent e) {
        // Ambil input dari form
        String username = usernameField.getText();
        String password = String.valueOf(passwordField.getPassword());

        // Gunakan class Login untuk validasi
        Login login = new Login();
        if (login.validate(username, password)) {
            JOptionPane.showMessageDialog(null, "Login Berhasil!");

            // Buka form ScheduleForm dan tutup LoginForm
            new ScheduleForm().setVisible(true);
            dispose(); // Menutup LoginForm
        } else {
            JOptionPane.showMessageDialog(null, "Username atau Password Salah!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       // Menjalankan LoginForm
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}