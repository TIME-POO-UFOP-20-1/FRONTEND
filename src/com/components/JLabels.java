package com.components;

import javax.swing.JLabel;
import java.awt.Font;

public class JLabels extends JLabel{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public JLabels(String Texto, int tam, int tipoF){
        this.setText(Texto);
        this.setFont(new Font("Roboto", tipoF, tam));
    }

}
