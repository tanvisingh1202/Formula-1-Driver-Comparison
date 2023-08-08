//package ui;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        FormulaOneCompare formulaOneCompare = new FormulaOneCompare();
//        formulaOneCompare.run(scanner);
//    }
//}

package ui;

import java.util.Scanner;
import javax.swing.*;

public class Main {
    // effects: allows the user to pick between GUI and console
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the mode: ");
        System.out.println("1. Console Mode");
        System.out.println("2. GUI Mode");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                runConsoleMode(scanner);
                break;
            case 2:
                runGUI();
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    // modifies: formulaOneCompare, scanner
    // effects: runs formulaOneCompare
    private static void runConsoleMode(Scanner scanner) {
        FormulaOneCompare formulaOneCompare = new FormulaOneCompare();
        formulaOneCompare.run(scanner);
    }

    // effects: runs formulaOneCompareGUI
    private static void runGUI() {
        SwingUtilities.invokeLater(() -> {
            FormulaOneCompareGUI gui = new FormulaOneCompareGUI();
            gui.setVisible(true);
        });
    }
}