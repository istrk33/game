/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildings.data;

import PlateauDeJeu.Cellule;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;

/**
 *
 * @author isoyturk
 */
public class IBatiment extends Batiment {

    private final String i = "i";
    private final int lignesPourDessinerBatiments = 1;
    private final int colonnesPourDessinerBatiments = 4;
    private String[][] tableauCases = new String[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];

    /**
     * constructeur d'un iblock
     *
     * @param nomBatiment
     * @param nombreDeBatiment
     * @param prix
     * @param consoNRJ
     * @param prodMatériaux
     * @param prodNRJ
     * @param action
     * @param charBat
     */
    public IBatiment(String nomBatiment, int nombreDeBatiment, int prix, int consoNRJ, int prodMatériaux, int prodNRJ, String action, String charBat) {
        super(nomBatiment, nombreDeBatiment, prix, consoNRJ, prodMatériaux, prodNRJ, action, charBat);
        batPos1 = new Case[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];
        batPos1[0][0] = new Case(0, 0, i, "gauche");
        batPos1[1][0] = new Case(1, 0, i, "hautmilieu");
        batPos1[2][0] = new Case(2, 0, i, "basmilieu");
        batPos1[3][0] = new Case(3, 0, i, "droite");

        batPos2 = new Case[lignesPourDessinerBatiments][colonnesPourDessinerBatiments];

        tableauCases[0][0] = i;
        tableauCases[1][0] = i;
        tableauCases[2][0] = i;
        tableauCases[3][0] = i;

        directionBatiment = "UN";
        batPosDefaut = batPos1;
    }

    /**
     * récupérer le string du batiment
     *
     * @return
     */
    public String getStrBatiment() {
        return i;
    }

    /**
     * dessiner le batiment dans la main
     *
     * @param deckJoueur
     * @param posX
     * @param posY
     */
    public void dessinerBatiment(Canvas deckJoueur, int posX, int posY) {
        for (int i = 0; i < colonnesPourDessinerBatiments; i++) {
            for (int j = 0; j < lignesPourDessinerBatiments; j++) {
                if ("i".equals(tableauCases[i][j])) {
                    Cellule c = new Cellule();
                    c.dessinerCelluleSansOuvrier(deckJoueur, posX + (c.recupTailleCote() + 1) * i, posY + (c.recupTailleCote() + 1) * j, Color.BLACK, Color.LIME);
                }
            }
        }
    }

    /**
     * pivoter le batiment
     *
     * @return
     */
    @Override
    public Case[][] pivoterBatiment() {
        switch (directionBatiment) {
            case "UN":
                if (batPos2[0][0].getX() + colonnesPourDessinerBatiments <= maxX && batPos2[0][0].getY() + lignesPourDessinerBatiments <= maxY) {
                    batPos1[0][0].setPosXCase(batPos2[0][0].getX());
                    batPos1[0][0].setPosYCase(batPos2[0][0].getY());
                    batPos1[1][0].setPosXCase(batPos2[0][0].getX() + 1);
                    batPos1[1][0].setPosYCase(batPos2[0][0].getY());
                    batPos1[2][0].setPosXCase(batPos2[0][0].getX() + 2);
                    batPos1[2][0].setPosYCase(batPos2[0][0].getY());
                    batPos1[3][0].setPosXCase(batPos2[0][0].getX() + 3);
                    batPos1[3][0].setPosYCase(batPos2[0][0].getY());
                    batPosDefaut = batPos1;
                }
                break;
            case "DEUX":
                if (batPos1[0][0].getX() + lignesPourDessinerBatiments <= maxX && batPos1[0][0].getY() + colonnesPourDessinerBatiments <= maxY) {
                    batPos2[0][0] = new Case(batPos1[0][0].getX(), batPos1[0][0].getY(), i, "haut");
                    batPos2[0][1] = new Case(batPos1[0][0].getX(), batPos1[0][0].getY() + 1, i, "gauchemilieu");
                    batPos2[0][2] = new Case(batPos1[0][0].getX(), batPos1[2][0].getY() + 2, i, "droitemilieu");
                    batPos2[0][3] = new Case(batPos1[0][0].getX(), batPos1[3][0].getY() + 3, i, "bas");
                    batPosDefaut = batPos2;
                }
                break;
        }
        return batPosDefaut;
    }

    /**
     * changer la direction
     */
    @Override
    public void setDirectionBatiment() {
        switch (directionBatiment) {
            case "UN":
                directionBatiment = "DEUX";

                break;
            case "DEUX":
                directionBatiment = "UN";

        }
    }
}
