package com.GUI;

import com.components.Background;
import com.components.JButtons;
import com.components.JPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class Menu extends JPanel implements ActionListener {
    private final Principal parent;
    private final CardLayout card = new CardLayout();
    private final JPanels cardPanels = new JPanels(75, 0, 1005, 540);
    private final JButtons users = new JButtons(75, 70, "usuarios", "/assets/UserIcon.png");
    private final JButtons workers = new JButtons(75, 70, "funcionarios","/assets/workerIcon.png");
    private final JButtons appointments = new JButtons(75, 70, "consultas", "/assets/ApointmentIcon.png");
    private final JButtons payments = new JButtons(75, 70, "pagamentos", "/assets/paymentsIcon.png");
    private final JButtons configurations = new JButtons(75, 70, "configurações", "/assets/configureIcon.png");
    private final JButtons exit = new JButtons(75, 70, "sair", "/assets/exitIcon.png");

    private List<String> setUser;

    private final JButtons newUser = new JButtons(90, 30, "Novo");
    private final JButtons changeUser = new JButtons(90, 30, "Alterar");
    private final JButtons deleteUser = new JButtons(90, 30, "Apagar");

    public Menu(Principal parent){
        super();
        this.parent = parent;
        createGUI();
    }

    private void createGUI(){
        this.setBounds(0, 0, 1080, 540);
        this.setLayout(null);
        this.add(FunctionsPanel());
        this.add(cardPanels());
    }

    private JPanels FunctionsPanel(){
        JPanels Container = new JPanels(0, 0, 70, 540);
        Container.setLayout(null);
        Container.setBackground(Color.black);
        Container.add(usersContainer());
        Container.add(workerContainer());
        Container.add(apointmentContainer());
        Container.add(paymentConteiner());
        Container.add(configurationsConteiner());
        Container.add(exitConteiner());
        Container.add(logoConteiner());
        return Container;
    }

    private JPanels usersContainer(){
        JPanels userContainer = new JPanels(0, -5, 75, 70);
        users.addActionListener(this);
        userContainer.add(users);
        return userContainer;
    }

    private JPanels workerContainer(){
        JPanels workerContainer = new JPanels(0, 68, 75, 70);
        workers.addActionListener(this);
        workerContainer.add(workers);
        return workerContainer;
    }

    private JPanels apointmentContainer(){
        JPanels apointmentContainer = new JPanels(0, 140, 75, 70);
        appointments.addActionListener(this);
        apointmentContainer.add(appointments);
        return apointmentContainer;
    }

    private JPanels paymentConteiner(){
        JPanels paymentConteiner = new JPanels(0, 215, 75, 70);
        payments.addActionListener(this);
        paymentConteiner.add(payments);
        return paymentConteiner;
    }

    private JPanels configurationsConteiner(){
        JPanels configurationsConteiner = new JPanels(0, 290, 75, 70);
        configurations.addActionListener(this);
        configurationsConteiner.add(configurations);
        return configurationsConteiner;
    }

    private JPanels exitConteiner(){
        JPanels exitConteiner = new JPanels(0, 365, 75, 70);
        exit.addActionListener(this);
        exitConteiner.add(exit);
        return exitConteiner;
    }

    private JPanels logoConteiner(){
        JPanels logoConteiner = new JPanels(0, 440, 75, 70);
        Background logo = new Background(new ImageIcon(Objects.requireNonNull(getClass().getResource("/assets/dentistIcon.png"))).getImage());
        logo.setBounds(-10, 0, 40, 50);
        logoConteiner.add(logo);
        return logoConteiner;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==users){
            card.show(cardPanels, "usersMenu");
        }else if(e.getSource()==workers) {
            card.show(cardPanels, "workesMenu");
        }else if(e.getSource()==appointments){
            card.show(cardPanels, "appointmentsMenu");
        }else if(e.getSource()==payments){
            card.show(cardPanels, "paymentsMenu");
        }else if(e.getSource()==configurations){
            card.show(cardPanels, "configurationsMenu");
        }else if(e.getSource()==exit){
            parent.setContentPane(new Login(parent));
        }
    }

    private JPanels cardPanels(){
        cardPanels.setLayout(card);
        cardPanels.add(backgroundPanel("/assets/menuAdmin.png", 75, 1005), "backgroundPanel");
        cardPanels.add(usersMenu(), "usersMenu");
        cardPanels.add(workesMenu(), "workesMenu");
        cardPanels.add(appointmentsMenu(), "appointmentsMenu");
        cardPanels.add(paymentsMenu(), "paymentsMenu");
        cardPanels.add(configurationsMenu(), "configurationsMenu");
        return cardPanels;
    }

    private JPanels backgroundPanel(String path, int x, int w){
        JPanels Container = new JPanels(x, 0, w, 540);
        Background bg = new Background(new ImageIcon(Objects.requireNonNull(getClass().getResource(path))).getImage());
        bg.setBounds(x, 0, w, 540);
        Container.add(bg);
        return Container;
    }

    private JPanels usersMenu(){
        JPanels Container = new JPanels(75, 0, 1005, 540);
        Container.setLayout(null);
        Container.add(usersMenuOptionsPanel());
        Container.add(backgroundPanel("/assets/menuUsers.png", 505, 505));
        return Container;
    }

    private JPanels usersMenuOptionsPanel(){
        JPanels Container = new JPanels(0, 0, 500, 540);
        Container.setLayout(null);
        Container.add(usersListPanel());
        Container.add(usersListPanelButtons());
        return Container;
    }

    private JPanels usersListPanel(){
        JPanels Container = new JPanels(50, 50, 400, 440);
        parent.sendMessage("userList");
        setUser = (List<String>) parent.getObject();
        try {
            JList<Object> list = new JList<>(setUser.toArray());
            list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            list.setVisibleRowCount(-1);
            JScrollPane listScroller = new JScrollPane(list);
            listScroller.setPreferredSize(new Dimension(250, 80));
            Container.add(list);
        }catch (NullPointerException e) {
            e.printStackTrace();
        }
        return Container;
    }

    private JPanels usersListPanelButtons(){
        JPanels Container = new JPanels(0, 10, 400, 40);
        Container.add(usersListnewUserPanel());
        Container.add(usersListchangeUserPanel());
        Container.add(usersListdeleteUserPanel());
        return Container;
    }

    private JPanel usersListnewUserPanel(){
        JPanels Container = new JPanels(0, 0, 100, 30);
        Container.add(newUser);
        return Container;
    }

    private JPanel usersListchangeUserPanel(){
        JPanels Container = new JPanels(0, 0, 100, 30);
        Container.add(changeUser);
        return Container;
    }

    private JPanel usersListdeleteUserPanel(){
        JPanels Container = new JPanels(0, 0, 100, 30);
        Container.add(deleteUser);
        return Container;
    }

    private JPanels workesMenu(){
        JPanels Container = new JPanels(75, 0, 1005, 540);
        Container.setLayout(null);
        Container.add(workesMenuOptionsPanel());
        Container.add(backgroundPanel("/assets/menuWorkers.png", 505, 505));
        return Container;
    }

    private JPanels workesMenuOptionsPanel(){
        JPanels Container = new JPanels(0, 0, 500, 540);
        Container.setLayout(null);
        return Container;
    }

    private JPanels appointmentsMenu(){
        JPanels Container = new JPanels(75, 0, 1005, 540);
        Container.setLayout(null);
        Container.add(appointmentsMenuOptionsPanel());
        Container.add(backgroundPanel("/assets/menuAppointment.png", 505, 505));
        return Container;
    }

    private JPanels appointmentsMenuOptionsPanel(){
        JPanels Container = new JPanels(0, 0, 500, 540);
        Container.setLayout(null);
        return Container;
    }


    private JPanels paymentsMenu(){
        JPanels Container = new JPanels(75, 0, 1005, 540);
        Container.setLayout(null);
        Container.add(paymentsMenuOptionsPanel());
        Container.add(backgroundPanel("/assets/menuPayments.png", 505, 505));
        return Container;
    }

    private JPanels paymentsMenuOptionsPanel(){
        JPanels Container = new JPanels(0, 0, 500, 540);
        Container.setLayout(null);
        return Container;
    }

    private JPanels configurationsMenu(){
        JPanels Container = new JPanels(75, 0, 1005, 540);
        Container.setLayout(null);
        Container.setBackground(Color.GRAY);
        return Container;
    }

}
