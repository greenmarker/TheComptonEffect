package compton.gui.miglayout;

import compton.gui.GuiReferenceHolder;
import compton.gui.IParamsSource;
import compton.gui.common.animation.SinusoidComponent;

import java.awt.*;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.swing.*;

import compton.gui.common.MenuBuilder;
import net.miginfocom.swing.MigLayout;


public class MenuCompton extends JFrame implements IParamsSource {
	final static ResourceBundle bundle = PropertyResourceBundle.getBundle("compton");

	OptionsPanel optionsPanel = new OptionsPanel(); // we'll need reference, because we need to return Angle from it

	//Ramka Główna
	public MenuCompton() {
		super(bundle.getString("app_title")); //Ramka Główna
		GuiReferenceHolder.gui = this;
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // zamykanie ramki
		setResizable(false);	//skalowanie ramki przez użytkownika
		setVisible(true); //wywołanie ramki
		setSize (800, 800); //rozmiar
		setLayout(new MigLayout());
		add(createMenu(),  "north");
		add(createAnimationPanel(), "center");
		add(optionsPanel,"west,south");
		setVisible(true);
	}

	private JPanel createMenu(){
		JPanel menuPanel = new JPanel(new MigLayout());
		menuPanel.add(new MenuBuilder().build());
		return menuPanel;
	}

	private JPanel createAnimationPanel(){
		SinusoidComponent sinusoid = new SinusoidComponent();
		JPanel animationPanel = new JPanel(new MigLayout());
		animationPanel.add(sinusoid);

		Dimension size = new Dimension(768, 494);//(szerokość(width),wysokość(height))
		animationPanel.setPreferredSize(size);
		animationPanel.setMinimumSize(size);
		animationPanel.setMaximumSize(size);
		sinusoid.setPreferredSize(size);
		sinusoid.setMinimumSize(size);
		sinusoid.setMaximumSize(size);

		return animationPanel;
	}

	@Override
	public double getAngle() {
		return optionsPanel.getAngle();
	}
}
