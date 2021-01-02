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
public class ZBatiment extends Batiment {

    private final String z = "z";
    private final int lignesPourDessinerBatiments = 2;
    private final int colonnesPourDessinerBatiments = 3;
    private String[][] tableauCases = new String[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];

    /**
     * constructeur d'un zblock
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
    public ZBatiment(String nomBatiment, int nombreDeBatiment, int prix, int consoNRJ, int prodMatériaux, int prodNRJ, String action, String charBat) {
        super(nomBatiment, nombreDeBatiment, prix, consoNRJ, prodMatériaux, prodNRJ, action, charBat);
        batPos1 = new Case[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];
        batPos1[0][0] = new Case(0, 0, z, "hautgauche");
        batPos1[1][0] = new Case(1, 0, z, "hautmilieu");
        batPos1[1][1] = new Case(1, 1, z, "basmilieu");
        batPos1[2][1] = new Case(2, 1, z, "basdroite");

        batPos2 = new Case[lignesPourDessinerBatiments][colonnesPourDessinerBatiments];

        tableauCases[0][0] = "z";
        tableauCases[1][0] = "z";
        tableauCases[2][0] = "n";
        tableauCases[0][1] = "n";
        tableauCases[1][1] = "z";
        tableauCases[2][1] = "z";

        directionBatiment = "UN";
        batPosDefaut = batPos1;
    }

    /**
     * récupérer le string du batiment
     *
     * @return
     */
    public String getStrBatiment() {
        return z;
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
                if ("z".equals(tableauCases[i][j])) {
                    Cellule c = new Cellule();
                    c.dessinerCelluleSansOuvrier(deckJoueur, posX + (c.recupTailleCote() + 1) * i, posY + (c.recupTailleCote() + 1) * j, Color.BLACK, Color.AQUAMARINE);
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
                if (batPos2[0][1].getX() + colonnesPourDessinerBatiments <= maxX && batPos2[1][0].getY() + lignesPourDessinerBatiments <= maxY) {
                    batPos1[0][0].setPosXCase(batPos2[1][0].getX() - 1);
                    batPos1[0][0].setPosYCase(batPos2[1][0].getY());
                    batPos1[1][0].setPosXCase(batPos2[1][0].getX());
                    batPos1[1][0].setPosYCase(batPos2[1][0].getY());
                    batPos1[1][1].setPosXCase(batPos2[1][0].getX());
                    batPos1[1][1].setPosYCase(batPos2[1][0].getY() + 1);
                    batPos1[2][1].setPosXCase(batPos2[1][0].getX() + 1);
                    batPos1[2][1].setPosYCase(batPos2[1][0].getY() + 1);
                    batPosDefaut = batPos1;
                } else {
                    System.out.println("Sortie du tableau");
                }
                break;
            case "DEUX":
                if (batPos1[0][0].getX() + lignesPourDessinerBatiments <= maxX && batPos1[0][0].getY() + colonnesPourDessinerBatiments <= maxY) {
                    batPos2[0][1] = new Case(batPos1[0][0].getX(), batPos1[1][1].getY(), z, "milieugauche");
                    batPos2[0][2] = new Case(batPos2[0][1].getX(), batPos2[0][1].getY() + 1, z, "basgauche");
                    batPos2[1][1] = new Case(batPos2[0][1].getX() + 1, batPos2[0][1].getY(), z, "milieudroite");
                    batPos2[1][0] = new Case(batPos2[0][1].getX() + 1, batPos2[0][1].getY() - 1, z, "hautdroite");
                    batPosDefaut = batPos2;
                } else {
                    System.out.println("Sortie du tableau");
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
