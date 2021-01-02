/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlateauDeJeu;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;

/**
 *
 * @author isoyturk
 */
public class Cellule {

    private final int coteCellule = 20;
    int x, y;

    /**
     * Dessiner les cases des batiments sans ouvriers
     * @param s
     * @param x
     * @param y
     * @param couleurTraits
     * @param couleurFond 
     */
    public void dessinerCelluleSansOuvrier(Canvas s, int x, int y, Color couleurTraits, Color couleurFond) {
        GraphicsContext gc = s.getGraphicsContext2D();
        gc.setFill(couleurFond);
        gc.setStroke(couleurTraits);
        gc.strokeRect(x, y, coteCellule, coteCellule);
        gc.fillRect(x, y, coteCellule, coteCellule);
    }

    /**
     * dessiner les cases des batiments avec des ouvriers
     * @param s
     * @param x
     * @param y
     * @param couleurTraits
     * @param couleurFond 
     */
    public void dessinerCelluleAvecOuvrier(Canvas s, int x, int y, Color couleurTraits, Color couleurFond) {
        GraphicsContext gc = s.getGraphicsContext2D();
        gc.setFill(couleurFond);
        gc.setStroke(couleurTraits);
        gc.strokeRect(x, y, coteCellule, coteCellule);
        gc.fillRect(x, y, coteCellule, coteCellule);
        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(x+3, y+3, coteCellule-6, coteCellule-6);
        gc.fillOval(x+3, y+3, coteCellule-6, coteCellule-6);
    }
    
        /**
     * dessiner les cases des batiments avec des ouvriers
     * @param s
     * @param x
     * @param y
     * @param couleurTraits
     * @param couleurFond 
     */
    public void dessinerCelluleAvecOuvrierDeplacement(Canvas s, int x, int y, Color couleurTraits, Color couleurFond) {
        GraphicsContext gc = s.getGraphicsContext2D();
        gc.setFill(couleurFond);
        gc.setStroke(couleurTraits);
        gc.strokeRect(x, y, coteCellule, coteCellule);
        gc.fillRect(x, y, coteCellule, coteCellule);
        gc.setFill(Color.DEEPPINK);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(x+3, y+3, coteCellule-6, coteCellule-6);
        gc.fillOval(x+3, y+3, coteCellule-6, coteCellule-6);
    }
    
    

    /**
     * getteur du côté d'une cellule
     * @return 
     */
    public int recupTailleCote() {
        return coteCellule;
    }
}
