package gui;

import database.AppointmentDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewAppointmentsPanel extends JPanel {

    public ViewAppointmentsPanel() {
        setLayout(new BorderLayout());

        String[] cols = {"Patient", "Doctor", "Specialization", "Date"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        JTable table = new JTable(model);

        JButton load = new JButton("Load Appointments");

        load.addActionListener(e -> {
            model.setRowCount(0);
            var list = AppointmentDAO.getAll();

            for (String[] row : list)
                model.addRow(row);
        });

        add(load, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
