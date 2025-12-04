package gui;

import model.*;
import database.AppointmentDAO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AppointmentPanel extends JPanel {

    public static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public AppointmentPanel(ArrayList<Doctor> doctors) {

        setLayout(new GridLayout(6, 2, 10, 10));

        JLabel pNameL = new JLabel("Patient Name:");
        JTextField pName = new JTextField();

        JLabel docL = new JLabel("Select Doctor:");
        JComboBox<String> docBox = new JComboBox<>();

        for (Doctor d : doctors) docBox.addItem(d.getName());

        JLabel dateL = new JLabel("Date (dd-mm-yyyy):");
        JSpinner dateSpinner = new JSpinner(new javax.swing.SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
        dateSpinner.setEditor(editor);

        JButton book = new JButton("Book");

        JLabel msg = new JLabel("");
        msg.setForeground(Color.BLUE);

        book.addActionListener(e -> {
            String patient = pName.getText();
            String doctor = (String) docBox.getSelectedItem();
            Date selectedDate = (Date) dateSpinner.getValue();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String date = sdf.format(selectedDate);
            String specialization = "";

            for (Doctor d : doctors)
                if (d.getName().equals(doctor))
                    specialization = d.getSpecialization();

            if (patient.isEmpty()) {
                msg.setText("All fields required!");
            } else {
                Appointment appointment = new Appointment(patient, doctor, specialization, date);
                appointmentList.add(appointment);
                try {
                    AppointmentDAO.save(appointment);
                    msg.setText("Appointment booked!");
                    pName.setText("");
                } catch (Exception ex) {
                    msg.setText("Error saving appointment!");
                    msg.setForeground(java.awt.Color.RED);
                }
            }
        });

        add(pNameL); add(pName);
        add(docL); add(docBox);
        add(dateL); add(dateSpinner);
        add(new JLabel()); add(book);
        add(msg);
    }
}
