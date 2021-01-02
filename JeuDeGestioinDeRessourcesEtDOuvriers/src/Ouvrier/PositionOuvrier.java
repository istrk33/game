/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ouvrier;

/**
 *
 * @author isoyturk
 */
public class PositionOuvrier {
    private int posX;
    private int posY;

    /**
     * Constructeur de position
     * @param posX
     * @param posY 
     */
    public PositionOuvrier(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    /**
     * getteur de l'abscisse
     * @return 
     */
    public int getPosX() {
        return posX;
    }

    /**
     * getteur de l'ordonnée
     * @return 
     */
    public int getPosY() {
        return posY;
    }

    /**
     * setteur de l'abscisse
     * @param posX 
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * setteur de l'ordonné
     * @param posY 
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    
}
