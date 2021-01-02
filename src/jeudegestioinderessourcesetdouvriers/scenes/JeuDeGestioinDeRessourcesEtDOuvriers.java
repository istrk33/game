/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudegestioinderessourcesetdouvriers.scenes;

import gameLogic.GameLogic;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author isoyturk
 */
public class JeuDeGestioinDeRessourcesEtDOuvriers extends Application {

    MenuView menu;
    GameViewController jeu;
    private Scene menuScene;
    private Scene jeuScene;

    /**
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        chargerVueMenu();
        //VUE MENU
        menu.quitterMenu(() -> Platform.exit());
        menu.creerNouvellePartie(() -> {
            try {
                chargerVueJeu();
            } catch (IOException ex) {

            }
            //VUE JEU
            jeu.afficherScore();
            jeu.initialiserVueDeJeu(primaryStage);
            primaryStage.setScene(jeuScene);
            primaryStage.setTitle("Jeu de gestion de ressources et d'ouvriers");
            primaryStage.show();

            jeu.quitterPartie(() -> {
                primaryStage.setScene(menuScene);
                primaryStage.setTitle("Menu");
                primaryStage.show();
            });

            jeu.finTour(() -> {
                jeu.tourSuivant();
                jeu.afficherTourCourrant();
            });

            jeu.placerIBatimentSurPlateau(() -> {
                if (jeu.verifierSiBatimentDansLaPile("I-Batiment") && !jeu.recupererBatimentValide() && !jeu.recupererBatimentPose()) {
                    jeu.placerTableauBatimentDansTableauPlateau("I-Batiment");
                    jeu.majPlateau();
                } else if (jeu.verifierSiBatimentDansLaPile("I-Batiment") && !jeu.recupererBatimentValide() && jeu.recupererBatimentPose()) {
                    jeu.setBatPosé();
                    jeu.placerTableauBatimentDansTableauPlateau("I-Batiment");
                    jeu.majPlateau();
                }
            });
            jeu.placerJBatimentSurPlateau(() -> {
                if (jeu.verifierSiBatimentDansLaPile("J-Batiment") && !jeu.recupererBatimentValide() && !jeu.recupererBatimentPose()) {
                    jeu.placerTableauBatimentDansTableauPlateau("J-Batiment");
                    jeu.majPlateau();
                } else if (jeu.verifierSiBatimentDansLaPile("J-Batiment") && !jeu.recupererBatimentValide() && jeu.recupererBatimentPose()) {
                    jeu.setBatPosé();
                    jeu.placerTableauBatimentDansTableauPlateau("J-Batiment");
                    jeu.majPlateau();
                }
            });
            jeu.placerLBatimentSurPlateau(() -> {
                if (jeu.verifierSiBatimentDansLaPile("L-Batiment") && !jeu.recupererBatimentValide() && !jeu.recupererBatimentPose()) {
                    jeu.placerTableauBatimentDansTableauPlateau("L-Batiment");
                    jeu.majPlateau();
                } else if (jeu.verifierSiBatimentDansLaPile("L-Batiment") && !jeu.recupererBatimentValide() && jeu.recupererBatimentPose()) {
                    jeu.setBatPosé();
                    jeu.placerTableauBatimentDansTableauPlateau("L-Batiment");
                    jeu.majPlateau();
                }
            });
            jeu.placerOBatimentSurPlateau(() -> {
                if (jeu.verifierSiBatimentDansLaPile("O-Batiment") && !jeu.recupererBatimentValide() && !jeu.recupererBatimentPose()) {
                    jeu.placerTableauBatimentDansTableauPlateau("O-Batiment");
                    jeu.majPlateau();
                } else if (jeu.verifierSiBatimentDansLaPile("O-Batiment") && !jeu.recupererBatimentValide() && jeu.recupererBatimentPose()) {
                    jeu.setBatPosé();
                    jeu.placerTableauBatimentDansTableauPlateau("O-Batiment");
                    jeu.majPlateau();
                }
            });
            jeu.placerSBatimentSurPlateau(() -> {
                if (jeu.verifierSiBatimentDansLaPile("S-Batiment") && !jeu.recupererBatimentValide() && !jeu.recupererBatimentPose()) {
                    jeu.placerTableauBatimentDansTableauPlateau("S-Batiment");
                    jeu.majPlateau();
                } else if (jeu.verifierSiBatimentDansLaPile("S-Batiment") && !jeu.recupererBatimentValide() && jeu.recupererBatimentPose()) {
                    jeu.setBatPosé();
                    jeu.placerTableauBatimentDansTableauPlateau("S-Batiment");
                    jeu.majPlateau();
                }
            });
            jeu.placerTBatimentSurPlateau(() -> {
                if (jeu.verifierSiBatimentDansLaPile("T-Batiment") && !jeu.recupererBatimentValide() && !jeu.recupererBatimentPose()) {
                    jeu.placerTableauBatimentDansTableauPlateau("T-Batiment");
                    jeu.majPlateau();
                } else if (jeu.verifierSiBatimentDansLaPile("T-Batiment") && !jeu.recupererBatimentValide() && jeu.recupererBatimentPose()) {
                    jeu.setBatPosé();
                    jeu.placerTableauBatimentDansTableauPlateau("T-Batiment");
                    jeu.majPlateau();
                }
            });
            jeu.placerZBatimentSurPlateau(() -> {
                if (jeu.verifierSiBatimentDansLaPile("Z-Batiment") && !jeu.recupererBatimentValide() && !jeu.recupererBatimentPose()) {
                    jeu.placerTableauBatimentDansTableauPlateau("Z-Batiment");
                    jeu.majPlateau();
                } else if (jeu.verifierSiBatimentDansLaPile("Z-Batiment") && !jeu.recupererBatimentValide() && jeu.recupererBatimentPose()) {
                    jeu.setBatPosé();
                    jeu.placerTableauBatimentDansTableauPlateau("Z-Batiment");
                    jeu.majPlateau();
                }
            });

            jeuScene.setOnKeyPressed(e -> {
                if(jeu.recupererBatimentPose()){
                switch (e.getCode()) {
                    case ENTER:
                        jeu.validerBatiment();
                        jeu.setBatPosé();
                        break;
                    case UP:
                        if (!jeu.recupererBatimentValide()) {
                            jeu.deplacerBatimentHaut();
                            jeu.majPlateau();
                        }
                        break;
                    case DOWN:
                        if (!jeu.recupererBatimentValide()) {
                            jeu.deplacerBatimentBas();
                            jeu.majPlateau();
                        }
                        break;
                    case RIGHT:
                        if (!jeu.recupererBatimentValide()) {
                            jeu.deplacerBatimentDroite();
                            jeu.majPlateau();
                        }
                        break;
                    case LEFT:
                        if (!jeu.recupererBatimentValide()) {
                            jeu.deplacerBatimentGauche();
                            jeu.majPlateau();
                        }
                        break;
                    case T:
                        // on tourne le batiment a 90 degres
                        break;
                }
                }

            });

            jeu.sauvegarderPartie(() -> {
            });
        });

        menu.chargerPartie(() -> {
        });
        primaryStage.setScene(menuScene);
        primaryStage.setTitle("Menu");
        primaryStage.show();
    }

    /**
     *
     * @throws IOException
     */
    private void chargerVueMenu() throws IOException {
        URL location = getClass().getResource("MenuView.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        menuScene = new Scene(loader.load());
        menu = loader.getController();
    }

    /**
     *
     * @throws IOException
     */
    private void chargerVueJeu() throws IOException {
        URL location = getClass().getResource("GameView.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        jeuScene = new Scene(loader.load());
        jeu = loader.getController();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
