/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.input.*;
import com.jme3.input.controls.*;
import com.jme3.system.AppSettings;

/**
 *
 * @author Ronald
 */
public class Chap3 extends SimpleApplication {
    
    private final static Trigger TRIGGER_COLOR = new KeyTrigger(KeyInput.KEY_SPACE);
    private final static Trigger TRIGGER_COLOR2 = new KeyTrigger(KeyInput.KEY_C);
    private final static Trigger TRIGGER_ROTATE = new MouseButtonTrigger(MouseInput.BUTTON_LEFT);
    
    private final static String MAPPING_COLOR = "Toggle Color";
    private final static String MAPPING_ROTATE = "Rotate";
    
    private static AppSettings set = new AppSettings(true);
    
    private Geometry geom;
    
    public static void main(String[] args) {
        set.setRenderer(AppSettings.LWJGL_OPENGL1);
        Chap3 app = new Chap3();
        app.setSettings(set);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        inputManager.addMapping(MAPPING_COLOR, TRIGGER_COLOR, TRIGGER_COLOR2);
        inputManager.addMapping(MAPPING_ROTATE, TRIGGER_ROTATE);
        
        inputManager.addListener(actionListener, new String[]{MAPPING_COLOR});
        inputManager.addListener(analogListener, new String[]{MAPPING_ROTATE});
        
        Box b = new Box(1, 1, 1);
        geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);
    }

    private ActionListener actionListener = new ActionListener() {
        public void onAction(String name, boolean isPressed, float tpf) {
            if (name.equals(MAPPING_COLOR) && !isPressed) {
                //System.out.println("You triggered: " + name);
                geom.getMaterial().setColor("Color", ColorRGBA.randomColor());
            }
            
        }
    };
    
    private AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String name, float intensity, float tpf) {
            if (name.equals(MAPPING_ROTATE)) {
                //System.out.println("You triggered: " + name);
                geom.rotate(0, intensity, 0);
            }
            
        }
    };
    
    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
