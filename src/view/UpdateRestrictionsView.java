package view;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.update_restrictions.UpdateRestrictionsController;
import interface_adapter.update_restrictions.UpdateRestrictionsState;
import interface_adapter.update_restrictions.UpdateRestrictionsViewModel;
import entities.User;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateRestrictionsView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "update restriction";
    public final UpdateRestrictionsViewModel updateRestrictionsViewModel;
    private final JSpinner maxcalspinner;
    private final JSpinner mincalspinner;
    private final JSpinner maxcarbspinner;
    private final JSpinner mincarbspinner;
    private final JSpinner maxfatspinner;
    private final JSpinner minfatspinner;
    private final JSpinner maxproteinspinner;
    private final JSpinner minproteinspinner;
    private final JButton savecals;
    private final JButton savefats;
    private final JButton savecarbs;
    private final JButton saveprotein;
    private final JButton savefooditem;
    private final JButton main_menu;
    private final JTextField FoodItemTextBox;
    private final JCheckBox enableKeto;
    private final JCheckBox enableVegan;
    private final JCheckBox enableVegetarian;
    private final UpdateRestrictionsController updateRestrictionController;
    public User user;

    public UpdateRestrictionsView(UpdateRestrictionsController updateRestrictionController,UpdateRestrictionsViewModel updateRestrictionsViewModel) {
        this.updateRestrictionsViewModel = updateRestrictionsViewModel;
        this.updateRestrictionController = updateRestrictionController;
        // Initialize user field
        updateRestrictionsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(UpdateRestrictionsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        //Buttons
        JPanel buttons = new JPanel();

        savecals = new JButton(UpdateRestrictionsViewModel.SET + " Calories Restrictions");
        buttons.add(savecals);
        add(buttons);

        savefats = new JButton(UpdateRestrictionsViewModel.SET + " Fat Restrictions");
        buttons.add(savefats);
        add(buttons);

        savecarbs = new JButton(UpdateRestrictionsViewModel.SET + " Carb Restrictions");
        buttons.add(savecarbs);

        saveprotein = new JButton(UpdateRestrictionsViewModel.SET + " Protein Restrictions");
        buttons.add(saveprotein);
        add(buttons);

        savefooditem = new JButton(UpdateRestrictionsViewModel.SAVE);
        buttons.add(savefooditem);
        add(buttons);

        main_menu = new JButton(UpdateRestrictionsViewModel.MAINMENU);
        buttons.add(main_menu);
        add(buttons);

        //Check Boxes
        enableKeto = new JCheckBox(UpdateRestrictionsViewModel.KETO);
        enableVegan = new JCheckBox(UpdateRestrictionsViewModel.VEGAN);
        enableVegetarian = new JCheckBox(UpdateRestrictionsViewModel.VEGETARIAN);

        add(enableKeto);
        add(enableVegan);
        add(enableVegetarian);


        //Add Food Item Text Box
        FoodItemTextBox = new JTextField(10);

        add(new JLabel("Enter Restricted Food Item:"));
        add(FoodItemTextBox);

        // Create SpinnerNumberModel for each spinner with default values
        int defaultMaxCalValue = 100;
        int defaultMinCalValue = 0;
        int defaultMaxCarbValue = 100;
        int defaultMinCarbValue = 0;
        int defaultMaxFatValue = 100;
        int defaultMinFatValue = 0;
        int defaultMaxProteinValue = 100;
        int defaultMinProteinValue = 0;

        SpinnerNumberModel maxcalModel = new SpinnerNumberModel(defaultMaxCalValue, 0, 100, 1);
        SpinnerNumberModel mincalModel = new SpinnerNumberModel(defaultMinCalValue, 0, 100, 1);
        SpinnerNumberModel maxcarbModel = new SpinnerNumberModel(defaultMaxCarbValue, 0, 100, 1);
        SpinnerNumberModel mincarbModel = new SpinnerNumberModel(defaultMinCarbValue, 0, 100, 1);
        SpinnerNumberModel maxfatModel = new SpinnerNumberModel(defaultMaxFatValue, 0, 100, 1);
        SpinnerNumberModel minfatModel = new SpinnerNumberModel(defaultMinFatValue, 0, 100, 1);
        SpinnerNumberModel maxproteinModel = new SpinnerNumberModel(defaultMaxProteinValue, 0, 100, 1);
        SpinnerNumberModel minproteinModel = new SpinnerNumberModel(defaultMinProteinValue, 0, 100, 1);

        // Initialize each spinner
        maxcalspinner = new JSpinner(maxcalModel);
        mincalspinner = new JSpinner(mincalModel);
        maxcarbspinner = new JSpinner(maxcarbModel);
        mincarbspinner = new JSpinner(mincarbModel);
        maxfatspinner = new JSpinner(maxfatModel);
        minfatspinner = new JSpinner(minfatModel);
        maxproteinspinner = new JSpinner(maxproteinModel);
        minproteinspinner = new JSpinner(minproteinModel);

        // Setting spinner values to already saved restriction value
        setSpinnerValue(maxcalspinner, user, "maxcal");
        setSpinnerValue(mincalspinner, user, "mincal");
        setSpinnerValue(maxcarbspinner, user, "maxcarb");
        setSpinnerValue(mincarbspinner, user, "mincarb");
        setSpinnerValue(maxfatspinner, user, "maxfat");
        setSpinnerValue(minfatspinner, user, "minfat");
        setSpinnerValue(maxproteinspinner, user, "maxprotein");
        setSpinnerValue(minproteinspinner, user, "minprotein");

        // Add the spinners to the panel
        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MAXCals));
        add(maxcalspinner);
        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MINCals));
        add(mincalspinner);

        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MAXCARBS));
        add(maxcarbspinner);
        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MINCARBS));
        add(mincarbspinner);

        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MAXFATS));
        add(maxfatspinner);
        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MINFATS));
        add(minfatspinner);

        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MAXPROTEIN));
        add(maxproteinspinner);
        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MINPROTEIN));
        add(minproteinspinner);

        // Add a listener to handle changes in the spinners' values
        maxcalspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });

        mincalspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });

        maxcarbspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });

        mincarbspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

            }
        });

        maxfatspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            }
        });

        minfatspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            }
        });

        maxproteinspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            }
        });

        minproteinspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
            }
        });

        //Back Button
        main_menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(main_menu)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    currentState.setView_name("main menu");
                    updateRestrictionController.execute(currentState.getView_name(), 0.25f);
                }
            }
        });
    }


    //Might have to move this somewhere else or adapt it elsewhere
    private void setSpinnerValue(JSpinner spinner, User user, String restriction) {
        try {
            Integer restrictionValue = Math.round(user.getRestriction(restriction));
            // Check if "min" or "max" is present in the restriction name
            if (restrictionValue != null) {
                spinner.setValue(restrictionValue);
            }
        } catch (Exception e) {
            spinner.setValue(0); // default to 0 if there is an exception (for example there isnt a user right now)
        }
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

