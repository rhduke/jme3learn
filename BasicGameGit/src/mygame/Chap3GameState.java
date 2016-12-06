/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.*;
import com.jme3.asset.AssetManager;
import com.jme3.input.FlyByCamera;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;

/**
 *
 * @author Ronald
 */
public class Chap3GameState extends AbstractAppState {
    
    static final String DATAINDEX_HP = "hp";
    static final String DATAINDEX_CHARGES = "charges";
    static final int START_CHARGES = 5;
    static final int CREEP_HP = 25;
    
    private SimpleApplication app;
    private AssetManager assetManager;
    private Camera cam;
    private FlyByCamera flyCam;
    private Node rootNode;
    private Node playerNode;
    private Node towerNode;
    private Node creepNode;
    private Node floorNode;
    
    private int level;
    private boolean lastGameWon;
    private int baseHP;
    private int budget; 
    private int score;
    
    @Override
    public void update(float tpf) {
        
    }
    
    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        //setDisplayFps(false);
        //setDisplayStatView(false);
        float r = FastMath.DEG_TO_RAD * 90f;
        
        this.app = (SimpleApplication) app;
        this.cam = this.app.getCamera();
        this.flyCam = this.app.getFlyByCamera();
        this.assetManager = app.getAssetManager();
        this.rootNode = this.app.getRootNode();     
        this.playerNode = new Node("player node");
        this.towerNode = new Node("tower node");
        this.creepNode = new Node("creep node");
        this.floorNode = new Node("floor node");
        
        spawnCreeps(5);
        createTowers();
        createBase(new Vector3f(0.0f, 1.0f, 10.0f));
        createFloor();
        rootNode.attachChild(creepNode);
        rootNode.attachChild(playerNode);
        rootNode.attachChild(towerNode);
        rootNode.attachChild(creepNode);
        rootNode.attachChild(floorNode);
        
        cam.setRotation((new Quaternion()).fromAngleAxis(r, Vector3f.UNIT_X));
        cam.setLocation(new Vector3f(0.0f, 40.0f, 0.0f));
        flyCam.setMoveSpeed(50);
    }
    
    @Override
    public void cleanup() {
        rootNode.detachChild(floorNode);
        rootNode.detachChild(towerNode);
        rootNode.detachChild(creepNode);
        rootNode.detachChild(playerNode);
                
        
    }
    
    public void spawnCreeps(int number) {
        for (int i = 0; i < number; i++) {
            Vector3f loc = new Vector3f(FastMath.nextRandomInt(-10,10), 1, FastMath.nextRandomInt(-10,-5));
            Geometry creep = createCreep(loc);
            creep.addControl(new Chap3CreepControl(this));
            creepNode.attachChild(creep);                  
        }
    }
    
    public void createTowers() {
        Geometry towerGeo1 = createTower(new Vector3f(10.0f, 1.0f, 10.0f));
        Geometry towerGeo2 = createTower(new Vector3f(-10.0f, 1.0f, 10.0f));
        
        towerNode.attachChild(towerGeo1);
        towerNode.attachChild(towerGeo2);
    }
    
    public void createBase(Vector3f v) {
        Box b = new Box(5, 3, 3);
        Geometry base = new Geometry("Box", b);
        Material basemat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        basemat.setColor("Color", ColorRGBA.Yellow);
        base.setMaterial(basemat);
        base.setLocalTranslation(v);
        playerNode.attachChild(base);
    }
    
    public void createFloor() {
        Box b = new Box(33, 1, 33);       
        Geometry floor = new Geometry("Box", b);
        Material floormat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");       
        floormat.setColor("Color", ColorRGBA.Orange);
        floor.setMaterial(floormat);
        floorNode.attachChild(floor);
    }
    
    public Geometry createTower(Vector3f v) {
        Box b = new Box(2, 3, 2);
        Geometry tower = new Geometry("Box", b);
        Material basemat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        
        basemat.setColor("Color", ColorRGBA.Green);
        tower.setMaterial(basemat);
        tower.setLocalTranslation(v);
        tower.setUserData(DATAINDEX_CHARGES, START_CHARGES);
        return tower;
    }
    
    public Geometry createCreep(Vector3f v) {
        Box b = new Box(1, 1, 1);
        Geometry creep = new Geometry("Box", b);
        Material basemat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");       
        basemat.setColor("Color", ColorRGBA.Black);
        creep.setMaterial(basemat);
        creep.setLocalTranslation(v);
        creep.setUserData(DATAINDEX_HP, CREEP_HP);
        return creep;
    }
    
    public int getLevel() { return level; }
    
    public int getScore() { return score; }
    
    public int getBudget() { return budget; }
    
    public int getHP() { return baseHP; }
    
    public boolean lastGameWon() { return lastGameWon; }
} 
