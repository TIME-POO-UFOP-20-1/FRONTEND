package com.GUI.Admin.UserCard;

import com.GUI.Principal;
import com.components.JButtons;
import com.components.JPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class User extends JPanel implements ActionListener {
    private final Principal parent;
    private final CardLayout card = new CardLayout();
    private final JPanels cardPanels = new JPanels(0, 400, 500, 100);

    private final JButtons newUser = new JButtons(90, 30, "Novo");
    private final JButtons changeUser = new JButtons(90, 30, "Alterar");
    private final JButtons deleteUser = new JButtons(90, 30, "Apagar");

    public User(Principal parent){
        super();
        this.parent = parent;
        createGUI();
    }

    private void createGUI(){
        this.setBounds(75, 0, 1005, 540);
        this.setLayout(null);
        this.add(usersMenuOptionsPanel());
        this.add(new JPanels("/assets/menuUsers.png", 505, 0, 505, 540));
    }

    private JPanels usersMenuOptionsPanel(){
        JPanels Container = new JPanels(0, 0, 500, 540);
        Container.setLayout(null);
        Container.add(usersListPanel());
        Container.add(usersListPanelButtons());
        Container.add(cardPanels());
        return Container;
    }

    private JPanels usersListPanel(){
        JPanels Container = new JPanels(50, 50, 400, 310);
        parent.sendMessage("userList");
        List<String> setUser = (List<String>) parent.getObject();
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
        Container.add(usersnewUserPanelButton());
        Container.add(userschangeUserPanelButton());
        Container.add(usersListdeleteUserPanelButton());
        return Container;
    }

    private JPanel usersnewUserPanelButton(){
        JPanels Container = new JPanels(0, 0, 100, 30);
        newUser.addActionListener(this);
        Container.add(newUser);
        return Container;
    }

    private JPanel userschangeUserPanelButton(){
        JPanels Container = new JPanels(0, 0, 100, 30);
        Container.add(changeUser);
        return Container;
    }

    private JPanel usersListdeleteUserPanelButton(){
        JPanels Container = new JPanels(0, 0, 100, 30);
        Container.add(deleteUser);
        return Container;
    }

    private JPanels cardPanels(){
        cardPanels.setLayout(card);
        cardPanels.add(messageCardPanel(), "messageCardPanel");
        cardPanels.add(new newUser(card, cardPanels), "createUserCardPanel");
        return cardPanels;
    }

    private JPanels messageCardPanel(){
        return new JPanels(0, 0, 500, 300);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==newUser){
            card.show(cardPanels, "createUserCardPanel");
        }
    }


}
