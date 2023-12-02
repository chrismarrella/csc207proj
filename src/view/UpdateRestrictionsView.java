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
    public final JButton savemaxcals;
    public final JButton savemincals;
    public final JButton savemaxfats;
    public final JButton saveminfats;
    public final JButton savemaxcarbs;
    public final JButton savemincarbs;
    public final JButton savemaxprotein;
    public final JButton saveminprotein;
    public final JButton savefooditem;
    public final JButton main_menu;
    private final JTextField FoodItemTextBox;
    private final JCheckBox enableKeto;
    private final JCheckBox enableVegan;
    private final JCheckBox enableVegetarian;
    private final UpdateRestrictionsController updateRestrictionController;
    private final MainMenuController mainMenuController;

    /**
     * The user that is currently using CHEFFI.
     */
    public User user;
    /**
     * A window with a title and a JButton.
     */
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

        savemaxcals = new JButton(UpdateRestrictionsViewModel.SET + " Max Calories");
        buttons.add(savemaxcals);

        savemincals = new JButton(UpdateRestrictionsViewModel.SET + " Min Calories");
        buttons.add(savemincals);

        savemaxfats = new JButton(UpdateRestrictionsViewModel.SET + " Max Fat");
        buttons.add(savemaxfats);

        saveminfats = new JButton(UpdateRestrictionsViewModel.SET + " Min Fat");
        buttons.add(saveminfats);

        savemaxcarbs = new JButton(UpdateRestrictionsViewModel.SET + " Max Carb");
        buttons.add(savemaxcarbs);

        savemincarbs = new JButton(UpdateRestrictionsViewModel.SET + " Min Carb");
        buttons.add(savemincarbs);

        savemaxprotein = new JButton(UpdateRestrictionsViewModel.SET + " Max Protein");
        buttons.add(savemaxprotein);

        saveminprotein = new JButton(UpdateRestrictionsViewModel.SET + " Min Protein");
        buttons.add(saveminprotein);

        savefooditem = new JButton(UpdateRestrictionsViewModel.SAVE);
        buttons.add(savefooditem);

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
            /**
             * Called when the spinner's value changes.
             * @param e  a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float maxcals = ((Number) maxcalspinner.getValue()).floatValue();
                currentState.setMaxcals(maxcals);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        mincalspinner.addChangeListener(new ChangeListener() {
            /**
             * Called when the spinner's value changes.
             * @param e  a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float mincals = ((Number) mincalspinner.getValue()).floatValue();
                currentState.setMincals(mincals);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        savemaxcals.addActionListener(new ActionListener() {
            /**
             * Called when button to save max calories is pressed.
             * @param e  an ActionEvent object
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(savemaxcals)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();

                    updateRestrictionController.execute("maxCalories", currentState.getMaxcals());
                }
            }
        });
        savemincals.addActionListener(new ActionListener() {
            /**
             * Called when button to save min calories is pressed.
             * @param e  an ActionEvent object
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(savemincals)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();

                    updateRestrictionController.execute("minCalories", currentState.getMincals());
                }
            }
        });

        maxcarbspinner.addChangeListener(new ChangeListener() {
            /**
             * Called when the spinner's value changes.
             * @param e  a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float maxcarbs = ((Number) maxcarbspinner.getValue()).floatValue();
                currentState.setMaxcarbs(maxcarbs);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        mincarbspinner.addChangeListener(new ChangeListener() {
            /**
             * Called when the spinner's value changes.
             * @param e  a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float mincarbs = ((Number) mincarbspinner.getValue()).floatValue();
                currentState.setMincarbs(mincarbs);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        savemaxcarbs.addActionListener(new ActionListener() {
            /**
             * Called when button to save max carbs is pressed.
             * @param e  an ActionEvent object
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(savemaxcarbs)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();

                    updateRestrictionController.execute("maxCarbs", currentState.getMaxcarbs());
                }
            }
        });
        savemincarbs.addActionListener(new ActionListener() {
            /**
             * Called when button to save min carbs is pressed.
             * @param e  a ChangeEvent object
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(savemincarbs)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();

                    updateRestrictionController.execute("minCarbs", currentState.getMincarbs());
                }
            }
        });

        maxfatspinner.addChangeListener(new ChangeListener() {
            /**
             * Called when the spinner's value changes.
             * @param e  a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float maxfats = ((Number) maxfatspinner.getValue()).floatValue();
                currentState.setMaxfat(maxfats);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        minfatspinner.addChangeListener(new ChangeListener() {
            /**
             * Called when the spinner's value changes.
             * @param e  a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float minfat = ((Number) minfatspinner.getValue()).floatValue();
                currentState.setMinfat(minfat);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        savemaxfats.addActionListener(new ActionListener() {
            /**
             * Called when button to save max fats is pressed.
             * @param e  an ActionEvent object
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(savemaxfats)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    if (currentState.getMaxfat() == null) {
                        currentState.setMaxfat(0.0f);
                        maxfatspinner.setValue(0.0f);
                    } else {
                        updateRestrictionController.execute("maxSaturatedFat", currentState.getMaxfat());
                        maxfatspinner.setValue(0.0f);

                    }
                }
            }
        });
        saveminfats.addActionListener(new ActionListener() {
            /**
             * Called when button to save min fats is pressed.
             * @param e  an ActionEvent object
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(saveminfats)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    if (currentState.getMinfat() == null) {
                        currentState.setMinfat(0.0f);
                        minfatspinner.setValue(0.0f);
                    } else {
                        updateRestrictionController.execute("minSaturatedFat", currentState.getMaxfat());
                        minfatspinner.setValue(0.0f);
                    }
                }
            }
            });

        maxproteinspinner.addChangeListener(new ChangeListener() {
            /**
             * Called when the spinner's value changes.
             * @param e  a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float maxprotein = ((Number) maxproteinspinner.getValue()).floatValue();
                currentState.setMaxprotein(maxprotein);
                updateRestrictionsViewModel.setState(currentState);
            }
        });

        minproteinspinner.addChangeListener(new ChangeListener() {
            /**
             * Called when the spinner's value changes.
             * @param e  a ChangeEvent object
             */
            @Override
            public void stateChanged(ChangeEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                Float minprotein = ((Number) minproteinspinner.getValue()).floatValue();
                currentState.setMinprotein(minprotein);
                updateRestrictionsViewModel.setState(currentState);
            }
        });
        savemaxprotein.addActionListener(new ActionListener() {
            /**
             * Called when button to save max protein is pressed.
             * @param e  an ActionEvent object
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(savemaxprotein)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    if (currentState.getMinprotein() == null) {
                        currentState.setMinprotein(0.0f);
                        minproteinspinner.setValue(0.0f);
                    } else {
                        updateRestrictionController.execute("maxProtein", currentState.getMaxprotein());
                        maxproteinspinner.setValue(0.0f);
                    }
                }
            }
        });

        saveminprotein.addActionListener(new ActionListener() {
            /**
             * Called when button to save min protein is pressed.
             * @param e  an ActionEvent object
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(saveminprotein)) {
                    UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                    if (currentState.getMinprotein() == null) {
                        currentState.setMinprotein(0.0f);
                        minproteinspinner.setValue(0.0f);
                    } else {
                        updateRestrictionController.execute("minProtein", currentState.getMinprotein());
                        minproteinspinner.setValue(0.0f);
                    }
                }
            }
        });

        savefooditem.addActionListener(new ActionListener() {
            /**
             * Called when button to save food item is pressed.
             * @param e  an ActionEvent object
             */
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
            /**
             * Called when the spinner's value changes.
             * @param e  a ChangeEvent object
             */
            @Override
            public void keyTyped(KeyEvent e) {
                UpdateRestrictionsState currentState = updateRestrictionsViewModel.getCurrState();
                String text = FoodItemTextBox.getText() + e.getKeyChar();
                currentState.setRestriction(text);
                updateRestrictionsViewModel.setState(currentState);
            }

            /**
             * Called when a key is pressed.
             * @param e  a ChangeEvent object
             */
            @Override
            public void keyPressed(KeyEvent e) {

            }

            /**
             * Called when a key is released.
             * @param e  a ChangeEvent object
             */
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        /**
         * Called when button to go to main menu is pressed to send you back to the main menu.
         * @param e  an ActionEvent object
         */
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
            /**
             * Called when the keto diet checkbox is selected or deselected.
             * @param e  a ChangeEvent object
             */
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
                    Float False = UpdateRestrictionsViewModel.FALSE;
                    currentState.setKeto(False);
                    updateRestrictionController.execute("keto", currentState.getKeto());
                }
            }
        });

        enableVegan.addItemListener(new ItemListener() {
            /**
             * Called when the vegan diet checkbox is selected or deselected.
             * @param e  a ChangeEvent object
             */
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
                    Float False = UpdateRestrictionsViewModel.FALSE;
                    currentState.setVegan(False);
                    updateRestrictionController.execute("vegan", currentState.getVegan());
                }

            }
        });


        enableVegetarian.addItemListener(new ItemListener() {
            /**
             * Called when the vegetarian diet checkbox is selected or deselected.
             * @param e  a ChangeEvent object
             */
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
                    Float False = UpdateRestrictionsViewModel.FALSE;
                    currentState.setVegetarian(False);
                    updateRestrictionController.execute("vegetarian", currentState.getVegetarian());
                }
            }
        });
    }
    /**
     * Called when button is pressed.
     * @param e  an ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Not implemented");
    }
    /**
     * Called when button is pressed and the success popup.
     * @param evt  an ActionEvent object
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        UpdateRestrictionsState state = (UpdateRestrictionsState) evt.getNewValue();
        if (state.getError() != null) {
            JOptionPane.showMessageDialog(null, "Cannot put number in the Food Text Box ", "Error", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "Successfully Updated Restriction", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

