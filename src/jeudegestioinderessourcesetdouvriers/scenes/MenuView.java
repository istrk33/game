/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudegestioinderessourcesetdouvriers.scenes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Administrateur
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
