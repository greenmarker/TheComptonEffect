

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Timer;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;


public class
		MenuCompton extends JFrame
{
	final ResourceBundle bundle = PropertyResourceBundle.getBundle("compton");
	
	//Tworzenie obiektu
	JFrame mainFrame = new JFrame(bundle.getString("app_title")); //Ramka G³ówna
	
	JPanel menuPanel = new JPanel(new MigLayout());
	JPanel animationPanel = new JPanel(new MigLayout());
	//Animation
	SinusiodComponent sinusoid = new SinusiodComponent();
	
	OptionCompton optionPanel = new OptionCompton();
	

	public MenuCompton()//Konstruktor domyœlny
	{
		//Ramka G³ówna
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE); // zamykanie ramki
		mainFrame.setResizable(false);	//skalowanie ramki przez u¿ytkownika
		mainFrame.setVisible(true); //wywo³anie ramki
		mainFrame.setSize (800, 800); //rozmiar
		mainFrame.setLayout(new MigLayout());
		mainFrame.add(menuPanel,  "north");
		mainFrame.add(animationPanel, "center");
		mainFrame.add(optionPanel,"west,south");
		
		
		//Pasek
		
		//Panel
		menuPanel.add(new MenuBuilder().build());
		
		//Sinusioda
		
		final SinusiodComponent.Sinusoider t = new SinusiodComponent.Sinusoider(sinusoid);
		final SinusiodComponent.Repainter r = new SinusiodComponent.Repainter(sinusoid);

        final Timer tickTimer = new Timer();
        final Timer paintTimer = new Timer();

        paintTimer.schedule(r, 1000, 50);
        tickTimer.schedule(t, 1000, 10);
        
        animationPanel.add(sinusoid);
	}
	
	
	
	
	
	public static void main(String[] args)
	{	
		//Ramka G³ówna
		MenuCompton frame1 = new MenuCompton();
		
		
	}
	
}
