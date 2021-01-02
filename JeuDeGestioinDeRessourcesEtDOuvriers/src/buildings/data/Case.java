/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildings.data;

/**
 *
 * @author isoyturk
 */
public class Case {

    private int posXCase;
    private int posYCase;
    private String chaineCharBat;
    private String typeDeCase;

    /**
     * constructeur d'une case
     *
     * @param posXCase
     * @param posYCase
     * @param b
     * @param type
     */
    public Case(int posXCase, int posYCase, String b, String type) {
        this.posXCase = posXCase;
        this.posYCase = posYCase;
        this.chaineCharBat = b;
        this.typeDeCase = type;
    }

    /**
     * getteur du type de la case , si la case est en haut,bas,droite ou gauche
     *
     * @return
     */
    public String getTypeDeCase() {
        return typeDeCase;
    }

    /**
     * getteur de la position x de la case
     *
     * @return
     */
    public int getX() {
        return posXCase;
    }

    /**
     * getteur de la position y de la case
     *
     * @return
     */
    public int getY() {
        return posYCase;
    }

    /**
     * changer la pos x
     *
     * @param posXCase
     */
    public void setPosXCase(int posXCase) {
        this.posXCase = posXCase;
    }

    /**
     * changer la pos y
     *
     * @param posYCase
     */
    public void setPosYCase(int posYCase) {
        this.posYCase = posYCase;
    }

    /**
     * getteur du string du bat
     *
     * @return
     */
    public String getBatimentChaineChar() {
        return chaineCharBat;
    }

    /**
     * verifier si il y a une collision entre cases avant de valider le batiment
     *
     * @param batCase
     * @return
     */
    public boolean collision(Case batCase) {
        return batCase.getX() == this.posXCase && batCase.getY() == this.posYCase;
    }

    /**
     * monter un case
     */
    public void haut() {
        this.posYCase--;
    }

    /**
     * descendre une case
     */
    public void bas() {
        this.posYCase++;
    }

    /**
     * aller à gauche
     */
    public void gauche() {
        this.posXCase--;
    }

    /**
     * aller à droite
     */
    public void droite() {
        this.posXCase++;
    }

    /**
     *changer le string de la case
     * @param chaineCharBat
     */
    public void setChaineCharBat(String chaineCharBat) {
        this.chaineCharBat = chaineCharBat;
    }

}
