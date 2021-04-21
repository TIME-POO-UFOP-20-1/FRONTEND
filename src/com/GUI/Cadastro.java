package com.GUI;

import com.components.Background;

import com.components.JButtons;
import com.components.JLabels;
import com.components.JPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Cadastro extends JPanel implements ActionListener {

    private final JButtons Cadastrar = new JButtons(125, 25, "CADASTRAR");
    private final JButtons Voltar = new JButtons(125, 25, "VOLTAR");
    private final JTextField UsuarioField = new JTextField();
    private final JTextField SenhaField = new JTextField();

    private final Principal parent;


    public Cadastro(Principal parent){
        super();
        this.parent = parent;
        createGUI();
    }

    private void createGUI(){
        this.setBounds(0, 0, 1080, 540);
        this.setLayout(null);
        this.add(Container());
        Background bg = new Background(new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/CadastroImage.png"))).getImage());
        bg.setBounds(0, 0, 830, 540);
        this.add(bg);
        this.setVisible(true);
    }

    private JPanels Container() {
        JPanels Container = new JPanels(830, 0, 250, 540);
        Container.setLayout(null);
        Container.add(Logo());
        Container.add(Formulario());
        Container.add(ButtonsPanel());
        return Container;
    }

    private JPanels Logo(){
        JPanels Logo = new JPanels(75,30,100,100);
        Logo.setBackground(Color.red);
        return Logo;
    }

    private JPanels Formulario(){
        JPanels Formulario = new JPanels(25, 150, 200, 175);
        Formulario.setLayout(null);
        Formulario.add(FSCPanel());
        Formulario.add(UsuarioPanel());
        Formulario.add(UsuarioFieldPanel());
        Formulario.add(SenhaPanel());
        Formulario.add(SenhaFieldPanel());
        return Formulario;
    }

    private JPanels FSCPanel(){
        JPanels FSC = new JPanels(25, 5, 170, 30);
        FSC.add(new JLabels("Faça seu Cadastro!", 20, 1));
        return FSC;
    }

    private JPanels ButtonsPanel(){
        JPanels ButtonsLabel = new JPanels(50, 350, 150, 130);
        ButtonsLabel.setLayout(null);
        ButtonsLabel.add(CPanel());
        ButtonsLabel.add(VPanel());
        return ButtonsLabel;
    }


    private JPanels CPanel(){
        JPanels CPanel = new JPanels(10, 40, 125, 30);
        Cadastrar.addActionListener(this);
        CPanel.add(Cadastrar);
        return CPanel;
    }

    private JPanels VPanel(){
        JPanels vPanel = new JPanels(10, 75, 125, 30);
        Voltar.addActionListener(this);
        vPanel.add(Voltar);
        return vPanel;
    }

    private JPanels UsuarioPanel(){
        JPanels UsuarioPanel = new JPanels(10, 40, 50, 20);
        UsuarioPanel.add(new JLabels("Usuario:", 12, 1));
        return UsuarioPanel;
    }

    private JPanels UsuarioFieldPanel(){
        JPanels UsuarioFieldPanel = new JPanels(10, 63, 150, 30);
        UsuarioFieldPanel.setLayout(null);
        UsuarioFieldPanel.add(UsuarioField());
        return UsuarioFieldPanel;
    }

    private JTextField UsuarioField(){
        UsuarioField.setBounds(0, 0, 150, 30);
        return UsuarioField;
    }

    private JPanels SenhaPanel(){
        JPanels Senha = new JPanels(10, 100, 50, 20);
        Senha.add(new JLabels("Senha:", 12, 1));
        return Senha;
    }

    private JPanels SenhaFieldPanel(){
        JPanels SenhaFieldPanel = new JPanels(10, 125, 150, 30);
        SenhaFieldPanel.setLayout(null);
        SenhaFieldPanel.add(SenhaField());
        return SenhaFieldPanel;
    }

    private JTextField SenhaField(){
        SenhaField.setBounds(0, 0, 150, 30);
        return SenhaField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Voltar){
            handleGoBack();
        }else if(e.getSource()==Cadastrar){
            try {
                handleCadastro();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    private void handleGoBack(){
        parent.setContentPane(new Login(parent));
    }

    private void handleCadastro() throws InterruptedException {
        parent.sendMessage("cadastro");
        Thread.sleep(1000);
        parent.sendMessage(UsuarioField.getText());
        Thread.sleep(1000);
        parent.sendMessage(SenhaField.getText());
        boolean confirmation = parent.getConfirmation();
        if (confirmation) {
            handleGoBack();
        }
    }

}