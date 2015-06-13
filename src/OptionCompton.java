import java.awt.Dimension;
import java.util.Hashtable;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class OptionCompton extends JPanel {

	final ResourceBundle bundle = PropertyResourceBundle.getBundle("compton");

	 static final int FPS_MIN = 1; //minimalna wartość
	 static final int FPS_MAX = 1000;
	 static final int FPS_INIT = 500;
	
	 static final int FPS_MIN1 = 0; //minimalna wartość
	 static final int FPS_MAX1 = 180;
	 static final int FPS_INIT1 = 90;
	 
	 JPanel optionPanel = new JPanel(new MigLayout());
	 
	JLabel optionTitle = new JLabel(bundle.getString("menu_sample"));
	
	JLabel fotonEnergyBefore = new JLabel(bundle.getString("parameter_energy_before_dissipation"));
	JTextField fotonEnergyBeforeField = new JTextField(bundle.getString("parameter_energy"));
	JSlider fotonEnergyBeforeSlider = new JSlider(FPS_MIN, FPS_MAX, FPS_INIT);
	Hashtable<Integer, JLabel> labelSlider = new Hashtable<Integer, JLabel>();
	
	Hashtable<Integer, JLabel> anglelabelSlider = new Hashtable<Integer, JLabel>();
	JLabel anglebBefore = new JLabel(bundle.getString("parameter_angle"));
	JTextField angleBeforeField = new JTextField();
	JSlider angleBeforeSlider = new JSlider(FPS_MIN1, FPS_MAX1, FPS_INIT1);
	
	JLabel fotonEnergyAfter = new JLabel(bundle.getString("parameter_energy_after_dissipation"));
	JTextField fotonEnergyAfterFields = new JTextField(bundle.getString("parameter_energy"));
	
	JLabel sourceExample = new JLabel(bundle.getString("sample_sources"));
	
	JRadioButton sourceCez = new JRadioButton(bundle.getString("caesium"));
	JRadioButton sourceJod = new JRadioButton(bundle.getString("iodine"));

	public OptionCompton()
	{
		optionPanel.add(optionTitle,"wrap");
        
        //newline
        optionPanel.add(fotonEnergyBefore);
        optionPanel.add(fotonEnergyBeforeField,"");
        fotonEnergyBeforeField.setPreferredSize( new Dimension( 150, 24 ) );
        
        optionPanel.add(fotonEnergyBeforeSlider,"span 4,wrap");
        
        labelSlider.put(new Integer(1), new JLabel("1 keV"));
        labelSlider.put(new Integer(FPS_MAX), new JLabel("1000 keV"));
        
        fotonEnergyBeforeSlider.setLabelTable(labelSlider);
        fotonEnergyBeforeSlider.setPaintLabels (true);
        
        //newline
        optionPanel.add(anglebBefore);
        optionPanel.add(angleBeforeField);
        angleBeforeField.setPreferredSize( new Dimension( 150, 24 ) );
        
        optionPanel.add(angleBeforeSlider,"wrap");
        anglelabelSlider.put(new Integer(0), new JLabel("0"));
        anglelabelSlider.put(new Integer(FPS_MAX1), new JLabel("180"));
        angleBeforeSlider.setLabelTable(anglelabelSlider);
        angleBeforeSlider.setPaintLabels (true);
        
        optionPanel.add(fotonEnergyAfter);
        optionPanel.add(fotonEnergyAfterFields,"wrap");
        fotonEnergyAfterFields.setPreferredSize( new Dimension( 150, 24 ) );
        
        // sample sources
        optionPanel.add(sourceExample,"wrap");
        optionPanel.add(sourceCez,"wrap");
        optionPanel.add(sourceJod);
        add(optionPanel);
	}
}