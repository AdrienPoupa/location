package location.views.components.panel;

import com.avaje.ebeaninternal.server.lib.util.Str;
import location.containers.Vehicules;
import location.models.*;
import location.views.components.misc.CustomFontLabel;

import javax.swing.*;
import java.awt.*;

/**
 * Panneau de choix d'un véhicule
 * @author Timothée Barbot
 * @author Stéphane Gâteau
 */
public class ChooseVehiculePanel extends BoxPanel {

    private TwoRadioPanel typeVehicule;

    private FlowPanel modelPanel;

    private JPanel dateDepartPanel;

    private JPanel dateRetourPanel;

    private JCheckBox assurancePanel;

    private CorrespondingVehiculesPanel correspondingVehiculesPanel;

    private JComboBox vehiculesComboBox;

    private JButton searchBtn;

    private Vehicule vehiculeChoisi;

    private String modeleCylindree;

    private Location location;

    /**
     * Constructeur par défaut
     */
    public ChooseVehiculePanel(){
        super();
        initChooseVehiculePanel();
    }

    /**
     * Constructeur avec couleur
     * @param bgColor couleur
     * @param l location
     */
    public ChooseVehiculePanel(Color bgColor, Location l){
        super();
        this.location = l;
        setBackground(bgColor);
        initChooseVehiculePanel();
    }

    /**
     * Initialisation de la fenêtre
     */
    private void initChooseVehiculePanel(){
        // Panel choix type de vehicule
        typeVehicule = new TwoRadioPanel(Color.ORANGE, "Type de location", "Auto", "Moto");
        typeVehicule.getBtn1().addActionListener(e->{
            vehiculesComboBox.removeAllItems();
            for(Vehicule v: Vehicules.get()){
                if(v instanceof Auto){
                    vehiculesComboBox.addItem(v.getDisplayName());
                }
            }
        });
        typeVehicule.getBtn2().addActionListener(e->{
            vehiculesComboBox.removeAllItems();
            for(Vehicule v: Vehicules.get()){
                if(v instanceof Moto){
                    vehiculesComboBox.addItem(v.getDisplayName());
                }
            }
        });

        // Panel selection du vehicule
        modelPanel = new FlowPanel(Color.ORANGE);
        JLabel constructeurModel = new CustomFontLabel("Choix du véhicule","Arial", 0,12);
        modelPanel.add(constructeurModel);


        vehiculesComboBox = new JComboBox();
        for(Vehicule v: Vehicules.get()){
            if(v instanceof Auto)
                vehiculesComboBox.addItem(v.getDisplayName());
        }

        modelPanel.add(vehiculesComboBox);

        // Panel date
        dateDepartPanel = new DatePanel(Color.ORANGE, "Date de départ", location != null ? location.getDebut().asUtilDate() : Date.now().asUtilDate());
        dateRetourPanel = new DatePanel(Color.ORANGE, "Date de retour", location != null ? location.getFin().asUtilDate() : Date.now().asUtilDate());

        // assurance
        assurancePanel = new JCheckBox("Assurance");
        assurancePanel.setAlignmentX(CENTER_ALIGNMENT);
        assurancePanel.setBackground(Color.ORANGE);

        // search btn
        searchBtn = new JButton("Rechercher disponibilité");
        searchBtn.addActionListener(e -> {
            //correspondingVehiculesPanel.
        });

        // table showing exemplaire corresponding to search
        correspondingVehiculesPanel = new CorrespondingVehiculesPanel(location);

        vehiculesComboBox.addActionListener(e->{
            if (vehiculesComboBox.getSelectedItem() != null) {
                String value = vehiculesComboBox.getSelectedItem().toString();

                // Récupération du véhicule choisi
                for(Vehicule v: Vehicules.get()){
                    if(value != null && value.equals(v.getDisplayName())) {
                        vehiculeChoisi = v;
                    }
                }

                if (vehiculeChoisi instanceof Auto) {
                    modeleCylindree = ((Auto) vehiculeChoisi).getModele();
                }
                else {
                    modeleCylindree = Integer.toString(((Moto) vehiculeChoisi).getCylindree());
                }

                correspondingVehiculesPanel.setSearchParam(vehiculeChoisi/*, dateDepartPanel, dateRetourPanel*/);
            }

        });
        JPanel typeModelPanel = new BoxPanel();
        typeModelPanel.setBackground(Color.ORANGE);
        typeModelPanel.add(typeVehicule);
        typeModelPanel.add(modelPanel);

        JPanel datePanel = new JPanel(new FlowLayout());
        datePanel.setBackground(Color.ORANGE);
        datePanel.add(dateDepartPanel);
        datePanel.add(dateRetourPanel);

        add(typeModelPanel);
        add(datePanel);
        add(assurancePanel);
        add(correspondingVehiculesPanel);
    }

    public TwoRadioPanel getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TwoRadioPanel typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public JPanel getDateDepartPanel() {
        return dateDepartPanel;
    }

    public void setDateDepartPanel(JPanel dateDepartPanel) {
        this.dateDepartPanel = dateDepartPanel;
    }

    public JPanel getDateRetourPanel() {
        return dateRetourPanel;
    }

    public void setDateRetourPanel(JPanel dateRetourPanel) {
        this.dateRetourPanel = dateRetourPanel;
    }

    public JCheckBox getAssurancePanel() {
        return assurancePanel;
    }

    public void setAssurancePanel(JCheckBox assurancePanel) {
        this.assurancePanel = assurancePanel;
    }

    public JComboBox getVehiculesComboBox() {
        return vehiculesComboBox;
    }

    public void setVehiculesComboBox(JComboBox vehiculesComboBox) {
        this.vehiculesComboBox = vehiculesComboBox;
    }
}
