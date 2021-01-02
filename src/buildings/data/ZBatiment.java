/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildings.data;

import PlateauDeJeu.Cellule;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import java.util.ArrayList;

/**
 *
 * @author isoyturk
 */
public class ZBatiment extends Batiment implements BatimentActions {

    private String z = "z";
    private final int lignesPourDessinerBatiments = 2;
    private final int colonnesPourDessinerBatiments = 3;
    private String[][] tableauCases = new String[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];

    public ZBatiment(String nomBatiment, int nombreDeBatiment, int prix, int consomation, int production) {
        super(nomBatiment, nombreDeBatiment, prix, consomation, production);
        cases = new Case[]{new Case(0, 0, z, "ref"), new Case(1, 0, z, "bas"), new Case(1, 1, z, "bas"), new Case(2, 1, z, "bas")};
        tableauCases[0][0] = "z";
        tableauCases[1][0] = "z";
        tableauCases[2][0] = "n";
        tableauCases[0][1] = "n";
        tableauCases[1][1] = "z";
        tableauCases[2][1] = "z";
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
        return z;
    }

    @Override
    public void dessinerBatiment(Canvas deckJoueur, int posX, int posY) {
        for (int i = 0; i < colonnesPourDessinerBatiments; i++) {
            for (int j = 0; j < lignesPourDessinerBatiments; j++) {
                if ("z".equals(tableauCases[i][j])) {
                    Cellule c = new Cellule();
                    c.dessinerCellule(deckJoueur, posX + (c.recupTailleCote() + 1) * i, posY + (c.recupTailleCote() + 1) * j, Color.BLACK, Color.AQUAMARINE);
                }
            }
        }

    }
}
