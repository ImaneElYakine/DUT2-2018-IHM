import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class AjoutCarton extends JPanel {
	
    GridBagConstraints gc = new GridBagConstraints();
	JLabel titre = new JLabel("Ajouter un carton");
	JTextField nom = new JTextField("", 10);
	JTextField description = new JTextField("", 10);
	String[] typeCarton = {"Petit", "Moyens", "Barrel", "Penderie", "Tableaux"};
	String[] pieces = {"Salon", "Chambre 1", "Chambre 2", "Cuisine", "Salle de bain"};
	JComboBox type = new JComboBox(typeCarton);
	JComboBox choixpiece = new JComboBox(pieces);
	JButton annuler = new JButton("Annuler");
	JButton ajouter = new JButton("Ajouter un carton");

	class AjoutCartonListener implements ActionListener {
		@Override
    	public void actionPerformed(ActionEvent e) {
			if(nom.getText().equals("") || description.getText().equals("")){
    			JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs");
    		} else {
				Data.listeCarton.addElement(new Carton(nom.getText()));
				nom.setText("");
            	Ecran.cl.show(Ecran.content, "ACCUEIL");
            }
        }
    }

    class AnnulerCartonListener implements ActionListener {
		@Override
    	public void actionPerformed(ActionEvent e) {
			nom.setText("");
			description.setText("");
        	Ecran.cl.show(Ecran.content, "ACCUEIL");
    	}
	}
   			 
	AjoutCarton(){
		annuler.setBackground(new Color(159,0,0));
	 	annuler.setForeground(Color.WHITE);
	 	ajouter.setBackground(new Color(45,148,38));
	 	ajouter.setForeground(Color.WHITE);
	 	titre.setFont(new Font("SansSerif", Font.BOLD, 18));
        setBackground(Color.WHITE);
		annuler.addActionListener(new AnnulerCartonListener());
		ajouter.addActionListener(new AjoutCartonListener()); 
		setLayout(new GridBagLayout());
        gc.insets = new Insets(0, 0, 0, 0);
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 2;
		gc.weighty = 6;
		// Titre
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 0;
		add(titre, gc);
		// Nom
		gc.gridwidth = 1;
		gc.gridx = 0;
		gc.gridy = 1;
		add(new JLabel("Nom: "), gc);
		gc.gridx = 1;
		add(nom, gc);
		// Description
		gc.gridx = 0;
		gc.gridy = 2;
		add(new JLabel("Description: "), gc);
		gc.gridx = 1;
		add(description, gc);
		// Type
		gc.gridx = 0;
		gc.gridy = 3;
		add(new JLabel("Type de carton: "), gc);
		gc.gridx = 1;
		add(type, gc);
		// Choisir une pièce
		gc.gridx = 0;
		gc.gridy = 5;
		add(new JLabel("Choisir une piece: "), gc);
		gc.gridx = 1;
		add(choixpiece, gc);
		// Ajouter Annuler
		gc.gridx = 0;
		gc.gridy = 6;
		add(annuler, gc);
		gc.gridx = 1;
		add(ajouter, gc);
	}	
}