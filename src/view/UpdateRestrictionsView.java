package view;
import interface_adapter.main_menu.MainMenuController;
import interface_adapter.main_menu.MainMenuState;
import interface_adapter.main_menu.MainMenuViewModel;
import interface_adapter.update_restrictions.UpdateRestrictionsController;
import interface_adapter.update_restrictions.UpdateRestrictionsState;
import interface_adapter.update_restrictions.UpdateRestrictionsViewModel;
import entities.User;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
    private final MainMenuController mainMenuController;
    public User user;

    public UpdateRestrictionsView(UpdateRestrictionsController updateRestrictionController,UpdateRestrictionsViewModel updateRestrictionsViewModel, MainMenuController mainMenuController, MainMenuViewModel mainMenuViewModel) {
        this.updateRestrictionsViewModel = updateRestrictionsViewModel;
        this.updateRestrictionController = updateRestrictionController;
        this.mainMenuController = mainMenuController;

        // Initialize user field
        updateRestrictionsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel(UpdateRestrictionsViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(title);

        //Buttons
        JPanel buttons = new JPanel();

        savecals = new JButton(UpdateRestrictionsViewModel.SET + " Max Calories Restriction");
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


        FoodItemTextBox = new JTextField(10);

        add(new JLabel("Enter Restricted Food Item:"));
        add(FoodItemTextBox);

        SpinnerNumberModel maxcalModel = new SpinnerNumberModel(0, 0, 800, 1);
        SpinnerNumberModel mincalModel = new SpinnerNumberModel(0, 0, 800, 1);
        SpinnerNumberModel maxcarbModel = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel mincarbModel = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel maxfatModel = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel minfatModel = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel maxproteinModel = new SpinnerNumberModel(0, 0, 100, 1);
        SpinnerNumberModel minproteinModel = new SpinnerNumberModel(0, 0, 100, 1);

        // Initialize each spinner
        maxcalspinner = new JSpinner(maxcalModel);
        mincalspinner = new JSpinner(mincalModel);
        maxcarbspinner = new JSpinner(maxcarbModel);
        mincarbspinner = new JSpinner(mincarbModel);
        maxfatspinner = new JSpinner(maxfatModel);
        minfatspinner = new JSpinner(minfatModel);
        maxproteinspinner = new JSpinner(maxproteinModel);
        minproteinspinner = new JSpinner(minproteinModel);

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
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float maxcals = ((Number) maxcalspinner.getValue()).floatValue();
                currentState.setMaxcals(maxcals);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        mincalspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float mincals = ((Number) mincalspinner.getValue()).floatValue();
                currentState.setMincals(mincals);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        savecals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(savecals)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();

                    updateRestrictionController.execute("maxcals", currentState.getMaxcals());
                    updateRestrictionController.execute("mincals", currentState.getMincals());
                }
            }
        });

        maxcarbspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float maxcarbs = ((Number) maxcarbspinner.getValue()).floatValue();
                currentState.setMaxcarbs(maxcarbs);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        mincarbspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float mincarbs = ((Number) mincarbspinner.getValue()).floatValue();
                currentState.setMincarbs(mincarbs);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        savecarbs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(savecarbs)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();

                    updateRestrictionController.execute("maxcarbs", currentState.getMaxcarbs());
                    updateRestrictionController.execute("mincarbs", currentState.getMincarbs());
                }
            }
        });

        maxfatspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float maxfats = ((Number) maxfatspinner.getValue()).floatValue();
                currentState.setMaxfat(maxfats);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        minfatspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float minfat = ((Number) minfatspinner.getValue()).floatValue();
                currentState.setMinfat(minfat);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        savefats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(savefats)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();

                    updateRestrictionController.execute("maxfat", currentState.getMaxfat());
                    updateRestrictionController.execute("minfat", currentState.getMinfat());
                }
            }
        });

        maxproteinspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float maxprotein = ((Number) maxproteinspinner.getValue()).floatValue();
                currentState.setMaxprotein(maxprotein);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        minproteinspinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float minprotein = ((Number) minproteinspinner.getValue()).floatValue();
                currentState.setMinprotein(minprotein);
                updateRestrictionsViewModel.setState(currentState);
            }
        });
        saveprotein.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(saveprotein)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();

                    updateRestrictionController.execute("maxprotein", currentState.getMaxprotein());
                    updateRestrictionController.execute("minprotein", currentState.getMinprotein());
                }
            }
        });

        savefooditem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(savefooditem)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();

                    updateRestrictionController.execute(currentState.getRestriction(), 1.0f);
                    System.out.println("Save food item button worked " + currentState.getRestriction());

                }
            }
        });

        FoodItemTextBox.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                String text = FoodItemTextBox.getText() + e.getKeyChar();
                currentState.setRestriction(text);
                updateRestrictionsViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        //Back Button
        main_menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(main_menu)) {
                    MainMenuState currentState = mainMenuViewModel.getState();
                    currentState.setView_name("main menu");
                    mainMenuController.execute(currentState.getView_name());
                }
            }
        });

        enableKeto.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Keto is selected");
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    Float True = UpdateRestrictionsViewModel.TRUE;
                    currentState.setKeto(True);
                    updateRestrictionController.execute("keto", currentState.getKeto());
                } else {
                    System.out.println("Keto is unselected");
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    Float False = UpdateRestrictionsViewModel.False;
                    currentState.setKeto(False);
                    updateRestrictionController.execute("keto", currentState.getKeto());
                }
            }
        });

        enableVegan.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Vegan is selected");
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    Float True = UpdateRestrictionsViewModel.TRUE;
                    currentState.setVegan(True);
                    updateRestrictionController.execute("vegan", currentState.getVegan());
                } else {
                    System.out.println("Vegan is unselected");
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    Float False = UpdateRestrictionsViewModel.False;
                    currentState.setVegan(False);
                    updateRestrictionController.execute("vegan", currentState.getVegan());
                }

            }
        });


        enableVegetarian.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Vegetarian is selected");
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    Float True = UpdateRestrictionsViewModel.TRUE;
                    currentState.setVegetarian(True);
                    updateRestrictionController.execute("vegetarian", currentState.getVegetarian());
                } else {
                    System.out.println("Vegetarian is unselected");
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    Float False = UpdateRestrictionsViewModel.False;
                    currentState.setVegetarian(False);
                    updateRestrictionController.execute("vegetarian", currentState.getVegetarian());
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        UpdateRestrictionsState state = (UpdateRestrictionsState) evt.getNewValue();
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(this, state.getError());
        }
    }
}

