package Main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        createAndShowGUI();
    }

    public static void createAndShowGUI() {
        JFrame windows = new JFrame("2D game");
        Gamepanel game = new Gamepanel();

        windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windows.add(game);
        windows.pack();
        windows.setLocationRelativeTo(null);
        windows.setVisible(true);

        game.startGame();
    }
}
