/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marsstation;

/**
 *
 * @author tibur
 */
public class Robot extends Thread {
    private int idRobot;
    private Scene scene;

    public Robot(int idRobot, Scene scene) {
        this.idRobot = idRobot;
        this.scene = scene;
    }
    
    @Override
    public void run() {
        int numPieza;
        do{
            scene.takeScrewdriver(idRobot);
            scene.takeHammer(idRobot);
            scene.takePieceAndAssembleIt(idRobot);
            yield();
            scene.releaseHammer(idRobot);
            scene.releaseScrewdriver(idRobot);
            yield();
        }while(scene.availablePieces(idRobot));
    }
    
    
}
