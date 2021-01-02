/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;

import Joueur.Joueur;
import buildings.data.Batiment;
import buildings.data.IBatiment;
import buildings.data.JBatiment;
import buildings.data.LBatiment;
import buildings.data.OBatiment;
import buildings.data.SBatiment;
import buildings.data.TBatiment;
import buildings.data.ZBatiment;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author isoyturk
 */
public class GameLogic {

    private ArrayList<Batiment> batimentsSansDoublons = new ArrayList<>();
    private ArrayList<Batiment> toutLesBatiments = new ArrayList<>();
    private ArrayList<Batiment> batimentsDuDeck = new ArrayList<>();
    private ArrayList<Batiment> batimentDuPlateau = new ArrayList<>();
    private int nbBatimentPlateau;
    Joueur j = new Joueur(1, 0);

    public void ajouterToutLesBatiments() {
        Batiment iBatiment = new IBatiment("I-Batiment", 25, 4, 1, 2);
        Batiment oBatiment = new OBatiment("O-Batiment", 10, 8, 0, 0);
        Batiment tBatiment = new TBatiment("T-Batiment", 30, 2, 0, 2);
        Batiment lBatiment = new LBatiment("L-Batiment", 20, 8, 1, 0);
        Batiment jBatiment = new JBatiment("J-Batiment", 10, 8, 4, 0);
        Batiment sBatiment = new SBatiment("S-Batiment", 30, 2, 0, 1);
        Batiment zBatiment = new ZBatiment("Z-Batiment", 10, 2, 1, 0);
        batimentsSansDoublons.add(iBatiment);
        batimentsSansDoublons.add(oBatiment);
        batimentsSansDoublons.add(tBatiment);
        batimentsSansDoublons.add(lBatiment);
        batimentsSansDoublons.add(jBatiment);
        batimentsSansDoublons.add(sBatiment);
        batimentsSansDoublons.add(zBatiment);

        batimentsSansDoublons.forEach((b) -> {
            for (int i = 0; i < b.getNombreDuBatiment(); i++) {
                toutLesBatiments.add(b);
            }
        });
    }

    public void ajouterBatimentAleatDansLeDeck() {
        int tailleListeToutLesBatiments = toutLesBatiments.size();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            Batiment b;
            b = toutLesBatiments.get(r.nextInt(tailleListeToutLesBatiments));
            batimentsDuDeck.add(b);
        }
    }

    public ArrayList<Batiment> recupererBatimentSDuDeck() {
        return batimentsDuDeck;
    }

    public ArrayList<Batiment> batimentsSansDoublons() {
        return batimentsSansDoublons;
    }

    public ArrayList<Batiment> recupererBatimentsDuPlateau() {
        return batimentDuPlateau;
    }

    public void ajouterBatimentPlateau(String nomBatiment) {
        Batiment aSupprimer = null;
        for (Batiment b : batimentsDuDeck) {
            if (b.getNomBatiment().equals(nomBatiment)) {
                aSupprimer = b;
                batimentDuPlateau.add(b);
            }
        }
            batimentsDuDeck.remove(aSupprimer);
    }

    public ArrayList<Batiment> getToutLesBatiments() {
        return toutLesBatiments;
    }

    public Joueur getJoueur() {
        return j;
    }

    public void tourSuivant() {
        j.tourSuivant();
    }

    public int recupererTourCourrant() {
        return j.recupererTourCourrant();
    }

    public int recupererScore() {
        return j.recupererScore();
    }

    public int recupererMateriel() {
        return j.recupererMateriel();
    }

    public int recupererEnergie() {
        return j.recupererEnergie();
    }

    public int recupererOuvriersPlateau() {
        return j.recupererOuvrierPlateau();
    }

    public int recupererOuvrierExterieur() {
        return j.recupererOuvrierExterieur();
    }
}
