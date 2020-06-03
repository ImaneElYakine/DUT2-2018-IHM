import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class MesCartons extends JPanel {

        GridBagConstraints gc = new GridBagConstraints();
        // Composants du panel
        JLabel titreCarton = new JLabel("Mes cartons");
        MonMenu m = new MonMenu();
        JList list = new JList(Data.listeCarton);
        JButton delete = new JButton("Supprimer");

        class SupprimerCartonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Data.listeCarton.removeElement(list.getSelectedValue());
                }
            }

        MesCartons(){
            titreCarton.setFont(new Font("SansSerif", Font.BOLD, 18));
            delete.setForeground(Color.WHITE);
            delete.setBackground(new Color(159,0,0));
            setBackground(Color.WHITE);
            delete.addActionListener(new SupprimerCartonListener());
            setLayout(new GridBagLayout());
            gc.insets = new Insets(0, 0, 0, 0);
            gc.ipady = gc.anchor = GridBagConstraints.CENTER;
            gc.weightx = 3;
            gc.weighty = 5;
            // Mes meubles
            gc.fill = GridBagConstraints.HORIZONTAL;
            gc.gridx = 0;
            gc.gridy = 0;
            gc.gridwidth = 3;
            add(titreCarton, gc);
            // Liste de meubles
            gc.fill = GridBagConstraints.BOTH;
            gc.gridx = 0;
            gc.gridy = 1;
            gc.gridheight = 2;
            gc.gridwidth = 3;
            add(list, gc);
            // Bouton supprimer
            gc.fill = GridBagConstraints.NONE;
            gc.gridx = 2;
            gc.gridy = 3;
            gc.gridwidth = 1;
            gc.anchor = GridBagConstraints.FIRST_LINE_END;
            add(delete, gc);
            gc.fill = GridBagConstraints.HORIZONTAL;
            gc.anchor = GridBagConstraints.PAGE_END;
            gc.gridy = 4;
           	add(m, gc);
    }
}
