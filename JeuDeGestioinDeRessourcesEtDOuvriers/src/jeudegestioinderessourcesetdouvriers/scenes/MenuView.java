/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudegestioinderessourcesetdouvriers.scenes;


import javafx.fxml.FXML;
import javafx.scene.control.Button;


/**
 *
 * @author isoyturk
 */
public class MenuView {

    @FXML
    private Button nouvellePartieBouton;

    @FXML
    private Button chargerPartieBouton;

    @FXML
    private Button quitterBouton;

    public void quitterMenu(Runnable quitter) {
        quitterBouton.setOnAction(event -> quitter.run());
    }

    public void chargerPartie(Runnable chargerPartie) {
        chargerPartieBouton.setOnAction(event -> chargerPartie.run());
    }

    public void creerNouvellePartie(Runnable nouvellePartie) {
        nouvellePartieBouton.setOnAction(event -> nouvellePartie.run());
    }

}
