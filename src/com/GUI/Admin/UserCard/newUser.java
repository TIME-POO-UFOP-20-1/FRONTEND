package com.GUI.Admin.UserCard;

import com.components.JButtons;
import com.components.JLabels;
import com.components.JPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class newUser extends JPanel implements ActionListener {
    private final CardLayout card;
    private final JPanels cardPanels;

    private final JTextField UsuarioField = new JTextField();
    private final JTextField SenhaField = new JTextField();

    private final JButtons ConfirmnewUser = new JButtons(120, 30, "Registrar");
    private final JButtons CancelnewUser = new JButtons(120, 30, "Cancelar");


    public newUser(CardLayout card, JPanels cardPanels){
        super();
        this.card = card;
        this.cardPanels = cardPanels;
        createGUI();
    }

    private void createGUI(){
        this.setBounds(0, 0, 500, 350);
        this.add(UsuarioPanel());
        this.add(UsuarioFieldPanel());
        this.add(SenhaPanel());
        this.add(SenhaFieldPanel());
        this.add(ButtomGroupTipePanel());
        this.add(ConfirmCancelPanel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ConfirmnewUser){
            System.out.println("Clicou");
        }else if(e.getSource()==CancelnewUser){
            card.show(cardPanels, "messageCardPanel");
        }
    }

    private JPanels UsuarioPanel(){
        JPanels UsuarioPanel = new JPanels(0, 40, 50, 20);
        UsuarioPanel.add(new JLabels("Usuario:", 12, 1));
        return UsuarioPanel;
    }

    private JPanels UsuarioFieldPanel(){
        JPanels UsuarioFieldPanel = new JPanels(0, 63, 150, 30);
        UsuarioFieldPanel.setLayout(null);
        UsuarioFieldPanel.add(UsuarioField());
        return UsuarioFieldPanel;
    }

    private JTextField UsuarioField(){
        UsuarioField.setBounds(0, 0, 150, 30);
        return UsuarioField;
    }

    private JPanels SenhaPanel(){
        JPanels Senha = new JPanels(0, 100, 50, 20);
        Senha.add(new JLabels("Senha:", 12, 1));
        return Senha;
    }

    private JPanels SenhaFieldPanel(){
        JPanels SenhaFieldPanel = new JPanels(0, 125, 150, 30);
        SenhaFieldPanel.setLayout(null);
        SenhaFieldPanel.add(SenhaField());
        return SenhaFieldPanel;
    }

    private JTextField SenhaField(){
        SenhaField.setBounds(0, 0, 150, 30);
        return SenhaField;
    }

    private JPanels ButtomGroupTipePanel(){
        JPanels Container = new JPanels(0, 0, 500, 20);
        JRadioButton opt1 = new JRadioButton("Administrador");
        opt1.setActionCommand("A");
        JRadioButton opt2 = new JRadioButton("Assistente");
        opt2.setActionCommand("B");
        JRadioButton opt3 = new JRadioButton("Geral");
        opt3.setActionCommand("G");
        ButtonGroup group = new ButtonGroup();
        group.add(opt1);
        group.add(opt2);
        group.add(opt3);
        Container.add(opt1);
        Container.add(opt2);
        Container.add(opt3);
        return Container;
    }

    private JPanels ConfirmCancelPanel(){
        JPanels Container = new JPanels(0, 0, 500, 35);
        ConfirmnewUser.addActionListener(this);
        Container.add(ConfirmnewUser);
        CancelnewUser.addActionListener(this);
        Container.add(CancelnewUser);
        return Container;
    }

}