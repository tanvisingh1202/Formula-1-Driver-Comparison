package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

import model.Driver;
import persistence.LoadsData;
import persistence.SavesData;

public class FormulaOneCompareGUI extends JFrame implements ActionListener {
    private List<Driver> driverList;
    private JPanel driverPanel;
    private JLabel driverLabel;
    private JButton addDriverButton;
    private JButton saveButton;
    private JButton loadButton;

    @SuppressWarnings("methodlength")
    public FormulaOneCompareGUI() {
        super("Formula One Driver Comparison");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);

        driverList = new ArrayList<>();
        LoadsData loadsData = new LoadsData("./data/drivers.json");

        try {
            driverList = loadsData.loadsDriverData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        driverPanel = new JPanel();
        driverPanel.setLayout(new BoxLayout(driverPanel, BoxLayout.Y_AXIS));
        updateDriverPanel();

        driverLabel = new JLabel("Drivers:");
        addDriverButton = new JButton("Add Driver");
        saveButton = new JButton("Save Data");
        loadButton = new JButton("Load Data");

        addDriverButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);

        add(driverLabel);
        add(driverPanel);
        add(addDriverButton);
        add(saveButton);
        add(loadButton);

        setVisible(true);

    }

    private void updateDriverPanel() {
        driverPanel.removeAll();
        for (Driver driver : driverList) {
            JLabel labelDriverInfo = new JLabel(driver.getName() + "driving for" + driver.getTeam());
            driverPanel.add(labelDriverInfo);
        }
        driverPanel.revalidate();
        driverPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addDriverButton) {
            String name = JOptionPane.showInputDialog(this, "Enter Driver Name: ");
            String team = JOptionPane.showInputDialog(this, "Enter Team Name: ");
            driverList.add(new Driver(name,team, "", 0,0,0,0,0));
            updateDriverPanel();
        } else if (e.getSource() == saveButton) {
            SavesData savesData = new SavesData("./data/drivers.json");

            try {
                savesData.savesDriverData(driverList);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Your data has been saved!");
        } else if (e.getSource() == loadButton) {
            LoadsData loadsData = new LoadsData("./data/drivers.json");

            try {
                driverList = loadsData.loadsDriverData();
                updateDriverPanel();
                JOptionPane.showMessageDialog(this, "Your data has been loaded!");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormulaOneCompareGUI());
    }
}
