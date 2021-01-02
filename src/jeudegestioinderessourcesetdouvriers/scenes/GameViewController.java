/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudegestioinderessourcesetdouvriers.scenes;

import PlateauDeJeu.Cellule;
import PlateauDeJeu.Plateau;
import buildings.data.Batiment;
import buildings.data.IBatiment;
import buildings.data.JBatiment;
import buildings.data.LBatiment;
import buildings.data.OBatiment;
import buildings.data.Case;
import buildings.data.SBatiment;
import buildings.data.TBatiment;
import buildings.data.ZBatiment;
import gameLogic.GameLogic;
//import java.awt.event.KeyEvent;
import javafx.scene.input.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.GraphicsContext;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * FXML Controller class
 *
 * @author Administrateur
 */
public class GameViewController {

    @FXML
    private Canvas dessinerPlateau;
    @FXML
    private Button quitterPartieBouton;
    @FXML
    private Button finDeTourBouton;
    @FXML
    private Button sauvegarderPartieBouton;
    @FXML
    private Label afficherNbMateriel;
    @FXML
    private Label afficherNbEnergie;
    @FXML
    private Label afficherNbOuvrier;
    @FXML
    private Label afficherNbTour;
    @FXML
    private Label afficherScoreJeu;
    @FXML
    private Canvas afficherBatiment;
    @FXML
    private Label nbIBatiments;
    @FXML
    private Label nbOBatiments;
    @FXML
    private Label nbTBatiments;
    @FXML
    private Label nbLBatiments;
    @FXML
    private Label ntJBatiments;
    @FXML
    private Label nbSBatiments;
    @FXML
    private Label nbZBatiments;
    @FXML
    private Button iBatimentBouton;
    @FXML
    private Button oBatimentBouton;
    @FXML
    private Button tBatimentBouton;
    @FXML
    private Button lBatimentBouton;
    @FXML
    private Button jBatimentBouton;
    @FXML
    private Button sBatimentBouton;
    @FXML
    private Button zBatimentBouton;

    private final Plateau p = new Plateau();
    private boolean batCharge = false;
    private Integer nbIBlock = 0, nbOBlock = 0, nbTBlock = 0, nbLBlock = 0, nbJBlock = 0, nbSBlock = 0, nbZBlock = 0;
    private final GameLogic logiqueDeJeu = new GameLogic();
    private Batiment batimentBEnDessin;
    private boolean batimentEnDessinValide = false;
    private boolean batimentPoséDansLeTour = false;
    private int largeurDuBatiment = 0;
    private int hauteurDuBatiment = 0;

    public void placerIBatimentSurPlateau(Runnable iBlock) {
        iBatimentBouton.setOnAction(event -> iBlock.run());
    }

    public void placerOBatimentSurPlateau(Runnable oBlock) {
        oBatimentBouton.setOnAction(event -> oBlock.run());
    }

    public void placerTBatimentSurPlateau(Runnable tBlock) {
        tBatimentBouton.setOnAction(event -> tBlock.run());
    }

    public void placerLBatimentSurPlateau(Runnable lBlock) {
        lBatimentBouton.setOnAction(event -> lBlock.run());
    }

    public void placerJBatimentSurPlateau(Runnable jBlock) {
        jBatimentBouton.setOnAction(event -> jBlock.run());
    }

    public void placerSBatimentSurPlateau(Runnable sBlock) {
        sBatimentBouton.setOnAction(event -> sBlock.run());
    }

    public void placerZBatimentSurPlateau(Runnable zBlock) {
        zBatimentBouton.setOnAction(event -> zBlock.run());
    }

    public void finTour(Runnable finTour) {
        finDeTourBouton.setOnAction(event -> finTour.run());
    }

    public void quitterPartie(Runnable quitter) {
        quitterPartieBouton.setOnAction(event -> quitter.run());
    }

    public void sauvegarderPartie(Runnable sauverPartie) {
        sauvegarderPartieBouton.setOnAction(event -> sauverPartie.run());
    }

    public void afficherNombreDeBatimentDansLaMain() {
        this.nbIBatiments.setText("    x" + nbIBlock.toString());
        this.nbOBatiments.setText("    x" + nbOBlock.toString());
        this.nbTBatiments.setText("    x" + nbTBlock.toString());
        this.nbLBatiments.setText("    x" + nbLBlock.toString());
        this.ntJBatiments.setText("    x" + nbJBlock.toString());
        this.nbSBatiments.setText("    x" + nbSBlock.toString());
        this.nbZBatiments.setText("    x" + nbZBlock.toString());
    }

    public void compterBatimentDeLaMain() {
        nbIBlock = 0;
        nbOBlock = 0;
        nbTBlock = 0;
        nbLBlock = 0;
        nbJBlock = 0;
        nbSBlock = 0;
        nbZBlock = 0;
        for (Batiment b : logiqueDeJeu.recupererBatimentSDuDeck()) {
            switch (b.getNomBatiment()) {
                case "I-Batiment":
                    nbIBlock++;
                    break;
                case "J-Batiment":
                    nbJBlock++;
                    break;
                case "L-Batiment":
                    nbLBlock++;
                    break;
                case "O-Batiment":
                    nbOBlock++;
                    break;
                case "S-Batiment":
                    nbSBlock++;
                    break;
                case "T-Batiment":
                    nbTBlock++;
                    break;
                case "Z-Batiment":
                    nbZBlock++;
                    break;
            }
        }
        afficherNombreDeBatimentDansLaMain();
    }

    public void majPlateau() {
        p.dessinerPlateau(dessinerPlateau);
    }

    public void dessinerBatimentsDansLaMain(Canvas deckJoueur) {
        int posX = 15;
        int posY = 15;

        for (Batiment b : logiqueDeJeu.batimentsSansDoublons()) {
            switch (b.getNomBatiment()) {
                case "I-Batiment":
                    IBatiment i = (IBatiment) b;
                    i.dessinerBatiment(deckJoueur, posX, posY);
                    posY += 40;
                    break;
                case "J-Batiment":
                    JBatiment j = (JBatiment) b;
                    j.dessinerBatiment(deckJoueur, posX + 20, posY);
                    posY += 80;
                    break;
                case "L-Batiment":
                    LBatiment l = (LBatiment) b;
                    l.dessinerBatiment(deckJoueur, posX + 20, posY);
                    posY += 80;
                    break;
                case "O-Batiment":
                    OBatiment o = (OBatiment) b;
                    o.dessinerBatiment(deckJoueur, posX + 20, posY);
                    posY += 60;
                    break;
                case "S-Batiment":
                    SBatiment s = (SBatiment) b;
                    s.dessinerBatiment(deckJoueur, posX + 15, posY);
                    posY += 60;
                    break;
                case "T-Batiment":
                    TBatiment t = (TBatiment) b;
                    t.dessinerBatiment(deckJoueur, posX + 15, posY);
                    posY += 60;
                    break;
                case "Z-Batiment":
                    ZBatiment z = (ZBatiment) b;
                    z.dessinerBatiment(deckJoueur, posX + 15, posY);
                    posY += 60;
                    break;
            }
        }
    }

    public boolean verifierSiBatimentDansLaPile(String nomBatiment) {
        boolean estPresent = false;
        int nbBatiment = 0;
        for (Batiment b : logiqueDeJeu.recupererBatimentSDuDeck()) {
            if (b.getNomBatiment().equals(nomBatiment)) {
                nbBatiment++;
            }
        }
        if (nbBatiment > 0) {
            estPresent = true;
        }
        return estPresent;
    }

    public void afficherScore() {
        Integer scoreGame = logiqueDeJeu.recupererScore();
        String score = scoreGame.toString();
        afficherScoreJeu.setText(score);
    }

    public void afficherTourCourrant() {
        Integer tourCourant = logiqueDeJeu.recupererTourCourrant();
        String tourCourantToString = tourCourant.toString();
        afficherNbTour.setText(tourCourantToString);
    }

    public void tourSuivant() {
        logiqueDeJeu.tourSuivant();
        batimentEnDessinValide = false;
        batimentPoséDansLeTour = false;
    }

    public void recupNbBatimentsDeLaMain() {
        if (!batCharge) {
            logiqueDeJeu.ajouterToutLesBatiments();
            logiqueDeJeu.ajouterBatimentAleatDansLeDeck();
            batCharge = true;
        }
        for (Batiment b : logiqueDeJeu.recupererBatimentSDuDeck()) {
            switch (b.getNomBatiment()) {
                case "I-Batiment":
                    nbIBlock++;
                    break;
                case "O-Batiment":
                    nbOBlock++;
                    break;
                case "T-Batiment":
                    nbTBlock++;
                    break;
                case "L-Batiment":
                    nbLBlock++;
                    break;
                case "J-Batiment":
                    nbJBlock++;
                    break;
                case "S-Batiment":
                    nbSBlock++;
                    break;
                case "Z-Batiment":
                    nbZBlock++;
                    break;
            }
            afficherNombreDeBatimentDansLaMain();
        }
    }

    public void initialiserVueDeJeu(Stage primaryStage) {
        GraphicsContext deck = afficherBatiment.getGraphicsContext2D();
        deck.setFill(Color.POWDERBLUE);
        deck.fillRect(0, 0, 10 * 20, 20 * 23);
        p.dessinerPlateau(dessinerPlateau);
        recupNbBatimentsDeLaMain();
        dessinerBatimentsDansLaMain(afficherBatiment);
        afficherTourCourrant();
    }

    public void ajouterBatimentDansListePlateau(String nomBatiment) {
        logiqueDeJeu.ajouterBatimentPlateau(nomBatiment);
    }

    public void validerBatiment() {
        if (p.validerBatiment() && !batimentEnDessinValide) {
            batimentEnDessinValide = true;
            System.out.println("Batiment posé valide");
        } else {
            System.out.println("Validation impossible car collision");
        }
    }

    public boolean recupererBatimentValide() {
        return batimentEnDessinValide;
    }

    public boolean recupererBatimentPose() {
        return batimentPoséDansLeTour;
    }

    public void placerTableauBatimentDansTableauPlateau(String nomBatiment) {
        for (Batiment b : logiqueDeJeu.batimentsSansDoublons()) {
            if (nomBatiment.equals(b.getNomBatiment())) {
                batimentBEnDessin = b;
                for (Case c : batimentBEnDessin.recupCases()) {
                    System.out.println(c.getX() + " " + c.getY());
                }
                p.placerBatimentDansTableauDePlateau(batimentBEnDessin, batimentBEnDessin.recupCases());
            }
        }
        batimentPoséDansLeTour = true;
    }

    public void deplacerBatimentDroite() {
        batimentBEnDessin.deplacerADroite();
        p.placerBatimentDansTableauDePlateau(batimentBEnDessin, batimentBEnDessin.recupCases());
    }

    public void deplacerBatimentGauche() {
        batimentBEnDessin.deplacerAGauche();
        p.placerBatimentDansTableauDePlateau(batimentBEnDessin, batimentBEnDessin.recupCases());
    }

    public void deplacerBatimentBas() {
        batimentBEnDessin.deplacerEnBas();
        p.placerBatimentDansTableauDePlateau(batimentBEnDessin, batimentBEnDessin.recupCases());
    }

    public void deplacerBatimentHaut() {
        batimentBEnDessin.deplacerEnHaut();
        p.placerBatimentDansTableauDePlateau(batimentBEnDessin, batimentBEnDessin.recupCases());
    }
    
    public void pivoterBatiment(){
        /*
        pivoter le batiment en fonction de la reference et 
        utiliser un enum (pour les directions)
        */
    }

    public void setBatPosé() {
        batimentPoséDansLeTour = false;
    }
}
