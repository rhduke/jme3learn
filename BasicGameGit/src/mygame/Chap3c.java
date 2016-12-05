package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.collision.CollisionResults;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Ray;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * test
 * @author normenhansen
 */
public class Chap3c extends SimpleApplication {
     
    public static void main(String[] args) {
        Chap3c app = new Chap3c();       
        app.start();
    }

    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(70f);
        CubeChaserState state = new CubeChaserState();
        stateManager.attach(state);
        
    }
    
    @Override
    public void simpleUpdate(float tpf) {
        System.out.println("Chase counter: " + stateManager.getState(CubeChaserState.class).getCounter());
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
