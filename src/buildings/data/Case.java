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

    public Case(int posXCase, int posYCase, String b, String type) {
        this.posXCase = posXCase;
        this.posYCase = posYCase;
        this.chaineCharBat = b;
        this.typeDeCase = type;
    }

    public String getTypeDeCase() {
        return typeDeCase;
    }

    public int getX() {
        return posXCase;
    }

    public int getY() {
        return posYCase;
    }

    public void setPosXCase(int posXCase) {
        this.posXCase = posXCase;
    }

    public void setPosYCase(int posYCase) {
        this.posYCase = posYCase;
    }

    public String getBatimentChaineChar() {
        return chaineCharBat;
    }

    public boolean collision(Case batCase) {
        return batCase.getX() == this.posXCase && batCase.getY() == this.posYCase;
    }

    public void haut() {
        this.posYCase--;
    }

    public void bas() {
        this.posYCase++;
    }

    public void gauche() {
        this.posXCase--;
    }

    public void droite() {
        this.posXCase++;
    }

}
