package views;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * Created by Adrien on 01/04/2016.
 */
public class TableauRecherche extends Tableau {

    public TableauRecherche(JPanel fenetre, Object[][] donnees, String[] entetes){
        super(fenetre, donnees, entetes);
    }

    public JPanel generer(){

        JPanel searchPanel = Panel.nvPanelFlow(Color.orange);

        JLabel nomLabel = Label.nvLabel("Recherche : ");
        JTextField nomTexte = Texte.nvTextField("", 10);

        nomTexte.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = nomTexte.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
                tableau.repaint();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = nomTexte.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                //not needed: throw new UnsupportedOperationException("Not supported yet.");
            }
        });

        searchPanel.add(nomLabel);
        searchPanel.add(nomTexte);
        fenetre.add(searchPanel);

        // Appel fonction parente pour créer le tableau
        fenetre = super.generer();

        return fenetre;
    }
}
