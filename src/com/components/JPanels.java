package com.components;

import javax.swing.*;
import java.awt.Dimension;
import java.util.Objects;

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

    public JPanels(String path, int x, int y, int w, int h){
        this.setBounds(x, y, w, h);
        this.setPreferredSize(new Dimension(w, h));
        this.setMaximumSize(new Dimension(w, h));
        Background bg = new Background(new ImageIcon(Objects.requireNonNull(getClass().getResource(path))).getImage());
        bg.setBounds(x, y, w, h);
        this.add(bg);
    }

}
