/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SimpleJadwal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author hecke
 */
public class ScheduleForm extends javax.swing.JFrame {
 
    private ArrayList<Schedule> scheduleList = new ArrayList<>();

    // Komponen GUI
    private JTextField activityField;
    private JTextField dayField;
    private JTextField dateField;
    private JTextField additionalInfoField;
    private JButton saveButton;

    public ScheduleForm() {
        // Judul JFrame
        setTitle("Input Jadwal");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Label judul
        JLabel titleLabel = new JLabel("Masukan Data Jadwal Anda");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(50, 20, 300, 30);
        add(titleLabel);

        // Label Nama Kegiatan
        JLabel activityLabel = new JLabel("Nama Kegiatan");
        activityLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        activityLabel.setBounds(50, 80, 120, 30);
        add(activityLabel);

        // Field Nama Kegiatan
        activityField = new JTextField();
        activityField.setBounds(200, 80, 150, 30);
        add(activityField);

        // Label Hari
        JLabel dayLabel = new JLabel("Hari");
        dayLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        dayLabel.setBounds(50, 130, 120, 30);
        add(dayLabel);

        // Field Hari
        dayField = new JTextField();
        dayField.setBounds(200, 130, 150, 30);
        add(dayField);

        // Label Tanggal
        JLabel dateLabel = new JLabel("Tanggal");
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        dateLabel.setBounds(50, 180, 120, 30);
        add(dateLabel);

        // Field Tanggal
        dateField = new JTextField();
        dateField.setBounds(200, 180, 150, 30);
        add(dateField);

        // Label Keterangan Tambahan
        JLabel additionalInfoLabel = new JLabel("Keterangan Tambahan");
        additionalInfoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        additionalInfoLabel.setBounds(50, 230, 150, 30);
        add(additionalInfoLabel);

        // Field Keterangan Tambahan
        additionalInfoField = new JTextField();
        additionalInfoField.setBounds(200, 230, 150, 30);
        add(additionalInfoField);

        // Tombol Simpan
        saveButton = new JButton("Simpan");
        saveButton.setBounds(150, 300, 100, 30);
        add(saveButton);

        // Event Listener untuk Tombol Simpan
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveDataToDatabase();
            }
        });

        // Tombol Lihat Jadwal
        JButton viewButton = new JButton("Lihat Jadwal");
        viewButton.setBounds(150, 340, 100, 30);
        add(viewButton);

        // Event Listener untuk Tombol "Lihat Jadwal"
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                new ScheduleTable().setVisible(true);
              }
        });
    }

    // Fungsi untuk menyimpan data ke database
    private void saveDataToDatabase() {
        String activityName = activityField.getText();
        String day = dayField.getText();
        String date = dateField.getText();
        String additionalInfo = additionalInfoField.getText();

        String url = "jdbc:mysql://localhost:3306/schedule_db"; // Ganti dengan nama database Anda
        String user = "root"; // Username database Anda
        String password = ""; // Password database Anda

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO schedule_table (activity_name, day, date, additional_info) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, activityName);
            statement.setString(2, day);
            statement.setString(3, date);
            statement.setString(4, additionalInfo);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke database!");
            }

            // Bersihkan input field
            activityField.setText("");
            dayField.setText("");
            dateField.setText("");
            additionalInfoField.setText("");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ScheduleForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
