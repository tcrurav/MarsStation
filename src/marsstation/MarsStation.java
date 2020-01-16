/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marsstation;

import java.util.ArrayList;

/**
 *
 * @author tibur
 */
public class MarsStation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scene scene = new Scene();
        ArrayList<Robot> robots = new ArrayList<Robot>();
        
        for (int i = 0; i < 10; i++) {
            robots.add(new Robot(i, scene));
        }
        
        for (int i = 0; i < 10; i++) {
            robots.get(i).start();
        }
    }
    
}
