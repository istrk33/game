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
public class LBatiment extends Batiment {

    private final String l = "l";
    private final int lignesPourDessinerBatiments = 3;
    private final int colonnesPourDessinerBatiments = 2;
    private String[][] tableauCases = new String[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];

    /**
     * constructeur d'un lblock
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
    public LBatiment(String nomBatiment, int nombreDeBatiment, int prix, int consoNRJ, int prodMatériaux, int prodNRJ, String action, String charBat) {
        super(nomBatiment, nombreDeBatiment, prix, consoNRJ, prodMatériaux, prodNRJ, action, charBat);
        batPos1 = new Case[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];
        batPos1[0][0] = new Case(0, 0, l, "hautgauche");
        batPos1[0][1] = new Case(0, 1, l, "milieugauche");
        batPos1[0][2] = new Case(0, 2, l, "basgauche");
        batPos1[1][2] = new Case(1, 2, l, "basdroite");

        batPos2 = new Case[lignesPourDessinerBatiments][colonnesPourDessinerBatiments];

        batPos3 = new Case[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];

        batPos4 = new Case[lignesPourDessinerBatiments][colonnesPourDessinerBatiments];

        tableauCases[0][0] = "l";
        tableauCases[0][1] = "l";
        tableauCases[0][2] = "l";
        tableauCases[1][0] = "n";
        tableauCases[1][1] = "n";
        tableauCases[1][2] = "l";

        directionBatiment = "UN";
        batPosDefaut = batPos1;
    }

    /**
     * récupérer le string du batiment
     *
     * @return
     */
    public String getStrBatiment() {
        return l;
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
                if ("l".equals(tableauCases[i][j])) {
                    Cellule c = new Cellule();
                    c.dessinerCelluleSansOuvrier(deckJoueur, posX + (c.recupTailleCote() + 1) * i, posY + (c.recupTailleCote() + 1) * j, Color.BLACK, Color.CRIMSON);
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
                    batPos1[0][0] = new Case(batPos4[0][0].getX(), batPos4[0][0].getY(), l, "hautgauche");
                    batPos1[0][1] = new Case(batPos4[0][0].getX(), batPos4[0][0].getY() + 1, l, "milieugauche");
                    batPos1[0][2] = new Case(batPos4[0][0].getX(), batPos4[0][0].getY() + 2, l, "basgauche");
                    batPos1[1][2] = new Case(batPos4[0][0].getX() + 1, batPos4[0][0].getY() + 2, l, "basdroite");
                    batPosDefaut = batPos1;
                } else {
                    System.out.println("Sortie du tableau");
                }
                break;
            case "DEUX":
                if (batPos1[0][0].getX() + lignesPourDessinerBatiments <= maxX && batPos1[0][0].getY() + colonnesPourDessinerBatiments <= maxY) {
                    batPos2[2][0] = new Case(batPos1[0][0].getX() + 2, batPos1[0][0].getY(), l, "hautdroite");
                    batPos2[2][1] = new Case(batPos1[0][0].getX() + 2, batPos1[0][0].getY() + 1, l, "basdroite");
                    batPos2[1][1] = new Case(batPos1[0][0].getX() + 1, batPos1[0][0].getY() + 1, l, "basmilieu");
                    batPos2[0][1] = new Case(batPos1[0][0].getX(), batPos1[0][0].getY() + 1, l, "basgauche");
                    batPosDefaut = batPos2;
                } else {
                    System.out.println("Sortie du tableau");
                }
                break;
            case "TROIS":
                if (batPos2[0][1].getX() + colonnesPourDessinerBatiments <= maxX && batPos2[2][0].getY() + lignesPourDessinerBatiments <= maxY) {
                    batPos3[0][0] = new Case(batPos2[0][1].getX(), batPos2[0][1].getY() - 1, l, "hautgauche");
                    batPos3[1][0] = new Case(batPos2[0][1].getX() + 1, batPos2[0][1].getY() - 1, l, "hautdroite");
                    batPos3[1][1] = new Case(batPos2[0][1].getX() + 1, batPos2[0][1].getY(), l, "milieudroite");
                    batPos3[1][2] = new Case(batPos2[0][1].getX() + 1, batPos2[0][1].getY() + 1, l, "basdroite");
                    batPosDefaut = batPos3;
                } else {
                    System.out.println("Sortie du tableau");
                }
                break;
            case "QUATRE":
                if (batPos3[0][0].getX() + lignesPourDessinerBatiments <= maxX && batPos3[0][0].getY() + colonnesPourDessinerBatiments <= maxY) {
                    batPos4[0][0] = new Case(batPos3[0][0].getX(), batPos3[0][0].getY(), l, "hautgauche");
                    batPos4[0][1] = new Case(batPos3[0][0].getX(), batPos3[0][0].getY() + 1, l, "basgauche");
                    batPos4[1][0] = new Case(batPos3[0][0].getX() + 1, batPos3[0][0].getY(), l, "hautmilieu");
                    batPos4[2][0] = new Case(batPos3[0][0].getX() + 2, batPos3[0][0].getY(), l, "hautdroite");
                    batPosDefaut = batPos4;
                } else {
                    System.out.println("Sortie du tableau");
                }
                break;
        }
        return batPosDefaut;
    }

}
