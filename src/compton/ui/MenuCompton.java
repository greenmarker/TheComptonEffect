package compton.ui;

import compton.animation.SinusoidComponent;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Timer;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;


public class MenuCompton extends JFrame {
	final ResourceBundle bundle = PropertyResourceBundle.getBundle("compton");

	public MenuCompton() {
		//Ramka Główna
		JFrame mainFrame = new JFrame(bundle.getString("app_title")); //Ramka Główna
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE); // zamykanie ramki
		mainFrame.setResizable(false);	//skalowanie ramki przez użytkownika
		mainFrame.setVisible(true); //wywołanie ramki
		mainFrame.setSize (800, 800); //rozmiar
		mainFrame.setLayout(new MigLayout());
		mainFrame.add(createMenu(),  "north");
		mainFrame.add(createAnimationPanel(), "center");
		mainFrame.add(createOptionsPanel(),"west,south");
		mainFrame.setVisible(true);
	}

	private OptionsPanel createOptionsPanel() {
		return new OptionsPanel();
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
		return animationPanel;
	}
}
