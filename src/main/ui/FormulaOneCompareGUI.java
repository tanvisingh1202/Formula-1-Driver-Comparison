package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

import model.CompareDriver;
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
    private JButton compareButton;
    private JButton clearButton;


    @SuppressWarnings("methodlength")
    public FormulaOneCompareGUI() {
        super("Formula One Driver Comparison");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);

        showSplashScreen();

        driverList = new ArrayList<>();
        LoadsData loadsData = new LoadsData("./data/drivers.json");

        try {
            driverList = loadsData.loadsDriverData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        driverLabel = new JLabel("Drivers:");
        addDriverButton = new JButton("Add Driver");
        saveButton = new JButton("Save Data");
        loadButton = new JButton("Load Data");
        compareButton = new JButton("Compare Drivers");
        clearButton = new JButton("Clear Drivers");

        addDriverButton.addActionListener(this);
        saveButton.addActionListener(this);
        loadButton.addActionListener(this);
        compareButton.addActionListener(this);
        clearButton.addActionListener(this);

        addDriverButton.setBackground(Color.RED);
        saveButton.setBackground(Color.RED);
        loadButton.setBackground(Color.RED);
        compareButton.setBackground(Color.RED);
        clearButton.setBackground(Color.RED);


        buttonPanel.add(driverLabel);
        buttonPanel.add(addDriverButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(compareButton);
        buttonPanel.add(clearButton);


        driverPanel = new JPanel();
        driverPanel.setLayout(new BoxLayout(driverPanel, BoxLayout.Y_AXIS));
        updateDriverPanel();

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, driverPanel);
        splitPane.setResizeWeight(0.5);

        getContentPane().add(splitPane);
        getContentPane().setBackground(Color.BLACK);

        setVisible(true);

    }

    private void showSplashScreen() {
        JFrame splashFrame = new JFrame();
        splashFrame.setUndecorated(true);
        JLabel splashLabel = new JLabel(new ImageIcon("/resources/f1splash.png"));
        splashFrame.add(splashLabel);
        splashFrame.pack();
        splashFrame.setLocationRelativeTo(null);
        splashFrame.setVisible(true);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        splashFrame.dispose();
    }



    private void updateDriverPanel() {
        driverPanel.removeAll();
        for (Driver driver : driverList) {
            JLabel labelDriverInfo = new JLabel(driver.getName() + " driving for " + driver.getTeam());
            driverPanel.add(labelDriverInfo);
        }
        driverPanel.revalidate();
        driverPanel.repaint();
    }

    @Override
    @SuppressWarnings("methodlength")
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addDriverButton) {
            String name = JOptionPane.showInputDialog(this, "Enter Driver Name: ");
            String team = JOptionPane.showInputDialog(this, "Enter Team: ");
            String country = JOptionPane.showInputDialog(this, "Enter Country: ");
            int points = Integer.parseInt(JOptionPane.showInputDialog(this,
                    "Enter Career Points: "));
            int racewins = Integer.parseInt(JOptionPane.showInputDialog(this,
                    "Enter Race Wins: "));
            int topthrees = Integer.parseInt(JOptionPane.showInputDialog(this,
                    "Enter Podium Finishes: "));
            int polepositions = Integer.parseInt(JOptionPane.showInputDialog(this,
                    "Enter Pole Positions: "));
            int fastestlaps = Integer.parseInt(JOptionPane.showInputDialog(this,
                    "Enter Fastest Laps: "));

            driverList.add(new Driver(name, team, country, points, racewins, topthrees, polepositions, fastestlaps));
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
        } else if (e.getSource() == compareButton) {
            CompareDriver compareDriver = new CompareDriver();
            List<Driver> firsttolast = compareDriver.compareDrivers(driverList);
            Driver winner = firsttolast.get(0);

            JOptionPane.showMessageDialog(this, "Winning driver:\n" + winner.getName()
                    + " with a score of " + winner.getFinalscore() + "!");
        } else if (e.getSource() == clearButton) {
            driverList.clear();
            updateDriverPanel();

            JOptionPane.showMessageDialog(this, "Drivers cleared!");
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormulaOneCompareGUI());
    }
}
