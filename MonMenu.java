import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class MenuListener implements ActionListener { 
		@Override
    	public void actionPerformed(ActionEvent e){ 
    		
        	String str = e.getActionCommand();

	       	if(str == "Accueil"){
	        	Ecran.cl.show(Ecran.content, "ACCUEIL");
	        }

	        if(str == "Mes meubles"){
	        	Ecran.cl.show(Ecran.content, "MEUBLE");
	        }

	        if(str == "Mes cartons"){
	            Ecran.cl.show(Ecran.content, "CARTON");
	        }
	    }
	}

class MonMenu extends JPanel {
 		JButton bAccueil = new JButton("Accueil");
        JButton bMeuble = new JButton("Mes meubles");
        JButton bCarton = new JButton("Mes cartons");
        GridBagConstraints gc = new GridBagConstraints();

        MonMenu(){
        	bAccueil.addActionListener(new MenuListener());
        	bCarton.addActionListener(new MenuListener());
        	bMeuble.addActionListener(new MenuListener());
        	setLayout(new GridBagLayout());
        	gc.insets = new Insets(0, 0, 0, 0);
			gc.weightx = 3;
			gc.fill = GridBagConstraints.BOTH;
			gc.anchor = GridBagConstraints.PAGE_END;
	        gc.gridx = 0;
	        gc.gridy = 4;
	        add(bAccueil, gc);
	        gc.gridx = 1;
	        gc.gridy = 4;
	        add(bMeuble, gc);
	        gc.gridx = 2;
	        gc.gridy = 4;
	        add(bCarton, gc);
        }
}