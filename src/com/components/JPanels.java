package com.components;

import javax.swing.JPanel;
import java.awt.Dimension;

public class JPanels extends JPanel{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public JPanels(int x, int y, int w, int h){
        this.setBounds(x, y, w, h);
        this.setPreferredSize(new Dimension(w, h));
        this.setMaximumSize(new Dimension(w, h));
    }

}
