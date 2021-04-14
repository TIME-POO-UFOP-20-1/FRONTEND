package com.components;

import javax.swing.JButton;
import java.awt.*;

public class JButtons extends JButton {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public JButtons(int w, int h, String Titulo){
        this.setPreferredSize(new Dimension(w, h));
        this.setText(Titulo);
    }
}
