package views.components.tab;

import models.Emprunteur;
import views.components.misc.TableauRecherche;
import views.components.misc.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;


public class Emprunteurs extends JPanel {
    public Emprunteurs() {
        super();
        setBackground(Color.orange);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initContent();
    }

    private void initContent() {
        // rajout du titre
        JLabel reservationLabel = new Label("Liste des emprunteurs","Calibri", Font.PLAIN, 25);
        reservationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(reservationLabel);

        // Bouton rajout Ajouter un emprunteur
        JButton ajouter = new JButton("Ajouter un emprunteur");
        ajouter.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(ajouter);

        // Données tableau
        String[] entetes = {"Numéro", "Nom", "Prénom", "Adresse", "Actions"};

        Object[][] donnees = new Object[containers.Emprunteurs.get().size()][5];

        int count = 0;
        for (Emprunteur e : containers.Emprunteurs.get()) {
            donnees[count][0] = e.getId();
            donnees[count][1] = e.getNom();
            donnees[count][2] = e.getPrenom();
            donnees[count][3] = e.getAdresse().toString();
            donnees[count][4] = "Bouton";

            count++;
        }

        add(new TableauRecherche(donnees, entetes));
    }
}
