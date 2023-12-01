import app.Main;
import data_access.FileUserDataAccessObject;
import org.junit.Test;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import use_case.update_restrictions.*;
import entities.*;
import interface_adapter.update_restrictions.*;
import view.UpdateRestrictionsView;

import javax.swing.*;

import static org.junit.Assert.*;

public class UpdateRestrictionTests {

    public JButton getButton() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component component = ((JRootPane) root).getContentPane();

        JPanel panel = (JPanel) component;

        JPanel panel2 = (JPanel) panel.getComponent(0);

        UpdateRestrictionsView view = (UpdateRestrictionsView) panel2.getComponent(0);

        JPanel buttons = (JPanel) view.getComponent(4);

        return (JButton) buttons.getComponent(2); // this should be the clear button
    }
    @org.junit.Test
    public void testMainMenuButtonPresent() {
        Main.main(null);
        JButton button = getButton();
        assert(button.getText().equals("main menu"));
    }
    @Test
    public void testaddfoodtestriction() throws IOException {

    }
}
