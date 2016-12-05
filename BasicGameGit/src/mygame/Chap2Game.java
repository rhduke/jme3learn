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
public class Chap2Game extends SimpleApplication{
    
    static AppSettings set = new AppSettings(true);
    
    public static void main(String[] args) {
        set.setSettingsDialogImage("Interface/gorilla.jpg");
        Chap2Game game = new Chap2Game();
        game.setSettings(set);
        game.start();
    }
    
    @Override
    public void simpleInitApp() {
        Node playerNode = new Node("player node");
        Node towerNode = new Node("tower node");
        Node creepNode = new Node("creep node");
        
        Geometry playerGeo1 = createBase(new Vector3f(0.0f, 1.0f, 10.0f));
        Geometry towerGeo1 = createTower(new Vector3f(10.0f, 1.0f, 10.0f));
        Geometry towerGeo2 = createTower(new Vector3f(-10.0f, 1.0f, 10.0f));
        Geometry creepGeo1 = createCreep(new Vector3f(0.0f, 1.0f, -10.0f));
        Geometry creepGeo2 = createCreep(new Vector3f(5.0f, 1.0f, -4.0f));
        Geometry creepGeo3 = createCreep(new Vector3f(-8.0f, 1.0f, -8.0f));
        
        float r = FastMath.DEG_TO_RAD * 90f;
        
        Box b = new Box(33, 1, 33);
        
        Geometry floor = new Geometry("Box", b);
        Material floormat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        
        
        floormat.setColor("Color", ColorRGBA.Orange);
        floor.setMaterial(floormat);
        playerNode.attachChild(playerGeo1);
        towerNode.attachChild(towerGeo1);
        towerNode.attachChild(towerGeo2);
        creepNode.attachChild(creepGeo1);
        creepNode.attachChild(creepGeo2);
        creepNode.attachChild(creepGeo3);
        rootNode.attachChild(playerNode);
        rootNode.attachChild(towerNode);
        rootNode.attachChild(creepNode);
        rootNode.attachChild(floor);
        cam.setRotation((new Quaternion()).fromAngleAxis(r, Vector3f.UNIT_X));
        cam.setLocation(new Vector3f(0.0f, 40.0f, 0.0f));
        flyCam.setMoveSpeed(50);
        //setDisplayFps(false);
        //setDisplayStatView(false);
    }
    
    public Geometry createBase(Vector3f v) {
        Box b = new Box(5, 3, 3);
        Geometry base = new Geometry("Box", b);
        Material basemat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        basemat.setColor("Color", ColorRGBA.Yellow);
        base.setMaterial(basemat);
        base.setLocalTranslation(v);
        return base;
    }
    
    public Geometry createTower(Vector3f v) {
        Box b = new Box(2, 3, 2);
        Geometry tower = new Geometry("Box", b);
        Material basemat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        basemat.setColor("Color", ColorRGBA.Green);
        tower.setMaterial(basemat);
        tower.setLocalTranslation(v);
        return tower;
    }
    
    public Geometry createCreep(Vector3f v) {
        Box b = new Box(1, 1, 1);
        Geometry creep = new Geometry("Box", b);
        Material basemat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        basemat.setColor("Color", ColorRGBA.Black);
        creep.setMaterial(basemat);
        creep.setLocalTranslation(v);
        return creep;
    }
    
    @Override
    public void simpleUpdate(float tpf) {
        
    }
    
    @Override
    public void simpleRender(RenderManager rm) {
        
    }
}
