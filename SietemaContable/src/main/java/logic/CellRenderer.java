package logic;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.Serial;

public class CellRenderer extends DefaultTableCellRenderer {

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null && value.toString().length() <= 4) {
            this.setValue(table.getValueAt(row, column));
            this.setFont(this.getFont().deriveFont(Font.BOLD));
        }
        return this;
    }
}
