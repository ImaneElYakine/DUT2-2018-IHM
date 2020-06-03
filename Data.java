import javax.swing.*;
import java.awt.*;
import java.util.*;

 class Meuble {
	String nom;
	String description;
	//Carton c;
	String volume;
	boolean demontable;
	String volumeBis;
	int pieces;

	Meuble(String nom){
		this.nom = nom;
	}

	public String toString() {
   		return this.nom;
	}
}

class Carton {

	String nom;
	String piece;
	String type;
	String description;

	Carton(String nom){
		this.nom = nom;
	}

	public String toString() {
   		return nom;
	}


}

class Data {
	public static DefaultListModel<Meuble> listeMeuble = new DefaultListModel<Meuble>();
	public static DefaultListModel<Carton> listeCarton = new DefaultListModel<Carton>();
}