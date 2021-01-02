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
public class EndGameViewController {

    @FXML
    private Label afficherScore;

    /**
     * afficher le score dans une petite fenetre quand la partie est finie
     * @param Score 
     */
    public void afficherScore(int Score){
        afficherScore.setText(""+Score);
    }
    
}
