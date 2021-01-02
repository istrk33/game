/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudegestioinderessourcesetdouvriers.scenes;

import gameLogic.GameLogic;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author isoyturk
 */
public class JeuDeGestioinDeRessourcesEtDOuvriers extends Application {

    MenuView menu;
    GameViewController jeu;
    StatistiqueViewController statistiques;
    AideController aide;
    private Scene menuScene;
    private Scene jeuScene;
    private Scene statsScene;
    private Scene aideScene;
    Stage stats = new Stage();
    Stage aideStage = new Stage();
    Stage jeuStage = new Stage();
    Stage finJeuStage;
    Scene finJeuScene;
    EndGameViewController finJeuControl;

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
                primaryStage.close();
            } catch (IOException ex) {

            }
            jeu.fenetreDeStats(() -> {
                try {
                    chargerVueDeStats();
                } catch (IOException ex) {
                    Logger.getLogger(JeuDeGestioinDeRessourcesEtDOuvriers.class.getName()).log(Level.SEVERE, null, ex);
                }
                stats.show();
                stats.setResizable(false);
                stats.setTitle("Statistiques");
                stats.centerOnScreen();
                statistiques.afficherStats(jeu.getLogiqueDeJeu());
            });

            jeu.aideFenetre(() -> {
                try {
                    chargerVueAide();
                } catch (IOException ex) {
                    Logger.getLogger(JeuDeGestioinDeRessourcesEtDOuvriers.class.getName()).log(Level.SEVERE, null, ex);
                }

                aideStage.setTitle("Aide");
                aide.dessinerBatimentsDansLaMain(jeu.getLogiqueDeJeu());
                aideStage.show();
                aideStage.setResizable(false);
                aideStage.centerOnScreen();
            });

            jeu.choisirOuvrierPlateau(() -> {
                jeu.choisirOuvrierADeplacer();
            });

            //VUE JEU
            jeu.afficherScore();
            jeu.initialiserVueDeJeu();
            jeuStage.setTitle("Jeu de gestion de ressources et d'ouvriers");
            jeuStage.setScene(jeuScene);
            jeuStage.centerOnScreen();
            jeuStage.setResizable(false);
            jeuStage.show();

            jeu.quitterPartie(() -> {
                jeuStage.close();
                primaryStage.centerOnScreen();
                primaryStage.show();
            });

            jeu.finTour(() -> {

                if (jeu.getLogiqueDeJeu().getTourCourrant() + 1 == 31) {
                    try {
                        jeuStage.close();
                        chargerVueFinJeu();
                    } catch (IOException ex) {
                        Logger.getLogger(JeuDeGestioinDeRessourcesEtDOuvriers.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    finJeuStage.setTitle("Fin");
                    finJeuControl.afficherScore(jeu.getLogiqueDeJeu().getScorePartie());
                    finJeuStage.setResizable(false);
                    finJeuStage.show();
                }
                jeu.tourSuivant();
                jeu.setBatSelectioné(false);
                jeu.afficherTourCourrant();
            });

            jeu.placerIBatimentSurPlateau(() -> {
                if (!jeu.getSiSuppressionPermise()) {
                    jeu.placerBatiment("I-Batiment");
                } else if (jeu.getSiSuppressionPermise()) {
                    jeu.supprimerBatimentDePile("I-Batiment");
                }
            });
            jeu.placerJBatimentSurPlateau(() -> {
                if (!jeu.getSiSuppressionPermise()) {
                    jeu.placerBatiment("J-Batiment");
                } else if (jeu.getSiSuppressionPermise()) {
                    jeu.supprimerBatimentDePile("J-Batiment");
                }
            });
            jeu.placerLBatimentSurPlateau(() -> {
                if (!jeu.getSiSuppressionPermise()) {
                    jeu.placerBatiment("L-Batiment");
                } else if (jeu.getSiSuppressionPermise()) {
                    jeu.supprimerBatimentDePile("L-Batiment");
                }
            });
            jeu.placerOBatimentSurPlateau(() -> {
                if (!jeu.getSiSuppressionPermise()) {
                    jeu.placerBatiment("O-Batiment");
                } else if (jeu.getSiSuppressionPermise()) {
                    jeu.supprimerBatimentDePile("O-Batiment");
                }
            });
            jeu.placerSBatimentSurPlateau(() -> {
                if (!jeu.getSiSuppressionPermise()) {
                    jeu.placerBatiment("S-Batiment");
                } else if (jeu.getSiSuppressionPermise()) {
                    jeu.supprimerBatimentDePile("S-Batiment");
                }
            });
            jeu.placerTBatimentSurPlateau(() -> {
                if (!jeu.getSiSuppressionPermise()) {
                    jeu.placerBatiment("T-Batiment");
                } else if (jeu.getSiSuppressionPermise()) {
                    jeu.supprimerBatimentDePile("T-Batiment");
                }
            });
            jeu.placerZBatimentSurPlateau(() -> {
                if (!jeu.getSiSuppressionPermise()) {
                    jeu.placerBatiment("Z-Batiment");
                } else if (jeu.getSiSuppressionPermise()) {
                    jeu.supprimerBatimentDePile("Z-Batiment");
                }
            });

            jeu.placerOuvrierPlateau(() -> {
                jeu.placerOuvrier();
            });

            jeu.supprimerBatimentMain(() -> {
                jeu.passerModeSuppression();
            });

            jeuScene.setOnKeyPressed((javafx.scene.input.KeyEvent e) -> {
                switch (e.getCode()) {
                    case ENTER:
                        if (!jeu.recupererBatimentValide() && jeu.getBatSelectionné() && !jeu.getSiModeDeplacement()) {
                            jeu.validerBatiment();
                            jeu.setBatPosé();
                        } else if (jeu.getOuvriéPosé() && !jeu.getOuvrierValidé() && jeu.getPlacePourOuvrierVide() && !jeu.getSiModeDeplacement()) {
                            jeu.validerOuvrier();
                        } else if (jeu.getSiModeDeplacement()) {
                            jeu.supprimerOuvrier();
                        }
                        break;
                    case UP:
                        if (!jeu.recupererBatimentValide() && jeu.getBatSelectionné()) {
                            jeu.deplacerBatimentHaut();
                            jeu.majPlateau();
                        } else if (jeu.getOuvriéPosé() && !jeu.getOuvrierValidé() && jeu.getPlacePourOuvrierVide()) {
                            jeu.deplacerOuvrierHaut();
                        }
                        break;
                    case DOWN:
                        if (!jeu.recupererBatimentValide() && jeu.getBatSelectionné()) {
                            jeu.deplacerBatimentBas();
                            jeu.majPlateau();
                        } else if (jeu.getOuvriéPosé() && !jeu.getOuvrierValidé() && jeu.getPlacePourOuvrierVide()) {
                            jeu.deplacerOuvrierBas();

                        }
                        break;
                    case RIGHT:
                        if (!jeu.recupererBatimentValide() && jeu.getBatSelectionné()) {
                            jeu.deplacerBatimentDroite();
                            jeu.majPlateau();
                        } else if (jeu.getOuvriéPosé() && !jeu.getOuvrierValidé() && jeu.getPlacePourOuvrierVide()) {
                            jeu.deplacerOuvrierDroite();

                        }
                        break;
                    case LEFT:
                        if (!jeu.recupererBatimentValide() && jeu.getBatSelectionné()) {
                            jeu.deplacerBatimentGauche();
                            jeu.majPlateau();
                        } else if (jeu.getOuvriéPosé() && !jeu.getOuvrierValidé() && jeu.getPlacePourOuvrierVide()) {
                            jeu.deplacerOuvrierGauche();

                        }
                        break;
                    case T:
                        if (!jeu.recupererBatimentValide() && jeu.getBatSelectionné()) {
                            jeu.pivoterBatiment();
                            jeu.majPlateau();
                        }
                        break;
                }

            });

            jeu.sauvegarderPartie(() -> {
              /*  try {
                    jeu.sauvegarderPartie();
                    jeu.indiquerPartieSauvé();
                } catch (IOException ex) {
                    Logger.getLogger(JeuDeGestioinDeRessourcesEtDOuvriers.class.getName()).log(Level.SEVERE, null, ex);
                }*/
            });
        });

        menu.chargerPartie(() -> {
          /*  try {
                FileInputStream fis = new FileInputStream("savePartie.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);
                GameLogic e = (GameLogic) ois.readObject();
                ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }*/
        });
        primaryStage.setScene(menuScene);
        primaryStage.setTitle("Menu");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * charger vue de menu
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
     * charger vue de jeu
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

    /**
     * charger vue de stats
     *
     * @throws IOException
     */
    private void chargerVueDeStats() throws IOException {
        URL location = getClass().getResource("StatistiqueView.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        statsScene = new Scene(loader.load());
        statistiques = loader.getController();
        stats.setScene(statsScene);
    }

    /**
     * charger vue aide
     *
     * @throws IOException
     */
    public void chargerVueAide() throws IOException {
        URL location = getClass().getResource("Aide.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        aideScene = new Scene(loader.load());
        aide = loader.getController();
        aideStage.setScene(aideScene);
    }

    /**
     * charger vue de fin de jeu
     *
     * @throws IOException
     */
    private void chargerVueFinJeu() throws IOException {
        URL location = getClass().getResource("EndGameView.fxml");
        FXMLLoader loader = new FXMLLoader(location);
        finJeuScene = new Scene(loader.load());
        finJeuControl = loader.getController();
        finJeuStage = new Stage();
        finJeuStage.setScene(finJeuScene);
    }

}
