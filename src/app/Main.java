package app;

import javax.swing.*;
import java.awt.*;

class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("CHEFFI");
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        JButton GenerateRecipe = new JButton("Generate Recipe");
        frame.getContentPane().add(GenerateRecipe);
        panel.add(GenerateRecipe);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setVisible(true);

    }
}