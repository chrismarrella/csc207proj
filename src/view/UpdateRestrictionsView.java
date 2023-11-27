package view;
import interface_adapter.update_restrictions.UpdateRestrictionsViewModel;
import interface_adapter.update_restrictions.UpdateRestrictionsState;
import interface_adapter.update_restrictions.UpdateRestrictionsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UpdateRestrictionsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "update restriction";
    public final UpdateRestrictionsViewModel updateRestrictionsViewModel;

    // Add a JSpinner component
    private JSpinner spinner;

    public UpdateRestrictionsView(UpdateRestrictionsViewModel updateRestrictionsViewModel) {
        this.updateRestrictionsViewModel = updateRestrictionsViewModel;
        updateRestrictionsViewModel.addPropertyChangeListener(this);

        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1); // Change the range and step as needed
        spinner = new JSpinner(spinnerModel);

        add(spinner);

        spinner.addChangeListener(e -> handleSpinnerChange());

    }

    private void handleSpinnerChange() {
        int spinnerValue = (int) spinner.getValue();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle other actions if needed
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property changes if needed
    }
}

