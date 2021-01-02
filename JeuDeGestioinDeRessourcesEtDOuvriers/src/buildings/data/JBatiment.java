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
public class JBatiment extends Batiment {

    private final String j = "j";
    private final int lignesPourDessinerBatiments = 3;
    private final int colonnesPourDessinerBatiments = 2;
    private String[][] tableauCases = new String[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];

    /**
     * constructeur d'un jblock
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
    public JBatiment(String nomBatiment, int nombreDeBatiment, int prix, int consoNRJ, int prodMatériaux, int prodNRJ, String action, String charBat) {
        super(nomBatiment, nombreDeBatiment, prix, consoNRJ, prodMatériaux, prodNRJ, action, charBat);
        batPos1 = new Case[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];
        batPos1[0][2] = new Case(0, 2, j, "basgauche");
        batPos1[1][0] = new Case(1, 0, j, "hautdroite");
        batPos1[1][1] = new Case(1, 1, j, "milieudroite");
        batPos1[1][2] = new Case(1, 2, j, "basdroite");

        batPos2 = new Case[lignesPourDessinerBatiments][colonnesPourDessinerBatiments];

        batPos3 = new Case[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];

        batPos4 = new Case[lignesPourDessinerBatiments][colonnesPourDessinerBatiments];

        tableauCases[0][0] = "n";
        tableauCases[0][1] = "n";
        tableauCases[0][2] = "j";
        tableauCases[1][0] = "j";
        tableauCases[1][1] = "j";
        tableauCases[1][2] = "j";

        directionBatiment = "UN";
        batPosDefaut = batPos1;
    }

    /**
     * récupérer le string du batiment
     *
     * @return
     */
    public String getStrBatiment() {
        return j;
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
                if ("j".equals(tableauCases[i][j])) {
                    Cellule c = new Cellule();
                    c.dessinerCelluleSansOuvrier(deckJoueur, posX + (c.recupTailleCote() + 1) * i, posY + (c.recupTailleCote() + 1) * j, Color.BLACK, Color.DARKORCHID);
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
                if (batPos4[0][0].getX() + colonnesPourDessinerBatiments <= maxX && batPos4[0][0].getY() + lignesPourDessinerBatiments <= maxY) {
                    batPos1[0][2].setPosXCase(batPos4[0][0].getX());
                    batPos1[0][2].setPosYCase(batPos4[0][0].getY() + 2);
                    batPos1[1][0].setPosXCase(batPos4[0][0].getX() + 1);
                    batPos1[1][0].setPosYCase(batPos4[0][0].getY());
                    batPos1[1][1].setPosXCase(batPos4[0][0].getX() + 1);
                    batPos1[1][1].setPosYCase(batPos4[0][0].getY() + 1);
                    batPos1[1][2].setPosXCase(batPos4[0][0].getX() + 1);
                    batPos1[1][2].setPosYCase(batPos4[0][0].getY() + 2);
                    batPosDefaut = batPos1;
                } else {
                    System.out.println("Sortie du tableau");
                }
                break;
            case "DEUX":
                if (batPos1[0][2].getX() + lignesPourDessinerBatiments <= maxX && batPos1[1][0].getY() + colonnesPourDessinerBatiments <= maxY) {
                    batPos2[0][0] = new Case(batPos1[1][0].getX() - 1, batPos1[1][0].getY(), j, "hautgauche");
                    batPos2[1][0] = new Case(batPos1[1][0].getX(), batPos1[1][0].getY(), j, "hautmilieu");
                    batPos2[2][0] = new Case(batPos1[1][0].getX() + 1, batPos1[1][0].getY(), j, "hautdroite");
                    batPos2[2][1] = new Case(batPos1[1][0].getX() + 1, batPos1[1][0].getY() + 1, j, "basdroite");
                    batPosDefaut = batPos2;
                } else {
                    System.out.println("Sortie du tableau");
                }
                break;
            case "TROIS":
                if (batPos2[0][0].getX() + colonnesPourDessinerBatiments <= maxX && batPos2[0][0].getY() + lignesPourDessinerBatiments <= maxY) {
                    batPos3[0][0] = new Case(batPos2[0][0].getX(), batPos2[0][0].getY(), j, "hautgauche");
                    batPos3[1][0] = new Case(batPos2[0][0].getX() + 1, batPos2[0][0].getY(), j, "hautdroite");
                    batPos3[0][1] = new Case(batPos2[0][0].getX(), batPos2[0][0].getY() + 1, j, "milieugauche");
                    batPos3[0][2] = new Case(batPos2[0][0].getX(), batPos2[0][0].getY() + 2, j, "basgauche");
                    batPosDefaut = batPos3;
                } else {
                    System.out.println("Sortie du tableau");
                }
                break;
            case "QUATRE":
                if (batPos3[0][0].getX() + lignesPourDessinerBatiments <= maxX && batPos3[0][0].getY() + colonnesPourDessinerBatiments <= maxY) {
                    batPos4[0][0] = new Case(batPos3[0][0].getX(), batPos3[0][0].getY(), j, "hautgauche");
                    batPos4[0][1] = new Case(batPos3[0][0].getX(), batPos3[0][0].getY() + 1, j, "basgauche");
                    batPos4[1][1] = new Case(batPos3[0][0].getX() + 1, batPos3[0][0].getY() + 1, j, "basmilieu");
                    batPos4[2][1] = new Case(batPos3[0][0].getX() + 2, batPos3[0][0].getY() + 1, j, "basdroite");
                    batPosDefaut = batPos4;
                } else {
                    System.out.println("Sortie du tableau");
                }
                break;
        }
        return batPosDefaut;
    }

}
