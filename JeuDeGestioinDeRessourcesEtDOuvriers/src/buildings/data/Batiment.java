/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildings.data;

import PlateauDeJeu.Cellule;

/**
 *
 * @author isoyturk
 */
public abstract class Batiment {

    String directionBatiment;
    private final String nomBatiment;
    private final int nombreDuBatiment;
    private final int prix;
    private final String charBat;
    private final int consomationEnergie;
    private final int productionEnergie;
    private final int productionMatériaux;
    private final String action;

    final int maxX = 10;
    final int maxY = 20;
    Cellule[] cellules = new Cellule[4];
    Case[][] batPosDefaut;
    Case[][] batPos1;
    Case[][] batPos2;
    Case[][] batPos3;
    Case[][] batPos4;

    /**
     * Constructeur de la classe abstraite d'un batiment
     * @param nomBatiment
     * @param nombreDeBatiment
     * @param prix
     * @param consoNRJ
     * @param prodMatériaux
     * @param prodNRJ
     * @param action
     * @param charBat 
     */
    public Batiment(String nomBatiment, int nombreDeBatiment, int prix,
            int consoNRJ, int prodMatériaux, int prodNRJ, String action, String charBat) {
        this.nombreDuBatiment = nombreDeBatiment;
        this.charBat = charBat;
        this.prix = prix;
        this.consomationEnergie = consoNRJ;
        this.productionEnergie = prodNRJ;
        this.productionMatériaux = prodMatériaux;
        this.nomBatiment = nomBatiment;
        this.action = action;
    }

    /**
     * getteur de l'action du bat
     * @return 
     */
    public String getAction() {
        return action;
    }

    /**
     * getteur du nom du bat
     * @return 
     */
    public String getNomBatiment() {
        return nomBatiment;
    }

    /**
     * getteur du nombre du bat
     * @return 
     */
    public int getNombreDuBatiment() {
        return nombreDuBatiment;
    }

    /**
     * getteur du prix du bat en matériaux
     * @return 
     */
    public int getPrix() {
        return prix;
    }

    /**
     * getteur de la conso en energie du bat
     * @return 
     */
    public int getConsoNRJ() {
        return consomationEnergie;
    }

    /**
     * getteur de la production du bat en énergie
     * @return 
     */
    public int getProdNRJ() {
        return productionEnergie;
    }

    /**
     * getteur de la prod de matériaux
     */
    public int getProdMatériaux() {
        return productionMatériaux;
    }

    /**
     * déplacer un batiment à droite
     * @param caseBat
     * @return 
     */
    public Case[][] deplacerADroite(Case caseBat[][]) {

        Case caseReference = null;
        for (int i = 0; i < caseBat.length; i++) {
            for (int j = 0; j < caseBat[0].length; j++) {
                if (caseBat[i][j] != null && caseBat[i][j].getTypeDeCase().contains("droite")) {
                    caseReference = caseBat[i][j];
                }
            }
        }
        if (caseReference.getX() + 1 < maxX) {
            for (int i = 0; i < caseBat.length; i++) {
                for (int j = 0; j < caseBat[0].length; j++) {
                    if (caseBat[i][j] != null && caseBat.length + 1 < maxX) {
                        caseBat[i][j].droite();
                    }
                }
            }
        }
        return caseBat;
    }

    /**
     * getteur du string d'un bat
     * @return 
     */
    public String getCharBat() {
        return charBat;
    }

    /**
     * deplacer un batiment à gauche
     * @param caseBat
     * @return 
     */
    public Case[][] deplacerAGauche(Case caseBat[][]) {
        Case caseReference = null;
        for (int i = 0; i < caseBat.length; i++) {
            for (int j = 0; j < caseBat[0].length; j++) {
                if (caseBat[i][j] != null && caseBat[i][j].getTypeDeCase().contains("gauche")) {
                    caseReference = caseBat[i][j];
                }
            }
        }
        if (caseReference.getX() - 1 >= 0) {
            for (int i = 0; i < caseBat.length; i++) {
                for (int j = 0; j < caseBat[0].length; j++) {
                    if (caseBat[i][j] != null) {
                        caseBat[i][j].gauche();
                    }
                }
            }
        }
        return caseBat;
    }

    /**
     * déplacer un batiment en haut
     * @param caseBat
     * @return 
     */
    public Case[][] deplacerEnHaut(Case caseBat[][]) {
        Case caseReference = null;
        for (int i = 0; i < caseBat.length; i++) {
            for (int j = 0; j < caseBat[0].length; j++) {
                if (caseBat[i][j] != null && caseBat[i][j].getTypeDeCase().contains("haut")) {
                    caseReference = caseBat[i][j];
                }
            }
        }
        if (caseReference.getY() - 1 >= 0) {
            for (int i = 0; i < caseBat.length; i++) {
                for (int j = 0; j < caseBat[0].length; j++) {
                    if (caseBat[i][j] != null) {
                        caseBat[i][j].haut();
                    }
                }
            }
        }
        return caseBat;
    }

    /**
     * déplacer un batiment en bas
     * @param caseBat
     * @return 
     */
    public Case[][] deplacerEnBas(Case caseBat[][]) {
        Case caseReference = null;
        for (int i = 0; i < caseBat.length; i++) {
            for (int j = 0; j < caseBat[0].length; j++) {
                if (caseBat[i][j] != null && caseBat[i][j].getTypeDeCase().contains("bas")) {
                    caseReference = caseBat[i][j];
                }
            }
        }
        if (caseReference.getY() + 1 < maxY) {
            for (int i = 0; i < caseBat.length; i++) {
                for (int j = 0; j < caseBat[0].length; j++) {
                    if (caseBat[i][j] != null) {
                        caseBat[i][j].bas();
                    }
                }
            }
        }
        return caseBat;
    }

    /**
     * pivoter batiment , méthode surchargé partout
     * @return 
     */
    public Case[][] pivoterBatiment() {
        return batPos1;
    }

    /**
     * direction du batiment pour L,J,T batiment
     */
    public void setDirectionBatiment() {
        switch (directionBatiment) {
            case "UN":
                directionBatiment = "DEUX";
                break;
            case "DEUX":
                directionBatiment = "TROIS";
                break;
            case "TROIS":
                directionBatiment = "QUATRE";
                break;
            case "QUATRE":
                directionBatiment = "UN";
                break;
        }
    }

    /**
     * retourner le tableau du batiment
     * @return 
     */
    public Case[][] recupCases() {
        return batPosDefaut;
    }

}
