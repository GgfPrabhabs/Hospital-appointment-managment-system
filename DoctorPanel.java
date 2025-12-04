package gui;

import model.Doctor;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DoctorPanel extends JPanel {

    public DoctorPanel(ArrayList<Doctor> doctors) {
        setLayout(new BorderLayout());

        String[] cols = {"Doctor Name", "Specialization"};

        String[][] data = new String[doctors.size()][2];
        for (int i = 0; i < doctors.size(); i++) {
            data[i][0] = doctors.get(i).getName();
            data[i][1] = doctors.get(i).getSpecialization();
        }

        JTable table = new JTable(data, cols);

        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
