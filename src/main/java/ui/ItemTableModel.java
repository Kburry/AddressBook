package ui;

import book.AddressBook;
import book.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.table.AbstractTableModel;

@Component
public class ItemTableModel extends AbstractTableModel {
    @Autowired
    protected AddressBook itemList;
    private static final int NAMECOLUMN = 0;
    private static final int ADDRESSCOLUMN = 1;
    private static final int PNCOLUMN = 2;

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public int getColumnCount() {
        return 3;
    }

    public String getColumnName(int column) {
        if(column == NAMECOLUMN)
            return "Name";
        else if(column == ADDRESSCOLUMN)
            return "Street";
        else
            return "Phone Number";
    }

    @Autowired
    public void setItemList(AddressBook itemList) {
        this.itemList = itemList;
    }

    public int getRowCount() {
        return itemList.size();
    }

    public void setValueAt(Object value,
                           int rowIndex, int columnIndex) {
        BuddyInfo buddy = itemList.getBuddyAt(rowIndex);
        if(columnIndex == NAMECOLUMN)
            buddy.setName((String) value);
        else if(columnIndex == ADDRESSCOLUMN)
            buddy.setAddress((String) value);
        else
            buddy.setPhoneNumber((String) value);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        BuddyInfo buddy = itemList.getBuddyAt(rowIndex);
        if(columnIndex == NAMECOLUMN)
            return buddy.getName();
        else if(columnIndex == ADDRESSCOLUMN)
            return  buddy.getAddress();
        return buddy.getPhoneNumber();
    }
}