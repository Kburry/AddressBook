package ui;

import book.BuddyInfo;

import java.awt.event.ActionEvent;

public class AddActionListener extends ListTableActionListener{
    public void actionPerformed(ActionEvent e) {
        book.addBuddy(new BuddyInfo());
        table.revalidate();
    }
}
