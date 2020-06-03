import javax.swing.*;
import java.awt.*;
import java.util.*; 
import java.awt.event.*;

 class Ecran extends JFrame {
	public static CardLayout cl = new CardLayout();
	public static JPanel content = new JPanel();
	Accueil p1 = new Accueil();
	MesCartons p3 = new MesCartons();
	MesMeubles p2 = new MesMeubles();
	public static AjoutMeuble p4 = new AjoutMeuble();
	public static AjoutCarton p5 = new AjoutCarton();

	Ecran(){
		content.setLayout(cl);
		content.add(p1, "ACCUEIL");
    	content.add(p2, "MEUBLE");
    	content.add(p3, "CARTON");
    	content.add(p4, "AJOUTMEUBLE");
    	content.add(p5, "AJOUTCARTON");
        cl.show(content, "ACCUEIL");
		setTitle("Application");
		setSize(320,480);
		add(content);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

public class Application {

	public static void main(String[] args){
			Data.listeCarton.addElement(new Carton("Carton fragile"));
            Data.listeCarton.addElement(new Carton("Carton de jouets"));
			Ecran f = new Ecran();
		}
}