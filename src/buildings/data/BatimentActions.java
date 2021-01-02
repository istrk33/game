/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildings.data;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;

/**
 *
 * @author isoyturk
 */
public interface BatimentActions {

    void consommer();

    void produire();

    void action();
    
    void dessinerBatiment(Canvas deckJoueur, int posX, int posY);

}
