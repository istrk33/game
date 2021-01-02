/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Joueur;

/**
 *
 * @author isoyturk
 */
public class Joueur {

    private int idJoueur;
    private int tourCourrant = 1;
    private final int nbToursMax = 30;
    private int score;
    private int nbOuvriersPlateau = 0;
    private int nbOuvriersExterieur = 8;
    private int materiels = 8;
    private int energie = 16;
    private int batimentSurPlateau=0;

    public Joueur(int idJoueur, int score) {
        this.idJoueur = idJoueur;
        this.score = score;
    }

    public void tourSuivant() {
        if (tourCourrant < nbToursMax) {
            tourCourrant++;
        }
    }

    public int recupererTourCourrant() {
        return tourCourrant;
    }

    public int recupererMateriel() {
        return materiels;
    }

    public int recupererEnergie() {
        return energie;
    }

    public int recupererScore() {
        score=(1*materiels)+(1*energie)+(2*nbOuvriersExterieur)+(4*nbOuvriersPlateau)+(8*batimentSurPlateau);
        return score;
    }

    public int recupererOuvrierPlateau() {
        return nbOuvriersPlateau;
    }

    public int recupererOuvrierExterieur() {
        return nbOuvriersExterieur;
    }

}
