/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marsstation;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tibur
 */
public class Scene {
    private int availableScrewdrivers = 3;
    private int availableHammers = 3;
    private int availablePieces = 100;
    
    synchronized public void takeScrewdriver(int idRobot){
        while(this.availableScrewdrivers == 0){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.availableScrewdrivers--;
        System.out.println("Robot " + idRobot + " took a screwdriver. there are " + availableScrewdrivers + " available.");
    }
    
    synchronized public void takePieceAndAssembleIt(int idRobot){
        if(this.availablePieces > 0) {
            this.availablePieces--;
            int numPieza = this.availablePieces + 1;
            assemblePiece(idRobot, numPieza);
        }
    }
    
    synchronized public void takeHammer(int idRobot){
        while(this.availableHammers == 0){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.availableHammers--;
        System.out.println("Robot " + idRobot + " took a hammer. there are " + availableHammers + " available.");
    }
    
    private void assemblePiece(int idRobot, int numPieza){
        System.out.println("Robot " + idRobot + " assembled piece " + numPieza + ". " + availablePieces + " left.");
    }
    
    synchronized public boolean availablePieces(int idRobot){
        if(availablePieces <= 0) {
            return false;
        }
        return true;
    }
    
    synchronized public void releaseHammer(int idRobot){
        availableHammers++;
        System.out.println("Robot " + idRobot + " released a hammer. there are " + availableHammers + " available.");
        notifyAll();
    }
    
    synchronized public void releaseScrewdriver(int idRobot){
        
        availableScrewdrivers++;
        System.out.println("Robot " + idRobot + " released a screwdriver. there are " + availableScrewdrivers + " available.");
        notifyAll();
    }
}
