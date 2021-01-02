/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PlateauDeJeu;

import buildings.data.Batiment;
import buildings.data.IBatiment;
import buildings.data.JBatiment;
import buildings.data.LBatiment;
import buildings.data.OBatiment;
import buildings.data.Case;
import buildings.data.SBatiment;
import buildings.data.TBatiment;
import buildings.data.ZBatiment;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import javafx.scene.shape.Rectangle;
import javafx.scene.canvas.GraphicsContext;

import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collection;
import javafx.scene.canvas.Canvas;
import java.util.HashMap;

/**
 *
 * @author isoyturk
 */
public class Plateau {

    private int nbColonnes = 10;
    private int nbLignes = 20;
    private String[][] plateauDeJeu = new String[nbColonnes][nbLignes];
    private ArrayList<Case[]> mesBatiments;
    private Case[] batimentActuel;

    public Plateau() {
        this.mesBatiments = new ArrayList();
        for (int i = 0; i < nbColonnes; i++) {
            for (int j = 0; j < nbLignes; j++) {
                plateauDeJeu[i][j] = "n";
            }
        }
    }

    public void setCellule(int i, int j, String bat) {
        plateauDeJeu[i][j] = bat;
    }

    public void dessinerPlateau(Canvas can) {
        for (int i = 0; i < nbColonnes; i++) {
            for (int j = 0; j < nbLignes; j++) {
                Cellule c = new Cellule();
                switch (plateauDeJeu[i][j]) {
                    case "i":
                        c.dessinerCellule(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.LIME);
                        break;
                    case "j":
                        c.dessinerCellule(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.DARKORCHID);
                        break;
                    case "l":
                        c.dessinerCellule(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.CRIMSON);
                        break;
                    case "o":
                        c.dessinerCellule(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.YELLOWGREEN);
                        break;
                    case "s":
                        c.dessinerCellule(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.DARKTURQUOISE);
                        break;
                    case "t":
                        c.dessinerCellule(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.CORAL);
                        break;
                    case "z":
                        c.dessinerCellule(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.AQUAMARINE);
                        break;
                    case "n":
                        c.dessinerCellule(can, (c.recupTailleCote() + 1) * i, (c.recupTailleCote() + 1) * j, Color.BLACK, Color.GREY);
                        break;

                }
            }
        }
    }

    public void placerBatimentDansTableauDePlateau(Batiment b, Case[] batimentCases) {
        batimentActuel = batimentCases;
        placerBatimentDeLaHashMapDansPlateau(charBatiment(b));
    }

    public void placerBatimentDeLaHashMapDansPlateau(String charBatiment) {
        for (int i = 0; i < nbColonnes; ++i) {
            for (int j = 0; j < nbLignes; ++j) {
                plateauDeJeu[i][j] = "n";
            }
        }

        mesBatiments.forEach(cases -> placerCasesDansTableau(cases));
        if (batimentActuel != null) {
            placerCasesDansTableau(batimentActuel);
        }
    }

    public void placerCasesDansTableau(Case[] cases) {
        for (Case c : cases) {
            plateauDeJeu[c.getX()][c.getY()] = c.getBatimentChaineChar();
        }
    }

    public boolean validerBatiment() {

        for (Case c1 : batimentActuel) {
            for (Case[] cases : mesBatiments) {
                for (Case c2 : cases) {
                    if (c1.collision(c2)) {
                        return false;
                    }
                }
            }
        }
        mesBatiments.add(batimentActuel);
        batimentActuel = null;
        return true;
    }

    public String charBatiment(Batiment b) {
        String charBat = null;
        switch (b.getNomBatiment()) {
            case "I-Batiment":
                IBatiment i = (IBatiment) b;
                charBat = i.getStrBatiment();
                break;
            case "J-Batiment":
                JBatiment j = (JBatiment) b;
                charBat = j.getStrBatiment();
                break;
            case "L-Batiment":
                LBatiment l = (LBatiment) b;
                charBat = l.getStrBatiment();
                break;
            case "O-Batiment":
                OBatiment o = (OBatiment) b;
                charBat = o.getStrBatiment();
                break;
            case "S-Batiment":
                SBatiment s = (SBatiment) b;
                charBat = s.getStrBatiment();
                break;
            case "T-Batiment":
                TBatiment t = (TBatiment) b;
                charBat = t.getStrBatiment();
                break;
            case "Z-Batiment":
                ZBatiment z = (ZBatiment) b;
                charBat = z.getStrBatiment();
                break;
        }
        return charBat;
    }

    public String[][] getPlateauDeJeu() {
        return plateauDeJeu;
    }

    public int getNbColonnes() {
        return nbColonnes;
    }

    public int getNbLignes() {
        return nbLignes;
    }

}
