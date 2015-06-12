import javax.swing.*;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by Kamil on 2015-06-12.
 */
public class MenuBuilder {

    final ResourceBundle bundle = PropertyResourceBundle.getBundle("compton");

    public JMenuBar build(){
        JMenuBar mainMenu = new JMenuBar();

        //Od File
        JMenu file = new JMenu(bundle.getString("menu_file"));
        JMenu comptonEffect = new JMenu("Zjawisko Comptona");
        JMenu language = new JMenu("Jêzyk");

        JMenuItem option = new JMenuItem("Opcje");
        JMenuItem exit = new JMenuItem("Wyjœcie");
        JMenuItem effect = new JMenuItem("Opis Zjawiska");
        JMenuItem polish = new JMenuItem("Polski");
        JMenuItem english = new JMenuItem("Angielski");

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

        return mainMenu;
    }
}
