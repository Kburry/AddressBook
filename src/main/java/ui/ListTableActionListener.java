package ui;

import book.AddressBook;
import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class ListTableActionListener implements ActionListener {
    protected JTable table;
    protected AddressBook book;

    public void setList(AddressBook list) {
        this.book = list;
    }

    public void setTable(JTable itemTable) {
        this.table = itemTable;
    }
}
