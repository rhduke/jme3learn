/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.*;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.input.*;
import com.jme3.input.controls.*;
import com.jme3.system.AppSettings;
import com.jme3.collision.*;

/**
 *
 * @author Ronald
 */
public class Chap3a extends SimpleApplication {
    
    private final static Trigger TRIGGER_COLOR = new KeyTrigger(KeyInput.KEY_SPACE);
    private final static Trigger TRIGGER_COLOR2 = new KeyTrigger(KeyInput.KEY_C);
    private final static Trigger TRIGGER_ROTATE = new MouseButtonTrigger(MouseInput.BUTTON_LEFT);
    
    private final static String MAPPING_COLOR = "Toggle Color";
    private final static String MAPPING_ROTATE = "Rotate";
    
    private static AppSettings set = new AppSettings(true);
    
    private static Box mesh = new Box(1, 1, 1);
    
    public static void main(String[] args) {
        set.setRenderer(AppSettings.LWJGL_OPENGL1);
        Chap3a app = new Chap3a();
        app.setSettings(set);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        inputManager.addMapping(MAPPING_COLOR, TRIGGER_COLOR, TRIGGER_COLOR2);
        inputManager.addMapping(MAPPING_ROTATE, TRIGGER_ROTATE);
        
        inputManager.addListener(actionListener, new String[]{MAPPING_COLOR});
        inputManager.addListener(analogListener, new String[]{MAPPING_ROTATE});
        
        rootNode.attachChild(myCube("Red Cube", new Vector3f(0, 1.5f, 0), ColorRGBA.Red));
        rootNode.attachChild(myCube("Blue Cube", new Vector3f(0, -1.5f, 0), ColorRGBA.Blue));
        attachCenterMark();
    }

    private ActionListener actionListener = new ActionListener() {
        public void onAction(String name, boolean isPressed, float tpf) {
            if (name.equals(MAPPING_COLOR) && !isPressed) {
                //System.out.println("You triggered: " + name);
                //geom.getMaterial().setColor("Color", ColorRGBA.randomColor());
            }
            
        }
    };
    
    private AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String name, float intensity, float tpf) {
            if (name.equals(MAPPING_ROTATE)) {
                CollisionResults results = new CollisionResults();
                Ray ray = new Ray(cam.getLocation(), cam.getDirection());
                rootNode.collideWith(ray, results);
                for (int i = 0; i < results.size(); i ++) {
                    float dist = results.getCollision(i).getDistance();
                    Vector3f pt = results.getCollision(i).getContactPoint();
                    String target = results.getCollision(i).getGeometry().getName();
                    System.out.println("Selection L #" + i + ": " + target + " at "
                            + pt + ", " + dist + " WU away.");
                }
                if (results.size() > 0) {
                    Geometry target = results.getClosestCollision().getGeometry();
                    if (target.getName().equals("Red Cube"))
                        target.rotate(0, -intensity, 0);
                    else if (target.getName().equals("Blue Cube"))
                        target.rotate(0, intensity, 0);
                        
                } else {
                    System.out.println("Selection: Nothing");
                }
            }
            
        }
    };
    
    private Geometry myCube(String name, Vector3f loc, ColorRGBA color) {
        Geometry geom = new Geometry(name, mesh);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        geom.setMaterial(mat);
        geom.setLocalTranslation(loc);
        return geom;
    }
    
    private void attachCenterMark() {
        Geometry c = myCube("center mark", Vector3f.ZERO, ColorRGBA.White);
        c.scale(4);
        c.setLocalTranslation(settings.getWidth()/2, settings.getHeight()/2, 0);
        guiNode.attachChild(c);
    }
    
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
