/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ouvrier;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 *
 * @author isoyturk
 */
public class Ouvrier {

    private String nomOuvriers = "o";
    private final int maxX = 10;
    private final int maxY = 20;
    private PositionOuvrier posOuvrier;


    /**
     * Constructeur de Ouvrier
     * @param po 
     */
    public Ouvrier(PositionOuvrier po) {
        this.posOuvrier = po;
    }
    
    /**
     * Dessiner sur le canvas pour montrer un ouvrier graphiquement
     * @param s
     * @param posXdeLaCase
     * @param posYdeLaCase 
     */
    public void dessinerOuvrier(Canvas s, int posXdeLaCase, int posYdeLaCase) {
        GraphicsContext gc = s.getGraphicsContext2D();
        gc.setFill(Color.YELLOW);
        gc.setStroke(Color.YELLOW);
        gc.strokeOval(posXdeLaCase, posYdeLaCase, 10, 10);
    }

    /**
     * deplacer un ouvrier vers le bas
     */
    public void deplacerBas() {
        if (posOuvrier.getPosY() + 1 < maxY) {
            posOuvrier.setPosY(posOuvrier.getPosY() + 1);
        }
    }

    /**
     * deplacer un ouvrier vers le haut
     */
    public void deplacerHaut() {
        if (posOuvrier.getPosY() - 1 >= 0) {
            posOuvrier.setPosY(posOuvrier.getPosY() - 1);
        }
    }

    /**
     * deplacer un ouvrier vers la droite
     */
    public void deplacerDroite() {
        if (posOuvrier.getPosX() + 1 < maxX) {
            posOuvrier.setPosX(posOuvrier.getPosX() + 1);
        }
    }

    /**
     * deplacer un ouvrier à gauche
     */
    public void deplacerGauche() {
        if (posOuvrier.getPosX() - 1 >= 0) {
            posOuvrier.setPosX(posOuvrier.getPosX() - 1);
        }
    }

    /**
     * 
     * @return le string de l'ouvrier
     */
    public String getNomOuvrier() {
        return nomOuvriers;
    }

    /**
     * 
     * @return la position de l'ouvrier
     */
    public PositionOuvrier getPosOuvrier() {
        return posOuvrier;
    }

    public void setNomOuvriers(String nomOuvriers) {
        this.nomOuvriers = nomOuvriers;
    }

    
    
}
