package view;

import javax.swing.*;

/**
 * A panel containing a label and a text field.
 */
class LabelTextPanel extends JPanel {
    LabelTextPanel(JLabel label, JTextField textField) {
        /**
         * This constructor instantiates a new label text panel.
         * @param label The label.
         * @param textField The text field.
         */
        this.add(label);
        this.add(textField);
    }
}
