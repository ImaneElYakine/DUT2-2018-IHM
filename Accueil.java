import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class AccueilListener implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e){

        String str = e.getActionCommand();

        if(str == "Nouveau meuble"){
            Ecran.cl.show(Ecran.content, "AJOUTMEUBLE");
        }

        if(str == "Nouveau carton"){
            Ecran.cl.show(Ecran.content, "AJOUTCARTON");
        }
    }
}


public class Accueil extends JPanel {

	GridBagConstraints gc = new GridBagConstraints();
	// Composants du panel
    JLabel bienvenue = new JLabel("BIENVENUE", JLabel.CENTER);
    JLabel text = new JLabel("Perferens quidem si statuas id addensque.", JLabel.CENTER);
    MonMenu m = new MonMenu();
    JButton addMeuble = new JButton("Nouveau meuble");
    JButton addCarton = new JButton("Nouveau carton");

    Accueil(){
        setBackground(Color.WHITE);
        addMeuble.addActionListener(new AccueilListener());
        addCarton.addActionListener(new AccueilListener());

    	setLayout(new GridBagLayout());
    	gc.weightx = 3;
    	gc.weighty = 3;
    	gc.insets = new Insets(0, 0, 0, 0);
    	gc.ipady = gc.anchor = GridBagConstraints.CENTER;
    	// Bienvenue
    	gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 3;
        gc.anchor = GridBagConstraints.SOUTH;
        add(bienvenue, gc);
        // Texte
        gc.anchor = GridBagConstraints.SOUTH;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 3;
        add(text, gc);
        // Ajout meuble 
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.SOUTH;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.gridwidth = 3;
        add(addMeuble, gc);
        gc.insets = new Insets(20, 20, 20, 20);
		// Ajout carton 
		gc.anchor = GridBagConstraints.NORTH;
        gc.gridx = 0;
        gc.gridy = 3;
        gc.gridwidth = 3;
        add(addCarton, gc);
        gc.insets = new Insets(0, 0, 0, 0);
        // Menu
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.PAGE_END;
        gc.gridy = 4;
       	add(m, gc);
    }
}

