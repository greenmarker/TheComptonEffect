package compton.gui.miglayout;

import static compton.utils.Utils.*;
import static compton.AppConstants.*;

import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.util.Hashtable;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import compton.AppConstants;
import compton.utils.Physics;
import net.miginfocom.swing.MigLayout;

public class OptionsPanel extends JPanel {

	final ResourceBundle bundle = PropertyResourceBundle.getBundle("compton");

	JPanel optionPanel = new JPanel(new MigLayout());

	JLabel optionTitle = new JLabel(bundle.getString("menu_sample"));

	JLabel fotonEnergyBefore = new JLabel(bundle.getString("parameter_energy_before_dissipation"));
	JTextField fotonEnergyBeforeField = new JTextField(FPS_INIT + ""); // bundle.getString("parameter_energy")
	JSlider fotonEnergyBeforeSlider = new JSlider(FPS_MIN, FPS_MAX, FPS_INIT);
	Hashtable<Integer, JLabel> labelSlider = new Hashtable<Integer, JLabel>();

	Hashtable<Integer, JLabel> anglelabelSlider = new Hashtable<Integer, JLabel>();
	JLabel angleBefore = new JLabel(bundle.getString("parameter_angle"));
	JTextField angleBeforeField = new JTextField(FPS_INIT1 + "");
	JSlider angleBeforeSlider = new JSlider(FPS_MIN1, FPS_MAX1, FPS_INIT1);

	JLabel fotonEnergyAfter = new JLabel(bundle.getString("parameter_energy_after_dissipation"));
	JTextField fotonEnergyAfterField = new JTextField(); // bundle.getString("parameter_energy")

	JLabel sourceExample = new JLabel(bundle.getString("sample_sources"));

	JRadioButton sourceCez = new JRadioButton(bundle.getString("caesium"));
	JRadioButton sourceJod = new JRadioButton(bundle.getString("iodine"));
	//JRadioButton sourceUran = new JRadioButton(bundle.getString("uranium"));

	public OptionsPanel() {
		optionPanel.add(optionTitle, "wrap");

		// newline
		optionPanel.add(fotonEnergyBefore);
		optionPanel.add(fotonEnergyBeforeField, "");
		fotonEnergyBeforeField.setPreferredSize(new Dimension(150, 24));
		fotonEnergyBeforeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
            	fotonEnergyBeforeSlider.setValue(Integer.parseInt(fotonEnergyBeforeField.getText()));
                updateEnergyAfter();
            }
		});

		optionPanel.add(fotonEnergyBeforeSlider, "span 4,wrap");

		labelSlider.put(new Integer(1), new JLabel("1 keV"));
		labelSlider.put(new Integer(FPS_MAX), new JLabel("1000 keV"));

		fotonEnergyBeforeSlider.setLabelTable(labelSlider);
		fotonEnergyBeforeSlider.setPaintLabels(true);
		fotonEnergyBeforeSlider.setValue(AppConstants.DEFAULT_ENERGY_BEFORE);
		fotonEnergyBeforeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				fotonEnergyBeforeField.setText(fotonEnergyBeforeSlider.getValue() + "");
				updateEnergyAfter();
			}
		});

		// newline
		optionPanel.add(angleBefore);
		optionPanel.add(angleBeforeField);
		angleBeforeField.setPreferredSize(new Dimension(150, 24));
		angleBeforeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
            	angleBeforeSlider.setValue(Integer.parseInt(angleBeforeField.getText()));
                updateEnergyAfter();
            }
		});

		optionPanel.add(angleBeforeSlider, "wrap");
		anglelabelSlider.put(new Integer(0), new JLabel("0"));
		anglelabelSlider.put(new Integer(FPS_MAX1), new JLabel("180"));
		angleBeforeSlider.setLabelTable(anglelabelSlider);
		angleBeforeSlider.setPaintLabels(true);
		angleBeforeSlider.setValue(AppConstants.DEFAULT_ANGLE);
		angleBeforeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				angleBeforeField.setText(angleBeforeSlider.getValue() + "");
				updateEnergyAfter();
			}
		});

		optionPanel.add(fotonEnergyAfter);
		optionPanel.add(fotonEnergyAfterField, "wrap");
		fotonEnergyAfterField.setPreferredSize(new Dimension(150, 24));

		// sample sources
		optionPanel.add(sourceExample, "wrap");
		optionPanel.add(sourceCez, "wrap");
		optionPanel.add(sourceJod);
		add(optionPanel);
		
		ItemListener radioItemListener = new ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
            	updateEnergyAfter();
            }
		};
		
		sourceCez.addItemListener(radioItemListener);
		sourceJod.addItemListener(radioItemListener);
		//sourceUran.addItemListener(radioItemListener);
		
		updateEnergyAfter();
	}
	
    private double getSourceEnergy(){
        if (sourceCez.isSelected()){
            return 662;
        } else if (sourceJod.isSelected()){
            return 364;
        } //else if (sourceUran.isSelected()){
        //    return 57.7;
        //}
        return 0;
    }

	private void updateEnergyAfter() {
		double sourceEnergy = getSourceEnergy();
		if (sourceEnergy >0) {
            double energyBefore = parseDouble(fotonEnergyBeforeField.getText());
            double angle = parseDouble(angleBeforeField.getText());
            double energyAfter = Physics.getEnergyAfter(energyBefore, sourceEnergy, angle);
            fotonEnergyAfterField.setText(energyAfter + " [keV]");
		}
	}

	public double getAngle() {
		return parseDouble(angleBeforeField.getText());
	}
}