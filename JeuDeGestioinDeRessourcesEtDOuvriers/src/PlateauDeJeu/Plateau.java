/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlateauDeJeu;

import Ouvrier.Ouvrier;
import buildings.data.Batiment;
import buildings.data.IBatiment;
import buildings.data.JBatiment;
import buildings.data.LBatiment;
import buildings.data.OBatiment;
import buildings.data.Case;
import buildings.data.SBatiment;
import buildings.data.TBatiment;
import buildings.data.ZBatiment;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import javafx.scene.canvas.Canvas;

/**
 *
 * @author isoyturk
 */
public class Plateau {
    
    private int nbColonnes = 10;
    private int nbLignes = 20;
    private String[][] plateauDeJeu = new String[nbColonnes][nbLignes];
    private ArrayList<Case[][]> mesBatiments;
    private Case[][] batimentActuel;
    private Ouvrier ouvrierEnDessin;

    /**
     * Constructeur de plateau
     */
    public Plateau() {
        this.mesBatiments = new ArrayList();
        for (int i = 0; i < nbColonnes; i++) {
            for (int j = 0; j < nbLignes; j++) {
                plateauDeJeu[i][j] = "n";
            }
        }
    }

    /**
     * changer le string d'une case
     *
     * @param i
     * @param j
     * @param bat
     */
    public void setCellule(int i, int j, String bat) {
        plateauDeJeu[i][j] = bat;
    }

    /**
     * dessiner le plateau de jeu complètement
     *
     * @param can
     */
    public void dessinerPlateau(Canvas can) {
        for (int i = 0; i < nbColonnes; i++) {
            for (int j = 0; j < nbLignes; j++) {
                Cellule c = new Cellule();
                switch (plateauDeJeu[i][j]) {
                    case "i":
                        c.dessinerCelluleSansOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.LIME);
                        break;
                    case "j":
                        c.dessinerCelluleSansOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.DARKORCHID);
                        break;
                    case "l":
                        c.dessinerCelluleSansOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.CRIMSON);
                        break;
                    case "O":
                        c.dessinerCelluleSansOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.YELLOWGREEN);
                        break;
                    case "s":
                        c.dessinerCelluleSansOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.DARKTURQUOISE);
                        break;
                    case "t":
                        c.dessinerCelluleSansOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.CORAL);
                        break;
                    case "z":
                        c.dessinerCelluleSansOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.AQUAMARINE);
                        break;
                    case "n":
                        c.dessinerCelluleSansOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.GREY);
                        break;
                    case "io":
                        c.dessinerCelluleAvecOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.LIME);
                        break;
                    case "jo":
                        c.dessinerCelluleAvecOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.DARKORCHID);
                        break;
                    case "lo":
                        c.dessinerCelluleAvecOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.CRIMSON);
                        break;
                    case "Oo":
                        c.dessinerCelluleAvecOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.YELLOWGREEN);
                        break;
                    case "so":
                        c.dessinerCelluleAvecOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.DARKTURQUOISE);
                        break;
                    case "to":
                        c.dessinerCelluleAvecOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.CORAL);
                        break;
                    case "zo":
                        c.dessinerCelluleAvecOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.AQUAMARINE);
                        break;
                    case "no":
                        c.dessinerCelluleAvecOuvrier(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.GREY);
                        break;
                    case "iod":
                        c.dessinerCelluleAvecOuvrierDeplacement(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.LIME);
                        break;
                    case "jod":
                        c.dessinerCelluleAvecOuvrierDeplacement(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.DARKORCHID);
                        break;
                    case "lod":
                        c.dessinerCelluleAvecOuvrierDeplacement(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.CRIMSON);
                        break;
                    case "Ood":
                        c.dessinerCelluleAvecOuvrierDeplacement(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.YELLOWGREEN);
                        break;
                    case "sod":
                        c.dessinerCelluleAvecOuvrierDeplacement(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.DARKTURQUOISE);
                        break;
                    case "tod":
                        c.dessinerCelluleAvecOuvrierDeplacement(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.CORAL);
                        break;
                    case "zod":
                        c.dessinerCelluleAvecOuvrierDeplacement(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.AQUAMARINE);
                        break;
                }
            }
        }
    }

    /**
     * placer un string d'ouvrier dans le tableau 2 dimensions de string du
     * plateau
     *
     * @param o
     */
    public void placerOuvrierDansTableauPlateau(Ouvrier o) {
        ouvrierEnDessin = o;
        placerBatimentDeLaListeDansPlateau();
        plateauDeJeu[ouvrierEnDessin.getPosOuvrier().getPosX()][ouvrierEnDessin.getPosOuvrier().getPosY()] = plateauDeJeu[ouvrierEnDessin.getPosOuvrier().getPosX()][ouvrierEnDessin.getPosOuvrier().getPosY()] + ouvrierEnDessin.getNomOuvrier();
    }
    
    public void deplacerOuvrierOblock(Ouvrier o) {
        ouvrierEnDessin = o;
        placerBatimentDeLaListeDansPlateau();
        plateauDeJeu[ouvrierEnDessin.getPosOuvrier().getPosX()][ouvrierEnDessin.getPosOuvrier().getPosY()] = plateauDeJeu[ouvrierEnDessin.getPosOuvrier().getPosX()][ouvrierEnDessin.getPosOuvrier().getPosY()] + ouvrierEnDessin.getNomOuvrier() + "d";
    }

    /**
     * placer les string d'un batiment dans le tableau de string du plateau
     *
     * @param b
     * @param batimentCases
     */
    public void placerBatimentDansTableauDePlateau(Batiment b, Case[][] batimentCases) {
        batimentActuel = batimentCases;
        placerBatimentDeLaListeDansPlateau();
    }

    /**
     * mettre a jour le tableau de string
     */
    public void placerBatimentDeLaListeDansPlateau() {
        for (int i = 0; i < nbColonnes; ++i) {
            for (int j = 0; j < nbLignes; ++j) {
                plateauDeJeu[i][j] = "n";
            }
        }
        for (Case[][] c : mesBatiments) {
            placerCasesDansTableau(c);
        }
        if (batimentActuel != null) {
            placerCasesDansTableau(batimentActuel);
        }
    }

    /**
     * mettre le string d'une case d'un batiment dans le tableau de string du
     * plateau
     *
     * @param cases
     */
    public void placerCasesDansTableau(Case[][] cases) {
        for (int i = 0; i < cases.length; i++) {
            for (int j = 0; j < cases[0].length; j++) {
                if (cases[i][j] != null) {
                    plateauDeJeu[cases[i][j].getX()][cases[i][j].getY()] = cases[i][j].getBatimentChaineChar();
                }
            }
        }
    }

    /**
     * demande de validation du batiment en vérifiant si un batiment n'est pas
     * déjà présent dans les coordonnés du batiment en placement
     *
     * @return
     */
    public boolean validerBatiment() {
        for (int i = 0; i < batimentActuel.length; i++) {
            for (int j = 0; j < batimentActuel[0].length; j++) {
                for (Case[][] cases : mesBatiments) {
                    for (int n = 0; n < cases.length; n++) {
                        for (int u = 0; u < cases[0].length; u++) {
                            if (batimentActuel[i][j] != null && cases[n][u] != null && batimentActuel[i][j].collision(cases[n][u])) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        mesBatiments.add(batimentActuel);
        batimentActuel = null;
        return true;
    }

    /**
     * valider un ouvrier en verifiant qu'on pose l'ouvrier sur un batiment et
     * qu'un autre ouvrier n'occupe pas la place
     *
     * @return
     */
    public boolean validerOuvrier() {
        if (plateauDeJeu[ouvrierEnDessin.getPosOuvrier().getPosX()][ouvrierEnDessin.getPosOuvrier().getPosY()].contains("n") || plateauDeJeu[ouvrierEnDessin.getPosOuvrier().getPosX()][ouvrierEnDessin.getPosOuvrier().getPosY()].contains("oo")) {
            return false;
        }
        for (Case[][] c : mesBatiments) {
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < c[0].length; j++) {
                    if (c[i][j] != null && c[i][j].getX() == ouvrierEnDessin.getPosOuvrier().getPosX() && c[i][j].getY() == ouvrierEnDessin.getPosOuvrier().getPosY()) {
                        c[i][j].setChaineCharBat(c[i][j].getBatimentChaineChar() + ouvrierEnDessin.getNomOuvrier());
                    }
                }
            }
        }
        ouvrierEnDessin = null;
        return true;
    }

    /**
     * récupérer le string du batiment a poser
     *
     * @param b
     * @return
     */
    public String charBatiment(Batiment b) {
        String charBat = null;
        switch (b.getNomBatiment()) {
            case "I-Batiment":
                IBatiment i = (IBatiment) b;
                charBat = i.getStrBatiment();
                break;
            case "J-Batiment":
                JBatiment j = (JBatiment) b;
                charBat = j.getStrBatiment();
                break;
            case "L-Batiment":
                LBatiment l = (LBatiment) b;
                charBat = l.getStrBatiment();
                break;
            case "O-Batiment":
                OBatiment o = (OBatiment) b;
                charBat = o.getStrBatiment();
                break;
            case "S-Batiment":
                SBatiment s = (SBatiment) b;
                charBat = s.getStrBatiment();
                break;
            case "T-Batiment":
                TBatiment t = (TBatiment) b;
                charBat = t.getStrBatiment();
                break;
            case "Z-Batiment":
                ZBatiment z = (ZBatiment) b;
                charBat = z.getStrBatiment();
                break;
        }
        return charBat;
    }

    /**
     * getteur du plateau de jeu
     *
     * @return
     */
    public String[][] getPlateauDeJeu() {
        return plateauDeJeu;
    }

    /**
     * getteur du nombre de colonnes du plateau
     *
     * @return
     */
    public int getNbColonnes() {
        return nbColonnes;
    }

    /**
     * getteur du nombre de lignes
     *
     * @return
     */
    public int getNbLignes() {
        return nbLignes;
    }
    
    /**
     * setteur du batiment actuel a null
     */
    public void batActuelNull() {
        batimentActuel = null;
    }
    
    /**
     * enlever l'ouvrier du plateau et de son batiment
     * @param ouvrierADeplacer 
     */
    public void enleverOuvrier(Ouvrier ouvrierADeplacer) {
        for (int i = 0; i < nbColonnes; i++) {
            for (int j = 0; j < nbLignes; j++) {
                if (ouvrierADeplacer.getPosOuvrier().getPosX() == i && ouvrierADeplacer.getPosOuvrier().getPosY() == j) {
                    plateauDeJeu[i][j] = plateauDeJeu[i][j].substring(0, 1);
                    for (Case[][] c : mesBatiments) {
                       for(int u=0;u<c.length;u++){
                           for(int n=0;n<c[0].length;n++){
                               if(c[u][n]!=null&&c[u][n].getX()==i&&c[u][n].getY()==j){
                                   c[u][n].setChaineCharBat(plateauDeJeu[i][j]);
                               }
                           }
                       }
                    }
                }
            }
        }
    }
    
    /**
     * changer de couleur quand on choisi l'ouvrier a supprimer
     * @param ouvrierADeplacer 
     */
    public void changerCouleurOuvrier(Ouvrier ouvrierADeplacer) {
        for (int i = 0; i < nbColonnes; i++) {
            for (int j = 0; j < nbLignes; j++) {
                if (ouvrierADeplacer.getPosOuvrier().getPosX() == i && ouvrierADeplacer.getPosOuvrier().getPosY() == j) {
                    plateauDeJeu[i][j] = plateauDeJeu[i][j].concat("d");
                }
            }
        }
    }
    
    /**
     * remettre la couleur par défaut si on change d'ouvrier
     * @param placeDavant 
     */
    public void remettreCouleurDefautOuvrier(Ouvrier placeDavant) {
        for (int i = 0; i < nbColonnes; i++) {
            for (int j = 0; j < nbLignes; j++) {
                if (placeDavant.getPosOuvrier().getPosX() == i && placeDavant.getPosOuvrier().getPosY() == j) {
                    plateauDeJeu[i][j] = plateauDeJeu[i][j].substring(0, 2);
                }
            }
        }
    }
}
