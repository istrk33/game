/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameLogic;

import Ouvrier.Ouvrier;
import Ouvrier.PositionOuvrier;
import buildings.data.Batiment;
import buildings.data.IBatiment;
import buildings.data.JBatiment;
import buildings.data.LBatiment;
import buildings.data.OBatiment;
import buildings.data.SBatiment;
import buildings.data.TBatiment;
import buildings.data.ZBatiment;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author isoyturk
 */
public class GameLogic implements Serializable{

    private int tourCourrant = 1;
    private final int nbToursMax = 30;
    private int scorePartie = 0;
    private int nbOuvriersPlateau = 0;
    private int nbOuvriersExterieur = 8;
    private int materiaux = 8;
    private int energie = 16;
    private int batimentSurPlateau = 0;
    private int nbBatimentPile;
    private Ouvrier aAjtPlateau;

    private ArrayList<Batiment> batimentsSansDoublons = new ArrayList<>();
    private ArrayList<Batiment> toutLesBatiments = new ArrayList<>();
    private ArrayList<Batiment> batimentsDeLaMain = new ArrayList<>();
    private ArrayList<Batiment> batimentDuPlateau = new ArrayList<>();
    private ArrayList<Ouvrier> ouvriersPlateau = new ArrayList<>();
    private ArrayList<Ouvrier> ouvriersExterieur = new ArrayList<>();

    /**
     * initialiser la logique du jeu
     */
    public void ajouterToutLesBatiments() {
        Batiment iBatiment = new IBatiment("I-Batiment", 25, 4, 1, 2, 0, "Usine", "i");// Produire 2 Matériaux");
        Batiment oBatiment = new OBatiment("O-Batiment", 10, 8, 0, 0, 0, "Parc", "O");//: Modifier l'emplacement d'un ouvrier librement");
        Batiment tBatiment = new TBatiment("T-Batiment", 30, 2, 0, 0, 2, "Panneau solaire", "t");// : Produit 2 énergies chaque tours");
        Batiment lBatiment = new LBatiment("L-Batiment", 20, 8, 1, 0, 0, "Apartement", "l"); //: Ajouter un nouvel ouvrier sur un batiment avec 2 ouvriers");
        Batiment jBatiment = new JBatiment("J-Batiment", 10, 8, 4, 0, 0, "Laboratoire", "j"); //: Ajoute un batiment de la pile");
        Batiment sBatiment = new SBatiment("S-Batiment", 30, 2, 0, 1, 0, "Mine", "s"); //: Produit 1 matériel");
        Batiment zBatiment = new ZBatiment("Z-Batiment", 10, 2, 1, 0, 0, "Décharge", "z"); //: Prend un batiment non souhaité le met au bas de la pile");
        batimentsSansDoublons.add(iBatiment);
        batimentsSansDoublons.add(oBatiment);
        batimentsSansDoublons.add(tBatiment);
        batimentsSansDoublons.add(lBatiment);
        batimentsSansDoublons.add(jBatiment);
        batimentsSansDoublons.add(sBatiment);
        batimentsSansDoublons.add(zBatiment);

        for (Batiment bat : batimentsSansDoublons) {
            switch (bat.getNomBatiment()) {
                case "I-Batiment":
                    for (int i = 0; i < bat.getNombreDuBatiment(); i++) {
                        Batiment ib = new IBatiment("I-Batiment", 25, 4, 1, 2, 0, "Usine", "i");
                        toutLesBatiments.add(ib);
                    }
                    break;
                case "O-Batiment":
                    for (int i = 0; i < bat.getNombreDuBatiment(); i++) {
                        Batiment ob = new OBatiment("O-Batiment", 10, 8, 0, 0, 0, "Parc", "O");
                        toutLesBatiments.add(ob);
                    }
                    break;
                case "T-Batiment":
                    for (int i = 0; i < bat.getNombreDuBatiment(); i++) {
                        Batiment tb = new TBatiment("T-Batiment", 30, 2, 0, 0, 2, "Panneau solaire", "t");
                        toutLesBatiments.add(tb);
                    }
                    break;
                case "L-Batiment":
                    for (int i = 0; i < bat.getNombreDuBatiment(); i++) {
                        Batiment lb = new LBatiment("L-Batiment", 20, 8, 1, 0, 0, "Apartement", "l");
                        toutLesBatiments.add(lb);
                    }
                    break;
                case "J-Batiment":
                    for (int i = 0; i < bat.getNombreDuBatiment(); i++) {
                        Batiment jb = new JBatiment("J-Batiment", 10, 8, 4, 0, 0, "Laboratoire", "j");
                        toutLesBatiments.add(jb);
                    }
                    break;
                case "S-Batiment":
                    for (int i = 0; i < bat.getNombreDuBatiment(); i++) {
                        Batiment sb = new SBatiment("S-Batiment", 30, 2, 0, 1, 0, "Mine", "s");
                        toutLesBatiments.add(sb);
                    }
                    break;
                case "Z-Batiment":
                    for (int i = 0; i < bat.getNombreDuBatiment(); i++) {
                        Batiment zb = new ZBatiment("Z-Batiment", 10, 2, 1, 0, 0, "Décharge", "z");
                        toutLesBatiments.add(zb);
                    }
                    break;
            }
        }

        for (int i = 0; i < nbOuvriersExterieur; i++) {
            Ouvrier o = new Ouvrier(new PositionOuvrier(0, 0));
            ouvriersExterieur.add(o);
        }
    }

    /**
     * hetteur nbOuvriers plateau
     *
     * @return
     */
    public int getNbOuvriersPlateau() {
        return nbOuvriersPlateau;
    }

    /**
     * getteur nb ouvrier exterieur
     *
     * @return
     */
    public int getNbOuvriersExterieur() {
        return nbOuvriersExterieur;
    }

    /**
     * getteur nb énergie
     *
     * @return
     */
    public int getEnergie() {
        return energie;
    }

    /**
     * getteur nb bat plateau
     *
     * @return
     */
    public int getBatimentSurPlateau() {
        return batimentSurPlateau;
    }

    /**
     * getteur nb bat main
     *
     * @return
     */
    public ArrayList<Batiment> getBatimentsMain() {
        return batimentsDeLaMain;
    }

    /**
     * setteur score de la partie
     *
     * @param scorePartie
     */
    public void setScorePartie(int scorePartie) {
        this.scorePartie = scorePartie;
    }

    /**
     * ajouter 1 aux batiment du plateau
     */
    public void setNbBatimentSurPlateau() {
        batimentSurPlateau += 1;
    }

    /**
     * setteur nb ouvriers sur plateau
     *
     * @param nbOuvriersPlateau
     */
    public void setNbOuvriersPlateau(int nbOuvriersPlateau) {
        this.nbOuvriersPlateau = nbOuvriersPlateau;
    }

    /**
     * setteur nb ouvrier exterieur du plateau
     *
     * @param nbOuvriersExterieur
     */
    public void setNbOuvriersExterieur(int nbOuvriersExterieur) {
        this.nbOuvriersExterieur = nbOuvriersExterieur;
    }

    /**
     * setteur nb materiaux
     *
     * @param matEnPlus
     */
    public void setMateriaux(int matEnPlus) {
        this.materiaux = matEnPlus;
    }

    /**
     * setteur nb énergie
     *
     * @param energie
     */
    public void setEnergie(int energie) {
        this.energie = energie;
    }

    /**
     * getteur liste de bat sans doublons
     *
     * @return
     */
    public ArrayList<Batiment> getBatimentsSansDoublons() {
        return batimentsSansDoublons;
    }

    /**
     * getteur de la liste de batiment du plateau
     *
     * @return
     */
    public ArrayList<Batiment> getBatimentsDuPlateau() {
        return batimentDuPlateau;
    }

    /**
     * getteur des batiment de la liste des de la piles
     *
     * @return
     */
    public ArrayList<Batiment> getBatimentsPile() {
        return toutLesBatiments;
    }

    /**
     * ajouter un batiment dans la liste des batiment du plateau
     *
     * @param b
     */
    public void setListeBatPlateau(Batiment b) {
        batimentDuPlateau.add(b);
    }

    /**
     * auganter l'entier du tour
     */
    public void tourSuivant() {
        if (tourCourrant < nbToursMax) {
            tourCourrant++;
        }
    }

    /**
     * getteur du tour courrant
     *
     * @return
     */
    public int recupererTourCourrant() {
        return tourCourrant;
    }

    /**
     * getteur du score de la partie
     *
     * @return
     */
    public int getScorePartie() {
        scorePartie = (1 * materiaux) + (1 * energie) + (2 * nbOuvriersExterieur) + (4 * nbOuvriersPlateau) + (8 * batimentSurPlateau);
        return scorePartie;
    }

    /**
     * deplacer batiment de la liste de la main vers la liste du plateau
     *
     * @param nomBatiment
     */
    public void ajouterBatimentPlateau(String nomBatiment) {
        for (int i = 0; i < batimentsDeLaMain.size(); ++i) {
            Batiment b = batimentsDeLaMain.get(i);
            if (b.getNomBatiment().equals(nomBatiment)) {
                batimentDuPlateau.add(b);
                batimentsDeLaMain.remove(i);
                return;
            }
        }
        batimentSurPlateau += 1;
    }

    /**
     * methode qui génèr les batiments de la main
     */
    public void ajouterBatAleatMain() {
        int tailleListeToutLesBatiments = toutLesBatiments.size() - 1;
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            Batiment b = toutLesBatiments.remove(r.nextInt(tailleListeToutLesBatiments));
            batimentsDeLaMain.add(b);
            tailleListeToutLesBatiments -= 1;
        }
    }

    /**
     * getteur des ouvriers du plateau
     *
     * @return
     */
    public ArrayList<Ouvrier> getOuvriersPlateau() {
        return ouvriersPlateau;
    }

    /**
     * getteur des ouvriers qui sont à l'exterieur du plateau
     *
     * @return
     */
    public ArrayList<Ouvrier> getOuvriersExterieur() {
        return ouvriersExterieur;
    }

    /**
     * payer la pose d'un batiment
     *
     * @param prixBatiment
     */
    public void payerPourPoserBatiment(int prixBatiment) {
        materiaux -= prixBatiment;
    }

    /**
     * ajout de matériaux
     *
     * @param productionBat
     */
    public void produireMatériaux(int productionBat) {
        materiaux += productionBat;
    }

    /**
     * conso d'énergie
     *
     * @param consoNRJbat
     */
    public void consommerNRJ(int consoNRJbat) {
        energie -= consoNRJbat;
    }

    /**
     * production d'énergie
     *
     * @param prodNRJbat
     */
    public void produireNRJ(int prodNRJbat) {
        energie += prodNRJbat;
    }

    /**
     * vérifier si on a les materiaux nécessaire à la pose d'un batiment
     *
     * @param b
     * @return
     */
    public boolean verifierSiMaterielsNécessaire(Batiment b) {
        return b.getPrix() <= materiaux;
    }

    /**
     * getteur du tour courrant
     *
     * @return
     */
    public int getTourCourrant() {
        return tourCourrant;
    }

    /**
     * getteur du nombre ne matériaux
     *
     * @return
     */
    public int getMateriaux() {
        return materiaux;
    }

    /**
     * getteur du nombre de batiment dans la pile
     *
     * @return
     */
    public int getNbBatPile() {
        return nbBatimentPile = toutLesBatiments.size();
    }

    /**
     * ajouter ouvrier dans les ouvriers du plateau
     *
     * @param ouvrierAPlacer
     */
    public void ajouterOuvrierListePlateau(Ouvrier ouvrierAPlacer) {
        ouvriersPlateau.add(ouvrierAPlacer);
    }

    /**
     * enlever ouvrier de la liste d'ouvriers externe
     *
     * @param aEnlever
     */
    public void enleverOuvrierDeListeExtérieur(Ouvrier aEnlever) {
        ouvriersExterieur.remove(aEnlever);
    }

    public void enleverOuvrierDePlateau(Ouvrier aEnlever) {
        ouvriersPlateau.remove(aEnlever);
    }

    public void ajouterOuvrierExterieur(Ouvrier aAjouter) {
        ouvriersExterieur.add(aAjouter);
    }

    /**
     * placer un ouvrier dans la liste du plateau en l'enlevant de la liste des
     * ouvriers externes et retourner cet ouvrier
     *
     */
    public void placerOuvrierPlateauList() {
        if (ouvriersExterieur.size() > 0) {
            ouvriersPlateau.add(ouvriersExterieur.get(0));
            ouvriersExterieur.remove(0);
            nbOuvriersExterieur -= 1;
            nbOuvriersPlateau += 1;
        }
    }

    /**
     * envoyer un ouvrier en dehors du plateau si il n'est pas validé ou ne peut
     * pas faire son action
     *
     */
    public void placerOuvrierExterieurList() {
        ouvriersExterieur.add(ouvriersPlateau.get(0));
        ouvriersPlateau.remove(0);
        nbOuvriersExterieur += 1;
        nbOuvriersPlateau -= 1;
    }

    /**
     * envoyer un ouvrier en dehors du plateau si il n'est pas validé ou ne peut
     * pas faire son action
     *
     */
    public void placerOuvrierExterieurList(Ouvrier o) {
        ouvriersExterieur.add(o);
        ouvriersPlateau.remove(o);
        nbOuvriersExterieur += 1;
        nbOuvriersPlateau -= 1;
    }
    
    /**
     * effectuer la suppression d'un batiment et l'ajout d'un batiment
     * dans les 2 listes
     * @param b 
     */
    public void OblockAction(Batiment b){
        batimentsDeLaMain.remove(b);
        toutLesBatiments.add(toutLesBatiments.size(), b);
        batimentsDeLaMain.add(toutLesBatiments.get(0));
        toutLesBatiments.remove(toutLesBatiments.get(0));
    }

    /**
     * modifier liste de l'ouvrier et recupérer l'ouvrier à dessiner
     *
     * @return
     */
    public Ouvrier ouvrierAplacerDansLePlateau() {
        aAjtPlateau = ouvriersExterieur.get(0);
        return aAjtPlateau;
    }

    /**
     * setteur du nombre d'ouvriers à l'extérieur du plateau
     *
     * @param i
     */
    public void ajouterOuvrierExtérieur(int i) {
        nbOuvriersExterieur += i;
    }

    public void ajouterOuvrierPlateau() {
        nbOuvriersExterieur -= 1;
        nbOuvriersPlateau += 1;
    }

     /*public void sauvegarderLaPartie() throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream("savePartie.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(toutLesBatiments);
            out.writeObject(batimentDuPlateau);
            out.writeObject(batimentsSansDoublons);
            out.writeObject(batimentsDeLaMain);
            out.writeObject(ouvriersExterieur);
            out.writeObject(ouvriersPlateau);
            out.write(batimentSurPlateau);
            out.write(energie);
            out.write(materiaux);
            out.write(nbBatimentPile);
            out.write(nbOuvriersExterieur);
            out.write(nbOuvriersPlateau);
            out.write(scorePartie);
            out.write(tourCourrant);
            out.close();
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
