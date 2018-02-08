package ui;

import java.awt.event.ActionEvent;

public class DeleteActionListener extends ListTableActionListener{
    public void actionPerformed(ActionEvent e) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            // if there is no selected row, don't do anything
            return;
        }

        if (table.isEditing()) {
            // if we are editing the table, don't do anything
            return;
        }

        book.remove(selectedRow);
        table.revalidate();
    }
}
