/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleJadwal;

/**
 *
 * @author hecke
 */
public class Mahasiswa extends Login{
    // Atribut tambahan untuk mahasiswa
    private String nama;
    private String nim;

    // Constructor untuk inisialisasi atribut
    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk NIM
    public String getNim() {
        return nim;
    }

    // Setter untuk NIM
    public void setNim(String nim) {
        this.nim = nim;
    }

    // Metode untuk menampilkan informasi mahasiswa
    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }

    // Metode main untuk pengujian
    public static void main(String[] args) {
        // Buat objek Mahasiswa
        Mahasiswa mhs = new Mahasiswa("John Doe", "12345678");

        // Set dan dapatkan informasi login
        boolean isValid = mhs.validate("admin", "123");
        if (isValid) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Login gagal!");
        }

        // Tampilkan informasi mahasiswa
        mhs.displayInfo();
    }
    
}
