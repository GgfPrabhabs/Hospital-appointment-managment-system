package model;

public class Appointment {
    private String patientName;
    private String doctorName;
    private String specialization;
    private String date;

    public Appointment(String p, String d, String s, String dt) {
        this.patientName = p;
        this.doctorName = d;
        this.specialization = s;
        this.date = dt;
    }

    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public String getSpecialization() { return specialization; }
    public String getDate() { return date; }
}
