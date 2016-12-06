/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.renderer.RenderManager;
import com.jme3.app.SettingsDialog;
import com.jme3.system.AppSettings;
import com.jme3.scene.Geometry;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.scene.shape.Box;
import com.jme3.scene.Node;
import com.jme3.math.Vector3f;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;

/**
 *
 * @author Ron
 */
public class Chap3Game extends SimpleApplication{
    
    //static AppSettings set = new AppSettings(true);
    
    public static void main(String[] args) {
        //set.setSettingsDialogImage("Interface/gorilla.jpg");
        //set.setRenderer(AppSettings.LWJGL_OPENGL1);             
        Chap3Game game = new Chap3Game();
        //game.setSettings(set);
        game.start();
    }
    
    @Override
    public void simpleInitApp() {
        Chap3GameState state = new Chap3GameState();
        stateManager.attach(state);
    }
    
    @Override
    public void simpleUpdate(float tpf) {
        
    }
    
    @Override
    public void simpleRender(RenderManager rm) {
        
    }
}
