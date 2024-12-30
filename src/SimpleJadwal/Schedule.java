/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleJadwal;

/**
 *
 * @author hecke
 */
public class Schedule {
  private String activityName;
    private String day;
    private String date;
    private String additionalInfo;

    // Constructor
    public Schedule(String activityName, String day, String date, String additionalInfo) {
        this.activityName = activityName;
        this.day = day;
        this.date = date;
        this.additionalInfo = additionalInfo;
    }

    // Getter dan Setter
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    // Metode untuk mencetak data jadwal
    @Override
    public String toString() {
        return "Nama Kegiatan: " + activityName + "\n" +
               "Hari: " + day + "\n" +
               "Tanggal: " + date + "\n" +
               "Keterangan Tambahan: " + additionalInfo;
    }  
}
