//package view;
//import interface_adapter.update_restrictions.UpdateRestrictionsViewModel;
//import entities.User;
//
//import javax.swing.*;
//import java.awt.*;
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class UpdateRestrictionsView extends JPanel implements ActionListener, PropertyChangeListener {
//    public final String viewName = "update restriction";
//    public final UpdateRestrictionsViewModel updateRestrictionsViewModel;
//    private final JSpinner maxcalspinner;
//    private final JSpinner mincalspinner;
//    private final JSpinner maxcarbspinner;
//    private final JSpinner mincarbspinner;
//    private final JSpinner maxfatspinner;
//    private final JSpinner minfatspinner;
//    private final JSpinner maxproteinspinner;
//    private final JSpinner minproteinspinner;
//    public User user;
//
//    public UpdateRestrictionsView(UpdateRestrictionsViewModel updateRestrictionsViewModel) {
//        this.updateRestrictionsViewModel = updateRestrictionsViewModel;
//        // Initialize user field
//        updateRestrictionsViewModel.addPropertyChangeListener(this);
//
//        // Create SpinnerNumberModel for each spinner with default values
//        int defaultMaxCalValue = 100;
//        int defaultMinCalValue = 0;
//        int defaultMaxCarbValue = 100;
//        int defaultMinCarbValue = 0;
//        int defaultMaxFatValue = 100;
//        int defaultMinFatValue = 0;
//        int defaultMaxProteinValue = 100;
//        int defaultMinProteinValue = 0;
//
//        SpinnerNumberModel maxcalModel = new SpinnerNumberModel(defaultMaxCalValue, 0, 100, 1);
//        SpinnerNumberModel mincalModel = new SpinnerNumberModel(defaultMinCalValue, 0, 100, 1);
//        SpinnerNumberModel maxcarbModel = new SpinnerNumberModel(defaultMaxCarbValue, 0, 100, 1);
//        SpinnerNumberModel mincarbModel = new SpinnerNumberModel(defaultMinCarbValue, 0, 100, 1);
//        SpinnerNumberModel maxfatModel = new SpinnerNumberModel(defaultMaxFatValue, 0, 100, 1);
//        SpinnerNumberModel minfatModel = new SpinnerNumberModel(defaultMinFatValue, 0, 100, 1);
//        SpinnerNumberModel maxproteinModel = new SpinnerNumberModel(defaultMaxProteinValue, 0, 100, 1);
//        SpinnerNumberModel minproteinModel = new SpinnerNumberModel(defaultMinProteinValue, 0, 100, 1);
//
//        // Initialize each spinner
//        maxcalspinner = new JSpinner(maxcalModel);
//        mincalspinner = new JSpinner(mincalModel);
//        maxcarbspinner = new JSpinner(maxcarbModel);
//        mincarbspinner = new JSpinner(mincarbModel);
//        maxfatspinner = new JSpinner(maxfatModel);
//        minfatspinner = new JSpinner(minfatModel);
//        maxproteinspinner = new JSpinner(maxproteinModel);
//        minproteinspinner = new JSpinner(minproteinModel);
//
//        // Setting spinner values to already saved restriction value
//        setSpinnerValue(maxcalspinner, user, "maxcal");
//        setSpinnerValue(mincalspinner, user, "mincal");
//        setSpinnerValue(maxcarbspinner, user, "maxcarb");
//        setSpinnerValue(mincarbspinner, user, "mincarb");
//        setSpinnerValue(maxfatspinner, user, "maxfat");
//        setSpinnerValue(minfatspinner, user, "minfat");
//        setSpinnerValue(maxproteinspinner, user, "maxprotein");
//        setSpinnerValue(minproteinspinner, user, "minprotein");
//
//        // Add the spinners to the panel
//        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MAXCals));
//        add(maxcalspinner);
//        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MINCals));
//        add(mincalspinner);
//
//        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MAXCARBS));
//        add(maxcarbspinner);
//        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MINCARBS));
//        add(mincarbspinner);
//
//        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MAXFATS));
//        add(maxfatspinner);
//        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MINFATS));
//        add(minfatspinner);
//
//        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MAXPROTEIN));
//        add(maxproteinspinner);
//        add(new JLabel(UpdateRestrictionsViewModel.UPDATE_MINPROTEIN));
//        add(minproteinspinner);
//
//        // Add a listener to handle changes in the spinners' values
//        maxcalspinner.addChangeListener(e -> handleSpinnerChange());
//        mincalspinner.addChangeListener(e -> handleSpinnerChange());
//        maxcarbspinner.addChangeListener(e -> handleSpinnerChange());
//        mincarbspinner.addChangeListener(e -> handleSpinnerChange());
//        maxfatspinner.addChangeListener(e -> handleSpinnerChange());
//        minfatspinner.addChangeListener(e -> handleSpinnerChange());
//        maxproteinspinner.addChangeListener(e -> handleSpinnerChange());
//        minproteinspinner.addChangeListener(e -> handleSpinnerChange());
//    }
//
//    private void setSpinnerValue(JSpinner spinner, User user, String restriction) {
//        try {
//            Integer restrictionValue = Math.round(user.getRestriction(restriction));
//            // Check if "min" or "max" is present in the restriction name
//            if (restrictionValue != null) {
//                spinner.setValue(restrictionValue);
//            }
//        } catch (Exception e) {
//            spinner.setValue(0); // default to 0 if there is an exception (for example there isnt a user right now)
//        }
//    }
//
//    private void handleSpinnerChange() {
//        // Handle the spinner value change here
//        // You can access the values using maxcalspinner.getValue(), mincalspinner.getValue(), etc.
//    }
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // Handle other actions if needed
//    }
//
//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        // Handle property changes if needed
//    }
//}
//
