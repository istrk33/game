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
public class OBatiment extends Batiment {

    private final String o = "O";
    private final int lignesPourDessinerBatiments = 2;
    private final int colonnesPourDessinerBatiments = 2;
    private String[][] tableauCases = new String[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];

    /**
     * constructeur d'un oblock
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
    public OBatiment(String nomBatiment, int nombreDeBatiment, int prix, int consoNRJ, int prodMatériaux, int prodNRJ, String action, String charBat) {
        super(nomBatiment, nombreDeBatiment, prix, consoNRJ, prodMatériaux, prodNRJ, action, charBat);
        batPosDefaut = new Case[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];
        batPosDefaut[0][0] = new Case(0, 0, o, "hautgauche");
        batPosDefaut[0][1] = new Case(0, 1, o, "hautdroite");
        batPosDefaut[1][0] = new Case(1, 0, o, "basgauche");
        batPosDefaut[1][1] = new Case(1, 1, o, "basdroite");

        tableauCases[0][0] = "o";
        tableauCases[0][1] = "o";
        tableauCases[1][0] = "o";
        tableauCases[1][1] = "o";
    }

    /**
     * récupérer le string du batiment
     *
     * @return
     */
    public String getStrBatiment() {
        return o;
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
                if ("o".equals(tableauCases[i][j])) {
                    Cellule c = new Cellule();
                    c.dessinerCelluleSansOuvrier(deckJoueur, posX + (c.recupTailleCote() + 1) * i, posY + (c.recupTailleCote() + 1) * j, Color.BLACK, Color.YELLOWGREEN);
                }
            }
        }
    }

    /**
     * pivoter le batiment,ne rien faire
     *
     * @return
     */
    @Override
    public Case[][] pivoterBatiment() {
        return batPosDefaut;
    }

    /**
     * changer la direction,ne rien faire
     */
    @Override
    public void setDirectionBatiment() {
    }
}
