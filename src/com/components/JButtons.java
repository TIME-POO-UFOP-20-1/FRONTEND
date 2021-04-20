package com.components;

import javax.swing.JButton;
import java.awt.*;
import java.util.Objects;

public class JButtons extends JButton {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public JButtons(int w, int h, String Titulo){
        this.setPreferredSize(new Dimension(w, h));
        this.setText(Titulo);
    }

    public JButtons(int w, int h, String Titulo, String Path){
        this.setPreferredSize(new Dimension(w, h));
        this.setText(Titulo);
        this.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource(Path))));
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
    }

}
