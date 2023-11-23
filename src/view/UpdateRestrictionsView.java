package view;

import interface_adapter.main_menu.MainMenuState;
import interface_adapter.update_restrictions.UpdateRestrictionsState;
import interface_adapter.update_restrictions.UpdateRestrictionsViewModel;
import interface_adapter.update_restrictions.UpdateRestrictionsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UpdateRestrictionsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "update restriction";
    public final JButton MainMenu;
    private final UpdateRestrictionsViewModel updateRestrictionsViewModel;
    private final UpdateRestrictionsController updateRestrictionsController;

    // Add text fields and labels for each restriction
    private final JLabel foodItemLabel;
    private final JTextField foodItemTextField;
    private final JButton saveFoodItemButton;

    private final JLabel maxProteinLabel;
    private final JTextField maxProteinTextField;
    private final JButton saveMaxProteinButton;

    // Add more text fields, labels, and buttons for other restrictions...

    public UpdateRestrictionsView(UpdateRestrictionsController updateRestrictionsController,
                                  UpdateRestrictionsViewModel updateRestrictionsViewModel) {
        this.updateRestrictionsViewModel = updateRestrictionsViewModel;
        this.updateRestrictionsController = updateRestrictionsController;
        updateRestrictionsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(UpdateRestrictionsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        JPanel buttons = new JPanel();

        // Back to Main Menu button
        MainMenu = new JButton(UpdateRestrictionsViewModel.MAIN_MENU);
        buttons.add(MainMenu);
        add(buttons);

        // Initialize text fields, labels, and buttons
        foodItemLabel = new JLabel(UpdateRestrictionsViewModel.UPDATE_FOODITEM);
        foodItemTextField = new JTextField();
        saveFoodItemButton = new JButton(UpdateRestrictionsViewModel.SAVE);

        // Add action listener for the save button
        saveFoodItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement save logic for food item
                System.out.println("Save food item button clicked.");
            }
        });

        // Initialize the missing components
        maxProteinLabel = new JLabel(UpdateRestrictionsViewModel.UPDATE_MAXPROTEIN);
        maxProteinTextField = new JTextField();
        saveMaxProteinButton = new JButton(UpdateRestrictionsViewModel.SAVE);

        // Add action listener for the save button
        saveMaxProteinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement save logic for max protein
                System.out.println("Save max protein button clicked.");
            }
        });

        // Add components to the panel
        addComponent(foodItemLabel, foodItemTextField, saveFoodItemButton);
        addComponent(maxProteinLabel, maxProteinTextField, saveMaxProteinButton);

        // Add action listener for the Main Menu button
        MainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(MainMenu)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    currentState.setView_name("get recipe");
                    updateRestrictionsController.execute(currentState.getView_name());
                }
            }
        });
    }

    // Helper method to add components to the panel
    private void addComponent(JLabel label, JTextField textField, JButton saveButton) {
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(saveButton);
        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        UpdateRestrictionsState state = (UpdateRestrictionsState) evt.getNewValue();
        if (state.getError() != null)
            JOptionPane.showMessageDialog(this, "Recipes: Will finalize when API works");
    }
}
