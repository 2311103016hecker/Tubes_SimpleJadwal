/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SimpleJadwal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author hecke
 */
public class ScheduleTable extends javax.swing.JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JButton deleteButton;

    public ScheduleTable() {
        // Judul JFrame
        setTitle("Hasil Jadwal Anda");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Label Judul
        JLabel titleLabel = new JLabel("Hasil Jadwal Anda", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.LIGHT_GRAY);
        add(titleLabel, BorderLayout.NORTH);

        // Model Tabel
        String[] columnNames = {"Nama Kegiatan", "Hari", "Tanggal", "Keterangan Tambahan"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Tombol Hapus
        deleteButton = new JButton("Hapus Data");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedRow();
            }
        });
        add(deleteButton, BorderLayout.SOUTH);

        // Mengisi data ke tabel dari database
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/schedule_db"; // Ganti dengan nama database Anda
        String user = "root"; // Username database Anda
        String password = ""; // Password database Anda

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT activity_name, day, date, additional_info FROM schedule_table";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String activityName = resultSet.getString("activity_name");
                String day = resultSet.getString("day");
                String date = resultSet.getString("date");
                String additionalInfo = resultSet.getString("additional_info");

                // Tambahkan data ke tabel
                Object[] rowData = {activityName, day, date, additionalInfo};
                tableModel.addRow(rowData);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saat memuat data: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void deleteSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang ingin dihapus terlebih dahulu.");
            return;
        }

        String activityName = (String) tableModel.getValueAt(selectedRow, 0);

        String url = "jdbc:mysql://localhost:3306/schedule_db"; // Ganti dengan nama database Anda
        String user = "root"; // Username database Anda
        String password = ""; // Password database Anda

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM schedule_table WHERE activity_name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, activityName);

            int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                preparedStatement.executeUpdate();
                tableModel.removeRow(selectedRow);
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saat menghapus data: " + ex.getMessage());
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
                new ScheduleTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
