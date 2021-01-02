/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlateauDeJeu;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.canvas.Canvas;
import sun.java2d.loops.FillRect;

/**
 *
 * @author isoyturk
 */
     public class Cellule {

    private final int coteCellule = 20;
    int x, y;
  
    public void dessinerCellule(Canvas s, int x, int y, Color couleurTraits, Color couleurFond) {
        GraphicsContext gc = s.getGraphicsContext2D();
        gc.setFill(couleurFond);
        gc.setStroke(couleurTraits);
        gc.strokeRect(x, y, coteCellule, coteCellule);
        gc.fillRect(x, y, coteCellule, coteCellule);
    }

    public int recupTailleCote() {
        return coteCellule;
    }
}
