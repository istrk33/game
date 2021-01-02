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
public class SBatiment extends Batiment {

    private final String s = "s";
    private final int lignesPourDessinerBatiments = 2;
    private final int colonnesPourDessinerBatiments = 3;
    private String[][] tableauCases = new String[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];

    /**
     * constructeur d'un sblock
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
    public SBatiment(String nomBatiment, int nombreDeBatiment, int prix, int consoNRJ, int prodMatériaux, int prodNRJ, String action, String charBat) {
        super(nomBatiment, nombreDeBatiment, prix, consoNRJ, prodMatériaux, prodNRJ, action, charBat);
        batPos1 = new Case[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];
        batPos1[1][0] = new Case(1, 0, s, "hautmilieu");
        batPos1[2][0] = new Case(2, 0, s, "hautdroite");
        batPos1[0][1] = new Case(0, 1, s, "basgauche");
        batPos1[1][1] = new Case(1, 1, s, "basmilieu");

        batPos2 = new Case[lignesPourDessinerBatiments][colonnesPourDessinerBatiments];

        tableauCases[0][0] = "n";
        tableauCases[1][0] = "s";
        tableauCases[2][0] = "s";
        tableauCases[0][1] = "s";
        tableauCases[1][1] = "s";
        tableauCases[2][1] = "n";

        directionBatiment = "UN";
        batPosDefaut = batPos1;
    }

    /**
     * récupérer le string du batiment
     *
     * @return
     */
    public String getStrBatiment() {
        return s;
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
                if ("s".equals(tableauCases[i][j])) {
                    Cellule c = new Cellule();
                    c.dessinerCelluleSansOuvrier(deckJoueur, posX + (c.recupTailleCote() + 1) * i, posY + (c.recupTailleCote() + 1) * j, Color.BLACK, Color.DARKTURQUOISE);
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
                    batPos1[1][0].setPosXCase(batPos2[1][1].getX());
                    batPos1[1][0].setPosYCase(batPos2[0][0].getY());
                    batPos1[2][0].setPosXCase(batPos2[1][1].getX() + 1);
                    batPos1[2][0].setPosYCase(batPos2[0][0].getY());
                    batPos1[0][1].setPosXCase(batPos2[1][1].getX() - 1);
                    batPos1[0][1].setPosYCase(batPos2[0][0].getY() + 1);
                    batPos1[1][1].setPosXCase(batPos2[1][1].getX());
                    batPos1[1][1].setPosYCase(batPos2[0][0].getY() + 1);
                    batPosDefaut = batPos1;
                } else {
                    System.out.println("Sortie du tableau");
                }
                break;
            case "DEUX":
                if (batPos1[0][1].getX() + lignesPourDessinerBatiments <= maxX && batPos1[1][0].getY() + colonnesPourDessinerBatiments <= maxY) {
                    batPos2[0][0] = new Case(batPos1[0][1].getX(), batPos1[1][0].getY(), s, "gauchehaut");
                    batPos2[0][1] = new Case(batPos1[0][1].getX(), batPos1[1][0].getY() + 1, s, "gauchemilieu");
                    batPos2[1][1] = new Case(batPos1[0][1].getX() + 1, batPos1[1][0].getY() + 1, s, "droitemilieu");
                    batPos2[1][2] = new Case(batPos1[0][1].getX() + 1, batPos1[1][0].getY() + 2, s, "droitebas");
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
