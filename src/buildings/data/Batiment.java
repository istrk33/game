/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildings.data;

import PlateauDeJeu.Cellule;

/**
 *
 * @author isoyturk
 */
public abstract class Batiment {

    private final String nomBatiment;
    private final int nombreDuBatiment;
    private final int prixEtRessource;
    private final int consomation;
    private final int production;
    private final int maxX = 10;
    private final int maxY = 20;
    int largeur;
    int hauteur;
    Cellule[] cellules = new Cellule[4];
    Case[] cases;

    public Batiment(String nomBatiment, int nombreDeBatiment, int prix, int consomation, int production) {
        this.nombreDuBatiment = nombreDeBatiment;
        this.prixEtRessource = prix;
        this.consomation = consomation;
        this.production = production;
        this.nomBatiment = nomBatiment;

    }

    public String getNomBatiment() {
        return nomBatiment;
    }

    public int getNombreDuBatiment() {
        return nombreDuBatiment;
    }

    public int getPrixEtRessource() {
        return prixEtRessource;
    }

    public int getConsomation() {
        return consomation;
    }

    public int getProduction() {
        return production;
    }

    public void deplacerADroite() {
        Case reference = null;
        for (Case c : cases) {
            if (c.getTypeDeCase().equals("ref")) {
                reference = c;
            }
        }
        if (reference.getX() + largeur + 1 <= maxX) {
            for (Case c : cases) {
                c.droite();
            }
        }
    }

    public void deplacerAGauche() {
        Case reference = null;
        for (Case c : cases) {
            if (c.getTypeDeCase().equals("ref")) {
                reference = c;
            }
        }
        if (reference.getX() - 1 >= 0) {
            for (Case c : cases) {
                c.gauche();
            }
        }
    }

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

    public void deplacerEnBas() {
        Case reference = null;
        for (Case c : cases) {
            if (c.getTypeDeCase().equals("ref")) {
                reference = c;
            }
        }
        if (reference.getY() + hauteur + 1 <= maxY) {
            for (Case c : cases) {
                c.bas();
            }
        }
    }

  /*  public void pivoterBatiment(){

        //first change the dimensions vertical length for horizontal length
        //and viceversa
        Case[][] newArray = new Case[5][8];

        //invert values 90 degrees clockwise by starting from button of
        //array to top and from left to right
        int ii = 0;
        int jj = 0;
        for(int i=0; i<9; i++){
            for(int j=cases.length-1; j>=0; j--){
                newArray[ii][jj] = cases[i][j];

                jj++;
            }
            ii++;
        }

      //  return newArray;
    
    }*/
   
    public Case[] recupCases() {
        return cases;
    }

}
