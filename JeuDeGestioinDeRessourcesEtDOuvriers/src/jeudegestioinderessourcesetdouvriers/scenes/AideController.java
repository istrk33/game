/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudegestioinderessourcesetdouvriers.scenes;

import buildings.data.Batiment;
import buildings.data.IBatiment;
import buildings.data.JBatiment;
import buildings.data.LBatiment;
import buildings.data.OBatiment;
import buildings.data.SBatiment;
import buildings.data.TBatiment;
import buildings.data.ZBatiment;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

/**
 * FXML Controller class
 *
 * @author isoyturk
 */
public class AideController {

    @FXML
    private Canvas dessinerIBlock;
    @FXML
    private Canvas dessinerOBlock;
    @FXML
    private Canvas dessinerTBlock;
    @FXML
    private Canvas dessinerLBlock;
    @FXML
    private Canvas dessinerJBLock;
    @FXML
    private Canvas dessinerSBlock;
    @FXML
    private Canvas dessinerZBlock;

    /**
     * dessiner les batiment dans la vue d'aide
     * @param logique 
     */
    public void dessinerBatimentsDansLaMain(gameLogic.GameLogic logique) {
        int posX = 15;
        int posY = 15;

        for (Batiment b : logique.getBatimentsSansDoublons()) {
            switch (b.getNomBatiment()) {
                case "I-Batiment":
                    IBatiment i = (IBatiment) b;
                    i.dessinerBatiment(dessinerIBlock, posX-10, posY+10);
                    break;
                case "J-Batiment":
                    JBatiment j = (JBatiment) b;
                    j.dessinerBatiment(dessinerJBLock, posX+10, posY-5);
                    break;
                case "L-Batiment":
                    LBatiment l = (LBatiment) b;
                    l.dessinerBatiment(dessinerLBlock, posX+10, posY+15);
                    break;
                case "O-Batiment":
                    OBatiment o = (OBatiment) b;
                    o.dessinerBatiment(dessinerOBlock, posX+10, posY);
                    break;
                case "S-Batiment":
                    SBatiment s = (SBatiment) b;
                    s.dessinerBatiment(dessinerSBlock, posX, posY);
                    break;
                case "T-Batiment":
                    TBatiment t = (TBatiment) b;
                    t.dessinerBatiment(dessinerTBlock, posX, posY);
                    break;
                case "Z-Batiment":
                    ZBatiment z = (ZBatiment) b;
                    z.dessinerBatiment(dessinerZBlock, posX, posY);
                    break;
            }
        }
    }

}
