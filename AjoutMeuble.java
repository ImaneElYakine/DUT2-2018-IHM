import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

class AjoutMeuble extends JPanel {

    GridBagConstraints gc = new GridBagConstraints();
	JLabel titre = new JLabel("Ajouter un meuble");
	String[] v = {"0-20", "20-40","40-60", "60-100","+100"};
	JTextField nom = new JTextField("", 10);
	JTextField description = new JTextField("", 10);
	JComboBox volume = new JComboBox(v);
	JComboBox choixcarton = new JComboBox();
	JCheckBox demontable = new JCheckBox("Demontable");
	JButton annuler = new JButton("Annuler");
	JButton ajouter = new JButton("Ajouter un meuble");
	Icon camera = new ImageIcon("camera.png");
	JButton photo = new JButton("Ajouter une photo", camera);
	JLabel image = new JLabel( new ImageIcon("meuble.png"));
	JTextField nb = new JTextField("", 5);
	JComboBox volumeBis = new JComboBox(v);
	JLabel textenb = new JLabel("Nombre de pieces: ");
	JLabel textebis = new JLabel("Volume demonte: ");

	class AjouterMeubleListener implements ActionListener {
		@Override
    	public void actionPerformed(ActionEvent e) {
    		if(nom.getText().equals("") || description.getText().equals("")){
    			JOptionPane.showMessageDialog(null,"Veuillez remplir tous les champs");
    		} else {
				Data.listeMeuble.addElement(new Meuble(nom.getText()));
				nom.setText("");
            	Ecran.cl.show(Ecran.content, "ACCUEIL");
            }
        }
    }


	class PhotoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e){
            gc.gridx = 1;
            gc.gridy = 1;
            add(image, gc);
            revalidate();
            repaint();
        }
    }

    class AnnulerMeubleListener implements ActionListener {
		@Override
    	public void actionPerformed(ActionEvent e) {
			nom.setText("");
			description.setText("");
			remove(image);
			gc.gridx = 1;
            gc.gridy = 1;
			add(new JLabel(""),gc);
			revalidate();
            repaint();
        	Ecran.cl.show(Ecran.content, "ACCUEIL");
    	}
	}

	class DemontableListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int state = e.getStateChange();
			if(state == e.SELECTED){
				gc.gridx = 0;
				gc.gridy = 7;
				add(textenb, gc);
				gc.gridx = 1;
				add(nb, gc);
				gc.gridx = 0;
				gc.gridy = 8;
				add(textebis, gc);
				gc.gridx = 1;
				add(volumeBis, gc);
			} else {
				remove(textebis);
				remove(textenb);
				remove(volumeBis);
				remove(nb);
		}
			revalidate();
			repaint();
	}
}
   	
	 AjoutMeuble(){
	 	for(int i=0; i< Data.listeCarton.size(); i++){
	 		choixcarton.addItem(Data.listeCarton.get(i).nom);
		}

	 	setLayout(new GridBagLayout());
	 	annuler.setBackground(new Color(159,0,0));
	 	annuler.setForeground(Color.WHITE);
	 	ajouter.setBackground(new Color(45,148,38));
	 	ajouter.setForeground(Color.WHITE);
	 	setBackground(Color.WHITE);
	 	titre.setFont(new Font("SansSerif", Font.BOLD, 18));
		photo.addActionListener(new PhotoListener());
		annuler.addActionListener(new AnnulerMeubleListener());
		ajouter.addActionListener(new AjouterMeubleListener());
		demontable.addItemListener(new DemontableListener());
        gc.insets = new Insets(0, 0, 0, 0);
        gc.ipady = gc.anchor = GridBagConstraints.CENTER;
		gc.weightx = 2;
		gc.weighty = 10;
		// Titre
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 0;
		add(titre, gc);
		// Photo
		gc.gridwidth = 1;
		gc.gridy = 1;
		add(photo, gc);
		// Nom
		gc.gridx = 0;
		gc.gridy = 2;
		add(new JLabel("Nom: "), gc);
		gc.gridx = 1;
		add(nom, gc);
		// Description
		gc.gridx = 0;
		gc.gridy = 3;
		add(new JLabel("Description: "), gc);
		gc.gridx = 1;
		add(description, gc);
		// Volume
		gc.gridx = 0;
		gc.gridy = 4;
		add(new JLabel("Volume (cm3): "), gc);
		gc.gridx = 1;
		add(volume, gc);
		// Choisir un carton
		gc.gridx = 0;
		gc.gridy = 5;
		add(new JLabel("Choisir un carton: "), gc);
		gc.gridx = 1;
		add(choixcarton, gc);
		// Demontable
		gc.gridx = 0;
		gc.gridy = 6;
		add(demontable, gc);
		// Ajouter Annuler
		gc.gridx = 0;
		gc.gridy = 9;
		add(annuler, gc);
		gc.gridx = 1;
		add(ajouter, gc);
	}
}