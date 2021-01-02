/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudegestioinderessourcesetdouvriers.scenes;

import Ouvrier.PositionOuvrier;
import Ouvrier.Ouvrier;
import PlateauDeJeu.Plateau;
import buildings.data.Batiment;
import buildings.data.Case;
import buildings.data.IBatiment;
import buildings.data.JBatiment;
import buildings.data.LBatiment;
import buildings.data.OBatiment;
import buildings.data.SBatiment;
import buildings.data.TBatiment;
import buildings.data.ZBatiment;
import gameLogic.GameLogic;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author isoyturk
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
    @FXML
    private Button boutonOuvrier;
    @FXML
    private Label labelNbOuvrier;
    @FXML
    private Canvas dessinerOuvrier;
    @FXML
    private Label indication;
    @FXML
    private Button ouvrirStats;
    @FXML
    private Button aideBouton;
    @FXML
    private Button choisirOuvrier;
    @FXML
    private Button zblockAction;

    private GameLogic logiqueDeJeu = new GameLogic();
    private final Plateau p = new Plateau();
    private boolean batCharge = false;
    private Integer nbIBlock = 0, nbOBlock = 0, nbTBlock = 0, nbLBlock = 0, nbJBlock = 0, nbSBlock = 0, nbZBlock = 0;
    private Batiment batimentBEnDessin;
    private Ouvrier ouvrierAPlacer;
    private Ouvrier ouvrierADeplacer;
    private boolean batimentEnDessinValide = false;
    private boolean batimentPoséDansLeTour = false;
    private boolean batSelectionne = false;
    private boolean ouvrierPosé = false;
    private boolean batimentAvecEmplacementVidePresent = false;
    private boolean ouvrierValidé = false;
    private boolean tourPair = false;
    private boolean modifierPlaceOuvrier = false;
    private int nbOuvrierSurLBatiment = 0;
    private int ouvrierAchoisirDansListe = 0;
    private boolean supprimerBatimentMain = false;
    private boolean passerModeSuppression = false;
    private boolean modeDeplacerOuvrier = false;

    /**
     * bouton pour passer au mode suppression
     *
     * @param suppr
     */
    public void supprimerBatimentMain(Runnable suppr) {
        zblockAction.setOnAction(event -> suppr.run());
    }

    /**
     * bouton pour placer iblock
     *
     * @param iBlock
     */
    public void placerIBatimentSurPlateau(Runnable iBlock) {
        iBatimentBouton.setOnAction(event -> iBlock.run());
    }

    /**
     * bouton pour choisir ouvrier a deplacer
     *
     * @param choisir
     */
    public void choisirOuvrierPlateau(Runnable choisir) {
        choisirOuvrier.setOnAction(event -> choisir.run());
    }

    /**
     * bouton pour ouvrir fenêtre d'aide
     *
     * @param aide
     */
    public void aideFenetre(Runnable aide) {
        aideBouton.setOnAction(event -> aide.run());
    }

    /**
     * bouton pour ouvrir fenêtre de stats
     *
     * @param stats
     */
    public void fenetreDeStats(Runnable stats) {
        ouvrirStats.setOnAction(event -> stats.run());
    }

    /**
     * bouton pour placer oblock
     *
     * @param oBlock
     */
    public void placerOBatimentSurPlateau(Runnable oBlock) {
        oBatimentBouton.setOnAction(event -> oBlock.run());
    }

    /**
     * bouton pour placer tblock
     *
     * @param tBlock
     */
    public void placerTBatimentSurPlateau(Runnable tBlock) {
        tBatimentBouton.setOnAction(event -> tBlock.run());
    }

    /**
     * bouton pour lce lblock
     *
     * @param lBlock
     */
    public void placerLBatimentSurPlateau(Runnable lBlock) {
        lBatimentBouton.setOnAction(event -> lBlock.run());
    }

    /**
     * bouton pour placer jblock
     *
     * @param jBlock
     */
    public void placerJBatimentSurPlateau(Runnable jBlock) {
        jBatimentBouton.setOnAction(event -> jBlock.run());
    }

    /**
     * bouton pour placer sblock
     *
     * @param sBlock
     */
    public void placerSBatimentSurPlateau(Runnable sBlock) {
        sBatimentBouton.setOnAction(event -> sBlock.run());
    }

    /**
     * bouton pour placer zblock
     *
     * @param zBlock
     */
    public void placerZBatimentSurPlateau(Runnable zBlock) {
        zBatimentBouton.setOnAction(event -> zBlock.run());
    }

    /**
     * bouton pour mettre fin au tour
     *
     * @param finTour
     */
    public void finTour(Runnable finTour) {
        finDeTourBouton.setOnAction(event -> finTour.run());
    }

    /**
     * bouton qui permet de quitter la partie
     *
     * @param quitter
     */
    public void quitterPartie(Runnable quitter) {
        quitterPartieBouton.setOnAction(event -> quitter.run());
    }

    /**
     * bouton pour sauvegarder la partie
     *
     * @param sauverPartie
     */
    public void sauvegarderPartie(Runnable sauverPartie) {
        sauvegarderPartieBouton.setOnAction(event -> sauverPartie.run());
    }

    /**
     * bouton pour placer un ouvrier
     *
     * @param poserOuvrier
     */
    public void placerOuvrierPlateau(Runnable poserOuvrier) {
        boutonOuvrier.setOnAction(event -> poserOuvrier.run());
    }

    /**
     * méthode pour afficher le nombre de batiment par type dans la main
     */
    public void afficherNbDeBatMain() {
        this.nbIBatiments.setText("    x" + nbIBlock);
        this.nbOBatiments.setText("    x" + nbOBlock);
        this.nbTBatiments.setText("    x" + nbTBlock);
        this.nbLBatiments.setText("    x" + nbLBlock);
        this.ntJBatiments.setText("    x" + nbJBlock);
        this.nbSBatiments.setText("    x" + nbSBlock);
        this.nbZBatiments.setText("    x" + nbZBlock);
    }

    /**
     * afficher le nombre d'ouvriers
     */
    public void afficherNbOuvriers() {
        labelNbOuvrier.setText(" x" + logiqueDeJeu.getNbOuvriersExterieur());
    }

    /**
     * getteur si on veut déplacer un ouvrier
     *
     * @return
     */
    public boolean getSiModeDeplacement() {
        return modeDeplacerOuvrier;
    }

    /**
     * afficher le nombre de materiaux
     */
    public void afficherNbMateriaux() {
        afficherNbMateriel.setText("" + logiqueDeJeu.getMateriaux());
    }

    /**
     * afficher le nombre d'énergies
     */
    public void afficherNbEnergie() {
        afficherNbEnergie.setText("" + logiqueDeJeu.getEnergie());
    }

    /**
     * compter le nombre de batiment présent dans la main en fonction du type du
     * batiment
     */
    public void compterBatimentDeLaMain() {
        nbIBlock = 0;
        nbOBlock = 0;
        nbTBlock = 0;
        nbLBlock = 0;
        nbJBlock = 0;
        nbSBlock = 0;
        nbZBlock = 0;
        for (Batiment b : logiqueDeJeu.getBatimentsMain()) {
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
        afficherNbDeBatMain();
    }

    /**
     * mettre a jour l'affichage du plateau
     */
    public void majPlateau() {
        p.dessinerPlateau(dessinerPlateau);
    }

    /**
     * dessiner tout les batiments dans un canvas afin de le prévisualiser au
     * joueur
     *
     * @param deckJoueur
     */
    public void dessinerBatimentsDansLaMain(Canvas deckJoueur) {
        int posX = 15;
        int posY = 15;

        for (Batiment b : logiqueDeJeu.getBatimentsSansDoublons()) {
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

    /**
     * booleen qui retourne si le batiment voulu se trouve bien dans la liste de
     * la pile
     *
     * @param nomBatiment
     * @return vrai si l batimnt voulu est présent
     */
    public Batiment verifierSiBatimentDansLaPile(String nomBatiment) {
        for (Batiment b : logiqueDeJeu.getBatimentsMain()) {
            if (b.getNomBatiment().equals(nomBatiment)) {
                return b;
            }
        }
        return null;
    }

    /**
     * afficher le score dans le label
     */
    public void afficherScore() {
        Integer scoreGame = logiqueDeJeu.getScorePartie();
        String score = scoreGame.toString();
        afficherScoreJeu.setText(score);
    }

    /**
     * afficher le tour dans lequel on se trouve dans un label
     */
    public void afficherTourCourrant() {
        Integer tourCourant = logiqueDeJeu.recupererTourCourrant();
        String tourCourantToString = tourCourant.toString();
        afficherNbTour.setText(tourCourantToString);
    }

    /**
     * passer au tour suivant et reinitialiser certaines variables pour le
     * prochain tour
     */
    public void tourSuivant() {

        for (Batiment b : logiqueDeJeu.getBatimentsDuPlateau()) {
            for (int i = 0; i < b.recupCases().length; i++) {
                for (int j = 0; j < b.recupCases()[0].length; j++) {
                    if (b.recupCases()[i][j] != null && b.recupCases()[i][j].getBatimentChaineChar().contains("o")) {
                        executerActionBatiment(b, b.recupCases()[i][j]);
                    }
                }
            }
            nbOuvrierSurLBatiment = 0;
        }
        if (logiqueDeJeu.getBatimentsMain().isEmpty()) {
            int tailleListeToutLesBatiments = logiqueDeJeu.getBatimentsPile().size() - 1;
            Random r = new Random();
            Batiment b = logiqueDeJeu.getBatimentsPile().remove(r.nextInt(tailleListeToutLesBatiments));
            logiqueDeJeu.getBatimentsMain().add(b);
            compterBatimentDeLaMain();
        }
        logiqueDeJeu.tourSuivant();
        batimentEnDessinValide = false;
        batimentPoséDansLeTour = false;
        ouvrierPosé = false;
        ouvrierValidé = false;
        p.batActuelNull();
        p.placerBatimentDeLaListeDansPlateau();
        indication.setText("Nouveau tour");
        majPlateau();
        afficherNbMateriaux();
        afficherNbEnergie();
        afficherScore();
    }

    /**
     * exécuter les actions de chaques batiments qui contiennent des ouvriers
     *
     * @param b
     * @param c
     */
    private void executerActionBatiment(Batiment b, Case c) {
        if (!(logiqueDeJeu.getEnergie() - b.getConsoNRJ() < 0)) {
            switch (b.getNomBatiment()) {
                case "I-Batiment":
                    logiqueDeJeu.consommerNRJ(b.getConsoNRJ());
                    logiqueDeJeu.produireMatériaux(b.getProdMatériaux());
                    break;
                case "J-Batiment":
                    logiqueDeJeu.consommerNRJ(b.getConsoNRJ());
                    JbatimentAction();
                    break;
                case "O-Batiment":
                    modifierPlaceOuvrier = true;
                    break;
                case "T-Batiment":
                    if (tourPair) {
                        logiqueDeJeu.produireNRJ(b.getProdNRJ());
                        tourPair = false;
                    } else {
                        tourPair = true;
                    }
                    break;
                case "L-Batiment":
                    ////////////////
                    nbOuvrierSurLBatiment++;
                    logiqueDeJeu.consommerNRJ(b.getConsoNRJ());
                    LbatimentAction(b);
                    break;
                case "S-Batiment":
                    logiqueDeJeu.produireMatériaux(b.getProdMatériaux());
                    break;
                case "Z-Batiment":
                    logiqueDeJeu.consommerNRJ(b.getConsoNRJ());
                    passerModeSuppression = true;
                    break;
            }
            indication.setText("Action du batiment réalisé");
        } else {
            c.setChaineCharBat(b.getCharBat());
            logiqueDeJeu.placerOuvrierExterieurList();
            labelNbOuvrier.setText("" + logiqueDeJeu.getNbOuvriersExterieur());
            indication.setText("Pas assez de ressource pour réaliser une action batiment");
        }
    }

    /**
     * action du lblock
     *
     * @param b
     */
    private void LbatimentAction(Batiment b) {
        switch (nbOuvrierSurLBatiment) {
            case 1:
                break;
            case 2:
                Ouvrier aEnlever = null;
                for (int i = 0; i < b.recupCases().length; i++) {
                    for (int j = 0; j < b.recupCases()[0].length; j++) {
                        if (b.recupCases()[i][j] != null && b.recupCases()[i][j].getBatimentChaineChar().contains("o")) {
                            b.recupCases()[i][j].setChaineCharBat(b.recupCases()[i][j].getBatimentChaineChar().substring(0, 1));
                            for (Ouvrier o : logiqueDeJeu.getOuvriersPlateau()) {
                                if (o.getPosOuvrier().getPosX() == b.recupCases()[i][j].getX() && o.getPosOuvrier().getPosY() == b.recupCases()[i][j].getY()) {
                                    aEnlever = o;
                                }
                            }
                            logiqueDeJeu.placerOuvrierExterieurList(aEnlever);
                        }
                    }
                }
                Ouvrier nouveau = new Ouvrier(new PositionOuvrier(0, 0));
                logiqueDeJeu.ajouterOuvrierExterieur(nouveau);
                logiqueDeJeu.ajouterOuvrierExtérieur(1);
                afficherNbOuvriers();
                break;
        }

    }

    /**
     * passer au mode de suppression de batiment dans la main
     */
    void passerModeSuppression() {
        if (passerModeSuppression) {
            supprimerBatimentMain = true;
            indication.setText("Appuyer sur un batiment que vous voulez supprimer");
        }
    }

    /**
     * action d'un Zblock de supprimer un batiment de la main et placer dans la
     * pile
     *
     * @param nomBatiment
     */
    public void supprimerBatimentDePile(String nomBatiment) {
        Batiment aSupprimer = null;
        Batiment b = verifierSiBatimentDansLaPile(nomBatiment);
        for (Batiment bat : logiqueDeJeu.getBatimentsMain()) {
            if (b.getNomBatiment().equals(bat.getNomBatiment())) {
                aSupprimer = bat;
                break;
            } else {
                indication.setText("Ce batiment n'est pas dans la main");
            }
        }
        logiqueDeJeu.OblockAction(aSupprimer);
        indication.setText("Un " + b.getNomBatiment() + " a été enlevé de la main");
        passerModeSuppression = false;
        supprimerBatimentMain = false;
        compterBatimentDeLaMain();
    }

    /**
     * piocher un batiment de la pile pour l'ajouter a la main , action du
     * jBlock
     */
    private void JbatimentAction() {
        int tailleListeToutLesBatiments = logiqueDeJeu.getBatimentsPile().size() - 1;
        Random r = new Random();
        Batiment b = logiqueDeJeu.getBatimentsPile().remove(r.nextInt(tailleListeToutLesBatiments));
        logiqueDeJeu.getBatimentsMain().add(b);
        compterBatimentDeLaMain();
    }

    /**
     * méthode qui permet de choisir l'ouvrier a supprimer action du OBLOCK
     */
    public void choisirOuvrierADeplacer() {
        if (modifierPlaceOuvrier) {
            modeDeplacerOuvrier = true;
            Ouvrier placeDavant = null;
            if (ouvrierAchoisirDansListe + 1 <= logiqueDeJeu.getOuvriersPlateau().size()) {
                if (ouvrierAchoisirDansListe - 1 >= 0) {
                    placeDavant = logiqueDeJeu.getOuvriersPlateau().get(ouvrierAchoisirDansListe - 1);
                } else if (ouvrierAchoisirDansListe - 1 < 0) {
                    placeDavant = logiqueDeJeu.getOuvriersPlateau().get(logiqueDeJeu.getOuvriersPlateau().size() - 1);
                }
                ouvrierADeplacer = logiqueDeJeu.getOuvriersPlateau().get(ouvrierAchoisirDansListe);
                p.remettreCouleurDefautOuvrier(placeDavant);
                p.changerCouleurOuvrier(ouvrierADeplacer);
                majPlateau();
                indication.setText("Choisissez l'ouvrier à déplacer");
                ouvrierAchoisirDansListe++;
            } else {
                ouvrierAchoisirDansListe = 0;
                if (ouvrierAchoisirDansListe - 1 >= 0) {
                    placeDavant = logiqueDeJeu.getOuvriersPlateau().get(ouvrierAchoisirDansListe - 1);
                } else if (ouvrierAchoisirDansListe - 1 < 0) {
                    placeDavant = logiqueDeJeu.getOuvriersPlateau().get(logiqueDeJeu.getOuvriersPlateau().size() - 1);
                }
                ouvrierADeplacer = logiqueDeJeu.getOuvriersPlateau().get(ouvrierAchoisirDansListe);
                p.remettreCouleurDefautOuvrier(placeDavant);
                p.changerCouleurOuvrier(ouvrierADeplacer);
                majPlateau();
                indication.setText("Choisissez l'ouvrier à déplacer");
                ouvrierAchoisirDansListe++;
            }
        }

    }

    /**
     * supprimer l'ouvrier et replacer un nouveau
     */
    public void supprimerOuvrier() {
        modifierPlaceOuvrier = false;
        modeDeplacerOuvrier = false;
        p.enleverOuvrier(ouvrierADeplacer);
        logiqueDeJeu.enleverOuvrierDePlateau(ouvrierADeplacer);
        ouvrierADeplacer.getPosOuvrier().setPosX(0);
        ouvrierADeplacer.getPosOuvrier().setPosY(0);
        logiqueDeJeu.ajouterOuvrierExterieur(ouvrierADeplacer);
        majPlateau();
        logiqueDeJeu.setNbOuvriersExterieur(logiqueDeJeu.getNbOuvriersExterieur() + 1);
        afficherNbOuvriers();
        indication.setText("Ouvrier supprimé");
        placerOuvrier();
    }

    /**
     * recompter nombre de batiments
     */
    public void recupNbBatimentsDeLaMain() {
        if (!batCharge) {
            logiqueDeJeu.ajouterToutLesBatiments();
            logiqueDeJeu.ajouterBatAleatMain();
            batCharge = true;
        }
        for (Batiment b : logiqueDeJeu.getBatimentsMain()) {
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
            afficherNbDeBatMain();
        }
    }

    /**
     * initialisation d la vue
     *
     */
    public void initialiserVueDeJeu() {
        GraphicsContext main = afficherBatiment.getGraphicsContext2D();
        main.fillRect(0, 0, 10 * 20, 20 * 23);
        p.dessinerPlateau(dessinerPlateau);
        recupNbBatimentsDeLaMain();
        dessinerBatimentsDansLaMain(afficherBatiment);
        dessinerOuvrier(dessinerOuvrier);
        afficherNbOuvriers();
        afficherNbEnergie();
        afficherNbMateriaux();
        afficherTourCourrant();
        indication.setText("Placez un batiment");
    }

    /**
     * dessiner un rond dans l'interface utilisateur
     *
     * @param s
     */
    public void dessinerOuvrier(Canvas s) {
        GraphicsContext gc = s.getGraphicsContext2D();
        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.YELLOW);
        gc.strokeOval(30, 25, 20, 20);
        gc.fillOval(30, 25, 20, 20);
    }

    /**
     * ajouter les batiments daans la liste du plateau
     *
     * @param nomBatiment
     */
    public void ajouterBatimentDansListePlateau(String nomBatiment) {
        logiqueDeJeu.ajouterBatimentPlateau(nomBatiment);
    }

    /**
     * recupere si un batment est deja validé dans le tour
     *
     * @return
     */
    public boolean recupererBatimentValide() {
        return batimentEnDessinValide;
    }

    /**
     * recupere si un batiment est deja posé dans le tour
     *
     * @return
     */
    private boolean recupererBatimentPose() {
        return batimentPoséDansLeTour;
    }

    /**
     * place le tableau du batiment dans le tableau du plateau
     *
     * @param b
     */
    public void placerTableauBatimentDansTableauPlateau(Batiment b) {
        if (logiqueDeJeu.verifierSiMaterielsNécessaire(b)) {
            indication.setText(" " + b.getNomBatiment() + " en placement ");
            batimentBEnDessin = b;
            p.placerBatimentDansTableauDePlateau(batimentBEnDessin, batimentBEnDessin.recupCases());
            batimentPoséDansLeTour = true;
        } else {
            indication.setText("Matériaux insuffisant !!");
        }
    }

    /**
     * méthode pour deplacer le batiment à droite
     */
    public void deplacerBatimentDroite() {
        p.placerBatimentDansTableauDePlateau(batimentBEnDessin, batimentBEnDessin.deplacerADroite(batimentBEnDessin.recupCases()));
    }

    /**
     * méthode pour deplacer le batiment à gauche
     */
    public void deplacerBatimentGauche() {
        p.placerBatimentDansTableauDePlateau(batimentBEnDessin, batimentBEnDessin.deplacerAGauche(batimentBEnDessin.recupCases()));
    }

    /**
     * méthode pour deplacer le batiment en bas
     */
    public void deplacerBatimentBas() {
        p.placerBatimentDansTableauDePlateau(batimentBEnDessin, batimentBEnDessin.deplacerEnBas(batimentBEnDessin.recupCases()));
    }

    /**
     * méthode pour deplacer le batiment en haut
     */
    public void deplacerBatimentHaut() {
        p.placerBatimentDansTableauDePlateau(batimentBEnDessin, batimentBEnDessin.deplacerEnHaut(batimentBEnDessin.recupCases()));
    }

    /**
     * méthode pour pivoter le batiment
     */
    public void pivoterBatiment() {
        batimentBEnDessin.setDirectionBatiment();
        p.placerBatimentDansTableauDePlateau(batimentBEnDessin, batimentBEnDessin.pivoterBatiment());
    }

    /**
     * placer un batiment de la main sur le plateau
     *
     * @param nomBat
     */
    public void placerBatiment(String nomBat) {
        Batiment b = verifierSiBatimentDansLaPile(nomBat);
        if (b != null && !recupererBatimentValide() && !supprimerBatimentMain) {
            setBatPosé();
            placerTableauBatimentDansTableauPlateau(b);
            if (recupererBatimentPose()) {
                setBatSelectioné(true);
            }
            majPlateau();
        } else {
            //texte.setText("Vous ne pouvez pas poser ce batiment maintenant.");
            indication.setText("Vous avez déjà joué ou le batiment n'est pas présent");
        }
    }

    /**
     * placer un ouvrier
     */
    public void placerOuvrier() {
        if (logiqueDeJeu.getNbOuvriersExterieur() > 0 && !ouvrierPosé && batimentAvecEmplacementVidePresent) {
            logiqueDeJeu.setNbOuvriersExterieur(logiqueDeJeu.getNbOuvriersExterieur());
            indication.setText("Placement de l'ouvrier en cours");
            ouvrierPosé = true;
            placerOuvrierDansTableauPlateau();
        } else {
            indication.setText("Posez un batiment ou passez le tour");
        }
        majPlateau();
    }

    /**
     * méthode qui valide le batiment selectionne
     */
    public void validerBatiment() {
        if (!batimentEnDessinValide && p.validerBatiment()) {
            batimentEnDessinValide = true;
            logiqueDeJeu.getBatimentsMain().remove(batimentBEnDessin);
            logiqueDeJeu.setListeBatPlateau(batimentBEnDessin);
            logiqueDeJeu.setNbBatimentSurPlateau();
            logiqueDeJeu.payerPourPoserBatiment(batimentBEnDessin.getPrix());
            afficherNbMateriaux();
            batimentBEnDessin = null;
            indication.setText("Batiment valide, placez un ouvrier ou passez le tour");
        } else {
            indication.setText("Placement impossible, collision présente");
        }
        batimentAvecEmplacementVidePresent = true;
        compterBatimentDeLaMain();
    }

    /**
     * valider un ouvrier posé
     */
    public void validerOuvrier() {
        if (!ouvrierValidé && p.validerOuvrier()) {
            ouvrierValidé = true;
            Ouvrier aMettreDansListe = new Ouvrier(new PositionOuvrier(ouvrierAPlacer.getPosOuvrier().getPosX(), ouvrierAPlacer.getPosOuvrier().getPosY()));
            logiqueDeJeu.ajouterOuvrierListePlateau(aMettreDansListe);
            logiqueDeJeu.enleverOuvrierDeListeExtérieur(ouvrierAPlacer);
            logiqueDeJeu.ajouterOuvrierPlateau();
            ouvrierAPlacer = null;
            indication.setText("Placement valide, mettez fin au tour");

        } else {
            indication.setText("Placez l'ouvrier sur une place vide");
        }
        afficherNbOuvriers();
    }

    /**
     * placer l'ouvrier dans le tableau du plateau
     */
    private void placerOuvrierDansTableauPlateau() {
        ouvrierAPlacer = logiqueDeJeu.ouvrierAplacerDansLePlateau();
        p.placerOuvrierDansTableauPlateau(ouvrierAPlacer);
        afficherNbOuvriers();
        majPlateau();
    }

    /**
     * deplacer l'ouvrier à droite
     */
    public void deplacerOuvrierDroite() {
        ouvrierAPlacer.deplacerDroite();
        p.placerOuvrierDansTableauPlateau(ouvrierAPlacer);
        majPlateau();
    }

    /**
     * déplacer l'ouvrier à gauche
     */
    public void deplacerOuvrierGauche() {
        ouvrierAPlacer.deplacerGauche();
        p.placerOuvrierDansTableauPlateau(ouvrierAPlacer);
        majPlateau();
    }

    /**
     * déplacer l'ouvrier en haut
     */
    public void deplacerOuvrierHaut() {
        ouvrierAPlacer.deplacerHaut();
        p.placerOuvrierDansTableauPlateau(ouvrierAPlacer);
        majPlateau();
    }

    /**
     * déplacer l'ouvrier en bas
     */
    public void deplacerOuvrierBas() {
        ouvrierAPlacer.deplacerBas();
        p.placerOuvrierDansTableauPlateau(ouvrierAPlacer);
        majPlateau();
    }

    /**
     * getteur si l'ouvrier est validé
     *
     * @return
     */
    public boolean getOuvrierValidé() {
        return ouvrierValidé;
    }

    /**
     * voir si il y a des places vides pour ouvriers
     *
     * @return
     */
    public boolean getPlacePourOuvrierVide() {
        return batimentAvecEmplacementVidePresent;
    }

    /**
     * getteur pour savoir si un ouvrier est posé dans le tour
     *
     * @return
     */
    public boolean getOuvriéPosé() {
        return ouvrierPosé;
    }

    /**
     * modifier la variabe batSelectionne en y placant la valeur placé en
     * parametre
     *
     * @param b
     */
    public void setBatSelectioné(boolean b) {
        batSelectionne = b;
    }

    /**
     * getteur d'un batiment séletionné
     *
     * @return
     */
    public boolean getBatSelectionné() {
        return batSelectionne;
    }

    /**
     * batiment posé
     */
    public void setBatPosé() {
        batimentPoséDansLeTour = false;
    }

    /**
     * getteur de la logique du jeu
     *
     * @return
     */
    public GameLogic getLogiqueDeJeu() {
        return logiqueDeJeu;
    }

    /**
     * verifier si nous avons le droit de supprimer un batiment
     *
     * @return
     */
    public boolean getSiSuppressionPermise() {
        return supprimerBatimentMain;
    }

    void indiquerPartieSauvé() {
        indication.setText("Fonctionnalité pas en service !");
    }

}
