/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildings.data;

import PlateauDeJeu.Cellule;
import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;

/**
 *
 * @author isoyturk
 */
public class LBatiment extends Batiment implements BatimentActions {

    private String l = "l";
    private final int lignesPourDessinerBatiments = 3;
    private final int colonnesPourDessinerBatiments = 2;
    private String[][] tableauCases = new String[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];

    public LBatiment(String nomBatiment, int nombreDeBatiment, int prix, int consomation, int production) {
        super(nomBatiment, nombreDeBatiment, prix, consomation, production);
        cases = new Case[]{new Case(0, 0, l,"ref"), new Case(0, 1, l,"bas"), new Case(0, 2, l,"bas"), new Case(1, 2, l,"bas")};
        tableauCases[0][0] = "l";
        tableauCases[0][1] = "l";
        tableauCases[0][2] = "l";
        tableauCases[1][0] = "n";
        tableauCases[1][1] = "n";
        tableauCases[1][2] = "l";
        largeur = colonnesPourDessinerBatiments;
        hauteur = lignesPourDessinerBatiments;
    }

    @Override
    public void consommer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void produire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getStrBatiment() {
        return l;
    }

    @Override
    public void dessinerBatiment(Canvas deckJoueur, int posX, int posY) {
        for (int i = 0; i < colonnesPourDessinerBatiments; i++) {
            for (int j = 0; j < lignesPourDessinerBatiments; j++) {
                if ("l".equals(tableauCases[i][j])) {
                    Cellule c = new Cellule();
                    c.dessinerCellule(deckJoueur, posX + (c.recupTailleCote() + 1) * i, posY + (c.recupTailleCote() + 1) * j, Color.BLACK, Color.CRIMSON);
                }
            }
        }
    }

}
