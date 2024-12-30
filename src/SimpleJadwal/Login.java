/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleJadwal;

/**
 *
 * @author hecke
 */
public class Login {
    // Simulasi data pengguna
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "123";

    // Metode untuk memvalidasi login
    public boolean validate(String username, String password) {
        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }
}
