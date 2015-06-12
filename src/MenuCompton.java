

import java.util.Timer;

import javax.swing.*;
import net.miginfocom.swing.MigLayout;


public class MenuCompton extends JFrame
{
	
	//Tworzenie obiektu
	JFrame mainFrame = new JFrame("ComptonEffect"); //Ramka G³ówna
	
	JMenuBar mainMenu = new JMenuBar();
	
	JMenu file = new JMenu("Plik");
	JMenu comptonEffect = new JMenu("Zjawisko Comptona");
	JMenu language = new JMenu("Jêzyk");
	
	JMenuItem option = new JMenuItem("Opcje");
	JMenuItem exit = new JMenuItem("Wyjœcie");
	JMenuItem effect = new JMenuItem("Opis Zjawiska");
	JMenuItem polish = new JMenuItem("Polski");
	JMenuItem english = new JMenuItem("Angielski");
	
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
		
		//Od File
		mainMenu.add(file);
		file.add(option);
		file.add(exit);
		
		//Od Zjawiska Comptona
		mainMenu.add(comptonEffect);
		comptonEffect.add(effect);
		
		//Od Jêzyka
		mainMenu.add(language);
		language.add(polish);
		language.add(english);
		
		//Panel
		menuPanel.add(mainMenu);
		
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
