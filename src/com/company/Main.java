package com.company;


import com.GUI.Principal;

import javax.swing.SwingUtilities;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Principal("Clinica").setVisible(true);
        });
    }
}
