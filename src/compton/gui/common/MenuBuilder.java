package compton.gui.common;

import javax.swing.*;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by Dominik Boryczka on 2015-06-12.
 */
public class MenuBuilder {

    final ResourceBundle bundle = PropertyResourceBundle.getBundle("compton");
    
    JMenu file = new JMenu(bundle.getString("menu_file"));
    JMenu comptonEffect = new JMenu(bundle.getString("menu_compton"));
    JMenu language = new JMenu(bundle.getString("menu_language"));
    
    JMenuItem option = new JMenuItem(bundle.getString("menu_options"));
    JMenuItem exit = new JMenuItem(bundle.getString("menu_exit"));
    JMenuItem effect = new JMenuItem(bundle.getString("menu_effect"));
    JMenuItem polish = new JMenuItem(bundle.getString("language_polish"));
    JMenuItem english = new JMenuItem(bundle.getString("language_english"));

    public JMenuBar build(){
        JMenuBar mainMenu = new JMenuBar();

        //Od File
        mainMenu.add(file);
        file.add(option);
        file.add(exit);

        //Od Zjawiska Comptona
        mainMenu.add(comptonEffect);
        comptonEffect.add(effect);

        //Od Języka
        mainMenu.add(language);
        language.add(polish);
        language.add(english);

        return mainMenu;
    }
}
