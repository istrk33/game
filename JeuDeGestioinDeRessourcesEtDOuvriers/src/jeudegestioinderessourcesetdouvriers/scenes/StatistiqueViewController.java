/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudegestioinderessourcesetdouvriers.scenes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author isoyturk
 */
public class StatistiqueViewController {

    @FXML
    private Label afficherTour;
    @FXML
    private Label afficherScore;
    @FXML
    private Label afficherEnergie;
    @FXML
    private Label afficherMatériaux;
    @FXML
    private Label afficherBatSurPlateau;
    @FXML
    private Label afficherNbOuvrierSurPlateau;
    @FXML
    private Label afficherNbOuvrierExtPlat;
    @FXML
    private Label nbBatPile;

    /**
     * afficher les stats
     * @param logique 
     */
    public void afficherStats(gameLogic.GameLogic logique) {
        afficherTour.setText("" + logique.getTourCourrant());
        afficherScore.setText("" + logique.getScorePartie());
        afficherEnergie.setText("" + logique.getEnergie());
        afficherMatériaux.setText("" + logique.getMateriaux());
        afficherBatSurPlateau.setText("" + logique.getBatimentSurPlateau());
        afficherNbOuvrierSurPlateau.setText("" + logique.getNbOuvriersPlateau());
        afficherNbOuvrierExtPlat.setText("" + logique.getNbOuvriersExterieur());
        nbBatPile.setText(""+logique.getNbBatPile());
    }
}
