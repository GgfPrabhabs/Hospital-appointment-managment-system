package database;

import model.Appointment;
import model.DBException;

import java.sql.*;
import java.util.ArrayList;

public class AppointmentDAO {

    public static void save(Appointment a) throws DBException {
        try {
            Connection con = DBConnection.getConnection();
            String q = "INSERT INTO appointments(patient, doctor, specialization, date) VALUES (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(q);

            ps.setString(1, a.getPatientName());
            ps.setString(2, a.getDoctorName());
            ps.setString(3, a.getSpecialization());
            ps.setString(4, a.getDate());

            ps.executeUpdate();

        } catch (Exception e) {
            throw new DBException("Error saving appointment: " + e.getMessage());
        }
    }

    public static ArrayList<String[]> getAll() {
        ArrayList<String[]> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String q = "SELECT * FROM appointments";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(q);

            while (rs.next()) {
                list.add(new String[]{
                        rs.getString("patient"),
                        rs.getString("doctor"),
                        rs.getString("specialization"),
                        rs.getString("date")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
