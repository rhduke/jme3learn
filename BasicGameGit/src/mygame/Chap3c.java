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

//    private void makeCubes(int number) {
//        for (int i = 0; i < number; i++) {
//            Vector3f loc = new Vector3f(
//                    FastMath.nextRandomInt(-20, 20),
//                    FastMath.nextRandomInt(-20, 20),
//                    FastMath.nextRandomInt(-20, 20));
//            Geometry geom = myCube("Cube" + i, loc, ColorRGBA.randomColor());
//            if (FastMath.nextRandomInt(1, 4) == 4) {
//                geom.addControl(new CubeChaserControl(cam, rootNode));
//            }
//            rootNode.attachChild(geom);
//        }
//    }
//    
//    private Geometry myCube(String name, Vector3f loc, ColorRGBA color) {
//        Geometry geom = new Geometry(name, mesh);
//        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
//        mat.setColor("Color", color);
//        geom.setMaterial(mat);
//        geom.setLocalTranslation(loc);
//        return geom;
//    }
    
    @Override
    public void simpleUpdate(float tpf) {
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
