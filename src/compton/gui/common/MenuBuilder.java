package compton.gui.common;

import compton.gui.GuiReferenceHolder;
import compton.gui.netbeans.MenuCompton2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by Dominik Boryczka on 2015-06-12.
 */
public class MenuBuilder {

    ResourceBundle bundle = PropertyResourceBundle.getBundle("compton");
    
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

        exit.addActionListener(new Exit());

        //Od Zjawiska Comptona
        mainMenu.add(comptonEffect);
        comptonEffect.add(effect);

        //Od Języka
        mainMenu.add(language);
        language.add(polish);
        language.add(english);

        polish.addActionListener(new LanguageChanger(Locale.forLanguageTag("pl")));
        english.addActionListener(new LanguageChanger(Locale.ENGLISH));

        return mainMenu;
    }

    private void changeLanguage(){
        bundle = PropertyResourceBundle.getBundle("compton");
        file.setText(bundle.getString("menu_file"));
        comptonEffect.setText(bundle.getString("menu_compton"));
        language.setText(bundle.getString("menu_language"));

        option.setText(bundle.getString("menu_options"));
        exit.setText(bundle.getString("menu_exit"));
        effect.setText(bundle.getString("menu_effect"));

        polish.setText(bundle.getString("language_polish"));
        english.setText(bundle.getString("language_english"));
    }

    private class LanguageChanger implements ActionListener {
        Locale locale;
        public LanguageChanger(Locale locale){
            this.locale = locale;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Locale.setDefault(locale);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    GuiReferenceHolder.gui.changeLanguage();
                    changeLanguage();
                }
            });
        }
    }

    private class Exit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            ((JFrame)GuiReferenceHolder.gui).dispose();
            System.exit(0);
        }
    }
}
