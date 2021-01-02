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
public class JBatiment extends Batiment implements BatimentActions {

    private String j = "j";
    private final int lignesPourDessinerBatiments = 3;
    private final int colonnesPourDessinerBatiments = 2;
    private String[][] tableauCases = new String[colonnesPourDessinerBatiments][lignesPourDessinerBatiments];

    public JBatiment(String nomBatiment, int nombreDeBatiment, int prix, int consomation, int production) {
        super(nomBatiment, nombreDeBatiment, prix, consomation, production);
        cases = new Case[]{new Case(1, 0, j, "ref"), new Case(1, 1, j, "bas"), new Case(1, 2, j, "bas"), new Case(0, 2, j, "bas")};
        tableauCases[0][0] = "n";
        tableauCases[0][1] = "n";
        tableauCases[0][2] = "j";
        tableauCases[1][0] = "j";
        tableauCases[1][1] = "j";
        tableauCases[1][2] = "j";

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
        return j;
    }

    @Override
    public void deplacerADroite() {
        int maxX = 10;
        Case reference = null;
        for (Case c : cases) {
            if (c.getTypeDeCase().equals("ref")) {
                reference = c;
            }
        }
        if (reference.getX() + largeur  <= maxX) {
            for (Case c : cases) {
                c.droite();
            }
        }
    }

    @Override
    public void deplacerAGauche() {
        Case reference = null;
        for (Case c : cases) {
            if (c.getTypeDeCase().equals("ref")) {
                reference = c;
            }
        }
        if (reference.getX() - 1 > 0) {
            for (Case c : cases) {
                c.gauche();
            }
        }
    }

    @Override
    public void deplacerEnHaut() {
        Case reference = null;
        for (Case c : cases) {
            if (c.getTypeDeCase().equals("ref")) {
                reference = c;
            }
        }
        if (reference.getY() - 1 >= 0) {
            for (Case c : cases) {
                c.haut();
            }
        }
    }

    @Override
    public void deplacerEnBas() {
        int maxY = 20;
        Case reference = null;
        for (Case c : cases) {
            if (c.getTypeDeCase().equals("ref")) {
                reference = c;
            }
        }
        if (reference.getY() +hauteur < maxY) {
            for (Case c : cases) {
                c.bas();
                System.out.println(c.getX()+" "+c.getY()+" "+c.getTypeDeCase());
            }
        }
    }

    @Override
    public void dessinerBatiment(Canvas deckJoueur, int posX, int posY) {
        for (int i = 0; i < colonnesPourDessinerBatiments; i++) {
            for (int j = 0; j < lignesPourDessinerBatiments; j++) {
                if ("j".equals(tableauCases[i][j])) {
                    Cellule c = new Cellule();
                    c.dessinerCellule(deckJoueur, posX + (c.recupTailleCote() + 1) * i, posY + (c.recupTailleCote() + 1) * j, Color.BLACK, Color.DARKORCHID);
                }
            }
        }
    }
}
